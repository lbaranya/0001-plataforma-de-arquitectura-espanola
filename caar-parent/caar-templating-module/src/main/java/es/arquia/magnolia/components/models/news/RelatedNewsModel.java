package es.arquia.magnolia.components.models.news;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Award;
import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.functions.LocalizedSuffixUtils;
import es.arquia.magnolia.manager.NewsManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class RelatedNewsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	
	private LocalizedSuffixUtils localizedSuffix;
	
	@Inject
	public RelatedNewsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final LocalizedSuffixUtils localizedSuffix){
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.localizedSuffix = localizedSuffix;
    }
	
	public News getInstance() {
		return newsManager.getInstance();
	}
	
	public List<Node> getCategorizedImportantNewsList(Node node) throws RepositoryException{
		Award tmpAward = new Award(localizedSuffix);
		return newsManager.getCategorizedImportantNewsList(tmpAward.getAwardCategoriesList(node), 4);
	}
	
}
