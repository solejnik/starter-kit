package pl.spring.demo.service;

import pl.spring.demo.to.BookTo;

import java.util.List;

public interface BookService {

    List<BookTo> findAllBooks();
    List<BookTo> findBooksByTitle(String title);
    List<BookTo> findBooksByAuthor(String author);
    
    BookTo findById(Long id);
    BookTo saveBook(BookTo book);
	BookTo deleteBook(BookTo book);
	void updateBook(BookTo book);
}
