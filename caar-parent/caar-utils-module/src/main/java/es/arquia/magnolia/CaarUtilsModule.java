package es.arquia.magnolia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.commands.CountryCommand;
import es.arquia.magnolia.commands.LanguagesCommand;
import info.magnolia.module.ModuleLifecycle;
import info.magnolia.module.ModuleLifecycleContext;

/**
 * This class is optional and represents the configuration for the
 * caar-utils-module module. By exposing simple getter/setter/adder methods,
 * this bean can be configured via content2bean using the properties and node
 * from <tt>config:/modules/caar-utils-module</tt>. If you don't need this,
 * simply remove the reference to this class in the module descriptor xml.
 */
public class CaarUtilsModule implements ModuleLifecycle {

	private static final Logger log = LoggerFactory.getLogger(CaarUtilsModule.class);
	
	private CountryCommand getCountries;
	
	private LanguagesCommand getLanguages;

	public CaarUtilsModule() {
		super();
		getCountries = new CountryCommand();
		getLanguages = new LanguagesCommand();
	}

	@Override
	public void start(ModuleLifecycleContext arg0) {
		
		try {
			
			getCountries.execute();
			getLanguages.execute();
			
		} catch (Exception e) {
			
			log.error("Countries load failed!! ", e.getMessage());
		}
	}

	@Override
	public void stop(ModuleLifecycleContext arg0) {
		// Nothing to do
	}
	/* you can optionally implement info.magnolia.module.ModuleLifecycle */

}
