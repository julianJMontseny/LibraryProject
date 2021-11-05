package org.iesfm.library.dao;

import org.iesfm.library.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public interface BookDAO {

<<<<<<< HEAD
     List<Book> bookListByYear();
=======
    public List<Book> bookListByYear();

    void bookModify();


>>>>>>> 85c927b3fc4b76f4444e36289229a9ef121858f2

}
