package es.arquia.magnolia.components.models.architectureFiles.support.event;

import javax.inject.Inject;
import javax.jcr.Node;

import es.arquia.magnolia.manager.ArchitectureFilesSupportEventManager;
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

}
