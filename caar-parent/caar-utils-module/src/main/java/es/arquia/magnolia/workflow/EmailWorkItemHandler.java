package es.arquia.magnolia.workflow;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import info.magnolia.commands.CommandsManager;
import info.magnolia.i18nsystem.SimpleTranslator;
import info.magnolia.module.mail.MailTemplate;

public class EmailWorkItemHandler implements WorkItemHandler {
	
	private static final Logger log = LoggerFactory.getLogger(EmailWorkItemHandler.class);
	
    /** The Constant TEMPLATE_PARAMETER_NAME. */
    private static final String TEMPLATE_PARAM_NAME = "mailTemplate";
    
    /** The Constant DATA_PARAMETER_NAME. */
    private static final String DATA_PARAM_NAME= "mgnlData";
    
    private static final String MAIL_PARAMETER_SEPARATOR = "\r\n";
    
    /** The definition. */
    private final EmailWorkItemHandlerDefinition definition;
    
    private final SimpleTranslator i18n;
    
    /** The commands manager. */
    private final CommandsManager commandsManager;

	@Inject
	public EmailWorkItemHandler(final EmailWorkItemHandlerDefinition definition, final CommandsManager commandsManager, final SimpleTranslator i18n) {
        this.definition = definition;
        this.commandsManager = commandsManager;
		this.i18n = i18n;
	}

	@Override
	public void executeWorkItem(WorkItem workItem, WorkItemManager manager) {

		Map<String, Object> mailParameters = new HashMap<>();
		
		// Node name that defines mail template in /modules/mail/config/templatesConfiguration
        mailParameters.put(TEMPLATE_PARAM_NAME, this.definition.getMailTemplate());
        
        // Mail parameters (to, from, etc) defined in a string with format name=value\r\nname=value
	        StringBuffer sbParameters = new StringBuffer();
	        sbParameters.append(MailTemplate.MAIL_TO + "=" + this.definition.getTo());
	        sbParameters.append(MAIL_PARAMETER_SEPARATOR);
	        sbParameters.append(MailTemplate.MAIL_FROM + "=" + this.definition.getFrom());
	        sbParameters.append(MAIL_PARAMETER_SEPARATOR);
	        sbParameters.append(MailTemplate.MAIL_SUBJECT + "=" + this.i18n.translate(this.definition.getSubject()));
	    mailParameters.put(MailTemplate.MAIL_PARAMETERS, sbParameters.toString());
        
	    // Map that represents data to be inserted into template script
	    	@SuppressWarnings("unchecked")
			Map<String, Object> dataParameters = (Map<String, Object>) workItem.getParameter(DATA_PARAM_NAME);
        mailParameters.put(DATA_PARAM_NAME, dataParameters);
        
        // Command call
		try {
			this.commandsManager.executeCommand(this.definition.getMailCommandCatalog(), this.definition.getMailCommand(), mailParameters);
		} catch (Exception e) {
			// TODO: show message to Magnolia user
			log.error("Sending publication request email failed: " + "Repository: " + dataParameters.get("repository") + " Path: " + dataParameters.get("path"), e.getMessage());
		}
		
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}

}
