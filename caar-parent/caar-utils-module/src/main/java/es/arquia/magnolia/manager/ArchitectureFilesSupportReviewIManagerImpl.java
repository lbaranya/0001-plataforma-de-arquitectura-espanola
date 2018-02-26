package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationDate;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.functions.QueryUtils;
import es.arquia.magnolia.utils.ArchitectureFilesSupportReviewI;

public class ArchitectureFilesSupportReviewIManagerImpl implements ArchitectureFilesSupportReviewIManager {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportReviewIManagerImpl.class);
	private QueryUtils queryUtils;
	
	private ArchitectureFilesSupportReviewI architectureFilesSupportReviewI;
	
	@Inject
	public ArchitectureFilesSupportReviewIManagerImpl(final QueryUtils queryUtils, final ArchitectureFilesSupportReviewI architectureFilesSupportReviewI) throws PathNotFoundException, RepositoryException {
        this.queryUtils = queryUtils;
        this.architectureFilesSupportReviewI = architectureFilesSupportReviewI;
    }
	
	@Override
	public List<Node> getArchitectureFilesSupportReviewIList() throws Exception{
		final int limit = 4;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportReviewINodeType + "] ORDER BY [" + presentationDate + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);
	}
	
	@Override
	public ArchitectureFilesSupportReviewI getInstance() {
		return this.architectureFilesSupportReviewI;
	}

}
