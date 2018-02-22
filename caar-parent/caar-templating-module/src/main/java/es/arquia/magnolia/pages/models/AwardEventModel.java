package es.arquia.magnolia.pages.models;

import javax.jcr.Node;

import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.utils.EventNodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class AwardEventModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;

	public AwardEventModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager) {
		super(content, definition, parent);
		this.awardManager = awardManager;
	}
	
	public EventNodeUtil getInstance() {
		return awardManager.getEventInstance();
	}

}
