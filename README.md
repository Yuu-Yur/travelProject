# 여행사 프로젝트

직관적이고 사용자 친화적인 여행사 웹 개발

---

## 사용 기술

- **백엔드**: Spring Boot  
- **프론트엔드**: Thymeleaf (HTML, CSS, JavaScript)
- **DB**: MariaDB  
- **기타**: Docker, Redis 등

---

## 📄 프로젝트 소개

이 프로젝트는 직관적이고 사용자 친화적인 여행사 웹 개발을 목적으로 개발되었으며, 주요 기능은 다음과 같습니다.

- 회원 가입/로그인/로그아웃
- 여행 상품 조회/상세조회
- 장바구니
- 여행 예약/결제
- 예약 내역 확인 및 취소
- 관리자 페이지
- 후기 작성/조회

---

## 프로젝트 구조
root
├ src
│ └ main
│   ├ java
│   │   ├ advice <-- 로그인 시 exceptionHandler
│   │   ├ annotation.member <-- member annotation 정의
│   │   ├ config <-- 관리자 설정, interceptors, argumentResolvers 등 로그인 관련 기능 설정
│   │   ├ context <-- 멤버 로그인 정보 서버에 저장 기능 구현
│   │   ├ controller
│   │   ├ domain
│   │   ├ dto
│   │   ├ execption.member < -- 로그인 시 exeception 정의
│   │   ├ interceptor <-- 로그인 관련 인터셉터 정의
│   │   ├ repository
│   │   ├ scheduler <-- 취소된 예약 자동 삭제 기능 구현
│   │   ├ service
│   │   └ application
│   └ resources 
│       ├ static <-- 화면에 사용된 이미지, css, js, font 파일 위치
│       └ templates <-- 화면 html 파일 위치
└ read.me
