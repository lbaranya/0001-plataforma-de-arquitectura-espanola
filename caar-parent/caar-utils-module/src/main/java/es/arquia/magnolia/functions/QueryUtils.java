package es.arquia.magnolia.functions;

import java.util.List;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface QueryUtils {
	
	/**
	 * Execute a JCR query of type "select" and return resultant list of nodes. If you set limit or offset to 0 or less, they'll be ignored.
	 * @return nodeList
	 */
	public List<Node> executeSelectQuery(String sqlQuery, String workspace, int limit, int offset) throws LoginException, RepositoryException;
}