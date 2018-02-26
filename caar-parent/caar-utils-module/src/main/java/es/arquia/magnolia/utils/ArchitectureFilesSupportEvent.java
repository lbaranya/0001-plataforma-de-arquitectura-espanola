package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ArchitectureFilesSupportEvent {
	
	public String getOuvreTitle(Node node) throws RepositoryException;
	
	public String getEventType(Node node) throws RepositoryException;
	
	public String getImportant(Node node) throws RepositoryException;
	
	public String getPresentationStartDate(Node node) throws RepositoryException;
	
	public String getStartDayOfWeek(Node node) throws RepositoryException;
	
	public String getPresentationLocation(Node node) throws RepositoryException;
	
	public String getOuvreAbstract(Node node) throws RepositoryException;
	
	public String getPresentationEndingDate(Node node) throws RepositoryException;
	
	public String getPrice(Node node) throws RepositoryException;
	
	public String getWebsite(Node node) throws RepositoryException;
	
	public String getAuthorshipType(Node node) throws RepositoryException;
	
	public String getAuthorshipName(Node node) throws RepositoryException;
	
	public String getAuthorshipDetail(Node node) throws RepositoryException;
	
	public String getAuthorshipInfo(Node node) throws RepositoryException;
	
	public List<Node> getListMedia(Node node) throws RepositoryException;
	
	public String getPreviewPhoto(Node node) throws RepositoryException;
	
	public String getStartTime(Node node) throws RepositoryException;
	
	public String getEndTime(Node node) throws RepositoryException;

}
