package es.arquia.magnolia.ui.workbench.tree.drop;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatAudioFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatAudioNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatAudioWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatBookFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatBookNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatBookWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatCartographicFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatCartographicNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatCartographicWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatContinuousFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatContinuousNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatContinuousWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatElectronicFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatElectronicNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatElectronicWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatGraphicFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatGraphicNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatGraphicWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatManuscriptFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatManuscriptNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatManuscriptWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatThreeDimensionalFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatThreeDimensionalNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatThreeDimensionalWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatVideoFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatVideoNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatVideoWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesFormatWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesPortfolioFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesPortfolioNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesPortfolioWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportBusinessFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportBusinessNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportBusinessWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIIFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIIIFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIIINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIIIWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIIWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewINodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIVFolderWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIVNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIVWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportReviewIWrapperNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportWrapperNodeType;

import javax.inject.Inject;
import javax.jcr.Item;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.constants.ArchitectureFilesConstants;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.ui.vaadin.integration.contentconnector.ContentConnector;
import info.magnolia.ui.workbench.tree.drop.JcrDropConstraint;

public class ArchitectureFilesJcrContentDropConstraint extends JcrDropConstraint {

    private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesJcrContentDropConstraint.class);

    @Inject
    public ArchitectureFilesJcrContentDropConstraint(ContentConnector contentConnector) {
        super(contentConnector);
    }

    @Override
    protected boolean allowedAsChild(Item source, Item target) {
    	
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
    
    /**
     * @param sourceNode
     * @param targetNode
     * @return true if file node is allowed to move into target node
     * @throws RepositoryException 
     */
    private boolean isAllowedAsChild(Node sourceNode, Node targetNode) throws RepositoryException {
    	
    	boolean ret = false;
    	
    	if (!ret && this.isSupportNode(targetNode)) {
			
    		ret = this.targetSupportNodeAllowSourceNode(sourceNode, targetNode);
    		
		}else if (!ret && this.isFormatNode(targetNode)) {
			
			ret = this.targetFormatNodeAllowSourceNode(sourceNode, targetNode);
			
		}else if (!ret && this.isPortfolioNode(targetNode)) {
			
			ret = this.targetPortfolioNodeAllowSourceNode(sourceNode, targetNode);
			
		}
    	
    	return ret;
    }
    
    @Override
    protected boolean allowedSibling(Item source, Item target) {
    	boolean movable = super.allowedAsChild(source, target) && source.isNode();
        if (movable) {
        	
            try {
            	
                Node sourceNode = (Node) source;
                Node targetNode = (Node) target;
            	
            	if (! this.isAllowedAsSibling(sourceNode, targetNode)) {

                    log.debug("Could not move a node type '{}' as sibling to a node type '{}'", sourceNode.getPrimaryNodeType().getName(), targetNode.getPrimaryNodeType().getName());
                    return false;
				}
                
            } catch (RepositoryException e) {
                log.warn("Could not check if siblings are allowed. ", e);
            }
        }

        return movable;
    }
    
    private boolean isAllowedAsSibling(Node sourceNode, Node targetNode) throws RepositoryException {
    	
    	boolean ret = false;
    	
    	if(sourceNode.getPrimaryNodeType().equals(targetNode.getPrimaryNodeType())) {
    		return true;
    	}else {
    		if(isSupportNode(sourceNode)) {
    			if(isSupportWrapperNode(sourceNode) && isSupportWrapperNode(targetNode)) {
    				ret = true;
    			}else {
    				if((isSupportTypeNode(sourceNode) || isSupportFolderNode(sourceNode)) && (isSupportTypeNode(targetNode) || isSupportFolderNode(targetNode)) && isAllowedAsChild(sourceNode, targetNode.getParent())){
    					ret = true;
    				}
    			}
    		}else {
    			if(isFormatWrapperNode(sourceNode) && isFormatWrapperNode(targetNode)) {
    				ret = true;
    			}else {
    				if((isFormatTypeNode(sourceNode) || isFormatFolderNode(sourceNode)) && (isFormatTypeNode(targetNode) || isFormatFolderNode(targetNode)) && isAllowedAsChild(sourceNode, targetNode.getParent())){
    					ret = true;
    				}
    			}
    		}
    	}
    	return ret;
    	
    }



	/**
	 * @param targetNode
	 * @return true if node type is one of the support types
	 * @throws RepositoryException 
	 */
	private boolean isSupportNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesSupportNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesSupportNodeTypes[i]);
		}
		
		return ret;
	}
	
	private boolean isSupportWrapperNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesSupportWrapperNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesSupportWrapperNodeTypes[i]);
		}
		
		return ret;
	}
	
	private boolean isSupportFolderNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesSupportFolderNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesSupportFolderNodeTypes[i]);
		}
		
		return ret;
	}
	
	private boolean isSupportTypeNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesSupportNodesNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesSupportNodesNodeTypes[i]);
		}
		
		return ret;
	}

	/**
	 * @param sourceNode
	 * @param targetNode
	 * @return true if source node is allowed to be moved into support target node  
	 * @throws RepositoryException 
	 */
	private boolean targetSupportNodeAllowSourceNode(Node sourceNode, Node targetNode) throws RepositoryException {

		boolean ret = false;
		
		/** GENERAL SUPPORT WRAPPER **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportArchitectWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIIWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIIIWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIVWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportBusinessWrapperNodeType);
		}
		/*****************************/
		
		/** SUPPORT ARCHITECT **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportArchitectWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportArchitectFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportArchitectNodeType);
		}
		
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportArchitectFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportArchitectFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportArchitectNodeType);
		}
		/*****************************/
		
		/** SUPPORT REVIEW I **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportReviewIWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewINodeType);
		}
		
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportReviewIFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewINodeType);
		}
		/*****************************/
		
		/** SUPPORT REVIEW II **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportReviewIIWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIIFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIINodeType);
		}
		
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportReviewIIFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIIFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIINodeType);
		}
		/*****************************/
		
		/** SUPPORT REVIEW III **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportReviewIIIWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIIIFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIIINodeType);
		}
		
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportReviewIIIFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIIIFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIIINodeType);
		}
		/*****************************/
		
		/** SUPPORT REVIEW IV **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportReviewIVWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIVFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIVNodeType);
		}
		
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportReviewIVFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIVFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportReviewIVNodeType);
		}
		/*****************************/
		
		/** SUPPORT BUSINESS **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportBusinessWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportBusinessFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportBusinessNodeType);
		}
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesSupportBusinessFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesSupportBusinessFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesSupportBusinessNodeType);
		}
		/*****************************/
		
		return ret;
	}
	
	/**
	 * @param targetNode
	 * @return true if node type is one of the format types
	 * @throws RepositoryException 
	 */
	private boolean isFormatNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesFormatNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesFormatNodeTypes[i]);
		}
		
		return ret;
	}
	
	private boolean isFormatWrapperNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesFormatWrapperNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesFormatWrapperNodeTypes[i]);
		}
		
		return ret;
	}
	
	private boolean isFormatFolderNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesFormatFolderNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesFormatFolderNodeTypes[i]);
		}
		
		return ret;
	}
	
	private boolean isFormatTypeNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesFormatNodesNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesFormatNodesNodeTypes[i]);
		}
		
		return ret;
	}


	/**
	 * @param sourceNode
	 * @param targetNode
	 * @return true if source node is allowed to be moved into format target node  
	 * @throws RepositoryException 
	 */
	private boolean targetFormatNodeAllowSourceNode(Node sourceNode, Node targetNode) throws RepositoryException {

		boolean ret = false;
		
		/** GENERAL FORMAT WRAPPER **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatVideoWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatManuscriptWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatThreeDimensionalWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatCartographicWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatAudioWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatBookWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatGraphicWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatContinuousWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatElectronicWrapperNodeType);
		}
		/*****************************/
		
		/** FORMAT VIDEO **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatVideoWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatVideoFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatVideoNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatVideoFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatVideoFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatVideoNodeType);
		}
		/*****************************/
		
		/** FORMAT MANUSCRIPT **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatManuscriptWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatManuscriptFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatManuscriptNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatManuscriptFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatManuscriptFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatManuscriptNodeType);
		}
		/*****************************/
		
		/** FORMAT THREE DIMENSIONAL **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatThreeDimensionalWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatThreeDimensionalFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatThreeDimensionalNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatThreeDimensionalFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatThreeDimensionalFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatThreeDimensionalNodeType);
		}
		/*****************************/
		
		/** FORMAT CARTOGRAPHIC **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatCartographicWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatCartographicFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatCartographicNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatCartographicFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatCartographicFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatCartographicNodeType);
		}
		/*****************************/
		
		/** FORMAT AUDIO **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatAudioWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatAudioFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatAudioNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatAudioFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatAudioFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatAudioNodeType);
		}
		/*****************************/
		
		/** FORMAT BOOK **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatBookWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatBookFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatBookNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatBookFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatBookFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatBookNodeType);
		}
		/*****************************/
		
		/** FORMAT GRAPHIC **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatGraphicWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatGraphicFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatGraphicNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatGraphicFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatGraphicFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatGraphicNodeType);
		}
		/*****************************/
		
		/** FORMAT CONTINUOUS **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatContinuousWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatContinuousFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatContinuousNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatContinuousFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatContinuousFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatContinuousNodeType);
		}
		/*****************************/
		
		/** FORMAT ELECTRONIC **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatElectronicWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatElectronicFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatElectronicNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesFormatElectronicFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesFormatElectronicFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesFormatElectronicNodeType);
		}
		/*****************************/
		
		return ret;
	}

	/**
	 * @param targetNode
	 * @return true if node type is one of the portfolio types
	 * @throws RepositoryException 
	 */
	private boolean isPortfolioNode(Node targetNode) throws RepositoryException {
		
		boolean ret = false;
		
		for (int i = 0; i < ArchitectureFilesConstants.architectureFilesPortfolioNodeTypes.length && !ret; i++) {
			
			ret = NodeUtil.isNodeType(targetNode, ArchitectureFilesConstants.architectureFilesPortfolioNodeTypes[i]);
		}
		
		return ret;
	}

	/**
	 * @param sourceNode
	 * @param targetNode
	 * @return true if source node is allowed to be moved into portfolio target node  
	 * @throws RepositoryException 
	 */
	private boolean targetPortfolioNodeAllowSourceNode(Node sourceNode, Node targetNode) throws RepositoryException {

		boolean ret = false;
		
		/** PORTFOLIO **/
		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesPortfolioWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesPortfolioFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesPortfolioNodeType);
		}

		if (! ret && NodeUtil.isNodeType(targetNode, architectureFilesPortfolioFolderWrapperNodeType)) {
			
			ret = NodeUtil.isNodeType(sourceNode, architectureFilesPortfolioFolderWrapperNodeType) 
					|| NodeUtil.isNodeType(sourceNode, architectureFilesPortfolioNodeType);
		}
		/*****************************/
		
		return ret;
	}

}
