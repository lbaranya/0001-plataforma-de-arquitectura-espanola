package es.arquia.magnolia.components.models.news;

import static es.arquia.magnolia.templates.constants.ContextNewsNavConstants.contextNewsNavObject;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import es.arquia.magnolia.functions.I18nURLFunctions;
import es.arquia.magnolia.templates.bean.ContextNewsNav;
import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class SubHeaderNavNewsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private List<Node> navigationNewsList;
	
	private String parentPath;
	
	private I18nURLFunctions i18nURLFunctions;
	
	private ContextNewsNav contextNewsNav;
	
	@Inject
	public SubHeaderNavNewsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final I18nURLFunctions i18nURLFunctions) {
		super(content, definition, parent);
		contextNewsNav = MgnlContext.getAttribute(contextNewsNavObject, Context.SESSION_SCOPE);
		if(contextNewsNav != null) {
			navigationNewsList = contextNewsNav.getListResultNews();
			parentPath = contextNewsNav.getParentPath();
		}
		this.i18nURLFunctions = i18nURLFunctions;
	}
	
	public String getParentListNewsPath() {
		return MgnlContext.getContextPath() + i18nURLFunctions.swapLocalizedURL(parentPath, MgnlContext.getAggregationState().getLocale().getLanguage());
	}
	
	private int getIndexSearchNodeList(Node node) throws RepositoryException {
		boolean finded = false;
		Iterator<Node> iterator = navigationNewsList.iterator();
		Node tmp = null;
		int iteratorIndex = 0;
		while(iterator.hasNext() && !finded) {
			tmp = iterator.next();
			finded = tmp.getIdentifier().equalsIgnoreCase(node.getIdentifier());
			iteratorIndex++;
		}
		return --iteratorIndex;
	}
	
	public Node getNextNews(Node node) throws RepositoryException {
		if(navigationNewsList != null) {
			if((getIndexSearchNodeList(node) + 1) > navigationNewsList.size() - 1) {
				return navigationNewsList.get(0);
			}
			else {
				return navigationNewsList.get(getIndexSearchNodeList(node) + 1);
			}
		}else {
			return null;
		}
	}
	
	public Node getPreviousNews(Node node) throws RepositoryException {
		if(navigationNewsList != null) {
			if((getIndexSearchNodeList(node) - 1) < 0) {
				return navigationNewsList.get(navigationNewsList.size() - 1);
			}
			else {
				return navigationNewsList.get(getIndexSearchNodeList(node) - 1);
			}
		}else {
			return null;
		}
	}
	
	public boolean listEmpty() {
		return CollectionUtils.isEmpty(navigationNewsList);
	}
	
	public boolean paramsEmpty() {
		return this.listEmpty() && StringUtils.isEmpty(parentPath);
	}

}
