package es.arquia.magnolia.setup;

import javax.jcr.ImportUUIDBehavior;

import info.magnolia.module.DefaultModuleVersionHandler;
import info.magnolia.module.delta.BootstrapSingleModuleResource;
import info.magnolia.module.delta.DeltaBuilder;

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
		
		register(DeltaBuilder.update("0.10", "")
				.addTask(new BootstrapSingleModuleResource("Publishing request mail template", "Mail template to request an approval from publication", "config.modules.mail.config.templatesConfiguration.ReviewForPublicationWithEmail.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Activate workflow modification", "Modified for publication review with email", "config.modules.workflow.commands.workflow.activate.activate.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
	}
	
}
