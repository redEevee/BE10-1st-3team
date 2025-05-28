# 영화관 예매 관리 시스템

##  프로젝트 개요
본 시스템은 사용자가 편리하게 영화를 예매할 수 있는 온라인 플랫폼을 제공합니다.

---
##  CRUD
|  기능        | 🟢 Create (생성)                      | 🔵 Read (조회)                     | 🟡 Update (수정)                          | 🔴 Delete (삭제)                          |
| ------------ | ----------------------------------- | -------------------------------- | --------------------------------------- | --------------------------------------- |
|  **회원**    | 회원가입<br>`/signup`                   | 회원 정보 조회<br>`/user/:id`          | 회원 정보 수정<br>`/user/:id`                 | 회원 탈퇴<br>`/user/:id`                    |
|  **인증/세션** | 로그인 요청<br>`/login`                  | 로그인 상태 확인<br>`/session`          | -                                       | 로그아웃<br>`/logout`                       |
|  **영화**    | 영화 등록 *(관리자)*<br>`/admin/movie`     | 영화 목록 조회<br>`/movies`            | 영화 정보 수정 *(관리자)*<br>`/admin/movie/:id`  | 영화 삭제 *(관리자)*<br>`/admin/movie/:id`     |
|  **상영 시간** | 시간표 추가 *(관리자)*<br>`/admin/schedule` | 시간표 조회<br>`/schedule`            | 시간표 수정 *(관리자)*<br>`/admin/schedule/:id` | 시간표 삭제 *(관리자)*<br>`/admin/schedule/:id` |
|  **좌석**    | 좌석 초기화 *(관리자)*<br>`/admin/seats`    | 좌석 현황 조회<br>`/seats/:scheduleId` | 좌석 선택 / 변경<br>`/seats/select`           | 좌석 초기화 *(관리자)*<br>`/admin/seats/:id`    |
|  **예매**    | 예매 신청<br>`/booking`                 | 예매 내역 조회<br>`/booking/history`   | (선택사항)<br>예매 변경<br>`/booking/:id`       | 예매 취소<br>`/booking/:id`                 |
|  **결제**    | 결제 요청<br>`/payment`                 | 결제 내역 조회<br>`/payment/history`   | 결제 수단 변경<br>`/payment/:id`              | 결제 취소<br>`/payment/:id`                 |




##  핵심 기능

###  회원 관리 시스템
- 회원가입 및 로그인 기능
- 회원 정보의 생성, 조회, 수정, 삭제(CRUD)

###  영화 예매 시스템
- 영화 목록 조회 및 선택
- 상영 시간표 조회 및 선택
- 2차원 배열 형태의 좌석 선택 시스템
- 다양한 결제 수단 지원 (카드, 계좌이체, 카카오페이, 네이버페이)

###  예매 관리
- 예매 정보 조회

---

##  기술 스택
- **백엔드**: Java  
- **데이터베이스**: MySQL  
- **개발 도구**: Eclipse IDE  
- **형상 관리**: GitHub  

---

##  요구사항 정의서

### 기능적 요구사항
- 회원가입 및 로그인
- 회원 정보 CRUD
- 영화 목록 및 상영 시간표 조회
- 좌석 선택 (2차원 배열 형태)
- 결제 수단 선택
- 예매 정보 확인

### 비기능적 요구사항
- MySQL 기반 데이터베이스 설계
- Java & Eclipse 환경에서 개발
- GitHub을 통한 형상관리

---

## 테이블 설계
[테이블 스프레드시트 보기](https://docs.google.com/spreadsheets/d/1uqyn9ivm9woyBFVLew8_6WkgJYd_po7Xx5D2-o4e4ZI/edit?usp=sharing)

---

##  프로젝트 목표
- CRUD 기반으로 영화 예매 기능 구현
- 번호 기반 영화 선택 기능
- 2차원 좌석 선택 시스템
- 다양한 결제 수단 제공

---

##  예매 프로세스 (Mermaid Flowchart)

> 아래 플로우차트를 지원하는 Markdown 뷰어나 Mermaid Live Editor(https://mermaid.live)에서 확인하세요.

```mermaid
flowchart TD
    A["시작"] --> B["영화관 메인페이지"]
    B --> C["영화 선택"]
    C --> D["상영 날짜/시간 선택"]
    D --> E["좌석 선택"]
    E --> F{"로그인 상태?"}
    F -- 미로그인 --> G["로그인/회원가입"]
    G --> H
    F -- 로그인 --> H["결제 정보 입력"]
    H --> I{"결제 성공?"}
    I -- 실패 --> H
    I -- 성공 --> J["예매 완료"]

