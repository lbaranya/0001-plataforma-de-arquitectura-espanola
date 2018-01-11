package es.arquia.magnolia.commands;

import java.text.Collator;
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

import info.magnolia.module.categorization.CategorizationNodeTypes;

public class CountryCommand {

	private static final Logger log = LoggerFactory.getLogger(CountryCommand.class);
	
	private Locale userLocale;

	public CountryCommand() {
		userLocale = MgnlContext.getLocale();
	}

	public boolean execute() throws Exception {

		String[] locales = Locale.getISOCountries();
		List<String> countryNames = new ArrayList<>();
		for (String countryCode : locales) {
			Locale obj2 = new Locale(userLocale.getLanguage(), countryCode);
			countryNames.add(obj2.getDisplayCountry(userLocale));
		}

		// Ordenar ignorando caracteres especiales, como acentos
		Collator coll = Collator.getInstance(userLocale);
		coll.setStrength(Collator.PRIMARY);
		Collections.sort(countryNames, coll);

		Session session = MgnlContext.getJCRSession("category");
		Node caarCategoryRootNode = null;
		Node subFolderCountriesNode = null;
		if (!session.getRootNode().hasNode("caar")) {

			caarCategoryRootNode = session.getRootNode().addNode("caar", NodeTypes.Folder.NAME);
			if (!caarCategoryRootNode.hasNode("caar-countries")) {
				subFolderCountriesNode = caarCategoryRootNode.addNode("caar-countries", NodeTypes.Folder.NAME);
			}

			if (subFolderCountriesNode != null && !subFolderCountriesNode.hasNodes()) {
				for (int i = 0; i < countryNames.size(); ++i) {
					subFolderCountriesNode.addNode(countryNames.get(i), CategorizationNodeTypes.Category.NAME);
				}
			}

		} else {
			log.debug("Exists node \"caar\", creating node \"caar-countries-tmp\"...");
			caarCategoryRootNode = session.getRootNode().getNode("caar");
			if (!caarCategoryRootNode.hasNode("caar-countries-tmp")) {
				log.debug("Creating \"caar-countries-tmp\" node...");
				subFolderCountriesNode = caarCategoryRootNode.addNode("caar-countries-tmp", NodeTypes.Folder.NAME);
			}
			if (subFolderCountriesNode != null && !subFolderCountriesNode.hasNodes()) {
				for (int i = 0; i < countryNames.size(); ++i) {
					subFolderCountriesNode.addNode(countryNames.get(i), CategorizationNodeTypes.Category.NAME);
				}
			}
			
			log.debug("Rename old node \"caar-countries\" to \"caar-contries-old\", and rename \"caar-countries-tmp\" to \"caar-countries\"...");
			Node oldNode = session.getRootNode().getNode("caar").getNode("caar-countries");
			Node newNode = session.getRootNode().getNode("caar").getNode("caar-countries-tmp");
			oldNode.getSession().move(oldNode.getPath(), oldNode.getParent().getPath() + "/caar-countries-old");
			newNode.getSession().move(newNode.getPath(), newNode.getParent().getPath() + "/caar-countries");
			
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
