package es.arquia.magnolia.commands;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import info.magnolia.commands.CommandsManager;
import info.magnolia.commands.impl.BaseRepositoryCommand;
import info.magnolia.context.Context;

public class RequestTranslationCommand extends BaseRepositoryCommand {
    
    /** The Constant TEMPLATE_PARAMETER_NAME. */
    private static final String TEMPLATE_PARAMETER_NAME= "mailTemplate";
    
    /** The Constant DATA_PARAMETER_NAME. */
    private static final String DATA_PARAMETER_NAME= "emailData";
	
	private final CommandsManager commandsManager;
  
    /** The mail command catalog. */
    private String mailCommandCatalog;
  
    /** The mail command. */
    private String mailCommand;
    
    /** The mail template. */
    private String mailTemplate;
	
	@Inject
	public RequestTranslationCommand(final CommandsManager commandsManager) {
		this.commandsManager = commandsManager;
	}

	@Override
	public boolean execute(Context context) throws Exception {

		Map<String, Object> mailParameters = new HashMap<>();
        mailParameters.put(TEMPLATE_PARAMETER_NAME, this.mailTemplate);
        mailParameters.put(DATA_PARAMETER_NAME, this.getPath());
        
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

}
