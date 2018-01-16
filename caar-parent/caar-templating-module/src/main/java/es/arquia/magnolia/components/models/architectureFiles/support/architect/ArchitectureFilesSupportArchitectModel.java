package es.arquia.magnolia.components.models.architectureFiles.support.architect;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.ArchitectureFilesSupportArchitect;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class ArchitectureFilesSupportArchitectModel <RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportArchitectModel.class);
	
	private ArchitectureFilesSupportArchitect architect;
	
	public ArchitectureFilesSupportArchitectModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        architect = new ArchitectureFilesSupportArchitect();
    }
	
	public ArchitectureFilesSupportArchitect getArchitect() {
		return architect;
	}
	
	public boolean isArchitectNodeType(String nodeJcrPath) throws PathNotFoundException, LoginException, RepositoryException {
		Node node = MgnlContext.getJCRSession(architectureFilesWorkspace).getNode(nodeJcrPath);
		try {
            return node.isNodeType(architectureFilesSupportArchitectNodeType);
        } catch (RepositoryException e) {
            log.error("Unable to read nodeType for node {}", NodeUtil.getNodePathIfPossible(node));
        }
        return false;
	}
}
