package es.arquia.magnolia.utils;

import java.util.List;

import javax.jcr.Node;

public interface EventNodeUtil {
	public String getEventWrapperTitle(Node node);
	
	public String getTitle(Node node);
	
	public String getStandardText(Node node);
	
	public List<String> getFilesList(Node node);
	
	public String getStreamingLink(Node node);
	
	public List<String> getFacebookHashtags(Node node);
	
	public List<String> getTwitterHashtags(Node node);
}
