package pl.spring.demo.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.spring.demo.to.AuthorTo;
import pl.spring.demo.to.BookEntity;
import pl.spring.demo.to.BookTo;

@Component
public class BookTypeMapper {

	public BookTo mapBookTypeEntityTo(BookEntity bookEntity) {
		BookTo bookTo = new BookTo();
		bookTo.setId(bookEntity.getId());
		bookTo.setTitle(bookEntity.getTitle());
		StringBuilder authorsList = new StringBuilder();
		for (AuthorTo author : bookEntity.getAuthors()) {
			if(author.getLastName().equals(author.getFirstName())){
				authorsList.append("," + author.getFirstName());
			}else{
				authorsList.append("," + author.getFirstName() + " " + author.getLastName());
			}
		}
		authorsList.replace(0, 1, "");
		bookTo.setAuthors(authorsList.toString());
		return bookTo;
	}

	public BookEntity mapBookTypeToEntity(BookTo bookTo) {
		BookEntity bookEntity = new BookEntity();
		bookEntity.setId(bookTo.getId());
		bookEntity.setTitle(bookTo.getTitle());
		List<AuthorTo> authors = new ArrayList<AuthorTo>();
		int countAuthors = 0;
		if (bookTo.getAuthors() != null) {
			for (String author : bookTo.getAuthors().split(",")) {
				String fname = author.split(" ")[0];
				String lname = author.split(" ")[0];
				if (author.split(" ").length > 1) {
					lname = author.split(" ")[1];
				}
				countAuthors++;
				authors.add(new AuthorTo(countAuthors, fname, lname));
			}
		}
		bookEntity.setAuthors(authors);
		return bookEntity;
	}

}
