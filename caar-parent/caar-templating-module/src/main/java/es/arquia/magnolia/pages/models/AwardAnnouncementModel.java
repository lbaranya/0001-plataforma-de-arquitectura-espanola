package es.arquia.magnolia.pages.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.apache.commons.lang3.StringUtils;

import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.utils.AnnouncementNodeUtil;
import es.arquia.magnolia.utils.AwardNodeUtil;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

import static es.arquia.magnolia.constants.AnnouncementConstants.nodeNameContainsEnrollment;
import static es.arquia.magnolia.constants.AnnouncementConstants.nodeNameContainsJury;
import static es.arquia.magnolia.constants.AnnouncementConstants.nodeNameContainsLemma;
import static es.arquia.magnolia.constants.AnnouncementConstants.nodeNameContainsRich;
import static es.arquia.magnolia.constants.AnnouncementConstants.enrollmentOptionWeight;
import static es.arquia.magnolia.constants.AnnouncementConstants.juryOptionWeight;
import static es.arquia.magnolia.constants.AnnouncementConstants.lemmaOptionWeight;
import static es.arquia.magnolia.constants.AnnouncementConstants.richTextOptionWeight;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgeListNameContains;

public class AwardAnnouncementModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;
	
	private List<Node> nodeArray;
	private List<Node> generalSortArray;
	
	@Inject
	public AwardAnnouncementModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager) {
		super(content, definition, parent);
		this.awardManager = awardManager;
		nodeArray = new ArrayList<>();
	}
	
	public AnnouncementNodeUtil getAnnouncementInstance() {
		return awardManager.getAnnouncementInstance();
	}
	
	public AwardNodeUtil getInstance() {
		return awardManager.getInstance();
	}
	
	// Sections sort
	
	public boolean addToList(Node node) {
		nodeArray.add(node);
		return true;
	}
	
	public List<Node> sortWeightArray() throws Exception{
		generalSortArray = new ArrayList<>();
		// Include sub nodes list into a general sortable array
		for(Node iterator: nodeArray) {
			if(NodeUtil.getName(iterator).contains(nodeNameContainsRich)) {
					generalSortArray.add(iterator);
			}
			if(NodeUtil.getName(iterator).contains(nodeNameContainsJury)) {
					generalSortArray.add(iterator);
			}
			if(NodeUtil.getName(iterator).contains(nodeNameContainsLemma)) {
					generalSortArray.add(iterator);
			}
			if(NodeUtil.getName(iterator).contains(nodeNameContainsEnrollment)) {
					generalSortArray.add(iterator);
			}
		}
		// Sort the general sortable array
		generalSortArray.sort(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				Integer weightOne;
				Integer weightTwo;
				try {
					weightOne = Integer.valueOf(o1.getProperty(richTextOptionWeight).getString());
				}catch(RepositoryException e) {
					try {
						weightOne = Integer.valueOf(o1.getProperty(juryOptionWeight).getString());
					}catch(RepositoryException e2) {
						try {
							weightOne = Integer.valueOf(o1.getProperty(lemmaOptionWeight).getString());
						}catch(RepositoryException e3) {
							try {
								weightOne = Integer.valueOf(o1.getProperty(enrollmentOptionWeight).getString());
							}catch(RepositoryException e4) {
								weightOne = 0;
							}
						}
					}
				}
				try {
					weightTwo = Integer.valueOf(o2.getProperty(richTextOptionWeight).getString());
				}catch(RepositoryException e) {
					try {
						weightTwo = Integer.valueOf(o2.getProperty(juryOptionWeight).getString());
					}catch(RepositoryException e2) {
						try {
							weightTwo = Integer.valueOf(o2.getProperty(lemmaOptionWeight).getString());
						}catch(RepositoryException e3) {
							try {
								weightTwo = Integer.valueOf(o2.getProperty(enrollmentOptionWeight).getString());
							}catch(RepositoryException e4) {
								weightTwo = 0;
							}
						}
					}
				}
				return weightOne.compareTo(weightTwo);
			}
			
		});
		return generalSortArray;
	}
	
	public String getAnchorFromString(String str) {
		if(StringUtils.isBlank(str))
			return "";
		return str.replaceAll("\\W", "");
	}
	
	public List<Node> getJuryList(Node content) throws RepositoryException{
		List<Node> juryList = new ArrayList<>();
		NodeIterator iterator = content.getNodes();
		while(iterator.hasNext()) {
			Node currentNode = iterator.nextNode();
			if(currentNode.getName().contains(judgeListNameContains)) {
				juryList.add(currentNode);
			}
		}
		return juryList;
	}
}
