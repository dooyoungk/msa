package kr.datasolution.msa.frontend.board.mapper;

import kr.datasolution.msa.frontend.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 */
@Mapper
public interface BoardMapper {
    /**
     * 전체 등록 게시물 리스트 조회
     * @return 전체 등록 게시물 리스트
     */
    @Select("SELECT ID, TITLE, REG_DT FROM BOARD ORDER BY ID DESC")
    List<BoardDto> findAll();

    /**
     * 지정 게시물 상세 조회
     * @param id 게시물 ID
     * @return 지정 게시물
     */
    @Select("SELECT ID, TITLE, CONTENTS, REG_DT, UPD_DT FROM BOARD WHERE ID = #{id}")
    BoardDto findById(@Param("id") int id);
}
