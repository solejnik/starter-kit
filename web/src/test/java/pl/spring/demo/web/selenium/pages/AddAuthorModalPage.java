package pl.spring.demo.web.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pl.spring.demo.web.selenium.AbstractPageObject;

public class AddAuthorModalPage extends AbstractPageObject {

	@FindBy(xpath = "//input[@placeholder='imie autora']")
	private WebElement authorFirstName;
	@FindBy(xpath = "//input[@placeholder='nazwisko autora']")
	private WebElement authorlastName;
	@FindBy(xpath = "//button[text()='Dodaj']")
	private WebElement addAuthorButton;


	public AddAuthorModalPage(WebDriver driver) {
		super(driver);
	}
	
	public void setFirstName(String firstName) {
		this.authorFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		this.authorlastName.sendKeys(lastName);
	}
	
	public void clickAdd(){
		addAuthorButton.click();
	}


}
