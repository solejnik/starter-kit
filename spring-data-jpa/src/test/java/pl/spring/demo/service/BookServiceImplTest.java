package pl.spring.demo.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.criteriasearch.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")
public class BookServiceImplTest {

	@Autowired
	private BookSearchService bookSearchService  ;


	@Test
	public void testShouldFindBookByCriteriaTitleAuthorLibraryName() {
		//given
		BookSearchCriteria criteria = new BookSearchCriteria("p", "j", "1");
		List<BookTo> booksAfterSearchByCriteria;
		// when
		booksAfterSearchByCriteria = bookSearchService.findBooksByCriteria(criteria);
		// then
		assertNotNull(booksAfterSearchByCriteria);
		assertFalse(booksAfterSearchByCriteria.isEmpty());
		assertEquals(1, booksAfterSearchByCriteria.size());
		assertEquals("Pierwsza książka", booksAfterSearchByCriteria.get(0).getTitle());
		assertEquals("Jan Kowalski", booksAfterSearchByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByCriteriaTitleAuthor() {
		//given
		BookSearchCriteria criteria = new BookSearchCriteria("d", "z", null);
		List<BookTo> booksAfterSearchByCriteria;
		// when
		booksAfterSearchByCriteria = bookSearchService.findBooksByCriteria(criteria);
		// then
		assertNotNull(booksAfterSearchByCriteria);
		assertFalse(booksAfterSearchByCriteria.isEmpty());
		assertEquals(1, booksAfterSearchByCriteria.size());
		assertEquals("Druga książka", booksAfterSearchByCriteria.get(0).getTitle());
		assertEquals("Zbigniew Nowak", booksAfterSearchByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByCriteriaTitleLibraryName() {
		//given
		BookSearchCriteria criteria = new BookSearchCriteria("Trzecia książka", "", "Biblia2");
		List<BookTo> booksAfterSearchByCriteria;
		// when
		booksAfterSearchByCriteria = bookSearchService.findBooksByCriteria(criteria);
		// then
		assertNotNull(booksAfterSearchByCriteria);
		assertFalse(booksAfterSearchByCriteria.isEmpty());
		assertEquals(1, booksAfterSearchByCriteria.size());
		assertEquals("Trzecia książka", booksAfterSearchByCriteria.get(0).getTitle());
		assertEquals("Janusz Jankowski", booksAfterSearchByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByCriteriaAuthorLibraryName() {
		//given
		BookSearchCriteria criteria = new BookSearchCriteria("", "jan", "1bib");
		List<BookTo> booksAfterSearchByCriteria;
		// when
		booksAfterSearchByCriteria = bookSearchService.findBooksByCriteria(criteria);
		// then
		assertNotNull(booksAfterSearchByCriteria);
		assertFalse(booksAfterSearchByCriteria.isEmpty());
		assertEquals(1, booksAfterSearchByCriteria.size());
		assertEquals("Pierwsza książka", booksAfterSearchByCriteria.get(0).getTitle());
		assertEquals("Jan Kowalski", booksAfterSearchByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByCriteriaTitle() {
		//given
		BookSearchCriteria criteria = new BookSearchCriteria("Druga książka", "", "");
		List<BookTo> booksAfterSearchByCriteria;
		// when
		booksAfterSearchByCriteria = bookSearchService.findBooksByCriteria(criteria);
		// then
		assertNotNull(booksAfterSearchByCriteria);
		assertFalse(booksAfterSearchByCriteria.isEmpty());
		assertEquals(1, booksAfterSearchByCriteria.size());
		assertEquals("Druga książka", booksAfterSearchByCriteria.get(0).getTitle());
		assertEquals("Zbigniew Nowak", booksAfterSearchByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByCriteriaAuthor() {
		//given
		BookSearchCriteria criteria = new BookSearchCriteria("", "ja", "");
		List<BookTo> booksAfterSearchByCriteria;
		// when
		booksAfterSearchByCriteria = bookSearchService.findBooksByCriteria(criteria);
		// then
		assertNotNull(booksAfterSearchByCriteria);
		assertFalse(booksAfterSearchByCriteria.isEmpty());
		assertEquals(2, booksAfterSearchByCriteria.size());
		assertEquals("Pierwsza książka", booksAfterSearchByCriteria.get(0).getTitle());
		assertEquals("Jan Kowalski", booksAfterSearchByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByCriteriaLibraryName() {
		//given
		BookSearchCriteria criteria = new BookSearchCriteria("", "", "Biblia2");
		List<BookTo> booksAfterSearchByCriteria;
		// when
		booksAfterSearchByCriteria = bookSearchService.findBooksByCriteria(criteria);
		// then
		assertNotNull(booksAfterSearchByCriteria);
		assertFalse(booksAfterSearchByCriteria.isEmpty());
		assertEquals(1, booksAfterSearchByCriteria.size());
		assertEquals("Trzecia książka", booksAfterSearchByCriteria.get(0).getTitle());
		assertEquals("Janusz Jankowski", booksAfterSearchByCriteria.get(0).getAuthors());
	}
	
	@Test
	public void testShouldFindBookByNoCriteriaCriteria() {
		//given
		BookSearchCriteria criteria = new BookSearchCriteria(null,null,null);
		List<BookTo> booksAfterSearchByCriteria;
		// when
		booksAfterSearchByCriteria = bookSearchService.findBooksByCriteria(criteria);
		// then
		assertNotNull(booksAfterSearchByCriteria);
		assertFalse(booksAfterSearchByCriteria.isEmpty());
		assertEquals(3, booksAfterSearchByCriteria.size());
	}

}