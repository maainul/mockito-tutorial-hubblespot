# mockito-tutorial-hubblespot
![Screenshot from 2021-02-17 16-53-46](https://user-images.githubusercontent.com/37740006/108393393-ccd4c600-723d-11eb-9ed9-5de85f3a5066.png)

# What is Junit?


# What is TestDoubles ?
External dependencies should be removed from the unit tests by replacing real objects with their fake replacements called as Test Doubles
![Screenshot from 2021-02-17 16-27-26](https://user-images.githubusercontent.com/37740006/108392669-225ca300-723d-11eb-8e22-33b16c1a4def.png)

# Types of TestDoubles
![Screenshot from 2021-02-17 16-28-31](https://user-images.githubusercontent.com/37740006/108392457-f0e3d780-723c-11eb-97e7-bea8eff708d7.png)
# Why we need External fake or dummy data?

![Screenshot from 2021-02-17 16-19-32](https://user-images.githubusercontent.com/37740006/108393480-e8d86780-723d-11eb-841f-f5bc61b7acae.png)


# 2. Fake
![Screenshot from 2021-02-17 16-51-47](https://user-images.githubusercontent.com/37740006/108392966-63ed4e00-723d-11eb-862c-92a7f42739ab.png)

Terminology of Fake
![Screenshot from 2021-02-17 16-52-32](https://user-images.githubusercontent.com/37740006/108393168-99923700-723d-11eb-8417-d9d7957128f2.png)

# Steps TO be Followed for the Fake
Service Class:
```java
package com.mainul.mockito.test_doubles.fake;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book){
        bookRepository.save(book);
    }

    public int findNumberOfBooks(){
        return bookRepository.findAll().size();
    }

}
```
Repository Class
```java
package com.mainul.mockito.test_doubles.fake;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);

    Collection<Book> findAll();
}

```
Book class / Entity Class
```java
package com.mainul.mockito.test_doubles.fake;

import java.time.LocalDate;

public class Book {
    private String bookId;
    private String title;
    private int price;
    private LocalDate publishdDate;

    public Book(String bookId, String title, int price, LocalDate publishdDate) {
        this.bookId = bookId;
        this.title = title;
        this.price = price;
        this.publishdDate = publishdDate;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getPublishdDate() {
        return publishdDate;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPublishdDate(LocalDate publishdDate) {
        this.publishdDate = publishdDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", publishdDate=" + publishdDate +
                '}';
    }
}

```
FakeBook class for testing purpose
```java
package com.mainul.mockito.test_doubles.fake;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FakeBookRepository implements BookRepository{

    Map<String,Book> bookStore = new HashMap<>();



    @Override
    public void save(Book book) {
        bookStore.put(book.getBookId(),book);

    }

    @Override
    public Collection<Book> findAll() {
        return bookStore.values();
    }
}

```
FakeTest Class
```java
package com.mainul.mockito.test_doubles.fake;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;


public class FakeTest {
    @Test
    public void testFake() {
        BookRepository bookRepository = new FakeBookRepository();
        BookService bookService = new BookService(bookRepository);

        bookService.addBook(new Book("1234", "Mockito In Action", 250, LocalDate.now()));
        bookService.addBook(new Book("1235", "JUnit 5 In Action", 200, LocalDate.now()));

        assertEquals(2,bookService.findNumberOfBooks());
    }
}
```