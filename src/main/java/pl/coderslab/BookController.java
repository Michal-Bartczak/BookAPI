package pl.coderslab;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private final MockBookService bookService;

    public BookController(MockBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAllBooks();
    }

    @ResponseBody
    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");

    }


    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }


    @GetMapping("/{id}")
    public Book bookById(@PathVariable Long id) {
        Book book = bookService.findBookById(id);
        if (book == null) {
            ResponseEntity.notFound();
        }
        return book;
    }

    @PutMapping()

    public void updateBook(@RequestBody Book book) {
        bookService.editBook(book);
    }


    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
