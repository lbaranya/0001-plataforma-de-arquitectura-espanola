package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;

import es.arquia.magnolia.utils.ArchitectureFilesSupportReviewI;

public interface ArchitectureFilesSupportReviewIManager {
	
	public List<Node> getArchitectureFilesSupportReviewIList() throws Exception;
	
	public ArchitectureFilesSupportReviewI getInstance();
}
