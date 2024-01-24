package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {  //rule no:1

//rule no:2  identification /declaration
	
@FindBy(name="user_name")
private WebElement usernameEdt;

@FindBy(name="user_password")
private WebElement passwordEdt;

@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
private WebElement loginBtn;

//rule no:3 Initiallisation

public Loginpage(WebDriver driver) {  
	PageFactory.initElements(driver, this);
}

//rule no:4 Utilisation

public WebElement getUsernameEdt() {   
	return usernameEdt;
}


public WebElement getPasswordEdt() {
	return passwordEdt;
}


public WebElement getLoginBtn() {
	return loginBtn;
}

//Business Library -Generic method -operate on element in current POM Class Only
/*this method will perform login action
 * @param USERNAME
 * @param PASSWORD
 * */
public void loginToApp(String USERNAME,String PASSWORD) {
	usernameEdt.sendKeys(USERNAME);
	passwordEdt.sendKeys(PASSWORD);
	loginBtn.click();
}


}
