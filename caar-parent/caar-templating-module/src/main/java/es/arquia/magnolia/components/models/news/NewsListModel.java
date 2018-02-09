package es.arquia.magnolia.components.models.news;

import static es.arquia.magnolia.templates.constants.ContextBeanConstants.contextBeanNewsNodeList;
import static es.arquia.magnolia.templates.constants.ContextBeanConstants.contextBeanParentPathString;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.templates.bean.ContextBean;
import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsListModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	
	private ContextBean contextBean;
	
	@Inject
	public NewsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final ContextBean contextBean) throws RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.contextBean = contextBean;
    }
	
	public List<Node> getNewsList(int numberOfNews) throws Exception{
		contextBean.setListResultNews(newsManager.getNewsList(numberOfNews));
		contextBean.setParentPath(MgnlContext.getAggregationState().getOriginalBrowserURI());
		setContextValuesFromNewsList(contextBean);
		return contextBean.getListResultNews();
	}
	
	public List<Node> getCategorizedNewsList(List<String> categoriesList, int numberOfNews) throws Exception{
		contextBean.setListResultNews(newsManager.getCategorizedNewsList(categoriesList, numberOfNews));
		contextBean.setParentPath(MgnlContext.getAggregationState().getOriginalBrowserURI());
		setContextValuesFromNewsList(contextBean);
		return contextBean.getListResultNews();
	}
	
	public boolean isLastRowOfNews() {
		return newsManager.isLastRowOfNews();
	}
	
	public News getInstance() {
		return newsManager.getInstance();
	}
	
	private void setContextValuesFromNewsList(ContextBean contextBean) {
		MgnlContext.setAttribute(contextBeanNewsNodeList, contextBean.getListResultNews(), Context.SESSION_SCOPE);
		MgnlContext.setAttribute(contextBeanParentPathString, contextBean.getParentPath(), Context.SESSION_SCOPE);
	}
}
