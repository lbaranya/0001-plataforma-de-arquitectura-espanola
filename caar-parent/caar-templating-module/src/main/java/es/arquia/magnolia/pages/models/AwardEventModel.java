package es.arquia.magnolia.pages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.manager.RelatedElementsManager;
import es.arquia.magnolia.utils.EventNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;

public class AwardEventModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;
	
	private RelatedElementsManager relatedElementsManager;

	public AwardEventModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager, final RelatedElementsManager relatedElements) {
		super(content, definition, parent);
		this.awardManager = awardManager;
		this.relatedElementsManager = relatedElements;
	}
	
	public EventNodeUtil getInstance() {
		return awardManager.getEventInstance();
	}
	
	public RelatedElement transform(Node node) throws RepositoryException {
		return relatedElementsManager.transformToRelatedElement(node);
	}
	
	public List<String> getSupportFiles(List<String> listFiles) throws RepositoryException {
		List<String> tmpList = new ArrayList<String>(listFiles);
		tmpList.removeIf(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				String path = t;
				try {
					Session sesion = MgnlContext.getJCRSession(architectureFilesWorkspace);
					Node testNode = sesion.getNode(path);
					return !(testNode.isNodeType(architectureFilesSupportArchitectNodeType) || testNode.isNodeType(architectureFilesSupportProjectNodeType) || testNode.isNodeType(architectureFilesSupportBusinessNodeType) || testNode.isNodeType(architectureFilesSupportEventNodeType) || testNode.isNodeType(architectureFilesSupportReviewINodeType) || testNode.isNodeType(architectureFilesSupportReviewIINodeType) || testNode.isNodeType(architectureFilesSupportReviewIIINodeType) || testNode.isNodeType(architectureFilesSupportReviewIVNodeType));
				} catch (RepositoryException e) {
					return false;
				}
			}
			
		});
		return tmpList;
	}
	
	public List<String> getFormatFiles(List<String> listFiles) throws RepositoryException {
		List<String> tmpList = new ArrayList<String>(listFiles);
		tmpList.removeIf(new Predicate<String>() {

			@Override
			public boolean test(String t) {
				String path = t;
				try {
					Session sesion = MgnlContext.getJCRSession(architectureFilesWorkspace);
					Node testNode = sesion.getNode(path);
					return !(testNode.isNodeType(architectureFilesFormatVideoNodeType) || testNode.isNodeType(architectureFilesFormatManuscriptNodeType) || testNode.isNodeType(architectureFilesFormatThreeDimensionalNodeType) || testNode.isNodeType(architectureFilesFormatCartographicNodeType) || testNode.isNodeType(architectureFilesFormatAudioNodeType) || testNode.isNodeType(architectureFilesFormatBookNodeType) || testNode.isNodeType(architectureFilesFormatGraphicNodeType) || testNode.isNodeType(architectureFilesFormatContinuousNodeType) || testNode.isNodeType(architectureFilesFormatElectronicNodeType));
				} catch (RepositoryException e) {
					return false;
				}
			}
			
		});
		return tmpList;
	}

}
