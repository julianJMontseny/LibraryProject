package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Member;
import org.iesfm.library.dao.MemberDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.Map;

public class JDBCMemberDAO implements MemberDAO {

    private NamedParameterJdbcTemplate jdbc;

    private final String SELECT_SOCIO = "SELECT * FROM member " +
                                        "WHERE nif = :nif";

=======
import java.util.List;

public class JDBCMemberDAO implements MemberDAO {
    private NamedParameterJdbcTemplate jdbc;

>>>>>>> 8d4ba4dd3f189e25e19c9c6dd3603ef55a9e12bf
    public JDBCMemberDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

<<<<<<< HEAD
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
=======
    private final static String SELECT_MEMBER = "SELECT * FROM member";

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
>>>>>>> 8d4ba4dd3f189e25e19c9c6dd3603ef55a9e12bf
