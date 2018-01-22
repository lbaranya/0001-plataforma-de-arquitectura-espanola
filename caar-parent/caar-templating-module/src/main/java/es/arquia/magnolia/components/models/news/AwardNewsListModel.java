package es.arquia.magnolia.components.models.news;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.manager.NewsManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class AwardNewsListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	
	@Inject
	public AwardNewsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
    }
	
	public List<Node> getAwardNewsList() throws Exception{
		return newsManager.getAwardNewsList();
	}
	
	public News getInstance() {
		return newsManager.getInstance();
	}

}
