package es.arquia.magnolia.components.models.news;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;

import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.utils.NewsNodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsDetailsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;

	@Inject
	public NewsDetailsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager) {
		super(content, definition, parent);
		this.newsManager = newsManager;
	}
	
	public List<Node> getNewsList() throws Exception{
		return newsManager.getNewsList();
	}
	
	public NewsNodeUtil getInstance() {
		return newsManager.getInstance();
	}

}
