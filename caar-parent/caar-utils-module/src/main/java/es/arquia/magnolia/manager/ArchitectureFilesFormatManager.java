package es.arquia.magnolia.manager;

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

public interface ArchitectureFilesFormatManager {
	
	public ArchitectureFilesFormatAudio getAudioInstance();
	
	public ArchitectureFilesFormatBook getBookInstance();
	
	public ArchitectureFilesFormatCartographic getCartographicInstance();
	
	public ArchitectureFilesFormatContinuous getContinuousInstance();
	
	public ArchitectureFilesFormatElectronic getElectronicInstance();
	
	public ArchitectureFilesFormatGraphic getGraphicInstance();
	
	public ArchitectureFilesFormatManuscript getManuscriptInstance();
	
	public ArchitectureFilesFormatThreeDimensional getThreeDimensionalInstance();
	
	public ArchitectureFilesFormatVideo getVideoInstance();
	
	public String getLink(Node node, String link);
	
	public boolean isFormat(Node node) throws RepositoryException;

}
