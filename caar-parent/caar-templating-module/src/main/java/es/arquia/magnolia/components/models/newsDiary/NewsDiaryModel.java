package es.arquia.magnolia.components.models.newsDiary;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.beans.NewsImpl;
import es.arquia.magnolia.manager.NewsManager;
import es.arquia.magnolia.manager.ArchitectureFilesSupportEventManager;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsDiaryModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	private NewsManager newsManager;
	private ArchitectureFilesSupportEventManager architectureFilesSupportEventManager;
	
	@Inject
	public NewsDiaryModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final NewsManager newsManager, final ArchitectureFilesSupportEventManager architectureFilesSupportEventManager) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.newsManager = newsManager;
        this.architectureFilesSupportEventManager = architectureFilesSupportEventManager;
    }
	
	public List<Node> getImportantNewsList() throws Exception{
		return newsManager.getImportantNewsList();
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
}
