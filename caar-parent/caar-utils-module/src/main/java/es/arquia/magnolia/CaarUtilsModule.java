package es.arquia.magnolia;

import es.arquia.magnolia.commands.CountryCommand;
import info.magnolia.module.ModuleLifecycle;
import info.magnolia.module.ModuleLifecycleContext;

/**
 * This class is optional and represents the configuration for the caar-utils-module module.
 * By exposing simple getter/setter/adder methods, this bean can be configured via content2bean
 * using the properties and node from <tt>config:/modules/caar-utils-module</tt>.
 * If you don't need this, simply remove the reference to this class in the module descriptor xml.
 */
public class CaarUtilsModule implements ModuleLifecycle{
	
	private CountryCommand getCountries;
	
	public CaarUtilsModule() {
		super();
		getCountries = new CountryCommand();
	}

	@Override
	public void start(ModuleLifecycleContext arg0) {
		try {
			getCountries.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void stop(ModuleLifecycleContext arg0) {
		// TODO Auto-generated method stub
		
	}
    /* you can optionally implement info.magnolia.module.ModuleLifecycle */

}
