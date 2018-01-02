package es.arquia.magnolia.commands;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import es.arquia.magnolia.messages.magnoliaUI.MessagesUI;
import info.magnolia.commands.CommandsManager;
import info.magnolia.commands.impl.BaseRepositoryCommand;
import info.magnolia.context.Context;
import info.magnolia.i18nsystem.SimpleTranslator;
import info.magnolia.module.mail.MailTemplate;
import info.magnolia.ui.api.action.ActionExecutionException;
import info.magnolia.ui.api.message.MessageType;

public class RequestTranslationCommand extends BaseRepositoryCommand {
    
    /** The Constant TEMPLATE_PARAMETER_NAME. */
    private static final String TEMPLATE_PARAM_NAME = "mailTemplate";
    
    /** The Constant DATA_PARAMETER_NAME. */
    private static final String DATA_PARAM_NAME = "emailData";
    
    /** Email data parameters names */
    private static final String DATA_PATH_TO_TRANSLATABLE_NODE_PARAM_NAME = "pathToTranslatableNode";
    private static final String DATA_REPOSITORY_OF_TRANSLATABLE_NODE_PARAM_NAME = "repositoryOfTranslatableNode";
    
    private static final String MAIL_PARAMETER_SEPARATOR = "\r\n";
    
    private static final String ACTION_FAILED_SUBJECT_I18N_KEY = "caar-utils-module.templates.email.requestTranslation.actionFailedSubject";
    private static final String ACTION_FAILED_BODY_MESSAGE_I18N_KEY = "caar-utils-module.templates.email.requestTranslation.actionFailedMessage";
    private static final String ACTION_COMPLETED_SUBJECT_I18N_KEY = "caar-utils-module.templates.email.requestTranslation.actionCompletedSubject";
    private static final String ACTION_COMPLETED_BODY_MESSAGE_I18N_KEY = "caar-utils-module.templates.email.requestTranslation.actionCompletedMessage";
	
	private final CommandsManager commandsManager;
	
    /** The mail command catalog. */
    private String mailCommandCatalog;
  
    /** The mail command. */
    private String mailCommand;
    
    private final SimpleTranslator i18n;
    
    private final MessagesUI messagesUI;
    
    /** The mail template. */
    private String mailTemplate;
    
    private String subject;
    
    private String from;
    
    private String to;
	
	@Inject
	public RequestTranslationCommand(final CommandsManager commandsManager, final SimpleTranslator i18n, final MessagesUI messagesUI) {
		this.commandsManager = commandsManager;
		this.i18n = i18n;
		this.messagesUI = messagesUI;
	}

	@Override
	public boolean execute(Context context) throws Exception {

		Map<String, Object> mailCommandParameters = new HashMap<>();
		
		this.addTemplateNodeConfigName(mailCommandParameters);
        
		this.addTemplateData(mailCommandParameters);
		
		this.addEMailParams(mailCommandParameters);
		
		this.commandCall(mailCommandParameters);
		
		this.notifySuccessResult();

		return true;
	}
	

	


	/**
	 * @param mailCommandParameters
	 * @return mail command parameters with node name added that defines mail template in /modules/mail/config/templatesConfiguration
	 */
	private Map<String, Object> addTemplateNodeConfigName(Map<String, Object> mailCommandParameters) {
		
		mailCommandParameters.put(TEMPLATE_PARAM_NAME, this.mailTemplate);
		
		return mailCommandParameters;
	}
	
	/**
	 * @param mailCommandParameters
	 * @return mail command parameters with Map that represents data to be inserted into template script
	 */
	private Map<String, Object> addTemplateData(Map<String, Object> mailCommandParameters) {
        
		    Map<String, Object> dataParameters = new HashMap<>();
		    dataParameters.put(DATA_PATH_TO_TRANSLATABLE_NODE_PARAM_NAME, this.getPath());
		    dataParameters.put(DATA_REPOSITORY_OF_TRANSLATABLE_NODE_PARAM_NAME, this.getRepository());
        mailCommandParameters.put(DATA_PARAM_NAME, dataParameters);
        
        return mailCommandParameters;
	}
	
	/**
	 * @param mailCommandParameters
	 * @return mail command parameters with mail parameters (to, from, etc) added
	 */
	private Map<String, Object> addEMailParams(Map<String, Object> mailCommandParameters) {
		
        // Mail parameters (to, from, etc) defined in a string with format name=value\r\nname=value
	        StringBuffer sbParameters = new StringBuffer();
	        sbParameters.append(MailTemplate.MAIL_TO + "=" + this.to);
	        sbParameters.append(MAIL_PARAMETER_SEPARATOR);
	        sbParameters.append(MailTemplate.MAIL_FROM + "=" + this.from);
	        sbParameters.append(MAIL_PARAMETER_SEPARATOR);
	        sbParameters.append(MailTemplate.MAIL_SUBJECT + "=" + this.i18n.translate(this.subject));
	    mailCommandParameters.put(MailTemplate.MAIL_PARAMETERS, sbParameters.toString());
		
	    return mailCommandParameters;
	}
	
	/**
	 * @param mailCommandParameters
	 * @throws ActionExecutionException 
	 */
	private void commandCall(Map<String, Object> mailCommandParameters) throws ActionExecutionException {
        
        // Command call
        String commandExecutionFailedSubject = this.i18n.translate(ACTION_FAILED_SUBJECT_I18N_KEY);
        String commandExecutionFailedMessage = this.i18n.translate(ACTION_FAILED_BODY_MESSAGE_I18N_KEY, this.getPath());
		try {
			
			// Method executeCommand returns an inverse logic result: true if failed...
			if (this.commandsManager.executeCommand(this.mailCommandCatalog, this.mailCommand, mailCommandParameters)) {
				this.notifyActionExecutionErrorResult(commandExecutionFailedSubject, commandExecutionFailedMessage);
			}
			
		} catch (Exception e) {
			
			this.notifyActionExecutionErrorResult(commandExecutionFailedSubject, commandExecutionFailedMessage);
		}
	}
	
	/**
	 * Notify success result to current Magnolia user
	 */
	private void notifySuccessResult() {
		
		this.messagesUI.sendToCurrentUser(MessageType.INFO, this.i18n.translate(ACTION_COMPLETED_SUBJECT_I18N_KEY), this.i18n.translate(ACTION_COMPLETED_BODY_MESSAGE_I18N_KEY));
	}
	
	/**
	 * Notify action execution error result to current Magnolia user
	 * 
	 * @param subject
	 * @param message
	 * @throws ActionExecutionException 
	 */
	private void notifyActionExecutionErrorResult(String subject, String message) throws ActionExecutionException {
		
		this.messagesUI.sendToCurrentUser(MessageType.ERROR, subject, message);
		
		throw new ActionExecutionException(message);
	}
	
	
	

	public String getMailCommandCatalog() {
		return mailCommandCatalog;
	}

	public void setMailCommandCatalog(String mailCommandCatalog) {
		this.mailCommandCatalog = mailCommandCatalog;
	}

	public String getMailCommand() {
		return mailCommand;
	}

	public void setMailCommand(String mailCommand) {
		this.mailCommand = mailCommand;
	}

	public String getMailTemplate() {
		return mailTemplate;
	}

	public void setMailTemplate(String mailTemplate) {
		this.mailTemplate = mailTemplate;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

}
