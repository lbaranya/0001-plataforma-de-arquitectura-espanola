package es.arquia.magnolia.components.models.architectureFiles.support.business;

import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesSupportBusinessNodeType;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.architectureFilesWorkspace;
import static es.arquia.magnolia.constants.UtilsConstants.dateFormat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.Value;
import javax.jcr.ValueFormatException;

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
	
	private static String businessType = "FS4.1.1";
	private static String legalName = "FS4.1.2";
	private static String logo = "FS4.1.3";
	private static String constitutionDate = "FS4.1.4";
	private static String departmentWebSite = "FS4.1.5";
	private static String departmentCity = "FS4.1.6";
	private static String departmentCountry = "FS4.1.7";
	private static String departmentComponents = "FS4.1.8";
	private static String biographicNews = "FS4.1.9";
	private static String curriculum = "FS4.1.10";
	private static String awardsAndDistinctions = "FS4.1.11";
	
	private static String aditionalInfo = "FS4.2.1";
	private static String annexes = "FS4.2.2";
	private static String dossier = "FS4.2.3";
	
	private ArchitectureFilesSupportArchitect architect;
	
	@Inject
	public ArchitectureFilesSupportBusinessModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent, final ArchitectureFilesSupportArchitect architect) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        this.architect = architect;
    }
	
	public String getBusinessType(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(businessType).getString();
	}
	
	public String getLegalName(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException {
		return node.getProperty(legalName).getString();
	}
	
	public String getLogo(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(logo).getString();
	}
	
	public String getConstitutionDate(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException, ParseException{
		Calendar calendar = node.getProperty(constitutionDate).getDate();
		Locale locale = MgnlContext.getLocale();
		DateFormat formatter = new SimpleDateFormat(dateFormat, locale);
		return formatter.format(calendar.getTime());
	}
	
	public String getDepartmentWebSite(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(departmentWebSite).getString();
	}
	
	public String getDepartmentCity(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(departmentCity).getString();
	}
	
	public String getDepartmentCountry(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(departmentCountry).getString();
	}
	
	public List<String> getDepartmentComponents(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		List<String> list = new ArrayList<String>();
		for(Value iterator : node.getProperty(departmentComponents).getValues()) {
			list.add(iterator.getString());
		}
		return list;
	}
	
	public String getBiographicNews(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(biographicNews).getString();
	}
	
	public String getCurriculum(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(curriculum).getString();
	}
	
	public String getAwardsAndDistinctions(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(awardsAndDistinctions).getValues().toString();
	}
	
	public String getAditionalInfo(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(aditionalInfo).getString();
	}
	
	public String getAnnexes(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(annexes).getValues().toString();
	}
	
	public String getDossier(Node node) throws ValueFormatException, PathNotFoundException, RepositoryException{
		return node.getProperty(dossier).getString();
	}
	
	public String getDepartmentWebSiteFieldName() {
		return departmentWebSite;
	}
	
	public boolean isBusinessNodeType(String nodeJcrPath) throws PathNotFoundException, LoginException, RepositoryException {
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
