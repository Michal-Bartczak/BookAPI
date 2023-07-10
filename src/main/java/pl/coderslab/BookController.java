package pl.coderslab;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/books")
public class BookController {

    private final MockBookService bookService;

    public BookController(MockBookService bookService) {
        this.bookService = bookService;
    }

    @ResponseBody
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

    @ResponseBody
    @PostMapping
    public void addBook(Book book) {
        bookService.addBook(book);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Book bookById(@RequestParam Long id) {
        return bookService.findBookById(id);
    }

    @PutMapping()
    @ResponseBody
    public void updateBook(@RequestBody Book book) {
        bookService.editBook(book);
    }

    @ResponseBody
    @DeleteMapping("/{id}")
    public void deleteBook(@RequestParam Long id) {
        bookService.deleteById(id);
    }
}
