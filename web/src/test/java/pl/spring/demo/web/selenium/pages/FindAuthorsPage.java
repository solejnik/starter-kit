package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pl.spring.demo.web.selenium.AbstractPageObject;

public class FindAuthorsPage extends AbstractPageObject {
	@FindBy(css = ".ng-pristine, .ng-untouched, .ng-valid")
	private WebElement searchAuthors;
	
	public FindAuthorsPage(WebDriver driver) {
		super(driver);
	}
	
	public void insertAuthor(String author){
		searchAuthors.sendKeys(author);
	}
}
