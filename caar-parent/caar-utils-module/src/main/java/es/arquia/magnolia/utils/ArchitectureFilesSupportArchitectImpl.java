package es.arquia.magnolia.utils;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.aditionalInfo;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.annexes;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.artisticSkills;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.awardsAndDistinctions;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.biographicNews;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.birthCity;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.birthCountry;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.birthDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.certification;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.certificationCenter;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.certificationCountry;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.certificationYear;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.computerSkills;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.curriculum;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.deathCity;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.deathCountry;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.deathDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.departmentCity;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.departmentComponents;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.departmentCountry;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.departmentName;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.departmentWebSite;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.doctorate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.drivingLicense;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.educationCenter;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.educationCenterType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.educationEndingDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.educationLevel;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.educationList;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.educationQualification;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.educationStartDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.educationSubjects;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.firstSurname;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.language;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.listening;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.motherLanguage;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.name;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.organizationalSkills;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.otherLanguages;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.otherNames;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.otherSkills;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.otherStudies;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.photo;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.reading;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.relatedFiles;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.secondSurname;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.socialSkills;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.speakingExpression;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.speakingInteraction;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.technicalSkills;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.workExperienceBusinessName;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.workExperienceBusinessType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.workExperienceEndingDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.workExperienceList;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.workExperienceMainFunctions;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.workExperiencePositionOccupied;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.workExperienceStartDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.writting;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.manager.RelatedElementsManagerImpl;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeUtil;

public class ArchitectureFilesSupportArchitectImpl implements ArchitectureFilesSupportArchitect{
	
<<<<<<< HEAD:caar-parent/caar-utils-module/src/main/java/es/arquia/magnolia/beans/ArchitectureFilesSupportArchitect.java
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportArchitect.class);
	
	@Inject
	private RelatedElementsManagerImpl relatedElementsManagerImpl;
	
	public ArchitectureFilesSupportArchitect() {
		//Do nothing
	}
	
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
=======
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportArchitectImpl.class);
>>>>>>> CAAR0001-429:caar-parent/caar-utils-module/src/main/java/es/arquia/magnolia/utils/ArchitectureFilesSupportArchitectImpl.java
	
	public ArchitectureFilesSupportArchitectImpl() {}

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
	
	private List<Node> getPropertyAsListOfNodes(Node node, String property) {
		List<Node> listNodes = new ArrayList<>();
		try {
			for(NodeIterator iterator = node.getNodes(); iterator.hasNext();) {
				listNodes.add(iterator.nextNode());
			}
		}catch(RepositoryException e) {
			return listNodes;
		}
		return listNodes;
	}
	
	public List<Node> getRelatedElements(Node node) throws RepositoryException {
		return getPropertyAsListOfNodes(node, relatedFiles);
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
	
	public String getFullName(Node node) throws RepositoryException {
		return this.getName(node) + " " + this.getFirstSurname(node) + " " + this.getSecondSurname(node);
	}
}
