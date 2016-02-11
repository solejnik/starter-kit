package pl.spring.demo.web.selenium.test;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import pl.spring.demo.web.selenium.AbstractSelenium;
import pl.spring.demo.web.selenium.pages.HomePage;

public class HomePageSeleniumTest extends AbstractSelenium {

	private HomePage homePage;

	@Override
	@Before
	public void setUp()  {
		super.setUp();
		homePage = openHomePage();
	}

	@Test
	public void shouldCheckIfIsErrorAfterLoadHomePage() {
		assertFalse(homePage.hasError());
	}


}
