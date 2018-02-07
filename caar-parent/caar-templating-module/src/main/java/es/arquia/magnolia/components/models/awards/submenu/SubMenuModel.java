package es.arquia.magnolia.components.models.awards.submenu;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Award;
import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.utils.breadcrumb.award.UtilsBreadcrumbAward;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class SubMenuModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;
	
	private UtilsBreadcrumbAward utilsBreadcrumbAward;

	@Inject
	public SubMenuModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager, final UtilsBreadcrumbAward utilsBreadcrumbAward) {
		super(content, definition, parent);
		this.awardManager = awardManager;
		this.utilsBreadcrumbAward = utilsBreadcrumbAward;
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
		return utilsBreadcrumbAward.getAwardAboutPageLink(currentUrl);
	}
	
	public String getNewsListLink(String currentUrl) {
		return utilsBreadcrumbAward.getAwardNewsListPageLink(currentUrl);
	}


}
