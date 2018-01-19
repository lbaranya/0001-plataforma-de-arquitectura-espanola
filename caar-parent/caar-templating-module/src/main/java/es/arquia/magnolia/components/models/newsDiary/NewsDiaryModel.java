package es.arquia.magnolia.components.models.newsDiary;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.ArchitectureFilesSupportReviewI;
import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.manager.ArchitectureFilesSupportReviewIManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsDiaryModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	private NewsManager newsManager;
	private ArchitectureFilesSupportReviewIManager architectureFilesSupportReviewIManager;
	
	@Inject
	public NewsDiaryModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final ArchitectureFilesSupportReviewIManager architectureFilesSupportReviewIManager) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.architectureFilesSupportReviewIManager = architectureFilesSupportReviewIManager;
    }
	
	public List<Node> getImportantNewsList() throws Exception{
		return newsManager.getImportantNewsList();
	}
	
	public News getNewsInstance() {
		return newsManager.getInstance();
	}
	
	public List<Node> getArchitectureFilesSupportReviewIList() throws Exception{
		return architectureFilesSupportReviewIManager.getArchitectureFilesSupportReviewIList();
	}
	
	public ArchitectureFilesSupportReviewI getArchitectureFilesSupportReviewIInstance() {
		return architectureFilesSupportReviewIManager.getInstance();
	}
}
