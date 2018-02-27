package es.arquia.magnolia.manager;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.RelatedElement;

public interface RelatedElementsManager {
	
	public RelatedElement transformToRelatedElement (Node node) throws RepositoryException;

}
