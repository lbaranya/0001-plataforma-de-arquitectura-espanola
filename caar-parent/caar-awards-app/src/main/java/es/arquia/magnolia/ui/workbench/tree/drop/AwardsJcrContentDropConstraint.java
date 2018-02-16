package es.arquia.magnolia.ui.workbench.tree.drop;

import static es.arquia.magnolia.constants.AnnouncementConstants.announcementNodeType;
import static es.arquia.magnolia.constants.AwardConstants.awardNodeType;
import static es.arquia.magnolia.constants.AwardConstants.editionNodeType;
import static es.arquia.magnolia.constants.AwardConstants.editionState;
import static es.arquia.magnolia.constants.AwardConstants.editionStateInProgress;
import static es.arquia.magnolia.constants.AwardConstants.editionStateOpen;
import static es.arquia.magnolia.constants.AwardConstants.programNodeType;

import javax.inject.Inject;
import javax.jcr.Item;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
			String newEditionState = sourceNode.getProperty(editionState).getValue().getString();
			boolean existState = false;
			if(newEditionState.equalsIgnoreCase(editionStateOpen)||newEditionState.equalsIgnoreCase(editionStateInProgress)) {
				Node parentNode = targetNode.getParent();
				NodeIterator parentIterator = parentNode.getNodes();
				while(parentIterator.hasNext() && !existState) {
					Node childNode = parentIterator.nextNode();
					String stateString = childNode.getProperty(editionState).getValue().getString();
					if((stateString.equalsIgnoreCase(editionStateOpen) || stateString.equalsIgnoreCase(editionStateInProgress)) && stateString.equalsIgnoreCase(newEditionState)) {
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
		return this.targetNodeAllowSourceNode(sourceNode, targetNode);
	}

	private boolean targetNodeAllowSourceNode(Node sourceNode, Node targetNode) throws RepositoryException {
		boolean ret = false;
		if(!ret &&  targetNode.isNodeType(awardNodeType)) {
			ret = sourceNode.isNodeType(editionNodeType);
		}else {
			if(!ret && targetNode.isNodeType(editionNodeType)) {
				ret = sourceNode.isNodeType(programNodeType) || sourceNode.isNodeType(announcementNodeType);
			}
		}
		return ret;
	}
    
    
}
