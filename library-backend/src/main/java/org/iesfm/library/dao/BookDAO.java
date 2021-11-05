package org.iesfm.library.dao;

import org.iesfm.library.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface BookDAO {


    List<Book> bookListByYear(int year);
     
    void bookModify();

    void insert (Book book);

}
