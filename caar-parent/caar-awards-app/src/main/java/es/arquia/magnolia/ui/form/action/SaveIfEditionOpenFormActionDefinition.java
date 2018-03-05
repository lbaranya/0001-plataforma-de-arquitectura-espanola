package es.arquia.magnolia.ui.form.action;

import info.magnolia.ui.api.action.ConfiguredActionDefinition;

public class SaveIfEditionOpenFormActionDefinition extends ConfiguredActionDefinition {

    public SaveIfEditionOpenFormActionDefinition() {
        setImplementationClass(SaveIfEditionOpenFormAction.class);
    }

}
