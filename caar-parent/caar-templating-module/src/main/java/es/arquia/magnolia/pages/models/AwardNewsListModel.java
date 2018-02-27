package es.arquia.magnolia.pages.models;

import static es.arquia.magnolia.templates.constants.ContextNewsNavConstants.contextNewsNavObject;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.templates.bean.ContextNewsNav;
import es.arquia.magnolia.utils.AwardNodeUtil;
import es.arquia.magnolia.utils.NewsNodeUtil;
import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class AwardNewsListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	private AwardManager awardManager;
	
	private ContextNewsNav contextNewsNav;
	
	@Inject
	public AwardNewsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final AwardManager awardManager, final ContextNewsNav contextBean) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.awardManager = awardManager;
        this.contextNewsNav = contextBean;
    }
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList) throws Exception{
		contextNewsNav.setListResultNews(newsManager.getCategorizedNewsList(categoriesList));
		contextNewsNav.setParentPath(MgnlContext.getAggregationState().getOriginalBrowserURI());
		setContextValuesFromNewsList(contextNewsNav);
		return contextNewsNav.getListResultNews();
	}
	
	public NewsNodeUtil getNewsInstance() {
		return newsManager.getInstance();
	}
	
	public AwardNodeUtil getAwardInstance() {
		return awardManager.getInstance();
	}
	
	private void setContextValuesFromNewsList(ContextNewsNav contextNewsNav) {
		MgnlContext.setAttribute(contextNewsNavObject, contextNewsNav, Context.SESSION_SCOPE);
	}

}
