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
public class CaarAwardsAppVersionHandler extends DefaultModuleVersionHandler {
	
	public CaarAwardsAppVersionHandler() {
		register(DeltaBuilder.update("0.18", "")
				.addTask(new BootstrapSingleModuleResource("URI2Repository mapping for awards", "Add a mapping to awards repository", "config.server.URI2RepositoryMapping.mappings.awards.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
		
		register(DeltaBuilder.update("0.24", "")
				.addTask(new BootstrapSingleModuleResource("Configuration constants for awards", "Create configuration constants into JCR awards module", "config.modules.caar-awards-app.constants.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
	}
}
