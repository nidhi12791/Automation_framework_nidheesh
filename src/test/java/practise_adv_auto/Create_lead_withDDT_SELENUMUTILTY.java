package practise_adv_auto;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUTilities.ExcelFileUTility;
import genericUTilities.PropertyFileUtility;
import genericUTilities.SeleniumUTility;

public class Create_lead_withDDT_SELENUMUTILTY {
public static void main(String[] args) throws IOException, InterruptedException {
	//Create OBJECT OF REQUIRED UTILITY CLSS
	
PropertyFileUtility pUtil=new PropertyFileUtility();
ExcelFileUTility eUtil=new ExcelFileUTility();
SeleniumUTility sUtil=new SeleniumUTility();		
		//READ COMMON DATA FROM PROPERTY FILE
String URL=pUtil.readDataFromPropertyFile("url");
String USERNAME=pUtil.readDataFromPropertyFile("username");
String PASSWORD=pUtil.readDataFromPropertyFile("password");	

//READ TEST DATA FROM EXCEL FILE
String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 4, 2);
String COMPANY=eUtil.readDataFromExcelFile("Contacts", 4,4);
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

//step4:click on Leads link
driver.findElement(By.linkText("Leads")).click();
//step5:click on create Leads look up image
driver.findElement(By.cssSelector("img[title='Create Lead...']")).click();
//step6:create new contact
driver.findElement(By.name("lastname")).sendKeys(LASTNAME);	
driver.findElement(By.name("company")).sendKeys(COMPANY);	
WebElement dropdown = driver.findElement(By.cssSelector("select[name='leadsource']"));
dropdown.click();
sUtil.handleDropdown(dropdown, 1);

//step7:save
WebElement scrolldown = driver.findElement(By.xpath("(//input[contains(@class,'crmbutton ')])[2]"));


Thread.sleep(2000);
sUtil.scrolltoWebelement(driver, scrolldown);
scrolldown.click();

//step8:validate
String txt_disply = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
if(txt_disply.contains(LASTNAME)) {
	System.out.println(txt_disply+" "+ "test is passed");
}
else {
	System.out.println("test is failed");
}

//step9:logout application
WebElement lout=driver.findElement(By.xpath("//td[@class='small']//img[@src='themes/softed/images/user.PNG']"));
sUtil.mouseoverAction(driver, lout);
Thread.sleep(2000);
driver.findElement(By.linkText("Sign Out")).click();
driver.close();

}
}
