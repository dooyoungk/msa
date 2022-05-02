package kr.datasolution.msa.frontend.board.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * 게시물 관련 처리 Controller Layer
 */
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
    @GetMapping("list")
    public ResponseEntity<?> getViewBoardMain(ModelMap map) {
        map.put("list", boardService.getBoardList());
        return new ResponseEntity<>(map, HttpStatus.OK);
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
    public ResponseEntity<?> getViewBoard(
            @PathVariable("id") int id,
            ModelMap map) {
        map.put("info", boardService.getBoard(id));
        return new ResponseEntity<>(map, HttpStatus.OK);
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
    public int addBoard(
            @RequestBody BoardDto boardDto,
            ModelMap map) {
        //return new ResponseEntity<>(map, HttpStatus.CREATED);
        return boardService.addBoard(boardDto);
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
    public int modBoard(
            @PathVariable("id") int id,
            @RequestBody BoardDto boardDto,
            ModelMap map) {
        boardDto.setId(id);
        return boardService.modBoard(boardDto);
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
    public int removeBoard(
            @PathVariable("id") int id,
            ModelMap map) {
        return boardService.removeBoard(id);
    }
}
