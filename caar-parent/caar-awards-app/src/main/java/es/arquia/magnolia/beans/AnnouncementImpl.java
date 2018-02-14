package es.arquia.magnolia.beans;

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

import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.jcr.util.NodeUtil;

public class AnnouncementImpl implements Announcement {
	
	private I18nContentSupport i18nContentSupport;
	
	@Inject
	public AnnouncementImpl(final I18nContentSupport i18nContentSupport) {
		this.i18nContentSupport = i18nContentSupport;
	}
	
	public String getAnnouncementState(Node node) throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, state).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAnnouncementTitle(Node node) throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, title).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAnnouncementText(Node node)throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, text).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAnnouncementMediaType(Node node)throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, media).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAnnouncementMediaImage(Node node)throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, mediaImage).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAnnouncementMediaVideo(Node node)throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, mediaVideo).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAnnouncementMediaPosition(Node node)throws RepositoryException{
		try {
			return i18nContentSupport.getProperty(node, mediaPosition).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public List<Node> getAnnouncementRichTextSections(Node node) throws RepositoryException{
		List<Node> richTextSectionsList = new ArrayList<>();
		
		NodeIterator iterator = node.getNodes();
		while(iterator.hasNext()) {
			Node iteratorTmp = iterator.nextNode();
			if(iteratorTmp.getName().contains("rich")) {
				richTextSectionsList.add(iteratorTmp);
			}
		}
		
		return richTextSectionsList;
	}
	
	public List<Node> getAnnouncementEnrollmentSections(Node node) throws RepositoryException{
		List<Node> enrollmentSectionsList = new ArrayList<>();
		
		NodeIterator iterator = node.getNodes();
		while(iterator.hasNext()) {
			Node iteratorTmp = iterator.nextNode();
			if(iteratorTmp.getName().contains("enrollment")) {
				enrollmentSectionsList.add(iteratorTmp);
			}
		}
		
		return enrollmentSectionsList;
	}
	
	public List<Node> getAnnouncementLemmaSections(Node node) throws RepositoryException{
		List<Node> lemmaSectionsList = new ArrayList<>();
		
		NodeIterator iterator = node.getNodes();
		while(iterator.hasNext()) {
			Node iteratorTmp = iterator.nextNode();
			if(iteratorTmp.getName().contains("lemma")) {
				lemmaSectionsList.add(iteratorTmp);
			}
		}
		
		return lemmaSectionsList;
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
	
	// TODO: Metodos para obtener las propiedades de cada seccion

}
