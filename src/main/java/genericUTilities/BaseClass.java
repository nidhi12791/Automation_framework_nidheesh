package genericUTilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.Homepage;
import objectRepository.Loginpage;
/*
 * this class consist of all basic configuration annotation of TestNG
 * @author nidheesh
 *
 *
 */
 public class BaseClass {
PropertyFileUtility pUtil=new PropertyFileUtility();
ExcelFileUTility eUtil=new ExcelFileUTility();
SeleniumUTility sUtil=new SeleniumUTility();
JavaUTility jUtil=new JavaUTility();
public WebDriver driver;
public static WebDriver sdriver;//for listeners
//@BeforeSuite
@BeforeSuite(groups={"smokesuite","regressionsuite"})	//Commentd for parallel excution&cbt------>
	public void beforesuite() {

	System.out.println("......DB Connection succesful....");	
		
	}
	/*// @BeforeTest mainly uses for parallel execution----------->
	 * 
	 * */
//@Parameters("Browser")
//@BeforeTest
	public void beforeTest() {

	System.out.println("To establish the connection to Database");	
	}

	//"launch the browser"
	//@BeforeClass
	@BeforeClass(alwaysRun=true)//comented thisline for parallel execution
	public void beforeClass(/*String BROWSER*/) throws IOException {

	String URL=pUtil.readDataFromPropertyFile("url");
	 driver = new ChromeDriver();//commented for cbt------->
	  
	//if(BROWSER.equalsIgnoreCase("Chrome")) {//line58 to 65 for cbt only
		
		//driver=new ChromeDriver();
	//}
	
	//else if (BROWSER.equalsIgnoreCase("Edge")) {
		//driver=new EdgeDriver();
	//}
	sdriver=driver;//for listeners
	sUtil.MaximizeWindow(driver);
	  sUtil.addImplicitlyWait(driver);
	  driver.get(URL);
	  System.out.println("launch the browser");
	}
	// "login"-------------->
	//@BeforeMethod
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws IOException {
    String USERNAME=pUtil.readDataFromPropertyFile("username");
    String PASSWORD=pUtil.readDataFromPropertyFile("password");
	Loginpage Ip=new Loginpage(driver);
	Ip.loginToApp(USERNAME, PASSWORD);;
	
	System.out.println("logined successfully");
	}
	//@AfterMethod
	@AfterMethod(alwaysRun=true)
	//logout------------->
	public void afterMethod() throws InterruptedException {
	Homepage Hp=new Homepage(driver);
	Hp.logoutofApp(driver);
	System.out.println("logout successfully......");	
	}
	//@AfterClass
	@AfterClass(alwaysRun=true)
	public void afterClass() {

	System.out.println("close browser.....");	
	}
	//To disconnect the connection from Database or browser close
	//@AfterTest
	public void afterTest() {
    driver.quit();
	System.out.println(" browser closed....");	
	}	
	//@AfterSuite//for batch execution
	@AfterSuite(alwaysRun=true)
	public void aftersuite() {

	System.out.println("DB Connection closed----");	
	}	
}
