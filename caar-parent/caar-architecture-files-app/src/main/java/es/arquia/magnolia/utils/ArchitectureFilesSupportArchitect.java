package es.arquia.magnolia.utils;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.RelatedElement;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.predicate.AbstractPredicate;
import info.magnolia.jcr.util.NodeUtil;

public class ArchitectureFilesSupportArchitect {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportArchitect.class);

	private static String name = "FS1_1_1";
	private static String firstSurname = "FS1_1_2";
	private static String secondSurname = "FS1_1_3";
	private static String otherNames = "FS1_1_4";
	private static String photo = "FS1_1_5";
	private static String birthDate = "FS1_1_6";
	private static String birthCity = "FS1_1_7";
	private static String birthCountry = "FS1_1_8";
	
	private static String deathDate = "FS1_1_9_1";
	private static String deathCity = "FS1_1_9_2";
	private static String deathCountry = "FS1_1_9_3";
	
	private static String certification = "FS1_2_1";
	private static String certificationCenter = "FS1_2_2";
	private static String certificationCountry = "FS1_2_3";
	private static String certificationYear = "FS1_2_4";
	private static String otherStudies = "FS1_2_5";
	private static String doctorate = "FS1_2_6";
	
	private static String departmentName = "FS1_3_1";
	private static String departmentWebSite = "FS1_3_2";
	private static String departmentCity = "FS1_3_3";
	private static String departmentCountry = "FS1_3_4";
	private static String departmentComponents = "FS1_3_5";
	private static String biographicNews = "FS1_3_6";
	private static String curriculum = "FS1_3_7";
	private static String awardsAndDistinctions = "FS1_3_8";
	
	private static String workExperienceList = "listExperience";
	private static String workExperienceStartDate = "FS1_4_1";
	private static String workExperienceEndingDate = "FS1_4_2";
	private static String workExperiencePositionOccupied = "FS1_4_3";
	private static String workExperienceMainFunctions = "FS1_4_4";
	private static String workExperienceBusinessName = "FS1_4_5";
	private static String workExperienceBusinessType = "FS1_4_6";
	
	private static String educationList = "listEducation";
	private static String educationStartDate = "FS1_5_1";
	private static String educationEndingDate = "FS1_5_2";
	private static String educationQualification = "FS1_5_3";
	private static String educationSubjects = "FS1_5_4";
	private static String educationCenter = "FS1_5_5";
	private static String educationCenterType = "FS1_5_6";
	private static String educationLevel = "FS1_5_7";
	
	private static String language = "FS1_6_1";
	private static String otherLanguages = "FS1_6_2";
	private static String motherLanguage = "FS1_6_3";
	private static String listening = "FS1_6_4";
	private static String reading = "FS1_6_5";
	private static String speakingInteraction = "FS1_6_6";
	private static String speakingExpression = "FS1_6_7";
	private static String writting = "FS1_6_8";
	
	private static String socialSkills = "FS1_7_1";
	private static String organizationalSkills = "FS1_7_2";
	private static String technicalSkills = "FS1_7_3";
	private static String computerSkills = "FS1_7_4";
	private static String artisticSkills = "FS1_7_5";
	private static String otherSkills = "FS1_7_6";
	private static String drivingLicense = "FS1_7_7";
	
	private static String aditionalInfo = "FS1_8_1";
	private static String annexes = "FS1_8_2";
	
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
	

	public String getName(Node node) throws RepositoryException {
		try {
			return node.getProperty(name).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getFirstSurname(Node node) throws RepositoryException {
		try {
			return node.getProperty(firstSurname).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getSecondSurname(Node node) throws RepositoryException {
		try {
			return node.getProperty(secondSurname).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getOtherNames(Node node) throws RepositoryException {
		try {
			return node.getProperty(otherNames).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getPhoto(Node node) throws RepositoryException {
		try {
			return node.getProperty(photo).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getBirthDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(birthDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getBirthCity(Node node) throws RepositoryException {
		try {
			return node.getProperty(birthCity).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getBirthCountry(Node node) throws RepositoryException {
		try {
			return node.getProperty(birthCountry).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDeathDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(deathDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDeathCity(Node node) throws RepositoryException {
		try {
			return node.getProperty(deathCity).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDeathCountry(Node node) throws RepositoryException {
		try {
			return node.getProperty(deathCountry).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getCertification(Node node) throws RepositoryException {
		try {
			return node.getProperty(certification).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getCertificationCenter(Node node) throws RepositoryException {
		try {
			return node.getProperty(certificationCenter).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getCertificatoinCountry(Node node) throws RepositoryException {
		try {
			return node.getProperty(certificationCountry).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getCertificationYear(Node node) throws RepositoryException {
		try {
			return node.getProperty(certificationYear).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getOtherStudies(Node node) throws RepositoryException {
		try {
			return node.getProperty(otherStudies).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDoctorate(Node node) throws RepositoryException {
		try {
			return node.getProperty(doctorate).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDepartmentName(Node node) throws RepositoryException {
		try {	
			return node.getProperty(departmentName).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDepartmentWebSite(Node node) throws RepositoryException {
		try {
			return node.getProperty(departmentWebSite).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDepartmentCity(Node node) throws RepositoryException {
		try {
			return node.getProperty(departmentCity).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDepartmentCountry(Node node) throws RepositoryException {
		try {
			return node.getProperty(departmentCountry).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public List<String> getDepartmentComponents(Node node) throws RepositoryException {
		List<String> list = new ArrayList<>();
		try {
			for(Value iterator : node.getProperty(departmentComponents).getValues()) {
				list.add(iterator.getString());
			}
		} catch(RepositoryException e) {}
		return list;
	}
	
	public String getConcatenatedDepartmentComponents(Node node) throws RepositoryException {
		try {
			String result = "";
			List<Property> properties = validProperties(node, departmentComponents);
			Session session = MgnlContext.getJCRSession(architectureFilesWorkspace);
			for (Property iterator : properties)
			{
				Node componentNode = session.getNode(iterator.getValue().getString());
				result += getName(componentNode) + " " + getFirstSurname(componentNode) + " " + getSecondSurname(componentNode) + ", ";
			}
			if (result.equals("")) {
				return "";
			} else {
				return result.substring(0, result.length()-2);
			}
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getBiographicNews(Node node) throws RepositoryException {
		try {
			return node.getProperty(biographicNews).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getCurriculum(Node node) throws RepositoryException {
		try {
			return node.getProperty(curriculum).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardsAndDistinctions(Node node) throws RepositoryException {
		try {
			return node.getProperty(awardsAndDistinctions).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getWorkingExperienceStartDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(workExperienceStartDate).getDate();
			Locale locale = MgnlContext.getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}

	public List<Node> getWorkExperienceList(Node node) throws RepositoryException {
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
		} catch(RepositoryException e) {}
		return list;
	}
	
	public String getWorkExperienceStartDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(workExperienceStartDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getWorkExperienceEndingDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(workExperienceEndingDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getWorkExperiencePositionOccupied(Node node) throws RepositoryException {
		try {
			return node.getProperty(workExperiencePositionOccupied).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getWorkExperienceMainFunctions(Node node) throws RepositoryException {
		try {
			return node.getProperty(workExperienceMainFunctions).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getWorkExperienceBusinessName(Node node) throws RepositoryException {
		try {
			return node.getProperty(workExperienceBusinessName).getString();
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getWorkExperienceBusinessType(Node node) throws RepositoryException {
		try {
			return node.getProperty(workExperienceBusinessType).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public List<Node> getEducationList(Node node) throws RepositoryException {
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
		} catch(RepositoryException e) {}
		return list;
	}
	
	public String getEducationStartDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(educationStartDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getEducationEndingDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(educationEndingDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getEducationQualification(Node node) throws RepositoryException {
		try {
			return node.getProperty(educationQualification).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getEducationSubjects(Node node) throws RepositoryException {
		try {
			return node.getProperty(educationSubjects).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getEducationCenter(Node node) throws RepositoryException {
		try {
			return node.getProperty(educationCenter).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getEducationCenterType(Node node) throws RepositoryException {
		try {
			return node.getProperty(educationCenterType).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getEducationLevel(Node node) throws RepositoryException {
		try {
			return node.getProperty(educationLevel).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getLanguage(Node node) throws RepositoryException {
		try {
			return node.getProperty(language).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getOtherLanguages(Node node) throws RepositoryException {
		try {
			return node.getProperty(otherLanguages).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getMotherLanguage(Node node) throws RepositoryException {
		try {
			return node.getProperty(motherLanguage).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getListening(Node node) throws RepositoryException {
		try {
			return node.getProperty(listening).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getReading(Node node) throws RepositoryException {
		try {
			return node.getProperty(reading).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getSpeakingInteraction(Node node) throws RepositoryException {
		try {
			return node.getProperty(speakingInteraction).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getSpeakingExpression(Node node) throws RepositoryException {
		try {
			return node.getProperty(speakingExpression).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getWritting(Node node) throws RepositoryException {
		try {
			return node.getProperty(writting).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getSocialSkills(Node node) throws RepositoryException {
		try {
			return node.getProperty(socialSkills).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getOrganizationalSkills(Node node) throws RepositoryException {
		try {
			return node.getProperty(organizationalSkills).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getTechnicalSkills(Node node) throws RepositoryException {
		try {
			return node.getProperty(technicalSkills).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getComputerSkills(Node node) throws RepositoryException {
		try {
			return node.getProperty(computerSkills).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getArtisticSkills(Node node) throws RepositoryException {
		try {
			return node.getProperty(artisticSkills).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getOtherSkills(Node node) throws RepositoryException {
		try {
			return node.getProperty(otherSkills).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getDrivingLicense(Node node) throws RepositoryException {
		try {
			return node.getProperty(drivingLicense).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}

	public String getAditionalInfo(Node node) throws RepositoryException {
		try {
			return node.getProperty(aditionalInfo).getString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAnnexes(Node node) throws RepositoryException {
		try {
			return node.getProperty(annexes).getValues().toString();
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public List<RelatedElement> getRelatedElements(Node node)  throws RepositoryException {
		
		List<RelatedElement> list = new ArrayList<>();
		Value[] relatedValues = node.getProperty(relatedFiles).getValues();
		for (Value currentValue : relatedValues) {
			
			Node tmpNode = MgnlContext.getJCRSession(architectureFilesWorkspace).getNode(currentValue.getString());
			list.add(this.getRelatedElement(tmpNode));
		}
		
		return list;
	}

	public RelatedElement getRelatedElement(Node node) throws RepositoryException {
		
		RelatedElement related = new RelatedElement();

		related.setTitle(this.getName(node) + " " + this.getFirstSurname(node) + " " + this.getSecondSurname(node));
		related.setPhoto(this.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		
		return related;
	}
	
	public String getDepartmentWebSiteFieldName() {
		return departmentWebSite;
	}
	
	public List<Property> validProperties(Node node, String field) throws RepositoryException {
		List<Property> validProperties = new ArrayList<>();
		for (PropertyIterator iterator = node.getNode(field).getProperties(); iterator.hasNext();)
		{
			Property prop = (Property) iterator.next();
			try {
				if (Integer.valueOf(prop.getName()) != null) {
					validProperties.add(prop);
				}
			} catch (NumberFormatException e) {
				
			}
		}
		
		return validProperties;
	}
}
