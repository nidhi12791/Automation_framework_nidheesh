package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUTilities.SeleniumUTility;

public class Homepage extends SeleniumUTility {

	// declaration-webelement-dropdowns,windows,frame,mousehovering
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;	
	@FindBy(linkText="products")
	private WebElement productLnk;
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	@FindBy(linkText="Sign Out")
	private WebElement signoutLnk;
//Intialisation	
	public Homepage(WebDriver driver) {
	PageFactory.initElements(driver,this);	
	}
//Utilisation	
	public WebElement getContactsLnk() {
		return contactsLnk;
	}
	
	public WebElement getProductLnk() {
		return productLnk;
	}
	
	public WebElement getAdministratorImg() {
		return administratorImg;
	}
	
	public WebElement getSignoutLnk() {
		return signoutLnk;
	}
	
//business Library
/*this method will click on contacts link 
 * */
public void clickoncontactsLink() {
contactsLnk.click();	
}
/*
 * this method will perform sign-out opration
 * @param driver
 * @throws InterruptedException
 * */
public void logoutofApp(WebDriver driver) throws InterruptedException {
	mouseoverAction(driver,administratorImg);
	Thread.sleep(2000);
	signoutLnk.click();
}
}
