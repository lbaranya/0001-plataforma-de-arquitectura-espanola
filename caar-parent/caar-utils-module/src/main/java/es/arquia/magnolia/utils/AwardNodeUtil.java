package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.RelatedElement;

public interface AwardNodeUtil {
	
	public String getType(Node node) throws RepositoryException;
	
	public String getAwardName(Node node) throws RepositoryException;
	
	public String getAwardDescription(Node node) throws RepositoryException;
	
	public String getAwardLogo(Node node) throws RepositoryException;
	
	public String getAwardExternalURL(Node node) throws RepositoryException;
	
	public String getAwardHeaderBackground(Node node) throws RepositoryException;
	
	public String getAwardAboutText(Node node) throws RepositoryException;
	
	public List<String> getAwardCategoriesList(Node node) throws RepositoryException;
	
	public String getEditionState(Node node) throws RepositoryException;
	
	public String getEditionAnnouncementButtonText(Node node) throws RepositoryException;
	
	public String getEditionEnrollmentButtonText(Node node) throws RepositoryException;

	public List<Node> getRelatedElements(Node node) throws RepositoryException;

}
