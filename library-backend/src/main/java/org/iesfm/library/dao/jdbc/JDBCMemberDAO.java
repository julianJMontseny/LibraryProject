package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Member;
import org.iesfm.library.dao.MemberDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

public class JDBCMemberDAO implements MemberDAO {

    private NamedParameterJdbcTemplate jdbc;

    private final String SELECT_SOCIO = "SELECT * FROM member " +
                                        "WHERE nif = :nif";

    public JDBCMemberDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Member getMember(String nif) {
        Map <String, Object> params = new HashMap<>();
        params.put("nif", nif);

        return jdbc.queryForObject(
                SELECT_SOCIO,
                params,
                (rs, rowNum) -> new Member(
                        rs.getString("nif"),
                        rs.getString("name"),
                        rs.getString("surname")
                )
        );
    }
}
