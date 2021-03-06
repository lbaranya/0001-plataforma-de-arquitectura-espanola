package es.arquia.magnolia.utils.breadcrumb.award;

import javax.jcr.Node;

public interface UtilsBreadcrumbAward {
	
	String URIRepositoryAward = "/awards/";
	
	String URIPrefixAboutAward = "/awards/about/";
	
	String URIPrefixNewsListAward = "/awards/news-list/";
	
	String URIPrefixAnnouncementAward = "/awards/announcement/";
	
	String URIPrefixAwardStandardEvent = "/awards/standard-event/";
	
	String URIPrefixAwardLiveEvent = "/awards/live-event/";
	
	public String getAwardAboutPageLink(String currentUrl);
	
	public String getAwardNewsListPageLink(String currentUrl);
	
	public String getAwardSeconLevelMenuLink(String currentUrl, Node node);
	
	public String getAwardStandardEventMenuLink(String currentUrl, Node node);
	
	public String getAwardLiveEventMenuLink(String currentUrl, Node node);
}
