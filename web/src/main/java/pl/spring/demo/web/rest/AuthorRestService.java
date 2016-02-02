package pl.spring.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.spring.demo.service.AuthorService;
import pl.spring.demo.to.AuthorTo;

@RestController
@RequestMapping(value="/authors")
public class AuthorRestService {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public List<AuthorTo> findallAuthors(@RequestParam(value = "titlePrefix", required = false) String titlePrefix) {
            return authorService.findAllAuthors();
    }

    @RequestMapping(value = "/author", method = {RequestMethod.POST})
    public void updateAuthor(@RequestBody AuthorTo author) {
         authorService.updateAuthor(author);
    }

    
//    @RequestMapping(value = "/book/{title}", method = RequestMethod.POST)
//    public void addBook(@PathVariable("title") String title) {
//    	BookTo book = new BookTo(null,title,new ArrayList<>(Arrays.asList(new AuthorTo(1l, "stefan", "batory"))));
//    	bookService.saveBook(book);
//    }
}
