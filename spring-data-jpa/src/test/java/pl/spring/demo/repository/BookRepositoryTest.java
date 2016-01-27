package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testShouldFindBookById() {
        // given
        final long bookId = 1;
        // when
        BookEntity bookEntity = bookRepository.findOne(bookId);
        // then
        assertNotNull(bookEntity);
        assertEquals("Pierwsza książka", bookEntity.getTitle());
    }

    @Test
    public void testShouldFindBooksByTitle() {
        // given
        final String bookTitle = "p";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByTitle(bookTitle);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }

    @Test
    public void testShouldFindBooksByAuthorFirstName() {
        // given
        final String author = "jan";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByAuthor(author);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }

    @Test
    public void testShouldFindBooksByAuthorLastName() {
        // given
        final String author = "kowalski";
        // when
        List<BookEntity> booksEntity = bookRepository.findBookByAuthor(author);
        // then
        assertNotNull(booksEntity);
        assertFalse(booksEntity.isEmpty());
        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
    }
    
    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void testShouldThrowDataIntegrityViolationException() {
    	// given
    	Set<AuthorEntity> authors = new HashSet<AuthorEntity>(Arrays.asList(new AuthorEntity("Max", "Iksiński")));
    	BookEntity booksEntity = new BookEntity(4l, "Czwarta Książka");
    	booksEntity.setAuthors(authors);
    	// when
    	bookRepository.save(booksEntity);
    	// then
    	fail("test should throw DataIntegrityViolationException");
    }
}
