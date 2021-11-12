package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Member;
import org.iesfm.library.dao.MemberDAO;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCMemberDAO implements MemberDAO {

    private NamedParameterJdbcTemplate jdbc;

    public JDBCMemberDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final static String SELECT_MEMBERS = "SELECT * FROM member";

    private final static String INSERT_MEMBER =
            "INSERT INTO member(" +
                    "nif," +
                    "name," +
                    "surname)" +
                    "VALUES(:nif," +
                    ":name," +
                    ":surname)";

    private final static String SELECT_MEMBER = "SELECT * FROM member " +
            "WHERE nif = :nif";

    @Override
    public List<Member> list() {
        return jdbc.query(
                SELECT_MEMBERS,
                (rs, n) ->
                        new Member(
                                rs.getString("nif"),
                                rs.getString("name"),
                                rs.getString("surname")
                        )
        );
    }


    @Override
    public void insert(Member member) {
        Map<String, Object> memberParams = new HashMap<>();
        memberParams.put("nif", member.getNif());
        memberParams.put("name", member.getName());
        memberParams.put("surname", member.getSurname());
        jdbc.update(INSERT_MEMBER, memberParams);
    }

    @Override
    public Member getMember(String nif) {
        Map<String, Object> params = new HashMap<>();
        params.put("nif", nif);

        try {
            return jdbc.queryForObject(
                    SELECT_MEMBER,
                    params,
                    (rs, rowNum) -> new Member(
                            rs.getString("nif"),
                            rs.getString("name"),
                            rs.getString("surname")
                    )
            );
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }
}