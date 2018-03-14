package es.arquia.magnolia.components.models.architectureFiles.support.event;

import javax.jcr.Node;

import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class ArchitectureFilesSupportEventListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{

	public ArchitectureFilesSupportEventListModel(Node content, ConfiguredTemplateDefinition definition,
			RenderingModel<?> parent) {
		super(content, definition, parent);
	}

}
