package genericUTilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUTility {
	/*
	 * this method will maximise the window
	 * @param driver
	 * */	
public void MaximizeWindow(WebDriver driver) {
	driver.manage().window().maximize();
	}
/*
 * this method will minimise the window
 *@param driver 
 * 
 * */
public void MinimizeWindow(WebDriver driver) {
	driver.manage().window().minimize();
	}
/*
 * this method will launch the browser in full screen mode 
 * @param driver 
 * 
 * */
public void fullScreenWindow(WebDriver driver) {
	driver.manage().window().fullscreen();
	}
/*
 * this method will wait for 10 secnds for all web elements to load
 * @param driver 
 * 
 * */
public void addImplicitlyWait(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
/*
 * 
 */
public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.visibilityOf(element));

	
}

public void waitForElementToBeclickable(WebDriver driver, WebElement element) {
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.elementToBeClickable(element));

	
}
public void waitForElementToBeTitlecontains(WebDriver driver) {
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
wait.until(ExpectedConditions.titleIs(""));

	
}
/*this method will handle dropdown by index
 *@param element
 * @param index
 */
public void handleDropdown(WebElement element,int index)
{
Select sel=new Select(element);

sel.selectByIndex(index);
}
/*this method will handle dropdown by value
 *@param element
 * @param value
 */
public void handleDropdown(WebElement element,String value)
{
Select sel=new Select(element);

sel.selectByValue(value);
}
/*this method will handle dropdown by visibletext
 *@param element
 * @param text
 */
public void handleDropdown(String text,WebElement element)
{
Select sel=new Select(element);

sel.selectByVisibleText(text);
}
/*this method will perform mouseover Action on web element
 *@param driver
 * @param element
 */

public void mouseoverAction(WebDriver driver,WebElement element)
{
Actions act=new Actions(driver)	;
act.moveToElement(element).perform();
}
/*this method will perform rightclick Action on web element
 *@param driver
 * @param element
 */

public void rightclick(WebDriver driver,WebElement element)
{
Actions act=new Actions(driver)	;
act.contextClick().perform();
}

/*this method will perform Doubleclick Action on web element
 *@param driver
 * @param element
 */

public void doubleclick(WebDriver driver,WebElement element)
{
Actions act=new Actions(driver)	;
act.doubleClick().perform();
}

/*this method will perform drag and drop Action on web element
 *@param driver
 * @param srelement
 * * @param targtelement
 */
public void draganddrop(WebDriver driver,WebElement srelement,WebElement targtelement)
{
Actions act=new Actions(driver)	;
act.dragAndDrop(srelement, targtelement).perform();
}
/*this method will scrolldown for 500units
 *@param driver
 * 
 */
public void scrollDownAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
   js.executeScript("window.scrollBy(0,500)", "");//java script snippet
}
/*this method will scrollUP for 500units
 *@param driver
 * 
 */
public void scrollUpAction(WebDriver driver)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
   js.executeScript("window.scrollBy(0,-500)", "");//java script snippet
}

public void scrolltoWebelement(WebDriver driver,WebElement element)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
   js.executeScript("arguments[0].scrollIntoView(false);",element);
//java script snippet
}
/*this method will accept alert POP_UP
 *@param driver
 * 
 */
public void acceptAlert(WebDriver driver) {
driver.switchTo().alert().accept();
	
}
/*this method will cancel alert POP_UP
 *@param driver
 * 
 */
public void cancelptAlert(WebDriver driver) {
driver.switchTo().alert().dismiss();		
	
}
/*this method will capture text in alert POP_UP and return it to the caller
 *@param driver
 * @return
 */
public String getAlert(WebDriver driver) {
	return driver.switchTo().alert().getText();

}
/*this method will handle frame by frame index
 *@param driver
 * @param frameIndex
 */

public void handleframe(WebDriver driver, int frameIndex) {
	driver.switchTo().frame(frameIndex);
}
/*this method will handle frame by frame name or ID
 *@param driver
 * @param framenameID
 */
public void handleframe(WebDriver driver, String frameNameID ) {
	driver.switchTo().frame(frameNameID);
}

/*this method will handle frame by frame Element
 *@param driver
 * @param frameElement
 */
public void handleframe(WebDriver driver, WebElement  frameElement ) {
	driver.switchTo().frame(frameElement);
}
/*this method will capture the screenshot and return the path to caller
 *@param driver
 * @param screenshotname
 * @return
 * @throws IOException
 */

public String captureScreenShot(WebDriver driver, String screenshotname ) throws IOException {
	
TakesScreenshot ts=(TakesScreenshot)driver;
File src = ts.getScreenshotAs(OutputType.FILE);//temporary location
File dst = new File(".\\Screenshots\\"+screenshotname+".png");//filename of screenshot will change each time
Files.copy(src, dst);//to copy to folder Screenshots
return dst.getAbsolutePath();//attaching this screenshot to extent report and complete path will show by using getAbsolutePath()
}

/*this method will switch the control to required widow based on title
 *@param driver
 * @param expartialtitle
 */
public void handlewindows(WebDriver driver, String expartialTitle) {
//capture all window id
Set<String> allwindowId = driver.getWindowHandles();
//navigate through each window id
for(String winId:allwindowId) {
//switch to each window ID and capure Title
String actTtle = driver.switchTo().window(winId).getTitle();
//compare the window Title
if(actTtle.contains(expartialTitle)) {
break;
}
}
}
}

