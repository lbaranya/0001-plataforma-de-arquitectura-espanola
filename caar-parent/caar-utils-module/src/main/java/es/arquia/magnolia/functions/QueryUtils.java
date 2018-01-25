package es.arquia.magnolia.functions;

import static es.arquia.magnolia.constants.UtilsConstants.jcrLanguage;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Session;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import info.magnolia.context.MgnlContext;

public class QueryUtils {
	
	public static List<Node> executeSelectQuery(String sqlQuery, String workspace, int limit, int offset) throws Exception{
		List<Node> nodeList = new ArrayList<>();
		
		Session session = MgnlContext.getJCRSession(workspace);
		QueryManager qm = session.getWorkspace().getQueryManager();
		Query q = qm.createQuery(sqlQuery, jcrLanguage);
		q.setLimit(limit);
		q.setOffset(offset);
		QueryResult result = q.execute();
		NodeIterator nodeIterator = result.getNodes();
		
		while (nodeIterator.hasNext()) {
			nodeList.add((Node) nodeIterator.next());
		}
		
		return nodeList;
	}

}