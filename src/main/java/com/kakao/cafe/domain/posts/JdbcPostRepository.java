package com.kakao.cafe.domain.posts;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

@Repository
public class JdbcPostRepository {
    private final static String INSERT_POST_SQL = "insert into post(writer, title, content, localdatetime ) values(?,?,?,?)";
    private final static String FIND_ID_SQL = "select id, writer, title, content, localdatetime from post where id = ?";
    private final static String FIND_WRITER_SQL = "select id, writer, title, content, localdatetime from post where writer = ?";
    private final static String FIND_POST_ALL_SQL = "select id, writer, title, content, localdatetime from post";
    private final static String UPDATE_POST_BY_WRITER_SQL = "update post set content = ? where writer = ?";
    private final static String DELETE_POST_BY_WRITER_SQL = "delete from post where writer = ?";
    private final JdbcTemplate jdbcTemplate;

    public JdbcPostRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void save(Post post) {
        post.setLocalDateTime(LocalDateTime.now());

        jdbcTemplate.update(INSERT_POST_SQL, post.getWriter(), post.getTitle(), post.getContents(), post.getLocalDateTime());;
    }

    public Post findById(Long id) {
        Post post = null;
        try {
            post = jdbcTemplate.query(FIND_ID_SQL, postRowMapper(), id)
                    .stream()
                    .findAny()
                    .orElseThrow(SQLException::new);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public Post findByWriter(String writer) {
        Post post = null;
        try {
            post = jdbcTemplate.query(FIND_WRITER_SQL, postRowMapper(), writer)
                    .stream()
                    .findAny()
                    .orElseThrow(SQLException::new);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }

    public List<Post> findAll() {
        return jdbcTemplate.query(FIND_POST_ALL_SQL, postRowMapper());
    }

    public void updatePost(String writer, Post post) {
        jdbcTemplate.update(UPDATE_POST_BY_WRITER_SQL, post.getContents(), writer);
    }

    public void deletePost(String writer) {
        jdbcTemplate.update(DELETE_POST_BY_WRITER_SQL, writer);
    }

    private RowMapper<Post> postRowMapper() {
        return (rs, rowNum) -> new Post(rs.getLong("id"), rs.getString("writer"),
                rs.getString("title"), rs.getString("content"),
                rs.getTimestamp("localdatetime").toLocalDateTime());
    }
}
