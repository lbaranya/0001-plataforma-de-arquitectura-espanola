package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
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
		else {
			return null;
		}
	}


}
