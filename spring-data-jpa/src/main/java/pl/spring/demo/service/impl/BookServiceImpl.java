package pl.spring.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import pl.spring.demo.dao.BookDao;
import pl.spring.demo.mapper.BookTypeMapper;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@Service
public class BookServiceImpl implements BookService {

	private BookDao bookDao;
	private BookTypeMapper mapper;

	@Autowired
	public BookServiceImpl(BookDao bookDao, BookTypeMapper mapper) {
		this.bookDao = bookDao;
		this.mapper = mapper;
	}

	@Override
	@Cacheable("booksCache")
	public List<BookTo> findAllBooks() {
		List<BookTo> books = new ArrayList<BookTo>();
		for (BookEntity bookEntity : bookDao.findAll()) {
			books.add(mapper.mapBookTypeEntityTo(bookEntity));
		}
		return books;
	}

	@Override
	public List<BookTo> findBooksByTitle(String title) {
		List<BookTo> books = new ArrayList<BookTo>();
		for (BookEntity bookEntity : bookDao.findBookByTitle(title)) {
			books.add(mapper.mapBookTypeEntityTo(bookEntity));
		}
		return books;
	}

	@Override
	public List<BookTo> findBooksByAuthor(String author) {
		List<BookTo> books = new ArrayList<BookTo>();
		for (BookEntity bookEntity : bookDao.findBooksByAuthor(author)) {
			books.add(mapper.mapBookTypeEntityTo(bookEntity));
		}
		return books;
	}

	@Override
	public BookTo saveBook(BookTo bookTo) {
		BookEntity bookEntity = mapper.mapBookTypeToEntity(bookTo);
		BookEntity savdBook = bookDao.save(bookEntity);
		return mapper.mapBookTypeEntityTo(savdBook);
	}

}
