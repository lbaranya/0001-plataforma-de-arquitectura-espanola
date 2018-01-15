package es.arquia.magnolia.files;

import javax.jcr.Node;

public interface ArchitectureFile {
	
	public RelatedFile getRelatedFile(Node node) throws Exception;

}
