package com.api.opendata.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.mybatis.spring.SqlSessionTemplate;
import com.api.opendata.model.boxoffice.*;

import java.util.List;

@Repository
public class BoxOfficeDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SqlSessionTemplate sqlSession;

    public List<MovieListModel.Movie> SearchMovie() {
        String query = "SELECT * FROM tbl_Movie";

        return jdbcTemplate.query(query, new BeanPropertyRowMapper<MovieListModel.Movie>(MovieListModel.Movie.class));
    }

    public List<MovieVO> SearchMovieMyBatis() {

        return sqlSession.selectList("BoxOfficeDao.searchMovie");
    }
}
