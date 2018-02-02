package es.arquia.magnolia.components.models.news;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.AwardImpl;
import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.beans.NewsImpl;
import es.arquia.magnolia.manager.NewsManager;
import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class RelatedNewsModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private NewsManager newsManager;
	
	private I18nContentSupport i18nContentSupport;
	
	@Inject
	public RelatedNewsModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final I18nContentSupport i18nContentSupport){
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.i18nContentSupport = i18nContentSupport;
    }
	
	public News getInstance() {
		return newsManager.getInstance();
	}
	
	public List<Node> getCategorizedImportantNewsList(Node node) throws RepositoryException{
		AwardImpl tmpAward = new AwardImpl(i18nContentSupport);
		return newsManager.getCategorizedImportantNewsList(tmpAward.getAwardCategoriesList(node), 4);
	}
	
}
