package org.iesfm.library.dao.jdbc;

import org.iesfm.library.BookLend;
import org.iesfm.library.dao.BookLendDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JDBCBookLendDAO implements BookLendDAO {
    private Scanner scanner;

    private final static String INSERT_BOOKLEND = "insert into book_lend(" +
            " nif, " +
            " isbn, " +
            " lend_date, " +
            " return_date, " +
            " status_id" +
            ")" +
            "VALUES (" +
            " :nif, " +
            " :isbn, " +
            " :lend_date, " +
            " :return_date, " +
            " :status_id " +
            ")";

    private NamedParameterJdbcTemplate jdbc;

    public JDBCBookLendDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void insert(BookLend booklend) {
        Map<String, Object> params = new HashMap<>();
        params.put("nif", booklend.getNif());
        params.put("isbn", booklend.getIsbn());
        params.put("lend_date", booklend.getLendDate());
        params.put("status_id", booklend.getStatusName());
        jdbc.update(INSERT_BOOKLEND, params);
    }


}
