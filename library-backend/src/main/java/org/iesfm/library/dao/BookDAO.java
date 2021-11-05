package org.iesfm.library.dao;
import org.iesfm.library.Book;

import java.util.List;

public interface BookDAO {

    List<Book> bookListByYear(int year);

    void bookModify();

    void insert(Book book);

    List<Book> listAll();

    List<Book> lookForBookWithAuthor(String author);
}


