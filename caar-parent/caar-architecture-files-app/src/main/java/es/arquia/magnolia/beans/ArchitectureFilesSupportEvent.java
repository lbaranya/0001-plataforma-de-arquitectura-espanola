package es.arquia.magnolia.beans;

import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.authorshipDetail;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.authorshipInfo;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.authorshipName;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.authorshipType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.listMedia;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.ouvreAbstract;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.ouvreTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationEndingDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationLocation;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationStartDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.price;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.website;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormatDayOfWeek;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;

import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;

public class ArchitectureFilesSupportEvent {
	
	@Inject
	private I18nContentSupport i18nContentSupport;
	
	public String getOuvreTitle(Node node) throws RepositoryException {
		try{
			return i18nContentSupport.getProperty(node, ouvreTitle).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getPresentationStartDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(presentationStartDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getStartDayOfWeek(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(presentationStartDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormatDayOfWeek, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getPresentationLocation(Node node) throws RepositoryException {
		try{
			Property tmp = node.getProperty(presentationLocation);
			return tmp.getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getOuvreAbstract(Node node) throws RepositoryException {
		try{
			return i18nContentSupport.getProperty(node, ouvreAbstract).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getPresentationEndingDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(presentationEndingDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getPrice(Node node) throws RepositoryException {
		try{
			Property tmp = node.getProperty(price);
			return tmp.getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getWebsite(Node node) throws RepositoryException {
		try{
			Property tmp = node.getProperty(website);
			return tmp.getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAuthorshipType(Node node) throws RepositoryException {
		try{
			return i18nContentSupport.getProperty(node, authorshipType).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAuthorshipName(Node node) throws RepositoryException {
		try{
			return i18nContentSupport.getProperty(node, authorshipName).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAuthorshipDetail(Node node) throws RepositoryException {
		try{
			return i18nContentSupport.getProperty(node, authorshipDetail).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAuthorshipInfo(Node node) throws RepositoryException {
		try{
			return i18nContentSupport.getProperty(node, authorshipInfo).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public List<Node> getListMedia(Node node) throws RepositoryException{
		List<Node> nodeList = new ArrayList<Node>();
		try{
			Node tmp = node.getNode(listMedia);
			return (List<Node>) tmp.getNodes();
		}catch(RepositoryException e) {
			return nodeList;
		}
	}
	
	public String getPreviewPhoto(Node node) throws RepositoryException{
		try{
			for (PropertyIterator iterator = node.getNode(listMedia).getProperties(); iterator.hasNext();)
			{
				Property prop = (Property) iterator.next();
				try {
					// If property name is an integer, that means it's not a Magnolia property but a list element
					if (Integer.valueOf(prop.getName()) != null) {
						String nodeId = prop.getValue().getString();
						return nodeId;
					}
				} catch (NumberFormatException e) {
					
				}
			}
			return null;
		}catch(RepositoryException e) {
			return null;
		}
	}
}
