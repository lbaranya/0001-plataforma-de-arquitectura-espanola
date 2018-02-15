package es.arquia.magnolia.beans;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface Announcement {
	
	public String getAnnouncementState(Node node);
	
	public String getAnnouncementTitle(Node node);
	
	public String getAnnouncementText(Node node);
	
	public String getAnnouncementMediaType(Node node);
	
	public String getAnnouncementMediaImage(Node node);
	
	public String getAnnouncementMediaVideo(Node node);
	
	public String getAnnouncementMediaPosition(Node node);
	
	public List<Node> getAnnouncementRichTextSections(Node node) throws RepositoryException;
	
	public List<Node> getAnnouncementEnrollmentSections(Node node) throws RepositoryException;
	
	public List<Node> getAnnouncementLemmaSections(Node node) throws RepositoryException;
	
	public Node createJuryNode(Node node);

}
