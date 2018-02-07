package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportEventNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportEventConstants.presentationStartDate;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.ArchitectureFilesSupportEvent;
import es.arquia.magnolia.functions.QueryUtils;
import info.magnolia.cms.i18n.I18nContentSupport;

public class ArchitectureFilesSupportEventManagerImpl implements ArchitectureFilesSupportEventManager {
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportEventManagerImpl.class);
	private QueryUtils queryUtils;
	private I18nContentSupport i18nContentSupport;
	
	@Inject
	public ArchitectureFilesSupportEventManagerImpl(final QueryUtils queryUtils, final I18nContentSupport i18nContentSupport) throws PathNotFoundException, RepositoryException {
        this.queryUtils = queryUtils;
        this.i18nContentSupport = i18nContentSupport;
    }
	
	@Override
	public List<Node> getArchitectureFilesSupportEventList() throws Exception{
		final int limit = 4;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + architectureFilesSupportEventNodeType + "] ORDER BY [" + presentationStartDate + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, architectureFilesWorkspace, limit, offset);
	}
	
	@Override
	public ArchitectureFilesSupportEvent getInstance() {
		return new ArchitectureFilesSupportEvent(i18nContentSupport);
	}

}
