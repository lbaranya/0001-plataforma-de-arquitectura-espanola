package es.arquia.magnolia.pages.models;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.utils.AwardNodeUtil;
import es.arquia.magnolia.utils.AwardNodeUtilImpl;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class AwardAboutModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;
	
	@Inject
	public AwardAboutModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager) {
		super(content, definition, parent);
		this.awardManager = awardManager;
	}
	
	public AwardNodeUtil getInstance() {
		return awardManager.getInstance();
	}
	
	public List<Node> getBiennialAwardList() throws RepositoryException{
		return awardManager.getBiennialList();
	}
	
	public Node getEditionStateOpen(Node node) throws RepositoryException{
		return awardManager.getEditionStateOpen(node);
	}
	
	public Node getEditionStateInProgress(Node node) throws RepositoryException{
		return awardManager.getEditionStateInProgress(node);
	}

}
