package es.arquia.magnolia.utils;

import static es.arquia.magnolia.constants.AwardConstants.awardWorkspace;
import static es.arquia.magnolia.constants.AwardConstants.awardAboutText;
import static es.arquia.magnolia.constants.AwardConstants.awardDescription;
import static es.arquia.magnolia.constants.AwardConstants.awardExternalURL;
import static es.arquia.magnolia.constants.AwardConstants.awardExternalURLText;
import static es.arquia.magnolia.constants.AwardConstants.awardHeaderBackground;
import static es.arquia.magnolia.constants.AwardConstants.awardLogo;
import static es.arquia.magnolia.constants.AwardConstants.awardName;
import static es.arquia.magnolia.constants.AwardConstants.categoriesList;
import static es.arquia.magnolia.constants.AwardConstants.editionState;
import static es.arquia.magnolia.constants.AwardConstants.editionAnnouncementButtonText;
import static es.arquia.magnolia.constants.AwardConstants.editionEnrollmentButtonText;
import static es.arquia.magnolia.constants.AwardConstants.editionNodeType;
import static es.arquia.magnolia.constants.AwardConstants.relatedNewsList;
import static es.arquia.magnolia.constants.AwardConstants.type;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.manager.RelatedElementsManagerImpl;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;

public class AwardNodeUtilImpl implements AwardNodeUtil{
	
	private I18nContentSupport i18nContentSupport;

	
	@Inject
	public AwardNodeUtilImpl(final I18nContentSupport i18nContentSupport) {
		this.i18nContentSupport = i18nContentSupport;
	}
	
	private static final Logger log = LoggerFactory.getLogger(AwardNodeUtilImpl.class);
	
	public String getType(Node node) throws RepositoryException{
		try {
			return node.getProperty(type).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardName(Node node) throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, awardName).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardDescription(Node node) throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, awardDescription).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardLogo(Node node) throws RepositoryException{
		try {
			return node.getProperty(awardLogo).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardExternalURL(Node node) throws RepositoryException{
		try {
			return node.getProperty(awardExternalURL).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardExternalURLText(Node node) throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node,awardExternalURLText).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardHeaderBackground(Node node) throws RepositoryException{
		try {
			return node.getProperty(awardHeaderBackground).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardAboutText(Node node) throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, awardAboutText).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public List<String> getAwardCategoriesList(Node node) throws RepositoryException{
		try{
			List<String> finalList = new ArrayList<>();
			Value[] valuesList = node.getProperty(categoriesList).getValues();
			for (Value value : valuesList) {
				finalList.add(value.getString());
			}
			return finalList;
		}catch(Exception e) {
			return null;
		}
	}
	
	public String getEditionAnnouncementButtonText(Node node) throws RepositoryException{
		if(node.isNodeType(editionNodeType)) {
			try {
				return i18nContentSupport.getProperty(node, editionAnnouncementButtonText).getString();
			}catch(RepositoryException e) {
				return "";
			}
		}else {
			return "";
		}
	}
	
	public String getEditionEnrollmentButtonText(Node node) throws RepositoryException{
		if(node.isNodeType(editionNodeType)) {
			try {
				return i18nContentSupport.getProperty(node, editionEnrollmentButtonText).getString();
			}catch(RepositoryException e) {
				return "";
			}
		}else {
			return "";
		}
	}
	
	
	@Override
	public String getEditionState(Node node) throws RepositoryException {
		if(node.isNodeType(editionNodeType)) {
			try {
				return i18nContentSupport.getProperty(node, editionState).getString();
			}catch(RepositoryException e) {
				return "";
			}
		}else {
			return "";
		}
	}

	@Override
	public List<Node> getRelatedElements(Node node) throws RepositoryException {
		return null;
	}
}
