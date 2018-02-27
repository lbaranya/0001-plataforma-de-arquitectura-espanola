package es.arquia.magnolia.components.models.architectureFiles.support.architect;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.manager.ArchitectureFilesSupportArchitectManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class ArchitectureFilesSupportArchitectsListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private ArchitectureFilesSupportArchitectManager architectureFilesSupportArchitectManager;

	@Inject
	public ArchitectureFilesSupportArchitectsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final ArchitectureFilesSupportArchitectManager architectureFilesSupportArchitectManager) {
		super(content, definition, parent);
		this.architectureFilesSupportArchitectManager = architectureFilesSupportArchitectManager;
	}
	
	public List<Node> getArchitectsList() throws RepositoryException {
		return architectureFilesSupportArchitectManager.getArchitectsList();
	}
	
	
	public ArchitectureFilesSupportArchitect getInstance() {
		return architectureFilesSupportArchitectManager.getInstance();
	}

}
