package es.arquia.magnolia.utils.breadcrumb.award;

public class UtilsBreadcrumbAwardImpl implements UtilsBreadcrumbAward{

	@Override
	public String getAwardAboutPageLink(String currentUrl) {
		return currentUrl.replace(URIRepositoryAward, URIPrefixAboutAward);
	}

	@Override
	public String getAwardNewsListPageLink(String currentUrl) {
		return currentUrl.replace(URIRepositoryAward, URIPrefixNewsListAward);
	}

}
