package es.arquia.magnolia.beans;

import static es.arquia.magnolia.constants.AnnouncementConstants.OptionType;
import static es.arquia.magnolia.constants.AnnouncementConstants.enrollmentOptionAbstract;
import static es.arquia.magnolia.constants.AnnouncementConstants.enrollmentOptionButtonLink;
import static es.arquia.magnolia.constants.AnnouncementConstants.enrollmentOptionButtonText;
import static es.arquia.magnolia.constants.AnnouncementConstants.enrollmentOptionImageAnchor;
import static es.arquia.magnolia.constants.AnnouncementConstants.enrollmentOptionRichText;
import static es.arquia.magnolia.constants.AnnouncementConstants.enrollmentOptionTitle;
import static es.arquia.magnolia.constants.AnnouncementConstants.enrollmentOptionWeight;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgeFileLink;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgeName;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgePhoto;
import static es.arquia.magnolia.constants.AnnouncementConstants.judgeText;
import static es.arquia.magnolia.constants.AnnouncementConstants.juryOptionAbstract;
import static es.arquia.magnolia.constants.AnnouncementConstants.juryOptionImageAnchor;
import static es.arquia.magnolia.constants.AnnouncementConstants.juryOptionTitle;
import static es.arquia.magnolia.constants.AnnouncementConstants.juryOptionWeight;
import static es.arquia.magnolia.constants.AnnouncementConstants.lemmaOptionAbstract;
import static es.arquia.magnolia.constants.AnnouncementConstants.lemmaOptionImageAnchor;
import static es.arquia.magnolia.constants.AnnouncementConstants.lemmaOptionLink;
import static es.arquia.magnolia.constants.AnnouncementConstants.lemmaOptionPhotoPreview;
import static es.arquia.magnolia.constants.AnnouncementConstants.lemmaOptionRichText;
import static es.arquia.magnolia.constants.AnnouncementConstants.lemmaOptionTitle;
import static es.arquia.magnolia.constants.AnnouncementConstants.lemmaOptionWeight;
import static es.arquia.magnolia.constants.AnnouncementConstants.richTextOptionAbstract;
import static es.arquia.magnolia.constants.AnnouncementConstants.richTextOptionImageAnchor;
import static es.arquia.magnolia.constants.AnnouncementConstants.richTextOptionRichText;
import static es.arquia.magnolia.constants.AnnouncementConstants.richTextOptionTitle;
import static es.arquia.magnolia.constants.AnnouncementConstants.richTextOptionWeight;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import info.magnolia.cms.i18n.I18nContentSupport;

public class AnnouncementSectionsImpl implements AnnouncementSections {
	
	@Inject
	private I18nContentSupport i18nContentSupport;
	
	private String getPropertyAsString(Node node, String property) {
		try {
			return i18nContentSupport.getProperty(node, property).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	// Get section type
	
	public String getOptionType(Node node){
		return getPropertyAsString(node, OptionType);
	}
	
	// RichText Section
	
	public String getRichTextOptionWeight(Node node){
		return getPropertyAsString(node, richTextOptionWeight);
	}
	
	public String getRichTextOptionTitle(Node node){
		return getPropertyAsString(node, richTextOptionTitle);
	}
	
	public String getRichTextOptionImageAnchor(Node node){
		return getPropertyAsString(node, richTextOptionImageAnchor);
	}
	
	public String getRichTextOptionAbstract(Node node){
		return getPropertyAsString(node, richTextOptionAbstract);
	}
	
	public String getRichTextOptionRichText(Node node){
		return getPropertyAsString(node, richTextOptionRichText);
	}
	
	// Jury Section
	
	public String getJuryOptionWeight(Node node) {
		return getPropertyAsString(node, juryOptionWeight);
	}
	
	public String getJuryOptionImageAnchor(Node node) {
		return getPropertyAsString(node, juryOptionImageAnchor);
	}
	
	public String getJuryOptionTitle(Node node) {
		return getPropertyAsString(node, juryOptionTitle);
	}
	
	public String getJuryOptionAbstract(Node node) {
		return getPropertyAsString(node, juryOptionAbstract);
	}
	
	// Judge inside jury
	
	public String getJudgeName(Node node) {
		return getPropertyAsString(node, judgeName);
	}
	
	public String getJudgePhoto(Node node) {
		return getPropertyAsString(node, judgePhoto);
	}
	
	public String getJudgeFileLink(Node node) {
		return getPropertyAsString(node, judgeFileLink);
	}
	
	public String getJudgeText(Node node) {
		return getPropertyAsString(node, judgeText);
	}
	
	// Enrollment section
	
	public String getEnrollmentOptionWeight(Node node) {
		return getPropertyAsString(node, enrollmentOptionWeight);
	}
	
	public String getEnrollmentOptionImageAnchor(Node node) {
		return getPropertyAsString(node, enrollmentOptionImageAnchor);
	}
	
	public String getEnrollmentOptionTitle(Node node) {
		return getPropertyAsString(node, enrollmentOptionTitle);
	}
	
	public String getEnrollmentOptionAbstract(Node node) {
		return getPropertyAsString(node, enrollmentOptionAbstract);
	}
	
	public String getEnrollmentOptionRichText(Node node) {
		return getPropertyAsString(node, enrollmentOptionRichText);
	}
	
	public String getEnrollmentOptionButtonText(Node node) {
		return getPropertyAsString(node, enrollmentOptionButtonText);
	}
	
	public String getEnrollmentOptionButtonLink(Node node) {
		return getPropertyAsString(node, enrollmentOptionButtonLink);
	}
	
	// Lemma section
	
	public String getLemmaOptionWeight(Node node) {
		return getPropertyAsString(node, lemmaOptionWeight);
	}
	
	public String getLemmaOptionImageAnchor(Node node) {
		return getPropertyAsString(node, lemmaOptionImageAnchor);
	}
	
	public String getLemmaOptionTitle(Node node) {
		return getPropertyAsString(node, lemmaOptionTitle);
	}
	
	public String getLemmaOptionAbstract(Node node) {
		return getPropertyAsString(node, lemmaOptionAbstract);
	}
	
	public String getLemmaOptionRichText(Node node) {
		return getPropertyAsString(node, lemmaOptionRichText);
	}
	
	public String getLemmaOptionLink(Node node) {
		return getPropertyAsString(node, lemmaOptionLink);
	}
	
	public String getLemmaOptionPhotoPreview(Node node) {
		return getPropertyAsString(node, lemmaOptionPhotoPreview);
	}
}
