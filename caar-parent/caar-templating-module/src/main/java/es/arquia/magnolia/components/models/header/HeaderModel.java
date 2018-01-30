package es.arquia.magnolia.components.models.header;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;

import es.arquia.magnolia.beans.Awards;
import es.arquia.magnolia.manager.AwardsManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class HeaderModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardsManager awardsManager;

	@Inject
	public HeaderModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardsManager awardsManager) {
		super(content, definition, parent);
		this.awardsManager = awardsManager;
	}
	
	public List<Node> getAwardsList() throws Exception{
		return awardsManager.getAwardsList();
	}
	
	public List<Node> getBiennialsList() throws Exception{
		return awardsManager.getBiennialsList();
	}
	
	public Awards getInstance() {
		return awardsManager.getInstance();
	}

}
