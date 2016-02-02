package pl.spring.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.mapper.AuthorMapper;
import pl.spring.demo.repository.AuthorRepository;
import pl.spring.demo.service.AuthorService;
import pl.spring.demo.to.AuthorTo;

@Service
@Transactional(readOnly = true)
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

	@Override
	public List<AuthorTo> findAllAuthors() {
		return AuthorMapper.map2To(authorRepository.findAll());
	}

	@Override
	public List<AuthorTo> findAuthorsByFirstName(String firstName) {
		return AuthorMapper.map2To(authorRepository.findAuthorsByFirstName(firstName));
	}

	@Override
	public List<AuthorTo> findAuthorsByLastName(String lastName) {
		return AuthorMapper.map2To(authorRepository.findAuthorsByLastName(lastName));	
		}

	@Override
	public void updateAuthor(AuthorTo author) {
		if(authorRepository.findAuthorsByFirstName(author.getFirstName()).isEmpty()&&authorRepository.findAuthorsByFirstName(author.getFirstName()).isEmpty()){
			AuthorEntity entity = AuthorMapper.map(author);
	        entity = authorRepository.save(entity);
		}
	}

    
}
