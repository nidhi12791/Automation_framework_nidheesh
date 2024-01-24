package practise_adv_auto;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import genericUTilities.ExcelFileUTility;
import genericUTilities.PropertyFileUtility;
import genericUTilities.SeleniumUTility;

public class Scenario1withDDTobject_and_generic_utiity {
public static void main(String[] args) throws InterruptedException, IOException {
	
	//Create OBJECT OF REQUIRED UTILITY CLSS
	
	PropertyFileUtility pUtil=new PropertyFileUtility();
	ExcelFileUTility eUtil=new ExcelFileUTility();
	SeleniumUTility sUtil=new SeleniumUTility();
	//READ COMMON DATA FROM PROPERTY FILE
			
	
	String URL=pUtil.readDataFromPropertyFile("url");
	String USERNAME=pUtil.readDataFromPropertyFile("username");
	String PASSWORD=pUtil.readDataFromPropertyFile("password");

	//READ TEST DATA FROM EXCEL FILE
	
	String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 1, 2);

	//STEP1: LAUNCH THE BASE BROWSER
	WebDriver driver=new ChromeDriver();
	sUtil.MaximizeWindow(driver);
	sUtil.addImplicitlyWait(driver);

	//STEP2:LOAD THE APPLICATION
	driver.get(URL);

	//STEP3: LOGIN TO APPLICATION
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();

	//step4:click on contact link
	driver.findElement(By.linkText("Contacts")).click();

	//step5:click on create contact look up image
	driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

	//step6:create new contact
	driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
	
	//step7:save
	driver.findElement(By.cssSelector("input[class=\"crmButton small save\"]")).click();

	//step8:validate
	
	String disply=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
	if(disply.contains(LASTNAME)) {
		System.out.println(disply+" "+" "+ "test case passed");
	}
	else {
		System.out.println("test caseis failed");
	}
	
	//step9:logout application
	WebElement lout=driver.findElement(By.xpath("//td[@class='small']//img[@src='themes/softed/images/user.PNG']"));
	sUtil.mouseoverAction(driver, lout);
	Thread.sleep(2000);
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();

	
	
}
}
