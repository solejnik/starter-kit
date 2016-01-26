package pl.spring.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.entity.LibraryEntity;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonRepositoryTest-context.xml")
public class LibraryRepositoryTest {

    @Autowired
    private LibraryRepository libraryRepository;
    @Autowired
    private BookRepository bookRepository;
    @Test
    public void testShouldFindLibraryByNamePrefix() {
        // given
        final String libraryNamePrefix = "Bi";
        // when
        List<LibraryEntity> libraries = libraryRepository.findLibraryByName(libraryNamePrefix);
        // then
        assertNotNull(libraries);
        assertEquals("Biblia2", libraries.get(0).getName());
    }
    
    @Test
    public void testShouldFindOneBookAfterDeleteFirstLibrary() {
    	// given
    	final int expectedAmountOfBooksAfterDeleteFirsLibrary = 1;
    	int amountOfBooksAfterDeleteFirsLibrary;
    	// when
    	libraryRepository.delete(1l);
    	amountOfBooksAfterDeleteFirsLibrary = bookRepository.findAll().size();
    	// then
    	assertEquals(expectedAmountOfBooksAfterDeleteFirsLibrary, amountOfBooksAfterDeleteFirsLibrary);
    }
    
    @Test
    public void testShouldFind() {
    	// given
    	BookEntity book = bookRepository.findOne(3l);
    	// when
    	// then
    }

//    @Test
//    public void testShouldFindBooksByTitle() {
//        // given
//        final String bookTitle = "p";
//        // when
//        List<BookEntity> booksEntity = bookRepository.findBookByTitle(bookTitle);
//        // then
//        assertNotNull(booksEntity);
//        assertFalse(booksEntity.isEmpty());
//        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
//    }
//
//    @Test
//    public void testShouldFindBooksByAuthorFirstName() {
//        // given
//        final String author = "jan";
//        // when
//        List<BookEntity> booksEntity = bookRepository.findBookByAuthor(author);
//        // then
//        assertNotNull(booksEntity);
//        assertFalse(booksEntity.isEmpty());
//        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
//    }
//
//    @Test
//    public void testShouldFindBooksByAuthorLastName() {
//        // given
//        final String author = "kowalski";
//        // when
//        List<BookEntity> booksEntity = bookRepository.findBookByAuthor(author);
//        // then
//        assertNotNull(booksEntity);
//        assertFalse(booksEntity.isEmpty());
//        assertEquals("Pierwsza książka", booksEntity.get(0).getTitle());
//    }
}
