package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.AnnouncementNodeUtil;
import es.arquia.magnolia.utils.AwardNodeUtil;
import es.arquia.magnolia.utils.EventNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;

public interface AwardManager {
	
	public List<Node> getAwardList() throws RepositoryException;
	
	public List<Node> getBiennialList() throws RepositoryException;
	
	public Node getEditionStateOpen(Node node) throws RepositoryException;
	
	public Node getEditionStateInProgress(Node node) throws RepositoryException;
	
	public AwardNodeUtil getInstance();
	
	public AnnouncementNodeUtil getAnnouncementInstance();
	
	public EventNodeUtil getEventInstance();
	
	public List<Node> getEvents(Node node) throws RepositoryException;
	
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException;
	
	public String getAnnouncementState (Node node) throws RepositoryException;

}
