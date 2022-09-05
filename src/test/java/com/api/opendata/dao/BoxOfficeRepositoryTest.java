package com.api.opendata.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.assertThat;
import com.api.opendata.model.boxoffice.MovieVO;
import java.util.List;
import java.util.stream.Collectors;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BoxOfficeRepositoryTest {
    @Autowired
    private BoxOfficeRepository boxOfficeRepository;

    @BeforeAll
    static void beforeAll() {
        System.out.println("JUnit - @BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("JUnit - @AfterAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("JUnit - @BeforeEach");
    }

    @AfterEach
    void afterEach() {
        System.out.println("JUnit - @AfterEach");
    }

    @Test
    void findAllTest() {
        //given
        List<MovieVO> movieList = boxOfficeRepository.findAll();

        //when
        List<MovieVO> actionList = movieList.stream().filter(f -> "액션".equals(f.getRepGenreNm())).collect(Collectors.toList());

        //then
        assertThat(actionList)
                .isNotEmpty()
                .hasSize(2);
    }

    @Test
    void test2() {
        System.out.println("JUnit - @Test test2");
    }

    @Test
    @Disabled
    void disabled_test() {
        System.out.println("JUnit - @Test @Disabled");
    }
}