package es.arquia.magnolia.functions;

public class I18nURLFunctionsImpl implements I18nURLFunctions{

	@Override
	public String swapLocalizedURL(String url, String newLanguage) {
		String tmp;
		if(url.contains("/en/")) {
			tmp = url.replace("/en/", "/"+newLanguage+"/");
		}else {
			if(url.contains("/es/")) {
				tmp = url.replace("/es/", "/");
			}else {
				tmp = "/"+newLanguage+url;
			}
		}
		return tmp;
	}

}
