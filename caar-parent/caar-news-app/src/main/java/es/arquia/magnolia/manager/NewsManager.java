package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;

import es.arquia.magnolia.beans.News;

public interface NewsManager {
	
	public List<Node> getNewsList() throws Exception;
	
	public News getInstance();

}
