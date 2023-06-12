package com.company.board.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Board {
     private int bno;
     private String title;
     private String writer;
     private String regdate;
     private String moddate;
     private String content;
/*
     public void incBno(int bno) throws Exception {
          this.bno = bno + 1;
          if(Integer.MAX_VALUE <= bno) {
               this.bno = Integer.MAX_VALUE;
          }
     }
 */
}
