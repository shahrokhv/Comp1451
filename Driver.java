
public class Driver
{

	public static void main(String[] args) 
	{
	
		
		
		
		
	   MailServer mailServer = new MailServer();

       MailClient   Tom = new MailClient(mailServer, "Tom");
       MailClient   John = new MailClient(mailServer, "John");
	
	  
		MailItem mailItem1 = new MailItem("     andrew", "    ShawN", " We fixed the problem with the Junit! ", " Testing Junit" );
		MailItem mailItem2 = new MailItem("     Syd", "    shawN", " This is just a test!", " newTest!" );
		MailItem mailItem3 = new MailItem("     Ryan", "    Melissa", " I am trying to get my project done on time!", "project" );
		MailItem mailItem4 = new MailItem("     john", "    andrew", " I have a Fake Watches!", " Watches!" );
		MailItem mailItem5 = new MailItem("     Wally", "    Martin", " I love programming Java!", " SPAM" );
		
	     mailServer.post(mailItem1);
	     mailServer.post(mailItem2);
	     mailServer.post(mailItem3);
	     mailServer.post(mailItem4);
	    mailServer.post(mailItem5);
	
		
		Tom.sendMailItem("John", "Spam", " Message A");
		Tom.sendMailItem("John", " Generic Viagra", " Message B");
		Tom.sendMailItem("John", "First Time", " Message C");
		Tom.sendMailItem("John", "Excellent work!", " Message D");
		
		John.sendMailItem("Tom", "Cheap Viagra", "Message A");
		John.sendMailItem("Tom", "Fake Watches", "Message B");
		John.sendMailItem("Tom", "Your new appointment", "Message C");
		John.sendMailItem("Tom", "Car rental in B.C.", "Message D");


	     
	     mailServer.printAllMessages();
	     
	     System.out.println("Number of mail item for Tom is   "     +  mailServer.howManyMailItems("Tom"));
	     System.out.println("Number of mail item for John is   "     +  mailServer.howManyMailItems("John"));
	     System.out.println("Number of mail item for Shawn is   " +  mailServer.howManyMailItems("Shawn"));
	     System.out.println("Number of mail item for Melissa is   "+  mailServer.howManyMailItems("Melissa"));
	     
	}

}


