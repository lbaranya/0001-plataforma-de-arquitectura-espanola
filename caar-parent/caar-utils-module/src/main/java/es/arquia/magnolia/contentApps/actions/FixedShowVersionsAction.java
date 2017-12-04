/**
 * 
 */
package es.arquia.magnolia.contentApps.actions;

import info.magnolia.i18nsystem.SimpleTranslator;
import info.magnolia.ui.api.action.ActionExecutionException;
import info.magnolia.ui.api.app.AppContext;
import info.magnolia.ui.api.context.UiContext;
import info.magnolia.ui.api.location.Location;
import info.magnolia.ui.api.location.LocationController;
import info.magnolia.ui.contentapp.browser.action.ShowVersionsAction;
import info.magnolia.ui.contentapp.detail.DetailLocation;
import info.magnolia.ui.contentapp.detail.DetailView;
import info.magnolia.ui.dialog.formdialog.FormDialogPresenter;
import info.magnolia.ui.vaadin.integration.contentconnector.ContentConnector;
import info.magnolia.ui.vaadin.integration.jcr.AbstractJcrNodeAdapter;

/**
 * @author David Caviedes
 *
 * Class to fix problem commented in https://jira.magnolia-cms.com/browse/SUPPORT-8185
 *
 */
public class FixedShowVersionsAction<D extends FixedShowVersionsActionDefinition> extends ShowVersionsAction<D> {
    
	private final ContentConnector contentConnector;
    private final AppContext appContext;

	public FixedShowVersionsAction(D definition, AppContext appContext, LocationController locationController,
			UiContext uiContext, FormDialogPresenter formDialogPresenter, AbstractJcrNodeAdapter nodeAdapter,
			SimpleTranslator i18n, ContentConnector contentConnector) {
		super(definition, appContext, locationController, uiContext, formDialogPresenter, nodeAdapter, i18n, contentConnector);

        this.appContext = appContext;
        this.contentConnector = contentConnector;
	}

    @Override
    protected Location getLocation() throws ActionExecutionException {
        try {
            Object itemId = contentConnector.getItemId(nodeAdapter);
            String path = contentConnector.getItemUrlFragment(itemId);
            return new DetailLocation(appContext.getName(), this.getDefinition().getSubAppId(), DetailView.ViewType.VIEW, path, getVersionName());
        } catch (Exception e) {
            throw new ActionExecutionException("Could not get location from nodeAdapter " + nodeAdapter.getItemId());
        }
    }

}
