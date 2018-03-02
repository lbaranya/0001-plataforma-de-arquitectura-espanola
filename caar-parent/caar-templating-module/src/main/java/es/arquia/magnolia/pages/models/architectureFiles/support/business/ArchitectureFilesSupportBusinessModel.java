package es.arquia.magnolia.pages.models.architectureFiles.support.business;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportBusinessNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.aditionalInfo;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.annexes;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.awardsAndDistinctions;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.biographicNews;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.businessType;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.constitutionDate;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.curriculum;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.departmentCity;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.departmentComponents;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.departmentCountry;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.departmentWebSite;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.dossier;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.legalName;
import static es.arquia.magnolia.constants.ArchitectureFilesSupportBusinessConstants.logo;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.utils.ArchitectureFilesSupportArchitect;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;

public class ArchitectureFilesSupportBusinessModel <RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportBusinessModel.class);
	
	private ArchitectureFilesSupportArchitect architect;
	
	@Inject
	public ArchitectureFilesSupportBusinessModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final ArchitectureFilesSupportArchitect architect) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.architect = architect;
    }
	
	public String getBusinessType(Node node) throws RepositoryException {
		return node.getProperty(businessType).getString();
	}
	
	public String getLegalName(Node node) throws RepositoryException {
		return node.getProperty(legalName).getString();
	}
	
	public String getLogo(Node node) throws RepositoryException{
		return node.getProperty(logo).getString();
	}
	
	public String getConstitutionDate(Node node) throws RepositoryException {
		Calendar calendar = node.getProperty(constitutionDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getDepartmentWebSite(Node node) throws RepositoryException{
		return node.getProperty(departmentWebSite).getString();
	}
	
	public String getDepartmentCity(Node node) throws RepositoryException{
		return node.getProperty(departmentCity).getString();
	}
	
	public String getDepartmentCountry(Node node) throws RepositoryException{
		return node.getProperty(departmentCountry).getString();
	}
	
	public List<String> getDepartmentComponents(Node node) throws RepositoryException{
		List<String> list = new ArrayList<String>();
		for(Value iterator : node.getProperty(departmentComponents).getValues()) {
			list.add(iterator.getString());
		}
		return list;
	}
	
	public String getBiographicNews(Node node) throws RepositoryException{
		return node.getProperty(biographicNews).getString();
	}
	
	public String getCurriculum(Node node) throws RepositoryException{
		return node.getProperty(curriculum).getString();
	}
	
	public String getAwardsAndDistinctions(Node node) throws RepositoryException{
		return node.getProperty(awardsAndDistinctions).getValues().toString();
	}
	
	public String getAditionalInfo(Node node) throws RepositoryException{
		return node.getProperty(aditionalInfo).getString();
	}
	
	public String getAnnexes(Node node) throws RepositoryException{
		return node.getProperty(annexes).getValues().toString();
	}
	
	public String getDossier(Node node) throws RepositoryException{
		return node.getProperty(dossier).getString();
	}
	
	public String getDepartmentWebSiteFieldName() {
		return departmentWebSite;
	}
	
	public boolean isBusinessNodeType(String nodeJcrPath) throws RepositoryException {
		Node node = MgnlContext.getJCRSession(architectureFilesWorkspace).getNode(nodeJcrPath);
		try {
            return node.isNodeType(architectureFilesSupportBusinessNodeType);
        } catch (RepositoryException e) {
            log.error("Unable to read nodeType for node {}", NodeUtil.getNodePathIfPossible(node));
        }
        return false;
	}
	
	public ArchitectureFilesSupportArchitect getArchitect() {
		return architect;
	}
	
}
