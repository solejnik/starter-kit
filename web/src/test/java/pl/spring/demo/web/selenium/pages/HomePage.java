package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.selenium.AbstractPageObject;

public class HomePage extends AbstractPageObject{
	@FindBy(linkText="Dialog A")
	private WebElement DialogA;
	@FindBy(linkText="Dialog B")
	private WebElement DialogB;
	@FindBy(linkText="Autorzy")
	private WebElement Authors;
	@FindBy(linkText="Ksiazki")
	private WebElement Books;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://localhost:9721/workshop/#/main/welcome");
	}

	
	public void clickDialogA() {
		DialogA.click();
	}
	
	public void clickDialogB() {
		DialogB.click();
	}
	
	public FindAuthorsPage clickAuthors() {
		Authors.click();
		return PageFactory.initElements(driver, FindAuthorsPage.class);
	}
	
	public BooksPage clickBooks() {
		Books.click();
		return PageFactory.initElements(driver, BooksPage.class);
	}
	
}
