package es.arquia.magnolia.functions;

import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.*;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardWorkspace;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.utils.ArchitectureFilesSupportProject;
import es.arquia.magnolia.utils.AwardNodeUtil;
import es.arquia.magnolia.utils.NewsNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;

public class RelatedElementsTransformersImpl implements RelatedElementsTransformers{
	
	@Inject
	private ArchitectureFilesSupportArchitect architectureFilesSupportArchitect;
	@Inject
	private ArchitectureFilesSupportProject architectureFilesSupportProject;
	@Inject
	private ArchitectureFilesSupportEvent architectureFilesSupportEvent;
	@Inject
	private NewsNodeUtil news;
	@Inject
	private AwardNodeUtil award;
	
	public RelatedElement architectureFilesSupportArchitectTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesSupportArchitect.getName(node) + " " + architectureFilesSupportArchitect.getFirstSurname(node) + " " + architectureFilesSupportArchitect.getSecondSurname(node));
		related.setPhoto(architectureFilesSupportArchitect.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesSupportArchitectNodeType);
		
		return related;
	}
	
	public RelatedElement architectureFilesSupportProjectTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesSupportProject.getProjectTitle(node));
		related.setPhoto(architectureFilesSupportProject.getListMedia(node).get(0).getProperty(photoPreview).getValue().getString());
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesSupportProjectNodeType);
		
		return related;
	}
	
	public RelatedElement architectureFilesSupportEventTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesSupportEvent.getOuvreTitle(node));
		related.setPhoto(architectureFilesSupportEvent.getPreviewPhoto(node));
		related.setDescription(architectureFilesSupportEvent.getOuvreAbstract(node));
		related.setEventType(architectureFilesSupportEvent.getEventType(node));
		related.setDayOfWeek(architectureFilesSupportEvent.getStartDayOfWeek(node));
		related.setDate(architectureFilesSupportEvent.getPresentationStartDate(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesSupportEventNodeType);
		
		return related;
	}
	
	public RelatedElement newsTransformer(Node node) throws RepositoryException {
		
		RelatedElement related = new RelatedElement();
		
		related.setTitle(news.getHeadline(node));
		related.setPhoto(news.getImage(node));
		related.setDescription(news.getDescription(node));
		related.setPath(node.getPath());
		related.setWorkspace(newsWorkspace);
		related.setNodeType(newsNodeType);
		
		return related;
	}
	
	public RelatedElement awardTransformer(Node node) throws RepositoryException {
		
		RelatedElement related = new RelatedElement();
		
		related.setTitle(award.getAwardName(node));
		related.setPhoto(award.getAwardLogo(node));
		related.setPath(node.getPath());
		related.setWorkspace(awardWorkspace);
		related.setNodeType(awardNodeType);
		
		return related;
	}

}
