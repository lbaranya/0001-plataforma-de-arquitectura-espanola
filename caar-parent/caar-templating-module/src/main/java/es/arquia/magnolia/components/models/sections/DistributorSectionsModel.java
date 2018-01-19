package es.arquia.magnolia.components.models.sections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

import info.magnolia.jcr.util.NodeUtil;

public class DistributorSectionsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private List<Node> nodeArray;
	private List<Node> generalSortArray;

	public DistributorSectionsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) {
		super(content, definition, parent);
		// TODO Auto-generated constructor stub
		nodeArray = new ArrayList<>();
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
				NodeIterator iteratorRich = iterator.getNodes();
				while(iteratorRich.hasNext()) {
					generalSortArray.add(iteratorRich.nextNode());
				}
			}
			if(NodeUtil.getName(iterator).contains("jury")) {
				NodeIterator iteratorJury = iterator.getNodes();
				while(iteratorJury.hasNext()) {
					generalSortArray.add(iteratorJury.nextNode());
				}
			}
			if(NodeUtil.getName(iterator).contains("lemma")) {
				NodeIterator iteratorLemma = iterator.getNodes();
				while(iteratorLemma.hasNext()) {
					generalSortArray.add(iteratorLemma.nextNode());
				}
			}
			if(NodeUtil.getName(iterator).contains("enrollment")) {
				NodeIterator iteratorEnrollment = iterator.getNodes();
				while(iteratorEnrollment.hasNext()) {
					generalSortArray.add(iteratorEnrollment.nextNode());
				}
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
				return weightTwo.compareTo(weightOne);
			}
			
		});
		return generalSortArray;
	}

}
