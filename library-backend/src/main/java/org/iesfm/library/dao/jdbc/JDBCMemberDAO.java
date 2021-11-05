package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Member;
import org.iesfm.library.dao.MemberDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class JDBCMemberDAO implements MemberDAO {

    private NamedParameterJdbcTemplate jdbc;

    private final String SELECT_SOCIO = "SELECT * FROM member " +
                                        "WHERE nif = :nif";

    private final static String SELECT_MEMBER = "SELECT * FROM member";

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

    @Override
    public List<Member> list() {
        return jdbc.query(
                SELECT_MEMBER,
                (rs, n) ->
                        new Member(
                                rs.getString("nif"),
                                rs.getString("name"),
                                rs.getString("surname")
                        )
        );
    }
}

