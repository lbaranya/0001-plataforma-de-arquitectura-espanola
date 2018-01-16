package es.arquia.magnolia.components.news;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.news.News;
import es.arquia.magnolia.news.manager.NewsManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsDiaryModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	private NewsManager newsManager;
	
	@Inject
	public NewsDiaryModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
    }
	
	public List<Node> getImportantNewsList() throws Exception{
		return newsManager.getImportantNewsList();
	}
	
	public News getInstance() {
		return newsManager.getInstance();
	}
}
