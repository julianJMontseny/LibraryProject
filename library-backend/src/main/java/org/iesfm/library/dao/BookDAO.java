package org.iesfm.library.dao;

import org.iesfm.library.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface BookDAO {


    List<Book> bookListByYear(int year);

    void bookModify();

    public List<Book> listAll();

    public List<Book> lookForBookWithAuthor(String author);
    }
