package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ArchitectureFilesSupportReviewI {
	
	public String getIdOuvre(Node node) throws RepositoryException;
	
	public String getStartDate(Node node) throws RepositoryException;
	
	public String getStartDayOfWeek(Node node) throws RepositoryException;
	
	public String getLastUpdateDate(Node node) throws RepositoryException;
	
	public String getPublishedInDirectory(Node node) throws RepositoryException;
	
	public String getOuvreTitle(Node node, String currentLanguage) throws RepositoryException;
	
	public String getPresentationDate(Node node) throws RepositoryException;
	
	public String getPresentationDateDayOfWeek(Node node) throws RepositoryException;
	
	public String getPresentationLocation(Node node, String currentLanguage) throws RepositoryException;
	
	public String getPresentationEntity(Node node, String currentLanguage) throws RepositoryException;
	
	public String getOuvreAbstract(Node node, String currentLanguage) throws RepositoryException;
	
	public String getAuthorshipType(Node node, String currentLanguage) throws RepositoryException;
	
	public String getAuthorshipName(Node node, String currentLanguage) throws RepositoryException;
	
	public String getAuthorshipDetail(Node node, String currentLanguage) throws RepositoryException;
	
	public String getNotes(Node node, String currentLanguage) throws RepositoryException;
	
	public String getTypology(Node node, String currentLanguage) throws RepositoryException;
	
	public String getConferences(Node node, String currentLanguage) throws RepositoryException;
	
	public String getDiscussions(Node node, String currentLanguage) throws RepositoryException;
	
	public String getPoster(Node node, String currentLanguage) throws RepositoryException;
	
	public String getCourses(Node node, String currentLanguage) throws RepositoryException;
	
	public String getAwardsAndDistinctions(Node node, String currentLanguage) throws RepositoryException;
	
	public String getRelatedThought(Node node) throws RepositoryException;
	
	public List<Node> getListMedia(Node node) throws RepositoryException;
	
	public Node getFirstMediaImage(Node node) throws RepositoryException;
	
	public String getMediaType(Node node, String currentLanguage) throws RepositoryException;
	
	public String getPreviewPhoto(Node node) throws RepositoryException;
	
	public String getMediaDetail(Node node, String currentLanguage) throws RepositoryException;
	
	public String getMediaTitle(Node node, String currentLanguage) throws RepositoryException;

}
