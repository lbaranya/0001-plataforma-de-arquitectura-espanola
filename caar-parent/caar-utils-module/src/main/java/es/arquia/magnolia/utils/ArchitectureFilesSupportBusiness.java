package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ArchitectureFilesSupportBusiness {
	
	public String getBusinessType(Node node) throws RepositoryException;
	
	public String getLegalName(Node node) throws RepositoryException;
	
	public String getLogo(Node node) throws RepositoryException;
	
	public String getConstitutionDate(Node node) throws RepositoryException;
	
	public String getDepartmentWebsite(Node node) throws RepositoryException;
	
	public String getDepartmentCity(Node node) throws RepositoryException;
	
	public String getDepartmentCountry(Node node) throws RepositoryException;
	
	public List<String> getDepartmentComponents(Node node) throws RepositoryException;
	
	public String getBiographicNews(Node node) throws RepositoryException;
	
	public String getCurriculum(Node node) throws RepositoryException;
	
	public String getAwardsAndDistinctions(Node node) throws RepositoryException;
	
	public String getAdditionalInfo(Node node) throws RepositoryException;
	
	public String getAnnexes(Node node) throws RepositoryException;
	
	public String getDossier(Node node) throws RepositoryException;
	
	public List<Node> getRelatedFiles(Node node) throws RepositoryException;
} 