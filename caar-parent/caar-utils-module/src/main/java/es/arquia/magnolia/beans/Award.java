package es.arquia.magnolia.beans;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface Award {
	
	public String getType(Node node) throws RepositoryException;
	
	public String getAwardName(Node node) throws RepositoryException;
	
	public String getAwardDescription(Node node) throws RepositoryException;
	
	public String getAwardLogo(Node node) throws RepositoryException;
	
	public String getAwardExternalURL(Node node) throws RepositoryException;
	
	public String getAwardHeaderBackground(Node node) throws RepositoryException;
	
	public String getAwardAboutText(Node node) throws RepositoryException;
	
	public List<String> getAwardCategoriesList(Node node) throws RepositoryException;
	
	public String getEditionAnnouncementButtonText(Node node) throws RepositoryException;
	
	public String getEditionEnrollmentButtonText(Node node) throws RepositoryException;

	public List<RelatedElement> getRelatedElements(Node node) throws RepositoryException;

}
