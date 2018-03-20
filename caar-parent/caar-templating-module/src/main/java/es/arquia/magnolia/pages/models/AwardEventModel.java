package es.arquia.magnolia.pages.models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;

import es.arquia.magnolia.manager.ArchitectureFilesFormatManager;
import es.arquia.magnolia.manager.ArchitectureFilesSupportManager;
import es.arquia.magnolia.manager.AwardManager;
import es.arquia.magnolia.manager.RelatedElementsManager;
import es.arquia.magnolia.utils.EventNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;

public class AwardEventModel <T extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private AwardManager awardManager;
	
	private ArchitectureFilesSupportManager supportManager;
	
	private ArchitectureFilesFormatManager formatManager;
	
	private RelatedElementsManager relatedElementsManager;
	
	private I18nContentSupport i18nContentSupport;

	public AwardEventModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final AwardManager awardManager, final RelatedElementsManager relatedElements, final I18nContentSupport i18n, final ArchitectureFilesSupportManager supportManager, final ArchitectureFilesFormatManager formatManager) {
		super(content, definition, parent);
		this.awardManager = awardManager;
		this.relatedElementsManager = relatedElements;
		this.i18nContentSupport = i18n;
		this.supportManager = supportManager;
		this.formatManager = formatManager;
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
	
	public String getCountryName(Node node) throws RepositoryException {
		return i18nContentSupport.getProperty(node, "displayName").getString();
	}
	
	public String getLink(Node node, String link) throws RepositoryException {
		// TODO: Portfolio file link
		if(supportManager.isSupport(node)) {
			return supportManager.getLink(node, link);
		}else {
			return formatManager.getLink(node, link);
		}
	}

}
