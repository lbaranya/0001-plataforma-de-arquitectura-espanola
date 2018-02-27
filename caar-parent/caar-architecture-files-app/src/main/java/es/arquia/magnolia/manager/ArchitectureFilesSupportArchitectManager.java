package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.ArchitectureFilesSupportArchitect;

public interface ArchitectureFilesSupportArchitectManager {
	
	public List<Node> getArchitectsList() throws RepositoryException;
	
	public ArchitectureFilesSupportArchitect getInstance();
	
	public List<Node> getLastModifiedArchitects() throws RepositoryException;

}
