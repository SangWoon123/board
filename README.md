# board
프레임워크 자유과제 23/05/14 ~ 23/05/19

과제 목표: CRUD, 에러핸들링 (ControllerAdvice) , Transactional 적용,AOP 적용 

~~디자인 미스~~

### **설계 요구사항**

1. 로그인
    - 사용자는 회원가입을 통해 계정을 생성하거나, 기존에 생성된 계정으로 로그인할 수 있다.
    - 회원가입 시 아이디, 비밀번호, 이메일, 닉네임 등의 정보를 입력한다.
    - 로그인 후 로그아웃 버튼을 통해 로그아웃할 수 있다.
2. 게시판
    - 게시판은 메인 게시판 하나만 존재한다.
    - 메인 게시판에는 제목, 글쓴이, 작성일, 조회수 등의 정보가 표시된다.

        ~~- 페이지당 게시글 수는 10개이다.~~
     - 게시글은 최신순으로 정렬된다.
    - 사용자는 글쓰기 버튼을 통해 게시글을 작성할 수 있다.
    - 사용자는 게시글 제목, 내용을 작성할 수 있다.
    - 게시글 작성 후 수정, 삭제가 가능하다.
    - 사용자는 게시글 목록에서 게시글을 선택하여 상세 페이지로 이동할 수 있다.

3. 검색
    - 사용자는 제목+내용 등의 검색어를 입력하여 게시글을 검색할 수 있다.
    - 검색된 결과는 최신순으로 정렬된다.

## DB 테이블 (users,posts)

### Users

<img width="450" alt="스크린샷 2023-05-19 오후 4 50 36" src="https://github.com/SangWoon123/board/assets/100204926/25523922-45f4-43ee-9621-448230255652">

### Posts

<img width="421" alt="스크린샷 2023-05-19 오후 4 50 47" src="https://github.com/SangWoon123/board/assets/100204926/c5397325-6c75-4ba8-a791-1a149e7adfb3">

#
### 트랜잭션 시나리오 1

**회원가입**:모든 입력이 유효하고 중복된 아이디가 없는지 등을 검증한 후에 DB 작업을 수행하고, 작업이 성공적으로 완료되면 회원가입을 완료 한다.

#
# 결과
### 로그인 

<img width="1058" alt="스크린샷 2023-05-19 오후 4 37 53" src="https://github.com/SangWoon123/board/assets/100204926/00b04260-0596-404a-b98f-cfa997a81310">

### 회원가입
<img width="996" alt="스크린샷 2023-05-19 오후 4 38 02" src="https://github.com/SangWoon123/board/assets/100204926/4f7a3a0d-2098-4540-90fc-1a2fb74d0692">

### 게시판
<img width="1433" alt="스크린샷 2023-05-19 오후 4 38 13" src="https://github.com/SangWoon123/board/assets/100204926/f4cc5559-199c-4f6b-b387-97e16a10dad2">


로그인페이지 부트스트랩 참조: https://codepen.io/AlexisBertin/pen/qOMegE 