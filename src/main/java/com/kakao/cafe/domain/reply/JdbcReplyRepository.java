package com.kakao.cafe.domain.reply;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JdbcReplyRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcReplyRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public List<Reply> findAllByPostId(Long id) {
        final String sql = "select post_id, writer, contents, create_time from reply where post_id = ?";
        return jdbcTemplate.query(sql, replyRowMapper(), id);
    }

    private RowMapper<Reply> replyRowMapper() {
        return (rs, rowNum) -> new Reply(rs.getLong("post_id"),
                rs.getString("writer"),
                rs.getString("contents"),
                rs.getTimestamp("create_time").toLocalDateTime());
    }
}
