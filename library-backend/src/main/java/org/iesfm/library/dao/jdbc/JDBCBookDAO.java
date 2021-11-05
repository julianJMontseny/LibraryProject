package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Book;
import org.iesfm.library.dao.BookDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class JDBCBookDAO implements BookDAO {
    private NamedParameterJdbcTemplate jdbc;

    public JDBCBookDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void bookModify() {

    }

    @Override
    public List<Book> bookListByYear() {
        return null;
    }
}
