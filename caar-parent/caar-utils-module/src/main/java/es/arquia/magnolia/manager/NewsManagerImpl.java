package es.arquia.magnolia.manager;

import static es.arquia.magnolia.constants.NewsConstants.category;
import static es.arquia.magnolia.constants.NewsConstants.dateTime;
import static es.arquia.magnolia.constants.NewsConstants.important;
import static es.arquia.magnolia.constants.NewsConstants.newsNodeType;
import static es.arquia.magnolia.constants.NewsConstants.newsWorkspace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.functions.QueryUtils;
import es.arquia.magnolia.utils.NewsNodeUtil;
import es.arquia.magnolia.utils.RelatedElement;
import info.magnolia.context.MgnlContext;

public class NewsManagerImpl implements NewsManager{

	private static final Logger log = LoggerFactory.getLogger(NewsManagerImpl.class);
	private QueryUtils queryUtils;
	private NewsNodeUtil news;
	private boolean lastRowOfNews = false;
	
	private RelatedElementsManager relatedElementsManager;

	@Inject
	public NewsManagerImpl(final QueryUtils queryUtils, final NewsNodeUtil news, final RelatedElementsManager relatedElementsManager) {
		this.queryUtils = queryUtils;
		this.news = news;
		this.relatedElementsManager = relatedElementsManager;
	}

	@Override
	public List<Node> getNewsList() throws RepositoryException{
		return getNewsList(0);
	}

	@Override
	public List<Node> getNewsList(int numberOfNews) throws RepositoryException{
		String rowsFromAjax = MgnlContext.getAttribute("rows");
		final int limit = (numberOfNews > 0) ? (numberOfNews + 1) : 0;
		final int lastNewsListElement = numberOfNews;
		int offset = (rowsFromAjax != null) ? (lastNewsListElement * Integer.valueOf(rowsFromAjax)) : 0;
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
	public List<Node> getCategorizedNewsList(List<String> categoriesList) throws RepositoryException{
		return getCategorizedNewsList(categoriesList, 0);
	}

	@Override
	public List<Node> getCategorizedNewsList(List<String> categoriesList, int numberOfNews) throws RepositoryException{
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
	public List<Node> getImportantNewsList() throws RepositoryException {
		final int limit = 3;
		final int offset = 0;
		String sqlQuery = "SELECT * FROM [" + newsNodeType + "] WHERE [" + important + "] IS NOT NULL ORDER BY [" + dateTime + "] DESC";
		return queryUtils.executeSelectQuery(sqlQuery, newsWorkspace, limit, offset);
	}

	public boolean isLastRowOfNews() {
		return lastRowOfNews;
	}

	@Override
	public NewsNodeUtil getInstance() {
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

	@Override
	public List<RelatedElement> getTransformedRelatedElements(List<Node> relatedElements) throws RepositoryException {
		List<RelatedElement> tmpList = new ArrayList<>();
		Iterator<Node> iterator = relatedElements.iterator();
		while(iterator.hasNext()) {
			tmpList.add(relatedElementsManager.transformToRelatedElement(iterator.next()));
		}
		return tmpList;
	}
}
