package es.arquia.magnolia.functions;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.RelatedElement;

public interface RelatedElementsTransformers {
	
	public RelatedElement architectureFilesSupportArchitectTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesSupportProjectTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesSupportEventTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesSupportReviewTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesSupportBusinessTransformer(Node node) throws RepositoryException;
	
	public RelatedElement newsTransformer(Node node) throws RepositoryException;
	
	public RelatedElement awardTransformer(Node node) throws RepositoryException;

}
