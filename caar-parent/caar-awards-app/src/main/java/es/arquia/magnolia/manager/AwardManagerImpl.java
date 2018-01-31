package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Award;

import static es.arquia.magnolia.constants.AwardConstants.*;

public class AwardManagerImpl implements AwardManager{

	@Override
	public List<Node> getAwardList() throws RepositoryException {
		return null;
	}

	@Override
	public List<Node> getBiennialList() throws RepositoryException {
		return null;
	}

	@Override
	public List<Node> getStandardAwardList() throws RepositoryException {
		return null;
	}

	@Override
	public Award getInstance() {
		return new Award();
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
