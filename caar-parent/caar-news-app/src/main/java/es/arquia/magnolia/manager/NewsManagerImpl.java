package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.NewsConstants.category;
import static es.arquia.magnolia.constants.NewsConstants.dateTime;
import static es.arquia.magnolia.constants.NewsConstants.important;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;

import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.beans.News;
import es.arquia.magnolia.beans.NewsImpl;
import es.arquia.magnolia.functions.QueryUtils;
import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;

public class NewsManagerImpl implements NewsManager{

	private static final Logger log = LoggerFactory.getLogger(NewsManagerImpl.class);
	private QueryUtils queryUtils;
	private News news;
	private boolean lastRowOfNews = false;

	@Inject
	public NewsManagerImpl(final QueryUtils queryUtils, final News news) {
		this.queryUtils = queryUtils;
		this.news = news;
	}

	@Override
	public List<Node> getNewsList() throws Exception{
		return getNewsList(0);
	}

	@Override
	public List<Node> getNewsList(int numberOfNews) throws Exception{
		final int limit = (numberOfNews > 0) ? (numberOfNews + 1) : 0;
		final int lastNewsListElement = numberOfNews;
		int offset = 0;
		String sqlQuery = "SELECT * FROM [" + newsNodeType + "] ORDER BY [" + dateTime + "] DESC";
		List<Node> newsList = queryUtils.executeSelectQuery(sqlQuery, newsWorkspace, limit, offset);
		if (newsList.size() < limit) {
			lastRowOfNews = true;
		}
		else if (limit > 0) {
			newsList.remove(lastNewsListElement);
		}
		return newsList;
	}

	@Override
	public List<Node> getCategorizedNewsList(List<String> categoriesList) throws Exception{
		return getCategorizedNewsList(categoriesList, 0);
	}

	@Override
	public List<Node> getCategorizedNewsList(List<String> categoriesList, int numberOfNews) throws Exception{
		String rowsFromAjax = MgnlContext.getAttribute("rows");
		final int limit = (numberOfNews > 0) ? (numberOfNews + 1) : 0;
		final int lastNewsListElement = numberOfNews;
		int offset = (rowsFromAjax != null) ? (lastNewsListElement * Integer.valueOf(rowsFromAjax)) : 0;
		String sqlQuery = categorizedNewsListQuery(categoriesList);
		List<Node> newsList = queryUtils.executeSelectQuery(sqlQuery, newsWorkspace, limit, offset);
		if (newsList.size() < limit) {
			lastRowOfNews = true;
		}
		else if (limit > 0) {
			newsList.remove(lastNewsListElement);
		}
		return newsList;
	}

	@Override
	public List<Node> getImportantNewsList() throws Exception {
		final int limit = 2;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + newsNodeType + "] WHERE [" + important + "] IS NOT NULL ORDER BY [" + dateTime + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, newsWorkspace, limit, offset);
	}

	public boolean isLastRowOfNews() {
		return lastRowOfNews;
	}

	@Override
	public News getInstance() {
		return this.news;
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

	@Override
	public List<Node> getCategorizedImportantNewsList(List<String> categoriesList, int numberOfNews) throws RepositoryException {
		String rowsFromAjax = MgnlContext.getAttribute("rows");
		final int limit = (numberOfNews > 0) ? (numberOfNews + 1) : 0;
		final int lastNewsListElement = numberOfNews;
		int offset = (rowsFromAjax != null) ? (lastNewsListElement * Integer.valueOf(rowsFromAjax)) : 0;
		String sqlQuery = categorizedImportantNewsListQuery(categoriesList);
		List<Node> newsList = queryUtils.executeSelectQuery(sqlQuery, newsWorkspace, limit, offset);
		if (newsList.size() < limit) {
			lastRowOfNews = true;
		}
		else if (limit > 0) {
			newsList.remove(lastNewsListElement);
		}
		return newsList;
	}

	private String categorizedImportantNewsListQuery(List<String> categoriesList) {
		boolean ctrlCondition = false;
		String sqlQuery = "SELECT * FROM [" + newsNodeType + "] ";
		for(String iterator : categoriesList) {

			if (!ctrlCondition) {
				sqlQuery += "WHERE (";
				ctrlCondition = true;
			}
			else {
				sqlQuery += "OR ";
			}
			sqlQuery += "CONTAINS([" + category + "], '" + iterator + "') ";
		}
		sqlQuery += ") AND [" + important + "] IS NOT NULL ORDER BY [" + dateTime + "] DESC";

		return sqlQuery;
	}
}
