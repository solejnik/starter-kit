package pl.spring.demo.service;

import java.util.List;

import pl.spring.demo.to.AuthorTo;

public interface AuthorService {

    List<AuthorTo> findAllAuthors();
    List<AuthorTo> findAuthorsByFirstName(String firstName);
    List<AuthorTo> findAuthorsByLastName(String lastName);

    void updateAuthor(AuthorTo author);
}
