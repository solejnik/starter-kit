package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.base.Predicate;

import pl.spring.demo.web.selenium.AbstractPageObject;

public class AddBookModalPage extends AbstractPageObject {
	@FindBy(xpath = "//form[@name='myForm']//input[@placeholder='Przykladowy tytul']")
	private WebElement title;
	@FindBy(xpath = "//input[@placeholder='imie']")
	private WebElement authorFirstName;
	@FindBy(xpath = "//input[@placeholder='nazwisko']")
	private WebElement authorlastName;
	@FindBy(xpath = "//form[@name='myForm']//button[text()='Zapisz']")
	private WebElement saveBookButton;
	@FindBy(xpath = "//form[@name='myForm']//button[text()='Kolejny autor']")
	private WebElement moreAuthorsButton;

	public AddBookModalPage(WebDriver driver) {
		super(driver);
	}

	public void setTitle(String title) {
		this.title.sendKeys(title);
	}
	
	public void setFirstName(String firstName) {
		this.authorFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		this.authorlastName.sendKeys(lastName);
	}
	
	public boolean isSaveBookEnabled(){
		return saveBookButton.isEnabled();
	}
	
	public void clickSaveButton(){
		saveBookButton.click();
	}
	
	public AddAuthorModalPage clickMoreAuthors() {
		moreAuthorsButton.click();
		return PageFactory.initElements(driver, AddAuthorModalPage.class);
	}

	public WebElement getTitle() {
		return title;
	}

	public WebElement getAuthorFirstName() {
		return authorFirstName;
	}

	public WebElement getAuthorlastName() {
		return authorlastName;
	}

	public WebElement getSaveBookButton() {
		return saveBookButton;
	}

	public Predicate<WebDriver> elementToBeClickable(By xpath) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
