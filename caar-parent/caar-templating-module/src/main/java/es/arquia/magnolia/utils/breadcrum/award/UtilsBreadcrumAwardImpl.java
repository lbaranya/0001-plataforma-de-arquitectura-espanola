package es.arquia.magnolia.utils.breadcrum.award;

public class UtilsBreadcrumAwardImpl implements UtilsBreadcrumAward{

	@Override
	public String getAwardAboutPageLink(String currentUrl) {
		return currentUrl.replace(URIRepositoryAward, URIPrefixAboutAward);
	}

	@Override
	public String getAwardNewsListPageLink(String currentUrl) {
		return currentUrl.replace(URIRepositoryAward, URIPrefixNewsListAward);
	}

}
