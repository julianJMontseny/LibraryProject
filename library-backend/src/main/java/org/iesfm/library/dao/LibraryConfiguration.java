package org.iesfm.library.dao;

import org.iesfm.library.dao.jdbc.JDBCMemberDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class LibraryConfiguration {

    @Bean
    public NamedParameterJdbcTemplate jdbc(DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean
    public MemberDAO jdbcMemberDao(NamedParameterJdbcTemplate jdbc){
        return new JDBCMemberDAO(jdbc);
    }

}
