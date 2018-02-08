package es.arquia.magnolia.components.models.sections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.jcr.ItemExistsException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class DistributorSectionsAwardModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private List<Node> nodeArray;
	private List<Node> generalSortArray;

	public DistributorSectionsAwardModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) {
		super(content, definition, parent);
		nodeArray = new ArrayList<>();
	}
	
	public Node createJuryNode(Node node) {
		Node juryTmp = null;
		try {
			if(node.hasNode("juryTmp")) {
				node.getNode("juryTmp").remove();
			}
		}catch(RepositoryException e) {
		}
		try {
			juryTmp = node.addNode("juryTmp", NodeTypes.ContentNode.NAME);
			try{ juryTmp.setProperty("type", node.getProperty("type").getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty("juryOptionWeight", node.getProperty("juryOptionWeight").getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty("juryOptionTitle", node.getProperty("juryOptionTitle").getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty("juryOptionIdAnchor", node.getProperty("juryOptionIdAnchor").getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty("juryOptionImageAnchor", node.getProperty("juryOptionImageAnchor").getValue());}catch(RepositoryException e2) {}
			try{ juryTmp.setProperty("juryOptionAbstract", node.getProperty("juryOptionAbstract").getValue());}catch(RepositoryException e2) {}
			NodeIterator iterator = node.getNodes();
			while(iterator.hasNext()) {
				Node tmpIteratorNode = iterator.nextNode();
				if(NodeUtil.getName(tmpIteratorNode).contains("judge")) {
					Node tmpJudgeList = juryTmp.addNode(tmpIteratorNode.getName(), NodeTypes.ContentNode.NAME);
					try{ tmpJudgeList.setProperty("judgeName", node.getNode(tmpIteratorNode.getName()).getProperty("judgeName").getValue());}catch(RepositoryException e2) {}
					try{ tmpJudgeList.setProperty("judgePhoto", node.getNode(tmpIteratorNode.getName()).getProperty("judgePhoto").getValue());}catch(RepositoryException e2) {}
					try{ tmpJudgeList.setProperty("judgeText", node.getNode(tmpIteratorNode.getName()).getProperty("judgeText").getValue());}catch(RepositoryException e2) {}
					try{ tmpJudgeList.setProperty("judgeFileLink", node.getNode(tmpIteratorNode.getName()).getProperty("judgeFileLink").getValue());}catch(RepositoryException e2) {}
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
