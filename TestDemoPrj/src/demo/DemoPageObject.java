package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoPageObject {

	private static PairElement pairEmlement = null;

	// By Info
	private static By insuranceTabBy = By.xpath("//a[contains(@href,'#Insurance')]");
	private static By travelLinkBy = By.linkText("TRAVEL");
	private static By showResultBtnBy = By.cssSelector(
			"#travel-form > div.form-footer.clearfix > div > button.btn.btn-primary.btn-block.text-uppercase.btn-form-submit");

	// Insurance tab
	public static PairElement locateInsuranceTab(WebDriver driver) {
		pairEmlement = new PairElement(insuranceTabBy, driver.findElement(insuranceTabBy));
		return pairEmlement;
	}

	// Travel link
	public static PairElement locateTravelLink(WebDriver driver) {
		pairEmlement = new PairElement(travelLinkBy, driver.findElement(travelLinkBy));
		return pairEmlement;
	}

	// Show result button
	public static PairElement locateShowResultBtn(WebDriver driver) {
		pairEmlement = new PairElement(showResultBtnBy, driver.findElement(showResultBtnBy));
		return pairEmlement;
	}
}
