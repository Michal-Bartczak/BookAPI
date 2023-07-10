package pl.coderslab;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Controller
public class MockBookService {

    private List<Book> booksList;

    public MockBookService() {

        booksList = new ArrayList<>();

        booksList.add(new Book(1L, "9788324631766", "Thiniking	in	Java", "Bruce	Eckel", "Helion", "programming"));

        booksList.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",

                "programming"));

        booksList.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",

                "programming"));

    }

    public List<Book> findAllBooks() {
        return booksList;
    }

    public Book findBookById(Long id) {
        return booksList.stream()
                .filter(book -> book.getId().equals(id))
                .map(book -> new Book(book.getId(), book.getIsbn(), book.getTitle(),
                        book.getAuthor(), book.getPublisher(), book.getType()))
                .findFirst().orElse(null);
    }

    public void editBook(Book book) {
        for (Book e : booksList) {
            if (book.getId().equals(e.getId())) {
                e.setId(book.getId());
                e.setIsbn(book.getIsbn());
                e.setType(book.getType());
                e.setTitle(book.getTitle());
                e.setAuthor(book.getAuthor());
                e.setPublisher(book.getPublisher());
            }
        }
    }

    public void deleteById(Long id) {
        booksList.removeIf(book -> id.equals(book.getId()));
    }

    public void addBook(Book book) {
        booksList.add(book);
    }
}

















