package org.iesfm.library.dao.jdbc;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class JDBCBookDAO {
    private NamedParameterJdbcTemplate jdbc;

    public JDBCBookDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
