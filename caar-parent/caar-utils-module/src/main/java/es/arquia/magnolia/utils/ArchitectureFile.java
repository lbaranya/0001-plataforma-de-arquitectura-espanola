package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ArchitectureFile {
	
	public List<Node> getRelatedElements(Node node) throws RepositoryException;

}
