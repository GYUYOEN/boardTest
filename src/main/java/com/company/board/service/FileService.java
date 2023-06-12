package com.company.board.service;

import com.company.board.vo.UploadFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface FileService {
    UploadFile uploadFile(MultipartFile mpfile, HttpServletRequest request, int maxBno) throws Exception;

    UploadFile selectFile(int bno) throws Exception;

    int deleteFile(int bno) throws Exception;

    void fileDownload(HttpServletResponse response, UploadFile uploadFile) throws Exception;
}
