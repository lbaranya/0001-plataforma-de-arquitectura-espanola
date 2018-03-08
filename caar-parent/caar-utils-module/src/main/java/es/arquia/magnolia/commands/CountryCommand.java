package es.arquia.magnolia.commands;

import static es.arquia.magnolia.constants.UtilsConstants.caarCountriesFolderName;
import static es.arquia.magnolia.constants.UtilsConstants.caarCountriesOldFolderName;
import static es.arquia.magnolia.constants.UtilsConstants.caarLanguagesFolderName;
import static es.arquia.magnolia.constants.UtilsConstants.caarRootFolderName;
import static es.arquia.magnolia.constants.UtilsConstants.tmpCaarCountiesFolderName;

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

public class CountryCommand {

	private static final Logger log = LoggerFactory.getLogger(CountryCommand.class);
	
	private Locale userLocale;

	private Locale englishLocale;
	private Locale spanishLocale;

	public CountryCommand() {
		userLocale = MgnlContext.getLocale();
		englishLocale = new Locale("en");
		spanishLocale = new Locale("es");
	}

	public boolean execute() throws Exception {
		
		String[] locales = Locale.getISOCountries();
		Locale[] allCountries = new Locale[locales.length];
		List<String> countryNames = new ArrayList<>();
		int index = 0;
		for (String countryCode : locales) {
			Locale obj2 = new Locale(userLocale.getLanguage(), countryCode);
			allCountries[index] = obj2;
			countryNames.add(obj2.getDisplayCountry(userLocale));
			++index;
		}

		Session session = MgnlContext.getJCRSession(CategorizationModule.CATEGORIZATION_WORKSPACE);
		Node caarCategoryRootNode = null;
		Node subFolderCountriesNode = null;
		if (!session.getRootNode().hasNode(caarRootFolderName) || !session.getRootNode().getNode(caarRootFolderName).hasNode(caarCountriesFolderName)) {
			if (!session.getRootNode().hasNode(caarRootFolderName)) {
				caarCategoryRootNode = session.getRootNode().addNode(caarRootFolderName, NodeTypes.Folder.NAME);
			}else {
				caarCategoryRootNode = session.getRootNode().getNode(caarRootFolderName);
			}
			if (!caarCategoryRootNode.hasNode(caarCountriesFolderName)) {
				subFolderCountriesNode = caarCategoryRootNode.addNode(caarCountriesFolderName, NodeTypes.Folder.NAME);
			}

			if (subFolderCountriesNode != null && !subFolderCountriesNode.hasNodes()) {
				for (int i = 0; i < countryNames.size(); ++i) {
					if(!StringUtils.isBlank(countryNames.get(i))) {
						try {
							//subFolderCountriesNode.addNode(countryNames.get(i), CategorizationNodeTypes.Category.NAME);
							Node categoryNode = subFolderCountriesNode.addNode(countryNames.get(i).toLowerCase(), CategorizationNodeTypes.Category.NAME);
							categoryNode.setProperty("name", countryNames.get(i).toLowerCase());
							categoryNode.setProperty("displayName", allCountries[i].getDisplayCountry(spanishLocale).toUpperCase());
							categoryNode.setProperty("displayName_en", allCountries[i].getDisplayCountry(englishLocale).toUpperCase());
							categoryNode.getSession().save();
						}catch(RepositoryException e) {
							// If exists a node with the same JCR name, skipped it!
						}
					}
				}
			}

		} else {
			log.debug("Exists node \"caar\", creating node \"caar-countries-tmp\"...");
			caarCategoryRootNode = session.getRootNode().getNode(caarRootFolderName);
			if (!caarCategoryRootNode.hasNode(tmpCaarCountiesFolderName)) {
				log.debug("Creating \"caar-countries-tmp\" node...");
				subFolderCountriesNode = caarCategoryRootNode.addNode(tmpCaarCountiesFolderName, NodeTypes.Folder.NAME);
			}
			if (subFolderCountriesNode != null && !subFolderCountriesNode.hasNodes()) {
				for (int i = 0; i < countryNames.size(); ++i) {
					if(!StringUtils.isBlank(countryNames.get(i))) {
						try {
							//subFolderCountriesNode.addNode(countryNames.get(i), CategorizationNodeTypes.Category.NAME);
							Node categoryNode = subFolderCountriesNode.addNode(countryNames.get(i).toLowerCase(), CategorizationNodeTypes.Category.NAME);
							categoryNode.setProperty("name", countryNames.get(i).toLowerCase());
							categoryNode.setProperty("displayName", allCountries[i].getDisplayCountry(spanishLocale).toUpperCase());
							categoryNode.setProperty("displayName_en", allCountries[i].getDisplayCountry(englishLocale).toUpperCase());
							categoryNode.getSession().save();
						}catch(RepositoryException e) {
							// Next language
						}
					}
				}
			}
			
			log.debug("Rename old node \"caar-countries\" to \"caar-contries-old\", and rename \"caar-countries-tmp\" to \"caar-countries\"...");
			Node oldNode = session.getRootNode().getNode(caarRootFolderName).getNode(caarCountriesFolderName);
			Node newNode = session.getRootNode().getNode(caarRootFolderName).getNode(tmpCaarCountiesFolderName);
			oldNode.getSession().move(oldNode.getPath(), oldNode.getParent().getPath() + "/" + caarCountriesOldFolderName);
			newNode.getSession().move(newNode.getPath(), newNode.getParent().getPath() + "/" + caarCountriesFolderName);
			
			log.debug("Remove old node renamed to \"caar-countries-old\"...");
			oldNode.remove();
		}
		if (caarCategoryRootNode != null)
			caarCategoryRootNode.getSession().save();
		if (subFolderCountriesNode != null)
			subFolderCountriesNode.getSession().save();
		return false;
	}

}
