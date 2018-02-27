package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.ArchitectureFilesSupportReviewI;
import es.arquia.magnolia.utils.RelatedElement;

public interface ArchitectureFilesSupportArchitectManager {
		
	public ArchitectureFilesSupportArchitect getInstance();
	
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException;
	
	public List<Node> getArchitectsList() throws RepositoryException;
}
