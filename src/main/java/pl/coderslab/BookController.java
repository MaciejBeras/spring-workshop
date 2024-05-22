package pl.coderslab;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {

  private final BookService bookService;


  @RequestMapping("helloBook")
  public Book helloBook() {
    return new Book(1L, "9788324631766", "Thinking in Java",
        "Bruce Eckel", "Helion", "programming");
  }

  @GetMapping("")
  public List<Book> getList() {
    return bookService.getBooks();
  }

  @PostMapping("")
  public void addBook(@RequestBody Book book) {
    bookService.add(book);
  }

  @GetMapping("/{id}")
  public Book getBook(@PathVariable Long id) {
    return this.bookService.get(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "entity not found"));
  }


  @DeleteMapping("/{id}")
  public void removeBook(@PathVariable Long id) {
    bookService.delete(id);
  }

  @PutMapping("")
  public void updateBook(@RequestBody Book book) {
    bookService.update(book);
  }

}
