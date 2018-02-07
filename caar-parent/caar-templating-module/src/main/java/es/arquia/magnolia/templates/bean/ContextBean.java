package es.arquia.magnolia.templates.bean;

import java.util.List;

import javax.jcr.Node;

public interface ContextBean {
	
	public List<Node> getListResultNews();

	public void setListResultNews(List<Node> listResultNews);

	public String getParentPath();

	public void setParentPath(String parentPath);

}
