package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesSupportReview;
import es.arquia.magnolia.utils.RelatedElement;

public interface ArchitectureFilesSupportReviewManager {
	
	public List<Node> getArchitectureFilesSupportReviewIList() throws RepositoryException;
	
	public ArchitectureFilesSupportReview getInstance();
	
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException;
	
	public String getLink(String link);
}
