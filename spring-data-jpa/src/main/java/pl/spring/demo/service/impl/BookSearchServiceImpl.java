package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.criteriasearch.BookSearchCriteria;
import pl.spring.demo.mapper.BookMapper;
import pl.spring.demo.repository.BookRepository;
import pl.spring.demo.service.BookSearchService;
import pl.spring.demo.to.BookTo;

@Service
@Transactional(readOnly = true)
public class BookSearchServiceImpl implements BookSearchService {
	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public List<BookTo> findBooksByCriteria(BookSearchCriteria criteria) {
		int criteriaValue = criteria.getCriteriaValue();
		switch (criteriaValue) {
		case 7:
			return BookMapper.map2To(bookRepository.findBookByTitleAuthorLibraryName(criteria.getTitle(), criteria.getAuthor(), criteria.getLibraryName()));
		case 6:
			return BookMapper.map2To(bookRepository.findBookByTitleAuthor(criteria.getTitle(), criteria.getAuthor()));
		case 5:
			return BookMapper.map2To(bookRepository.findBookByTitleLibraryName(criteria.getTitle(), criteria.getLibraryName()));
		case 4:
			return BookMapper.map2To(bookRepository.findBookByTitle(criteria.getTitle()));
		case 3:
			return BookMapper.map2To(bookRepository.findBookByAuthorLibraryName(criteria.getAuthor(), criteria.getLibraryName()));
		case 2:
			return BookMapper.map2To(bookRepository.findBookByAuthor(criteria.getAuthor()));
		case 1:
			return BookMapper.map2To(bookRepository.findBookByLibraryName(criteria.getLibraryName()));
		default:
			return BookMapper.map2To(bookRepository.findAll());
		}
	}

}
