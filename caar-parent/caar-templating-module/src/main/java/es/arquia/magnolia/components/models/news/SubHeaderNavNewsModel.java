package es.arquia.magnolia.components.models.news;

import static es.arquia.magnolia.templates.constants.ContextBeanConstants.contextBeanNewsNodeList;
import static es.arquia.magnolia.templates.constants.ContextBeanConstants.contextBeanParentPathString;

import java.util.LinkedList;
import java.util.List;

import javax.jcr.Node;

import info.magnolia.context.Context;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class SubHeaderNavNewsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private List<Node> navigationNewsList;
	
	private String parentPath;
	
	private LinkedList<Node> linkedNavigationList;

	public SubHeaderNavNewsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) {
		super(content, definition, parent);
		navigationNewsList = (List<Node>)MgnlContext.getAttribute(contextBeanNewsNodeList, Context.SESSION_SCOPE);
		parentPath = (String)MgnlContext.getAttribute(contextBeanParentPathString, Context.SESSION_SCOPE);
		linkedNavigationList = new LinkedList<>();
		linkedNavigationList.addAll(navigationNewsList);
	}
	
	public String getParentListNewsPath() {
		return parentPath;
	}
	
	public Node getNextNews(Node node) {
		if((linkedNavigationList.indexOf(node) + 1) > linkedNavigationList.size()) {
			return linkedNavigationList.getFirst();
		}
		else {
			return linkedNavigationList.get(linkedNavigationList.indexOf(node) + 1);
		}
	}
	
	public Node getPreviousNews(Node node) {
		if((linkedNavigationList.indexOf(node) - 1) < 0) {
			return linkedNavigationList.getLast();
		}
		else {
			return linkedNavigationList.get(linkedNavigationList.indexOf(node) - 1);
		}
	}

}
