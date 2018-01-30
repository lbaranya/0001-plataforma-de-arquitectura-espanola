package es.arquia.magnolia.ui.workbench.tree.drop;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jcr.Item;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import info.magnolia.ui.vaadin.integration.contentconnector.ContentConnector;
import info.magnolia.ui.workbench.tree.drop.JcrDropConstraint;

import static es.arquia.magnolia.constants.AwardConstants.*;

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

	@Override
	protected boolean allowedSibling(Item source, Item target) {
		boolean movable = super.allowedSibling(source, target) && source.isNode();
		if(movable) {
			try {
				
				Node sourceNode = (Node) source;
				Node targetNode = (Node) target;
				if(!this.isAllowedAsSibling(sourceNode, targetNode)) {
					log.debug("Could not move a node type '{}' as sibling as node type '{}'", sourceNode.getPrimaryNodeType().getName(), targetNode.getPrimaryNodeType().getName());
					return false;
				}
			}catch(RepositoryException e) {
				
			}
		}
		return movable;
	}

	private boolean isAllowedAsSibling(Node sourceNode, Node targetNode) throws RepositoryException {
		if(sourceNode.isNodeType(editionNodeType)) {
			String newEditionState = sourceNode.getProperty("state").getValue().getString();
			boolean existState = false;
			if(newEditionState.equalsIgnoreCase("open")||newEditionState.equalsIgnoreCase("progress")) {
				Node parentNode = targetNode.getParent();
				NodeIterator parentIterator = parentNode.getNodes();
				while(parentIterator.hasNext() && !existState) {
					Node childNode = parentIterator.nextNode();
					String stateString = childNode.getProperty("state").getValue().getString();
					if((stateString.equalsIgnoreCase("open") || stateString.equalsIgnoreCase("progress")) && stateString.equalsIgnoreCase(newEditionState)) {
						existState = true;
					}else{
						existState = false;
					}
				}
			}
			return sourceNode.getPrimaryNodeType().getName().equals(targetNode.getPrimaryNodeType().getName()) && !existState;
		}else {
			if(sourceNode.isNodeType(awardNodeType)) {
				return sourceNode.getPrimaryNodeType().getName().equals(targetNode.getPrimaryNodeType().getName());
			}else {
				return false;
			}
		}
		
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
		if(!ret &&  targetNode.isNodeType(awardNodeType)) {
			ret = sourceNode.isNodeType(editionNodeType);
		}
		return ret;
	}

	private boolean isAward(Node targetNode) throws RepositoryException {
		return targetNode.isNodeType(awardNodeType);
	}
    
    
}
