package es.arquia.magnolia.ui.contentapp.detail.action;

import javax.inject.Inject;
import javax.jcr.Node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.v7.data.Item;

import es.arquia.magnolia.constants.AwardConstants;
import es.arquia.magnolia.messages.magnoliaUI.MessagesUI;
import es.arquia.magnolia.utils.AwardNodeUtil;
import info.magnolia.context.MgnlContext;
import info.magnolia.i18nsystem.SimpleTranslator;
import info.magnolia.ui.api.action.AbstractAction;
import info.magnolia.ui.api.action.ActionExecutionException;
import info.magnolia.ui.api.location.LocationController;
import info.magnolia.ui.api.message.MessageType;
import info.magnolia.ui.contentapp.detail.DetailLocation;
import info.magnolia.ui.contentapp.detail.DetailView;
import info.magnolia.ui.vaadin.integration.contentconnector.ContentConnector;

public class EditionLimitEditItemAction extends AbstractAction<EditionLimitEditItemActionDefinition> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final Item nodeItemToEdit;
    private final LocationController locationController;
    private final ContentConnector contentConnector;
    
    private final AwardNodeUtil awardNodeUtil;
    
    private final MessagesUI messagesUI;
    
    private final SimpleTranslator i18n;
    
    private static final String ANNOUNCEMENT_EDIT_ERROR_SUBJECT = "caar-awards-app.message.ui.announcement.edit.subject";
    private static final String ANNOUNCEMENT_EDIT_ERROR_MESSAGE = "caar-awards-app.message.ui.announcement.edit.messageText";

    @Inject
    public EditionLimitEditItemAction(EditionLimitEditItemActionDefinition definition, Item nodeItemToEdit, LocationController locationController, ContentConnector contentConnector, final AwardNodeUtil awardNodeUtil, final MessagesUI messagesUI, final SimpleTranslator i18n) {
        super(definition);
        this.nodeItemToEdit = nodeItemToEdit;
        this.locationController = locationController;
        this.contentConnector = contentConnector;
        this.awardNodeUtil = awardNodeUtil;
        this.messagesUI = messagesUI;
        this.i18n = i18n;
    }

    @Override
    public void execute() throws ActionExecutionException {
        try {
            Object itemId = contentConnector.getItemId(nodeItemToEdit);
            if (!contentConnector.canHandleItem(itemId)) {
                log.warn("EditItemAction requested for a node type definition {}. Current node type is {}. No action will be performed.", getDefinition(), String.valueOf(itemId));
                return;
            }

            final String path = contentConnector.getItemUrlFragment(itemId);
            /*	Edition's state validation	*/
            Node announcementNode = MgnlContext.getJCRSession(AwardConstants.awardWorkspace).getNode(path);
            Node editionNode = announcementNode.getParent();
            if(editionNode.isNodeType(AwardConstants.editionNodeType) && awardNodeUtil.getEditionState(editionNode).contains(AwardConstants.editionStateOpen)) {
	            DetailLocation location = new DetailLocation(getDefinition().getAppName(), getDefinition().getSubAppId(), DetailView.ViewType.EDIT, path, "");
	            locationController.goTo(location);
            }else {
            	messagesUI.sendToCurrentUser(MessageType.ERROR, this.i18n.translate(ANNOUNCEMENT_EDIT_ERROR_SUBJECT), this.i18n.translate(ANNOUNCEMENT_EDIT_ERROR_MESSAGE));
            }

        } catch (Exception e) {
            throw new ActionExecutionException("Could not execute EditItemAction: ", e);
        }
    }
}

