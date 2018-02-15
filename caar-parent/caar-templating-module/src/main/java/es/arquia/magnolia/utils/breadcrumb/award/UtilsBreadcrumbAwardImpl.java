package es.arquia.magnolia.utils.breadcrumb.award;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import static es.arquia.magnolia.constants.AnnouncementConstants.announcementNodeType;

public class UtilsBreadcrumbAwardImpl implements UtilsBreadcrumbAward{

	@Override
	public String getAwardAboutPageLink(String currentUrl) {
		return currentUrl.replace(URIRepositoryAward, URIPrefixAboutAward);
	}

	@Override
	public String getAwardNewsListPageLink(String currentUrl) {
		return currentUrl.replace(URIRepositoryAward, URIPrefixNewsListAward);
	}

	@Override
	public String getAwardSeconLevelMenuLink(String currentUrl, Node node) {
		try {
			if(node.isNodeType(announcementNodeType)) {
				return currentUrl.replace(URIRepositoryAward, URIPrefixAnnouncementAward);
			}else {
				return currentUrl;
			}
		} catch (RepositoryException e) {
			return currentUrl;
		}
	}

}
