package es.arquia.magnolia.ui.workbench.drop;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Item;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import info.magnolia.ui.vaadin.integration.contentconnector.ContentConnector;
import info.magnolia.ui.workbench.tree.drop.JcrDropConstraint;

public class AwardsJcrContentDropConstraint extends JcrDropConstraint{
	private static final Logger log = LoggerFactory.getLogger(AwardsJcrContentDropConstraint.class);

    @Inject
    public AwardsJcrContentDropConstraint(ContentConnector contentConnector) {
        super(contentConnector);
    }

	@Override
	public boolean allowedAsChild(Item source, Item target) {
		boolean movable = super.allowedAsChild(source, target) && source.isNode();
        if (movable) {
        	
            try {
            	
                Node sourceNode = (Node) source;
                Node targetNode = (Node) target;
            	
            	if (! this.isAllowedAsChild(sourceNode, targetNode)) {

                    log.debug("Could not move a node type '{}' under a node type '{}'", sourceNode.getPrimaryNodeType().getName(), targetNode.getPrimaryNodeType().getName());
                    return false;
				}
                
            } catch (RepositoryException e) {
                log.warn("Could not check if child is allowed. ", e);
            }
        }

        return movable;
	}

	private boolean isAllowedAsChild(Node sourceNode, Node targetNode) throws RepositoryException {
		boolean ret = false;
		if(!ret && this.isAward(targetNode)) {
			ret = this.targetNodeAllowSourceNode(sourceNode, targetNode);
		}
		return ret;
	}

	private boolean targetNodeAllowSourceNode(Node sourceNode, Node targetNode) throws RepositoryException {
		boolean ret = false;
		if(!ret &&  targetNode.isNodeType("mgnl:award")) {
			ret = sourceNode.isNodeType("mgnl:edition");
		}
		return ret;
	}

	private boolean isAward(Node targetNode) throws RepositoryException {
		return targetNode.isNodeType("mgnl:award");
	}
    
    
}
