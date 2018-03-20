package es.arquia.magnolia.manager;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.ArchitectureFilesSupportBusiness;
import es.arquia.magnolia.utils.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.utils.ArchitectureFilesSupportProject;
import es.arquia.magnolia.utils.ArchitectureFilesSupportReview;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;

public class ArchitectureFilesSupportManagerImpl implements ArchitectureFilesSupportManager {
	
	private ArchitectureFilesSupportArchitect architect;
	
	private ArchitectureFilesSupportBusiness business;
	
	private ArchitectureFilesSupportReview review;
	
	private ArchitectureFilesSupportEvent event;
	
	private ArchitectureFilesSupportProject project;
	
	@Inject
	public ArchitectureFilesSupportManagerImpl(final ArchitectureFilesSupportArchitect architect,
			final ArchitectureFilesSupportBusiness business, final ArchitectureFilesSupportReview review,
			final ArchitectureFilesSupportEvent event, final ArchitectureFilesSupportProject project) {
		super();
		this.architect = architect;
		this.business = business;
		this.review = review;
		this.event = event;
		this.project = project;
	}

	@Override
	public ArchitectureFilesSupportArchitect getArchitectInstance() {
		return architect;
	}

	@Override
	public ArchitectureFilesSupportEvent getEventInstance() {
		return event;
	}

	@Override
	public ArchitectureFilesSupportReview getReviewInstance() {
		return review;
	}

	@Override
	public ArchitectureFilesSupportProject getProjectInstance() {
		return project;
	}

	@Override
	public ArchitectureFilesSupportBusiness getBusinessProject() {
		return business;
	}

	@Override
	public String getLink(Node node, String link) throws RepositoryException {
		try {
			if(node.isNodeType(architectureFilesSupportArchitectNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportArchitect);
			}
			else if(node.isNodeType(architectureFilesSupportEventNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportEvent);
			}
			else if(node.isNodeType(architectureFilesSupportProjectNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportProject);
			}
			else if(node.isNodeType(architectureFilesSupportBusinessNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportBusiness);
			}
			else if(node.isNodeType(architectureFilesSupportReviewINodeType) || node.isNodeType(architectureFilesSupportReviewIINodeType) || node.isNodeType(architectureFilesSupportReviewIIINodeType) || node.isNodeType(architectureFilesSupportReviewIVNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportReview);
			}
			else {
				return link;
			}
		} catch (RepositoryException e) {
			return link;
		}
	}

	@Override
	public boolean isSupport(Node node) throws RepositoryException {
		return node.isNodeType(architectureFilesSupportArchitectNodeType) || node.isNodeType(architectureFilesSupportEventNodeType) || node.isNodeType(architectureFilesSupportProjectNodeType) || node.isNodeType(architectureFilesSupportBusinessNodeType) || node.isNodeType(architectureFilesSupportReviewINodeType) || node.isNodeType(architectureFilesSupportReviewIINodeType) || node.isNodeType(architectureFilesSupportReviewIIINodeType) || node.isNodeType(architectureFilesSupportReviewIVNodeType);
	}

}
