package es.arquia.magnolia.templates.bean;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;

public class ContextBeanImpl implements ContextBean{
	
	public ContextBeanImpl() {
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
