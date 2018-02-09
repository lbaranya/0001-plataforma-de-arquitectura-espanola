package es.arquia.magnolia.components.models.sections;

import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.judgeFileLink;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.judgeListNameContains;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.judgeName;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.judgePhoto;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.judgeText;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.nodeName;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.sectionJuryAbstract;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.sectionJuryIdAnchor;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.sectionJuryImageAnchor;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.sectionJuryTitle;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.sectionJuryType;
import static es.arquia.magnolia.components.models.sections.constants.DistributorSectionsAwardConstants.sectionJuryWeight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class DistributorSectionsAwardModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private List<Node> nodeArray;
	private List<Node> generalSortArray;
	
	@Inject
	private I18nContentSupport i18nContentSupport;

	public DistributorSectionsAwardModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) {
		super(content, definition, parent);
		nodeArray = new ArrayList<>();
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
	
	public boolean addToList(Node node) {
		nodeArray.add(node);
		return true;
	}
	
	public List<Node> sortWeightArray() throws Exception{
		generalSortArray = new ArrayList<>();
		// Include sub nodes list into a general sortable array
		for(Node iterator: nodeArray) {
			if(NodeUtil.getName(iterator).contains("richText")) {
					generalSortArray.add(iterator);
			}
			if(NodeUtil.getName(iterator).contains("jury")) {
					generalSortArray.add(iterator);
			}
			if(NodeUtil.getName(iterator).contains("lemma")) {
					generalSortArray.add(iterator);
			}
			if(NodeUtil.getName(iterator).contains("enrollment")) {
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
					weightOne = Integer.valueOf(o1.getProperty("richTextOptionWeight").getString());
				}catch(RepositoryException e) {
					try {
						weightOne = Integer.valueOf(o1.getProperty("juryOptionWeight").getString());
					}catch(RepositoryException e2) {
						try {
							weightOne = Integer.valueOf(o1.getProperty("lemmaOptionWeight").getString());
						}catch(RepositoryException e3) {
							try {
								weightOne = Integer.valueOf(o1.getProperty("enrollmentOptionWeight").getString());
							}catch(RepositoryException e4) {
								weightOne = 0;
							}
						}
					}
				}
				try {
					weightTwo = Integer.valueOf(o2.getProperty("richTextOptionWeight").getString());
				}catch(RepositoryException e) {
					try {
						weightTwo = Integer.valueOf(o2.getProperty("juryOptionWeight").getString());
					}catch(RepositoryException e2) {
						try {
							weightTwo = Integer.valueOf(o2.getProperty("lemmaOptionWeight").getString());
						}catch(RepositoryException e3) {
							try {
								weightTwo = Integer.valueOf(o2.getProperty("enrollmentOptionWeight").getString());
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
	
	public List<Node> getJuryList(Node content) throws RepositoryException{
		List<Node> juryList = new ArrayList<>();
		NodeIterator iterator = content.getNodes();
		while(iterator.hasNext()) {
			Node currentNode = iterator.nextNode();
			if(currentNode.getName().contains("judge")) {
				juryList.add(currentNode);
			}
		}
		return juryList;
	}
	
	public String getAnchorFromString(String str) {
		return str.replaceAll("\\W", "");
	}

}
