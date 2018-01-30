package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;

import es.arquia.magnolia.beans.ArchitectureFilesSupportEvent;

public interface ArchitectureFilesSupportEventManager {
	
	public List<Node> getArchitectureFilesSupportEventList() throws Exception;
	
	public ArchitectureFilesSupportEvent getInstance();
}
