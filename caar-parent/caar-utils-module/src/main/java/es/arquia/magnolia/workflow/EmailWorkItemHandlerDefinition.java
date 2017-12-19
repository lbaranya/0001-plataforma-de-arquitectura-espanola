package es.arquia.magnolia.workflow;

import info.magnolia.module.workflow.jbpm.workitem.handler.definition.ConfiguredWorkItemHandlerDefinition;

/**
 * The Class EmailWorkItemHandlerDefinition.
 */
public class EmailWorkItemHandlerDefinition extends ConfiguredWorkItemHandlerDefinition {
  
    /** The mail command. */
    private String mailCommand;
    
    /** The mail template. */
    private String mailTemplate;
    
    private String subject;
    
    private String from;
    
    private String to;
  
    /**
     * Instantiates a new email work item handler definition.
     */
    public EmailWorkItemHandlerDefinition() {
        setImplementationClass(EmailWorkItemHandler.class);
    }
  
    /**
     * Gets the mail template.
     *
     * @return the mail template
     */
    public String getMailTemplate() {
        return mailTemplate;
    }
    
    /**
     * Gets the mail command.
     *
     * @return the mail command
     */
    public String getMailCommand() {
        return mailCommand;
    }
    
    /**
     * Sets the mail template.
     *
     * @param mailTemplate the new mail template
     */
    public void setMailTemplate(String mailTemplate) {
        this.mailTemplate = mailTemplate;
    }
    
    /**
     * Sets the mail command.
     *
     * @param mailCommand the new mail command
     */
    public void setMailCommand(String mailCommand) {
        this.mailCommand = mailCommand;
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