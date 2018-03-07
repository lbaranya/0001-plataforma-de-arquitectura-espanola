package es.arquia.magnolia.manager;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface HomeGridManager {

	String getLink(Node node) throws RepositoryException;

}
