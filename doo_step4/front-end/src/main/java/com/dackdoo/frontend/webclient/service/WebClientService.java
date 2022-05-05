package com.dackdoo.frontend.webclient.service;

import com.dackdoo.frontend.webclient.dto.BoardDto;
import com.dackdoo.frontend.webclient.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 게시물 관련 처리 Service Layer
 */
@Component
@Service
@RequiredArgsConstructor
@Slf4j
public class WebClientService{
    private final BoardMapper boardMapper;

    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:9090/api/")
            .build();



    /**
     * 전체 게시물 리스트 조회
     * @return 전체 게시물 리스트
     */
    public List<BoardDto> getBoardList() {
        return webClient.get()
                .uri("")
                .retrieve()
                .bodyToFlux(BoardDto.class)
                .toStream()
                .collect(Collectors.toList());
    }
    /**
     * 지정 게시물 상세 조회
     * @param id 게시물 ID
     * @return 지정 게시물
     */
    public Mono<BoardDto> getBoard(int id) {
        return webClient.get()
                .uri("/" + id)
                .retrieve()
                .bodyToMono(BoardDto.class);
    }


    /**
     * 게시물 등록 처리
     * @param boardDto 게시물 등록 데이터
     */

    public Void addBoard(BoardDto boardDto){
        return webClient.post()
                .uri("")
                .bodyValue(boardDto)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    /**
     * 게시물 수정 처리
     * @param boardDto 게시물 수정 데이터
     */
    public Void modBoard(BoardDto boardDto) {
        return webClient.put()
                .uri("/" + boardDto.getId()+"/edit")
                .body(Mono.just(boardDto), BoardDto.class)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }


    /**
     * 게시물 삭제 처리
     * @param id 게시물 ID
     */

    public Void removeBoard(int id){
        return webClient.delete()
                .uri("/"+id)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

}
