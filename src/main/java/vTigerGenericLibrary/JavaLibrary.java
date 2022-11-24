package vTigerGenericLibrary;

	import java.util.Date;
import java.util.Random;

	//single line comment 
	/*multi  line comment*/
	 /** this method will generate random number for every execution 
	 @author Family 
	 Generic library is the first foremost designed is generic library inFramework  .Automation consultant of 
	 10 to 15 years experience,will write the libraries.there is moucehover,depending on the crs they write the 
	 libraries, they design generic utilities,
	 *
	 */
	public class JavaLibrary {
		
		public int getRandomNumber()
		{/**this method will generate random number for every execution
		  */
			Random ran=new Random();
			int value=ran.nextInt(500);
			return value;
		}
		/**
		 * This method will generate the system date
		 * @return
		 */
		public String getSystemDate()
		{
			Date d = new Date();
			String date = d.toString();
			return date;
		}
		
		/*
		 * This method will return the current system date in a specific format
		 * @return
		 */
		public String getSystemDateInFormat()
		{
			Date d = new Date();
			String[] dArr = d.toString().split(" ");
			String month = dArr[1];
			String date = dArr[2];
			String year = dArr[5];
			String time = dArr[3].replace(":", "-");
			
			String dateInFormat = date+"-"+month+"-"+year+"-"+time;
			return dateInFormat;
		}
	}



