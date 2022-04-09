# MSA 구축 과제 - (STEP.0) 초기 프로젝트 구성

## 구현 화면
* 게시물 목록 조회 (METHOD : GET, URI : /board) : BoardController.java의 getViewBoardMain 메소드 참고
* 게시물 상세 조회 (METHOD : GET, URI : /board/{id}) : BoardController.java의 getViewBoard 메소드 참고
* 게시물 등록 화면 (METHOD : GET, URI : /board/new) : BoardController.java의 getViewBoardNew 메소드 참고
* 게시물 수정 화면 (METHOD : GET, URI : /board/{id}/edit) : BoardController.java의 getViewBoardEdit 메소드 참고
* 게시물 등록 처리 (METHOD : POST, URI : /board) : BoardController.java의 addBoard 메소드 참고
* 게시물 수정 처리 (METHOD : PUT, URI : /board/{id}) : BoardController.java의 modBoard 메소드 참고
* 게시물 삭제 처리 (METHOD : DELETE, URI : /board/{id}) : BoardController.java의 removeBoard 메소드 참고

## Tech stack
* Spring Boot : 2.6.6
* JDK : 1.8
* Database : H2 Database (Embedded File DB) & Mybatis
  * DB 경우 별도의 설치 필요 없음
  * 첫 구동 시, DB 파일 생성 및 테이블 생성까지 진행
* View Engine : Thymeleaf
* CSS : Bootstrap 4.2.1
* JavaScript : JQuery 3.3.1

## 실행 환경
* PORT : 8080
* Main Class인 FrontEndApplication 클래스를 기준으로 프로그램 실행
* 반드시 로컬 환경에서 실행하시기 바랍니다. (서버에서의 실행은 고려 되어 있지 않습니다...!!)