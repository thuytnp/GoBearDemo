package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PairElement {
	
	private By by;
	private WebElement element;
	
	public PairElement(By by, WebElement element) {
		this.by = by;
		this.element = element;
	}

	public By getBy() {
		return by;
	}

	public void setBy(By by) {
		this.by = by;
	}

	public WebElement getElement() {
		return element;
	}

	public void setElement(WebElement element) {
		this.element = element;
	}

}
