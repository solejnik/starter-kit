package pl.spring.demo.service;

import pl.spring.demo.criteriasearch.BookSearchCriteria;
import pl.spring.demo.to.BookTo;

import java.util.List;

public interface BookSearchService {

	List<BookTo> findBooksByCriteria(BookSearchCriteria criteria);

}
