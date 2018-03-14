package es.arquia.magnolia.components.models.architectureFiles.support.event;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.manager.ArchitectureFilesSupportEventManager;
import es.arquia.magnolia.utils.ArchitectureFilesSupportEvent;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class ArchitectureFilesSupportEventListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private ArchitectureFilesSupportEventManager architectureFilesSupportEventManager;

	@Inject
	public ArchitectureFilesSupportEventListModel(Node content, ConfiguredTemplateDefinition definition,
			RenderingModel<?> parent, final ArchitectureFilesSupportEventManager architectureFilesSupportEventManager) {
		super(content, definition, parent);
		this.architectureFilesSupportEventManager = architectureFilesSupportEventManager;
	}
	
	public List<Node> getArchitectureFilesSupportEventList(int eventsPerRow) throws RepositoryException {
		return architectureFilesSupportEventManager.getArchitectureFilesSupportEventList(eventsPerRow);
	}
	
	public ArchitectureFilesSupportEvent getInstance() {
		return architectureFilesSupportEventManager.getInstance();
	}
	
	public boolean isLastRow() {
		return architectureFilesSupportEventManager.isLastRowOfEvents();
	}

}
