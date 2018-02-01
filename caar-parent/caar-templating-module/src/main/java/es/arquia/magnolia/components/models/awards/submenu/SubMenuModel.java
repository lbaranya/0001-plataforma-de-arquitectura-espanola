package es.arquia.magnolia.components.models.awards.submenu;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Award;
import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.utils.breadcrum.award.UtilsBreadcrumAward;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class SubMenuModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;
	
	private UtilsBreadcrumAward utilsBreadcrumAward;

	@Inject
	public SubMenuModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager, final UtilsBreadcrumAward utilsBreadcrumAward) {
		super(content, definition, parent);
		this.awardManager = awardManager;
		this.utilsBreadcrumAward = utilsBreadcrumAward;
	}
	
	public Award getInstance() {
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
	
	public String getAboutLink(String currentUrl) {
		return utilsBreadcrumAward.getAwardAboutPageLink(currentUrl);
	}
	
	public String getNewsListLink(String currentUrl) {
		return utilsBreadcrumAward.getAwardNewsListPageLink(currentUrl);
	}


}
