package es.arquia.magnolia.templates.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;

public class ContextNewsNavImpl implements ContextNewsNav, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4359187170010027587L;

	public ContextNewsNavImpl() {
		listResultNews = new ArrayList<>();
	}

	private List<Node> listResultNews;
	
	private String parentPath;

	public List<Node> getListResultNews() {
		return listResultNews;
	}

	public void setListResultNews(List<Node> listResultNews) {
		this.listResultNews = listResultNews;
	}

	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}
	
	

}
