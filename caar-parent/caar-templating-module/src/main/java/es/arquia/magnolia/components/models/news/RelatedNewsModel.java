package es.arquia.magnolia.components.models.news;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.utils.AwardNodeUtilImpl;
import es.arquia.magnolia.utils.NewsNodeUtil;
import es.arquia.magnolia.utils.NewsNodeUtilImpl;
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
	
	public NewsNodeUtil getInstance() {
		return newsManager.getInstance();
	}
	
	public List<Node> getCategorizedImportantNewsList(Node node) throws RepositoryException{
		AwardNodeUtilImpl tmpAward = new AwardNodeUtilImpl(i18nContentSupport);
		List<String> categoriesList = new ArrayList<>();
		categoriesList.add(tmpAward.getAwardCategoriesList(node));
		return newsManager.getCategorizedImportantNewsList(categoriesList, 4);
	}
	
}
