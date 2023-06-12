package com.company.board.controller;

import com.company.board.service.BoardService;
import com.company.board.service.FileService;
import com.company.board.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RequestMapping("/board")
@Controller
@Slf4j
public class BoardController {

    @Autowired
    BoardService boardService;

    @Autowired
    FileService fileService;

    // 게시판 전체 조회 및 검색 조회 및 페이징
    @RequestMapping("/list.do")
    public String boardlist(Model model, Criteria cri, Search search) throws Exception {
        // 게시판 전체 조회
        List<Board> boardList = boardService.selectSearchBoard(search, cri);

        // 게시판 전체 개수 -> 페이징 처리를 위한 처리
        int total = boardService.getTotal(search);

        model.addAttribute("list", boardList);
        model.addAttribute("pageMaker", new Page(cri, total)); // 페이징

        return "/board/list";
    }

    // 게시판 조회
    @RequestMapping("/one.do")
    public String boardone(Model model, Board brd, Criteria cri, Search search) throws Exception {

        if(cri == null) {
            throw new NullPointerException("해당값은 null 입니다.");
        }

        // 하나의 게시판 조회
        Board board = boardService.selectOneBoard(brd.getBno());

        // 해당 게시판에 존재하는 file 조회
        UploadFile file = fileService.selectFile(brd.getBno());

        model.addAttribute("board", board); // 하나의 게시물
        model.addAttribute("cri", cri); // 페이지 넘버와 페이지양
        model.addAttribute("file", file); // file 이름

        return "/board/one";
    }

    // 게시판 수정
    @RequestMapping("/modify.do")
    public String boardmodify(Model model, Board brd, Search search) throws Exception {
        // 하나의 게시판 조회
        Board board = boardService.selectOneBoard(brd.getBno());

        // 해당 게시판에 존재하는 file 조회
        UploadFile file = fileService.selectFile(brd.getBno());

        model.addAttribute("board", board);
        model.addAttribute("file", file); // file 이름

        return "/board/modify";
    }

    // Post
    @RequestMapping("/modifypost.do")
    public String boardmodifypost(Board brd, MultipartFile mpfile, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {
        int deleteFile = 0;

        if (mpfile != null && mpfile.getSize() > 0) {
            // file을 등록 했으면 insert
            // 2. 기존 데이터가 있는지 확인여부
            UploadFile tmpFile = fileService.selectFile(brd.getBno());

            // 3. 있으면 삭제.
            if(tmpFile != null) {
                deleteFile = fileService.deleteFile(brd.getBno());
            }

            // 4. 없으면 업데이트.
            fileService.uploadFile(mpfile, request, brd.getBno());
        }

        boolean result = boardService.updateBoard(brd);

        redirectAttributes.addFlashAttribute("msg", (result == true) ? "success"  : "fail" );

        return "redirect:/board/one.do?bno="+brd.getBno();
    }

    // 게시판 등록
    // Get
    @RequestMapping("/write.do")
    public String boardwrite(Model model) {
        return "/board/write";
    }

    // Post
    @RequestMapping("/writepost.do")
    public String boardwritepost(Board board, MultipartFile mpfile, HttpServletRequest request, RedirectAttributes redirectAttributes) throws Exception {

        if (mpfile != null && mpfile.getSize() > 0) {
            long fileSize = mpfile.getSize();

            // 2. 파일 번호 가져오기(기존 순서 번호 체크)
            // 가장 큰 게시판 번호 조회
            int maxBno = boardService.selectMaxBno();

            fileService.uploadFile(mpfile, request, maxBno+1);
        }

        // 게시판 insert
        boolean result = boardService.insertBoard(board);

        // 결과값 처리
        redirectAttributes.addFlashAttribute("msg", (result  == true) ? "success"  : "fail" );

        return "redirect:/board/list.do";
    }

    // 게시판 삭제
    @RequestMapping("/remove.do")
    public String boardremove(Board board) throws Exception {
        // 게시판 삭제
        boardService.deleteBoard(board.getBno());

        return "redirect:/board/list.do";
    }
}
