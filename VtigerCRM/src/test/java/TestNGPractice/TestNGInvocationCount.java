package TestNGPractice;

import org.testng.annotations.Test;

public class TestNGInvocationCount {
	
	@Test
	public void createContact()
	{

	System.out.println("contact created");

	}
    @Test
	public void modifyContact()
	{
		System.out.println("modify contact");
	}
	
	@Test(invocationCount = 2)
	public void deleteContact()
	{
		System.out.println("delete contact");
	}
	
	
	

}
