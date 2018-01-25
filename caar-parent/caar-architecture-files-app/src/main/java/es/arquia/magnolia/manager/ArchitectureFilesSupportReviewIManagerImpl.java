package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationDate;

import java.util.List;

import javax.jcr.Node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.ArchitectureFilesSupportReviewI;
import es.arquia.magnolia.functions.QueryUtils;

public class ArchitectureFilesSupportReviewIManagerImpl implements ArchitectureFilesSupportReviewIManager {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportReviewIManagerImpl.class);
	
	@Override
	public List<Node> getArchitectureFilesSupportReviewIList() throws Exception{
		final int limit = 0;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportReviewINodeType + "] ORDER BY [" + presentationDate + "] DESC";
		return QueryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);
	}
	
	@Override
	public ArchitectureFilesSupportReviewI getInstance() {
		return new ArchitectureFilesSupportReviewI();
	}

}
