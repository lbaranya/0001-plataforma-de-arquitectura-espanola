package es.arquia.magnolia.utils;

import static es.arquia.magnolia.constants.AwardConstants.eventTitle;
import static es.arquia.magnolia.constants.AwardConstants.eventWrapperNodeType;
import static es.arquia.magnolia.constants.AwardConstants.eventWrapperTitle;
import static es.arquia.magnolia.constants.AwardConstants.filesList;
import static es.arquia.magnolia.constants.AwardConstants.liveEventNodeType;
import static es.arquia.magnolia.constants.AwardConstants.standardEventNodeType;
import static es.arquia.magnolia.constants.AwardConstants.standardEventText;
import static es.arquia.magnolia.constants.AwardConstants.streamingLink;
import static es.arquia.magnolia.constants.AwardConstants.twitterHashtagsList;
import static es.arquia.magnolia.constants.AwardConstants.facebookUser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;

import info.magnolia.cms.i18n.I18nContentSupport;

public class EventNodeUtilImpl implements EventNodeUtil {
	@Inject
	private I18nContentSupport i18nContentSupport;
	
	private String getPropertyAsString(Node node, String property) {
		try {
			return i18nContentSupport.getProperty(node, property).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	private List<String> getPropertyAsListOfString(Node node, String property) {
		List<String> listString = new ArrayList<>();
		try {
			List<Property> tmpNoSystemProperties = validProperties(node, property);
			for(Iterator<Property> iterator = tmpNoSystemProperties.iterator(); iterator.hasNext();) {
				listString.add(iterator.next().getString());
			}
		}catch(RepositoryException e) {
			return listString;
		}
		return listString;
	}
	
	private String fromEventWrapperAsString(Node node, String property) {
		try {
			if(node.isNodeType(eventWrapperNodeType)) {
				return getPropertyAsString(node, property);
			}else {
				return "";
			}
		} catch (RepositoryException e) {
			return "";
		}
	}
	
	private String fromStandardEventAsString(Node node, String property) {
		try {
			if(node.isNodeType(standardEventNodeType)) {
				return getPropertyAsString(node, property);
			}else {
				return "";
			}
		} catch (RepositoryException e) {
			return "";
		}
	}
	
	private String fromLiveEventAsString(Node node, String property) {
		try {
			if(node.isNodeType(liveEventNodeType)) {
				return getPropertyAsString(node, property);
			}else {
				return "";
			}
		} catch (RepositoryException e) {
			return "";
		}
	}
	
	public String getEventWrapperTitle(Node node) {
		return fromEventWrapperAsString(node, eventWrapperTitle);
	}
	
	public String getTitle(Node node) {
		return getPropertyAsString(node, eventTitle);
	}
	
	public String getStandardText(Node node) {
		return fromStandardEventAsString(node, standardEventText);
	}
	
	public List<String> getFilesList(Node node){
		return getPropertyAsListOfString(node, filesList);
	}
	
	public String getStreamingLink(Node node) {
		return fromLiveEventAsString(node, streamingLink);
	}
	
	public String getFacebookUser(Node node) {
		return fromLiveEventAsString(node, facebookUser);
	}
	
	public List<String> getTwitterHashtags(Node node) {
		return getPropertyAsListOfString(node, twitterHashtagsList);
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
	
}
