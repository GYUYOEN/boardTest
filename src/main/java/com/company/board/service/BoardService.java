package com.company.board.service;

import com.company.board.vo.Board;
import com.company.board.vo.Criteria;
import com.company.board.vo.Search;

import java.util.List;

public interface BoardService {

    List<Board> selectSearchBoard(Search search, Criteria cri) throws Exception;

    Board selectOneBoard(int bno) throws Exception;

    int selectMaxBno() throws Exception;

    int getTotal(Search search) throws Exception;

    boolean insertBoard(Board board) throws Exception;

    boolean updateBoard(Board brd) throws Exception;

    int deleteBoard(int bno) throws Exception;

}
