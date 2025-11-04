## 환경
- Java 17
- IntelliJ Ultimate
- Claude
- Spring Boot 3

## Claude 1번 명령어
```
# 역할
너는 숙련된 백엔드 개발자야. 내가 요청한 기능에 맞게 Kotlin + Spring Boot 기반의 코드를 작성해줘.
# 기술 스택
Spring Boot 3.x, Spring Web, Spring Data JPA, H2DB
# 요구사항
1. Todo 엔티티는 title, description, isDone 필드를 가진다.
2. title은 필수 값이며, description은 선택 값이고, isDone은 기본값이 false여야 한다.
3. Todo를 생성(Create), 전체 조회(Read), 단건 조회(Read), 수정(Update), 삭제(Delete)할 수 있는 REST API를 구현해줘.
4. 각 기능에 필요한 DTO, Service, Controller를 작성해줘.
5. Repository는 JpaRepository를 사용해 구현해줘.
6. 테스트 코드는 나중에 따로 요청할 예정이니 지금은 작성하지 않아도 돼.
```

## Claude 2번 명령어
```
# 역할
너는 Spring Boot + Thymeleaf를 사용하는 웹 프론트엔드 개발자야.
기존 작성된 서버 코드를 바탕으로 Thymeleaf와 연동을 진행해주면 돼
# 요구사항
1. todo 목록을 보여주는 list.html을 만들어줘.
2. todo 등록 폼을 갖는 create.html을 만들어줘.
3. 등록 폼에는 title, description 입력창과 등록 버튼이 있어야 해.
4. 목록 페이지에서는 Checkbox로 완료 처리(isDone 수정)가 가능해야 해.
5. Controller는 @Controller Annotation을 사용하고, Model에 데이터 넣어서 view에 전달해줘.
6. thymeleaf 문법은 기본적인 것만 사용해줘.
```
