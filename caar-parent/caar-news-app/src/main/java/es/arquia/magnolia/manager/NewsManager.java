package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;

import es.arquia.magnolia.beans.News;

public interface NewsManager {
	
	public List<Node> getNewsList() throws Exception;
	
	public List<Node> getNewsList(int numberOfNews) throws Exception;
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList) throws Exception;
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList, int numberOfNews) throws Exception;
	
	public List<Node> getImportantNewsList() throws Exception;
	
	public boolean isLastRowOfNews();
	
	public News getInstance();

}
