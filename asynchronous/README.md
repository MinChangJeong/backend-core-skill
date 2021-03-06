## 비동기 프로그래밍

#### 비동기 프로그래밍이 필요한 이유 : 
 - 만약 어떤 함수의 결과가 다른 함수에 영향을 받는 다면 그 함수는 다른 함수가 끝나고 값을 산출 할 때 까지 기다려야 합니다.
 - 그리고 그 과정이 끝날 때 까지 유저의 입장에서 보면 전체 프로그램이 모두 멈춘 것 처럼 보일것 입니다.
 - 여러개의 프로세서를 돌리는 시대에는 컴퓨터 성능을 효율적으로 쓰지 못하는 경우에 해당합니다.
 - 다른 코어 프로세서에 다른 작업들을 움직이게하고 작업이 완료되면 알려줄 수 있을 때 그동안 다른 작업 들을 수행하게 하는 것이 필요한 이유입니다.

#### Blocking
 - 비동기 기법은 웹 프로그래밍에 유용합니다.
 - 웹 앱이 브라우저에서 특정 코드를 실행하느라 브라우저에게 제어권을 돌려주지 않으면 브라우저는 마치 정지 된것 처럼 보이는 데 이러한 현상을 "Blocking" 이라고 합니다.
 - 사용자의 입력을 처리하느라 웹 앱이 프로세서에 대한 제어 권을 브라우저에게 반환하지 않는 현상입니다.


#### Promise/ Future
 - Future : 미래에 실행이 완료될 것으로 예상되는 객체
  - 따라서 아직 실행되지 않은 경우나, 실행 중이지만 아직 완료되지 않은 경우를 포함하는 개념임.
  - Future 객체에 요청한 값이 들어오기를 기다리는 동안 다른 연산을 수행 할 수 있다.
 
 - Promise : 기본적으로 Future와 비슷하지만 Future는 외부에서 완료된 결과가 들어오기만 하므로 read-only, Promise는 강제로 내가 complete할 수 있는 메서드를 제공한다는 점에서 차이가 있다.
  - 자바에서 Promise == CompletetableFuture
  - .complete() 라는 메서드를 제공하고 있다.


#### Promise/ Future가 왜 필요한가?
- callback의 단점
 - callback 실행 결과를 외부로 리턴할 수 없어서 callback결과를 다루려면 callback안에서 해결해야하고, 결국 callback안에 callback... 형시긍로 중첩해서 써내려가야 한다.
 - 반면 Promise는 실행 결과 프로미스를 리턴해서 다음 then으로 전달 가능하다.


### Build Tool
 - 우리가 프로젝트에서 작성한 java 코드와 프로젝트 내에서 필요한 각종 xml, properties, jar파일들을 JVM이나
   WAS가 인식할수 있도록 패키징 해주는 빌드 과정 
 - 다양한 외부 라이브러리들을 다운로드하고 해당 라이브러리를 사용하여 개발해야 하는 상황이 만ㅇ흔데 
   이때 각 라이브러리들을 번거롭게 모두 다운 받을 필요 없이 빌드도구 설정파일에 필요한 라이브러리 종류와 버전을 자동으로 다운로드 해줌
 
 ### Maven / Gradle
  - Gradle은 작업 의존성 그래프를 기반으로 하는 반면 Maven은 고정적이고 선형적인 단계의 모델을 기반으로 한다.
  - 성능 측면에서는 둘다 다중 모듈 빌드를 병렬로 실행 할 수 있지만 Gradle은 어떤 task가 업데이트 되었고 안되었는지를 체크하기 때문에 incremental build를 허용한다.
  - 이미 업데이트된 테스크에 대해서는 작업이 실행 되지 않으므로 빌드 시간이 단축됨

