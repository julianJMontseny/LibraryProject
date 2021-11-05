package org.iesfm.library.dao;

import org.iesfm.library.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface BookDAO {


    List<Book> bookListByYear(int year);

    void bookModify(Book book);

<<<<<<< HEAD
    void insert (Book book);

    List<Book> listAll();
}
=======
    List<Book> listAll();

    List<Book> lookForBookWithAuthor(String author);
    }
>>>>>>> b9c871164b6800e1eb1a5a79a19e279d9f797780
