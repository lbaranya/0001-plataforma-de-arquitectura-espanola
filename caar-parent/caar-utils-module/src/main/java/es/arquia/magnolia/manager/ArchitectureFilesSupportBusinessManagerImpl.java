package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.URIPrefixArchitectureFilesSupportBusiness;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.URIRepositoryArchitectureFiles;

import javax.inject.Inject;

import es.arquia.magnolia.utils.ArchitectureFilesSupportBusiness;

public class ArchitectureFilesSupportBusinessManagerImpl implements ArchitectureFilesSupportBusinessManager {

	private ArchitectureFilesSupportBusiness architectureFilesSupportBusiness;
	
	@Inject
	public ArchitectureFilesSupportBusinessManagerImpl(final ArchitectureFilesSupportBusiness architectureFilesSupportBusiness) {
		this.architectureFilesSupportBusiness = architectureFilesSupportBusiness;
	}
	
	@Override
	public ArchitectureFilesSupportBusiness getInstance() {
		return this.architectureFilesSupportBusiness;
	}

	@Override
	public String getLink(String link) {
		return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportBusiness);
	}

}
