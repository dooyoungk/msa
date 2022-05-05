package com.dackdoo.frontend.webclient.controller;

import com.dackdoo.frontend.webclient.dto.BoardDto;
import com.dackdoo.frontend.webclient.service.WebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 게시물 관련 처리 Controller Layer
 */
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class WebClientController {

    /** 게시물 관련 처리 Service Layer 연결 */
    private final WebClientService webClientService;

    /**
     * 게시물 목록 조회 화면 이동
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 경로
     */
    @GetMapping("")
    public String getViewBoardMain(ModelMap map) {
        map.put("list", webClientService.getBoardList());

        return "board/main";
    }
    /**
     * 게시물 상세 조회 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 경로
     */
    @GetMapping("{id}")
    public String getViewBoard(
            @PathVariable("id") int id,
            ModelMap map) {
        BoardDto boardDto =  webClientService.getBoard(id).block();
        map.put("info", boardDto);
        return "board/info";
    }


    // 게시물 등록 화면 이동

    @GetMapping("new")
    public String getViewBoardNew() {
        return "board/new";
    }

    /**
     * 게시물 등록 처리
     * @param boardDto 게시물 등록 데이터
     * @return 게시물 상세 조회 화면 호출
     */
    @PostMapping("")
    public String addBoard(
            @ModelAttribute BoardDto boardDto) {
        webClientService.addBoard(boardDto);
        return "redirect:/board";
    }

    /**
     * 게시물 수정 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 수정 화면 경로
     */
    @GetMapping("{id}/edit")
    public String getViewBoardEdit(
            @PathVariable("id") int id,
            ModelMap map) {
        BoardDto boardDto =  webClientService.getBoard(id).block();
        map.put("info", boardDto);
        return "board/edit";
    }

    /**
     * 게시물 수정 처리
     * @param boardDto 게시물 수정 데이터
     * @return 게시물 상세 조회 화면 호출
     */
    @PutMapping("{id}")
    public String modBoard(
            @PathVariable("id") int id,
            @ModelAttribute BoardDto boardDto) {
        boardDto.setId(id);
       webClientService.modBoard(boardDto);

        return "redirect:/board/" + id;
    }

    @DeleteMapping("{id}")
    public String removeBoard(
            @PathVariable("id") int id) {
        webClientService.removeBoard(id);
        return "redirect:/board";
    }
}
