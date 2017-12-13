package es.arquia.magnolia.commands;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Session;

import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeTypes;

public class CountryCommand{
	
	private Locale userLocale;
	
	public CountryCommand() {
		userLocale = MgnlContext.getLocale();
	}

	public boolean execute() throws Exception {
		
		String[] locales = Locale.getISOCountries();
		List<String> countryNames = new ArrayList<String>();
		for (String countryCode : locales) {
    		Locale obj2 = new Locale(userLocale.getLanguage(), countryCode);
    		countryNames.add(obj2.getDisplayCountry(userLocale));
		}
		
		// Ordenar ignorando caracteres especiales, como acentos
    	Collator coll = Collator.getInstance(userLocale);
    	coll.setStrength(Collator.PRIMARY);
    	Collections.sort(countryNames, coll);
    	
    	/*for(String locale : countryNames)
    		System.out.println(locale);*/
    	
    	Session session = MgnlContext.getJCRSession("category");
    	Node caarCategoryRootNode = null;
    	Node subFolderCountriesNode = null;
    	if(!session.getRootNode().hasNode("caar")) {
    		caarCategoryRootNode = session.getRootNode().addNode("caar", NodeTypes.Folder.NAME);
    		if(!caarCategoryRootNode.hasNode("caar-countries"))
    			subFolderCountriesNode = caarCategoryRootNode.addNode("caar-countries", NodeTypes.Folder.NAME);
			if(!subFolderCountriesNode.hasNodes()) {
				for(int i=0; i<countryNames.size(); ++i) {
					subFolderCountriesNode.addNode(countryNames.get(i), "mgnl:category");
				}
			}
    	}else {
    		System.out.println("Exists node \"caar\", creating node \"tmp-caar\"...");
    		if(!session.getRootNode().hasNode("tmp-caar")) {
    			caarCategoryRootNode = session.getRootNode().addNode("tmp-caar", NodeTypes.Folder.NAME);
    			if(!caarCategoryRootNode.hasNode("caar-countries")) {
    				System.out.println("Creating \"caar-countries\" node...");
        			subFolderCountriesNode = caarCategoryRootNode.addNode("caar-countries", NodeTypes.Folder.NAME);
    			}
    			if(!subFolderCountriesNode.hasNodes()) {
    				for(int i=0; i<countryNames.size(); ++i) {
    					subFolderCountriesNode.addNode(countryNames.get(i), "mgnl:category");
    				}
    			}
    			System.out.println("Rename old node \"caar\" to \"caar-r\", and rename \"tmp-caar\" to \"caar\"...");
    			Node oldNode = session.getRootNode().getNode("caar");
    			Node newNode = session.getRootNode().getNode("tmp-caar");
    			oldNode.getSession().move(oldNode.getPath(), oldNode.getParent().getPath() + "caar-2");
    			newNode.getSession().move(newNode.getPath(), newNode.getParent().getPath() + "caar");
    			System.out.println("Remove old node renamed to \"caar-2\"...");
    			oldNode.remove();
    		}
    	}
    	if(caarCategoryRootNode != null)
    		caarCategoryRootNode.getSession().save();
    	if(subFolderCountriesNode != null)
    		subFolderCountriesNode.getSession().save();
		return false;
	}

}
