package kr.datasolution.msa.frontend.board.service;

import kr.datasolution.msa.frontend.board.dto.BoardDto;
import kr.datasolution.msa.frontend.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 게시물 관련 처리 Service Layer
 */
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    /**
     * 전체 게시물 리스트 조회
     * @return 전체 게시물 리스트
     */
    public List<BoardDto> getBoardList() {
        return boardMapper.findAll();
    }

    /**
     * 지정 게시물 상세 조회
     * @param id 게시물 ID
     * @return 지정 게시물
     */
    public BoardDto getBoard(int id) {
        return boardMapper.findById(id);
    }
}
