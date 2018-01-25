package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.NewsConstants.category;
import static es.arquia.magnolia.constants.NewsConstants.dateTime;
import static es.arquia.magnolia.constants.NewsConstants.important;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;

import java.util.List;

import javax.jcr.Node;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.functions.QueryUtils;

public class NewsManagerImpl implements NewsManager{
	
	private static final Logger log = LoggerFactory.getLogger(NewsManagerImpl.class);
    
	@Override
	public List<Node> getNewsList() throws Exception{
		final int limit = 4;
		int offset = 0;
		String sqlQuery = "SELECT * FROM [" + newsNodeType + "] ORDER BY [" + dateTime + "] DESC";
		return QueryUtils.executeSelectQuery(sqlQuery, newsWorkspace, limit, offset);
	}
	
	@Override
	public List<Node> getCategorizedNewsList(List<String> categoriesList) throws Exception{
		final int limit = 4;
		int offset = 0;
		String sqlQuery = categorizedNewsListQuery(categoriesList);
		return QueryUtils.executeSelectQuery(sqlQuery, newsWorkspace, limit, offset);
	}
	
	@Override
	public List<Node> getImportantNewsList() throws Exception {
		final int limit = 2;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + newsNodeType + "] WHERE [" + important + "] IS NOT NULL ORDER BY [" + dateTime + "] DESC";
		return QueryUtils.executeSelectQuery(sqlQuery, newsWorkspace, limit, offset);
	}

	@Override
	public News getInstance() {
		return new News();
	}
	
	private String categorizedNewsListQuery(List<String> categoriesList) {
		boolean ctrlCondition = false;
		String sqlQuery = "SELECT * FROM [" + newsNodeType + "] ";
		for(String iterator : categoriesList) {
			
			if (!ctrlCondition) {
				sqlQuery += "WHERE ";
				ctrlCondition = true;
			}
			else {
				sqlQuery += "OR ";
			}
			sqlQuery += "CONTAINS([" + category + "], '" + iterator + "') ";
		}
		sqlQuery += "ORDER BY [" + dateTime + "] DESC";
		
		return sqlQuery;
	}
}
