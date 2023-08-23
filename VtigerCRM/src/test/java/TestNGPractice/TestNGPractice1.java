package TestNGPractice;

import org.testng.annotations.Test;

public class TestNGPractice1 {

	
	@Test(priority=0)
	public void createProduct()
	{
		System.out.println("productname created");
	}
	@Test(priority=-1)
	public void modifyProduct()
	{
		System.out.println("productName modified");
	}
	@Test(priority=1)
	public void deleteProductName()
	{
		System.out.println("productName Deleted");
	}
	
	
	
}
