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
import java.util.Iterator;
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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;

public class DemoHappyCaseTest {

	private final String RECORD_VIDEO_FILE_PATH = "D:\\recordVideo\\";
	private final String SCREENSHOT_PATH = "screenshots/";
	private final String BASE_URL = "https://www.gobear.com/ph?x_session_type=UAT";
	private final String CHROME_DRIVER = "webdriver.chrome.driver";
	private final String PROPERTY_FILE_CHROME = "property/chromedriver.exe";	
	private Logger logger = LogManager.getLogger(DemoHappyCaseTest.class.getName());
	private final String LOG_FILE_NAME = "log4j.xml";
	private WebDriver driver = null;
	private ATUTestRecorder recorder;

	@BeforeTest
	public void prepareTest() {
		DOMConfigurator.configure(LOG_FILE_NAME);
		logger.info("Start Test.");
		System.out.println("Test case is started.");
		System.setProperty(CHROME_DRIVER, PROPERTY_FILE_CHROME);
		driver = new ChromeDriver();
		driver.get(BASE_URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
			JavascriptExecutor js = (JavascriptExecutor) driver;

			// Go to Insurance tab
			DemoPageObject.locateInsuranceTab(driver).getElement().click();
			logger.info("Click on Insurance tab.");
			Thread.sleep(2000);

			// Go to travel tab
			DemoPageObject.locateTravelLink(driver).getElement().click();
			logger.info("Click on Travel tab.");
			Thread.sleep(2000);

			// Select travel plan drop down
			DemoPageObject.locateTravelPlanDropDown(driver).getElement().click();
			Thread.sleep(2000);
			DemoPageObject.locateTravelPlanItem(driver).getElement().click();
			logger.info("Change value of travel plan dropdown.");
			Thread.sleep(2000);

			// Select destination drop down
			DemoPageObject.locateDestinationDropDown(driver).getElement().click();
			Thread.sleep(2000);
			DemoPageObject.locateDestinationItem(driver).getElement().click();
			logger.info("Change value of destination dropdown.");
			Thread.sleep(2000);

			// Select calendar date from
			pickCalendarStartDate("2019", "Sep", "19");

			// Select calendar date to
			pickCalendarEndDate("2019", "Sep", "29");
			logger.info("Select date from and date to.");

			js.executeScript("window.scrollBy(0,-200)");
			Thread.sleep(2000);

			captureScreenShot("travelPage");
			logger.info("Capture screen shot of travel page.");

			// Go to the Travel results page
			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateShowResultBtn(driver).getBy())).click();
			logger.info("Click on Show Result button.");

			// waiting for loading result page
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Make sure at least 3 cards are being displayed
			List<WebElement> listCardsSortedByPromotion = DemoPageObject.locateListCards(driver);
			logger.info("List Card is sorted by promotion: " + listCardsSortedByPromotion.size());
			Assert.assertTrue("There are at least 3 cards sorted by promotion: ", listCardsSortedByPromotion.size() >= 3);
			Thread.sleep(2000);

