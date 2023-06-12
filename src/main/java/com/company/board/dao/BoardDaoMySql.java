package com.company.board.dao;

import com.company.board.vo.Board;
import com.company.board.vo.Criteria;
import com.company.board.vo.Search;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoMySql implements BoardDao {
    @Autowired
    private SqlSession sqlSession;

    String dao = "boards.";

    @Override
    public Board selectOneBoard(int bno) throws Exception {
        Board board = null;
        board = sqlSession.selectOne(new StringBuilder().append(dao).append("selectOneBoard").toString(), bno);
        return board;
    }

    @Override
    public List<Board> selectSearchBoard(Map<String, String> param) throws Exception {
        List<Board> boardList = null;
        boardList = sqlSession.selectList(new StringBuilder().append(dao).append("selectSearchBoard").toString(), param);
        return boardList;
    }

    @Override
    public int selectMaxBno() throws Exception {
        int bno = 0;
        bno = sqlSession.selectOne(dao+"selectMaxBno", "");
        return bno;
    }

    @Override
    public int getTotalCount(Search search) throws Exception {
        int total = 0;
        total = sqlSession.selectOne(dao+"getTotalCount", search);
        return total;
    }

    @Override
    public int insertBoard(Board board) throws Exception {
        int result = 0;
        result = sqlSession.insert(dao+"insertBoard", board);
        return result;
    }

    @Override
    public int updateBoard(Board board) throws Exception {
        int result = 0;
        result = sqlSession.update(dao+"updateBoard", board);
        return result;
    }

    @Override
    public int deleteBoard(int bno) throws Exception {
        int result = 0;
        result = sqlSession.delete(dao+"deleteBoard", bno);
        return result;
    }
}
