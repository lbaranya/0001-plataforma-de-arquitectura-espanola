package es.arquia.magnolia.utils;

import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.ableToGetResource;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.authorshipDetails;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.authorshipList;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.authorshipName;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.authorshipSurname;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.authorshipType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.autonomousCommunity;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.autonomousCommunityAuthorOwnership;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.awardsAndDistinctions;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.buildedBy;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.contactEmail;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.contactPhone;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.country;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.countryAuthorOwnership;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.dischargeDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.galleryTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.lastUpdateDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.lattitude;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.linkExternalPage;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.listMedia;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.listRelatedThoughts;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.location;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.longitude;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.mainArchitect;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.mainArchitecturalType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.mainArchitecturalUse;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.mainTheme;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.mediaDetails;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.mediaTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.mediaType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.number;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.numberAuthorOwnership;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.otherReferences;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.photoPreview;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.postalCode;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.postalCodeAuthorOwnership;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.projectActualState;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.projectActualUse;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.projectFinishDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.projectId;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.projectStartDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.projectTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.projectType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.province;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.provinceAuthorOwnership;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.publishedDirectory;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.relatedThought;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.road;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.roadAuthorOwnership;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.squareMetersBuilded;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.squareMetersCost;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.supportTypology;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.temporalScope;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.territorialScope;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.town;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.townAuthorOwnership;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.typeOfRoad;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.typeOfRoadAuthorOwnership;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.workStartDate;
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

import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;

public class ArchitectureFilesSupportProjectImpl implements ArchitectureFilesSupportProject{
	
	@Inject
	private I18nContentSupport i18nContentSupport;
	
