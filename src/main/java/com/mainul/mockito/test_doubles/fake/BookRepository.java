package com.mainul.mockito.test_doubles.fake;

import java.util.Collection;

public interface BookRepository {
    void save(Book book);

    Collection<Book> findAll();
}
