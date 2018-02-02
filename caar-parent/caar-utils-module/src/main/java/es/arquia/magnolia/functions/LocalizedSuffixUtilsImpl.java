package es.arquia.magnolia.functions;

import info.magnolia.context.MgnlContext;

public class LocalizedSuffixUtilsImpl implements LocalizedSuffixUtils{
	
	public String getLocalizedSuffix(String currentLanguage) {
		if(!MgnlContext.getLocale().getLanguage().equals(currentLanguage))
			currentLanguage = "_" + currentLanguage;
		else
			currentLanguage = "";
		return currentLanguage;
	}

}
