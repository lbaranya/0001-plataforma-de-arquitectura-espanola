package es.arquia.magnolia.components.news;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.magnolia.cms.i18n.AbstractI18nContentSupport;
import info.magnolia.cms.i18n.DefaultI18nContentSupport;
import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.predicate.AbstractPredicate;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsListModel <RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private static final Logger log = LoggerFactory.getLogger(NewsListModel.class);
	
	private static String headTitle = "N1.1";
	private static String longTitle = "N1.2";
	private static String descriptionShort = "N1.3";
	private static String descriptionLong = "N1.4";
	private static String dateTime = "N1.5";
	private static String image = "N1.6";
	private static String category = "N1.7";
	private static String important = "N1.8";
	private static String files = "N1.9";
	private static String relatedNews = "N1.10";
	
	private static String newsNodeType = "mgnl:news";
	
	private static String newsWorkspace = "news";
	
	private static String newsDateFormat = "dd MMMM YYYY";
	
	public NewsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
    }
	
	private static AbstractPredicate<Node> MAGNOLIA_NEWS_FILTER = new AbstractPredicate<Node>() {

        @Override
        public boolean evaluateTyped(Node node) {

            try {
                return node.isNodeType(newsNodeType);
            } catch (RepositoryException e) {
                log.error("Unable to read nodeType for node {}", NodeUtil.getNodePathIfPossible(node));
            }
            return false;
        }
    };
    
    private String getLocalizedSuffix(String currentLanguage) {
    	if(!MgnlContext.getLocale().getLanguage().equals(currentLanguage))
			currentLanguage = "_" + currentLanguage;
		else
			currentLanguage = "";
    	return currentLanguage;
    }
	
	public List<Node> getNewsList() throws Exception{
		List<Node> newsList = new ArrayList<>();
		
		Session session = MgnlContext.getJCRSession(newsWorkspace);
		Node parentNewsNodeFolder = session.getRootNode();
		if(parentNewsNodeFolder.hasNodes()) {
			Iterable<Node> childList = NodeUtil.collectAllChildren(parentNewsNodeFolder, MAGNOLIA_NEWS_FILTER);
			newsList = NodeUtil.asList(childList);
		}
		// Dates comparison
		newsList.sort(new Comparator<Node>() {

			@Override
			public int compare(Node arg0, Node arg1) {
				try {
					return arg1.getProperty(dateTime).getDate().compareTo(arg0.getProperty(dateTime).getDate());
				} catch (ValueFormatException e) {
					e.printStackTrace();
				} catch (PathNotFoundException e) {
					e.printStackTrace();
				} catch (RepositoryException e) {
					e.printStackTrace();
				}
				return 0;
			}
			
		});
		// Sort news by calendar (earlier first)
		return newsList;
	}
	
	public String getHeadline(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try{
			Property tmp = node.getProperty(headTitle + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(headTitle).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	public String getLongTitle(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException {
		try{
			Property tmp = node.getProperty(longTitle + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(longTitle).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	public String getDescription(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(descriptionShort + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(descriptionShort).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	public String getLongDescription(Node node, String currentLanguage) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(descriptionLong + getLocalizedSuffix(currentLanguage));
			return tmp.getString();
		}catch(Exception e) {
			try {
				return node.getProperty(descriptionLong).getString();
			}catch(Exception ex) {
				return "";
			}
		}
	}
	
	public String getDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(dateTime).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(newsDateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getImage(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(image);
			return tmp.getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getCategories(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(category);
			return tmp.getValues().toString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getImportant(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(important);
			return tmp.getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getArchitectLinks(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(files);
			return tmp.getValues().toString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getRelatedNews(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(relatedNews);
			return tmp.getValues().toString();
		}catch(Exception e) {
			return "";
		}
	}
}
