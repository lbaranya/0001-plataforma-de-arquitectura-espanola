package es.arquia.magnolia.components.models.home;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.manager.HomeGridManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class HomeGridModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private HomeGridManager homeGridManager;

	@Inject
	public HomeGridModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final HomeGridManager homeGridManager) {
		super(content, definition, parent);
		this.homeGridManager = homeGridManager;
	}
	
	public String getLink(Node node) throws RepositoryException {
		return homeGridManager.getLink(node);
	}

}
