package es.arquia.magnolia.components.models.newsDiary;

import static es.arquia.magnolia.templates.constants.ContextBeanConstants.contextBeanNewsNodeList;
import static es.arquia.magnolia.templates.constants.ContextBeanConstants.contextBeanParentPathString;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.manager.ArchitectureFilesSupportEventManager;
import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.templates.bean.ContextBean;
import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsDiaryModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	private NewsManager newsManager;
	private ArchitectureFilesSupportEventManager architectureFilesSupportEventManager;
	
	private ContextBean contextBean;
	
	@Inject
	public NewsDiaryModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final ArchitectureFilesSupportEventManager architectureFilesSupportEventManager, final ContextBean contextBean) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.architectureFilesSupportEventManager = architectureFilesSupportEventManager;
        this.contextBean = contextBean;
    }
	
	public List<Node> getImportantNewsList() throws Exception{
		contextBean.setListResultNews(newsManager.getImportantNewsList());
		contextBean.setParentPath(MgnlContext.getAggregationState().getOriginalBrowserURI());
		setContextValuesFromNewsList(contextBean);
		return contextBean.getListResultNews();
	}
	
	public News getNewsInstance() {
		return newsManager.getInstance();
	}
	
	public List<Node> getArchitectureFilesSupportEventList() throws Exception{
		return architectureFilesSupportEventManager.getArchitectureFilesSupportEventList();
	}
	
	public ArchitectureFilesSupportEvent getArchitectureFilesSupportEventInstance() {
		return architectureFilesSupportEventManager.getInstance();
	}
	
	private void setContextValuesFromNewsList(ContextBean contextBean) {
		MgnlContext.setAttribute(contextBeanNewsNodeList, contextBean.getListResultNews(), Context.SESSION_SCOPE);
		MgnlContext.setAttribute(contextBeanParentPathString, contextBean.getParentPath(), Context.SESSION_SCOPE);
	}
}
