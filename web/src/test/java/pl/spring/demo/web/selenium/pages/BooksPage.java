package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pl.spring.demo.web.selenium.AbstractPageObject;

public class BooksPage extends AbstractPageObject {
	@FindBy(xpath = "//button[text()='Dodaj książkę']")
	private WebElement addBook;
	@FindBy(xpath = "//button[text()='Szukaj']")
	private WebElement searchBook;
	@FindBy(css = ".ng-pristine, .ng-untouched, .ng-valid")
	private WebElement searchCriteria;
	@FindBy(xpath = "//tr[.//td]//button[text()='Usuń']")
	private WebElement deleteButton;
	@FindBy(xpath = "//tr[.//td]//button[text()='Edytuj książkę']")
	private WebElement editBookButton;
	
	public BooksPage(WebDriver driver) {
		super(driver);
	}
	
	public AddBookModalPage clickAddBooks() {
		addBook.click();
		return PageFactory.initElements(driver, AddBookModalPage.class);
	}
	
	public void clickSearchBooks(){
		searchBook.click();
	}
	
	public void insertIntoSearchCriteria(String criteria){
		searchCriteria.sendKeys(criteria);
	}
	
	public void clickDeleteButton(){
		deleteButton.click();
		Dimension size = deleteButton.getSize();
		System.out.println(size);
	}
	
	public void clickEditBookButton(){
		editBookButton.click();
	}
}
