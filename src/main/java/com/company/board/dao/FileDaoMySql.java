package com.company.board.dao;

import com.company.board.vo.UploadFile;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileDaoMySql implements FileDao {

    @Autowired
    SqlSession sqlSession;

    String dao = "file.";

    @Override
    public int insertFile(UploadFile fileObj) throws Exception {
        int file = 0;
        file = sqlSession.insert(dao+"insertFile", fileObj);
        return file;
    }

    @Override
    public UploadFile selectFile(int bno) throws Exception {
        UploadFile file = null;
        file = sqlSession.selectOne(dao+"selectFile", bno);
        return file;
    }

    @Override
    public int deleteFile(int bno) throws Exception {
        int file = 0;
        file = sqlSession.delete(dao+"deleteFile", bno);
        return file;
    }
}
