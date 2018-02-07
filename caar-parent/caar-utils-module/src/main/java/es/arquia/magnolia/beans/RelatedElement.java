package es.arquia.magnolia.beans;

public class RelatedElement {
	
	private String title;
	private String photo;
	
	public RelatedElement() {
		super();
	}
	
	public RelatedElement(String title, String photo) {
		this.title = title;
		this.photo = photo;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	
}
