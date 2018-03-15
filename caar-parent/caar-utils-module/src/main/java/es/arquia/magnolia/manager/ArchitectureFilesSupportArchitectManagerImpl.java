package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportArchitectNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.NewsConstants.dateTime;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import es.arquia.magnolia.functions.QueryUtils;
import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeTypes;

public class ArchitectureFilesSupportArchitectManagerImpl implements ArchitectureFilesSupportArchitectManager {
	
	private ArchitectureFilesSupportArchitect architectureFilesSupportArchitect;
	
	private RelatedElementsManager relatedElementsManager;
	
	@Inject
	private QueryUtils queryUtils;
	
	private boolean lastRowOfArchitects = false;
	
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
		public List<Node> getHighlightedArchitectsList(int architectsPerRow) throws RepositoryException {
			String rowsFromAjax = MgnlContext.getAttribute("rows");
			List<Node> architectsList = new ArrayList<>();
			if (rowsFromAjax == null) {
				final int offset = 0;
				String sqlQuery = "SELECT * FROM [" + architectureFilesSupportArchitectNodeType + "] ORDER BY [" + NodeTypes.LastModified.LAST_MODIFIED + "] DESC";
				architectsList = queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, architectsPerRow, offset);
			}
			return architectsList;
		}
	
	// This function has some special variables. It only works with a list of architects with two highlighted elements, as the one in architecture-files-support-architects-list-component
	@Override
	public List<Node> getArchitectsListAfterHighlighted(int architectsPerRow, int architectsToSkip) throws RepositoryException {
		String rowsFromAjax = MgnlContext.getAttribute("rows");
		int limit = (architectsPerRow > 0) ? (limit = architectsPerRow + 1) : 0; // If it's the first call, add "architectsToSkip" to the limit so that we can load the highlighted architects
		int offset = (rowsFromAjax != null) ? (architectsPerRow * Integer.valueOf(rowsFromAjax) + architectsToSkip) : architectsToSkip; // We'll have to increment offset too because of the two highlighted elements
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportArchitectNodeType + "] ORDER BY [" + NodeTypes.LastModified.LAST_MODIFIED + "] DESC";
		List<Node> architectsList = queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);
		if (architectsList.size() < limit) {
			lastRowOfArchitects = true;
		}
		else if (limit > 0) {
			architectsList.remove(architectsList.size() - 1);
		}
		return architectsList;
	}
	
	@Override
	public boolean isLastRowOfArchitects() {
		return lastRowOfArchitects;
	}

}
