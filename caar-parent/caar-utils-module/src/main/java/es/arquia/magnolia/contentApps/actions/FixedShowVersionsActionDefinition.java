/**
 * 
 */
package es.arquia.magnolia.contentApps.actions;

import info.magnolia.ui.api.action.ConfiguredActionDefinition;

/**
 * @author David Caviedes
 *
 */
public class FixedShowVersionsActionDefinition extends ConfiguredActionDefinition {

	 private String subAppId;
	
    public FixedShowVersionsActionDefinition() {
        setImplementationClass(FixedShowVersionsAction.class);
    }

	public String getSubAppId() {
		return subAppId;
	}

	public void setSubAppId(String subAppId) {
		this.subAppId = subAppId;
	}
}
