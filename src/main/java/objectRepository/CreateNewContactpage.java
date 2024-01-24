package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUTilities.SeleniumUTility;

public class CreateNewContactpage extends SeleniumUTility{
	
	@FindBy(name="lastname")
	private WebElement LastNameEdt;	
	@FindBy(css="input[class=\"crmButton small save\"]")
	private WebElement SaveBtn;	
	@FindBy(name="leadsource")
	private WebElement leadsourceDropdown;	
	//initialization
	public CreateNewContactpage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
//utilization	
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	
	public WebElement getLeadsourceDropdown() {
		return leadsourceDropdown;
	}
	//business library
/*this method will create a new contact and save it
 * @param LASTNAME
 * @PARAM LEADSOURCEVALUE
 * */	
public void  CreateNewContact(String LASTNAME) {
	LastNameEdt.sendKeys(LASTNAME);
	SaveBtn.click();
}
	public void  CreateNewContact(String LASTNAME,String LEADSOURCEVALUE) {
		LastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadsourceDropdown,1);
		SaveBtn.click();
		 	
}
}
