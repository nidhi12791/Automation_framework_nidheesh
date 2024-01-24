package contactsTests;

import java.io.IOException;

import org.testng.annotations.Test;

import genericUTilities.BaseClass;
import genericUTilities.ExcelFileUTility;
import objectRepository.Contactspage;
import objectRepository.CreateContactInfopage;
import objectRepository.CreateNewContactpage;
import objectRepository.Homepage;

public class Contactby_testngsuit_implimentation extends BaseClass {
	@Test
	public void create_contact() throws InterruptedException, IOException {
		ExcelFileUTility eUtil=new ExcelFileUTility();
		/* read test data from excel file*/
		
		String LASTNAME = eUtil.readDataFromExcelFile("Contacts",1,2);
		
		
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
					    driver.close();
		
	          }
              }
