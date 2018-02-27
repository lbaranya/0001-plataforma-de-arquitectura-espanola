package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.functions.QueryUtils;
import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.RelatedElement;

public class ArchitectureFilesSupportArchitectManagerImpl implements ArchitectureFilesSupportArchitectManager {
	
	private ArchitectureFilesSupportArchitect architectureFilesSupportArchitect;
	
	private RelatedElementsManager relatedElementsManager;
	
	private QueryUtils queryUtils;
	
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
	
	@Override
	public List<Node> getArchitectsList() throws RepositoryException {
		final int limit = 4;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportArchitectNodeType + "] ORDER BY [" + "mgnl:lastModified" + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);
	}

}
