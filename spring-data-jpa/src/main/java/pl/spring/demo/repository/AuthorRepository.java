package pl.spring.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.spring.demo.entity.AuthorEntity;

public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {

    @Query("select author from AuthorEntity author where author.firstName like :firstName")
    public List<AuthorEntity> findAuthorsByFirstName(@Param("firstName") String firstName);

    @Query("select author from AuthorEntity author where author.lastName like :lastName")
    public List<AuthorEntity> findAuthorsByLastName(@Param("lastName") String lastName);
    
    @Query("select author from AuthorEntity author where author like :author")
    public AuthorEntity findAuthorByAuthor(@Param("author") AuthorEntity author);

}
