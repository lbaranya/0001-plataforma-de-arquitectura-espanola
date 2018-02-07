package es.arquia.magnolia.beans;

import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.authorshipDetail;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.authorshipName;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.authorshipType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.awardsAndDistinctions;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.conferences;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.courses;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.discussions;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.idOuvre;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.lastUpdateDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.listMedia;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.mediaDetail;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.mediaTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.mediaType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.notes;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.ouvreAbstract;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.ouvreTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.poster;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationEntity;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationLocation;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.previewPhoto;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.publishedInDirectory;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.relatedThought;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.startDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.typology;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormatDayOfWeek;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormatNumeric;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

import info.magnolia.context.MgnlContext;

public class ArchitectureFilesSupportReviewI {
	
	private String getLocalizedSuffix(String currentLanguage) {
    	if(!MgnlContext.getLocale().getLanguage().equals(currentLanguage))
			currentLanguage = "_" + currentLanguage;
		else
			currentLanguage = "";
    	return currentLanguage;
    }
	
	public String getIdOuvre(Node node) throws RepositoryException {
		try{
			Property tmp = node.getProperty(idOuvre);
			return tmp.getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getStartDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(startDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getStartDayOfWeek(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(startDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormatDayOfWeek, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getLastUpdateDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(lastUpdateDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getPublishedInDirectory(Node node) throws RepositoryException {
		try{
			Property tmp = node.getProperty(publishedInDirectory);
			return tmp.getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getOuvreTitle(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(ouvreTitle + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(ouvreTitle).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getPresentationDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(presentationDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormatNumeric, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getPresentationDateDayOfWeek(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(presentationDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormatDayOfWeek, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getPresentationLocation(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(presentationLocation + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(presentationLocation).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getPresentationEntity(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(presentationEntity + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(presentationEntity).getString();
			}catch(RepositoryException ex) {
				return "";
			}
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
	
	public String getNotes(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(notes + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(notes).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getTypology(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(typology + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(typology).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getConferences(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(conferences + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(conferences).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getDiscussions(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(discussions + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(discussions).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getPoster(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(poster + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(poster).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getCourses(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(courses + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(courses).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getAwardsAndDistinctions(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(awardsAndDistinctions + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(awardsAndDistinctions).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getRelatedThought(Node node) throws RepositoryException{
		try{
			Property tmp = node.getProperty(relatedThought);
			return tmp.getValues().toString();
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
	
	public Node getFirstMediaImage(Node node) throws RepositoryException{
		try{
			final String mediaTypeImage = "image";
			Node tmp = node.getNode(listMedia);
			NodeIterator it = tmp.getNodes();
			while (it.hasNext()) {
				Node auxNode = it.nextNode();
				if (auxNode.getProperty(mediaType).getString().equals(mediaTypeImage)) {
					return auxNode;
				}
			}
			return null;
		}catch(RepositoryException e) {
			return null;
		}
	}
	
	public String getMediaType(Node node, String currentLanguage) throws RepositoryException {
		try {
			Property tmp = node.getProperty(mediaType + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		} catch (RepositoryException e) {
			try {
				return node.getProperty(mediaType).getString();
			} catch (RepositoryException ex) {
				return "";
			}
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
	
	public String getMediaDetail(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(mediaDetail + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(mediaDetail).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}
	
	public String getMediaTitle(Node node, String currentLanguage) throws RepositoryException {
		try{
			Property tmp = node.getProperty(mediaTitle + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(mediaTitle).getString();
			}catch(RepositoryException ex) {
				return "";
			}
		}
	}	
}
