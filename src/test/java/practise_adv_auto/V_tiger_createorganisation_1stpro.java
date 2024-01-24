package practise_adv_auto;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class V_tiger_createorganisation_1stpro {

	public static void main(String[] args) throws InterruptedException {
		Random r=new Random();
		String customerName="Rakesh"+r.nextInt(100);
		//step1:launch base browser	
	WebDriver driver=new ChromeDriver();
	//step2:load the application
	driver.get("http://localhost:8888");
	//step3:login to application
	driver.findElement(By.name("user_name")).sendKeys("admin");
	driver.findElement(By.name("user_password")).sendKeys("admin");
	driver.findElement(By.id("submitButton")).click();
	//step4:click on Organizations link
	driver.findElement(By.linkText("Organizations")).click();
	//step5:click on create contact look up image
	driver.findElement(By.xpath("//table[@class='small'][2]//img[@alt='Create Organization...']")).click();
	//step6:create new contact
	driver.findElement(By.cssSelector("input[name='accountname']")).sendKeys(customerName);
	//step7:save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//step8:validate
	Thread.sleep(2000);
	String disply_text=driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
	
	if(disply_text.contains(customerName)) {
		System.out.println(disply_text);
		//System.out.println("pass");
	}
	else {
		System.out.println("fail");
	}
	
//	//step9:logout application
	WebElement lout=driver.findElement(By.xpath("//td[@class='small']//img[@src='themes/softed/images/user.PNG']"));
	Actions act=new Actions(driver);
	act.moveToElement(lout).perform();
	Thread.sleep(2000);
	driver.findElement(By.linkText("Sign Out")).click();
	driver.close();
	
	
	
	
	
	}

}
