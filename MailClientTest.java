import static org.junit.Assert.*;

import org.junit.Test;


/**
 * @author shahrokh
 *
 */
public class MailClientTest
{

	 MailServer mailServer = new MailServer();
	MailClient   Bryan = new MailClient(mailServer, "Bryan");
	MailClient    Tom    = new MailClient(mailServer, "Tom");
	
	
	
	
	
	@Test
	public void testSending()
	{
		Bryan.sendMailItem("Tom", "meeting", " Please try to show up for the meeting on time.");
		Tom.sendMailItem("Bryan", "new cellphone", "I need to replace my broken phone.");
	}

	@Test
	public void testGetNextMailItem()
	{
		Tom.sendMailItem("Bryan",  "meeting", " Please try to show up for the meeting on time.");
		assertEquals("Bryan", Bryan.getNextMailItem().getTo());
				
	   Tom.sendMailItem("Bryan",  "meeting", " Please try to show up for the meeting on time.");
	   assertEquals("Tom"	, Bryan.getNextMailItem().getFrom());
		
		Tom.sendMailItem("Bryan",  "meeting", " Please try to show up for the meeting on time.");
		assertEquals("meeting", Bryan.getNextMailItem().getSubject());
		
		Tom.sendMailItem("Bryan",  "meeting", " Please try to show up for the meeting on time.");
		assertEquals("Please try to show up for the meeting on time.", Bryan.getNextMailItem().getMessage());
		}
	
}
