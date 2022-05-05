package com.dackdoo.board.board.controller;

import com.dackdoo.board.board.dto.BoardDto;
import com.dackdoo.board.board.service.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시물 관련 처리 Controller Layer
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */

    private final BoardService boardService;


    /**
     * 게시물 목록 조회 화면 이동
     * @return 게시물 목록 조회 화면 경로
     */
    @Operation(summary = "게시물 목록 조회",description = "all of board read")
    @GetMapping("")
    public List<BoardDto> getViewBoardMain() {
        return boardService.getBoardList();
    }

    /**
     * 게시물 상세 조회 화면 이동
     * @param id 게시물 ID
     * @return 게시물 상세 조회 화면 경로
     */
    @Operation(summary = "게시물 상세 조회",description = "a board read for id")
    @GetMapping("{id}")
    public BoardDto getViewBoard(
            @PathVariable("id") int id) {

        return boardService.getBoard(id);
    }


    /**
     * 게시물 등록 처리
     * @param boardDto 게시물 등록 데이터
     * @return 게시물 상세 조회 화면 호출
     */
    @Operation(summary = "게시물 등록",description = "a new board create")
    @PostMapping("")
    public void addBoard(
            @RequestBody BoardDto boardDto) {
        boardService.addBoard(boardDto);
    }

    /**
     * 게시물 수정 화면 이동
     * @param id 게시물 ID
     * @return 게시물 수정 화면 경로
     */
    @Operation(summary = "게시물 수정",description = "a board update")
    @PutMapping("{id}/edit")
    public List<BoardDto> getViewBoardEdit(
            @PathVariable("id") int id,
            @RequestBody BoardDto boardDto
    ) {
        boardService.getBoard(id);
        boardService.modBoard(boardDto);

        return boardService.getBoardList();
    }



    /**
     * 게시물 삭제 처리
     * @param id 삭제 대상 게시물 ID
     * @return 게시물 목록 조회 화면 호출
     */
    @Operation(summary = "게시물 삭제",description = "a board delete")
    @DeleteMapping("{id}")
    public void removeBoard(
            @PathVariable("id") int id) {
        boardService.removeBoard(id);
    }
}