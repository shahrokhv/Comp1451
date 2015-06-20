import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;


/**
 * A simple model of a mail server. The server is able to receive
 * mail items for storage, and deliver them to clients on demand.
 * 
 *  @author Shawn Vahid	
 * @version 1 (April 1.2015)  
 */
public class MailServer
{
    // Storage for the arbitrary number of mail items to be stored
    // on the server.
    //private List<MailItem> items;
    private HashMap<String, ArrayList<MailItem>>  nameNmail; 
    private SpamFilter spam = new SpamFilter();
   
    /**
     * Construct a mail server.
     */
    public MailServer()
    {
       // items = new ArrayList<MailItem>();
    	nameNmail = new HashMap<String, ArrayList<MailItem> >();
    	
        
    }

    /**
     * Return how many mail items are waiting for a user.
     * @param who The user to check for.
     * @return How many items are waiting.
     */
    public int howManyMailItems(String who)
    {
       ArrayList<MailItem>  tempMail =  nameNmail.get(who);
       int count = 0;
    	
        //count =  tempMail.size();
    	
        //return count;
        
       for(MailItem item : tempMail) {
          if(item.getTo().equals(who)) {
            count++;
           }
      }
     
      return count;
    }

    /**
     * Return the next mail item for a user or null if there
     * are none.
     * @param who The user requesting their next item.
     * @return The user's next item.
     */
    public MailItem getNextMailItem(String who)
    {
    	if(who != null && who !=""){
    	ArrayList<MailItem>  tempMail =  nameNmail.get(who);
        MailItem mailItem = new MailItem();
        
        mailItem =tempMail.remove(0);
    	
    	return  mailItem;
    }
    	return null;
    }

    /**
     * Add the given mail item to the message list.
     * @param item The mail item to be stored on the server.
     */
    public void post(MailItem item)
    {

	    	if(!spam.spamChecker(item.getMessage()) && !spam.spamChecker(item.getSubject()))
	    	{
			    
			    	if(nameNmail.containsKey(item.getTo()))
			        {
				    	ArrayList<MailItem>  tempMail =  nameNmail.get(item.getTo());
				        tempMail.add(item);        
			    	}else
			    	   {
				    		ArrayList<MailItem>	newMail = new ArrayList<MailItem>();
				    		newMail.add(item);
				    		nameNmail.put(item.getTo(), newMail);
			        	}
	           }else
	    	         {
				    	    System.err.print(" There is a spam word in "+ item.getFrom()+ 
				    	    		                           "'s  message! with the subject line: "+ item.getSubject()+"\n");
	                 }
	    		
    }
    
    
    /*
     * This method displays the recipients
     */
    public void displayHashMap()
    {
    	 for    (Entry<String,  ArrayList<MailItem>> entry : nameNmail.entrySet())
    	 {
    		        System.out.print(" recipient:   "+entry.getKey() +"  \n" );
    		        for(MailItem theMails: entry.getValue())
    		        {
    		        	System.out.println(" In Box:  \n "+ theMails);
    		        }
    		        System.out.println();
    	 }
    	   
    }
    
    /**
     * Iterates through all the users, prints out each user name, and 
     * prints out all the emails associated with that user.
     */
    public void printAllMessages()
    {
        Set<String> allUsers = nameNmail.keySet();
        
        for(String name : allUsers) { 
      
            ArrayList<MailItem> mailItems = nameNmail.get(SpamFilter.formattedString(name));
            
            if(mailItems != null) {
                System.out.println("\n..............< All mail for " + name +
                                  " >............................. ");
                
                for(MailItem mail : mailItems) { 
                    System.out.println("To: " + SpamFilter.formattedString(mail.getTo()));           
                    System.out.println("From: " + SpamFilter.formattedString(mail.getFrom()));
                    System.out.println("Subject: " + mail.getSubject());
                    System.out.println("Message: " + mail.getMessage());
                    System.out.println("**********************************************");
                    
                }
            }
            else {
                System.out.println("No mail for " + name);
            }
        }
    }
}