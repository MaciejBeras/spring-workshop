package pl.coderslab;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;


public interface BookService {

    List<Book> getBooks();
    Optional<Book> get(Long id);
    void add(Book book);
    void delete(Long id);
    void update(Book book);

  }

