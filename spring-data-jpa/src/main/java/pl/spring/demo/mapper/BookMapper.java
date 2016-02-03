package pl.spring.demo.mapper;

import pl.spring.demo.entity.AuthorEntity;
import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.to.BookTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookMapper {
public static void main(String args[]){
}
    public static BookTo map(BookEntity bookEntity) {
        if (bookEntity != null) {
        	List<AuthorEntity> authorsList = new ArrayList<AuthorEntity>();
            Set<AuthorEntity> authors = bookEntity.getAuthors();
            AuthorEntity next = authors.iterator().next();
            authorsList.addAll(authors);
			return new BookTo(bookEntity.getId(), bookEntity.getTitle(), AuthorMapper.map2To(authorsList));
        }
        return null;
    }

    public static BookEntity map(BookTo bookTo) {
        if (bookTo != null) {
            return new BookEntity(bookTo.getId(), bookTo.getTitle());
        }
        return null;
    }

    public static List<BookTo> map2To(List<BookEntity> bookEntities) {
        return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
    }

    public static List<BookEntity> map2Entity(List<BookTo> bookEntities) {
        return bookEntities.stream().map(BookMapper::map).collect(Collectors.toList());
    }

    private static String mapAuthors(Collection<AuthorEntity> authors) {
        if (!authors.isEmpty()) {
            return authors.stream().map(authorEntity -> authorEntity.getFirstName() + " " + authorEntity.getLastName()).collect(Collectors.joining
                    (", "));
        }
        return null;
    }
}