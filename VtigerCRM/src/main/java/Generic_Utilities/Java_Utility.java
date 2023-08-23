package Generic_Utilities;

import java.util.Date;
import java.util.Random;
/**
 * This class consists of generic methods related to java
 * @author mamta
 */

public class Java_Utility {

	/**
	 * 	 * This method is used to avoid Duplicate records
	 * @return
	 * @author mamta
	 */
		
		public int getRandomNum()// no need to parameterize the method 
		{
			Random r =new Random();
			int ranNum=r.nextInt(1000);
			return ranNum;
			
		}
		
	public String getSystemDate()
	{
		Date d=new Date();
		return d.toString();
	}
		
		
		

	

	
	

}
