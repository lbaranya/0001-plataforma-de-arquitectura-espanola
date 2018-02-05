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
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;

public class NewsImpl implements News{

	private I18nContentSupport i18nContentSupport;
	
	@Inject
	public NewsImpl(final I18nContentSupport i18nContentSupport) {
		this.i18nContentSupport = i18nContentSupport;
	}

	public String getHeadline(Node node) throws RepositoryException {
		try{
			return i18nContentSupport.getProperty(node, headTitle).getString();
		}catch(Exception e) {
			return "";
		}
	}

	public String getLongTitle(Node node) throws RepositoryException {
		try{
			return i18nContentSupport.getProperty(node, longTitle).getString();
		}catch(Exception e) {
			return "";
		}
	}

	public String getDescription(Node node) throws RepositoryException{
		try{
			return i18nContentSupport.getProperty(node, descriptionShort).getString();
		}catch(Exception e) {
			return "";
		}
	}

	public String getLongDescription(Node node) throws RepositoryException{
		try{
			return i18nContentSupport.getProperty(node, descriptionLong).getString();
		}catch(Exception e) {
			return "";
		}
	}

	public String getDate(Node node) throws RepositoryException {
		Calendar calendar = node.getProperty(dateTime).getDate();
		Locale locale = MgnlContext.getAggregationState().getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}

	public String getImage(Node node) throws RepositoryException{
		try{
			Property tmp = node.getProperty(image);
			return tmp.getString();
		}catch(Exception e) {
			return "";
		}
	}

	public String getCategories(Node node) throws RepositoryException{
		try{
			Property tmp = node.getProperty(category);
			return Arrays.toString(tmp.getValues());
		}catch(Exception e) {
			return "";
		}
	}

	public String getImportant(Node node) throws RepositoryException{
		try{
			Property tmp = node.getProperty(important);
			return tmp.getString();
		}catch(Exception e) {
			return "";
		}
	}

	public String getArchitectLinks(Node node) throws RepositoryException{
		try{
			Property tmp = node.getProperty(files);
			return Arrays.toString(tmp.getValues());
		}catch(Exception e) {
			return "";
		}
	}

	public String getRelatedNews(Node node) throws RepositoryException{
		try{
			Property tmp = node.getProperty(relatedNews);
			return Arrays.toString(tmp.getValues());
		}catch(Exception e) {
			return "";
		}
	}

	public String getMedium(Node node, String currentLanguage) throws RepositoryException{
		try{
			return i18nContentSupport.getProperty(node, informativeMedium).getString();
		}catch(Exception e) {
			return "";
		}
	}

}