package demo;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoTest {

	/*private static final String BASE_URL = "https://www.gobear.com/ph?x_session_type=UAT";	
	private static final String CHROME_DRIVER = "webdriver.chrome.driver";
	private static final String PROPERTY_FILE_CHROME = "property/chromedriver.exe";

	private static WebDriver driver = null;
	
	private static WebDriver initWebDriver() {
		
		System.setProperty(CHROME_DRIVER, PROPERTY_FILE_CHROME);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BASE_URL);		
		driver.manage().window().maximize();		
		return driver;
	}

	public static void main(String[] args) throws InterruptedException {
		
		initWebDriver();
		WebDriverWait wait = new WebDriverWait(driver, 300);
		
		// Go to Insurance tab
		wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateInsuranceTab(driver).getBy())).click();

		// Go to travel tab
		DemoPageObject.locateTravelLink(driver).getElement().click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,50)");
		
		// Go to the Travel results page 
		wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateShowResultBtn(driver).getBy())).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Hide tip alert
		js.executeScript("jQuery('#step-1').css('display','none')");
//		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#step-1 > div.popover-navigation > button:nth-child(1)"))).click();
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"step-1\"]/button"))).click();
		
		// Make sure at least 3 cards are being displayed
		int listCardsSize = driver.findElements(By.cssSelector("div.col-sm-4.card-full")).size();
		if(listCardsSize >= 3) {
			System.out.println("There are at least 3 cards being displayed. ==> Test Pass");
		} else {
			System.out.println("There are less 3 cards being displayed.");
		}
		Assert.assertTrue(listCardsSize >= 3);
		
		// click on the check box	
		
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#collapseFilter > div:nth-child(3) > div > div > div:nth-child(1) > div"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapseFilter\"]/div[3]/div/div/div[1]/div"))).click();
		boolean isSelectedFPGInsurance = driver.findElement(By.xpath("//*[@id=\"gb_checkbox_963\"]")).isSelected();
		if(isSelectedFPGInsurance) {
			System.out.println("FPGInsurance checkbox is checked.");
		} else {
			System.out.println("FPGInsurance checkbox is not checked.");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapseFilter\"]/div[3]/div/div/div[3]/div"))).click();
				
		
		js.executeScript("window.scrollBy(0,300)");
		
		// click on the radio button in Sort	
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#collapseTwo > div > div:nth-child(3)"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"collapseTwo\"]/div/div[3]"))).click();
		boolean isSelectedRadioInSort = driver.findElement(By.xpath("//*[@id=\"gb_radio_4\"]")).isSelected();
		if(isSelectedRadioInSort) {
			System.out.println("A radio button in Sort is checked.");
		} else {
			System.out.println("A radio button in Sort is not checked.");
		}
		
		// Click on SEE MORE link
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("SEE MORE"))).click();	
		
		js.executeScript("window.scrollBy(0,800)");
		// click on the drop down in detail	
		WebElement destination = driver.findElement(By.xpath("//*[@id=\"detailCollapse\"]/div/div[3]/div/div/div/select"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"detailCollapse\"]/div/div[3]/div/div/div"))).click();		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"detailCollapse\"]/div/div[3]/div/div/div/div/ul/li[4]/a"))).click();
		Select destinationDropdown = new Select(destination);
		//destinationDropdown.selectByIndex(2);
		//destinationDropdown.selectByVisibleText("Japan");	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// select start date
		driver.findElement(By.xpath("//*[@id=\"detailCollapse\"]/div/div[4]/div[1]/div/div")).click();
		//js.executeScript("window.scrollBy(0,1800)");
		Thread.sleep(200);
		driver.findElement(By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom > div.datepicker-days > table > tbody > tr:nth-child(4) > td:nth-child(3)")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(200);
		// select end date
		driver.findElement(By.xpath("//*[@id=\"detailCollapse\"]/div/div[4]/div[2]/div/div")).click();
		js.executeScript("window.scrollBy(0,1800)");
		driver.findElement(By.cssSelector("body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top > div.datepicker-days > table > tbody > tr:nth-child(5) > td:nth-child(5)")).click();
		
		System.out.println("Finish Testing.");
	}*/
}
