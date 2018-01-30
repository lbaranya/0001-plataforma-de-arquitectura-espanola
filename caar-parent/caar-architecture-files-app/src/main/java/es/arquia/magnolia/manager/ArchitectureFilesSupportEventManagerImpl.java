package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationStartDate;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.functions.QueryUtils;

public class ArchitectureFilesSupportEventManagerImpl implements ArchitectureFilesSupportEventManager {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportEventManagerImpl.class);
	private QueryUtils queryUtils;
	
	@Inject
	public ArchitectureFilesSupportEventManagerImpl(final QueryUtils queryUtils) throws PathNotFoundException, RepositoryException {
        this.queryUtils = queryUtils;
    }
	
	@Override
	public List<Node> getArchitectureFilesSupportEventList() throws Exception{
		final int limit = 4;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportEventNodeType + "] ORDER BY [" + presentationStartDate + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);
	}
	
	@Override
	public ArchitectureFilesSupportEvent getInstance() {
		return new ArchitectureFilesSupportEvent();
	}

}
