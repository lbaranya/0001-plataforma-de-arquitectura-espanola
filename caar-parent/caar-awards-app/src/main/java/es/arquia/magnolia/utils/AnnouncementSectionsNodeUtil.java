package es.arquia.magnolia.utils;

import javax.jcr.Node;

public interface AnnouncementSectionsNodeUtil {
	
	public String getOptionType(Node node);
	
	public String getRichTextOptionWeight(Node node);
	
	public String getRichTextOptionTitle(Node node);
	
	public String getRichTextOptionImageAnchor(Node node);
	
	public String getRichTextOptionAbstract(Node node);
	
	public String getRichTextOptionRichText(Node node);
	
	public String getJuryOptionWeight(Node node);
	
	public String getJuryOptionImageAnchor(Node node);
	
	public String getJuryOptionTitle(Node node);
	
	public String getJuryOptionAbstract(Node node);
	
	public String getJudgeName(Node node);
	
	public String getJudgePhoto(Node node);
	
	public String getJudgeFileLink(Node node);
	
	public String getJudgeText(Node node);
	
	public String getEnrollmentOptionWeight(Node node);
	
	public String getEnrollmentOptionImageAnchor(Node node);
	
	public String getEnrollmentOptionTitle(Node node);
	
	public String getEnrollmentOptionAbstract(Node node);
	
	public String getEnrollmentOptionRichText(Node node);
	
	public String getEnrollmentOptionButtonText(Node node);
	
	public String getEnrollmentOptionButtonLink(Node node);
	
	public String getLemmaOptionWeight(Node node);
	
	public String getLemmaOptionImageAnchor(Node node);
	
	public String getLemmaOptionTitle(Node node);
	
	public String getLemmaOptionAbstract(Node node);
	
	public String getLemmaOptionRichText(Node node);
	
	public String getLemmaOptionLink(Node node);
	
	public String getLemmaOptionPhotoPreview(Node node);

}
