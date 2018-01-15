package es.arquia.magnolia.components.architectureFiles.support.architect;

import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFormatException;


import es.arquia.magnolia.files.ArchitectureFile;
import es.arquia.magnolia.files.RelatedFile;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.predicate.AbstractPredicate;
import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.jcr.util.PropertyUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;

public class ArchitectureFilesSupportArchitect implements ArchitectureFile{
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportArchitect.class);

	private static String name = "FS1.1.1";
	private static String firstSurname = "FS1.1.2";
	private static String secondSurname = "FS1.1.3";
	private static String otherNames = "FS1.1.4";
	private static String photo = "FS1.1.5";
	private static String birthDate = "FS1.1.6";
	private static String birthCity = "FS1.1.7";
	private static String birthCountry = "FS1.1.8";
	
	private static String deathDate = "FS1.1.9.1";
	private static String deathCity = "FS1.1.9.2";
	private static String deathCountry = "FS1.1.9.3";
	
	private static String certification = "FS1.2.1";
	private static String certificationCenter = "FS1.2.2";
	private static String certificationCountry = "FS1.2.3";
	private static String certificationYear = "FS1.2.4";
	private static String otherStudies = "FS1.2.5";
	private static String doctorate = "FS1.2.6";
	
	private static String departmentName = "FS1.3.1";
	private static String departmentWebSite = "FS1.3.2";
	private static String departmentCity = "FS1.3.3";
	private static String departmentCountry = "FS1.3.4";
	private static String departmentComponents = "FS1.3.5";
	private static String biographicNews = "FS1.3.6";
	private static String curriculum = "FS1.3.7";
	private static String awardsAndDistinctions = "FS1.3.8";
	
	private static String workExperienceList = "listExperience";
	private static String workExperienceStartDate = "FS1.4.1";
	private static String workExperienceEndingDate = "FS1.4.2";
	private static String workExperiencePositionOccupied = "FS1.4.3";
	private static String workExperienceMainFunctions = "FS1.4.4";
	private static String workExperienceBusinessName = "FS1.4.5";
	private static String workExperienceBusinessType = "FS1.4.6";
	
	private static String educationList = "listEducation";
	private static String educationStartDate = "FS1.5.1";
	private static String educationEndingDate = "FS1.5.2";
	private static String educationQualification = "FS1.5.3";
	private static String educationSubjects = "FS1.5.4";
	private static String educationCenter = "FS1.5.5";
	private static String educationCenterType = "FS1.5.6";
	private static String educationLevel = "FS1.5.7";
	
	private static String language = "FS1.6.1";
	private static String otherLanguages = "FS1.6.2";
	private static String motherLanguage = "FS1.6.3";
	private static String listening = "FS1.6.4";
	private static String reading = "FS1.6.5";
	private static String speakingInteraction = "FS1.6.6";
	private static String speakingExpression = "FS1.6.7";
	private static String writting = "FS1.6.8";
	
	private static String socialSkills = "FS1.7.1";
	private static String organizationalSkills = "FS1.7.2";
	private static String technicalSkills = "FS1.7.3";
	private static String computerSkills = "FS1.7.4";
	private static String artisticSkills = "FS1.7.5";
	private static String otherSkills = "FS1.7.6";
	private static String drivingLicense = "FS1.7.7";
	
	private static String aditionalInfo = "FS1.8.1";
	private static String annexes = "FS1.8.2";
	
	private static String relatedFiles = "relatedFiles";
	
	public ArchitectureFilesSupportArchitect() {}
	
	private static AbstractPredicate<Node> MAGNOLIA_ARCHITECT_FILTER = new AbstractPredicate<Node>() {

        @Override
        public boolean evaluateTyped(Node node) {

            try {
                return node.isNodeType(architectureFilesSupportArchitectNodeType);
            } catch (RepositoryException e) {
                log.error("Unable to read nodeType for node {}", NodeUtil.getNodePathIfPossible(node));
            }
            return false;
        }
    };
	

	public String getName(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(name).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getFirstSurname(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(firstSurname).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getSecondSurname(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(secondSurname).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getOtherNames(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(otherNames).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getPhoto(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(photo).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getBirthDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		try {
			Calendar calendar = node.getProperty(birthDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(architectureFilesDateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getBirthCity(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(birthCity).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getBirthCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(birthCountry).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDeathDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		try {
			Calendar calendar = node.getProperty(deathDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(architectureFilesDateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDeathCity(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(deathCity).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDeathCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(deathCountry).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getCertification(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(certification).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getCertificationCenter(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(certificationCenter).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getCertificatoinCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(certificationCountry).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getCertificationYear(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(certificationYear).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getOtherStudies(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(otherStudies).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDoctorate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(doctorate).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDepartmentName(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {	
			return node.getProperty(departmentName).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDepartmentWebSite(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			return node.getProperty(departmentWebSite).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDepartmentCity(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			return node.getProperty(departmentCity).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDepartmentCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			return node.getProperty(departmentCountry).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public List<String> getDepartmentComponents(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		List<String> list = new ArrayList<>();
		try {
			for(Value iterator : node.getProperty(departmentComponents).getValues()) {
				list.add(iterator.getString());
			}
		} catch(Exception e) {}
		return list;
	}
	
	public String getConcatenatedDepartmentComponents(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			String result = "";
			List<Property> properties = validProperties(node, departmentComponents);
			Session session = MgnlContext.getJCRSession(architectureFilesWorkspace);
			for (Property iterator : properties)
			{
				Node componentNode = session.getNode(iterator.getValue().getString());
				result += getName(componentNode) + " " + getFirstSurname(componentNode) + " " + getSecondSurname(componentNode) + ", ";
			}
			return result.substring(0, result.length()-2);
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getBiographicNews(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			return node.getProperty(biographicNews).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getCurriculum(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			return node.getProperty(curriculum).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getAwardsAndDistinctions(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			return node.getProperty(awardsAndDistinctions).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getWorkingExperienceStartDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(workingExperienceStartDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(architectureFilesDateFormat, locale);

	public List<Node> getWorkExperienceList(Node node) throws Exception{
		List<Node> list = new ArrayList<>();
		try {
			if (node.getNode(workExperienceList) != null)
			{
				Node listNode = node.getNode(workExperienceList);
				if(listNode.hasNodes()) {
					Iterable<Node> childList = NodeUtil.collectAllChildren(listNode);
					list = NodeUtil.asList(childList);
				}
			}
		} catch(Exception e) {}
		return list;
	
	public String getWorkExperienceStartDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		try {
			Calendar calendar = node.getProperty(workExperienceStartDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(architectureFilesDateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(Exception e) {
			return "";
		}
	
	public String getWorkExperienceEndingDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		try {
			Calendar calendar = node.getProperty(workExperienceEndingDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(architectureFilesDateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getWorkExperiencePositionOccupied(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(workExperiencePositionOccupied).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getWorkExperienceMainFunctions(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(workExperienceMainFunctions).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getWorkExperienceBusinessName(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(workExperienceBusinessName).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getWorkExperienceBusinessType(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(workExperienceBusinessType).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public List<Node> getEducationList(Node node) throws Exception{
		List<Node> list = new ArrayList<>();
		try {
			if (node.getNode(educationList) != null)
			{
				Node listNode = node.getNode(educationList);
				if(listNode.hasNodes()) {
					Iterable<Node> childList = NodeUtil.collectAllChildren(listNode);
					list = NodeUtil.asList(childList);
				}
			}
		} catch(Exception e) {}
		return list;
	}
	
	public String getEducationStartDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		try {
			Calendar calendar = node.getProperty(educationStartDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(architectureFilesDateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getEducationEndingDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		try {
			Calendar calendar = node.getProperty(educationEndingDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(architectureFilesDateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getEducationQualification(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(educationQualification).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getEducationSubjects(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(educationSubjects).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getEducationCenter(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(educationCenter).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getEducationCenterType(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(educationCenterType).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getEducationLevel(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(educationLevel).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getLanguage(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(language).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getOtherLanguages(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(otherLanguages).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getMotherLanguage(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(motherLanguage).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getListening(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(listening).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getReading(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(reading).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getSpeakingInteraction(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(speakingInteraction).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getSpeakingExpression(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(speakingExpression).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getWritting(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(writting).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getSocialSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(socialSkills).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getOrganizationalSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(organizationalSkills).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getTechnicalSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(technicalSkills).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getComputerSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(computerSkills).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getArtisticSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(artisticSkills).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getOtherSkills(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(otherSkills).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getDrivingLicense(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try {
			return node.getProperty(drivingLicense).getString();
		} catch(Exception e) {
			return "";
		}
	}

	public String getAditionalInfo(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			return node.getProperty(aditionalInfo).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getAnnexes(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try {
			return node.getProperty(annexes).getValues().toString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public List<String> getRelatedFiles(Node node)  throws ValueFormatException, PathNotFoundException, RepositoryException{
		List<String> list = new ArrayList<String>();
		try {
			for(Value iterator : node.getProperty(relatedFiles).getValues()) {
				list.add(iterator.getString());
			}
		} catch(Exception e) {}
		return list;
	}

	@Override
	public RelatedFile getRelatedFile(Node node) throws Exception{
		RelatedFile related = new RelatedFile();
		try {
			related.setTitle(this.getName(node) + " " + this.getFirstSurname(node) + " " + this.getSecondSurname(node));
			related.setPhoto(this.getPhoto(node));
		} catch(Exception e) {}
		return related;
	}
	
	public String getDepartmentWebSiteFieldName() {
		return departmentWebSite;
	}
	
	public List<Property> validProperties(Node node, String field) throws PathNotFoundException, RepositoryException {
		List<Property> validProperties = new ArrayList<>();
		for (PropertyIterator iterator = node.getNode(field).getProperties(); iterator.hasNext();)
		{
			Property prop = (Property) iterator.next();
			try {
				if (Integer.valueOf(prop.getName()) != null) {
					System.out.println("Prop. type: " + PropertyUtil.getJCRPropertyType(prop) + "\n");
					System.out.println("Prop. name: " + prop.getName() + "\n");
					System.out.println("Prop. value: " + prop.getString() + "\n");
					validProperties.add(prop);
				}
			} catch (NumberFormatException e) {
				
			}
		}
		
		return validProperties;
	}
}
