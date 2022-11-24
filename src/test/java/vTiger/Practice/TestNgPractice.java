package vTiger.Practice;

import org.testng.annotations.Test;

public class TestNgPractice {
	
	@Test(invocationCount= 2, priority =-1)
	public void createCustomer()
	{
		System.out.println("create customer");
	}
   @Test (priority=1)
   public void modifyCustomer()
   {
	   System.out.println("modified customer");
   }
   @Test
   public void deleteCustomer()
   {
	   System.out.println("delete customer");
   }
}
