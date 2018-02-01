package es.arquia.magnolia.utils.breadcrum.award;

public interface UtilsBreadcrumAward {
	
	String URIRepositoryAward = "/awards/";
	
	String URIPrefixAboutAward = "/awards/about/";
	
	String URIPrefixNewsListAward = "/awards/news-list/";
	
	public String getAwardAboutPageLink(String currentUrl);
	
	public String getAwardNewsListPageLink(String currentUrl);
}
