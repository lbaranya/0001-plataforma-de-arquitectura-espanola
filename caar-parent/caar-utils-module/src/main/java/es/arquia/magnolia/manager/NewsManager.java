package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.NewsNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;

public interface NewsManager {
	
	public List<Node> getNewsList() throws RepositoryException;
	
	public List<Node> getNewsList(int numberOfNews) throws RepositoryException;
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList) throws RepositoryException;
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList, int numberOfNews) throws RepositoryException;
	
	public List<Node> getImportantNewsList() throws RepositoryException;
	
	public List<Node> getCategorizedImportantNewsList(List<String> categoriesList, int numberOfNews) throws RepositoryException;
	
	public boolean isLastRowOfNews();
	
	public NewsNodeUtil getInstance();
	
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException;

}
