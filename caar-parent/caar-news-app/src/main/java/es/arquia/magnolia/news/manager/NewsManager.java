package es.arquia.magnolia.news.manager;

import java.util.List;

import javax.jcr.Node;

import es.arquia.magnolia.news.News;

public interface NewsManager {
	
	public List<Node> getNewsList() throws Exception;
	
	public News getInstance();

}
