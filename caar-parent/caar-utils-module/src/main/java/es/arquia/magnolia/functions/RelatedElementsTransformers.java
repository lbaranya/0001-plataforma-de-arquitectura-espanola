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
	
	public RelatedElement architectureFilesFormatAudioTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesFormatBookTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesFormatCartographicTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesFormatContinuousTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesFormatElectronicTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesFormatGraphicTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesFormatManuscriptTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesFormatThreeDimensionalTransformer(Node node) throws RepositoryException;
	
	public RelatedElement architectureFilesFormatVideoTransformer(Node node) throws RepositoryException;
	
	public RelatedElement newsTransformer(Node node) throws RepositoryException;
	
	public RelatedElement awardTransformer(Node node) throws RepositoryException;

}
