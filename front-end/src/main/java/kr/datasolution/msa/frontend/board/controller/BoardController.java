package kr.datasolution.msa.frontend.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 게시물 관련 처리 Controller Layer
 */
@Controller
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
//@Slf4j
public class BoardController {

    /** 게시물 관련 처리 Service Layer 연결 */
    private final BoardService boardService;

    /**
     * 게시물 목록 조회 화면 이동
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 경로
     */
    @Operation (summary = "게시물 목록 조회", description = "hello api example")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "OK !!"),
            @ApiResponse(responseCode = "400", description = "BAD REQUEST !!"),
            @ApiResponse(responseCode = "404", description = "NOT FOUND !!"),
            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR !!"),
    })
    @GetMapping("")
    public ResponseEntity<List<BoardDto>> getViewBoardMain() {
        boardService.getBoardList();
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoardList());
    }

//    @GetMapping("")
//    public String getViewBoardMain(ModelMap map) {
//        return "Project name is dy.";
//       map.put("list", boardService.getBoardList());
//       return "board/main";
//    }

    /**
     * 게시물 상세 조회 화면 이동
     * @param id 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 경로
     */
    @Operation (summary = "게시물 상세 조회", description = "hello api example")
    @GetMapping("{id}")
    public ResponseEntity<BoardDto> getViewBoard(
            @PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getBoard(id));
    }

//    /**
//     * 게시물 등록 화면 이동
//     * @return 게시물 등록 화면 경로
//     */
//    @GetMapping("new")
//    public String getViewBoardNew() {
//        return "board/new";
//    }
//
//    /**
//     * 게시물 수정 화면 이동
//     * @param id 게시물 ID
//     * @param map View 로 전달할 ModelMap 객체
//     * @return 게시물 수정 화면 경로
//     */
//    @GetMapping("{id}/edit")
//    public String getViewBoardEdit(
//            @PathVariable("id") int id,
//            ModelMap map) {
//        map.put("info", boardService.getBoard(id));
//        return "board/edit";
//    }

    /**
     * 게시물 등록 처리
     *
     * @param boardDto 게시물 등록 데이터
     * @param map      View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출
     */
    @Operation (summary = "게시물 등록", description = "new contents in board")
    @PostMapping("")
    public ResponseEntity<Integer> addBoard(
            @RequestBody BoardDto boardDto) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.addBoard(boardDto));
    }

    /**
     * 게시물 수정 처리
     *
     * @param boardDto 게시물 수정 데이터
     * @param map      View 로 전달할 ModelMap 객체
     * @return 게시물 상세 조회 화면 호출
     */
    @Operation (summary = "게시물 수정", description = "modify board contents")
    @PutMapping("{id}")
    public ResponseEntity<Integer> modBoard(
            @PathVariable("id") int id,
            @RequestBody BoardDto boardDto) {
        boardDto.setId(id);
        return ResponseEntity.ok(boardService.modBoard(boardDto));
    }

    /**
     * 게시물 삭제 처리
     *
     * @param id  삭제 대상 게시물 ID
     * @param map View 로 전달할 ModelMap 객체
     * @return 게시물 목록 조회 화면 호출
     */
    @Operation (summary = "게시물 삭제", description = "delete board contents")
    @DeleteMapping("{id}")
    public ResponseEntity<Integer> removeBoard(
            @PathVariable("id") int id) {
        return ResponseEntity.ok(boardService.removeBoard(id));
    }
}
