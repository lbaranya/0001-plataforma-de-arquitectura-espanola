package es.arquia.magnolia.utils;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

public class ArchitectureFileImpl implements ArchitectureFile {

	@Inject
	private ArchitectureFilesSupportArchitect architectureFilesSupportArchitect;
	
	@Override
	public List<RelatedElement> getRelatedElements(Node node) throws RepositoryException {

		List<RelatedElement> ret = new LinkedList<>();

		// TODO: crear metodos iguales por cada tipo de elemento que pueda asociarse a un premio
		ret.addAll(this.getRelatedElementsFromFilesList(node));

		return ret;
	}
	
	public List<RelatedElement> getRelatedElementsFromFilesList(Node node) throws RepositoryException {
		
		List<RelatedElement> ret = new LinkedList<>();
		
		// TODO: agregar diferentes tipos de fichas conforme se vayan implementando sus vistas detalle
		if (node.isNodeType(architectureFilesSupportArchitectNodeType)) {
			
			ret.addAll(this.architectureFilesSupportArchitect.getRelatedElements(node));
		}
		
		return ret;
	}

}
