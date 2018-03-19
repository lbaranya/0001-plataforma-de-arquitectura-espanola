package es.arquia.magnolia.manager;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.ArchitectureFilesSupportBusiness;
import es.arquia.magnolia.utils.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.utils.ArchitectureFilesSupportProject;
import es.arquia.magnolia.utils.ArchitectureFilesSupportReview;

public interface ArchitectureFilesSupportManager {
	
	public ArchitectureFilesSupportArchitect getArchitectInstance();
	
	public ArchitectureFilesSupportEvent getEventInstance();
	
	public ArchitectureFilesSupportReview getReviewInstance();
	
	public ArchitectureFilesSupportProject getProjectInstance();
	
	public ArchitectureFilesSupportBusiness getBusinessProject();
	
	public String getLink(Node node, String link) throws RepositoryException;
	
	public boolean isSupport(Node node) throws RepositoryException;

}
