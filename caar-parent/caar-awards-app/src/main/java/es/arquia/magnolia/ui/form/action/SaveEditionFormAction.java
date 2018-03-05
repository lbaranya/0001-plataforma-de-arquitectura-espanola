package es.arquia.magnolia.ui.form.action;

import static es.arquia.magnolia.constants.AwardConstants.editionState;
import static es.arquia.magnolia.constants.AwardConstants.editionStateClosed;
import static es.arquia.magnolia.constants.AwardConstants.editionStateInProgress;
import static es.arquia.magnolia.constants.AwardConstants.editionStateOpen;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.RepositoryException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.messages.magnoliaUI.MessagesUI;
import info.magnolia.cms.core.Path;
import info.magnolia.i18nsystem.SimpleTranslator;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.jcr.util.PropertyUtil;
import info.magnolia.ui.api.action.AbstractAction;
import info.magnolia.ui.api.action.ActionExecutionException;
import info.magnolia.ui.api.message.MessageType;
import info.magnolia.ui.form.EditorCallback;
import info.magnolia.ui.form.EditorValidator;
import info.magnolia.ui.vaadin.integration.jcr.JcrNodeAdapter;
import info.magnolia.ui.vaadin.integration.jcr.ModelConstants;

public class SaveEditionFormAction extends AbstractAction<SaveEditionFormActionDefinition> {

    private static final Logger log = LoggerFactory.getLogger(SaveEditionFormAction.class);

    protected final JcrNodeAdapter item;
    protected final EditorCallback callback;
    protected final EditorValidator validator;
    
    private final MessagesUI messagesUI;
    
    private final SimpleTranslator i18n;
    
    private static final String EDITION_SAVE_ERROR_SUBJECT = "caar-awards-app.message.ui.edition.save.subject";
    private static final String EDITION_SAVE_ERROR_MESSAGE = "caar-awards-app.message.ui.edition.save.messageText";

    public SaveEditionFormAction(SaveEditionFormActionDefinition definition, JcrNodeAdapter item, EditorCallback callback, EditorValidator validator, final MessagesUI messagesUI, final SimpleTranslator i18n) {
        super(definition);
        this.item = item;
        this.callback = callback;
        this.validator = validator;
        this.i18n = i18n;
        this.messagesUI = messagesUI;
    }

    @Override
    public void execute() throws ActionExecutionException {
        if (validateForm()) {
            try {
            	
            	final Node node = item.getJcrItem();
            	String oldState = PropertyUtil.getString(node, editionState);
                item.applyChanges(); // Changes applied will update all variables that point to this JCR item, because it is the nature of JcrNodeAdapter, so it is not necessary to assign the result of this line
                if(validateEditionState(item.getJcrItem(), oldState)) {
	                setNodeName(node, item);
	                node.getSession().save();
                }else {
                	messagesUI.sendToCurrentUser(MessageType.ERROR, this.i18n.translate(EDITION_SAVE_ERROR_SUBJECT), this.i18n.translate(EDITION_SAVE_ERROR_MESSAGE));
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
        String propertyName = "name";
        if (node.hasProperty(propertyName) && !node.hasProperty(ModelConstants.JCR_NAME)) {
            Property property = node.getProperty(propertyName);
            String newNodeName = property.getString();
            if (!node.getName().equals(Path.getValidatedLabel(newNodeName))) {
                newNodeName = Path.getUniqueLabel(node.getSession(), node.getParent().getPath(), Path.getValidatedLabel(newNodeName));
                item.setNodeName(newNodeName);
                NodeUtil.renameNode(node, newNodeName);
            }
        }
    }
    
    private boolean validateEditionState(Node node, String oldState) {
    	try {
			String newEditionState = node.getProperty(editionState).getValue().getString();
			if(! newEditionState.equalsIgnoreCase(oldState) || StringUtils.isEmpty(oldState)) {
				if(newEditionState.equalsIgnoreCase(editionStateOpen)||newEditionState.equalsIgnoreCase(editionStateInProgress)) {
					Node parentNode = node.getParent();
					NodeIterator parentIterator = parentNode.getNodes();
					boolean existState = false;
					while(parentIterator.hasNext() && !existState) {
						Node childNode = parentIterator.nextNode();
						if(!childNode.isSame(node)) {
							String stateString = childNode.getProperty(editionState).getValue().getString();
							if((stateString.equalsIgnoreCase(editionStateOpen) || stateString.equalsIgnoreCase(editionStateInProgress)) && stateString.equalsIgnoreCase(newEditionState)) {
								existState = true;
							}else{
								existState = false;
							}
						}
					}
					return !existState;
				}else {
					return true;
				}
			}else {
				return !(newEditionState.equals(editionStateInProgress) || newEditionState.equals(editionStateClosed));
			}
		} catch (IllegalStateException | RepositoryException e) {
			return true;
		}
    }
}
