package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Award;

public interface AwardManager {
	
	public List<Node> getAwardList() throws RepositoryException;
	
	public List<Node> getBiennialList() throws RepositoryException;
	
	public Node getEditionStateOpen(Node node) throws RepositoryException;
	
	public Node getEditionStateInProgress(Node node) throws RepositoryException;
	
	public Award getInstance();

}
