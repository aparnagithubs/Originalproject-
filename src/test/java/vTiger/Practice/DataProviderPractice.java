package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	@Test(dataProvider = "Phones")
       public void addProductToCartTest(String Name,String model, int price, int qty)
       {
		System.out.println("ph name "+Name+" model"+model+"costs u"+price+"v stock"+qty );
       }
	@DataProvider(name =  "Phones")
	public Object[][] getData()
	{
		Object[][] data=new Object[3][4];
		data[0][0] = "Samsung";
		data[0][1] ="A80";
		data[0][2] =25000;
		data[0][3] =10;
		
		data[1][0] = "Samsung";
		data[1][1] ="11pro";
		data[1][2] =5000;
		data[1][3] =12;
		
		data[2][0] = "Samsung";
		data[2][1] ="galaxy s";
		data[2][2] =10000;
		data[2][3] =5;
				
		return data;}
	
	@Test(dataProvider ="products" )
	
    public void  getDataProducts(String pName, int qty)
    {
		System.out.println("ph name "+pName+" v stock"+qty );
    }
	
	@DataProvider(name= "products")
	public Object[][] getDataProducts()
	{ 
		  Object[][] d= new Object[2][2];
		  d[0][0]="Steel ";
		  d[0][1]=125;
		  
		  d[1][0]="silver";
		   d[1][1]=193;
		return d;}
}
