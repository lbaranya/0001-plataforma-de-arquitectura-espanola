package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatAudioNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatBookNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatCartographicNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatContinuousNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatElectronicNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatGraphicNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatManuscriptNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatThreeDimensionalNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatVideoNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesPortfolioNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportBusinessNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportProjectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIIINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIVNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;
import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import info.magnolia.templating.functions.TemplatingFunctions;

public class HomeGridManagerImpl implements HomeGridManager {
	
	private TemplatingFunctions templatingFunctions;
	
	@Inject
	public HomeGridManagerImpl(final TemplatingFunctions templatingFunctions) {
		this.templatingFunctions = templatingFunctions;
	}
	
	public String getLink(Node node) throws RepositoryException {
		if (node.isNodeType(architectureFilesPortfolioNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesSupportArchitectNodeType)) {
			return templatingFunctions.link(node).replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportArchitect);
		}
		else if (node.isNodeType(architectureFilesSupportProjectNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesSupportReviewINodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesSupportReviewIINodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesSupportReviewIIINodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesSupportReviewIVNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesSupportEventNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesSupportBusinessNodeType)) {
			return templatingFunctions.link(node).replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportBusiness);
		}
		else if (node.isNodeType(architectureFilesFormatVideoNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesFormatManuscriptNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesFormatThreeDimensionalNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesFormatCartographicNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesFormatAudioNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesFormatBookNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesFormatGraphicNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesFormatContinuousNodeType)) {
			return "";
		}
		else if (node.isNodeType(architectureFilesFormatElectronicNodeType)) {
			return "";
		}
		return templatingFunctions.link(node);
	}

}