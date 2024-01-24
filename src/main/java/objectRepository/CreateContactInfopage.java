package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInfopage {
	//declaration
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderText;
	
	//intialisation
		
	public CreateContactInfopage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	//utilization

	public WebElement getContactHeaderText() {
		return ContactHeaderText;
	}

	//Business library 
	/*
	 * this method will capture the header text and return it to caller
	 * @return
	 * */
	public String captureHeadertext() {
		 return ContactHeaderText.getText();
	}
	
}
