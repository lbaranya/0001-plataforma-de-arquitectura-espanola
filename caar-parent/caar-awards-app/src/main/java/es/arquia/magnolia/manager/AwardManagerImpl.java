package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardWorkspace;
import static es.arquia.magnolia.constants.AwardConstants.editionState;
import static es.arquia.magnolia.constants.AwardConstants.editionStateInProgress;
import static es.arquia.magnolia.constants.AwardConstants.editionStateOpen;
import static es.arquia.magnolia.constants.AwardConstants.type;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.functions.QueryUtils;
import es.arquia.magnolia.utils.AnnouncementNodeUtil;
import es.arquia.magnolia.utils.AwardNodeUtil;

public class AwardManagerImpl implements AwardManager{
	
	private QueryUtils queryUtils;
	
	private AwardNodeUtil award;
	
	private AnnouncementNodeUtil announcement;
	
	@Inject
	public AwardManagerImpl(final QueryUtils queryUtils, final AwardNodeUtil award, final AnnouncementNodeUtil announcement) {
        this.queryUtils = queryUtils;
        this.award = award;
        this.announcement = announcement;
    }

	@Override
	public List<Node> getAwardList() throws RepositoryException {
		final int limit = 6;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + awardNodeType + "] WHERE [" + type + "] LIKE 'standard' ORDER BY [" + "mgnl:lastModified" + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, awardWorkspace, limit, offset);
	}

	@Override
	public List<Node> getBiennialList() throws RepositoryException {
		final int limit = 6;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + awardNodeType + "] WHERE [" + type + "] LIKE 'biennial' ORDER BY [" + "mgnl:lastModified" + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, awardWorkspace, limit, offset);
	}

	@Override
	public AwardNodeUtil getInstance() {
		return this.award;
	}
	
	@Override
	public AnnouncementNodeUtil getAnnouncementInstance() {
		return this.announcement;
	}

	@Override
	public Node getEditionStateOpen(Node node) throws RepositoryException {
		if(node.isNodeType(awardNodeType)) {
			boolean foundNode = false;
			Node found = null;
			NodeIterator nodeIterator = node.getNodes();
			while(nodeIterator.hasNext() && !foundNode) {
				found = nodeIterator.nextNode();
				foundNode = found.getProperty(editionState).getValue().getString().equalsIgnoreCase(editionStateOpen);
			}
			return found;
		}
		return null;
	}

	@Override
	public Node getEditionStateInProgress(Node node) throws RepositoryException {
		if(node.isNodeType(awardNodeType)) {
			boolean foundNode = false;
			Node found = null;
			NodeIterator nodeIterator = node.getNodes();
			while(nodeIterator.hasNext() && !foundNode) {
				found = nodeIterator.nextNode();
				foundNode = found.getProperty(editionState).getValue().getString().equalsIgnoreCase(editionStateInProgress);
			}
			return foundNode?found:null;
		}
		return null;
	}

}
