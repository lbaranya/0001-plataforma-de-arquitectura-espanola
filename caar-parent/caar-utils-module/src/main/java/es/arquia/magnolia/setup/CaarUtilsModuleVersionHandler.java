package es.arquia.magnolia.setup;

import javax.jcr.ImportUUIDBehavior;

import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.delta.BootstrapSingleModuleResource;
import info.magnolia.module.delta.DeltaBuilder;
import info.magnolia.module.delta.IsAdminInstanceDelegateTask;

/**
 * This class is optional and lets you manage the versions of your module,
 * by registering "deltas" to maintain the module's configuration, or other type of content.
 * If you don't need this, simply remove the reference to this class in the module descriptor xml.
 *
 * @see info.magnolia.module.DefaultModuleVersionHandler
 * @see info.magnolia.module.ModuleVersionHandler
 * @see info.magnolia.module.delta.Task
 */
public class CaarUtilsModuleVersionHandler extends DefaultModuleVersionHandler {

	public CaarUtilsModuleVersionHandler() {
		
		register(DeltaBuilder.update("0.7", "")
				.addTask(new BootstrapSingleModuleResource("Module commands", "Create all module commands", "config.modules.caar-utils-module.commands.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Request translation mail template", "Mail template to request translation action business", "config.modules.mail.config.templatesConfiguration.requestTranslation.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
		
		register(DeltaBuilder.update("0.12", "")
				.addTask(new BootstrapSingleModuleResource("Publishing request mail template", "Mail template to request an approval from publication", "config.modules.mail.config.templatesConfiguration.reviewForPublication.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Publication rejected mail template", "Mail template to notify a rejected publication", "config.modules.mail.config.templatesConfiguration.rejectedPublication.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Activate workflow modification", "Modified for publication review with email", "config.modules.workflow.commands.workflow.activate.activate.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Workflow definition", "Review for publication with email workflow definition", "config.modules.caar-utils-module.workflows.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("WorkItemHandler definition", "Review for publication with email workItem handler definition", "config.modules.caar-utils-module.workItemHandlers.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Request translation action: Pages app", "Action for request translation into Pages app", "config.modules.pages.apps.pages.subApps.browser.actions.requestTranslation.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Request translation section action: Pages app", "Add request translation action into correct section of Pages app", "config.modules.pages.apps.pages.subApps.browser.actionbar.sections.pageActions.groups.activationActions.items.requestTranslation.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Request translation action: Assets app", "Action for request translation into Assets app", "config.modules.dam-app.apps.assets.subApps.browser.actions.requestTranslation.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Request translation section action: Assets app", "Add request translation action into correct section of Assets app", "config.modules.dam-app.apps.assets.subApps.browser.actionbar.sections.asset.groups.activationActions.items.requestTranslation.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Alt asset text", "Alternative text field for all assets", "config.modules.dam-app.apps.assets.subApps.detail.editor.form.tabs.asset.fields.alternative.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
		
		register(DeltaBuilder.update("0.17", "")
				.addTask(new IsAdminInstanceDelegateTask("Solr indexers", "Indexation configuration fields for Solr in public instance", null, 
							new BootstrapSingleModuleResource("Solr indexers", "Indexation configuration fields for Solr", "config.modules.content-indexer.config.indexers.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING)))
				);
		
		register(DeltaBuilder.update("0.18", "")
				.addTask(new BootstrapSingleModuleResource("Category displayName i18n", "Add i18n property to displayName Textfield", "config.modules.categorization.apps.categories.subApps.detail.editor.form.tabs.category.fields.displayName.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Arquia apps", "Add arquia custom apps to main layout", "config.modules.ui-admincentral.config.appLauncherLayout.groups.arquia.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
		register(DeltaBuilder.update("0.23", "")
				.addTask(new BootstrapSingleModuleResource("Content caching", "Disable content caching for all site", "config.modules.cache.config.contentCaching.defaultPageCache.cachePolicy.shouldBypassVoters.urls.excludes.caarCache.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
	}
	
}
