package es.arquia.magnolia.utils;

import static es.arquia.magnolia.constants.AnnouncementConstants.judgeCV;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgeFileLink;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgeListNameContains;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgeName;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgePhoto;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgeText;
import static es.arquia.magnolia.constants.AnnouncementConstants.media;
import static es.arquia.magnolia.constants.AnnouncementConstants.mediaImage;
import static es.arquia.magnolia.constants.AnnouncementConstants.mediaPosition;
import static es.arquia.magnolia.constants.AnnouncementConstants.mediaVideo;
import static es.arquia.magnolia.constants.AnnouncementConstants.nodeName;
import static es.arquia.magnolia.constants.AnnouncementConstants.sectionJuryAbstract;
import static es.arquia.magnolia.constants.AnnouncementConstants.sectionJuryIdAnchor;
import static es.arquia.magnolia.constants.AnnouncementConstants.sectionJuryImageAnchor;
import static es.arquia.magnolia.constants.AnnouncementConstants.sectionJuryTitle;
import static es.arquia.magnolia.constants.AnnouncementConstants.sectionJuryType;
import static es.arquia.magnolia.constants.AnnouncementConstants.sectionJuryWeight;
import static es.arquia.magnolia.constants.AnnouncementConstants.state;
import static es.arquia.magnolia.constants.AnnouncementConstants.text;
import static es.arquia.magnolia.constants.AnnouncementConstants.title;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.commons.lang3.StringUtils;

import es.arquia.magnolia.constants.AnnouncementConstants;
import es.arquia.magnolia.constants.UtilsConstants;
import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.jcr.util.PropertyUtil;
import info.magnolia.module.categorization.CategorizationModule;
import info.magnolia.repository.RepositoryConstants;

public class AnnouncementNodeUtilImpl implements AnnouncementNodeUtil {
	@Inject
	private I18nContentSupport i18nContentSupport;
	
	private String getPropertyAsI18nString(Node node, String property) {
		try {
			return i18nContentSupport.getProperty(node, property).getString();
		}catch(RepositoryException e) {
			return StringUtils.EMPTY;
		}
	}
	
	private List<Node> getSectionList(Node node, String sectionType) throws RepositoryException {
		List<Node> lemmaSectionsList = new ArrayList<>();
		
		NodeIterator iterator = node.getNodes();
		while(iterator.hasNext()) {
			Node iteratorTmp = iterator.nextNode();
			if(iteratorTmp.getName().contains(sectionType)) {
				lemmaSectionsList.add(iteratorTmp);
			}
		}
		
		return lemmaSectionsList;
	}
	
	public String getAnnouncementState(Node node) {
		
		Node categoryNode = null;
		
		try {
			
				Session categorizationWorkspaceSession = MgnlContext.getJCRSession(CategorizationModule.CATEGORIZATION_WORKSPACE);
					Session configWorkspaceSession = MgnlContext.getJCRSession(RepositoryConstants.CONFIG);
				String pathToAwardsAnnouncementPhasesCategories = PropertyUtil.getValueString(configWorkspaceSession.getProperty(AnnouncementConstants.jcrPropertyPathToAwardsAnnouncementPhasesCategoriesPathConstant));
				String announcementStateCategoryValue = PropertyUtil.getValueString(node.getProperty(state));
			categoryNode = categorizationWorkspaceSession.getNode(pathToAwardsAnnouncementPhasesCategories + "/" + announcementStateCategoryValue);
			
		} catch (RepositoryException e) {
			
			return StringUtils.EMPTY;
		}
		

		return getPropertyAsI18nString(categoryNode, UtilsConstants.CATEGORIES_DISPLAY_NAME_PROP);
	}
	
	public String getAnnouncementTitle(Node node){
		return getPropertyAsI18nString(node, title);
	}
	
	public String getAnnouncementText(Node node){
		return getPropertyAsI18nString(node, text);
	}
	
	public String getAnnouncementMediaType(Node node){
		return getPropertyAsI18nString(node, media);
	}
	
	public String getAnnouncementMediaImage(Node node){
		return getPropertyAsI18nString(node, mediaImage);
	}
	
	public String getAnnouncementMediaVideo(Node node){
		return getPropertyAsI18nString(node, mediaVideo);
	}
	
	public String getAnnouncementMediaPosition(Node node){
		return getPropertyAsI18nString(node, mediaPosition);
	}
	
	public List<Node> getAnnouncementRichTextSections(Node node) throws RepositoryException{
		return getSectionList(node, "rich");
	}
	
	public List<Node> getAnnouncementEnrollmentSections(Node node) throws RepositoryException{
		return getSectionList(node, "enrollment");
	}
	
	public List<Node> getAnnouncementLemmaSections(Node node) throws RepositoryException{
		return getSectionList(node, "lemma");
	}
	
	public Node createJuryNode(Node node) {
		Node juryTmp = null;
		try {
			if(node.hasNode(nodeName)) {
				node.getNode(nodeName).remove();
			}
		}catch(RepositoryException e) {
		}
		try {
			juryTmp = node.addNode(nodeName, NodeTypes.ContentNode.NAME);
			try{ juryTmp.setProperty(sectionJuryType, i18nContentSupport.getProperty(node,sectionJuryType).getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty(sectionJuryWeight, i18nContentSupport.getProperty(node,sectionJuryWeight).getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty(sectionJuryTitle, i18nContentSupport.getProperty(node,sectionJuryTitle).getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty(sectionJuryIdAnchor, i18nContentSupport.getProperty(node,sectionJuryIdAnchor).getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty(sectionJuryImageAnchor, i18nContentSupport.getProperty(node,sectionJuryImageAnchor).getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty(sectionJuryAbstract, i18nContentSupport.getProperty(node, sectionJuryAbstract).getValue());}catch(RepositoryException e2) {}
			NodeIterator iterator = node.getNodes();
			while(iterator.hasNext()) {
				Node tmpIteratorNode = iterator.nextNode();
				if(NodeUtil.getName(tmpIteratorNode).contains(judgeListNameContains)) {
					Node tmpJudgeList = juryTmp.addNode(tmpIteratorNode.getName(), NodeTypes.ContentNode.NAME);
					try{ tmpJudgeList.setProperty(judgeName, i18nContentSupport.getProperty(node.getNode(tmpIteratorNode.getName()),judgeName).getValue());}catch(RepositoryException e2) {}
					try{ tmpJudgeList.setProperty(judgePhoto, i18nContentSupport.getProperty(node.getNode(tmpIteratorNode.getName()),judgePhoto).getValue());}catch(RepositoryException e2) {}
					try{ tmpJudgeList.setProperty(judgeCV, i18nContentSupport.getProperty(node.getNode(tmpIteratorNode.getName()),judgeCV).getValue());}catch(RepositoryException e2) {}
					try{ tmpJudgeList.setProperty(judgeText, i18nContentSupport.getProperty(node.getNode(tmpIteratorNode.getName()),judgeText).getValue());}catch(RepositoryException e2) {}
					try{ tmpJudgeList.setProperty(judgeFileLink, i18nContentSupport.getProperty(node.getNode(tmpIteratorNode.getName()),judgeFileLink).getValue());}catch(RepositoryException e2) {}
				}
			}
			MgnlContext.getJCRSession(MgnlContext.getAggregationState().getRepository()).save();
		}catch(RepositoryException e1) {
			juryTmp = null;
		}
		return juryTmp;
	}
	
}
