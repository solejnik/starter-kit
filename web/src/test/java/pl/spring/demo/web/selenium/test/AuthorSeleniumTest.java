package pl.spring.demo.web.selenium.test;

import org.junit.Before;
import org.junit.Test;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.FindAuthorsPage;
import pl.spring.demo.web.selenium.pages.HomePage;

public class AuthorSeleniumTest extends AbstractSelenium {

	private HomePage homePage;
	private FindAuthorsPage findAuthorsPage;

	@Override
	@Before
	public void setUp()  {
		super.setUp();
		homePage = openHomePage();
		findAuthorsPage = homePage.clickAuthors();;
	}

	@Test
	public void shouldCheckIfBookTitleIsNotRequired() {
		findAuthorsPage.insertAuthor("Jan");
	}
	

}
