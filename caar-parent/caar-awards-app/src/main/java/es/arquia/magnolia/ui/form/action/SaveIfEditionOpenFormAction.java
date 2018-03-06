package es.arquia.magnolia.ui.form.action;

import static es.arquia.magnolia.constants.AwardConstants.editionState;
import static es.arquia.magnolia.constants.AwardConstants.editionStateOpen;
import static es.arquia.magnolia.constants.AwardConstants.standardEventNodeType;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.messages.magnoliaUI.MessagesUI;
import info.magnolia.i18nsystem.SimpleTranslator;
import info.magnolia.jcr.util.NodeNameHelper;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.jcr.util.PropertyUtil;
import info.magnolia.ui.api.action.AbstractAction;
import info.magnolia.ui.api.action.ActionExecutionException;
import info.magnolia.ui.api.message.MessageType;
import info.magnolia.ui.form.EditorCallback;
import info.magnolia.ui.form.EditorValidator;
import info.magnolia.ui.vaadin.integration.jcr.JcrNodeAdapter;
import info.magnolia.ui.vaadin.integration.jcr.ModelConstants;

public class SaveIfEditionOpenFormAction extends AbstractAction<SaveIfEditionOpenFormActionDefinition> {

    private static final Logger log = LoggerFactory.getLogger(SaveIfEditionOpenFormAction.class);

    protected final JcrNodeAdapter item;
    protected final EditorCallback callback;
    protected final EditorValidator validator;
    
    private final MessagesUI messagesUI;
    
    private final SimpleTranslator i18n;
    
    private final NodeNameHelper nodeNameHelper;
    
    private static final String ITEM_SAVE_ERROR_SUBJECT = "caar-awards-app.message.ui.item.save.subject";
    private static final String ITEM_SAVE_ERROR_MESSAGE = "caar-awards-app.message.ui.item.save.messageText";

    public SaveIfEditionOpenFormAction(SaveIfEditionOpenFormActionDefinition definition, JcrNodeAdapter item, EditorCallback callback, EditorValidator validator, final MessagesUI messagesUI, final SimpleTranslator i18n, final NodeNameHelper nodeNameHelper) {
        super(definition);
        this.item = item;
        this.callback = callback;
        this.validator = validator;
        this.i18n = i18n;
        this.messagesUI = messagesUI;
        this.nodeNameHelper = nodeNameHelper;
    }

    @Override
    public void execute() throws ActionExecutionException {
        if (validateForm()) {
            try {
                final Node node = item.applyChanges();
                if(validateEditionState(item.getJcrItem())) {
	                setNodeName(node, item);
	                node.getSession().save();
                }else {
                	messagesUI.sendToCurrentUser(MessageType.ERROR, this.i18n.translate(ITEM_SAVE_ERROR_SUBJECT), this.i18n.translate(ITEM_SAVE_ERROR_MESSAGE));
                }
            } catch (final RepositoryException e) {
                throw new ActionExecutionException(e);
            }
            callback.onSuccess(getDefinition().getName());
        }
    }

    protected boolean validateForm() {
        boolean isValid = validator.isValid();
        validator.showValidation(!isValid);
        if (!isValid) {
            log.info("Validation error(s) occurred. No save performed.");
        }
        return isValid;
    }

    /**
     * Set the node Name.
     * Node name is set to: <br>
     * the value of the property 'name' if it is present.
     */
    protected void setNodeName(Node node, JcrNodeAdapter item) throws RepositoryException {
    	String propertyName = ModelConstants.JCR_NAME;
        if (node.hasProperty(propertyName) && !node.hasProperty(ModelConstants.JCR_NAME)) {
            Property property = node.getProperty(propertyName);
            String newNodeName = property.getString();
            if (!node.getName().equals(nodeNameHelper.getValidatedName(newNodeName))) {
                newNodeName = nodeNameHelper.getUniqueName(node.getSession(), node.getParent().getPath(), nodeNameHelper.getValidatedName(newNodeName));
                item.setNodeName(newNodeName);
                NodeUtil.renameNode(node, newNodeName);
            }
        }
    }
    
    private boolean validateEditionState(Node node) {
    	try {
    		Node currentNode = node;
    		if(node.isNodeType(standardEventNodeType)) {
    			currentNode = currentNode.getParent();
    		}
    		return PropertyUtil.getString(currentNode.getParent(), editionState).equalsIgnoreCase(editionStateOpen);
		} catch (IllegalStateException | RepositoryException e) {
			return true;
		}
    }
}
