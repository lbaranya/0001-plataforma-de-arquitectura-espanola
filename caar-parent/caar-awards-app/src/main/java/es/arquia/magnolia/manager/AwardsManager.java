package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;

import es.arquia.magnolia.beans.Awards;

public interface AwardsManager {

	public List<Node> getAwardsList() throws Exception;
	
	public List<Node> getBiennialsList() throws Exception;
	
	public Awards getInstance();
	
}
