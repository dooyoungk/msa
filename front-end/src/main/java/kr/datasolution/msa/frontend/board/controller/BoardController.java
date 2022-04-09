package kr.datasolution.msa.frontend.board.controller;

import kr.datasolution.msa.frontend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 게시물 관련 처리 Controller Layer
 */
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */
    private final BoardService boardService;

    /**
     * 게시물 목록 조회 화면 이동
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 경로
     */
    @GetMapping("")
    public String getBoardMain(ModelMap map) {
        map.put("list", boardService.getBoardList());
        return "board/main";
    }

    /**
     * 게시물 상세 조회 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 경로
     */
    @GetMapping("{id}")
    public String getBoard(
            @PathVariable("id") int id,
            ModelMap map) {
        map.put("info", boardService.getBoard(id));
        return "board/info";
    }
}
