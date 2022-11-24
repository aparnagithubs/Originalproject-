package mavenPractice;

import org.testng.annotations.Test;

public class ReadDataFromCmdLineTest {
	@Test
	 public void readData()
	 {
		String BROWSER =System.getProperty("browser");
		System.out.println(BROWSER);
		
		String USERNAME= System.getProperty("username");
		System.out.println(USERNAME);
	 }
	

}
