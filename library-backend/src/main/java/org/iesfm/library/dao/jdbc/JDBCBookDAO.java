package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Book;
<<<<<<< HEAD
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCBookDAO {
=======
import org.iesfm.library.dao.BookDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class JDBCBookDAO implements BookDAO {
>>>>>>> 85c927b3fc4b76f4444e36289229a9ef121858f2
    private NamedParameterJdbcTemplate jdbc;
    private static final String SELECT_BOOK_BY_YEAR = "SELLECT * FROM BOOK WHERE year = :year ";


    public JDBCBookDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

<<<<<<< HEAD
    public List<Book> bookListByYear(int year) {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);

        return jdbc.query(SELECT_BOOK_BY_YEAR, params, ((rs, rowNum) -> new Book(
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year")
        )));


=======
    @Override
    public void bookModify() {

    }

    @Override
    public List<Book> bookListByYear() {
        return null;
>>>>>>> 85c927b3fc4b76f4444e36289229a9ef121858f2
    }
}

