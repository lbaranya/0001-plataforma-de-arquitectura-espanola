package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.NewsConstants.dateTime;
import static es.arquia.magnolia.constants.NewsConstants.important;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;
import static es.arquia.magnolia.constants.UtilsConstants.jcrLanguage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.apache.jackrabbit.commons.predicate.Predicate;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;
import javax.jcr.query.Query;
import javax.jcr.query.QueryManager;
import javax.jcr.query.QueryResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.News;
import info.magnolia.cms.util.QueryUtil;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.predicate.AbstractPredicate;
import info.magnolia.jcr.util.NodeUtil;

public class NewsManagerImpl implements NewsManager{
	
	private static final Logger log = LoggerFactory.getLogger(NewsManagerImpl.class);
	
	private static AbstractPredicate<Node> MAGNOLIA_NEWS_FILTER = new AbstractPredicate<Node>() {

        @Override
        public boolean evaluateTyped(Node node) {

            try {
                return node.isNodeType(newsNodeType);
            } catch (RepositoryException e) {
                log.error("Unable to read nodeType for node {}", NodeUtil.getNodePathIfPossible(node));
            }
            return false;
        }
    };
    
	@Override
	public List<Node> getNewsList() throws Exception{
		List<Node> newsList = new ArrayList<>();
		
		Session session = MgnlContext.getJCRSession(newsWorkspace);
		Node parentNewsNodeFolder = session.getRootNode();
		if(parentNewsNodeFolder.hasNodes()) {
			Iterable<Node> childList = NodeUtil.collectAllChildren(parentNewsNodeFolder, MAGNOLIA_NEWS_FILTER);
			newsList = NodeUtil.asList(childList);
		}
		// Dates comparison
		newsList.sort(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				try {
					return arg1.getProperty(dateTime).getDate().compareTo(arg0.getProperty(dateTime).getDate());
				} catch (ValueFormatException e) {
					e.printStackTrace();
				} catch (PathNotFoundException e) {
					e.printStackTrace();
				} catch (RepositoryException e) {
					e.printStackTrace();
				}
				return 0;
			}
			
		});
		
		return newsList;
	}
	
	@Override
	public List<Node> getImportantNewsList() throws Exception {
		final int maxNewsToShow = 2;
		List<Node> newsList = new ArrayList<>();
		
		String sqlQuery = "SELECT * FROM [" + newsNodeType + "] WHERE [" + important + "] IS NOT NULL ORDER BY [" + dateTime + "]";
		Session session = MgnlContext.getJCRSession(newsWorkspace);
		QueryManager qm = session.getWorkspace().getQueryManager();
		Query q = qm.createQuery(sqlQuery, jcrLanguage);
		q.setLimit(maxNewsToShow);
		QueryResult result = q.execute();
		NodeIterator nodes = result.getNodes();
		
		while (nodes.hasNext()) {
			newsList.add((Node) nodes.next());
		}
		
		return newsList;
	}

	@Override
	public News getInstance() {
		return new News();
	}

}
