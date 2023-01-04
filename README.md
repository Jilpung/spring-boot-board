# Basic Board Project
> 웹의 기본을 다 넣을 수 있는 게시판 프로젝트! 

## 목차
- 들어가며
  - 프로젝트 소개
  - 프로젝트 기능
  - 사용기술
    - 백엔드
    - 프론트엔드

- 구조 및 설계
  - DB 설계
  - API 설계

- 마치며
  - 보완사항
  - 후기


## 들어가며
### 1. 프로젝트소개
JAVA를 기반으로 웹의 기본을 다 넣을 수 있는 게시판 프로젝트를 만들며 배우기 위해 시작했습니다.
Bootstrap과 thymeleaf를 사용해서 프론트를 간단히 제작.
### 2. 프로젝트 기능
**게시판:** CRUD, 조회수, 페이징, 검색  
**사용자:** Security, jwt 회원가입 및 로그인, 회원정보 수정, 회원가입시 유효성 검사 및 중복 검사  
**댓글:** CRUD  

**미구현:** jwt, 권한별(USER, ADMIN)접속 가능 여부, 댓글

### 3. 사용기술
#### 백엔드
  - JAVA11, SpringBoot, JPA(Spring Data JPA), Spring Security, Gradle, mysql  
#### 프론트엔드
  - Html/Css, Javascript, Bootstrap, thymeleaf

### 4. 구조 및 설계
  <details>
    <summary>DB 설계</summary>
    
![DBarchitecture](./img/DBarchitecture.png)  
  
  </details>
  <br />
  <details>
  
  <summary>API 설계</summary>
  
![boardAPI](./img/boardAPI.png)
![userAPI](./img/userAPI.png)
  </details>
  
### 5. 마치며
  - #### 보완사항
    1. 로그인 한 사람만 글쓰기 가능
    2. 작성자, 관리자만 글 수정, 삭제 가능하게 하기
    3. 글 삭제시 글 번호 재 정렬
    4. 페이징 처리 정확히(1페이지 글 10개씩)


  - ##### 후기
처음으로 만들어본 java프로젝트입니다. javascript의 자유로움을 누리다 java환경에 적응하는데 시간이 좀 걸렸습니다.
우선 이 프로젝트의 목표는 '한번 만들어보자!'입니다. 
많은 블로그들을 참고하고 인강과 교재를 참고하며 만들었습니다. 
그래서 여전히 부족한게 많지만, 차차 더 나은 방향성의 성과품이 있지 않을까 생각됩니다.
똑같은 내용을 찾아도 다른 방식의 개발을 보며 더 나은 best practice를 찾아가는 과정은 즐거운 시간이었습니다.
이제 간단한 게시판을 만들었으니, 보완사항을 그리고 더 넣고 싶은 기능들을 넣고 싶습니다.
여전히 공부하고 찾는 것은 어렵지만, 여전히 재미있습니다.
이 재미를 통해 더 나은 개발자가 되기를 소망하며!
감사합니다.

/2023.1.4
