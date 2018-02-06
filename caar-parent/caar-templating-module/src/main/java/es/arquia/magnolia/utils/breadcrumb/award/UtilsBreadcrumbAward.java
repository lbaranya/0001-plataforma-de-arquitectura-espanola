package es.arquia.magnolia.utils.breadcrumb.award;

public interface UtilsBreadcrumbAward {
	
	String URIRepositoryAward = "/awards/";
	
	String URIPrefixAboutAward = "/awards/about/";
	
	String URIPrefixNewsListAward = "/awards/news-list/";
	
	public String getAwardAboutPageLink(String currentUrl);
	
	public String getAwardNewsListPageLink(String currentUrl);
}
