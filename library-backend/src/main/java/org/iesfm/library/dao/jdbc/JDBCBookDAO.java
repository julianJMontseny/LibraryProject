package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Book;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCBookDAO {
    private NamedParameterJdbcTemplate jdbc;
    private static final String SELECT_BOOK_BY_YEAR = "SELLECT * FROM BOOK WHERE year = :year ";


    public JDBCBookDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Book> bookListByYear(int year) {
        Map<String, Object> params = new HashMap<>();
        params.put("year", year);

        return jdbc.query(SELECT_BOOK_BY_YEAR, params, ((rs, rowNum) -> new Book(
                rs.getString("isbn"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getInt("year")
        )));


    }
}

