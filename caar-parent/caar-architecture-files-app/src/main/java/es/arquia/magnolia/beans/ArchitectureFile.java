package es.arquia.magnolia.beans;

import javax.jcr.Node;

public interface ArchitectureFile {
	
	public RelatedFile getRelatedFile(Node node) throws Exception;

}