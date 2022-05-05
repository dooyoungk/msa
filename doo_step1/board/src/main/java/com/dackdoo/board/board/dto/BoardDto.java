package com.dackdoo.board.board.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Data
public class BoardDto {
    /** 게시물 ID */

    private int id;

    /** 제목 */
    private String title;

    /** 내용 */
    private String contents;

    /** 등록일시 */
    private LocalDateTime regDt;

    /** 수정일시 */
    private LocalDateTime updDt;

}
