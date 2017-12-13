package es.arquia.magnolia.commands;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import info.magnolia.context.MgnlContext;

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
    	
    	for(String locale : countryNames)
    		System.out.println(locale);
		
		return false;
	}

}
