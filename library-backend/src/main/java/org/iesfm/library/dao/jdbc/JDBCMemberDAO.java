package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Member;
import org.iesfm.library.dao.MemberDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCMemberDAO implements MemberDAO {

    private final static String INSERT_MEMBER =
            "INSERT INTO member(" +
                    "nif," +
                    "name," +
                    "surname)" +
                    "VALUES(:nif," +
                    ":name," +
                    ":surname)";

    private NamedParameterJdbcTemplate jdbc;

    public JDBCMemberDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final static String SELECT_MEMBER = "SELECT * FROM member";

    @Override
    public List<Member> list() {
        return null;
    }



    @Override
    public void insert(Member member) {
        Map<String,Object> memberParams = new HashMap<>();
        memberParams.put("nif",member.getNif());
        memberParams.put("name",member.getName());
        memberParams.put("surname",member.getSurname());
        jdbc.update(INSERT_MEMBER,memberParams);
    }
}