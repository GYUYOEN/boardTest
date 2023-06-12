package com.company.board.service;

import com.company.board.annotation.DataSource;
import com.company.board.common.Types;
import com.company.board.dao.FileDao;
import com.company.board.vo.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    FileDao fileDao;

    @Value("${path}")
    String filePath;

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public UploadFile uploadFile(MultipartFile mpfile, HttpServletRequest request, int maxBno) throws Exception {
        long fileSize = mpfile.getSize();

        if(maxBno <= 0) {
            throw new NullPointerException("해당 값이 존재하지 않습니다.");
        }

        // 1. 파일용량 체크
        if (fileSize > 10 * 1024 * 1024) {
            throw new Exception("파일 크기는 10MB 이하로 등록해주세요.");
        }

        String name = mpfile.getOriginalFilename();

        String extension = name.substring(name.lastIndexOf(".") + 1).toLowerCase(); // 확장자를 이용해서 폴더 이름 만들기

        String renameFileName = renameFile(name); // UUID를 이용해서 파일이름 raname

        UploadFile fileObj = new UploadFile();
        fileObj.setOriginalFileName(name);
        fileObj.setFileName(renameFileName);
        fileObj.setFileSize(mpfile.getSize());
        fileObj.setFno(maxBno);

        StringBuilder stringBuilder = new StringBuilder();
//      String path = stringBuilder.append("/upload/").append(extension).toString(); // 리눅스
        String path = stringBuilder.append(filePath).append(extension).toString(); // 윈도우

        fileObj.setFilePath(path);

        File storage = new File(path);

        // 해당 폴더가 존재하지 않으면 만들어줌
        if(!storage.exists()) {
            storage.mkdir();
        }

        File newFile = new File(path+"/"+renameFileName);

        // 해당 파일이 존재하지 않으면 만들어줌
        if(!newFile.exists()) {
            newFile.createNewFile();
        }

        try (
                InputStream inputStream = mpfile.getInputStream();
                OutputStream outputStream = new FileOutputStream(newFile);
        ) {
            int read = 0;
            byte[] b = new byte[(int)mpfile.getSize()];

            while ((read=inputStream.read(b)) != -1) {
                outputStream.write(b, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        int result = fileDao.insertFile(fileObj);

        if(result <= 0) {
            throw new Exception("파일 insert 처리가 제대로 이루어지지 않았습니다.");
        }

        return fileObj;
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public void fileDownload(HttpServletResponse response, UploadFile uploadFile) throws Exception {
        String fileName = uploadFile.getFileName();

        String extension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase(); // 확장자를 이용해서 폴더 이름 만들기

        StringBuilder stringBuilder = new StringBuilder();
        //  String path = stringBuilder.append("/upload/").append(extension).append("/").append(fileName).toString(); // 리눅스
        String path = stringBuilder.append("D:/upload/").append(extension).append("/").append(fileName).toString(); // 윈도우

        File file = new File(path);
        long fileLength = file.length();
        //파일의 크기와 같지 않을 경우 프로그램이 멈추지 않고 계속 실행되거나, 잘못된 정보가 다운로드 될 수 있다.

        response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(uploadFile.getOriginalFileName(),"UTF-8")+"\";");
        response.setHeader("Content-Transfer-Encoding", "binary");
        response.setHeader("Content-Length", "" + fileLength);
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");

        try(
                FileInputStream inputStream = new FileInputStream(path);
                OutputStream outputStream = response.getOutputStream();
        ) {
            int readCount = 0;
            byte[] buffer = new byte[1024];
            while((readCount = inputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,readCount);
            }
        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public UploadFile selectFile(int bno) throws Exception {
        if(bno <= 0) {
            throw new NullPointerException("해당 값이 존재하지 않습니다.");
        }

        UploadFile file = fileDao.selectFile(bno);

        return file;
    }

    @Override
    @DataSource(type = Types.DataSourceType.COMMON)
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {Throwable.class})
    public int deleteFile(int bno) throws Exception {
        if(bno <= 0) {
            throw new NullPointerException("해당 값이 존재하지 않습니다.");
        }

        // 파일 가져오기 -> 파일 경로 알기 위해
        UploadFile uploadFile = fileDao.selectFile(bno);

        // 파일 경로 설정
        StringBuilder stringBuilder = new StringBuilder();
        String path = stringBuilder.append(uploadFile.getFilePath()).append("/").append(uploadFile.getFileName()).toString();
        File file = new File(path);

        // 파일이 존재하면 삭제하기
        if(file.exists()) {
            file.delete();
        }

        int result = fileDao.deleteFile(bno);

        if(result <= 0) {
            throw new Exception("해당 삭제 작업이 제대로 이루어지지 않았습니다.");
        }

        return result;
    }

    private String renameFile(String originalName) {
        // uuid 생성
        UUID uuid = UUID.randomUUID();

        // 랜덤생성+파일이름 저장
        String savedName = uuid.toString()+"_"+originalName;

        return savedName;
    }
}
