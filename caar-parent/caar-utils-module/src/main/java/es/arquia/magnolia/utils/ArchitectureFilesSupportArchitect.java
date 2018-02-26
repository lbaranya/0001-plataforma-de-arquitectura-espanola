package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

public interface ArchitectureFilesSupportArchitect {

	public String getName(Node node) throws RepositoryException;
	
	public String getFirstSurname(Node node) throws RepositoryException;
	
	public String getSecondSurname(Node node) throws RepositoryException;
	
	public String getOtherNames(Node node) throws RepositoryException;
	
	public String getPhoto(Node node) throws RepositoryException;
	
	public String getBirthDate(Node node) throws RepositoryException;
	
	public String getBirthCity(Node node) throws RepositoryException;
	
	public String getBirthCountry(Node node) throws RepositoryException;
	
	public String getDeathDate(Node node) throws RepositoryException;
	
	public String getDeathCity(Node node) throws RepositoryException;
	
	public String getDeathCountry(Node node) throws RepositoryException;
	
	public String getCertification(Node node) throws RepositoryException;
	
	public String getCertificationCenter(Node node) throws RepositoryException;
	
	public String getCertificatoinCountry(Node node) throws RepositoryException;
	
	public String getCertificationYear(Node node) throws RepositoryException;
	
	public String getOtherStudies(Node node) throws RepositoryException;
	
	public String getDoctorate(Node node) throws RepositoryException;
	
	public String getDepartmentName(Node node) throws RepositoryException;
	
	public String getDepartmentWebSite(Node node) throws RepositoryException;
	
	public String getDepartmentCity(Node node) throws RepositoryException;
	
	public String getDepartmentCountry(Node node) throws RepositoryException;
	
	public List<String> getDepartmentComponents(Node node) throws RepositoryException;
	
	public String getConcatenatedDepartmentComponents(Node node) throws RepositoryException;
	
	public String getBiographicNews(Node node) throws RepositoryException;
	
	public String getCurriculum(Node node) throws RepositoryException;
	
	public String getAwardsAndDistinctions(Node node) throws RepositoryException;
	
	public String getWorkingExperienceStartDate(Node node) throws RepositoryException;

	public List<Node> getWorkExperienceList(Node node) throws RepositoryException;
	
	public String getWorkExperienceStartDate(Node node) throws RepositoryException;
	
	public String getWorkExperienceEndingDate(Node node) throws RepositoryException;
	
	public String getWorkExperiencePositionOccupied(Node node) throws RepositoryException;
	
	public String getWorkExperienceMainFunctions(Node node) throws RepositoryException;
	
	public String getWorkExperienceBusinessName(Node node) throws RepositoryException;
	
	public String getWorkExperienceBusinessType(Node node) throws RepositoryException;
	
	public List<Node> getEducationList(Node node) throws RepositoryException;
	
	public String getEducationStartDate(Node node) throws RepositoryException;
	
	public String getEducationEndingDate(Node node) throws RepositoryException;
	
	public String getEducationQualification(Node node) throws RepositoryException;
	
	public String getEducationSubjects(Node node) throws RepositoryException;
	
	public String getEducationCenter(Node node) throws RepositoryException;
	
	public String getEducationCenterType(Node node) throws RepositoryException;
	
	public String getEducationLevel(Node node) throws RepositoryException;
	
	public String getLanguage(Node node) throws RepositoryException;
	
	public String getOtherLanguages(Node node) throws RepositoryException;
	
	public String getMotherLanguage(Node node) throws RepositoryException;
	
	public String getListening(Node node) throws RepositoryException;
	
	public String getReading(Node node) throws RepositoryException;
	
	public String getSpeakingInteraction(Node node) throws RepositoryException;
	
	public String getSpeakingExpression(Node node) throws RepositoryException;
	
	public String getWritting(Node node) throws RepositoryException;
	
	public String getSocialSkills(Node node) throws RepositoryException;
	
	public String getOrganizationalSkills(Node node) throws RepositoryException;
	
	public String getTechnicalSkills(Node node) throws RepositoryException;
	
	public String getComputerSkills(Node node) throws RepositoryException;
	
	public String getArtisticSkills(Node node) throws RepositoryException;
	
	public String getOtherSkills(Node node) throws RepositoryException;
	
	public String getDrivingLicense(Node node) throws RepositoryException;

	public String getAditionalInfo(Node node) throws RepositoryException;
	
	public String getAnnexes(Node node) throws RepositoryException;
	
	public List<RelatedElement> getRelatedElements(Node node)  throws RepositoryException;
	
	public String getDepartmentWebSiteFieldName();
	
	public List<Property> validProperties(Node node, String field) throws RepositoryException;

}
