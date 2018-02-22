package es.arquia.magnolia.beans;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ArchitectureFile {
	
	public List<RelatedElement> getRelatedElements(Node node) throws RepositoryException;

}
