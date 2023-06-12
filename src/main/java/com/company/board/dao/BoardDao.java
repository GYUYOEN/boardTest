package com.company.board.dao;

import com.company.board.vo.Board;
import com.company.board.vo.Criteria;
import com.company.board.vo.Search;

import java.util.List;
import java.util.Map;

public interface BoardDao {

    // 검색 조회
    List<Board> selectSearchBoard(Map<String, String> param) throws Exception;

    // 하나 조회
    Board selectOneBoard(int bno) throws Exception;

    // 가장큰 게시판 번호(bno) 조회
    int selectMaxBno() throws Exception;

    // 전체 데이터 개수
    int getTotalCount(Search search) throws Exception;

    // 추가
    int insertBoard(Board board) throws Exception;

    // 수정
    int updateBoard(Board board) throws Exception;

    // 삭제
    int deleteBoard(int bno) throws Exception;
}
