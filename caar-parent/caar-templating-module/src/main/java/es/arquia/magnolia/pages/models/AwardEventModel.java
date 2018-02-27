package es.arquia.magnolia.pages.models;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.manager.RelatedElementsManager;
import es.arquia.magnolia.utils.EventNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class AwardEventModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;
	
	private RelatedElementsManager relatedElementsManager;

	public AwardEventModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager, final RelatedElementsManager relatedElements) {
		super(content, definition, parent);
		this.awardManager = awardManager;
		this.relatedElementsManager = relatedElements;
	}
	
	public EventNodeUtil getInstance() {
		return awardManager.getEventInstance();
	}
	
	public RelatedElement transform(Node node) throws RepositoryException {
		return relatedElementsManager.transformToRelatedElement(node);
	}

}
