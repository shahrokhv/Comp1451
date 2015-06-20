import static org.junit.Assert.*;
import org.junit.Test;



/**
 * @author 
 *
 */
public class MailItemTest {


	@Test
	public void testGetFfrom() {
		
		MailItem mailItem = new MailItem("     sHawn", "    WalLy", " We fixed the problem with the Junit!", " Test!" );
		assertEquals("Shawn", mailItem.getFrom());
	}
	
	@Test
	public void testGetTo()
	{
        MailItem mailItem = new MailItem("     sHawn", "    JohN", " I haven't finished my project yet!", " Project" );
		assertEquals("John", mailItem.getTo());
	}
	
      public void testGetMessage()
		{
			MailItem mailItem = new MailItem(" Dan", "Ryan" , "This is just for testing the message line", " Subject line!");
			assertEquals("This is just for testing the message line", mailItem.getMessage());
		}
	
         public void testGetSubject()
         {
        	 MailItem mailItem = new MailItem(" Dan", "Ryan" , "This is just for testing the message line", " Subject line!");
 			assertEquals("Subject line!", mailItem.getSubject());
         }
         
         


	}

