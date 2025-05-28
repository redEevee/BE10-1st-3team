<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>영화관 예매 관리 프로젝트 소개</title>
  <style>
    body {
      font-family: 'Arial', sans-serif;
      background-color: #f9f9f9;
      padding: 2em;
      color: #333;
      line-height: 1.6;
    }
    .container {
      background-color: #fff;
      max-width: 900px;
      margin: auto;
      padding: 2em;
      border-radius: 10px;
      box-shadow: 0 0 15px rgba(0,0,0,0.1);
    }
    h1, h2 {
      color: #222;
    }
    ul {
      padding-left: 1.5em;
    }
    pre {
      background-color: #f0f0f0;
      padding: 1em;
      border-radius: 5px;
      overflow-x: auto;
    }
    a {
      color: #007acc;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>🎬 영화관 예매 관리 시스템</h1>
    <p>사용자가 편리하게 영화를 예매할 수 있는 온라인 플랫폼을 제공합니다.</p>

    <h2>📌 핵심 기능</h2>
    <ul>
      <li>회원가입 및 로그인</li>
      <li>회원 정보 조회, 수정, 삭제</li>
      <li>영화 목록 및 상영 시간표 조회</li>
      <li>2차원 배열 좌석 선택</li>
      <li>결제 수단: 카드, 계좌이체, 카카오페이, 네이버페이</li>
    </ul>

    <h2>💻 기술 스택</h2>
    <ul>
      <li><strong>백엔드:</strong> Java</li>
      <li><strong>데이터베이스:</strong> MySQL</li>
      <li><strong>개발도구:</strong> Eclipse IDE</li>
      <li><strong>형상관리:</strong> GitHub</li>
    </ul>

    <h2>🧭 사용자 플로우</h2>
    <p>메인페이지 → 영화 선택 → 상영 시간 선택 → 좌석 선택 → 로그인 확인 → 결제 → 예매 완료</p>

    <h2>📋 기능 요구사항</h2>
    <ul>
      <li><strong>회원 관리:</strong> 가입, 로그인, CRUD</li>
      <li><strong>영화 예매:</strong> 목록 및 시간표 조회, 좌석 선택, 결제</li>
      <li><strong>예매 관리:</strong> 예매 내역 조회</li>
    </ul>

    <h2>⚙️ 비기능 요구사항</h2>
    <ul>
      <li>MySQL 기반 테이블 설계</li>
      <li>개발환경: Java + Eclipse</li>
    </ul>

    <h2>📊 테이블 설계 문서</h2>
    <p><a href="https://docs.google.com/spreadsheets/d/1uqyn9ivm9woyBFVLew8_6WkgJYd_po7Xx5D2-o4e4ZI/edit?usp=sharing" target="_blank">
      Google 스프레드시트 보기
    </a></p>

    <h2>🎯 프로젝트 목표</h2>
    <p>CRUD 기능을 기반으로 영화 예매 시스템을 구현합니다.</p>
    <ul>
      <li>회원 및 로그인 시스템</li>
      <li>번호 기반 영화 선택</li>
      <li>2차원 좌석 배열 선택</li>
      <li>다양한 결제 수단 제공</li>
    </ul>

    <h2>🔄 플로우 차트 (Mermaid)</h2>
    <pre><code class="language-mermaid">
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
    </code></pre>
  </div>
</body>
</html>

