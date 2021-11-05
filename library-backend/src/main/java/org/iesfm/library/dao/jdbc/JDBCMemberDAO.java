package org.iesfm.library.dao.jdbc;

import org.iesfm.library.Member;
import org.iesfm.library.dao.MemberDAO;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

public class JDBCMemberDAO implements MemberDAO {
    private NamedParameterJdbcTemplate jdbc;

    public JDBCMemberDAO(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final static String SELECT_MEMBER = "SELECT * FROM member";

    @Override
    public List<Member> list() {
        return null;
    }
}