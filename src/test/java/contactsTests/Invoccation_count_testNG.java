package contactsTests;

import org.testng.annotations.Test;

public class Invoccation_count_testNG {
	@Test(priority=1)	//(priority=1) register() will execute first and// if we dont give priority it will execute alphebetical order of method name we give
	public void register() {
		
		System.out.println("registration successful");
	}
		@Test(invocationCount=5)// login() EXECUTE 5 TIMES//invocationCount-USED FOR EXECUTE METHODS NOF TIMES
	public void login() {
		
		System.out.println("Login successful");
	}
		@Test(priority=3)	
	public void addTocart() {
		
		System.out.println(" Product added to cart");
	}
	@Test(priority=4)
	public void placeorder() {
		
	System.out.println("order placed");
}}
