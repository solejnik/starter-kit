package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.AddBookModalPage;
import pl.spring.demo.web.selenium.pages.BooksPage;
import pl.spring.demo.web.selenium.pages.HomePage;

public class AddBookModalPageSeleniumTest extends AbstractSelenium {

	private HomePage homePage;
	private BooksPage booksPage;
	private AddBookModalPage addBookModalPage;
	@Override
	@Before
	public void setUp()  {
		super.setUp();
		homePage = openHomePage();
		booksPage = homePage.clickBooks();
		addBookModalPage = booksPage.clickAddBooks();
	}

	@Test
	public void shouldCheckIfNewBookTitleIsNotRequired() {
		addBookModalPage.setFirstName("Jan");
		addBookModalPage.setLastName("Kowalski");
		boolean isEnabled = addBookModalPage.getSaveBookButton().isEnabled();
		assertFalse(isEnabled);
	}
	
	
	@Test
	public void shouldCheckIfNewBookAuthorLastNameIsNotRequired() {
		addBookModalPage.setFirstName("Jan");
		addBookModalPage.setTitle("Tytul");
		boolean isEnabled = addBookModalPage.getSaveBookButton().isEnabled();
		assertFalse(isEnabled);
	}
	
	@Test
	public void shouldCheckIfNewBookAuthorFirstNameIsNotRequired() {
		addBookModalPage.setLastName("Kowalski");
		addBookModalPage.setTitle("Tytul");
		boolean isEnabled = addBookModalPage.getSaveBookButton().isEnabled();
		assertFalse(isEnabled);
	}
	
	@Test
	public void shouldCheckIfAddMoreAuthorsButtonOpenAddAuthorModal() {
		addBookModalPage.setFirstName("Jan");
		addBookModalPage.setLastName("Kowalski");
		addBookModalPage.setTitle("Tytul");
		addBookModalPage.clickMoreAuthors();
	}
	
	@Test
	public void shouldClickSaveIfAllImputsAreFilled() {
		addBookModalPage.setFirstName("Jan");
		addBookModalPage.setLastName("Kowalski");
		addBookModalPage.setTitle("Tytul");
		boolean isEnabled = addBookModalPage.getSaveBookButton().isEnabled();
		assertTrue(isEnabled);
	}

}
