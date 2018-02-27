package es.arquia.magnolia.components.models.relatedElements;

import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.manager.ArchitectureFilesSupportArchitectManager;
import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.manager.RelatedElementsManager;
import es.arquia.magnolia.utils.ArchitectureFileImpl;
import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.AwardNodeUtil;
import es.arquia.magnolia.utils.NewsNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class RelatedElementsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private ArchitectureFilesSupportArchitect architectureFilesSupportArchitect;
	
	private ArchitectureFilesSupportArchitectManager architectureFilesSupportArchitectManager;
	
	private NewsManager newsManager;
	
	private NewsNodeUtil newsNodeUtil;
	
	private AwardManager awardManager;
	
	private AwardNodeUtil awardNodeUtil;

	@Inject
	public RelatedElementsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final ArchitectureFilesSupportArchitectManager architectureFilesSupportArchitectManager, final NewsManager newsManager, final AwardManager awardManager) {
		super(content, definition, parent);
		this.architectureFilesSupportArchitectManager = architectureFilesSupportArchitectManager;
		this.newsManager = newsManager;
		this.awardManager = awardManager;
		architectureFilesSupportArchitect = architectureFilesSupportArchitectManager.getInstance();
		newsNodeUtil = newsManager.getInstance();
		awardNodeUtil = awardManager.getInstance();
	}

	public List<RelatedElement> getRelatedElements(Node node) throws RepositoryException{
		List<RelatedElement> tmpElements = new ArrayList<>();
		if(node.isNodeType("mgnl:support-architect")) {
			tmpElements = architectureFilesSupportArchitectManager.getTransformedRelatedElements(architectureFilesSupportArchitect.getRelatedElements(node));
			
		}else if(node.isNodeType("mgnl:news")){
			tmpElements = newsManager.getTransformedRelatedElements(newsNodeUtil.getRelatedElements(node));
		}else if(node.isNodeType("mgnl:award")) {
			tmpElements = awardManager.getTransformedRelatedElements(awardNodeUtil.getRelatedElements(node));
		}
		return tmpElements;
	}
	
}
