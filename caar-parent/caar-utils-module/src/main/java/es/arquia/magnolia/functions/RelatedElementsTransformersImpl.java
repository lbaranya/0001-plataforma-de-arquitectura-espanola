package es.arquia.magnolia.functions;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportBusinessNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportProjectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIIINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIVNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportProjectConstants.photoPreview;
import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardWorkspace;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesFormatAudio;
import es.arquia.magnolia.utils.ArchitectureFilesFormatBook;
import es.arquia.magnolia.utils.ArchitectureFilesFormatCartographic;
import es.arquia.magnolia.utils.ArchitectureFilesFormatContinuous;
import es.arquia.magnolia.utils.ArchitectureFilesFormatElectronic;
import es.arquia.magnolia.utils.ArchitectureFilesFormatGraphic;
import es.arquia.magnolia.utils.ArchitectureFilesFormatManuscript;
import es.arquia.magnolia.utils.ArchitectureFilesFormatThreeDimensional;
import es.arquia.magnolia.utils.ArchitectureFilesFormatVideo;
import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.ArchitectureFilesSupportBusiness;
import es.arquia.magnolia.utils.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.utils.ArchitectureFilesSupportProject;
import es.arquia.magnolia.utils.ArchitectureFilesSupportReview;
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
	private ArchitectureFilesSupportReview architectureFilesSupportReview;
	@Inject
	private ArchitectureFilesSupportBusiness architectureFilesSupportBusiness;
	@Inject
	private ArchitectureFilesFormatAudio architectureFilesFormatAudio;
	@Inject
	private ArchitectureFilesFormatBook architectureFilesFormatBook;
	@Inject
	private ArchitectureFilesFormatCartographic architectureFilesFormatCartographic;
	@Inject
	private ArchitectureFilesFormatContinuous architectureFilesFormatContinuous;
	@Inject
	private ArchitectureFilesFormatElectronic architectureFilesFormatElectronic;
	@Inject
	private ArchitectureFilesFormatGraphic architectureFilesFormatGraphic;
	@Inject
	private ArchitectureFilesFormatManuscript architectureFilesFormatManuscript;
	@Inject
	private ArchitectureFilesFormatThreeDimensional architectureFilesFormatThreeDimensional;
	@Inject
	private ArchitectureFilesFormatVideo architectureFilesFormatVideo;
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

	@Override
	public RelatedElement architectureFilesSupportReviewTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();
		
		if(node.isNodeType(architectureFilesSupportReviewINodeType) || node.isNodeType(architectureFilesSupportReviewIINodeType) || node.isNodeType(architectureFilesSupportReviewIIINodeType) || node.isNodeType(architectureFilesSupportReviewIVNodeType)) {
			related.setTitle(architectureFilesSupportReview.getOuvreTitle(node));
			related.setPhoto(architectureFilesSupportReview.getPreviewPhoto(architectureFilesSupportReview.getFirstMediaImage(node)));
			related.setPath(node.getPath());
			related.setWorkspace(architectureFilesWorkspace);
			related.setNodeType(node.getPrimaryNodeType().getName());
		}
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesSupportBusinessTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesSupportBusiness.getLegalName(node));
		related.setPhoto(architectureFilesSupportBusiness.getLogo(node));
		related.setCountry(architectureFilesSupportBusiness.getDepartmentCountry(node));
		related.setCity(architectureFilesSupportBusiness.getDepartmentCity(node));
		related.setBusinessType(architectureFilesSupportBusiness.getBusinessType(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesSupportBusinessNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatAudioTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatAudio.getTitle(node));
		related.setSubtitle(architectureFilesFormatAudio.getSubtitle(node));
		related.setPhoto(architectureFilesFormatAudio.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatAudioNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatBookTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatBook.getTitle(node));
		related.setSubtitle(architectureFilesFormatBook.getSubtitle(node));
		related.setPhoto(architectureFilesFormatBook.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatBookNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatCartographicTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatCartographic.getTitle(node));
		related.setSubtitle(architectureFilesFormatCartographic.getSubtitle(node));
		related.setPhoto(architectureFilesFormatCartographic.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatCartographicNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatContinuousTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatContinuous.getTitle(node));
		related.setSubtitle(architectureFilesFormatContinuous.getSubtitle(node));
		related.setPhoto(architectureFilesFormatContinuous.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatContinuousNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatElectronicTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatElectronic.getTitle(node));
		related.setSubtitle(architectureFilesFormatElectronic.getSubtitle(node));
		related.setPhoto(architectureFilesFormatElectronic.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatElectronicNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatGraphicTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatGraphic.getTitle(node));
		related.setSubtitle(architectureFilesFormatGraphic.getSubtitle(node));
		related.setPhoto(architectureFilesFormatGraphic.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatGraphicNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatManuscriptTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatManuscript.getTitle(node));
		related.setSubtitle(architectureFilesFormatManuscript.getSubtitle(node));
		related.setPhoto(architectureFilesFormatManuscript.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatManuscriptNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatThreeDimensionalTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatThreeDimensional.getTitle(node));
		related.setSubtitle(architectureFilesFormatThreeDimensional.getSubtitle(node));
		related.setPhoto(architectureFilesFormatThreeDimensional.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatThreeDimensionalNodeType);
		
		return related;
	}

	@Override
	public RelatedElement architectureFilesFormatVideoTransformer(Node node) throws RepositoryException {
		RelatedElement related = new RelatedElement();

		related.setTitle(architectureFilesFormatVideo.getTitle(node));
		related.setSubtitle(architectureFilesFormatVideo.getSubtitle(node));
		related.setPhoto(architectureFilesFormatVideo.getPhoto(node));
		related.setPath(node.getPath());
		related.setWorkspace(architectureFilesWorkspace);
		related.setNodeType(architectureFilesFormatVideoNodeType);
		
		return related;
	}

}
