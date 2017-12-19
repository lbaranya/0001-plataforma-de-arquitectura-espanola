package es.arquia.magnolia.components.news;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;

import info.magnolia.context.MgnlContext;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class NewsListModel <RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	public NewsListModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
    }
	
	public List<Node> getNewsList() throws LoginException, RepositoryException{
		List<Node> newsList = new ArrayList<Node>();
		
		Session session = MgnlContext.getJCRSession("news");
		Node parentNewsNodeFolder = null;
		if(session.getRootNode().hasNode("caar/news")) {
			parentNewsNodeFolder = session.getRootNode().getNode("caar/news");
			if(parentNewsNodeFolder.getNodes() != null) {
				NodeIterator childList = parentNewsNodeFolder.getNodes();
				while(childList.hasNext()) {
					newsList.add(childList.nextNode());
				}
			}
		}
		
		return newsList;
	}
	
	public String getHeadline(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty("N1.1").getString();
	}
	
	public String getLongTitle(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty("N1.2").getString();
	}
	
	public String getDescription(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty("N1.3").getString();
	}
	
	public String getLongDescription(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty("N1.4").getString();
	}
	
	public String getDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty("N1.5").getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat("dd MMMM YYYY", locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getImage(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty("N1.6").getString();
	}
	
	public String getCategories(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty("N1.7").getValues().toString();
	}
	
	public String getImportant(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty("N1.8").getString();
	}
	
	public String getArchitectLinks(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty("N1.9").getValues().toString();
	}
	
	public String getRelatedNews(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty("N1.10").getValues().toString();
	}
	}
