import static org.junit.Assert.*;
import org.junit.Test;



/**
 * @author shahrokh
 *
 */
public class MailServerTest
{
 
       MailServer mailServer = new MailServer();
       SpamFilter spamFilter = new SpamFilter();
       MailClient   Tom = new MailClient(mailServer, "Tom");
       MailClient   John = new MailClient(mailServer, "John");
       
	
	/**
	 * @throws java.lang.Exception
	 */

	public void setUp() 
	{
		Tom.sendMailItem("John", "Spam", " Message 1");
		Tom.sendMailItem("John", " Generic Viagra", " Message 2");
		Tom.sendMailItem("John", "First Time", " Message 3");
		Tom.sendMailItem("John", "Excellent work!", " Message 4");
		
		John.sendMailItem("Tom", "Cheap Viagra", "Message 1");
		John.sendMailItem("Tom", "Fake Watches", "Message 2");
		John.sendMailItem("Tom", "Your new appointment", "Message 3");
		John.sendMailItem("Tom", "Car rental in B.C.", "Message 4");

	}

	@Test
	public void testSpamCheckerForTrue() 
	{
		assertEquals(true, spamFilter.spamChecker("SPAM"));
		assertEquals(true, spamFilter.spamChecker("Fake watches"));
		assertEquals(true, spamFilter.spamChecker("Generic Viagra"));
		assertEquals(true, spamFilter.spamChecker("This is not spam"));
		assertEquals(true, spamFilter.spamChecker("I've got Replica Watches!"));
		
	}
	
	@Test
	public void testSpamCheckerForFalse()
	{
		assertEquals(false, spamFilter.spamChecker("spaam"));
		assertEquals(false, spamFilter.spamChecker("Generic pills"));
		assertEquals(false, spamFilter.spamChecker("Fake Watch"));
	}
	
	@Test
	public void testNumberOfMailItems()
	{
		
		assertEquals(2, mailServer.howManyMailItems("John"));
	    assertEquals(2, mailServer.howManyMailItems("Tom"));
	    assertEquals(0, mailServer.howManyMailItems("anonymous"));
		
	}

}
