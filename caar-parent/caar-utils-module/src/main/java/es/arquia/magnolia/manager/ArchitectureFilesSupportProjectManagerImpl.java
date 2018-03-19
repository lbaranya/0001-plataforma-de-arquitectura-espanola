package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.URIPrefixArchitectureFilesSupportProject;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.URIRepositoryArchitectureFiles;

import javax.inject.Inject;

import es.arquia.magnolia.utils.ArchitectureFilesSupportProject;

public class ArchitectureFilesSupportProjectManagerImpl implements ArchitectureFilesSupportProjectManager {
	
	private ArchitectureFilesSupportProject architectureFilesSupportProject;
	
	@Inject
	public ArchitectureFilesSupportProjectManagerImpl(final ArchitectureFilesSupportProject architectureFilesSupportProject) {
		this.architectureFilesSupportProject = architectureFilesSupportProject;
	}

	@Override
	public ArchitectureFilesSupportProject getInstance() {
		return this.architectureFilesSupportProject;
	}

	@Override
	public String getLink(String link) {
		return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesSupportProject);
	}

}
