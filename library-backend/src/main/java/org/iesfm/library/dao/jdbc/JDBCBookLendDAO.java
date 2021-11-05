package org.iesfm.library.dao.jdbc;

import org.iesfm.library.BookLend;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCBookLendDAO {

    private NamedParameterJdbcTemplate jdbc;
    private static final String SELECT_BOOKLEND_BY_NIF = "SELLECT * FROM book_lend WHERE nif = :nif ";

    public JDBCBookLendDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

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

    public void insert(BookLend booklend) {
        Map<String, Object> params = new HashMap<>();
        params.put("nif", booklend.getNif());
        params.put("isbn", booklend.getIsbn());
        params.put("lend_date", booklend.getLendDate());
        params.put("status_id", booklend.getStatusId());
        jdbc.update(INSERT_BOOKLEND, params);
    }


    public List<BookLend> listBookLendByNif(String nif){
        Map<String, Object> params = new HashMap<>();
        params.put("nif", nif);
        return jdbc.query(SELECT_BOOKLEND_BY_NIF, params, (rs, n) -> new BookLend(
                rs.getString("nif"),
                rs.getString("isbn"),
                rs.getDate("lend_date"),
                rs.getDate("return_date"),
                rs.getInt("status_id")
        ) );
    }

}
