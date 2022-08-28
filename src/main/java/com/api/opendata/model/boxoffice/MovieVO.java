package com.api.opendata.model.boxoffice;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="tbl_Movie")
public class MovieVO {
    @Id
    @Column
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name = "repGenreNm", length = 30, nullable = true)
    private String repGenreNm;
    @Column(name = "movieNm", length = 300, nullable = true)
    private String movieNm;
}
