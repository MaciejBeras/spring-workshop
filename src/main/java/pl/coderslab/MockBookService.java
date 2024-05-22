package pl.coderslab;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Getter
@Setter
@Component
@Service
public class MockBookService implements BookService {

  private List<Book> books;
  private static Long nextId = 11L;


  public MockBookService() {
    books = new ArrayList<>();
    books.add(new Book(1L, "978-3-16-148410-0", "Władca Pierścieni: Drużyna Pierścienia",
        "J.R.R. Tolkien", "Wydawnictwo Muza", "Fantasy"));
    books.add(new Book(2L, "978-0-7432-7356-5", "Kod Leonarda da Vinci", "Dan Brown",
        "Wydawnictwo Sonia Draga", "Thriller"));
    books.add(new Book(3L, "978-83-240-5672-7", "Złodziejka książek", "Markus Zusak",
        "Wydawnictwo Nasza Księgarnia", "Powieść historyczna"));
    books.add(new Book(4L, "978-83-7758-595-4", "Gra o tron", "George R.R. Martin",
        "Wydawnictwo Zysk i S-ka", "Fantasy"));
    books.add(
        new Book(5L, "978-83-8129-615-0", "Małe życie", "Hanya Yanagihara", "Wydawnictwo W.A.B.",
            "Powieść obyczajowa"));
    books.add(
        new Book(6L, "978-83-287-1420-2", "Sapiens: Od zwierząt do bogów", "Yuval Noah Harari",
            "Wydawnictwo Literackie", "Non-fiction"));
    books.add(new Book(7L, "978-83-287-1626-8", "Hobbit, czyli tam i z powrotem", "J.R.R. Tolkien",
        "Wydawnictwo Zysk i S-ka", "Fantasy"));
    books.add(new Book(8L, "978-83-8125-086-2", "Zapiski z małej wyspy", "Bill Bryson",
        "Wydawnictwo Zysk i S-ka", "Podróżnicza"));
    books.add(new Book(9L, "978-83-7839-515-6", "Pachnidło", "Patrick Süskind",
        "Wydawnictwo Świat Książki", "Powieść"));
    books.add(
        new Book(10L, "978-83-8125-734-2", "Cień wiatru", "Carlos Ruiz Zafón", "Wydawnictwo Muza",
            "Powieść"));
  }

  @Override
  public List<Book> getBooks() {
    return books;
  }

  @Override
  public Optional<Book> get(Long id) {

    return books.stream()
        .filter(item -> item.getId()
            .equals(id))
        .findFirst();
  }

  @Override
  public void add(Book book) {
    book.setId(nextId++);
    books.add(book);
  }

  @Override
  public void delete(Long id) {
    if (get(id).isPresent()) {
      books.remove(this.get(id).get());
    }
  }

  @Override
  public void update(Book book) {
    if(this.get(book.getId()).isPresent()){
      int indexOf = books.indexOf(this.get(book.getId()).get());
      books.set(indexOf, book);
    }

  }
}
