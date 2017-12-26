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
public class CaarNewsAppVersionHandler extends DefaultModuleVersionHandler {
	
	public CaarNewsAppVersionHandler() {
		
		register(DeltaBuilder.update("0.10", "")
				.addTask(new BootstrapSingleModuleResource("News URI2RepositoryMapping", "Add URI2RespositoryMapping to server configuration", "config.server.URI2RepositoryMapping.mappings.news.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
	}

}
