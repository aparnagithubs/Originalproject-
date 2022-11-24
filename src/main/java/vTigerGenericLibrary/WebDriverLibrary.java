package vTigerGenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLibrary {
	
	/**
	 * It is a class created in generic library package of src/main/java source folder
	 * in the project which contains all generic methods related to WebDriverActions like 
	 * wait statements,handling dropDown, switching window,switching frame etc.,
	 * 
	 *
	 */
	public void maximiseWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		//explicitlywait
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10L));
		wait.until(ExpectedConditions.visibilityOfAllElements(element));
	}
	public void waitForElementToBeClickable(WebDriver driver,WebDriver element)
	{ 
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10L));
		//wait.until(ExpectedConditions.elementToBeClickable(element));
		wait.until(ExpectedConditions.elementToBeClickable((By) element));
	}
	public void waitAndClickOnElement(WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<10)
		{  try
		  {
		    element.click();
		    break;
	      }
		  catch(Exception e)
		    {
			  Thread.sleep(1000);
			  count++;
		    }
  	    }
    }
	/** 
	 * This method selects drop down list
	 * select class is not methodoverloaded.
	 * when we create 2 or more methods with same name with 
	 * multiple or different arguments is called method overloading  
	 * @param element
	 * @param index
	 */
public void handleDropDown(WebElement element, int index)	
{
    Select s=new Select(element);
    s.selectByIndex(index);
}
/**
 * 
 */  
  public void handleDropDown(WebElement element,String value)
 
{
	Select s=new Select(element);
	s.selectByValue(value);
	}
	
public void handleDropDown(String text,WebElement element) 	
{ Select s=new Select(element);
   s.selectByValue(text);
}


/**
 * method to perform mouse hover
 */
 
	
public void mouseHover(WebDriver driver, WebElement element)
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}
/** 
 * perform click on mouuse hover	
 * @param driver
 * @param element
 */
public void righClickOn(WebDriver driver,WebElement element)	
{
	Actions act= new Actions(driver);
	act.contextClick(element).perform();
	}


/*
 * perform doubleclick on webpage
 */
public void doubleClickOn(WebDriver driver)	
{
	 Actions act=new Actions(driver);
	 act.doubleClick().perform();
}
/**
 * perform double click on a particular element
 */
public void doubleClickOn(WebDriver driver, WebElement element)	
{
	Actions act= new Actions(driver);
	act.doubleClick(element).perform();
	}
/**
 * dragand drop src element to destination element	
 */
public void dragAndDropOn(WebDriver driver,WebElement srcelement,WebElement dstelement)	
{ 
	Actions act= new Actions(driver);
	act.dragAndDrop(srcelement, dstelement).perform();
	}
/**
 * This is method will mouse hover using offset value for x and y co-ordinates.
 * @param driver
 * @param xOff
 * @param yOff
 */
public void mouseHoverOn(WebDriver driver, int xOff, int yOff)
{
	Actions act = new Actions(driver);
	act.moveByOffset(xOff, yOff).perform();
}
/**
 * switch to frame based on index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index)
{ 
	driver.switchTo().frame(index);
}
/**This switches to frame based on name or id  
 * 
 */
public void switchToFrame(WebDriver driver,String nameOrId)
{ 
  driver.switchTo().frame(nameOrId);
}
/**
 * method to switch frame based on element   
 *
 */
public void switchToFrame(WebDriver driver,WebElement element )
{ driver.switchTo().frame(element);
	}
/**
 * method to switch from current frame to immediate frame
 */
public void switchToParentFrame(WebDriver driver)
{driver.switchTo().parentFrame();
	}
/**
 * method to switch from current frame to default frame
 */
public void switchToDefaultFrame(WebDriver driver) 
{ driver.switchTo().defaultContent();
	}
/** 
 * method to handle the alert popups
 */
public void acceptAlert(WebDriver driver)
{
	driver.switchTo().alert().accept();
	}
/**
 * to handle alert n dismiss it 
 * @param driver
 */
public void dismissAlert(WebDriver driver)
{
	driver.switchTo().alert().dismiss();
	}
public String getAlertText(WebDriver driver)
{
	String alertText=driver.switchTo().alert().getText();
	return alertText;
}
/**
 * Robot class is used to handle the keyboard actions
 * @throws AWTException 
 */
public void pressEnter() throws AWTException
{	Robot r=new Robot();
    r.keyPress(KeyEvent.VK_ENTER);
    r.keyPress(KeyEvent.VK_ENTER);
}
/**
 * This method will switch from parent window to any child window or from any child window
 * to parent window based on the partial window title.
 * @param driver
 * @param partialWindowTitle
 */

public void switchToWindow(WebDriver driver,String partialWindowTitle)
{//step1: get all the window handles
	Set<String> windowIds= driver.getWindowHandles();
	//step2 iterate through allthe window ids --similar to for each loop
	Iterator <String>it= windowIds.iterator();
	//step 3: navigate to each window and check the title
	while(it.hasNext())
	{
		//step4: capture the individual window id 
		String winID=it.next();
		//step5:
		String currentTitle= driver.switchTo().window(winID).getTitle();
		//Step 6: compare current title with partial title
		if(currentTitle.contains(partialWindowTitle))
		{
			break;
		}
	}
	
}

/** using for each loop
 *  step1 :get all the window handles
 * Set<String> windowIds= driver.getWindowHandles();
 * for(String winId:windowIds)
 *   {
 *     step5: switch to that window and capture the title
 *     string   currentTitle=driver.switchTo().window(winId).getTitle();
 *     
 *     step6: compare current title with partial title
 *     if(currentTitle.contains(partialWindowTitle))
 *        { break;} }}
 */
/**
 * This method will take the screen shot 
 * @param driver
 * @param screenshotName
 * @return
 * @throws IOException
 */
public String takeScreenShot(WebDriver driver, String screenshotName) throws IOException 
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst = new File(".\\ScreenShot\\"+screenshotName+".png");
	FileUtils.copyFile(src, dst); // from commons io
	
	return dst.getAbsolutePath(); //used for extends reports
	
}

/**
 * This method will scroll down for 500 units
 * @param driver
 */
public void scrollAction(WebDriver driver)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,500)", "");
}

/**
 * This method will scroll until the specified element is found
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver, WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	//js.executeScript("arguments[0].scrollIntoView();", element);
	
	int y = element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")", element);
	
	}
public void mouseHoverOn(WebDriver driver, WebElement adminImg) {
	Actions act=new Actions(driver);
	act.moveToElement(adminImg);}
	
	public void closeAllTabs (WebDriver driver)
	{ 
		driver.quit();
	}
}
