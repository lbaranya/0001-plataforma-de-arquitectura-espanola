package es.arquia.magnolia.beans;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface News {
	
	public String getHeadline(Node node) throws RepositoryException;

	public String getDescription(Node node) throws RepositoryException;

	public String getDate(Node node) throws RepositoryException;

	public String getImage(Node node) throws RepositoryException;

	public String getCategories(Node node) throws RepositoryException;

	public String getImportant(Node node) throws RepositoryException;

	public String getArchitectLinks(Node node) throws RepositoryException;

	public String getRelatedNews(Node node) throws RepositoryException;

	public String getMedium(Node node, String currentLanguage) throws RepositoryException;
	
	public List<RelatedElement> getRelatedElements(Node node) throws RepositoryException;
	
	public RelatedElement getRelatedElement(Node node) throws RepositoryException;

}