	private String getPropertyAsString(Node node, String property) {
		try {
			return i18nContentSupport.getProperty(node, property).getString();
		}catch(RepositoryException e) {
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
	
	private List<Property> validProperties(Node node, String field) throws RepositoryException {
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
	
	private String getPropertyAsDate(Node node, String property) {
		try {
			Calendar calendar = node.getProperty(property).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}

	@Override
	public String getProjectId(Node node) {
		
		return getPropertyAsString(node, projectId);
	}

	@Override
	public String getDischargeDate(Node node) {
		
		return getPropertyAsDate(node, dischargeDate);
	}

	@Override
	public String getLastUpdateDate(Node node) {
		
		return getPropertyAsDate(node, lastUpdateDate);
	}

	@Override
	public String getPublishedDirectory(Node node) {
		
		return getPropertyAsString(node, publishedDirectory);
	}

	@Override
	public String getProjectTitle(Node node) {
		
		return getPropertyAsString(node, projectTitle);
	}

	@Override
	public String getOtherReferences(Node node) {
		
		return getPropertyAsString(node, otherReferences);
	}

	@Override
	public String getProjectStartDate(Node node) {
		
		return getPropertyAsDate(node, projectStartDate);
	}

	@Override
	public String getWorkStartDate(Node node) {
		
		return getPropertyAsDate(node, workStartDate);
	}

	@Override
	public String getProjectFinishDate(Node node) {
		
		return getPropertyAsDate(node, projectFinishDate);
	}

	@Override
	public String getSquareMetersBuilded(Node node) {
		
		return getPropertyAsString(node, squareMetersBuilded);
	}

	@Override
	public String getSquareMetersCost(Node node) {
		
		return getPropertyAsString(node, squareMetersCost);
	}

	@Override
	public String getAwardsAndDistinctions(Node node) {
		
		return getPropertyAsString(node, awardsAndDistinctions);
	}

	@Override
	public String getTypeOfRoad(Node node) {
		
		return getPropertyAsString(node, typeOfRoad);
	}

	@Override
	public String getRoad(Node node) {
		
		return getPropertyAsString(node, road);
	}

	@Override
	public String getNumber(Node node) {
		
		return getPropertyAsString(node, number);
	}

	@Override
	public String getPostalCode(Node node) {
		
		return getPropertyAsString(node, postalCode);
	}

	@Override
	public String getLocation(Node node) {
		
		return getPropertyAsString(node, location);
	}

	@Override
	public String getTown(Node node) {
		
		return getPropertyAsString(node, town);
	}

	@Override
	public String getProvince(Node node) {
		
		return getPropertyAsString(node, province);
	}

	@Override
	public String getAutonomousCommunity(Node node) {
		
		return getPropertyAsString(node, autonomousCommunity);
	}

	@Override
	public String getCountry(Node node) {
		
		return getPropertyAsString(node, country);
	}

	@Override
	public String getLattitude(Node node) {
		
		return getPropertyAsString(node, lattitude);
	}

	@Override
	public String getLongitude(Node node) {
		
		return getPropertyAsString(node, longitude);
	}

	@Override
	public List<Node> getAuthorshipList(Node node) {
		
		return getPropertyAsListOfNodes(node, authorshipList);
	}

	@Override
	public String getAuthorshipType(Node node) {
		
		return getPropertyAsString(node, authorshipType);
	}

	@Override
	public String getAuthorshipName(Node node) {
		
		return getPropertyAsString(node, authorshipName);
	}

	@Override
	public String getAuthorshipSurname(Node node) {
		
		return getPropertyAsString(node, authorshipSurname);
	}

	@Override
	public String getAuthorshipDetails(Node node) {
		
		return getPropertyAsString(node, authorshipDetails);
	}

	@Override
	public String getSupportTypology(Node node) {
		
		return getPropertyAsString(node, supportTypology);
	}

	@Override
	public String getLinkExternalPage(Node node) {
		
		return getPropertyAsString(node, linkExternalPage);
	}

	@Override
	public String getIfAbleToGetResource(Node node) {
		
		return getPropertyAsString(node, ableToGetResource);
	}

	@Override
	public String getContactEmail(Node node) {
		
		return getPropertyAsString(node, contactEmail);
	}

	@Override
	public String getContactPhone(Node node) {
		
		return getPropertyAsString(node, contactPhone);
	}

	@Override
	public String getTypeOfRoadAuthorOwnership(Node node) {
		
		return getPropertyAsString(node, typeOfRoadAuthorOwnership);
	}

	@Override
	public String getRoadAuthorOwnership(Node node) {
		
		return getPropertyAsString(node, roadAuthorOwnership);
	}

	@Override
	public String getNumberAuthorOwnership(Node node) {
		
		return getPropertyAsString(node, numberAuthorOwnership);
	}

	@Override
	public String getTownAuthorOwnership(Node node) {
		
		return getPropertyAsString(node, townAuthorOwnership);
	}

	@Override
	public String getPostalCodeAuthorOwnership(Node node) {
		
		return getPropertyAsString(node, postalCodeAuthorOwnership);
	}

	@Override
	public String getProvinceAuthorOwnership(Node node) {
		
		return getPropertyAsString(node, provinceAuthorOwnership);
	}

	@Override
	public String getAutonomousCommunityAuthorOwnership(Node node) {
		
		return getPropertyAsString(node, autonomousCommunityAuthorOwnership);
	}

	@Override
	public String getCountryAuthorOwnership(Node node) {
		
		return getPropertyAsString(node, countryAuthorOwnership);
	}

	@Override
	public List<Node> getListRelatedThoughts(Node node) {
		
		return getPropertyAsListOfNodes(node, listRelatedThoughts);
	}

	@Override
	public String getRelatedThoughtPath(Node node) {
		
		return getPropertyAsString(node, relatedThought);
	}

	@Override
	public String getBuildedBy(Node node) {
		
		return getPropertyAsString(node, buildedBy);
	}

	@Override
	public String getProjectActualState(Node node) {
		
		return getPropertyAsString(node, projectActualState);
	}

	@Override
	public String getProjectActualUse(Node node) {
		
		return getPropertyAsString(node, projectActualUse);
	}

	@Override
	public String getProjectType(Node node) {
		
		return getPropertyAsString(node, projectType);
	}

	@Override
	public String getMainTheme(Node node) {
		
		return getPropertyAsString(node, mainTheme);
	}

	@Override
	public String getTemporalScope(Node node) {
		
		return getPropertyAsString(node, temporalScope);
	}

	@Override
	public String getTerritorialScope(Node node) {
		
		return getPropertyAsString(node, territorialScope);
	}

	@Override
	public String getMainArchitect(Node node) {
		
		return getPropertyAsString(node, mainArchitect);
	}

	@Override
	public String getMainArchitecturalType(Node node) {
		
		return getPropertyAsString(node, mainArchitecturalType);
	}

	@Override
	public String getMainArchitecturalUse(Node node) {
		
		return getPropertyAsString(node, mainArchitecturalUse);
	}

	@Override
	public List<Node> getListMedia(Node node) {
		
		return getPropertyAsListOfNodes(node, listMedia);
	}

	@Override
	public String getGalleryTitle(Node node) {
		
		return getPropertyAsString(node, galleryTitle);
	}

	@Override
	public String getMediaType(Node node) {
		
		return getPropertyAsString(node, mediaType);
	}

	@Override
	public String getPhotoPreview(Node node) {
		
		return getPropertyAsString(node, photoPreview);
	}

	@Override
	public String getMediaDetails(Node node) {
		
		return getPropertyAsString(node, mediaDetails);
	}

	@Override
	public String getMediaTitle(Node node) {
		
		return getPropertyAsString(node, mediaTitle);
	}

}
