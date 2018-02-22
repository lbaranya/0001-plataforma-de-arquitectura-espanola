package es.arquia.magnolia.components.models.relatedElements;

import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFileImpl;
import es.arquia.magnolia.utils.AwardNodeUtil;
import es.arquia.magnolia.utils.NewsNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class RelatedElementsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsNodeUtil news;
	private AwardNodeUtil award;
	@Inject
	private ArchitectureFileImpl architectureFileImpl;

	@Inject
	public RelatedElementsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsNodeUtil news, final AwardNodeUtil award) {
		super(content, definition, parent);
		this.news = news;
		this.award = award;
	}

	public List<RelatedElement> getRelatedElements(Node node){
		List<RelatedElement> relatedElements = new LinkedList<>();
		try {
			if (node.isNodeType(newsNodeType)) {
				
				relatedElements.addAll(this.news.getRelatedElements(node));
				
			} else if (node.isNodeType(awardNodeType)) {
				
				relatedElements.addAll(this.award.getRelatedElements(node));
				
			} else {
				
				relatedElements.addAll(this.architectureFileImpl.getRelatedElements(node));
			}
		}catch(RepositoryException e) {
			
		}
		return relatedElements;
	}
	
}
