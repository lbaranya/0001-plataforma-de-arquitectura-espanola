package es.arquia.magnolia.beans;

import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.authorshipDetail;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.authorshipInfo;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.authorshipName;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.authorshipType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.listMedia;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.ouvreAbstract;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationEndingDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationLocation;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationStartDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.previewPhoto;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.price;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.title;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.website;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

import info.magnolia.context.MgnlContext;

public class ArchitectureFilesSupportEvent {
	
	private String getLocalizedSuffix(String currentLanguage) {
    	if(!MgnlContext.getLocale().getLanguage().equals(currentLanguage))
			currentLanguage = "_" + currentLanguage;
		else
			currentLanguage = "";
    	return currentLanguage;
    }
	
	public String getTitle(Node node) throws RepositoryException {
		try{
			Property tmp = node.getProperty(title);
			return tmp.getString();
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
	
	public String getPresentationLocation(Node node) throws RepositoryException {
		try{
			Property tmp = node.getProperty(presentationLocation);
			return tmp.getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getOuvreAbstract(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(ouvreAbstract + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(ouvreAbstract).getString();
			}catch(RepositoryException ex) {
				return "";
			}
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
	
	public String getAuthorshipType(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(authorshipType + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(authorshipType).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getAuthorshipName(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(authorshipName + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(authorshipName).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getAuthorshipDetail(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(authorshipDetail + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(authorshipDetail).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getAuthorshipInfo(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(authorshipInfo + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(authorshipInfo).getString();
			}catch(RepositoryException ex) {
				return "";
			}
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
			Property tmp = node.getProperty(previewPhoto);
			return tmp.getString();
		}catch(RepositoryException e) {
			return "";
		}
	}	
}
