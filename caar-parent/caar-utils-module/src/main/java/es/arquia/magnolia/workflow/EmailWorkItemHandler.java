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
    
    /** The Constant TASK_RESULT_PARAMETER_NAME. */
    private static final String TASK_RESULT_PARAM_NAME= "taskResult";

    /** The Constant TASK_RESULT_VALUE. */
    private static final String TASK_RESULT_VALUE = "decision";
    
    /** The Constant TASK_RESULT_VALUE_REJECT. */
    private static final String TASK_RESULT_VALUE_REJECT = "reject";
    
    private static final String MAIL_PARAMETER_SEPARATOR = "\r\n";
    
    private static final String PUBLICATION_NOTIFICATION_SUBJECT = "caar-utils-module.templates.email.reviewForPublication.subject";
    private static final String REJECTED_PUBLICATION_NOTIFICATION_SUBJECT = "caar-utils-module.templates.email.rejectedPublication.subject";
    
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

		Map<String, Object> mailCommandParameters = new HashMap<>();
		
		boolean publicationRejected = this.isPublicationRejected(workItem);
    	@SuppressWarnings("unchecked")
		Map<String, Object> workflowData = (Map<String, Object>) workItem.getParameter(DATA_PARAM_NAME);
		
		this.addTemplateNodeConfigName(publicationRejected, mailCommandParameters);
		
		this.addTemplateData(workflowData, mailCommandParameters);
		
		this.addEMailParams(publicationRejected, mailCommandParameters);
        
        // Command call
		try {
			this.commandsManager.executeCommand(this.definition.getMailCommandCatalog(), this.definition.getMailCommand(), mailCommandParameters);
		} catch (Exception e) {
			// TODO: show message to Magnolia user
			log.error("Sending publication request email failed: " + "Repository: " + workflowData.get("repository") + " Path: " + workflowData.get("path"), e.getMessage());
		}
		
		// We must complete the workItem, if not, the workflow won´t continue
		manager.completeWorkItem(workItem.getId(), mailCommandParameters);
	}

	@Override
	public void abortWorkItem(WorkItem workItem, WorkItemManager manager) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param workItem
	 * @return true if publication was rejected
	 */
	private boolean isPublicationRejected(WorkItem workItem) {
		
		boolean ret = false;

		Object taskResultObj = workItem.getParameter(TASK_RESULT_PARAM_NAME);
		if (taskResultObj != null) {
	
			@SuppressWarnings("unchecked")
			String taskResult = ((Map<Object, String>)(taskResultObj)).get(TASK_RESULT_VALUE);
			if (taskResult.equalsIgnoreCase(TASK_RESULT_VALUE_REJECT)) {
			
				ret = true;
			}
		}		
		
		return ret;
	}
	
	/**
	 * @param publicationRejected
	 * @param mailCommandParameters
	 * @return mail command parameters with node name added that defines mail template in /modules/mail/config/templatesConfiguration
	 */
	private Map<String, Object> addTemplateNodeConfigName(boolean publicationRejected, Map<String, Object> mailCommandParameters) {
		
			String mailTemplate = (publicationRejected) ? this.definition.getRejectedPublicationMailTemplate() : this.definition.getReviewForPublicationMailTemplate();
        mailCommandParameters.put(TEMPLATE_PARAM_NAME, mailTemplate);
		
		return mailCommandParameters;
	}
	
	/**
	 * @param workflowData
	 * @param mailCommandParameters
	 * @return mail command parameters with Map that represents data to be inserted into template script
	 */
	private Map<String, Object> addTemplateData(Map<String, Object> workflowData, Map<String, Object> mailCommandParameters) {
        
		mailCommandParameters.put(DATA_PARAM_NAME, workflowData);
        
        return mailCommandParameters;
	}
	
	/**
	 * @param publicationRejected
	 * @param mailCommandParameters
	 * @return mail command parameters with mail parameters (to, from, etc) added
	 */
	private Map<String, Object> addEMailParams(boolean publicationRejected, Map<String, Object> mailCommandParameters) {
        
        // Mail parameters (to, from, etc) are defined in a string with format name=value\r\nname=value
	        StringBuffer sbParameters = new StringBuffer();
	        
	        sbParameters.append(MailTemplate.MAIL_TO + "=" + this.definition.getTo());
	        
	        sbParameters.append(MAIL_PARAMETER_SEPARATOR);
	        sbParameters.append(MailTemplate.MAIL_FROM + "=" + this.definition.getFrom());
	        
	        String i18nSubjectKey = (publicationRejected) ? REJECTED_PUBLICATION_NOTIFICATION_SUBJECT : PUBLICATION_NOTIFICATION_SUBJECT;
	        sbParameters.append(MAIL_PARAMETER_SEPARATOR);
	        sbParameters.append(MailTemplate.MAIL_SUBJECT + "=" + this.i18n.translate(i18nSubjectKey));
	        
	    mailCommandParameters.put(MailTemplate.MAIL_PARAMETERS, sbParameters.toString());
		
	    return mailCommandParameters;
	}

}
