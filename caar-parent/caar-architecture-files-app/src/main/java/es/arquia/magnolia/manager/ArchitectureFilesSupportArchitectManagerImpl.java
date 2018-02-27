package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.functions.QueryUtils;

public class ArchitectureFilesSupportArchitectManagerImpl {
	
	private QueryUtils queryUtils;
	private ArchitectureFilesSupportArchitect architectureFilesSupportArchitect;
	
	@Inject
	public ArchitectureFilesSupportArchitectManagerImpl(final QueryUtils queryUtils, final ArchitectureFilesSupportArchitect architectureFilesSupportArchitect) {
        this.queryUtils = queryUtils;
        this.architectureFilesSupportArchitect = architectureFilesSupportArchitect;
    }
	
	public List<Node> getArchitectsList() throws RepositoryException {
		final int limit = 8;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportArchitectNodeType + "] ORDER BY [" + "mgnl:lastModified" + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);	
	}
	
	public List<Node> getLastModifiedArchitects() throws RepositoryException {
		final int limit = 2;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportArchitectNodeType + "] ORDER BY [" + "mgnl:lastModified" + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);	
	}
	
	public ArchitectureFilesSupportArchitect getInstance() {
		return architectureFilesSupportArchitect;
	}

}
