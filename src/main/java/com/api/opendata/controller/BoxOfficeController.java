package com.api.opendata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.opendata.service.BoxOfficeService;

import java.util.HashMap;

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
@RequestMapping("/api/boxoffice/*")
public class BoxOfficeController {
    @Autowired
    private BoxOfficeService boxOfficeService;

    @RequestMapping("/search")
    public HashMap<String, String> SearchBoxOffice(@RequestParam String targetDt)
    {
        HashMap<String, String> result;

        result = boxOfficeService.RunSearch(targetDt);

        return result;
    }
}



