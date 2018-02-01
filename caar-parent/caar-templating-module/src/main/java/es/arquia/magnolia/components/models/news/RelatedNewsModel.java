package es.arquia.magnolia.components.models.news;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Award;
import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.manager.NewsManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class RelatedNewsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	
	@Inject
	public RelatedNewsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager){
        super(content, definition, parent);
        this.newsManager = newsManager;
    }
	
	public News getInstance() {
		return newsManager.getInstance();
	}
	
	public List<Node> getCategorizedImportantNewsList(Node node) throws RepositoryException{
		Award tmpAward = new Award();
		return newsManager.getCategorizedImportantNewsList(tmpAward.getAwardCategoriesList(node), 4);
	}
	
}
