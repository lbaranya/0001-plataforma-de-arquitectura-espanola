package es.arquia.magnolia.beans;

public class RelatedFile {
	
	private String title;
	private String photo;
	
	public RelatedFile() {
		super();
	}
	
	public RelatedFile(String title, String photo) {
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
