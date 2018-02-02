package es.arquia.magnolia.components.models.header;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.AwardImpl;
import es.arquia.magnolia.beans.Award;
import es.arquia.magnolia.manager.AwardManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class HeaderModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardsManager;

	@Inject
	public HeaderModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardsManager) {
		super(content, definition, parent);
		this.awardsManager = awardsManager;
	}
	
	public List<Node> getAwardsList() throws RepositoryException {
		return awardsManager.getAwardList();
	}
	
	public List<Node> getBiennialsList() throws RepositoryException{
		return awardsManager.getBiennialList();
	}
	
	public Award getInstance() {
		return awardsManager.getInstance();
	}

}
