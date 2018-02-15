package es.arquia.magnolia.pages.models;

import static es.arquia.magnolia.templates.constants.ContextBeanConstants.contextBeanNewsNodeList;
import static es.arquia.magnolia.templates.constants.ContextBeanConstants.contextBeanParentPathString;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Award;
import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.templates.bean.ContextBean;
import es.arquia.magnolia.templates.bean.ContextBeanImpl;
import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class AwardNewsListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	private AwardManager awardManager;
	
	private ContextBeanImpl contextBean;
	
	@Inject
	public AwardNewsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final AwardManager awardManager) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.awardManager = awardManager;
        this.contextBean = new ContextBeanImpl();
    }
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList) throws Exception{
		contextBean.setListResultNews(newsManager.getCategorizedNewsList(categoriesList));
		contextBean.setParentPath(MgnlContext.getAggregationState().getOriginalBrowserURI());
		setContextValuesFromNewsList(contextBean);
		return contextBean.getListResultNews();
	}
	
	public News getNewsInstance() {
		return newsManager.getInstance();
	}
	
	public Award getAwardInstance() {
		return awardManager.getInstance();
	}
	
	private void setContextValuesFromNewsList(ContextBean contextBean) {
		MgnlContext.setAttribute(contextBeanNewsNodeList, contextBean.getListResultNews(), Context.SESSION_SCOPE);
		MgnlContext.setAttribute(contextBeanParentPathString, contextBean.getParentPath(), Context.SESSION_SCOPE);
	}

}
