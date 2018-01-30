package es.arquia.magnolia.beans;

import static es.arquia.magnolia.constants.AwardConstants.awardAboutText;
import static es.arquia.magnolia.constants.AwardConstants.awardDescription;
import static es.arquia.magnolia.constants.AwardConstants.awardExternalURL;
import static es.arquia.magnolia.constants.AwardConstants.awardHeaderBackground;
import static es.arquia.magnolia.constants.AwardConstants.awardLogo;
import static es.arquia.magnolia.constants.AwardConstants.awardName;
import static es.arquia.magnolia.constants.AwardConstants.categoriesList;
import static es.arquia.magnolia.constants.AwardConstants.type;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

public class Awards {

	public String getType(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(type);
			return tmp.getValue().getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getAwardName(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(awardName);
			return tmp.getValue().getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getAwardDescription(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(awardDescription);
			return tmp.getValue().getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getAwardLogo(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(awardLogo);
			return tmp.getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getAwardExternalURL(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(awardExternalURL);
			return tmp.getValue().getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getAwardHeaderBackground(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(awardHeaderBackground);
			return tmp.getValue().getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getAwardAboutText(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(awardAboutText);
			return tmp.getValue().getString();
		}catch(Exception e) {
			return "";
		}
	}
	
	public String getCategoriesList(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		try{
			Property tmp = node.getProperty(categoriesList);
			return tmp.getValues().toString();
		}catch(Exception e) {
			return "";
		}
	}
	
}
