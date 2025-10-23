# 🏎️ 자동차 경주 게임

## 🚀 기능 구현 목록

### 1️⃣ 프로젝트 초기 설정

- [ ]  Layered Architecture 패키지 구조 생성
  - [ ]  controller, service, domain, infrastructure, validator 패키지

---

### 2️⃣ Infrastructure Layer

**인터페이스 정의**

- [ ]  랜덤 숫자 생성 인터페이스
- [ ]  입력 인터페이스
- [ ]  출력 인터페이스

**구현체**

- [ ]  랜덤 숫자 생성 구현
- [ ]  콘솔 입력 구현
- [ ]  콘솔 출력 구현

---

### 3️⃣ Domain Layer

**Car (자동차)**

- [ ]  자동차 이름과 위치 저장
- [ ]  전진 기능 (랜덤 값 4 이상일 때)
- [ ]  현재 위치 반환

**Cars (자동차 목록)**

- [ ]  여러 대의 자동차 관리
- [ ]  모든 자동차 이동 처리
- [ ]  우승자 찾기 (최대 위치 자동차들)

---

### 4️⃣ Validator

**입력 검증**

- [ ]  자동차 이름 검증
  - [ ]  빈 문자열 체크 → 예외 발생
  - [ ]  5자 초과 체크 → 예외 발생
  - [ ]  중복 이름 체크 → 예외 발생
- [ ]  시도 횟수 검증
  - [ ]  숫자 형식 체크 → 예외 발생
  - [ ]  양수 체크 → 예외 발생

---

### 5️⃣ Service Layer

**게임 진행 관리**

- [ ]  자동차 목록 생성
- [ ]  한 라운드 진행 (모든 차 이동)
- [ ]  전체 게임 진행 (n번 라운드 반복)
- [ ]  우승자 결정

---

### 6️⃣ Controller Layer

**게임 흐름 제어**

- [ ]  자동차 이름 입력 받기
- [ ]  자동차 이름 검증
- [ ]  시도 횟수 입력 받기
- [ ]  시도 횟수 검증
- [ ]  게임 시작 및 진행
- [ ]  각 라운드 결과 출력
- [ ]  최종 우승자 출력 (쉼표로 구분)

---

### 7️⃣ Application

**객체 조립 및 실행**

- [ ]  모든 구현체 생성
- [ ]  의존성 주입
- [ ]  게임 시작

---

## 🧪 테스트 목록

### Domain 테스트

**Car 테스트**

- [ ]  이름 저장 확인
- [ ]  초기 위치 0 확인
- [ ]  랜덤 값 4 이상일 때 전진
- [ ]  랜덤 값 3 이하일 때 정지
- [ ]  여러 번 이동 시 위치 누적

**Cars 테스트**

- [ ]  여러 대 자동차 생성
- [ ]  모든 자동차 동시 이동
- [ ]  단독 우승자 찾기
- [ ]  공동 우승자 찾기

---

### Validator 테스트

**자동차 이름 검증**

- [ ]  정상 입력 통과
- [ ]  5자 초과 예외 발생
- [ ]  빈 문자열 예외 발생
- [ ]  중복 이름 예외 발생

**시도 횟수 검증**

- [ ]  정상 숫자 통과
- [ ]  문자 입력 시 예외 발생
- [ ]  0 이하 입력 시 예외 발생

---

### Service 테스트

- [ ]  자동차 목록 생성 확인
- [ ]  게임 진행 로직 확인
- [ ]  우승자 결정 로직 확인

---

## 📂 프로젝트 구조

```
src/main/java/racingcar/
├── Application.java
├── controller/
│   └── RacingController.java
├── service/
│   └── RacingService.java
├── domain/
│   ├── Car.java
│   └── Cars.java
├── infrastructure/
│   ├── random/
│   │   ├── RandomNumberGenerator.java
│   │   └── DefaultRandomNumberGenerator.java
│   └── io/
│       ├── Input.java
│       ├── Output.java
│       ├── ConsoleInput.java
│       └── ConsoleOutput.java
└── validator/
    └── InputValidator.java
```
