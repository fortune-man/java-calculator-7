# java-calculator-precourse

## 문자열 덧셈 계산기
### 고객 요구사항 100%
- [x] 과제 진행 요구사항 - 진행률 97%
  - [x] fork, clone
  - [x] 구현부터 하지 않고 문제 정의와 분석부터함으로써 문제 해결 과정 표현
  - [x] 작성한 기능 목록 단위로 커밋 && 커밋 컨벤션 참고하여 커밋 메시지 작성
- [x] 기능 요구사항 - 진행 97% / 필요 3%
  - [x] 고객 요구에 근거한 문제 분석을 통해 도출한 기능 목록 구현
- [x] 프로그래밍 요구 사항 - 진행률 29%
  - [x] JDK 21버전에서 실행
  - [x] 프로그램 실행 시작점 준수 : Application의 main()
  - [x] build.gradle 변경 x, 외부 라이브러리 사용 x, 제공된 라이브러리 사용
  - [x] 프로그램 종료시 System.exit() 호출 x
  - [x] 프로그래밍 요구사항에 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동 x
  - [] 자바 코드 컨벤션 준수 : Google Java Style Guide
  - [x] camp.nextstep.edu.missionutils에서 제공하는 Console API를 사용하여 구현
  - [x] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

### 트러블슈팅
- 제한된 시간내 일정 엄수하기 위해 실패하는 테스트 시도
- 입출력 테스트에서 null pointer -> next step 제공 라이브러리 사용법 미숙으로 테스팅 지연되는 문제
- 통과하는 최소한의 로직 작성에서 무언가 막힘. 문제가 뭔지 식별중
  - 문제가 '어떻게' 발생했는가? -> 실패하는 테스트 작성 후 최소한의 로직 작성 중 무엇을 해야할지 모르는 문제가 발생했다
  - 문제가 '왜' 발생했는가?
  - 터미널 에러와 경고줄 끝까지 읽고 이해하는 스킬 부족 -> 솔루션) 디버깅 병목 포인트 추적
- 커스텀 구분자 사용하는 경우 정상 결과 출력과 예외 처리에서 테스팅 실패 && 병목 추적 어려움을 겪고 있는 현상
  - 왜 병목이 하나만 남았는가? -> 문제해결 많이 < 병목 최소화로 관점 바꿔서 접근한게 나름 효과있었던 걸로 추정
  

#### why note
실패하는 테스트 작성 후 최소한의 로직 작성하는 과정에서 막히는 문제가 ‘왜’ 생겼는가?
- mitigation: 실패하는 테스트 작성 후 깔끔한 코드로 리팩토링 개선 시도 -> 로직 복붙
  - 장점 : 빠른 실행,
  - 단점: 근본적 스킬 향상 우회
- 근본 솔루션: 돌아가는 로직으로 개선
  - 장점 : 정확한 실행, 동일한 문제 재발생 방지를 보장
  - 단점 : 막막함, 느린 속도
- 배운점 : 트러블 슈팅 x, 병목 포인트 줄이기
  - 문제는 해결될 수 없다. 계속 나오니까..
  - 그렇다면 병목을 최소한으로 줄이는 관점으로 접근해보자 가 이번 미션을 통해 얻은 점 한가지입니당

### 문제 분석
- 문제 정의
  - 사용자 입력에 따라 연산된 결과를 출력하는 문자열 덧셈 계산기
- 입력 허용: 정수, 구분자, 커스텀 구분자
- 구분자 : “,” , “:”
- 커스텀 구분자 : “;”
- 특이사항
  - 커스텀 구분자 사용시 문자열 앞부분에 위치
  - “//;\n”이 문자열 앞에 있는 경우 커스텀 구분자 지정으로 판단
  - 커스텀 구분자 사용하는 경우 다른 구분자 사용과 같이 연산
- 사용자가 잘못된 값을 입력할 경우 예외 처리
  - IllegalArgumentException 발생 후 애플리케이션 종료

—--


### 구현할 기능 목록 정리
- [x] 문자열 입력
    - [x] 기본 구분자와 양수로 구성된 문자열
    - [x] 커스텀 구분자와 양수로 구성된 문자열
- [x] 입력된 문자열 구분자와 정수 분리
  - [x] 기본 구분자
  - [x] 커스텀 구분자
  - [x] 정수 연산 return
- [x] 예외 처리
    - [x] 허용하지 않는 구분자
    - [x] 음의 정수
    - [x] 허용되지 않은 문자열
- [x] 메인
  - 문자열을 입력하면 정수 연산 결과를 출력
