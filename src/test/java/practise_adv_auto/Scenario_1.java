package practise_adv_auto;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario_1 {

public static void main(String[] args) throws InterruptedException {

//step1:launch base browser	
	
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//step2:load the application
driver.get("http://localhost:8888");

//step3:login to application
driver.findElement(By.name("user_name")).sendKeys("admin");
driver.findElement(By.name("user_password")).sendKeys("admin");
driver.findElement(By.id("submitButton")).click();

//step4:click on contact link
driver.findElement(By.linkText("Contacts")).click();

//step5:click on create contact look up image
driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//step6:create new contact
driver.findElement(By.name("lastname")).sendKeys("mattummal4");

//step7:save
driver.findElement(By.cssSelector("input[class='crmButton small save']")).click();

//step8:validate
String disply=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
if(disply.contains("mattummal4")) {
	System.out.println(disply+" "+" "+ "test case passed");
}
else {
	System.out.println("test caseis failed");
}
//step9:logout application
WebElement lout=driver.findElement(By.xpath("//td[@class='small']//img[@src='themes/softed/images/user.PNG']"));
Actions act=new Actions(driver);
act.moveToElement(lout).perform();
Thread.sleep(2000);
driver.findElement(By.linkText("Sign Out")).click();
driver.close();

}

}
