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
public class CaarArchitectureFilesAppVersionHandler extends DefaultModuleVersionHandler {
	
	public CaarArchitectureFilesAppVersionHandler() {
		register(DeltaBuilder.update("0.18", "")
				.addTask(new BootstrapSingleModuleResource("Support project category folder", "Add a folder in category app for support project file", "category.caar.support-project.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Support review i category folder", "Add a folder in category app for support review i file", "category.caar.support-reviewi.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Support review ii category folder", "Add a folder in category app for support review ii file", "category.caar.support-reviewii.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Support review iii category folder", "Add a folder in category app for support review iii file", "category.caar.support-reviewiii.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				.addTask(new BootstrapSingleModuleResource("Support review iv category folder", "Add a folder in category app for support review iv file", "category.caar.support-reviewiv.xml", ImportUUIDBehavior.IMPORT_UUID_COLLISION_REPLACE_EXISTING))
				);
	}
}
