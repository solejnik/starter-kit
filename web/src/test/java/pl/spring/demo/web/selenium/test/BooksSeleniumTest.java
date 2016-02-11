package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.AddBookModalPage;
import pl.spring.demo.web.selenium.pages.BooksPage;
import pl.spring.demo.web.selenium.pages.HomePage;

public class BooksSeleniumTest extends AbstractSelenium {

	private HomePage homePage;
	private BooksPage booksPage;

	@Override
	@Before
	public void setUp()  {
		super.setUp();
		homePage = openHomePage();
		booksPage = homePage.clickBooks();
	}

	@Test
	public void shouldCheckIfBookTitleIsNotRequired() {
		booksPage.clickSearchBooks();
		assertFalse(booksPage.hasError());
	}
	
	@Test
	public void shouldCheckIfAddBokkButtonOpenAddBookModal() {
		AddBookModalPage addBookModalPage = booksPage.clickAddBooks();
		assertNotNull(addBookModalPage);
		assertFalse(booksPage.hasError());
	}

}
