# 🏎️ 자동차 경주 게임

## 🚀 기능 구현 목록

### 프로젝트 초기 설정
&nbsp;&nbsp;\[X] Layered Architecture 패키지 구조 생성  
&nbsp;&nbsp;&nbsp;&nbsp;\[X] controller, service, domain, infrastructure, validator 패키지  
&nbsp;&nbsp;\[X] 기본 클래스 정의  
&nbsp;&nbsp;\[X] 인터페이스 정의

### Infrastructure Layer
&nbsp;&nbsp;\[X] 랜덤 숫자 생성 구현  
&nbsp;&nbsp;\[X] 콘솔 입력 구현  
&nbsp;&nbsp;\[X] 콘솔 출력 구현

### Domain Layer

#### Car (자동차)
&nbsp;&nbsp;\[X] 자동차 이름과 위치 저장  
&nbsp;&nbsp;\[X] 전진 기능  
&nbsp;&nbsp;\[X] 현재 위치 반환
&nbsp;&nbsp;\[X] 이름 반환

#### Cars (자동차 목록)
&nbsp;&nbsp;\[X] 자동차 등록  
&nbsp;&nbsp;\[X] 모든 자동차 이동 처리  
&nbsp;&nbsp;\[X] 우승자 찾기 (최대 위치 자동차들)

#### DTO
&nbsp;&nbsp;\[X] 자동차 이름 데이터 

### Validator

#### 입력 검증

##### 자동차 이름 검증
&nbsp;&nbsp;\[ ] 빈 문자열 체크 → 예외 발생  
&nbsp;&nbsp;\[ ] 5자 초과 체크 → 예외 발생  
&nbsp;&nbsp;\[ ] 중복 이름 체크 → 예외 발생

##### 시도 횟수 검증
&nbsp;&nbsp;\[ ] 숫자 형식 체크 → 예외 발생  
&nbsp;&nbsp;\[ ] 양수 체크 → 예외 발생

### Service Layer

#### 게임 진행 관리
&nbsp;&nbsp;\[ ] 자동차 목록 생성  
&nbsp;&nbsp;\[ ] 한 라운드 진행 (모든 차 이동)  
&nbsp;&nbsp;\[ ] 전체 게임 진행 (n번 라운드 반복)  
&nbsp;&nbsp;\[ ] 우승자 결정

### Controller Layer

#### 게임 흐름 제어
&nbsp;&nbsp;\[ ] 자동차 이름 입력 받기  
&nbsp;&nbsp;\[ ] 자동차 이름 검증  
&nbsp;&nbsp;\[ ] 시도 횟수 입력 받기  
&nbsp;&nbsp;\[ ] 시도 횟수 검증  
&nbsp;&nbsp;\[ ] 게임 시작 및 진행  
&nbsp;&nbsp;\[ ] 각 라운드 결과 출력  
&nbsp;&nbsp;\[ ] 최종 우승자 출력 (쉼표로 구분)

### Application

#### 객체 조립 및 실행
&nbsp;&nbsp;\[ ] 모든 구현체 생성  
&nbsp;&nbsp;\[ ] 의존성 주입  
&nbsp;&nbsp;\[ ] 게임 시작

---

## 🧪 테스트 목록

### Domain 테스트

#### Car 테스트
&nbsp;&nbsp;\[X] 이름 저장 확인  
&nbsp;&nbsp;\[X] 초기 위치 0 확인  
&nbsp;&nbsp;\[X] 전진 테스트  
&nbsp;&nbsp;\[X] 정지 테스트 
&nbsp;&nbsp;\[X] 여러 번 이동 시 위치 누적

#### Cars 테스트
&nbsp;&nbsp;\[X] 자동차 등록  
&nbsp;&nbsp;\[X] 자동차 이름 중복 확인  
&nbsp;&nbsp;\[X] 단독 우승자 찾기  
&nbsp;&nbsp;\[X] 공동 우승자 찾기

### Validator 테스트

#### 자동차 이름 검증
&nbsp;&nbsp;\[ ] 정상 입력 통과  
&nbsp;&nbsp;\[ ] 5자 초과 예외 발생  
&nbsp;&nbsp;\[ ] 빈 문자열 예외 발생  
&nbsp;&nbsp;\[ ] 중복 이름 예외 발생

#### 시도 횟수 검증
&nbsp;&nbsp;\[ ] 정상 숫자 통과  
&nbsp;&nbsp;\[ ] 문자 입력 시 예외 발생  
&nbsp;&nbsp;\[ ] 0 이하 입력 시 예외 발생

### Service 테스트
&nbsp;&nbsp;\[ ] 자동차 목록 생성 확인  
&nbsp;&nbsp;\[ ] 게임 진행 로직 확인  
&nbsp;&nbsp;\[ ] 우승자 결정 로직 확인

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
├── dto/
│   └── CarName.java
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