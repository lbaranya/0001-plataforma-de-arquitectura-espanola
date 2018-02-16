package es.arquia.magnolia.components.models.newsDiary;

import static es.arquia.magnolia.templates.constants.ContextNewsNavConstants.contextNewsNavObject;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.manager.ArchitectureFilesSupportEventManager;
import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.templates.bean.ContextNewsNav;
import es.arquia.magnolia.utils.NewsNodeUtil;
import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsDiaryModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	private NewsManager newsManager;
	private ArchitectureFilesSupportEventManager architectureFilesSupportEventManager;
	
	private ContextNewsNav contextNewsNav;
	
	@Inject
	public NewsDiaryModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final ArchitectureFilesSupportEventManager architectureFilesSupportEventManager, final ContextNewsNav contextBean) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.architectureFilesSupportEventManager = architectureFilesSupportEventManager;
        this.contextNewsNav = contextBean;
    }
	
	public List<Node> getImportantNewsList() throws Exception{
		contextNewsNav.setListResultNews(newsManager.getImportantNewsList());
		contextNewsNav.setParentPath(MgnlContext.getAggregationState().getOriginalBrowserURI());
		setContextValuesFromNewsList(contextNewsNav);
		return contextNewsNav.getListResultNews();
	}
	
	public NewsNodeUtil getNewsInstance() {
		return newsManager.getInstance();
	}
	
	public List<Node> getArchitectureFilesSupportEventList() throws Exception{
		return architectureFilesSupportEventManager.getArchitectureFilesSupportEventList();
	}
	
	public ArchitectureFilesSupportEvent getArchitectureFilesSupportEventInstance() {
		return architectureFilesSupportEventManager.getInstance();
	}
	
	private void setContextValuesFromNewsList(ContextNewsNav contextNewsNav) {
		MgnlContext.setAttribute(contextNewsNavObject, contextNewsNav, Context.SESSION_SCOPE);
	}
}
