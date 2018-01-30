package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardWorkspace;
import static es.arquia.magnolia.constants.AwardConstants.type;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Awards;
import es.arquia.magnolia.functions.QueryUtils;

public class AwardsManagerImpl implements AwardsManager {
	
	private QueryUtils queryUtils;
	
	@Inject
	public AwardsManagerImpl(final QueryUtils queryUtils) throws PathNotFoundException, RepositoryException {
        this.queryUtils = queryUtils;
    }

	@Override
	public List<Node> getAwardsList() throws Exception {
		final int limit = 6;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + awardNodeType + "] WHERE [" + type + "] LIKE 'standard' ORDER BY [" + "mgnl:lastModified" + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, awardWorkspace, limit, offset);
	}

	@Override
	public List<Node> getBiennialsList() throws Exception {
		final int limit = 6;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + awardNodeType + "] WHERE [" + type + "] LIKE 'biennial' ORDER BY [" + "mgnl:lastModified" + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, awardWorkspace, limit, offset);
	}

	@Override
	public Awards getInstance() {
		return new Awards();
	}

}
