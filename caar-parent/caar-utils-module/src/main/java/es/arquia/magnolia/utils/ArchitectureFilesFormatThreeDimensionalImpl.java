package es.arquia.magnolia.utils;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import info.magnolia.cms.i18n.I18nContentSupport;

import static es.arquia.magnolia.constants.ArchitectureFilesFormatAudioConstants.subtitle;
import static es.arquia.magnolia.constants.ArchitectureFilesFormatThreeDimensionalConstants.*;

public class ArchitectureFilesFormatThreeDimensionalImpl implements ArchitectureFilesFormatThreeDimensional {
	
	private I18nContentSupport i18nContentSupport;
	
	@Inject
	public ArchitectureFilesFormatThreeDimensionalImpl(final I18nContentSupport i18n) {
		this.i18nContentSupport = i18n;
	}
	
	private String getPropertyAsString(Node node, String property) {
		try {
			return i18nContentSupport.getProperty(node, property).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}

	@Override
	public String getTitle(Node node) {
		return getPropertyAsString(node, title);
	}

	@Override
	public String getPhoto(Node node) {
		return getPropertyAsString(node, photo);
	}

	@Override
	public String getSubtitle(Node node) {
		return getPropertyAsString(node, subtitle);
	}

}
