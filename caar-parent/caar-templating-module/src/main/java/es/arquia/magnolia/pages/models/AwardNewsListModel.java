package es.arquia.magnolia.pages.models;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.AwardImpl;
import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.beans.Award;
import es.arquia.magnolia.beans.NewsImpl;
import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.manager.NewsManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class AwardNewsListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	private AwardManager awardManager;
	
	@Inject
	public AwardNewsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final AwardManager awardManager) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.awardManager = awardManager;
    }
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList) throws Exception{
		return newsManager.getCategorizedNewsList(categoriesList);
	}
	
	public News getNewsInstance() {
		return newsManager.getInstance();
	}
	
	public Award getAwardInstance() {
		return awardManager.getInstance();
	}

}
