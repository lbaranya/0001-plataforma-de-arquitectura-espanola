package es.arquia.magnolia.utils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import static es.arquia.magnolia.constants.AwardConstants.*;

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
			Value[] tmpValues = i18nContentSupport.getProperty(node, property).getValues();
			for(int i = 0; i < tmpValues.length; ++i) {
				listString.add(tmpValues[i].getString());
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
	
	public List<String> getFacebookHashtags(Node node) {
		return getPropertyAsListOfString(node, facebookHashtagsList);
	}
	
	public List<String> getTwitterHashtags(Node node) {
		return getPropertyAsListOfString(node, twitterHashtagsList);
	}
	
	
}
