package pl.spring.demo.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.spring.demo.annotation.NullableId;
import pl.spring.demo.common.Sequence;
import pl.spring.demo.dao.BookDao;
import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;

@Component
public class BookDaoImpl implements BookDao {
	private final Set<BookEntity> ALL_BOOKS = new HashSet<>();

	public BookDaoImpl() {
		addTestBooks();
	}

	@Override
	public List<BookEntity> findAll() {
		return new ArrayList<>(ALL_BOOKS);
	}

	@Override
	public List<BookEntity> findBookByTitle(String title) {
		List<BookEntity> allBooks = findAll();
		List<BookEntity> foundedBooks = new ArrayList<BookEntity>();
		for (BookEntity book : allBooks) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				foundedBooks.add(book);
			}
		}

		return foundedBooks;
	}

	@Override
	public List<BookEntity> findBooksByAuthor(String author) {
		List<BookEntity> allBooks = findAll();
		Map<Long, BookEntity> foundedBooks = new HashMap<Long, BookEntity>();
		for (BookEntity book : allBooks) {
			List<AuthorTo> authorsTo = book.getAuthors();
			for (AuthorTo authorTo : authorsTo) {
				if ((authorTo.getFirstName().toLowerCase().contains(author.toLowerCase())
						|| authorTo.getLastName().toLowerCase().contains(author.toLowerCase()))) {
					foundedBooks.put(book.getId(), book);
					break;
				}
			}
		}
		return new ArrayList<BookEntity>(foundedBooks.values());
	}

	@Override
	@NullableId
	public BookEntity save(BookEntity book) {
		ALL_BOOKS.add(book);
		return book;
	}

	private void addTestBooks() {
		ALL_BOOKS.add(new BookEntity(1L, "Romeo i Julia", new ArrayList<AuthorTo>(
				Arrays.asList(new AuthorTo(1, "Wiliam", "Szekspir"), new AuthorTo(2, "Sztefn", "Marcepan")))));
		ALL_BOOKS.add(new BookEntity(2L, "Opium w rosole",
				new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(2, "Hanna", "Ożogowska")))));
		ALL_BOOKS.add(new BookEntity(3L, "Przygody Odyseusza",
				new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(3, "Jan", "Parandowski")))));
		ALL_BOOKS.add(new BookEntity(4L, "Awantura w Niekłaju",
				new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(4, "Edmund", "Niziurski")))));
		ALL_BOOKS.add(new BookEntity(5L, "Pan Samochodzik i Fantomas",
				new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(5, "Zbigniew", "Nienacki")))));
		ALL_BOOKS.add(new BookEntity(6L, "Zemsta",
				new ArrayList<AuthorTo>(Arrays.asList(new AuthorTo(6, "Aleksander", "Fredro")))));
	}

}
