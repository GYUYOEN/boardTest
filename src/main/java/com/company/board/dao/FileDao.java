package com.company.board.dao;

import com.company.board.vo.UploadFile;

public interface FileDao {
    int insertFile(UploadFile fileObj) throws Exception;

    UploadFile selectFile(int bno) throws Exception;

    int deleteFile(int bno) throws Exception;
}
