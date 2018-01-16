package es.arquia.magnolia.components.models.architectureFiles;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.jcr.Node;

import es.arquia.magnolia.beans.ArchitectureFile;
import es.arquia.magnolia.beans.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.beans.RelatedFile;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class RelatedFilesModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{

	public RelatedFilesModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) {
		super(content, definition, parent);
	}
	
	private RelatedFile transformToRelatedFile(Node node) throws Exception{
		if(node.isNodeType(architectureFilesSupportArchitectNodeType)) {
			ArchitectureFile architect = new ArchitectureFilesSupportArchitect();
			return architect.getRelatedFile(node);
		}else {
			
		}
		return null;
	}

	public List<RelatedFile> getNodes(Node node) throws Exception{
		List<String> filePaths = new ArchitectureFilesSupportArchitect().getRelatedFiles(node);
		List<RelatedFile> relatedFiles = new LinkedList<>();
		for (Iterator<String> iterator = filePaths.iterator() ; iterator.hasNext();)
		{
			Node fileNode = MgnlContext.getJCRSession(architectureFilesWorkspace).getNode(iterator.next().toString());
			relatedFiles.add(this.transformToRelatedFile(fileNode));
		}
		return relatedFiles;
	}
}
