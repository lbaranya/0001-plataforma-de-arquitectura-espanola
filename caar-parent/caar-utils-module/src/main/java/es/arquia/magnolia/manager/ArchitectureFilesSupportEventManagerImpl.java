package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.important;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationStartDate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.functions.QueryUtils;
import es.arquia.magnolia.utils.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.utils.RelatedElement;

public class ArchitectureFilesSupportEventManagerImpl implements ArchitectureFilesSupportEventManager {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportEventManagerImpl.class);
	private QueryUtils queryUtils;
	
	private ArchitectureFilesSupportEvent architectureFilesSupportEvent;
	
	private RelatedElementsManager relatedElementsManager;
	
	@Inject
	public ArchitectureFilesSupportEventManagerImpl(final QueryUtils queryUtils, final RelatedElementsManager relatedElementsManager, final ArchitectureFilesSupportEvent architectureFilesSupportEvent) {
        this.queryUtils = queryUtils;
        this.relatedElementsManager = relatedElementsManager;
        this.architectureFilesSupportEvent = architectureFilesSupportEvent;
    }
	
	@Override
	public List<Node> getArchitectureFilesSupportEventList() throws RepositoryException {
		final int limit = 4;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportEventNodeType + "] WHERE [" + important + "] IS NOT NULL AND [" + important + "] = true ORDER BY [" + presentationStartDate + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);
	}
	
	@Override
	public ArchitectureFilesSupportEvent getInstance() {
		return architectureFilesSupportEvent;
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