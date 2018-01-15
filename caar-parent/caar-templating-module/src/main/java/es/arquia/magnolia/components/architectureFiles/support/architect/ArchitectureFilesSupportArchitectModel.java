package es.arquia.magnolia.components.architectureFiles.support.architect;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.Value;
import javax.jcr.ValueFormatException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.arquia.magnolia.components.architectureFiles.support.architect.ArchitectureFilesSupportArchitect;
import info.magnolia.context.MgnlContext;
import info.magnolia.jcr.predicate.AbstractPredicate;
import info.magnolia.jcr.util.NodeTypes;
import info.magnolia.jcr.util.NodeUtil;
import info.magnolia.rendering.model.RenderingModel;
import info.magnolia.rendering.model.RenderingModelImpl;
import info.magnolia.rendering.template.configured.ConfiguredTemplateDefinition;
import static es.arquia.magnolia.constants.ArchitectureFilesConstants.*;

public class ArchitectureFilesSupportArchitectModel <RD extends ConfiguredTemplateDefinition> extends RenderingModelImpl<ConfiguredTemplateDefinition>{
	
	private static final Logger log = LoggerFactory.getLogger(ArchitectureFilesSupportArchitectModel.class);
	
	private ArchitectureFilesSupportArchitect architect;
	
	public ArchitectureFilesSupportArchitectModel(Node content, ConfiguredTemplateDefinition definition, RenderingModel<?> parent) throws PathNotFoundException, RepositoryException {
        super(content, definition, parent);
        architect = new ArchitectureFilesSupportArchitect();
    }
	
	public ArchitectureFilesSupportArchitect getArchitect() {
		return architect;
	}
	
	public boolean isArchitectNodeType(String nodeJcrPath) throws PathNotFoundException, LoginException, RepositoryException {
		Node node = MgnlContext.getJCRSession(architectureFilesWorkspace).getNode(nodeJcrPath);
		try {
            return node.isNodeType(architectureFilesSupportArchitectNodeType);
        } catch (RepositoryException e) {
            log.error("Unable to read nodeType for node {}", NodeUtil.getNodePathIfPossible(node));
        }
        return false;
	}
}
