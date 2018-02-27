package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface NewsNodeUtil {
	
	public String getHeadline(Node node) throws RepositoryException;

	public String getDescription(Node node) throws RepositoryException;

	public String getDate(Node node) throws RepositoryException;

	public String getImage(Node node) throws RepositoryException;

	public String getCategories(Node node) throws RepositoryException;

	public String getImportant(Node node) throws RepositoryException;

	public String getArchitectLinks(Node node) throws RepositoryException;

	public String getRelatedNews(Node node) throws RepositoryException;

	public String getMedium(Node node) throws RepositoryException;
	
	public List<Node> getRelatedElements(Node node) throws RepositoryException;
	
}
