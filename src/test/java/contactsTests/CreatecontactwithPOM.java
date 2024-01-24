package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUTilities.ExcelFileUTility;
import genericUTilities.PropertyFileUtility;
import genericUTilities.SeleniumUTility;
import objectRepository.Contactspage;
import objectRepository.CreateContactInfopage;
import objectRepository.CreateNewContactpage;
import objectRepository.Homepage;
import objectRepository.Loginpage;

public class CreatecontactwithPOM {
	
public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
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
		Loginpage Ip=new Loginpage(driver);
        Ip.loginToApp(USERNAME, PASSWORD);
		//step4:click on contact link
		Homepage hp=new Homepage(driver);
        hp.clickoncontactsLink();
		//step5:click on create contact look up image
        Contactspage CP=new Contactspage(driver);
        	CP.clickonCreateContactLookUpImg();
        

		//step6:create new contact&SAVE
        	CreateNewContactpage CNCP1 =new CreateNewContactpage(driver);
            CNCP1.CreateNewContact(LASTNAME);
		

		//step7:validate
        CreateContactInfopage ci=new CreateContactInfopage(driver);
            
		String disply=ci.captureHeadertext();
		if(disply.contains(LASTNAME)) {
			System.out.println(disply+" "+" "+ "test case passed");
		}
		else {
			System.out.println("test caseis failed");
		}
		
		//step8:logout application
		hp.logoutofApp(driver);
		//STEP 9:close the browser
	driver.quit();

		
			
}
}
