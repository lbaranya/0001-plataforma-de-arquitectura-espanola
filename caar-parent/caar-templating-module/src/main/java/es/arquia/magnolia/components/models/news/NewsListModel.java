package es.arquia.magnolia.components.models.news;

import static es.arquia.magnolia.templates.constants.ContextNewsNavConstants.*;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.templates.bean.ContextNewsNav;
import es.arquia.magnolia.utils.NewsNodeUtil;
import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	
	private ContextNewsNav contextNewsNav;
	
	@Inject
	public NewsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final ContextNewsNav contextBean) throws RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.contextNewsNav = contextBean;
    }
	
	public List<Node> getNewsList(int numberOfNews) throws Exception{
		contextNewsNav.setListResultNews(newsManager.getNewsList(numberOfNews));
		contextNewsNav.setParentPath(MgnlContext.getAggregationState().getOriginalBrowserURI());
		setContextValuesFromNewsList(contextNewsNav);
		return contextNewsNav.getListResultNews();
	}
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList, int numberOfNews) throws Exception{
		contextNewsNav.setListResultNews(newsManager.getCategorizedNewsList(categoriesList, numberOfNews));
		contextNewsNav.setParentPath(MgnlContext.getAggregationState().getOriginalBrowserURI());
		setContextValuesFromNewsList(contextNewsNav);
		return contextNewsNav.getListResultNews();
	}
	
	public boolean isLastRowOfNews() {
		return newsManager.isLastRowOfNews();
	}
	
	public NewsNodeUtil getInstance() {
		return newsManager.getInstance();
	}
	
	private void setContextValuesFromNewsList(ContextNewsNav contextNewsNav) {
		MgnlContext.setAttribute(contextNewsNavObject, contextNewsNav, Context.SESSION_SCOPE);
	}
}
