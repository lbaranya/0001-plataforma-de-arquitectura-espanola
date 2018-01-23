package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportReviewIConstants.presentationDate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.ArchitectureFilesSupportReviewI;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.predicate.AbstractPredicate;
import info.magnolia.jcr.util.NodeUtil;

public class ArchitectureFilesSupportReviewIManagerImpl implements ArchitectureFilesSupportReviewIManager {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportReviewIManagerImpl.class);
	
	private static AbstractPredicate<Node> MAGNOLIA_REVIEW_I_FILTER = new AbstractPredicate<Node>() {

        @Override
        public boolean evaluateTyped(Node node) {

            try {
                return node.isNodeType(architectureFilesSupportReviewINodeType);
            } catch (RepositoryException e) {
                log.error("Unable to read nodeType for node {}", NodeUtil.getNodePathIfPossible(node));
            }
            return false;
        }
    };
    
	@Override
	public List<Node> getArchitectureFilesSupportReviewIList() throws Exception{
		List<Node> eventsList = new ArrayList<>();
		
		Session session = MgnlContext.getJCRSession(architectureFilesWorkspace);
		Node parentNewsNodeFolder = session.getRootNode();
		if(parentNewsNodeFolder.hasNodes()) {
			Iterable<Node> childList = NodeUtil.collectAllChildren(parentNewsNodeFolder, MAGNOLIA_REVIEW_I_FILTER);
			eventsList = NodeUtil.asList(childList);
		}
		// Dates comparison
		eventsList.sort(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				try {
					return arg1.getProperty(presentationDate).getDate().compareTo(arg0.getProperty(presentationDate).getDate());
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
		
		return eventsList;
	}
	
	@Override
	public ArchitectureFilesSupportReviewI getInstance() {
		return new ArchitectureFilesSupportReviewI();
	}

}
