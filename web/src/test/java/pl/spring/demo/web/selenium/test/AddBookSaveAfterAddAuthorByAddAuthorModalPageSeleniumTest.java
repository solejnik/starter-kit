package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.AddAuthorModalPage;
import pl.spring.demo.web.selenium.pages.AddBookModalPage;
import pl.spring.demo.web.selenium.pages.BooksPage;
import pl.spring.demo.web.selenium.pages.HomePage;

public class AddBookSaveAfterAddAuthorByAddAuthorModalPageSeleniumTest extends AbstractSelenium {

	private HomePage homePage;
	private BooksPage booksPage;
	private AddBookModalPage addBookModalPage;
	private AddAuthorModalPage addAuthorModalPage;
	@Override
	@Before
	public void setUp()  {
		super.setUp();
		homePage = openHomePage();
		booksPage = homePage.clickBooks();
		addBookModalPage = booksPage.clickAddBooks();
		addBookModalPage.setTitle("Tytul");
		addBookModalPage.setFirstName("Jan");
		addBookModalPage.setLastName("Kowalski");
		addAuthorModalPage = addBookModalPage.clickMoreAuthors();
	}

	@Test
	public void shouldSaveBookAfterAddAnotherAuthor() {
		addAuthorModalPage.setFirstName("Anna");
		addAuthorModalPage.setLastName("Wanna");
		addAuthorModalPage.clickAdd();
		WebDriverWait wait = new WebDriverWait(getDriver(), 15);

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("anotherAuthor")));
		addBookModalPage.clickSaveButton();
	}
}
