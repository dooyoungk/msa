package kr.datasolution.msa.frontend.board.mapper;

import kr.datasolution.msa.frontend.board.dto.BoardDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 게시물 DB TABLE 처리 Mapper Interface
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

    /**
     * 게시물 등록 처리
     * @param boardDto 게시물 등록 데이터
     * @return 게시물 등록 건수
     */
    @Insert("INSERT INTO BOARD(TITLE, CONTENTS, REG_DT) VALUES (#{board.title}, #{board.contents}, NOW())")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(@Param("board") BoardDto boardDto);

    /**
     * 게시물 수정 처리
     * @param boardDto 게시물 수정 데이터
     * @return 게시물 수정 건수
     */
    @Update("UPDATE BOARD SET TITLE = #{board.title}, CONTENTS = #{board.contents}, UPD_DT = NOW() WHERE ID = #{board.id}")
    int update(@Param("board") BoardDto boardDto);

    /**
     * 게시물 삭제 처리
     * @param id 게시물 ID
     * @return 게시물 삭제 건수
     */
    @Delete("DELETE FROM BOARD WHERE ID = #{id}")
    int deleteById(@Param("id") int id);
}
