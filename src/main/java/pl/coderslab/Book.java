package pl.coderslab;

import lombok.Data;
@Data
public class Book {

  private Long id;
  private String isbn;
  private String title;
  private String author;
  private String publisher;
  private String type;

  public Book(Long id, String isbn, String title, String author, String publisher, String type) {
    this.id = id;
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.type = type;
  }
}