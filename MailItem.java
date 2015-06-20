/**
 * A class to model a simple mail item. The item has sender and recipient
 * addresses and a message string.
 * 
 * @author Shawn Vahid	
 * @version 1 (April 1.2015)
 */
public class MailItem
{
 
    private String from;
    private String to;
    private String message;
    private String subject;

    public MailItem()
    {
    	this.from = "";
    	this.to = "";
    	this.message = "";
    	this.subject = "";
    }
    
    /**
     * Create a mail item from sender to the given recipient,
     * containing the given message.
     * @param from The sender of this item.
     * @param to The intended recipient of this item.
     * @param message The text of the message to be sent.
     */
    public MailItem(String from, String to, String message, String subject)
    {
  
        if(from != null && !from.isEmpty()){
        this.from =SpamFilter.formattedString(from);
        }
        if(to != null && !to.isEmpty()){
        this.to = SpamFilter.formattedString(to);
        }
        
        this.message = message;
        this.subject    = subject;

    }

    /**
     * @return The sender of this message.
     */
    public String getFrom()
    {
        return from;
    }

    /**
     * @return The intended recipient of this message.
     */
    public String getTo()
    {
        return to;
    }

    /**
     * @return The text of the message.
     */
    public String getMessage()
    {
        return message;
    }

    public String getSubject() {
		return subject;
	}
    
    /**
     * Print this mail message to the text terminal.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
	
}
