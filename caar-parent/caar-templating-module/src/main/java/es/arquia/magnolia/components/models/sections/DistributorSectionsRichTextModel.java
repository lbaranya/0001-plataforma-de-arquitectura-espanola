package es.arquia.magnolia.components.models.sections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class DistributorSectionsRichTextModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private List<Node> nodeArray;
	private List<Node> generalSortArray;

	public DistributorSectionsRichTextModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) {
		super(content, definition, parent);
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
					weightOne = 0;
				}
				try {
					weightTwo = Integer.valueOf(o2.getProperty("richTextOptionWeight").getString());
				}catch(RepositoryException e) {
					weightTwo = 0;
				}
				return weightOne.compareTo(weightTwo);
			}
			
		});
		return generalSortArray;
	}
	
	public String getAnchorFromString(String str) {
		return str.replaceAll("\\W", "");
	}

}
