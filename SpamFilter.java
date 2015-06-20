
public class SpamFilter
{
	private static final String[] spamWrods = {"spam", "Cheap Viagra", "Generic Viagra", "Fake Watches", 
    	"Replica Watches"  };
	
	
	
	  /**
     * Return true of the string contains any of the words
     * within the spamWords array.
     * 
     * @param string a string of any given length
     * @return true or false if the string contains a spamWord
     */
    public boolean spamChecker(String string)
    {
	        for(int i = 0; i < spamWrods.length; i++ ) 
	        {
	            if(string.toLowerCase().contains(spamWrods[i].toLowerCase()))
	            {
	                if(spamWrods[i].equals("SPAM")) 
	                {
	                    if(string.toLowerCase().startsWith(spamWrods[i].toLowerCase()))
	                    {
	                        return true;
	                    }
	                 }  else {
	                               return true;
	                                }
	             }
	         }
	        return false;
     }
	
    
    public static String formattedString(String string)
    {
    	String formattedStrings;
    	String newString = string.trim();
    	formattedStrings =  newString.substring(0, 1).toUpperCase()+newString.substring(1).toLowerCase();
    	return formattedStrings;	
    }
	
}
