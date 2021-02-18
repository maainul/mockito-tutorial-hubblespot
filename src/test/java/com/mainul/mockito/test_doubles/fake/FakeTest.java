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
