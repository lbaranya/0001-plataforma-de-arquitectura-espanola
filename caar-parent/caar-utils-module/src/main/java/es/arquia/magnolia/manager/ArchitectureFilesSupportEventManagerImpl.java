package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.important;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationStartDate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
		Date today = Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(today); // Now use today date.
		String date = sdf.format(c.getTime());
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportEventNodeType + "] WHERE [" + presentationStartDate + "] >= CAST('" + date + "T00:00:00.000' AS DATE) AND [" + important + "] IS NOT NULL AND [" + important + "] = true ORDER BY [" + presentationStartDate + "] DESC";
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
