 package practise_adv_auto;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scenario1with_DDT {

public static void main(String[] args) throws IOException, InterruptedException {
	
//READ COMMON DATA FROM PROPERTY FILE
FileInputStream	fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");		
Properties P =new Properties();
P.load(fis);	
String URL=P.getProperty("url");
String USERNAME=P.getProperty("username");
String PASSWORD=P.getProperty("password");

//READ TEST DATA FROM EXCEL FILE
FileInputStream	fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
Workbook wb=WorkbookFactory.create(fise);
String LASTNAME=wb.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();//in method overloading datatype will be the last method like getStringCellValue()

//STEP1: LAUNCH THE BASE BROWSER
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//STEP2:LOAD THE APPLICATION
driver.get(URL);

//STEP3: LOGIN TO APPLICATION
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();

//step4:click on contact link
driver.findElement(By.linkText("Contacts")).click();

//step5:click on create contact look up image
driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();

//step6:create new contact
driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

//step7:save
driver.findElement(By.cssSelector("input[class=\"crmButton small save\"]")).click();

//step8:validate
String disply=driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
if(disply.contains(LASTNAME)) {
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
