package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesSupportReviewI;
import es.arquia.magnolia.utils.RelatedElement;

public interface ArchitectureFilesSupportReviewIManager {
	
	public List<Node> getArchitectureFilesSupportReviewIList() throws RepositoryException;
	
	public ArchitectureFilesSupportReviewI getInstance();
	
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException;
}
