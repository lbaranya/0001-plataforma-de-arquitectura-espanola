package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardWorkspace;
import static es.arquia.magnolia.constants.AwardConstants.editionState;
import static es.arquia.magnolia.constants.AwardConstants.editionStateInProgress;
import static es.arquia.magnolia.constants.AwardConstants.editionStateOpen;
import static es.arquia.magnolia.constants.AwardConstants.*;
import static es.arquia.magnolia.constants.AnnouncementConstants.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.apache.jackrabbit.commons.predicate.Predicate;

import com.google.common.collect.Lists;

import es.arquia.magnolia.functions.QueryUtils;
import es.arquia.magnolia.utils.AnnouncementNodeUtil;
import es.arquia.magnolia.utils.AwardNodeUtil;
import es.arquia.magnolia.utils.EventNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.jcr.util.NodeUtil;

public class AwardManagerImpl implements AwardManager{
	
	private QueryUtils queryUtils;
	
	private AwardNodeUtil award;
	
	private AnnouncementNodeUtil announcement;
	
	private EventNodeUtil eventNodeUtil;
	
	private RelatedElementsManager relatedElementsManager;
	
	@Inject
	public AwardManagerImpl(final QueryUtils queryUtils, final AwardNodeUtil award, final AnnouncementNodeUtil announcement, final EventNodeUtil eventNodeUtil, final RelatedElementsManager relatedElementsManager) {
        this.queryUtils = queryUtils;
        this.award = award;
        this.announcement = announcement;
        this.eventNodeUtil = eventNodeUtil;
        this.relatedElementsManager = relatedElementsManager;
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
	public EventNodeUtil getEventInstance() {
		return this.eventNodeUtil;
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
	
	public List<Node> getEvents(Node node) throws RepositoryException{
		Iterable<Node> tmpIterable = NodeUtil.collectAllChildren(node, new Predicate() {

			@Override
			public boolean evaluate(Object arg0) {
				Node tmpNode = (Node) arg0;
				try {
					return tmpNode.isNodeType(standardEventNodeType) || tmpNode.isNodeType(liveEventNodeType);
				} catch (RepositoryException e) {
					return false;
				}
			}
		});
		return Lists.newArrayList(tmpIterable);
	}
	
	@Override
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException {
		List<RelatedElement> tmpList = new ArrayList<>();
		Iterator<Node> iterator = relatedElements.iterator();
		while(iterator.hasNext()) {
			tmpList.add(relatedElementsManager.transformToRelatedElement(iterator.next()));
		}
		return tmpList;
	}

	@Override
	public String getAnnouncementState(Node node) throws RepositoryException {
		
		Node tmpEditionNode = null;
		Iterable<Node> tmpIterable = NodeUtil.collectAllChildren(node, new Predicate() {

			@Override
			public boolean evaluate(Object arg0) {
				Node tmpNode = (Node) arg0;
				try {
					return tmpNode.isNodeType(announcementNodeType) && tmpNode.getParent().isNodeType(editionNodeType) 
							&& award.getEditionState(tmpNode.getParent()).contains(editionStateOpen);
				}catch(RepositoryException e) {
					return false;
				}
			}
			
		});
		
		if(tmpIterable.iterator().hasNext()) {
			tmpEditionNode = tmpIterable.iterator().next();
		}
		
		return announcement.getAnnouncementState(tmpEditionNode);
	}

}
