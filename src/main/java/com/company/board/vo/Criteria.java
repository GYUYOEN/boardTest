package com.company.board.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Criteria {
    private int pageNum; // 페이지 번호
    private int amount; // 한 페이지 당 몇 개의 데이터를 보여 줄 것인지
    private int count;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }
}
