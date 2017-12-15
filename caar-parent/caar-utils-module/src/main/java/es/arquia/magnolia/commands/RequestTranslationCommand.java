package es.arquia.magnolia.commands;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import info.magnolia.commands.CommandsManager;
import info.magnolia.commands.impl.BaseRepositoryCommand;
import info.magnolia.context.Context;
import info.magnolia.i18nsystem.SimpleTranslator;
import info.magnolia.module.mail.MailTemplate;

public class RequestTranslationCommand extends BaseRepositoryCommand {
    
    /** The Constant TEMPLATE_PARAMETER_NAME. */
    private static final String TEMPLATE_PARAM_NAME = "mailTemplate";
    
    /** The Constant DATA_PARAMETER_NAME. */
    private static final String DATA_PARAM_NAME = "emailData";
    
    /** Email data parameters names */
    private static final String DATA_PATH_TO_TRANSLATABLE_NODE_PARAM_NAME = "pathToTranslatableNode";
    
    private static final String MAIL_PARAMETER_SEPARATOR = "\r\n";
	
	private final CommandsManager commandsManager;
  
    /** The mail command catalog. */
    private String mailCommandCatalog;
  
    /** The mail command. */
    private String mailCommand;
    
    private final SimpleTranslator i18n;
    
    /** The mail template. */
    private String mailTemplate;
    
    private String subject;
    private String from;
    private String to;
	
	@Inject
	public RequestTranslationCommand(final CommandsManager commandsManager, final SimpleTranslator i18n) {
		this.commandsManager = commandsManager;
		this.i18n = i18n;
	}

	@Override
	public boolean execute(Context context) throws Exception {

		Map<String, Object> mailParameters = new HashMap<>();
		
		// Node name that defines mail template in /modules/mail/config/templatesConfiguration
        mailParameters.put(TEMPLATE_PARAM_NAME, this.mailTemplate);
        
        // Mail parameters (to, from, etc) defined in a string with format name=value\r\nname=value
	        StringBuffer sbParameters = new StringBuffer();
	        sbParameters.append(MailTemplate.MAIL_TO + "=" + this.to);
	        sbParameters.append(MAIL_PARAMETER_SEPARATOR);
	        sbParameters.append(MailTemplate.MAIL_FROM + "=" + this.from);
	        sbParameters.append(MAIL_PARAMETER_SEPARATOR);
	        sbParameters.append(MailTemplate.MAIL_SUBJECT + "=" + this.i18n.translate(this.subject));
	    mailParameters.put(MailTemplate.MAIL_PARAMETERS, sbParameters.toString());
        
	    // Map that represents data to be inserted into template script
		    Map<String, Object> dataParameters = new HashMap<>();
		    dataParameters.put(DATA_PATH_TO_TRANSLATABLE_NODE_PARAM_NAME, this.getPath());
        mailParameters.put(DATA_PARAM_NAME, dataParameters);
        
        // Command call
		this.commandsManager.executeCommand(this.mailCommandCatalog, this.mailCommand, mailParameters);

		return true;
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
