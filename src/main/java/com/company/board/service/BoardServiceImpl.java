package com.company.board.service;

import com.company.board.annotation.DataSource;
import com.company.board.dao.BoardDao;
import com.company.board.common.Types;
import com.company.board.vo.Board;
import com.company.board.vo.Criteria;
import com.company.board.vo.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    BoardDao boardDAO;

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public List<Board> selectSearchBoard(Search search, Criteria cri) throws Exception {
        if(cri == null) {
            throw new NullPointerException("해당 값은 null 입니다.");
        }

        Map<String, String> param = new HashMap<String, String>(); // 검색 조건과 페이징 관련 데이터를 담기 위한 map

        // sql문에 보낼 페이지 count (limit)
        int count = (cri.getPageNum()-1)*(cri.getAmount());
        cri.setCount(count);

        // 파라미터로 보내진 search가 null이 아니면 map에 담아준다.
        if(search != null) {
            param.put("search", search.getSearch());
            param.put("type", search.getType());
        }

        // 파라미터로 보내진 cri가 null이 아니면 map에 담아준다.
        if (cri != null) {
            param.put("pageNum", Integer.toString(cri.getPageNum()));
            param.put("amount", Integer.toString(cri.getAmount()));
            param.put("count", Integer.toString(cri.getCount()));
        }

        List<Board> boardList = boardDAO.selectSearchBoard(param);

        return boardList;
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public Board selectOneBoard(int bno) throws Exception {
        if(bno <= 0) {
            throw new NullPointerException("해당 값이 존재하지 않습니다.");
        }

        Board board = boardDAO.selectOneBoard(bno);

        return board;
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public int selectMaxBno() throws Exception {

        int bno = boardDAO.selectMaxBno();

        return bno;
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public int getTotal(Search search) throws Exception {

        int total = boardDAO.getTotalCount(search);

        return total;
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public boolean insertBoard(Board board) throws Exception {
        if(board == null) {
            throw new NullPointerException("해당 값은 null 입니다.");
        }

        int insertBoard = boardDAO.insertBoard(board);

        boolean result = (insertBoard >= 1) ? true : false;

        return result;
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public boolean updateBoard(Board board) throws Exception {
        if(board == null) {
            throw new NullPointerException("해당 값은 null 입니다.");
        }

        int updateBoard = boardDAO.updateBoard(board);

        boolean result = (updateBoard >= 1) ? true : false;

        return result;
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public int deleteBoard(int bno) throws Exception {
        if(bno <= 0) {
            throw new NullPointerException("해당 값이 존재하지 않습니다.");
        }

        int deleteBoard = boardDAO.deleteBoard(bno);

        if(deleteBoard <= 0) {
            throw new Exception("삭제가 제대로 이루어지지 않았습니다.");
        }

        return deleteBoard;
    }
}
