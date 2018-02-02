package es.arquia.magnolia.beans;

import static es.arquia.magnolia.constants.AwardConstants.awardAboutText;
import static es.arquia.magnolia.constants.AwardConstants.awardDescription;
import static es.arquia.magnolia.constants.AwardConstants.awardExternalURL;
import static es.arquia.magnolia.constants.AwardConstants.awardHeaderBackground;
import static es.arquia.magnolia.constants.AwardConstants.awardLogo;
import static es.arquia.magnolia.constants.AwardConstants.awardName;
import static es.arquia.magnolia.constants.AwardConstants.categoriesList;
import static es.arquia.magnolia.constants.AwardConstants.editionAnnouncementButtonText;
import static es.arquia.magnolia.constants.AwardConstants.editionEnrollmentButtonText;
import static es.arquia.magnolia.constants.AwardConstants.editionNodeType;
import static es.arquia.magnolia.constants.AwardConstants.type;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.functions.LocalizedSuffixUtils;

public class Award {
	
	private LocalizedSuffixUtils localizedSuffix;
	
	@Inject
	public Award(final LocalizedSuffixUtils localizedSuffix) {
		this.localizedSuffix = localizedSuffix;
	}
	
	private static final Logger log = LoggerFactory.getLogger(Award.class);
	
	public String getType(Node node) throws RepositoryException{
		try {
			return node.getProperty(type).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardName(Node node, String currentLanguage) throws RepositoryException{
		try {
			return node.getProperty(awardName + localizedSuffix.getLocalizedSuffix(currentLanguage)).getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(awardName).getString();
			}catch(RepositoryException e2) {
				return "";
			}
		}
	}
	
	public String getAwardDescription(Node node, String currentLanguage) throws RepositoryException{
		try {
			return node.getProperty(awardDescription + localizedSuffix.getLocalizedSuffix(currentLanguage)).getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(awardDescription).getString();
			}catch(RepositoryException e2) {
				return "";
			}
		}
	}
	
	public String getAwardLogo(Node node) throws RepositoryException{
		try {
			return node.getProperty(awardLogo).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardExternalURL(Node node) throws RepositoryException{
		try {
			return node.getProperty(awardExternalURL).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardHeaderBackground(Node node) throws RepositoryException{
		try {
			return node.getProperty(awardHeaderBackground).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	public String getAwardAboutText(Node node, String currentLanguage) throws RepositoryException{
		try {
			return node.getProperty(awardAboutText + localizedSuffix.getLocalizedSuffix(currentLanguage)).getString();
		}catch(RepositoryException e) {
			try {
				return node.getProperty(awardAboutText).getString();
			}catch(RepositoryException e2) {
				return "";
			}
		}
	}
	
	public List<String> getAwardCategoriesList(Node node) throws RepositoryException{
		try{
			List<String> finalList = new ArrayList<>();
			Value[] valuesList = node.getProperty(categoriesList).getValues();
			for (Value value : valuesList) {
				finalList.add(value.getString());
			}
			return finalList;
		}catch(Exception e) {
			return null;
		}
	}
	
	public String getEditionAnnouncementButtonText(Node node, String currentLanguage) throws RepositoryException{
		if(node.isNodeType(editionNodeType)) {
			try {
				return node.getProperty(editionAnnouncementButtonText + localizedSuffix.getLocalizedSuffix(currentLanguage)).getString();
			}catch(RepositoryException e) {
				try {
					return node.getProperty(editionAnnouncementButtonText).getString();
				}catch(RepositoryException e2) {
					return "";
				}
			}
		}else {
			return "";
		}
	}
	
	public String getEditionEnrollmentButtonText(Node node, String currentLanguage) throws RepositoryException{
		if(node.isNodeType(editionNodeType)) {
			try {
				return node.getProperty(editionEnrollmentButtonText + localizedSuffix.getLocalizedSuffix(currentLanguage)).getString();
			}catch(RepositoryException e) {
				try {
					return node.getProperty(editionEnrollmentButtonText).getString();
				}catch(RepositoryException e2) {
					return "";
				}
			}
		}else {
			return "";
		}
	}

}
