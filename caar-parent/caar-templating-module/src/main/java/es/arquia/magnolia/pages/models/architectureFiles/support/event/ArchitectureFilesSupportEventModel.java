package es.arquia.magnolia.pages.models.architectureFiles.support.event;

import javax.inject.Inject;
import javax.jcr.Node;

import es.arquia.magnolia.manager.ArchitectureFilesSupportEventManager;
import es.arquia.magnolia.utils.ArchitectureFilesSupportEvent;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class ArchitectureFilesSupportEventModel <RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition> {
	
	private ArchitectureFilesSupportEventManager architectureFilesSupportEventManager;

	@Inject
	public ArchitectureFilesSupportEventModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, ArchitectureFilesSupportEventManager architectureFilesSupportEventManager) {
		super(content, definition, parent);
		this.architectureFilesSupportEventManager = architectureFilesSupportEventManager;
	}
	
	public ArchitectureFilesSupportEvent getInstance() {
		return architectureFilesSupportEventManager.getInstance();
	}

}
