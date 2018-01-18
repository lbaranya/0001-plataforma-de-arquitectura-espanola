package es.arquia.magnolia.beans;

import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.*;
import static es.arquia.magnolia.constants.NewsConstants.category;
import static es.arquia.magnolia.constants.NewsConstants.dateTime;
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

public class ArchitectureFilesSupportReviewI {
	
	private String getLocalizedSuffix(String currentLanguage) {
    	if(!MgnlContext.getLocale().getLanguage().equals(currentLanguage))
			currentLanguage = "_" + currentLanguage;
		else
			currentLanguage = "";
    	return currentLanguage;
    }
	
	public String getIdOuvre(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(idOuvre);
			return tmp.getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getStartDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		try {
			Calendar calendar = node.getProperty(startDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(Exception e) {
			return "";
		}
	}
	
	public String getHeadline(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try{
			Property tmp = node.getProperty(headline + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(headline).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	
	
	
	
	
	
}
