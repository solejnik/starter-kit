package pl.spring.demo.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.mapper.AuthorMapper;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.AuthorRepository;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

@Service
@Transactional(readOnly = true)
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<BookTo> findAllBooks() {
        return BookMapper.map2To(bookRepository.findAll());
    }

    @Override
    public List<BookTo> findBooksByTitle(String title) {
        return BookMapper.map2To(bookRepository.findBookByTitle(title));
    }

    @Override
    public List<BookTo> findBooksByAuthor(String author) {
        return BookMapper.map2To(bookRepository.findBookByAuthor(author));
    }

    @Override
    @Transactional(readOnly = false)
    public BookTo saveBook(BookTo book) {
        BookEntity entity = BookMapper.map(book);
        Set<AuthorEntity> authorsSet = new HashSet<AuthorEntity>();
        List<AuthorEntity> map2Entity = AuthorMapper.map2Entity((book.getAuthors()));
        //
//        for(AuthorEntity author : map2Entity){
//        	if(authorRepository.findAuthorsByFirstNameAndLastName(author.getFirstName(), author.getLastName()).size()>0){
//        		authorsSet.add(author);
//        	}else if(authorRepository.findAuthorsByFirstNameAndLastName(author.getFirstName(), author.getLastName()).size()>0){
//        		authorsSet.add(authorRepository.findOneAuthorbyFirstNameAndLastName(author.getFirstName(), author.getLastName()));
//        	}
//        		
//        }
        //
		authorsSet.addAll(map2Entity);
        entity.setAuthors(authorsSet);
        entity = bookRepository.save(entity);
        return BookMapper.map(entity);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteBook(long id) {
        bookRepository.delete(id);
    }
}
