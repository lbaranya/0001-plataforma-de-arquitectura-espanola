package es.arquia.magnolia.manager;

import java.util.List;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.beans.Award;

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

}
