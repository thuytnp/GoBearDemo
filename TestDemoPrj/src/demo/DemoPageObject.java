package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoPageObject {

	private static PairElement pairEmlement = null;

	// Html element Info
	private static String insuranceTabXPath = "//a[contains(@href,'#Insurance')]";
	private static String travelLinkText = "TRAVEL";
	private static String showResultBtnCss = "#travel-form > div.form-footer.clearfix > div > button.btn.btn-primary.btn-block.text-uppercase.btn-form-submit";
	private static String travelPlanDropDownXPath = "//*[@id=\"travel-form\"]/div[1]/div[1]/div[2]";
	private static String travelPlanItemXPath = "//*[@id=\"travel-form\"]/div[1]/div[1]/div[2]/div/div/div/ul/li[3]/a";
	private static String destinationDropDownXPath = "//*[@id=\"travel-form\"]/div[1]/div[2]/div/div[1]";
	private static String destinationItemXPath = "//*[@id=\"travel-form\"]/div[1]/div[2]/div/div[1]/div/div/div/ul/li[1]/a";
	private static String listCardCss = "div.col-sm-4.card-full";
	private static String insuranceCheckboxDivCss = "#collapseFilter > div:nth-child(3) > div > div > div:nth-child(1) > div";
	private static String insuranceCheckboxXPath = "//*[@id=\"gb_checkbox_963\"]";
	private static String pacificCrossCheckboxDivXPath = "//*[@id=\"collapseFilter\"]/div[3]/div/div/div[3]/div";
	private static String pacificCrossCheckboxXPath = "//*[@id=\"gb_checkbox_965\"]";
	private static String priceHighToLowRadioDivCss = "#collapseTwo > div > div:nth-child(3)";
	private static String priceHighToLowRadioXPath = "//*[@id=\"gb_radio_4\"]";
	private static String seeMoreLinkText = "SEE MORE";
	private static String destinationResultPageDropDownXPath = "//*[@id=\"detailCollapse\"]/div/div[3]/div/div/div";
	private static String destinationResultPageItemXPath = "//*[@id=\"detailCollapse\"]/div/div[3]/div/div/div/div/ul/li[4]/a";
	private static String personalAccidentSliderMinXPath = "//div[@data-type='Number'][1]//div[contains(@class,'min-slider-handle')]";
	private static String personalAccidentSliderMaxXPath = "//div[@data-type='Number'][1]//div[contains(@class,'max-slider-handle')]";
	private static String dateFromClassName = "date-from";
	private static String dateToClassName = "date-from";
	private static String daysPickerCss = ".datepicker-days .datepicker-switch";
	private static String monthsPickerCss = ".datepicker-months .datepicker-switch";
	
	// Insurance tab
	public static PairElement locateInsuranceTab(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(insuranceTabXPath), driver.findElement(By.xpath(insuranceTabXPath)));
		return pairEmlement;
	}

	// Travel link
	public static PairElement locateTravelLink(WebDriver driver) {
		pairEmlement = new PairElement(By.linkText(travelLinkText), driver.findElement(By.linkText(travelLinkText)));
		return pairEmlement;
	}

	// Show result button
	public static PairElement locateShowResultBtn(WebDriver driver) {
		pairEmlement = new PairElement(By.cssSelector(showResultBtnCss), driver.findElement(By.cssSelector(showResultBtnCss)));
		return pairEmlement;
	}
	
	//Select travel plan drop down
	public static PairElement locateTravelPlanDropDown(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(travelPlanDropDownXPath), driver.findElement(By.xpath(travelPlanDropDownXPath)));
		return pairEmlement;
	}
	
	//Select travel plan item
	public static PairElement locateTravelPlanItem(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(travelPlanItemXPath), driver.findElement(By.xpath(travelPlanItemXPath)));
		return pairEmlement;
	}
	
	//Select travel plan drop down
	public static PairElement locateDestinationDropDown(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(destinationDropDownXPath), driver.findElement(By.xpath(destinationDropDownXPath)));
		return pairEmlement;
	}
	
	//Select travel plan item
	public static PairElement locateDestinationItem(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(destinationItemXPath), driver.findElement(By.xpath(destinationItemXPath)));
		return pairEmlement;
	}
	
	//Get List Cards
	public static List<WebElement> locateListCards(WebDriver driver) {
		List<WebElement> listCards = driver.findElements(By.cssSelector(listCardCss));
		return listCards;
	}
	
	// Insurance check box div
	public static PairElement locateInsuranceCheckBoxDiv(WebDriver driver) {
		pairEmlement = new PairElement(By.cssSelector(insuranceCheckboxDivCss), driver.findElement(By.cssSelector(insuranceCheckboxDivCss)));
		return pairEmlement;
	}
	
	// Insurance check box
	public static PairElement locateInsuranceCheckBox(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(insuranceCheckboxXPath), driver.findElement(By.xpath(insuranceCheckboxXPath)));
		return pairEmlement;
	}
	
	// Pacific Cross check box div
	public static PairElement locatePacificCrossCheckBoxDiv(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(pacificCrossCheckboxDivXPath), driver.findElement(By.xpath(pacificCrossCheckboxDivXPath)));
		return pairEmlement;
	}
	
	// Pacific Cross check box
	public static PairElement locatePacificCrossCheckBox(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(pacificCrossCheckboxXPath), driver.findElement(By.xpath(pacificCrossCheckboxXPath)));
		return pairEmlement;
	}
	
	// Price high to low radio div
	public static PairElement locatePriceHighToLowRadioDiv(WebDriver driver) {
		pairEmlement = new PairElement(By.cssSelector(priceHighToLowRadioDivCss), driver.findElement(By.cssSelector(priceHighToLowRadioDivCss)));
		return pairEmlement;
	}
	
	// Price high to low radio
	public static PairElement locatePriceHighToLowRadio(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(priceHighToLowRadioXPath), driver.findElement(By.xpath(priceHighToLowRadioXPath)));
		return pairEmlement;
	}
	
	// See more link
	public static PairElement locateSeeMoreLink(WebDriver driver) {
		pairEmlement = new PairElement(By.linkText(seeMoreLinkText), driver.findElement(By.linkText(seeMoreLinkText)));
		return pairEmlement;
	}
	
	// Destination Result Page drop down
	public static PairElement locateDestinationResultPageDropDown(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(destinationResultPageDropDownXPath), driver.findElement(By.xpath(destinationResultPageDropDownXPath)));
		return pairEmlement;
	}
	
	// Destination Result Page item
	public static PairElement locateDestinationResultPageItem(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(destinationResultPageItemXPath), driver.findElement(By.xpath(destinationResultPageItemXPath)));
		return pairEmlement;
	}
	
	// Personal Accident slider minimum
	public static PairElement locatePersonalAccidentSliderMin(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(personalAccidentSliderMinXPath), driver.findElement(By.xpath(personalAccidentSliderMinXPath)));
		return pairEmlement;
	}
	
	// Personal Accident slider maximum
	public static PairElement locatePersonalAccidentSliderMax(WebDriver driver) {
		pairEmlement = new PairElement(By.xpath(personalAccidentSliderMaxXPath), driver.findElement(By.xpath(personalAccidentSliderMaxXPath)));
		return pairEmlement;
	}
	
	// Date from
	public static PairElement locateDateFrom(WebDriver driver) {
		pairEmlement = new PairElement(By.className(dateFromClassName), driver.findElement(By.className(dateFromClassName)));
		return pairEmlement;
	}
	
	// Date to
	public static PairElement locateDateTo(WebDriver driver) {
		pairEmlement = new PairElement(By.className(dateToClassName), driver.findElement(By.className(dateToClassName)));
		return pairEmlement;
	}
	
	// Days Picker
	public static PairElement locateDaysPicker(WebDriver driver) {
		pairEmlement = new PairElement(By.cssSelector(daysPickerCss), driver.findElement(By.cssSelector(daysPickerCss)));
		return pairEmlement;
	}
	
	// Months Picker
	public static PairElement locateMonthsPicker(WebDriver driver) {
		pairEmlement = new PairElement(By.cssSelector(monthsPickerCss), driver.findElement(By.cssSelector(monthsPickerCss)));
		return pairEmlement;
	}
	
	// Year Picker Detail
	public static PairElement locateYearsPickerDetail(WebDriver driver, String year) {
		String yearsPickerXPath = String.format("//div[@class='datepicker-years']//span[text()='%s']", year);
		pairEmlement = new PairElement(By.xpath(yearsPickerXPath), driver.findElement(By.xpath(yearsPickerXPath)));
		return pairEmlement;
	}
	
	// Month Picker Detail
	public static PairElement locateMonthPickerDetail(WebDriver driver, String month) {
		String yearsPickerXPath = String.format("//div[@class='datepicker-months']//span[text()='%s']", month);
		pairEmlement = new PairElement(By.xpath(yearsPickerXPath), driver.findElement(By.xpath(yearsPickerXPath)));
		return pairEmlement;
	}
	
	// Day Picker Detail
	public static PairElement locateDayPickerDetail(WebDriver driver, String day) {
		String yearsPickerXPath = String.format("//div[@class='datepicker-days']//td[text()='%s']", day);
		pairEmlement = new PairElement(By.xpath(yearsPickerXPath), driver.findElement(By.xpath(yearsPickerXPath)));
		return pairEmlement;
	}
}
