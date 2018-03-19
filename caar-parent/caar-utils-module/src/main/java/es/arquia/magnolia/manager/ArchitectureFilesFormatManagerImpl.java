package es.arquia.magnolia.manager;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesFormatAudio;
import es.arquia.magnolia.utils.ArchitectureFilesFormatBook;
import es.arquia.magnolia.utils.ArchitectureFilesFormatCartographic;
import es.arquia.magnolia.utils.ArchitectureFilesFormatContinuous;
import es.arquia.magnolia.utils.ArchitectureFilesFormatElectronic;
import es.arquia.magnolia.utils.ArchitectureFilesFormatGraphic;
import es.arquia.magnolia.utils.ArchitectureFilesFormatManuscript;
import es.arquia.magnolia.utils.ArchitectureFilesFormatThreeDimensional;
import es.arquia.magnolia.utils.ArchitectureFilesFormatVideo;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;

public class ArchitectureFilesFormatManagerImpl implements ArchitectureFilesFormatManager {
	
	private ArchitectureFilesFormatAudio architectureFilesFormatAudio;
	
	private ArchitectureFilesFormatBook architectureFilesFormatBook;
	
	private ArchitectureFilesFormatCartographic architectureFilesFormatCartographic;
	
	private ArchitectureFilesFormatContinuous architectureFilesFormatContinuous;
	
	private ArchitectureFilesFormatElectronic architectureFilesFormatElectronic;
	
	private ArchitectureFilesFormatGraphic architectureFilesFormatGraphic;
	
	private ArchitectureFilesFormatManuscript architectureFilesFormatManuscript;
	
	private ArchitectureFilesFormatThreeDimensional architectureFilesFormatThreeDimensional;
	
	private ArchitectureFilesFormatVideo architectureFilesFormatVideo;

	@Inject
	public ArchitectureFilesFormatManagerImpl(final ArchitectureFilesFormatAudio architectureFilesFormatAudio,
			final ArchitectureFilesFormatBook architectureFilesFormatBook,
			final ArchitectureFilesFormatCartographic architectureFilesFormatCartographic,
			final ArchitectureFilesFormatContinuous architectureFilesFormatContinuous,
			final ArchitectureFilesFormatElectronic architectureFilesFormatElectronic,
			final ArchitectureFilesFormatGraphic architectureFilesFormatGraphic,
			final ArchitectureFilesFormatManuscript architectureFilesFormatManuscript,
			final ArchitectureFilesFormatThreeDimensional architectureFilesFormatThreeDimensional,
			final ArchitectureFilesFormatVideo architectureFilesFormatVideo) {
		this.architectureFilesFormatAudio = architectureFilesFormatAudio;
		this.architectureFilesFormatBook = architectureFilesFormatBook;
		this.architectureFilesFormatCartographic = architectureFilesFormatCartographic;
		this.architectureFilesFormatContinuous = architectureFilesFormatContinuous;
		this.architectureFilesFormatElectronic = architectureFilesFormatElectronic;
		this.architectureFilesFormatGraphic = architectureFilesFormatGraphic;
		this.architectureFilesFormatManuscript = architectureFilesFormatManuscript;
		this.architectureFilesFormatThreeDimensional = architectureFilesFormatThreeDimensional;
		this.architectureFilesFormatVideo = architectureFilesFormatVideo;
	}

	@Override
	public ArchitectureFilesFormatAudio getAudioInstance() {
		return architectureFilesFormatAudio;
	}

	@Override
	public ArchitectureFilesFormatBook getBookInstance() {
		return architectureFilesFormatBook;
	}

	@Override
	public ArchitectureFilesFormatCartographic getCartographicInstance() {
		return architectureFilesFormatCartographic;
	}

	@Override
	public ArchitectureFilesFormatContinuous getContinuousInstance() {
		return architectureFilesFormatContinuous;
	}

	@Override
	public ArchitectureFilesFormatElectronic getElectronicInstance() {
		return architectureFilesFormatElectronic;
	}

	@Override
	public ArchitectureFilesFormatGraphic getGraphicInstance() {
		return architectureFilesFormatGraphic;
	}

	@Override
	public ArchitectureFilesFormatManuscript getManuscriptInstance() {
		return architectureFilesFormatManuscript;
	}

	@Override
	public ArchitectureFilesFormatThreeDimensional getThreeDimensionalInstance() {
		return architectureFilesFormatThreeDimensional;
	}

	@Override
	public ArchitectureFilesFormatVideo getVideoInstance() {
		return architectureFilesFormatVideo;
	}

	@Override
	public String getLink(Node node, String link) {
		try {
			if(node.isNodeType(architectureFilesFormatAudioNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatAudio);
			}
			else if(node.isNodeType(architectureFilesFormatBookNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatBook);
			}
			else if(node.isNodeType(architectureFilesFormatCartographicNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatCartographic);
			}
			else if(node.isNodeType(architectureFilesFormatContinuousNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatContinuous);
			}
			else if(node.isNodeType(architectureFilesFormatElectronicNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatElectronic);
			}
			else if(node.isNodeType(architectureFilesFormatGraphicNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatGraphic);
			}
			else if(node.isNodeType(architectureFilesFormatManuscriptNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatManuscript);
			}
			else if(node.isNodeType(architectureFilesFormatThreeDimensionalNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatThreeDimensional);
			}
			else if(node.isNodeType(architectureFilesFormatVideoNodeType)) {
				return link.replace(URIRepositoryArchitectureFiles, URIPrefixArchitectureFilesFormatVideo);
			}
			else {
				return link;
			}
		} catch (RepositoryException e) {
			return link;
		}
	}

	@Override
	public boolean isFormat(Node node) throws RepositoryException {
		return node.isNodeType(architectureFilesFormatAudioNodeType) || node.isNodeType(architectureFilesFormatBookNodeType) || node.isNodeType(architectureFilesFormatCartographicNodeType) || node.isNodeType(architectureFilesFormatContinuousNodeType) || node.isNodeType(architectureFilesFormatElectronicNodeType) || node.isNodeType(architectureFilesFormatGraphicNodeType) || node.isNodeType(architectureFilesFormatManuscriptNodeType) || node.isNodeType(architectureFilesFormatThreeDimensionalNodeType) || node.isNodeType(architectureFilesFormatVideoNodeType);
	}

}
