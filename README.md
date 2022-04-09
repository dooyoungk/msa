# MSA 구축 과제 - (STEP.0) 초기 프로젝트 구성

## 구현 화면
* 게시물 목록 조회 : BoardController.java의 getBoardMain 메소드 참고
* 게시물 상세 조회 : BoardController.java의 getBoard 메소드 참고
* 게시물 등록 : 진행중
* 게시물 수정 : 진행중
* 게시물 삭제 : 진행중

## Tech stack
* Spring Boot : 2.6.6
* JDK : 1.8
* Database : H2 Database (Embedded File DB) & Mybatis
  * DB 경우 별도의 설치 필요 없음
  * 첫 구동 시, DB 파일 생성 및 테이블 생성까지 진행
* View Engine : Thymeleaf