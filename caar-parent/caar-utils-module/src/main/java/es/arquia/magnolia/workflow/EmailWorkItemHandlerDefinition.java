package es.arquia.magnolia.workflow;

import info.magnolia.module.workflow.jbpm.workitem.handler.definition.ConfiguredWorkItemHandlerDefinition;

/**
 * The Class EmailWorkItemHandlerDefinition.
 */
public class EmailWorkItemHandlerDefinition extends ConfiguredWorkItemHandlerDefinition {
  
    /** The mail command catalog. */
    private String mailCommandCatalog;
  
    /** The mail command. */
    private String mailCommand;
    
    private String rejectedPublicationMailTemplate;
    
    private String reviewForPublicationMailTemplate;
    
    private String from;
    
    private String to;
  
    /**
     * Instantiates a new email work item handler definition.
     */
    public EmailWorkItemHandlerDefinition() {
        setImplementationClass(EmailWorkItemHandler.class);
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
     * Sets the mail command.
     *
     * @param mailCommand the new mail command
     */
    public void setMailCommand(String mailCommand) {
        this.mailCommand = mailCommand;
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

	public String getMailCommandCatalog() {
		return mailCommandCatalog;
	}

	public void setMailCommandCatalog(String mailCommandCatalog) {
		this.mailCommandCatalog = mailCommandCatalog;
	}

	public String getRejectedPublicationMailTemplate() {
		return rejectedPublicationMailTemplate;
	}

	public void setRejectedPublicationMailTemplate(String rejectedPublicationMailTemplate) {
		this.rejectedPublicationMailTemplate = rejectedPublicationMailTemplate;
	}

	public String getReviewForPublicationMailTemplate() {
		return reviewForPublicationMailTemplate;
	}

	public void setReviewForPublicationMailTemplate(String reviewForPublicationMailTemplate) {
		this.reviewForPublicationMailTemplate = reviewForPublicationMailTemplate;
	}
}