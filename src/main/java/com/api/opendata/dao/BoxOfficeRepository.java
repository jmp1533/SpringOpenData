package com.api.opendata.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.api.opendata.model.boxoffice.MovieVO;

@Repository
public interface BoxOfficeRepository extends JpaRepository<MovieVO, String> {
}
