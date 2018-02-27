package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;

public interface ArchitectureFilesSupportProject {
	
	public String getProjectId (Node node);
	
	public String getDischargeDate (Node node);
	
	public String getLastUpdateDate (Node node);
	
	public String getPublishedDirectory (Node node);
	
	public String getProjectTitle (Node node);
	
	public String getOtherReferences (Node node);
	
	public String getProjectStartDate (Node node);
	
	public String getWorkStartDate (Node node);
	
	public String getProjectFinishDate (Node node);
	
	public String getSquareMetersBuilded (Node node);
	
	public String getSquareMetersCost (Node node);
	
	public String getAwardsAndDistinctions (Node node);
	
	public String getTypeOfRoad (Node node);
	
	public String getRoad (Node node);
	
	public String getNumber (Node node);
	
	public String getPostalCode (Node node);
	
	public String getLocation (Node node);
	
	public String getTown (Node node);
	
	public String getProvince (Node node);
	
	public String getAutonomousCommunity (Node node);
	
	public String getCountry (Node node);
	
	public String getLattitude (Node node);
	
	public String getLongitude (Node node);
	
	public List<Node> getAuthorshipList (Node node);
	
	public String getAuthorshipType (Node node);
	
	public String getAuthorshipName (Node node);
	
	public String getAuthorshipSurname (Node node);
	
	public String getAuthorshipDetails (Node node);
	
	public String getSupportTypology (Node node);
	
	public String getLinkExternalPage (Node node);
	
	public String getIfAbleToGetResource (Node node);
	
	public String getContactEmail (Node node);
	
	public String getContactPhone (Node node);
	
	public String getTypeOfRoadAuthorOwnership (Node node);
	
	public String getRoadAuthorOwnership (Node node);
	
	public String getNumberAuthorOwnership (Node node);
	
	public String getTownAuthorOwnership (Node node);
	
	public String getPostalCodeAuthorOwnership (Node node);
	
	public String getProvinceAuthorOwnership (Node node);
	
	public String getAutonomousCommunityAuthorOwnership (Node node);
	
	public String getCountryAuthorOwnership (Node node);
	
	public List<Node> getListRelatedThoughts (Node node);
	
	public String getRelatedThoughtPath (Node node);
	
	public String getBuildedBy (Node node);
	
	public String getProjectActualState (Node node);
	
	public String getProjectActualUse (Node node);
	
	public String getProjectType (Node node);
	
	public String getMainTheme (Node node);
	
	public String getTemporalScope (Node node);
	
	public String getTerritorialScope (Node node);
	
	public String getMainArchitect (Node node);
	
	public String getMainArchitecturalType (Node node);
	
	public String getMainArchitecturalUse (Node node);
	
	public List<Node> getListMedia (Node node);
	
	public String getGalleryTitle (Node node);
	
	public String getMediaType (Node node);
	
	public String getPhotoPreview (Node node);
	
	public String getMediaDetails (Node node);
	
	public String getMediaTitle (Node node);

}
