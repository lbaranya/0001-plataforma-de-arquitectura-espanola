package es.arquia.magnolia.manager;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.RelatedElement;

public class ArchitectureFilesSupportArchitectManagerImpl implements ArchitectureFilesSupportArchitectManager {
	
	private ArchitectureFilesSupportArchitect architectureFilesSupportArchitect;
	
	private RelatedElementsManager relatedElementsManager;
	
	@Inject
	public ArchitectureFilesSupportArchitectManagerImpl(final ArchitectureFilesSupportArchitect architectureFilesSupportArchitect, final RelatedElementsManager relatedElementsManager) {
		this.architectureFilesSupportArchitect = architectureFilesSupportArchitect;
		this.relatedElementsManager = relatedElementsManager;
	}

	@Override
	public ArchitectureFilesSupportArchitect getInstance() {
		return architectureFilesSupportArchitect;
	}

	@Override
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException{
		List<RelatedElement> tmpList = new ArrayList<>();
		Iterator<Node> iterator = relatedElements.iterator();
		while(iterator.hasNext()) {
			tmpList.add(relatedElementsManager.transformToRelatedElement(iterator.next()));
		}
		return tmpList;
	}

}
