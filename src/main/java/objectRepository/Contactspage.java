package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUTilities.SeleniumUTility;

public class Contactspage extends SeleniumUTility {

//declaration
	
@FindBy(xpath="//img[@title='Create Contact...']")
private WebElement CreateContactLookUpImg;
//intialisation
	
public Contactspage(WebDriver driver) {
PageFactory.initElements(driver, this);
}
//utilization

public WebElement getCreateContactLookUpImg() {
return CreateContactLookUpImg;
}
//business Library
/*this method will click on create contact look up image
* */
public void clickonCreateContactLookUpImg() {
	CreateContactLookUpImg.click();
}
}
