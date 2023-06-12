package com.company.board.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Search {
    private String search; // 검색어
    private String type; // 검색 옵션
}
