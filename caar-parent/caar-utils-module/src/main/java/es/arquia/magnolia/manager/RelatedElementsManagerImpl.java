package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportProjectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIIINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIVNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportBusinessNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.functions.RelatedElementsTransformers;
import es.arquia.magnolia.utils.RelatedElement;

public class RelatedElementsManagerImpl implements RelatedElementsManager {
	
	@Inject
	RelatedElementsTransformers relatedElementsTransformers;
	
	public RelatedElement transformToRelatedElement (Node node) throws RepositoryException {
		if (node.isNodeType(newsNodeType)) {
			return relatedElementsTransformers.newsTransformer(node);
		}
		else if (node.isNodeType(awardNodeType)) {
			return relatedElementsTransformers.awardTransformer(node);
		}
		else if (node.isNodeType(architectureFilesSupportArchitectNodeType)) {
			return relatedElementsTransformers.architectureFilesSupportArchitectTransformer(node);
		}
		else if (node.isNodeType(architectureFilesSupportEventNodeType)) {
			return relatedElementsTransformers.architectureFilesSupportEventTransformer(node);
		}
		else if(node.isNodeType(architectureFilesSupportProjectNodeType)){
			return relatedElementsTransformers.architectureFilesSupportProjectTransformer(node);
		}
		else if(node.isNodeType(architectureFilesSupportReviewINodeType) || node.isNodeType(architectureFilesSupportReviewIINodeType) || node.isNodeType(architectureFilesSupportReviewIIINodeType) || node.isNodeType(architectureFilesSupportReviewIVNodeType)) {
			return relatedElementsTransformers.architectureFilesSupportReviewTransformer(node);
		}
		else if(node.isNodeType(architectureFilesSupportBusinessNodeType)) {
			return relatedElementsTransformers.architectureFilesSupportBusinessTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatAudioNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatAudioTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatBookNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatBookTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatCartographicNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatCartographicTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatContinuousNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatContinuousTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatElectronicNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatElectronicTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatGraphicNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatGraphicTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatManuscriptNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatManuscriptTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatThreeDimensionalNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatThreeDimensionalTransformer(node);
		}
		else if(node.isNodeType(architectureFilesFormatVideoNodeType)) {
			return relatedElementsTransformers.architectureFilesFormatVideoTransformer(node);
		}
		else {
			return null;
		}
	}
}
