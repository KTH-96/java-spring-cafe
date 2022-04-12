package com.kakao.cafe.domain.user;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcUserRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final static String INSERT_USER_SQL = "insert into user(user_id, password, name, email) values(?,?,?,?)";
    private final static String FIND_ID_SQL = "select id, user_id, password, name, email from user where id = ?";
    private final static String FIND_USERID_SQL = "select id, user_id, password, name, email from user where user_id = ?";
    private final static String FIND_USER_ALL_SQL = "select id, user_id, password, name, email from user";
    private final static String UPDATE_USER_BY_ID_SQL = "update user set name = ?, email = ? where id = ?";

    public void save(User user) {
        jdbcTemplate.update(INSERT_USER_SQL, user.getUserId(), user.getPassword(), user.getName(), user.getEmail());
    }

    public Optional<User> findById(Long id) {
        return jdbcTemplate.query(FIND_ID_SQL, userRowMapper(), id).stream()
                .findAny();
    }

    public Optional<User> findByUserId(String userId) {
        return jdbcTemplate.query(FIND_USERID_SQL, userRowMapper(), userId)
                .stream()
                .findAny();
    }

    public List<User> findAll() {
        return jdbcTemplate.query(FIND_USER_ALL_SQL, userRowMapper());
    }

    public void updateUser(Long id, User user) {
        jdbcTemplate.update(UPDATE_USER_BY_ID_SQL, user.getName(), user.getEmail(), id);
    }

    private RowMapper<User> userRowMapper() {
        return (rs, rowNum) -> {
            User user = new User();
            user.setMapper(rs.getLong("id"), rs.getString("user_id"),
                    rs.getString("password"), rs.getString("name"),
                    rs.getString("email"));
            return user;
        };
    }
}
