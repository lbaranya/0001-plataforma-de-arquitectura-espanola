package es.arquia.magnolia.utils;

import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.articleTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.authorshipDetail;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.authorshipName;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.authorshipType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.editor;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.idOuvre;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.lastUpdateDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.listMedia;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.mediaDetail;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.mediaTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.mediaType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.nodeTypeR4;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.notes;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.ouvreAbstract;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.ouvreTitle;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.ouvreTitleR4;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.place;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationEntity;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationLocation;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.previewPhoto;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.publishedInDirectory;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.relatedThought;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.startDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.typology;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.year;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormatDayOfWeek;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormatNumeric;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;

public class ArchitectureFilesSupportReviewImpl implements ArchitectureFilesSupportReview{
	
	private I18nContentSupport i18nContentSupport;
	
	@Inject
	public ArchitectureFilesSupportReviewImpl(final I18nContentSupport i18n) {
		this.i18nContentSupport = i18n;
	}
	
	private String getPropertyAsString(Node node, String property) {
		try {
			return i18nContentSupport.getProperty(node, property).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getIdOuvre(Node node) throws RepositoryException {
		return getPropertyAsString(node, idOuvre);
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
		return getPropertyAsString(node, publishedInDirectory);
	}
	
	public String getOuvreTitle(Node node) throws RepositoryException {
		if(!node.isNodeType(nodeTypeR4)) {
			return getPropertyAsString(node, ouvreTitle);
		}else {
			return getPropertyAsString(node, ouvreTitleR4);
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
	
	public String getPresentationLocation(Node node) throws RepositoryException {
		if(!node.isNodeType(nodeTypeR4)) {
			return getPropertyAsString(node, presentationLocation);
		}else {
			return getPlace(node);
		}
	}
	
	public String getPresentationEntity(Node node) throws RepositoryException {
		if(!node.isNodeType(nodeTypeR4)) {
			return getPropertyAsString(node, presentationEntity);
		}else {
			return getEditor(node);
		}
	}
	
	public String getOuvreAbstract(Node node) throws RepositoryException {
		if(!node.isNodeType(nodeTypeR4)) {
			return getPropertyAsString(node, ouvreAbstract);
		}
		return "";
	}
	
	public String getAuthorshipType(Node node) throws RepositoryException {
		return getPropertyAsString(node, authorshipType);
	}
	
	public String getAuthorshipName(Node node) throws RepositoryException {
		return getPropertyAsString(node, authorshipName);
	}
	
	public String getAuthorshipDetail(Node node) throws RepositoryException {
		return getPropertyAsString(node, authorshipDetail);
	}
	
	public String getNotes(Node node) throws RepositoryException {
		return getPropertyAsString(node, notes);
	}
	
	public String getTypology(Node node) throws RepositoryException {
		return getPropertyAsString(node, typology);
	}
	
	public String getRelatedThought(Node node) throws RepositoryException{
		return getPropertyAsString(node, relatedThought);
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
	
	public String getMediaType(Node node) throws RepositoryException {
		return getPropertyAsString(node, mediaType);
	}
	
	public String getPreviewPhoto(Node node) throws RepositoryException{
		return getPropertyAsString(node, previewPhoto);
	}
	
	public String getMediaDetail(Node node) throws RepositoryException {
		return getPropertyAsString(node, mediaDetail);
	}
	
	public String getMediaTitle(Node node) throws RepositoryException {
		return getPropertyAsString(node, mediaTitle);
	}

	@Override
	public String getArticleTitle(Node node) throws RepositoryException {
		if(node.isNodeType(nodeTypeR4)) {
			return getPropertyAsString(node, articleTitle);
		}
		return "";
	}

	@Override
	public String getPlace(Node node) throws RepositoryException {
		if(node.isNodeType(nodeTypeR4)) {
			return getPropertyAsString(node, place);
		}
		return "";
	}

	@Override
	public String getEditor(Node node) throws RepositoryException {
		if(node.isNodeType(nodeTypeR4)) {
			return getPropertyAsString(node, editor);
		}
		return "";
	}

	@Override
	public String getYear(Node node) throws RepositoryException {
		if(node.isNodeType(nodeTypeR4)) {
			return getPropertyAsString(node, year);
		}
		return "";
	}	
}
