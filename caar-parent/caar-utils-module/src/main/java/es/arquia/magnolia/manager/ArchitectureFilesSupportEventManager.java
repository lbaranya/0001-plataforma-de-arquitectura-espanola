package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.utils.RelatedElement;

public interface ArchitectureFilesSupportEventManager {
	
	public List<Node> getArchitectureFilesSupportEventList() throws Exception;
	
	public ArchitectureFilesSupportEvent getInstance();
	
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException;
}
