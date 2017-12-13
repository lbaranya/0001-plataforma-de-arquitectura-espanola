package es.arquia.magnolia.contentApps.actions;

import java.util.Arrays;
import java.util.List;

import info.magnolia.commands.CommandsManager;
import info.magnolia.i18nsystem.SimpleTranslator;
import info.magnolia.ui.api.context.UiContext;
import info.magnolia.ui.framework.action.AbstractCommandAction;
import info.magnolia.ui.vaadin.integration.jcr.JcrItemAdapter;

public class RequestTranslationAction<D extends RequestTranslationActionDefinition> extends AbstractCommandAction<D> {

	public RequestTranslationAction(D definition, JcrItemAdapter item, CommandsManager commandsManager,
			UiContext uiContext, SimpleTranslator i18n) {
		this(definition, Arrays.asList(item), commandsManager, uiContext, i18n);
	}
	
	public RequestTranslationAction(D definition, List<JcrItemAdapter> items, CommandsManager commandsManager,
			UiContext uiContext, SimpleTranslator i18n) {
		super(definition, items, commandsManager, uiContext, i18n);
	}

}
