package es.arquia.magnolia.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import info.magnolia.cms.i18n.I18nContentSupport;
import info.magnolia.context.MgnlContext;

import static es.arquia.magnolia.constants.ArchitectureFilesSupportArchitectConstants.departmentComponents;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.*;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;

public class ArchitectureFilesSupportBusinessImpl implements ArchitectureFilesSupportBusiness {
	
private I18nContentSupport i18nContentSupport;
	
	@Inject
	public ArchitectureFilesSupportBusinessImpl(final I18nContentSupport i18n) {
		this.i18nContentSupport = i18n;
	}
	
	private String getPropertyAsString(Node node, String property) {
		try {
			return i18nContentSupport.getProperty(node, property).getString();
		}catch(RepositoryException e) {
			return "";
		}
	}
	
	private List<Node> getPropertyAsListOfNodes(Node node, String property) {
		List<Node> listNodes = new ArrayList<>();
		try {
		Node tmpNode = node.getNode(property);
			for(NodeIterator iterator = tmpNode.getNodes(); iterator.hasNext();) {
				listNodes.add(iterator.nextNode());
			}
		}catch(RepositoryException e) {
			return listNodes;
		}
		return listNodes;
	}

	@Override
	public String getBusinessType(Node node) throws RepositoryException {
		return getPropertyAsString(node, businessType);
	}

	@Override
	public String getLegalName(Node node) throws RepositoryException {
		return getPropertyAsString(node, legalName);
	}

	@Override
	public String getLogo(Node node) throws RepositoryException {
		return getPropertyAsString(node, logo);
	}

	@Override
	public String getConstitutionDate(Node node) throws RepositoryException {
		try {
			Calendar calendar = node.getProperty(constitutionDate).getDate();
			Locale locale = MgnlContext.getAggregationState().getLocale();
			DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
			return formatter.format(calendar.getTime());
		} catch(RepositoryException e) {
			return "";
		}
	}

	@Override
	public String getDepartmentWebsite(Node node) throws RepositoryException {
		return getPropertyAsString(node, departmentWebSite);
	}

	@Override
	public String getDepartmentCity(Node node) throws RepositoryException {
		return getPropertyAsString(node, departmentCity);
	}

	@Override
	public String getDepartmentCountry(Node node) throws RepositoryException {
		return getPropertyAsString(node, departmentCountry);
	}

	@Override
	public List<String> getDepartmentComponents(Node node) throws RepositoryException {
		List<String> list = new ArrayList<>();
		try {
			for(Value iterator : node.getProperty(departmentComponents).getValues()) {
				list.add(iterator.getString());
			}
		} catch(RepositoryException e) {}
		return list;
	}

	@Override
	public String getBiographicNews(Node node) throws RepositoryException {
		return getPropertyAsString(node, biographicNews);
	}

	@Override
	public String getCurriculum(Node node) throws RepositoryException {
		return getPropertyAsString(node, curriculum);
	}

	@Override
	public String getAwardsAndDistinctions(Node node) throws RepositoryException {
		return getPropertyAsString(node, awardsAndDistinctions);
	}

	@Override
	public String getAdditionalInfo(Node node) throws RepositoryException {
		return getPropertyAsString(node, aditionalInfo);
	}

	@Override
	public String getAnnexes(Node node) throws RepositoryException {
		return null;
	}

	@Override
	public String getDossier(Node node) throws RepositoryException {
		return null;
	}

	@Override
	public List<Node> getRelatedFiles(Node node) throws RepositoryException {
		return getPropertyAsListOfNodes(node, relatedFiles);
	}

}
