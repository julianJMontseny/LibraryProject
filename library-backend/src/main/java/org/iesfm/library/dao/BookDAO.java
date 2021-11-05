package org.iesfm.library.dao;

import org.iesfm.library.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface BookDAO {

    public List<Book> bookListByYear();

    void bookModify();



}
