package com.api.opendata.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Optional;

public enum MovieEnum {

    OPENSORT("open", "상영영화 개봉순"),
    POINTSORT("point", "상영영화 평점순"),
    LIKESORT("likeCount", "상영영화 좋아요순");

    private String code;
    private String codeName;

    MovieEnum(String code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

    public String getCode() {
        return code;
    }

    public String getCodeName() {
        return codeName;
    }

    //코드성 데이터 배열 생성
    public static MovieEnum[] createMovieCode() {
        return MovieEnum.class.getEnumConstants();
    }

    //특정 코드가 존재여부 확인
    public static boolean existMovieCodeName(MovieEnum[] movieCodes, String codeName) {
        MovieEnum movieEnum = findMovieCodeName(movieCodes, codeName);

        return movieEnum.getCodeName() == codeName;
    }

    //특정 코드 데이터 찾기
    public static MovieEnum findMovieCodeName(MovieEnum[] movieCodes, String codeName) {
        MovieEnum movieEnum = Arrays.stream(movieCodes).filter(f -> f.codeName.equals(codeName)).findFirst().orElse(null);

        return movieEnum;
    }
}
