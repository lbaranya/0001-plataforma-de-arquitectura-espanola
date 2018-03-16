package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ArchitectureFilesSupportReview {
	
	public String getIdOuvre(Node node) throws RepositoryException;
	
	public String getStartDate(Node node) throws RepositoryException;
	
	public String getStartDayOfWeek(Node node) throws RepositoryException;
	
	public String getLastUpdateDate(Node node) throws RepositoryException;
	
	public String getPublishedInDirectory(Node node) throws RepositoryException;
	
	public String getOuvreTitle(Node node) throws RepositoryException;
	
	public String getArticleTitle(Node node) throws RepositoryException;
	
	public String getPlace(Node node) throws RepositoryException;
	
	public String getEditor(Node node) throws RepositoryException;
	
	public String getYear(Node node) throws RepositoryException;
	
	public String getPresentationDate(Node node) throws RepositoryException;
	
	public String getPresentationDateDayOfWeek(Node node) throws RepositoryException;
	
	public String getPresentationLocation(Node node) throws RepositoryException;
	
	public String getPresentationEntity(Node node) throws RepositoryException;
	
	public String getOuvreAbstract(Node node) throws RepositoryException;
	
	public String getAuthorshipType(Node node) throws RepositoryException;
	
	public String getAuthorshipName(Node node) throws RepositoryException;
	
	public String getAuthorshipDetail(Node node) throws RepositoryException;
	
	public String getNotes(Node node) throws RepositoryException;
	
	public String getTypology(Node node) throws RepositoryException;
	
	public String getRelatedThought(Node node) throws RepositoryException;
	
	public List<Node> getListMedia(Node node) throws RepositoryException;
	
	public Node getFirstMediaImage(Node node) throws RepositoryException;
	
	public String getMediaType(Node node) throws RepositoryException;
	
	public String getPreviewPhoto(Node node) throws RepositoryException;
	
	public String getMediaDetail(Node node) throws RepositoryException;
	
	public String getMediaTitle(Node node) throws RepositoryException;

}
