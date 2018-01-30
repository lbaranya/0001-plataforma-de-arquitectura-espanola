package es.arquia.magnolia.beans;

import static es.arquia.magnolia.constants.NewsConstants.category;
import static es.arquia.magnolia.constants.NewsConstants.dateTime;
import static es.arquia.magnolia.constants.NewsConstants.descriptionLong;
import static es.arquia.magnolia.constants.NewsConstants.descriptionShort;
import static es.arquia.magnolia.constants.NewsConstants.files;
import static es.arquia.magnolia.constants.NewsConstants.headTitle;
import static es.arquia.magnolia.constants.NewsConstants.image;
import static es.arquia.magnolia.constants.NewsConstants.important;
import static es.arquia.magnolia.constants.NewsConstants.informativeMedium;
import static es.arquia.magnolia.constants.NewsConstants.longTitle;
import static es.arquia.magnolia.constants.NewsConstants.relatedNews;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import info.magnolia.context.MgnlContext;

public class News {
    
    private String getLocalizedSuffix(String currentLanguage) {
    	if(!MgnlContext.getLocale().getLanguage().equals(currentLanguage))
			currentLanguage = "_" + currentLanguage;
		else
			currentLanguage = "";
    	return currentLanguage;
    }
	
	public String getHeadline(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try{
			Property tmp = node.getProperty(headTitle + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(headTitle).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	public String getLongTitle(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try{
			Property tmp = node.getProperty(longTitle + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(longTitle).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	public String getDescription(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(descriptionShort + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(descriptionShort).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	public String getLongDescription(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(descriptionLong + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(descriptionLong).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	public String getDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(dateTime).getDate();
		Locale locale = MgnlContext.getAggregationState().getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getImage(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(image);
			return tmp.getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getCategories(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(category);
			return tmp.getValues().toString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getImportant(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(important);
			return tmp.getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getArchitectLinks(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(files);
			return tmp.getValues().toString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getRelatedNews(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(relatedNews);
			return tmp.getValues().toString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getMedium(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try{
			Property tmp = node.getProperty(informativeMedium + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(informativeMedium).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}

}
