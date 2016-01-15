package pl.spring.demo.mapper;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "BookTypeMapperTest.xml" })
public class BokkTypeMapperTest {

	@Autowired
	private BookTypeMapper bookTypeMapper;

	@Before
	public void setUp() {
		bookTypeMapper = new BookTypeMapper();
	}

	@Test
	public void testShouldMappFromBookToToBookEntity() {
		// given
		BookTo bookTo = new BookTo(1l, "title", "author");
		BookEntity bookEntity = new BookEntity(1l, "title",
				new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1l, "author", "author"))));
		// when
		BookEntity mappedBookEntity = bookTypeMapper.mapBookTypeToEntity(bookTo);
		// then
		assertEquals(bookEntity.getId(), mappedBookEntity.getId());
		assertEquals(bookEntity.getTitle(), mappedBookEntity.getTitle());

		for (int i = 0; i < bookEntity.getAuthors().size(); i++) {
			AuthorTo entityAuthor = bookEntity.getAuthors().get(i);
			AuthorTo mappedEntityAuthor = mappedBookEntity.getAuthors().get(i);
			assertEquals(entityAuthor.getFirstName(), mappedEntityAuthor.getFirstName());
			assertEquals(entityAuthor.getLastName(), mappedEntityAuthor.getLastName());
			assertEquals(entityAuthor.getId(), mappedEntityAuthor.getId());
		}
	}

	@Test
	public void testShouldMappFromBookEntityToBookTo() {
		// given
		BookEntity bookEntity = new BookEntity(1l, "title",
				new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(1l, "author", "author"))));
		BookTo bookTo = new BookTo(1l, "title", "author");
		// when
		BookTo mappedBookTo = bookTypeMapper.mapBookTypeEntityTo(bookEntity);
		// then
		assertEquals(bookTo.getId(), mappedBookTo.getId());
		assertEquals(bookTo.getTitle(), mappedBookTo.getTitle());
		assertEquals(bookTo.getAuthors(), mappedBookTo.getAuthors());
	}
}
