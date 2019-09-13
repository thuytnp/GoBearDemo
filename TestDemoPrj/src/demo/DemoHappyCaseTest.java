package demo;

import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;

public class DemoHappyCaseTest {

	private final String BASE_URL = "https://www.gobear.com/ph?x_session_type=UAT";
	private final String CHROME_DRIVER = "webdriver.chrome.driver";
	private final String PROPERTY_FILE_CHROME = "property/chromedriver.exe";

	private WebDriver driver = null;

	private Logger logger = LogManager.getLogger(DemoHappyCaseTest.class.getName());
	private final String LOG_FILE = "log4j.xml";

	private final String SCREENSHOT_PATH = "screenshots/screenshots1.jpg";

	private ATUTestRecorder recorder;

	@BeforeTest
	public void initWebDriver() {
		DOMConfigurator.configure(LOG_FILE);
		logger.info("Start Test.");
		System.setProperty(CHROME_DRIVER, PROPERTY_FILE_CHROME);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(BASE_URL);
		driver.manage().window().maximize();
		try {
			initRecordVideo();
			// Start capturing the Video
			recorder.start();
		} catch (ATUTestRecorderException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGoBearHappyCase() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 300);

			// Go to Insurance tab
			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateInsuranceTab(driver).getBy()))
					.click();
			logger.info("Click on Insurance tab.");
			
			Thread.sleep(2000);
			// Go to travel tab
			DemoPageObject.locateTravelLink(driver).getElement().click();
			logger.info("Click on Travel tab.");

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,50)");
			logger.info("Scroll window.");
			Thread.sleep(2000);
			// Go to the Travel results page
			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateShowResultBtn(driver).getBy()))
					.click();
			logger.info("Click on Show Result button.");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Make sure at least 3 cards are being displayed
			int listCardsSize = driver.findElements(By.cssSelector("div.col-sm-4.card-full")).size();
			logger.info("Count on List Result: " + listCardsSize);
			if (listCardsSize >= 3) {
				System.out.println("There are at least 3 cards being displayed. ==> Test Pass");
			} else {
				System.out.println("There are less 3 cards being displayed.");
			}
			
			// Assert.assertTrue(listCardsSize >= 3);
			Assert.assertTrue("Cards are not in Price: Low to High.", listCardsSize >= 3);
			Thread.sleep(2000);
			// click on the check box
			wait.until(ExpectedConditions.elementToBeClickable(
					By.cssSelector("#collapseFilter > div:nth-child(3) > div > div > div:nth-child(1) > div"))).click();
			boolean isSelectedFPGInsurance = driver.findElement(By.xpath("//*[@id=\"gb_checkbox_963\"]")).isSelected();
			if (isSelectedFPGInsurance) {
				logger.info("FPGInsurance checkbox is checked.");
				System.out.println("FPGInsurance checkbox is checked.");
			} else {
				logger.info("FPGInsurance checkbox is not checked.");
				System.out.println("FPGInsurance checkbox is not checked.");
			}
			Thread.sleep(2000);
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"collapseFilter\"]/div[3]/div/div/div[3]/div"))).click();
			boolean isSelectedPacificCross = driver.findElement(By.xpath("//*[@id=\"gb_checkbox_965\"]")).isSelected();
			if (isSelectedPacificCross) {
				logger.info("Pacific Cross checkbox is checked.");
				System.out.println("Pacific Cross checkbox is checked.");
			} else {
				logger.info("Pacific Cross checkbox is not checked.");
				System.out.println("Pacific Cross checkbox is not checked.");
			}

			//js.executeScript("window.scrollBy(0,300)");

			// click on the radio button in Sort
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#collapseTwo > div > div:nth-child(3)")))
					.click();
			boolean isSelectedRadioInSort = driver.findElement(By.xpath("//*[@id=\"gb_radio_4\"]")).isSelected();
			if (isSelectedRadioInSort) {
				logger.info("A radio button in Sort is checked.");
				System.out.println("A radio button in Sort is checked.");
			} else {
				logger.info("A radio button in Sort is not checked.");
				System.out.println("A radio button in Sort is not checked.");
			}
			Thread.sleep(3000);
			
			
			// Click on SEE MORE link
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("SEE MORE"))).click();
			logger.info("Click on SEE MORE link.");

			//js.executeScript("window.scrollBy(0,800)");

			// click on the drop down in detail
			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id=\"detailCollapse\"]/div/div[3]/div/div/div"))).click();
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//*[@id=\"detailCollapse\"]/div/div[3]/div/div/div/div/ul/li[4]/a"))).click();
			logger.info("Change value of dropdown.");

			WebElement destination = driver
					.findElement(By.xpath("//*[@id=\"detailCollapse\"]/div/div[3]/div/div/div/select"));
			Select destinationDropdown = new Select(destination);
			// destinationDropdown.selectByIndex(2);
			// destinationDropdown.selectByVisibleText("Japan"); todo

			// waiting loading page again
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// select start date
//			driver.findElement(By.xpath("//*[@id=\"detailCollapse\"]/div/div[4]/div[1]/div/div")).click();
//			logger.info("Change value of start date.");
//			js.executeScript("window.scrollBy(0,1800)");
//			Thread.sleep(200);
//			driver.findElement(By.cssSelector(
//					"body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-bottom > div.datepicker-days > table > tbody > tr:nth-child(4) > td:nth-child(3)"))
//					.click();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			// js.executeScript("window.scrollBy(0,1000)");
//			Thread.sleep(200);
//			// select end date
//			driver.findElement(By.xpath("//*[@id=\"detailCollapse\"]/div/div[4]/div[2]/div/div")).click();
//			js.executeScript("window.scrollBy(0,1800)");
//			driver.findElement(By.cssSelector(
//					"body > div.datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top > div.datepicker-days > table > tbody > tr:nth-child(5) > td:nth-child(5)"))
//					.click();
			
			// Expand Travel Start Date calendar picker
			WebElement startDatePicker = driver.findElement(By.className("date-from"));
			startDatePicker.click();
			Thread.sleep(1000);
			
			// Change date by the selecting order in calendar: Year > Month > Day
			WebElement daysPickerSwitch = driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch"));
			daysPickerSwitch.click(); // Navigate to months picker
			Thread.sleep(1000);
			
			WebElement monthsPickerSwitch = driver.findElement(By.cssSelector(".datepicker-months .datepicker-switch"));
			monthsPickerSwitch.click(); // Navigate to years picker
			Thread.sleep(1000);
			
			// Select Year with value '2020'
			WebElement yearElement = driver.findElement(By.xpath("//div[@class='datepicker-years']//span[text()='2019']"));
			yearElement.click();
			Thread.sleep(1000);

			// Select Month with value 'Aug'
			WebElement monthElement = driver.findElement(By.xpath("//div[@class='datepicker-months']//span[text()='Sep']"));
			monthElement.click();
			Thread.sleep(1000);

			// Select Day with value '10'
			WebElement dayElement = driver.findElement(By.xpath("//div[@class='datepicker-days']//td[text()='17']"));
			dayElement.click();
			Thread.sleep(1000);
			
			// Select slider range
			// Change minHandle of "Personal Accident" slider
			WebElement minSliderHandle = driver
					.findElement(By.xpath("//div[@data-type='Number'][1]//div[contains(@class,'min-slider-handle')]"));
			Actions action = new Actions(driver);
			action.dragAndDropBy(minSliderHandle, 20, 0).build().perform();
			Thread.sleep(3000);
			
			// Change maxHandle of "Personal Accident" slider
			WebElement maxSliderHandle = driver
					.findElement(By.xpath("//div[@data-type='Number'][1]//div[contains(@class,'max-slider-handle')]"));
			action = new Actions(driver);
			action.dragAndDropBy(maxSliderHandle, -20, 0).build().perform();
			Thread.sleep(3000);	
			
			// loop
			List<WebElement> listResult = driver.findElements(By.cssSelector("div.col-sm-4.card-full"));
			System.out.println("Size: " + listResult.size());
			List<Double> listPrice = new ArrayList<>();
			for (WebElement e : listResult) {
				Double price = Double.valueOf(e.findElement(By.cssSelector(".policy-price")).getAttribute("premium"));
				listPrice.add(price);
			}
			for (Double p : listPrice) {
				System.out.println("\nP: " + p);
			}

			logger.info("Capture screen shot.");
			captureScreenShot();

		} catch (Exception e) {
			logger.error("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void captureScreenShot() {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(SCREENSHOT_PATH));
		} catch (IOException e) {
			logger.error("Take screen shot fail.");
			e.printStackTrace();
		}
	}

	private void initRecordVideo() throws ATUTestRecorderException {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder("D:\\recordVideo\\", "TestVideo-" + dateFormat.format(date), false);
	}

	@AfterTest
	public void afterTest() {
		try {
			recorder.stop();
		} catch (ATUTestRecorderException e) {
			e.printStackTrace();
		}
		logger.info("End Test.");
		System.out.println("Test case is done.");
	}

}
