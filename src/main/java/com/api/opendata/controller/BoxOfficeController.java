package com.api.opendata.controller;

import com.api.opendata.model.boxoffice.DailyBoxOfficeModel;
import com.api.opendata.service.BoxOfficeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * 영화박스오피스 DB (일 3000회 제한)
 * 일별 박스오피스
 * 주간/주말 박스오피스
 * 공통코드 조회
 * 영화목록
 * 영화 상세정보
 * 영화사목록
 * 영화사 상세정보
 * 영화인목록
 * 영화인 상세정보
 */
@RestController
public class BoxOfficeController {

    @RequestMapping("/api/boxOffice")
    public String SearchBoxOffice(@RequestParam String targetDt)
    {
        String result = "";
        BoxOfficeService boxOffice = new BoxOfficeService();

        result = boxOffice.RunSearch(targetDt);

        return result;
    }
}

