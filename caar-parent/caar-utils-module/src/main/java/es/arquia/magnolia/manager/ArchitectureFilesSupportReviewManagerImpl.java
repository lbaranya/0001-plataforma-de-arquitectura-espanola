package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.URIPrefixArchitectureFilesSupportReview;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.URIRepositoryArchitectureFiles;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationDate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.functions.QueryUtils;
import es.arquia.magnolia.utils.ArchitectureFilesSupportReview;
import es.arquia.magnolia.utils.RelatedElement;

public class ArchitectureFilesSupportReviewManagerImpl implements ArchitectureFilesSupportReviewManager {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportReviewManagerImpl.class);
	private QueryUtils queryUtils;
	
	private ArchitectureFilesSupportReview architectureFilesSupportReview;
	
	private RelatedElementsManager relatedElementsManager;
	
	@Inject
	public ArchitectureFilesSupportReviewManagerImpl(final QueryUtils queryUtils, final ArchitectureFilesSupportReview architectureFilesSupportReview, final RelatedElementsManager relatedElementsManager) throws PathNotFoundException, RepositoryException {
        this.queryUtils = queryUtils;
        this.architectureFilesSupportReview = architectureFilesSupportReview;
        this.relatedElementsManager = relatedElementsManager;
    }
	
	@Override
	public List<Node> getArchitectureFilesSupportReviewIList() throws RepositoryException{
		final int limit = 4;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportReviewINodeType + "] ORDER BY [" + presentationDate + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);
	}
	
	@Override
	public ArchitectureFilesSupportReview getInstance() {
		return this.architectureFilesSupportReview;
	}
	
	@Override
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException {
		List<RelatedElement> tmpList = new ArrayList<>();
		Iterator<Node> iterator = relatedElements.iterator();
		while(iterator.hasNext()) {
			tmpList.add(relatedElementsManager.transformToRelatedElement(iterator.next()));
		}
		return tmpList;
	}
	
	@Override
	public String getLink(String link) {
		return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportReview);
	}

}