			// click on the check box in filter
			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateInsuranceCheckBoxDiv(driver).getBy())).click();
			boolean isSelectedFPGInsurance = DemoPageObject.locateInsuranceCheckBox(driver).getElement().isSelected();
			if (isSelectedFPGInsurance) {
				logger.info("FPGInsurance checkbox is checked.");
			} else {
				logger.info("FPGInsurance checkbox is not checked.");
			}
			Thread.sleep(2000);

			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locatePacificCrossCheckBoxDiv(driver).getBy())).click();
			boolean isSelectedPacificCross = DemoPageObject.locatePacificCrossCheckBox(driver).getElement().isSelected();
			if (isSelectedPacificCross) {
				logger.info("Pacific Cross checkbox is checked.");
			} else {
				logger.info("Pacific Cross checkbox is not checked.");
			}
			Thread.sleep(2000);

			captureScreenShot("checkboxInFilter");
			logger.info("Capture screen shot after selecting checkbox in filter.");

			List<WebElement> listCardsAfterFiltering = DemoPageObject.locateListCards(driver);
			logger.info("List Cards are filtered by Pacific Cross: " + listCardsAfterFiltering.size());
			Thread.sleep(2000);

			js.executeScript("window.scrollBy(0,-500)");

			// click on the radio button in Sort
			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locatePriceHighToLowRadioDiv(driver).getBy())).click();
			boolean isSelectedRadioInSort = DemoPageObject.locatePriceHighToLowRadio(driver).getElement().isSelected();
			if (isSelectedRadioInSort) {
				logger.info("Price: High to low radio button in Sort is checked.");
			} else {
				logger.info("Price: High to low radio button in Sort is not checked.");
			}
			Thread.sleep(2000);

			captureScreenShot("radioBtnInSort");
			logger.info("Capture screen shot after checking radio in sort.");

			List<WebElement> listCardsSortedByPriceHighToLow = DemoPageObject.locateListCards(driver);
			logger.info("List Cards are sorted by price from high to low: " + listCardsSortedByPriceHighToLow.size());
			Thread.sleep(2000);

			// Compare list cards after filtered and sorted
			Assert.assertNotEquals("Compare list cards after filtered and sorted: ", listCardsAfterFiltering,
					listCardsSortedByPriceHighToLow);

			// Verify to make sure list cards sorted by price from high to low
			boolean isPriceHighToLow = verifyListCardByPriceHighToLow(listCardsSortedByPriceHighToLow);
			Assert.assertTrue("Verify list cards sorted by price from high to low.", isPriceHighToLow);

			// Compare list cards after sorting by promotion and price from high to low
			Assert.assertNotEquals("Compare list cards after sorting by price from high to low: ",
					listCardsSortedByPromotion, listCardsSortedByPriceHighToLow);

			// Click on SEE MORE link
			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateSeeMoreLink(driver).getBy())).click();
			logger.info("Click on SEE MORE link.");
			Thread.sleep(2000);

			// click on the drop down in detail
			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateDestinationResultPageDropDown(driver).getBy())).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.elementToBeClickable(DemoPageObject.locateDestinationResultPageItem(driver).getBy())).click();
			logger.info("Change value of destination dropdown.");
			Thread.sleep(2000);

			captureScreenShot("radioBtnInSort");
			logger.info("Capture screen shot after selecting dropdown in detail.");

			// waiting loading page again
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Change value of start date and end date
			// Select calendar start date
			pickCalendarStartDate("2019", "Sep", "23");

			// Select calendar end date
			pickCalendarEndDate("2019", "Sep", "29");
			logger.info("Change value of start date and end date.");

			// slider range
			changeSliderRange();
			logger.info("Change value of slider range.");

			// waiting for loading page again
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			List<WebElement> listCardsFinal = DemoPageObject.locateListCards(driver);
			logger.info("List Cards after all changes: " + listCardsFinal.size());

			captureScreenShot("resultPage");
			logger.info("Capture screen shot of result page.");

		} catch (Exception e) {
			logger.error("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private void changeSliderRange() throws InterruptedException {
		// Change minimum of Personal Accident slider
		WebElement rangeMin = DemoPageObject.locatePersonalAccidentSliderMin(driver).getElement();
		Actions action = new Actions(driver);
		action.dragAndDropBy(rangeMin, 35, 0).build().perform();
		Thread.sleep(2000);

		// Change maximum of Personal Accident slider
		WebElement rangeMax = DemoPageObject.locatePersonalAccidentSliderMax(driver).getElement();
		action = new Actions(driver);
		action.dragAndDropBy(rangeMax, -40, 0).build().perform();
		Thread.sleep(2000);
	}

	private void pickCalendarStartDate(String year, String month, String day) throws InterruptedException {
		// select start date
		DemoPageObject.locateDateFrom(driver).getElement().click();
		Thread.sleep(1000);

		// Pick day
		DemoPageObject.locateDaysPicker(driver).getElement().click();
		Thread.sleep(1000);

		// Pick month
		DemoPageObject.locateMonthsPicker(driver).getElement().click();
		Thread.sleep(1000);

		// Pick year
		DemoPageObject.locateYearsPickerDetail(driver, year).getElement().click();
		Thread.sleep(1000);

		DemoPageObject.locateMonthPickerDetail(driver, month).getElement().click();
		Thread.sleep(1000);

		DemoPageObject.locateDayPickerDetail(driver, day).getElement().click();
		Thread.sleep(2000);
	}

	private void pickCalendarEndDate(String year, String month, String day) throws InterruptedException {
		// select end date
		DemoPageObject.locateDateTo(driver).getElement().click();
		Thread.sleep(1000);

		// Pick day
		DemoPageObject.locateDaysPicker(driver).getElement().click();
		Thread.sleep(1000);

		// Pick month
		DemoPageObject.locateMonthsPicker(driver).getElement().click();
		Thread.sleep(1000);

		// Pick year
		DemoPageObject.locateYearsPickerDetail(driver, year).getElement().click();
		Thread.sleep(1000);

		DemoPageObject.locateMonthPickerDetail(driver, month).getElement().click();
		Thread.sleep(1000);

		DemoPageObject.locateDayPickerDetail(driver, day).getElement().click();
		Thread.sleep(2000);
	}

	private boolean verifyListCardByPriceHighToLow(List<WebElement> listCardsSortedByPriceHighToLow) {
		List<Double> listPrice = new ArrayList<>();
		for (WebElement e : listCardsSortedByPriceHighToLow) {
			Double price = Double.valueOf(e.findElement(By.cssSelector(".policy-price")).getAttribute("premium"));
			listPrice.add(price);
		}
		if (listPrice.size() == 1) {
			return true;
		}
		Iterator<Double> iter = listPrice.iterator();
		Double current, previous = iter.next();
		while (iter.hasNext()) {
			current = iter.next();
			if (previous.compareTo(current) < 0) {
				return false;
			}
			previous = current;
		}
		return true;
	}

	private void captureScreenShot(String screenshotFileName) {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = SCREENSHOT_PATH + screenshotFileName + ".jpg";
		try {
			FileUtils.copyFile(screenshot, new File(filePath));
		} catch (IOException e) {
			logger.error("Take screen shot fail.");
			e.printStackTrace();
		}
	}

	private void initRecordVideo() throws ATUTestRecorderException {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(RECORD_VIDEO_FILE_PATH, "TestVideo-" + dateFormat.format(date), false);
	}

	@AfterTest
	public void finishTest() {
		try {
			recorder.stop();
		} catch (ATUTestRecorderException e) {
			e.printStackTrace();
		}
		logger.info("End Test.");
		System.out.println("Test case is done.");
		driver.close();
	}

}
