package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.NewsConstants.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.News;
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
	public News getInstance() {
		return new News();
	}

}
