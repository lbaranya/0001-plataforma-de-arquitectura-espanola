package es.arquia.magnolia.commands;

import static es.arquia.magnolia.constants.UtilsConstants.caarLanguagesFolderName;
import static es.arquia.magnolia.constants.UtilsConstants.caarLanguagesOldFolderName;
import static es.arquia.magnolia.constants.UtilsConstants.caarRootFolderName;
import static es.arquia.magnolia.constants.UtilsConstants.tmpCaarLanguagesFolderName;

import java.text.Collator;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.jcr.Node;
import javax.jcr.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.module.categorization.CategorizationModule;
import info.magnolia.module.categorization.CategorizationNodeTypes;

public class LanguagesCommand {
	
private static final Logger log = LoggerFactory.getLogger(CountryCommand.class);
	
	private Locale userLocale;

	public LanguagesCommand() {
		userLocale = MgnlContext.getLocale();
	}
	
	public boolean execute() throws Exception {
		Locale[] allLanguages = DateFormat.getAvailableLocales();
		List<String> allLanguagesNames = new ArrayList<>();
		for(int i=0; i<allLanguages.length; ++i) {
			allLanguagesNames.add(userLocale.getDisplayLanguage(allLanguages[i]));
		}
		
		// Ordenar ignorando caracteres especiales, como acentos
		Collator coll = Collator.getInstance(userLocale);
		coll.setStrength(Collator.PRIMARY);
		Collections.sort(allLanguagesNames, coll);
		
		Session session = MgnlContext.getJCRSession(CategorizationModule.CATEGORIZATION_WORKSPACE);
		Node caarCategoryRootNode = null;
		Node subFolderCountriesNode = null;
		if (!session.getRootNode().hasNode(caarRootFolderName)) {

			caarCategoryRootNode = session.getRootNode().addNode(caarRootFolderName, NodeTypes.Folder.NAME);
			if (!caarCategoryRootNode.hasNode(caarLanguagesFolderName)) {
				subFolderCountriesNode = caarCategoryRootNode.addNode(caarLanguagesFolderName, NodeTypes.Folder.NAME);
			}

			if (subFolderCountriesNode != null && !subFolderCountriesNode.hasNodes()) {
				for (int i = 0; i < allLanguagesNames.size(); ++i) {
					subFolderCountriesNode.addNode(allLanguagesNames.get(i), CategorizationNodeTypes.Category.NAME);
				}
			}

		} else {
			log.debug("Exists node \"caar\", creating node \"caar-languages-tmp\"...");
			caarCategoryRootNode = session.getRootNode().getNode(caarRootFolderName);
			if (!caarCategoryRootNode.hasNode(tmpCaarLanguagesFolderName)) {
				log.debug("Creating \"caar-languages-tmp\" node...");
				subFolderCountriesNode = caarCategoryRootNode.addNode(tmpCaarLanguagesFolderName, NodeTypes.Folder.NAME);
			}
			if (subFolderCountriesNode != null && !subFolderCountriesNode.hasNodes()) {
				for (int i = 0; i < allLanguagesNames.size(); ++i) {
					subFolderCountriesNode.addNode(allLanguagesNames.get(i), CategorizationNodeTypes.Category.NAME);
				}
			}
			
			log.debug("Rename old node \"caar-countries\" to \"caar-languages-old\", and rename \"caar-languages-tmp\" to \"caar-languages\"...");
			Node oldNode = session.getRootNode().getNode(caarRootFolderName).getNode(caarLanguagesFolderName);
			Node newNode = session.getRootNode().getNode(caarRootFolderName).getNode(tmpCaarLanguagesFolderName);
			oldNode.getSession().move(oldNode.getPath(), oldNode.getParent().getPath() + "/" + caarLanguagesOldFolderName);
			newNode.getSession().move(newNode.getPath(), newNode.getParent().getPath() + "/" + caarLanguagesFolderName);
			
			log.debug("Remove old node renamed to \"caar-languages-old\"...");
			oldNode.remove();
		}
		if (caarCategoryRootNode != null)
			caarCategoryRootNode.getSession().save();
		if (subFolderCountriesNode != null)
			subFolderCountriesNode.getSession().save();
		return false;
	}

}
