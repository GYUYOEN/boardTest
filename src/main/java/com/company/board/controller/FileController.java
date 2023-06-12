package com.company.board.controller;

import com.company.board.service.FileService;
import com.company.board.vo.UploadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletResponse;

@RequestMapping("/file")
@Controller
@Slf4j
public class FileController {

    @RequestMapping("/upload.do")
    public String upload() {
        return "/file/upload";
    }

    @Autowired
    FileService fileService;

    @ResponseBody
    @RequestMapping("/download.do")
    public void download(HttpServletResponse response, int bno) throws Exception {
        // 게시판 번호를 이용해서 file 조회
        UploadFile uploadFile = fileService.selectFile(bno);

        // 해당 파일이 존재하면 다운로드 진행
        if (uploadFile != null && uploadFile.getFileSize() > 0) {
            fileService.fileDownload(response, uploadFile);
        }
    }
}
