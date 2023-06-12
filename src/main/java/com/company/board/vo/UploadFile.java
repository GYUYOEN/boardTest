package com.company.board.vo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UploadFile {
    private int fno;
    private String originalFileName;
    private String fileName;
    private String filePath;
    private Long fileSize;
}
