package es.arquia.magnolia.components.models.awards.submenu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.utils.AwardNodeUtil;
import es.arquia.magnolia.utils.EventNodeUtil;
import es.arquia.magnolia.utils.breadcrumb.award.UtilsBreadcrumbAward;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

import static es.arquia.magnolia.constants.AwardConstants.editionSectionWeight;

public class SubMenuModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;
	
	private UtilsBreadcrumbAward utilsBreadcrumbAward;

	@Inject
	public SubMenuModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager, final UtilsBreadcrumbAward utilsBreadcrumbAward) {
		super(content, definition, parent);
		this.awardManager = awardManager;
		this.utilsBreadcrumbAward = utilsBreadcrumbAward;
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
	
	public String getAboutLink(String currentUrl) {
		return utilsBreadcrumbAward.getAwardAboutPageLink(currentUrl);
	}
	
	public String getNewsListLink(String currentUrl) {
		return utilsBreadcrumbAward.getAwardNewsListPageLink(currentUrl);
	}
	
	public String getSecondLevelMenuLink(String currentUrl, Node node) {
		return utilsBreadcrumbAward.getAwardSeconLevelMenuLink(currentUrl, node);
	}
	
	public EventNodeUtil getEventInstance() {
		return awardManager.getEventInstance();
	}
	
	public List<Node> getEvents(Node node) throws RepositoryException{
		return awardManager.getEvents(node);
	}
	
	public String getAwardStandardEventMenuLink(String currentUrl, Node node) {
		return utilsBreadcrumbAward.getAwardStandardEventMenuLink(currentUrl, node);
	}
	
	public String getAwardLiveEventMenuLink(String currentUrl, Node node) {
		return utilsBreadcrumbAward.getAwardLiveEventMenuLink(currentUrl, node);
	}
	
	public String getAnnouncementState(Node node) throws RepositoryException{
		return awardManager.getAnnouncementState(node);
	}
	
	public List<Node> getChildrenOrderedByWeight(List<Node> childNodes){
		List<Node> resList = new ArrayList<>(childNodes);
		resList.sort(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				Integer w1 = new Integer(0);
				Integer w2 = new Integer(0);
				try {
					w1 = Integer.valueOf(o1.getProperty(editionSectionWeight).getValue().getString());
					w2 = Integer.valueOf(o2.getProperty(editionSectionWeight).getValue().getString());
				} catch (RepositoryException e) {
				}
				return w1.compareTo(w2);
			}
		});
		return resList;
	}


}
