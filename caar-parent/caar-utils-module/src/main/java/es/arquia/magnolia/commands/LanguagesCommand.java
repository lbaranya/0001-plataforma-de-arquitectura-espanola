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
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.module.categorization.CategorizationModule;
import info.magnolia.module.categorization.CategorizationNodeTypes;

public class LanguagesCommand {
	
private static final Logger log = LoggerFactory.getLogger(CountryCommand.class);
	
	private Locale userLocale;
	
	private Locale englishLocale;
	private Locale spanishLocale;

	public LanguagesCommand() {
		userLocale = MgnlContext.getLocale();
		englishLocale = new Locale("en");
		spanishLocale = new Locale("es");
	}
	
	public boolean execute() throws Exception {
		Locale[] allLanguages = DateFormat.getAvailableLocales();
		List<String> allLanguagesNames = new ArrayList<>();
		for(int i=0; i<allLanguages.length; ++i) {
			allLanguagesNames.add(allLanguages[i].getDisplayLanguage(userLocale));
			System.out.println(allLanguages[i].getDisplayLanguage(spanishLocale));
		}
		
		Session session = MgnlContext.getJCRSession(CategorizationModule.CATEGORIZATION_WORKSPACE);
		Node caarCategoryRootNode = null;
		Node subFolderCountriesNode = null;
		if (!session.getRootNode().hasNode(caarRootFolderName) || !session.getRootNode().getNode(caarRootFolderName).hasNode(caarLanguagesFolderName)) {
			if (!session.getRootNode().hasNode(caarRootFolderName)) {
				caarCategoryRootNode = session.getRootNode().addNode(caarRootFolderName, NodeTypes.Folder.NAME);
			}else {
				caarCategoryRootNode = session.getRootNode().getNode(caarRootFolderName);
			}
			if (!caarCategoryRootNode.hasNode(caarLanguagesFolderName)) {
				subFolderCountriesNode = caarCategoryRootNode.addNode(caarLanguagesFolderName, NodeTypes.Folder.NAME);
			}

			if (subFolderCountriesNode != null && !subFolderCountriesNode.hasNodes()) {
				for (int i = 0; i < allLanguagesNames.size(); ++i) {
					if(!StringUtils.isBlank(allLanguagesNames.get(i))) {
						try {
							Node categoryNode = subFolderCountriesNode.addNode(allLanguagesNames.get(i).toLowerCase(), CategorizationNodeTypes.Category.NAME);
							categoryNode.setProperty("name", allLanguagesNames.get(i).toLowerCase());
							categoryNode.setProperty("displayName", allLanguages[i].getDisplayName(spanishLocale).toUpperCase().replaceAll("\\s\\(.+?\\)", ""));
							categoryNode.setProperty("displayName_en", allLanguages[i].getDisplayName(englishLocale).toUpperCase().replaceAll("\\s\\(.+?\\)", ""));
							categoryNode.getSession().save();
						}catch(RepositoryException e) {
							// Next language
						}
					}
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
					if(!StringUtils.isBlank(allLanguagesNames.get(i))) {
						try {
							Node categoryNode = subFolderCountriesNode.addNode(allLanguagesNames.get(i).toLowerCase(), CategorizationNodeTypes.Category.NAME);
							categoryNode.setProperty("name", allLanguagesNames.get(i).toLowerCase());
							categoryNode.setProperty("displayName", allLanguages[i].getDisplayName(spanishLocale).toUpperCase().replaceAll("\\s\\(.+?\\)", ""));
							categoryNode.setProperty("displayName_en", allLanguages[i].getDisplayName(englishLocale).toUpperCase().replaceAll("\\s\\(.+?\\)", ""));
							categoryNode.getSession().save();
						}catch(RepositoryException e) {
							// If exists a node with the same JCR name, skipped it!
						}
					}
				}
			}
			
			log.debug("Rename old node \"caar-languages\" to \"caar-languages-old\", and rename \"caar-languages-tmp\" to \"caar-languages\"...");
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
