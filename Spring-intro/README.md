# Spring Intro
>### Spring_Intro 레포지토리의 목표는,   
> 가장 기본적인 기능들을 살펴보고 코드를 직접 작성하고 돌려보면서,   
웹 애플리케이션을 개발할 때 어떤 기술들이 어떻게 사용되는지,   
스프링 개발의 전반적인 감을 잡고 큰 그림을 머릿속에 그리는 것입니다.
> 
> 일단 가장 쉬운 예제로 스프링 웹 애플리케이션을 만드는 핵심 사이클을 돌려보았습니다.   
> 자연스럽게 큰 그림이 그려지고, 앞으로 어떤 부분을 깊이있게 학습해야 하는지 파악했습니다.

---
## Index
[프로젝트 환경설정](#프로젝트-환경설정)
- 프로젝트 생성
- 라이브러리 살펴보기 
- View 환경설정 
- 빌드하고 실행하기

[스프링 웹 개발 기초](#스프링-웹-개발-기초)
- 정적 컨텐츠 
- MVC와 템플릿 엔진 
- API      

[회원 관리 예제 - 백엔드 개발](#회원-관리-예제-백엔드-개발)
- 비즈니스 요구사항 정리
- 회원 도메인과 리포지토리 만들기 
- 회원 리포지토리 테스트 케이스 작성 
- 회원 서비스 개발 
- 회원 서비스 테스트
#### 스프링 빈과 의존관계
- 컴포넌트 스캔과 자동 의존관계 설정 
- 자바 코드로 직접 스프링 빈 등록하기
#### 회원 관리 예제 - 웹 MVC 개발 
- 회원 웹 기능 - 홈 화면 추가 
- 회원 웹 기능 - 등록
- 회원 웹 기능 - 조회
#### 스프링 DB 접근 기술
- H2 데이터베이스 설치 
- 순수 Jdbc 
- 스프링 통합 테스트 
- 스프링 JdbcTemplate 
- JPA
- 스프링 데이터 JPA
#### AOP
- AOP가 필요한 상황
- AOP 적용  

***

목차순으로 내용을 정리하였습니다.

# 프로젝트 환경설정   
> ## [✅ 프로젝트 생성](https://github.com/mgyokim/Spring/commit/d4b13f2cc5ffe0b0c397dcaeac00ef40017517b9)   
>    
> https://start.spring.io 사이트를 이용하여 프로젝트를 생성했습니다.    
> ***Dependencies*** 에는 ***Spring Web*** , ***Thymeleaf*** 를 추가했습니다.    
> 
> ![image](https://user-images.githubusercontent.com/66030601/197760064-a8069124-207f-4bee-9bc2-b1f8009b05e1.png)     
> 프로젝트 구조를 살펴보겠습니다.    
> ***.idea*** 는 인텔리제이가 사용하는 설정파일입니다.    
> ***gradle*** 에 ***wrapper*** 는, ***gradle*** 관련되어 사용되는 폴더입니다. ***gradle***은 그루비를 이용한 빌드 자동화 시스템입니다.    
>  
> ***src*** 폴더를 보면, ***main*** 폴더와 ***test*** 폴더가 있습니다. 요즈음에는 ***Maven*** 과 ***Gradle*** 둘다 기본적으로 ***main*** 폴더와 ***test*** 폴더가 나누어져 있습니다.    
> ***main*** 폴더 내부에는 ***java*** 와 ***resources*** 가 있고, ***java*** 밑에 실제 패키지와 소스파일들이 있습니다.    
> 그리고 ***test*** 폴더는 ***test*** 코드들과 관련된 소스들이 들어갑니다.    
> 이러한 프로젝트 구조에서 파악할 수 있는 것은, 개발에서 _**"테스트 코드가 정말 중요하다."**_ 라는 것 입니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/197843731-8f056a1e-18aa-4406-8d39-eb8d79617466.png)   
> 이번에는 ***build.gradle*** 을 살펴보았습니다.    
> 예전에는 이것들을 전부 하나씩 코드를 작성했어야 하는데, 요즈음에는 ***start.spring.io*** 를 이용하여 ***springboot*** 를 사용하면서 개발자 친화적으로 이렇게 설정파일들이 모두 제공이 됩니다.   
>
> 소스를 보면, 제가 프로젝트 생성시에 설정했던, ***SpringBoot2.6.7*** 버전, ***java*** 언어를 선택한 것 등이 플러그인으로 들어갑니다.    
> 추가로 소스의 ***repositories*** 를 보면, ***mavenCentral()*** 이라고 되어 있는데, 이것이 뭐냐면,    
> 우리가 앞서 추가한 라이브러리를 어디선가 다운받아야 하는데, "mavenCentral 이라는 공개된 사이트에서 다운로드 받아라."라고 설정을 간편하게 해놓은 것입니다.   
> 필요하다면 우리가 특정 사이트의 url을 넣을 수도 있습니다.    
>     
> ***dependencies*** 를 보면, ***SpringBoot*** 를 생성할 때 추가했던 ***html 템플릿 엔진*** 인 ***thymeleaf*** 그리고 웹프로젝트로 ***Spring Web*** 을 선택했던 것을 확인할 수 있습니다.    
> ***testImplementation*** 은 기본적으로 ***junit*** 이라는 테스트 라이브러리가 자동으로 들어간 것을 확인할 수 있습니다.    
>     
> ***gitignore*** 파일은 소스코드를 관리해주는 것입니다.    
> 깃에는 소스코드만 올라가야 되고, 빌드된 결과물 같은 것이 올라가면 안됩니다.    
>    
> ***HelloSpringApplication*** 의 ***main*** 메서드를 실행해보겠습니다.
>     
> ![image](https://user-images.githubusercontent.com/66030601/197767081-e1256f83-f3d2-4e09-af0c-627ff53c2356.png)
>     
> 위 그림과 같이 ***Spring*** 이 뜨면서 ***SpringBoot*** 버전 이 2.6.7이라고 확인할 수 있습니다.    
> 내용을 좀더 자세히 보면, ***Tomcat started on port:8080*** 을 확인할 수 있습니다.   
>     
> ![image](https://user-images.githubusercontent.com/66030601/197772818-686692ae-ff73-4e60-a1df-bde8ce996f48.png)   
> 웹브라우저에서 ***localhost:8080*** 으로 접속하면 위와 같은 화면을 볼 수 있습니다.    
>
> 위에서 실행한 ***main*** 메서드를 간단히 설명하자면,    
> ***SpringApplication.run*** 을 해서 ***HelloSpringApplication*** 클래스를 실행하는 것입니다.
> 
> ![image](https://user-images.githubusercontent.com/66030601/197780299-7ca62792-a569-4da7-aadd-c335d9bb0e21.png)
> ***@SpringBootApplication*** 어노테이션 내부를 확인 해보았습니다. 크게 3가지의 역할을 수행합니다.
> 
> 1.***@SpringBootConfiguration*** - 사용자가 추가적으로 빈이나 설정 클래스들을 등록 가능하게 합니다.
> 
> 2.***@EnableAutoConfiguration*** - ***jar properties*** 를 기반으로 자동으로 의존성을 설정합니다.   
>    
> 3.***@ComponentScan*** - ***@Component*** 가 적용된 클래스들을 스캔하여 자동으로 빈 등록을 합니다.   
>
> ---
> ## ✅ 라이브러리 살펴보기
> ![image](https://user-images.githubusercontent.com/66030601/197784492-8b0a13e6-5a87-4ca2-99e8-9206ad728871.png)    
> 프로젝트를 생성할 때 선택한 라이브러리는 ***Spring Web*** , ***thymeleaf*** 2개였습니다.    
> ***build.gradle*** 을 살펴보면, 자동으로 ***test*** 라이브러리도 들어온 것을 볼 수 있습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/197785313-4cf35a5d-cef9-4e26-9c6e-61ea58d678c8.png)   
> 실제 라이브러리를 들어가서 살펴보면, 당겨온 라이브러리들이 엄청나게 많이 있습니다.   
> ***Gradle*** 은 의존관계가 있는 라이브러리를 함께 다운로드 해준다는 것을 알 수 있습니다.
>![image](https://user-images.githubusercontent.com/66030601/197785825-51327803-4b6a-48c3-a4a2-f0c1a781d7b3.png)  
> 이렇게 소스 라이브러리에서 웹서버인 ***tomcat*** 을 내장하여 들고 있는 것도 확인할 수 있습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/197786003-0f7ce841-19bb-4731-83cf-f775809c2d41.png)   
> 그리고 ***spring-core*** 도 다운되어 있는 것을 확인할 수 있습니다.    
> 한마디로, ***spring-boot*** 와 관련된 라이브러리를 사용하면,   
> ***spring-core*** 도 다 당겨와서 ***Spring*** 과 관련된 것들이 전부 세팅되서 돌아간다고 이해할 수 있습니다.   
>
> ![image](https://user-images.githubusercontent.com/66030601/197787623-03779ca6-8f51-4374-bcdd-f773eb0551b5.png)   
> 그리고 ***log*** 부분에 대해서 언급을 하자면, ***log*** 는 ***System.out.println*** 으로 찍으면 안됩니다.   
> ***log*** 로 남겨야 심각한 에러를 따로 모아서 로그 파일들을 관리할 수 있습니다.   
> 즉, 실무에서는 로깅을 사용해야 합니다.      
>
> ***Gradle*** 에서 살펴보면 ***spring-boot-starter-logging*** 을 찾을 수 있습니다.    
> 그 안을 보면, ***slf4j***, ***logback*** 을 볼 수 있습니다.   
> ***slf4j*** 는 쉽게말해서 인터페이스이고, "실제 로그를 어떤 구현체로 출력할거야." 라는 것으로 ***logback***을 많이 선택합니다.   
>
> 요즘에는 ***slf4j*** 와 ***logback*** 조합을 많이 사용합니다. 그래서 ***spring-boot-starter*** 에서 이 두개를 표준으로 가져옵니다.   
>
> ![image](https://user-images.githubusercontent.com/66030601/197788654-b4e68ffe-001d-46c2-bb68-9083ed7e15db.png)   
>
> 이번에는 ***test*** 쪽을 살펴보겠습니다.   
> 테스트를 할 때, java 진영에서는 ***junit*** 이라는 라이브러리를 사용합니다. 
> 그래서 spring 에서도 ***junit*** 라이브러리를 사용합니다.    
> ***test*** 부분에 다른 것들도 많이 있는데, ***assertj*** 라이브러리는 테스트를 편리하게 하도록 도와주는 라이브러리입니다.   
> 
>---
> ## [✅ View 환경설정](https://github.com/mgyokim/Spring/commit/ad758650cbec3fd7e1e257e24606916804214d4c)
> 이번에는 ***Welcome Page*** 을 만들어 보도록 하겠습니다.   
>
> ***SpringBoot*** 는 Spring생태계 자체를 감싸서 편리하게 사용할 수 있도록 도와줍니다.   
> ***Spring*** 은 Java 엔터프라이즈 웹애플리케이션 개발과 관련된 전반의 생태계를 거의 다 제공하기 때문에 어마어마하게 큽니다.   
> 그래서 필요한 것을 잘 찾는 능력이 중요합니다.   
>
> "Welcome Page"는 어떻게 만들지? 라고 할 때는 아래와 같이 하면 됩니다. 
> ![image](https://user-images.githubusercontent.com/66030601/197795167-b474d64a-2fdf-451a-887c-1d8d75aedb70.png)   
> ***Spring.io*** 사이트의 ***Document*** 에서 Web섹션을 살펴보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/197796032-a02cef37-129a-43c6-95cf-58b30756db8d.png)   
> ***static*** 폴더에서 ***index.html*** 을 먼저 찾고, 만약에 못찾으면 ***index template*** 를 찾는 방식... 으로 동작한다는 내용을 확인할 수 있습니다.   
>
> ***index.html***에 코드를 작성해서 실행한 것은 정적페이지 입니다.   
> 그냥, 우리가 적은 파일을 웹서버가 그대로 웹브라우저에 응답을 주는 것입니다.  프로그래밍이라기보다는 파일을 그대로 던져준 것입니다.  
>
> 그런데, 템플릿 엔진이라는 것을 사용하면,
> 내가 원하는대로 ***loop*** 를 넣거나 해서 모양을 바꿀 수 있습니다. 
> ![image](https://user-images.githubusercontent.com/66030601/197797835-a13f6f67-6565-40aa-9f11-6470d02b7a45.png)   
> Document에 자주 사용하는 템플릿 엔진들이 제시되어 있습니다. 그중에 ***Thymeleaf*** 를 선택한 것입니다.   
>   
> ![image](https://user-images.githubusercontent.com/66030601/197821372-21386ddb-199c-43ba-8a1e-acabdae2d0fb.png)   
> 우선, 웹애플리케이션의 첫번째 진입점인 컨트롤러를 만들었습니다.    
> 
> ***@Controller*** 어노테이션과 ***@GetMapping*** 어노테이션을 사용했습니다.    
> 
> ![image](https://user-images.githubusercontent.com/66030601/197821872-8ac357bf-39da-4c56-9595-e6c2731d55d0.png)   
> ***@GetMapping*** 에서 return 시킬 ***html*** 을 ***thymeleaf*** 를 적용해서 작성했습니다.   
>    
> _**${data}**_ 부분이 ***HelloController.java*** 에서 ***model.addAttribute*** 에서 ***key*** 로 넣었던 ***data*** 의 ***value*** 인 ***"hello!!"*** 로 치환됩니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/197822357-570f4599-fa4d-4ff9-89d5-233ef59da196.png)   
> 실제 랜더링 된 화면의 _**html**_ 소스를 살펴보면, 잘 치환된 것을 확인할 수 있습니다.  
>   
> ![image](https://user-images.githubusercontent.com/66030601/197822646-61a7120d-167d-404e-a7f5-d2d47ff4f09b.png)   
> 동작 환경을 그림으로 살펴보겠습니다.  
> 
> 먼저 웹브라우저에서 _**loclahost:8080/hello**_ 라고 던지면,   
> 스프링 부트는 내장하고 있는 _**tomcat**_ 서버에서 이것을 받아서,   
> "어? _**/hello**_ 네?" 라고 하면서 스프링한테 던져서 물어봅니다.    
> 
> 스프링이 ***helloCOntroller*** 를 보고 _**@GetMapping**_ 어노테이션으로 감싸있으며 ***/hello*** 가 매핑된 메서드가 실행되게 됩니다.   
> 그러면, 스프링이 모델이라는 것을 만들어서 넣어주는데, 해당 모델에다가 ***model.addAttribute*** 를 해서 ***key*** 는 _**data**_ , ***value*** 는 _**hello!!**_ 라고 넣어 놓게 됩니다.   
> 그리고 ***return*** 을 하는데, _**return**_ 의 이름이 ***"hello"*** 입니다.   
> 
> 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버(_**viewResolver**_)가 화면을 찾아서 처리합니다.   
> 스프링 부트 템플릿엔진 기본 _**viewName**_ 매핑이 되며, _**resources:templates/+(ViewName)+.html**_ 입니다.   
> 
> ---
> ## ✅ 빌드하고 실행하기
> ![image](https://user-images.githubusercontent.com/66030601/197828613-c155c0c8-a794-4e05-a12c-e65cd00dbee0.png)   
> 터미널에서 빌드할 프로젝트가 저장되있는 디렉토리로 이동합니다.      
> <pre><code>./gradlew build</code></pre>   
> 그리고 터미널에서 위의 명령어를 이용해서 ***Build*** 를 합니다.   
> ![image](https://user-images.githubusercontent.com/66030601/197829074-a23cc835-ee8a-4678-96e5-09a9abbe1ad9.png)   
> ***build*** 가 완료되었습니다.  ***build*** 를 완료하면 _**build**_ 폴더가 생기는데, 해당 폴더를 확인해보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/197829215-8f5af4bc-5b67-4c73-9185-5c1ba940cb2b.png)   
>
> 여러 폴더를 확인할 수 있습니다. 그중, ***libs*** 폴더로 이동해서 확인해보겠습니다.
> ![image](https://user-images.githubusercontent.com/66030601/197829327-7fe049ed-38c8-4c95-a502-86cb76838fdc.png)   
> _**hello-spring-0.0.1-SNAPSHOT.jar**_ 이라는 이름으로 18M 짜리 파일이 만들어져 있습니다.
> <pre><code>java -jar hello-spring-0.0.1-SNAPSHOT.jar</code></pre>
> 위의 명령어를 이용해서 _**hello-spirng-0.0.1-SNAPSHOT.jar**_ 파일을 실행해보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/197829801-0865ce03-c1b4-49a1-b9ec-5217160a988d.png)   
> 잘 실행되는 것을 확인할 수 있습니다.  ***localhost:8080*** 도 잘 작동합니다.   
>    
> 서버를 배포할 때는, _**hello-spring-0.0.1-SNAPSHOT.jar**_ 파일만 복사해서 서버에 넣고,   
> <pre><code>java -jar 파일.jar</code></pre>   
> 이 명령어로 실행을 시키면 됩니다. 그러면 서버에서도 ***spring*** 이 동작하게 됩니다. 

# 스프링 웹 개발 기초
> ## [✅ 프로젝트 생성](https://github.com/mgyokim/Spring/commit/592992a224300c1b6514b728a5282d463b10a603)
> 웹을 개발한다는 것은 크게 3가지 방법이 있습니다.    
>     
> 1.정적 컨텐츠   
> 이전에 _**welcome page**_ 처럼 서버에서 그냥 파일을 그대로 웹브라우저에 내려주는 것입니다.
>    
>2.MVC와 템플릿 엔진   
> 예를 들어 과거에 ***JSP*** 와 ***PHP*** 가 소위 말하는 템플릿 엔진인데,    
> ***HTML*** 을 그냥 주는 것이 아니라, 서버에서 프로그래밍을 통해 ***HTML*** 을 동적으로 바꿔서 내리는 것입니다.    
> 이것을 하기 위해서 _**Model**_, _**Controller**_, _**View**_ 패턴을 이용합니다.   
>    
> 3.API   
> 만약에 안드로이드를 개발한다고하면, 서버입장에서는 예전에는 ***xml*** 이라는 포맷을 많이 사용했는데,   
> 요즈음에는 ***json(JavaScriptObjectNotation)*** 이라는 데이터구조 포맷으로 데이터를 내려줍니다.    
> ***html*** 이 아니라, 데이터구조 포맷으로 클라이언트한테 데이터를 전달하는 방식을 _**API**_ 방식이라고 합니다.    
> _**API**_ 방식은 요즘에 뷰, 리액트 등을 쓸 때도 ***API*** 로 데이터만 내려주면, 화면은 클라이언트가 알아서 그리고 정리하는 방식에도 이용됩니다.    
>    
> ![image](https://user-images.githubusercontent.com/66030601/197964518-19cf56e1-1129-4731-9791-ee08c0f22740.png)   
> 스프링 부트는 정적 컨텐츠 기능을 자동으로 제공합니다.    
> 기본 설정으로 스프링 부트는 _**/static**_ 폴더에서 찾아서 제공한다는 것을 Document에서 확인할 수 있습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/197964847-8047a452-e88d-47a2-ae0f-f386463ee371.png)   
> 웹브라우저에서 _**"http://localhost:8080/hello-static.html"**_ 를 치면,    
> 내장 톰켓 서버에서는 요청을 받고, "_**"hello-static.html"**_ 이라고 요청이 왔대!!" 하고서 스프링에게 넘깁니다.    
> 스프링은 먼저, 컨트롤러 쪽에 _**hello-static**_ 이라는게 있는지 찾아봅니다. 컨트롤러가 우선순위를 먼저 가진다는 의미입니다.   
>     
> ***hello-static***으로 매핑된 컨트롤러가 없다면,   
>    
> ![image](https://user-images.githubusercontent.com/66030601/197965564-51da573b-718a-4a9b-9b71-b976d1a4b645.png)   
> 후순위로 _**resources**_ 폴더 내부에 있는 ***static/hello-static.html***을 찾습니다.   
> 이러한 순서로 해당 파일을 찾으면, 웹브라우저에 반환을 해주는 것 입니다.   
> ---
> ## [✅ MVC와 템플릿 엔진](https://github.com/mgyokim/Spring/commit/d88c6b3f2bd8247bedd9dd084aa6484b1971a293)      
> ***MVC*** 란, _**Model**_, _**View**_, ***Controller*** 의 약자입니다.   
>    
> ***View*** 는 화면을 그리는데에 모든 역량을 집중해야합니다.   
> ***Controller*** 나 _**Model**_ 과 관련된 부분에서는 비즈니스 로직과 관련이 있거나, 뭔가 내부적인 것을 처리하는데 집중해야 합니다.   
>    
> 이러한 이유로, _**Model**_, _**View**_, ***Controller***를 분리한 것입니다.   
>    
> ***View*** 는 화면과 관련된 일만,   
> 비즈니스 로직과 서버 뒷단에 관련된 것은, ***Controller*** 나, 뒷단 비즈니스 로직에서 전부 처리하고,   
> 화면에서 필요한 관련된 것들을 ***Model*** 에다가 담아서 화면쪽에 넘겨주는 패턴을 많이 사용합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/197969965-314eb942-f7f1-401d-8082-8717547fb559.png)   
> ***@RequestParam*** 을 이용하면 외부에서(웹에서) _**url**_ 로 파라미터를 받을 수 있습니다.    
> ![image](https://user-images.githubusercontent.com/66030601/197970700-3961be48-ef65-4b4c-b889-7022fad3b24b.png)   
> 만약, 이렇게 파라미터를 받게되면,    
> ![image](https://user-images.githubusercontent.com/66030601/197970969-7d8cb219-ccdc-40a7-9e33-806e795cd8d6.png)   
> ***Controller*** 에서 ***name*** 이 _**spring!**_ 이라고 바뀝니다. 그리고 이것이 ***model.addAttribute("name", name)*** 로 ***model***에 담깁니다.   
> 그리고 ***tempalte*** 로 넘어가서, _**$**_ 에 표시되어 있는 것은 모델에서 값을 꺼내는 것입니다.    
> _**${name}**_ 은 모델에서 _**key**_ 가 _**name**_ 인 것의 _**value**_ 를 꺼내는 것입니다.   
> 이런 과정으로 치환해서 보여줍니다.   
>    
> 이 과정을 간단한 그림으로 알아보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/197971613-b1a1e9af-0354-4089-b67f-ce92dcf4c3d4.png)    
> 웹 브라우저에서 ***localhost8080/hello-mvc*** 를 넘기면, _**springboot**_ 를 띄울 때, 같이 띄우는 내장 톰켓 서버를 거칩니다.    
> 내장 톰켓 서버는 "***hello-mvc*** 라는게 왔어!" 라고 스프링한테 던집니다.      
>    
> 스프링은 "***helloController*** 에 _**hello-mvc**_ 메서드가 매핑이 되어있네?"라고 하며 _**hello-mvc**_ 메서드를 호출해줍니다.   
> 그런데, _**return**_ 을 해줄 때, 이름을 _**hello-template**_, 그리고 ***model***에는 ***key***는 _**name**_, ***value***는 ***spring*** 이라고 지정했으므로 이것을 스프링한테 넘겨줍니다.    
>    
> 그러면 스프링에 있는 _**viewResolver**_ 라는 화면과 관련된 해결자가 동작을 합니다.   
> _**viewResolver**_ 는 _**view**_ 를 찾아주고, 템플릿 엔진을 연결시켜줍니다.   
>    
> 그러면 _**viewResolver**_ 가 _**templates**_ 폴더에서 _**hello-template**_ 라는 앞의 _**return**_ 의 이름과 똑같은 _**html**_ 을 찾아서 _**thymeleaf**_ 템플릿 엔진에게 처리해달라고 넘깁니다.    
>    
> 그러면, 템플릿 엔진이 랜더링을 해서 _**html**_ 로 변환을 하여 웹브라우저에 반환해줍니다.    
>     
> 정적일때는 변환을 하지 않고 그대로 반환을 해주었지만,   
> 이러한 템플릿 엔진에서는 변환을 해서 웹브라우저에 반환합니다.      
> 참고로, ***@RequestParam*** 에 _**required=false**_ 옵션을 주게되면, 파라미터를 넘기는 것은 필수가 아니라 선택사항이 됩니다.   
> ---
> ## [✅ API](https://github.com/mgyokim/Spring/commit/50ecbd3e63642acd687e2237bcd344ae3285c527)   
> 정적 컨텐츠 방식을 제외하면,    
> 앞서 살펴보았던 _**MVC**_ 방식처럼 _**View**_ 를 찾아서 템플릿 엔진을 통해서 화면을 랜더링하고, _**html**_ 로 변환해서 웹브라우저에 넘겨주는 방식이 있고,   
> 그 다음 방법이 _**API**_ 를 사용하는 방법이 있습니다.   
>    
> 그러니까, 정적 컨텐츠 방식을 제외하면,   
> 2가지 방법만 기억하면 됩니다.   
>    
> _**MVC**_ 방식처럼 ***HTML*** 로 내리냐,   
> 아니면 _**API**_ 라는 방식으로 데이터를 바로 내리냐의 차이입니다.   
>    
> 이번에는 _**API**_ 방식에 대해서 알아보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198003521-a53113d9-318f-44b7-8fd3-535d62c61f87.png)    
> ***@ResponseBody***는 ***HTML***에 나오는 _**body**_ 태그를 이야기 하는게 아니라,   
> _**http**_ 통신 프로토콜에서 _**header**_ 부와 _**body**_ 부가 있는데, _**body**_ 부에 _**return**_ 으로 준 _**"hello" + name**_;을 직접 넣어주겠다는 의미입니다. (***body*** 부에 직접 넣어주겠다는 의미입니다.)   
> 만약, _**name**_ 을 ***spring***으로 주면, _**return**_ ***"hello spring"*** 으로 바뀔 것 입니다.    
> 즉, 이 문자가, 내가 요청한 클라이언트에 그대로 내려갑니다.   
>    
> 이 방식과 템플릿엔진 방식의 차이는,   
> _**view**_ 없이, 그냥 해당 문자가 그대로 내려간다는 것입니다.    
>     
> _**@ResponseBody**_ 방식은, 데이터를 그대로 내려줍니다.  
> 즉, 뷰 리졸버(_**viewResolver**_)를 사용하지 않습니다.    
>    
> 이번에는 _**@ResponseBody**_ 객체 반환을 해보겠습니다.   
> 만약 문자가 아니라, 데이터를 반환해야 하는 상황 때문에 _**API**_ 방식을 많이 사용합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198006868-87ceb781-39c7-4bc2-986f-f95666dcd00f.png)   
> 이런식으로 작성을 해주었고, _**Java Bean**_ 규약을 지키기 위해 노력했습니다.   
> ***private String name;*** 이라고 선언하고, _**getter**_, ***setter*** 를 _**public**_ 으로 열어두고, 해당 메서드를 통해 _**name**_ 에 접근하도록 하였습니다.      
> 이러한 _**getter**_, _**setter**_ 방식을 프로퍼티 접근 방식이라고 합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198007417-fd6da5e9-6ebe-4f43-a004-61a73825a2fb.png)   
> 서버를 돌려서 확인해보면, ***JSON*** 방식으로 데이터가 전달 된 것을 확인할 수 있습니다.   
>    
> ***JSON*** 은 _**key**_, ***value*** 로 이루어진 구조입니다.   
> 과거에는 _**xml**_ 방식도 많이 쓰였으나, _**xml**_ 방식은 _**<HTML></HTML>**_ 처럼 열고 닫고를 두번씩 해야하는데,   
> _**JSON**_ 은 _**key**_, _**value**_ 로 되어 있어서 심플하며, 최근에는 거의 _**JSON**_ 방식으로 통일 되었습니다.   
>    
> _**Spring**_ 은 기본적으로 객체를 반환하면서 _**@ResponseBody**_ 라고 해놓으면, _**JSON**_ 방식으로 반환하는 것이 기본입니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198009350-9d129164-b3a8-45f9-ad90-2802cb8b81e7.png)   
>     
> 이번에는 간단한 그림을 통해 _**@ResponseBody**_ 를 사용했을 때의 동작과정을 살펴보겠습니다.    
>    
> 먼저, _**localhost:8080/hello-api**_ 를 요청하면,   
> 톰켓 내장서버에서 "_**hello-api**_ 가 요청으로 왔어!"라고 스프링에 던집니다.   
>    
> 스프링은, "여기보니까 _**hello-api**_ 가 매핑된 컨트롤러가 있네?"라고 하는데,    
> "어? 근데 _**@ResponseBody**_ 라는 애너테이션이 붙어있네?"라고 합니다.   
> 원래, 이런게 안붙어 있으면, 이전에 살펴본 템플릿 엔진 처럼 _**viewResolver**_ 한테 던지면서 "나한테 맞는 _**template**_ 찾아서 돌려줘!"라고 하는데,   
> _**@ResponseBody**_ 가 붙어있으면,   
> "_**http**_ 응답에 데이터를 그대로 넘겨야 되겠구나!"라고 동작을 합니다.   
>    
> 그런데, 보니까 _**hello**_ 가 문자가 아니라 객체입니다.   
> 문자의 경우에는 문자값을 그대로 _**http**_ 응답에 넣어서 주고 끝이었지만, 지금은 객체를 줘야하므로 스프링이 생각을 합니다.   
> "객체를 줘야하는데?"   
> 스프링에서는 이것을 어떻게 할지 디폴트 값이 정해져 있습니다.   
> "객체가 오면, 기본 디폴트로 _**JSON**_ 방식으로 데이터를 만들어서 _**http**_ 응답에 반환하겠다" 라는 것이 스프링의 기본 정책입니다.   
>    
> 즉, _**@ResponseBody**_ 라고 오면서 객체를 넘기면,   
> 몇가지 조건을 보는데,    
> 우선, _**@ResponseBody**_ 가 있으면 _**HttpMessageConverter**_ 라는 것이 동작을 합니다.   
> 그리고 만약, 반환하는게 단순히 문자이면, _**StringConverter**_ 라는게 동작을 하게 됩니다.   
> 그런데 반환하는것이 객체이면, _**JsonConverter**_ 라는 것이 동작을 합니다.   
> 그러면서 객체를 _**JSON**_ 스타일로 바꿉니다.("어? _**key**_ 로 _**name**_ 이 있고, _**value**_ 로 값이 있네?"라고 하며..)   
> 그리고 _**JsonConverter**_ 는 _**JSON**_ 스타일로 바꾼 것을 나를 요청한 웹브라우저 or 서버에게 보내줍니다.   
>    
> 정리하자면, _**@ResponseBody**_ 를 사용한 _**API**_ 는 이러한 과정으로 동작합니다.   
> - _**@ResponseBody**_ 를 사용   
> -- ***HTTP*** 의 ***BODY*** 에 문자 내용을 직접 반환  
> -- _**viewResolver**_ 대신에 ***HttpMessageConverter*** 가 동작   
> -- 기본 문자처리 : _**StringHttpMessageConverter**_   
> -- 기본 객체처리 : _**MappingJackson2HttpMessageConverter**_   
> -- byte 처리 등등 기타 여러 ***HttpMessageConverter*** 가 기본으로 등록되어 있음   
>   
> 참고로, 클라이언트의 _**HTTP Accept**_ 헤더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 ***HttpMessageConverter*** 가 선택됩니다.

# 회원 관리 예제 백엔드 개발
> ## ✅ 비즈니스 요구사항 정리   
> 회원 관리 예제를 만들어 보겠습니다.    
>  
> 먼저, 비즈니스 요구사항을 정리 할 것입니다.     
> 
> 그 다음, 회원 도메인과 회원 객체를 저장하고 불러올 수 있는 저장소라고 불리는 리포지토리를 만들 것입니다.     
> 
> 그리고 회원 리포지토리가 정상 동작하는지 테스트 케이스를 작성할 것이고,      
>      
> 실제 비즈니스 로직이 있는 회원 서비스를 만들고 이것이 정상적으로 동작하는지 테스트를 만들 것입니다.    
> 이때, 테스트는 Junit이라는 테스트 프레임웍을 이용해서 만들겠습니다.    
>     
> 이번시간에는 비즈니스 요구사항을 정리하겠습니다.   
> - 데이터 : 회원 ID, 이름    
> - 기능 : 회원 등록, 조회
> - 아직 데이터 저장소가 선정되지 않음(가상의 시나리오)   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198045717-c023b0a6-2efb-4395-b3d2-4bcf9c01a379.png)   
> 일반적인 웹 애플리케이션 계층 구조는,   
> - 컨트롤러 : 웹 MVC의 컨트롤러 역할
> - 서비스 : 핵심 비즈니스 로직 구현
> - 리포지토리 : 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
> - 도메인 : 비즈니스 도메인 객체, 예) 회원, 주문, 쿠폰, 등등 주로 데이터 베이스에 저장하고 관리됨   
>    
> 이렇게 이루어져 있습니다.   
> 이번 예제에서는 이러한 일반적인 웹 어플리케이션 계층 구조를 따라 갈 것입니다.   
>     
> ![image](https://user-images.githubusercontent.com/66030601/198046819-de94eb18-f414-4ffc-b4df-a1fefcf01c2c.png)   
> - 아직 데이터 저장소가 선정되지 않아서, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계   
> - 데이터 저장소는 RDB, NoSQL등등 다양한 저장소를 고민중인 상황으로 가정   
> - 개발을 진행하기 위해서 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용    
>    
> 클래스 의존관계는 회원 비즈니스 로직에 있는 회원 서비스(_**MemberService**_)가 있고,   
> 회원을 저장하는 ***MemberRepository*** 는 인터페이스로 설계할 것입니다.
> 왜냐하면, 앞서 비즈니스 요구사항에 가상의 시나리오로 주어진 조건으로 "아직 데이터 저장소가 선정되지 않음" 이 있기 떄문입니다.   
>    
> _**MemberRepository**_ 는 인터페이스로 만들고 구현체를 _**MemoryMemberRepository**_ (메모리에 저장할 수 있도록 간단하게 작성할 수 있는 것)으로 만들겠습니다.   
> 즉, 인터페이스로 설계하고, 단순한 구현체를 만들고, 향후에 구체적인 기술이 선정되면, 이것을 바꿔끼우겠습니다.         
>    
> ---   
> ## [✅ 회원 도메인과 리포지토리 만들기](https://github.com/mgyokim/Spring/commit/50ecbd3e63642acd687e2237bcd344ae3285c527)   
> ![image](https://user-images.githubusercontent.com/66030601/198051886-75de76d9-f254-46dd-96f1-e735fb67a3ec.png)   
> _**hello.hellospring.domain**_ 이라는 이름으로 새로운 패키지를 생성하고, _**domain**_ 패키지에 _**Member**_ 라는 이름의 클래스를 생성했습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198052091-5ef72742-ecb7-44a2-a31a-06a4286188da.png)   
> 여기서 _**id**_ 는 임의의 값인데, 데이터 베이스든 데이터에 저장할 때 사용하는 단순 시퀀스로 정해지는 임의의 값입니다.   
> 고객이 정하는 _**id**_ 가 아니라 데이터를 구분하기 위해서 시스템이 저장하는 _**id**_ 값입니다.   
> _**name**_ 은 이름입니다.   
> _**getter**_, ***setter*** 를 만들어 주었습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198053450-e302f3c3-5d93-4049-987e-78450dd9e5b4.png)    
> 이번에는 회원 리포지토리 인터페이스를 만들겠습니다.   
> 우선, 패키지를 만들었습니다. 이름은 ***hello.hellospring.repository*** 로 생성했습니다   
> 그리고, _**MemberRepository**_ 라는 이름의 인터페이스를 만들었습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198054085-b0f7c707-16f5-494e-8886-bf6909d3b829.png)    
> 기능을 선언 할 것 입니다.    
>    
> _**save**_ 를 만듭니다. 회원을 저장하면, 저장된 회원이 반환됩니다.   
> _**findById(Long id);**_ 라고 해서 앞서 생성했던 _**id**_ 로 회원을 찾는 것을 만들 것입니다.   
> 그리고 ***findByName(String name);*** 은 _**name**_ 으로 회원을 찾는 기능입니다.   
> _**findAll();**_ 기능은 지금까지 저장된 모든 회원 리스트를 반환해줍니다.   
>    
> _**Optional**_ 은 _**findById**_ 혹은 _**findByName**_ 을 가져오는데 이것이 _**Null**_ 일 수 도 있는데, 이때 ***Null*** 을 처리하는 방법중에,   
> _**Null**_ 을 그대로 반환하는 것 보다 _**Optional**_ 이라는 것으로 감싸서 반환하는 방법을 선호합니다. java8에 들어가 있는 기능입니다.   
>    
> 각 기능을 선언했으므로 이제 구현체를 만들어야 합니다.   
>   
> ![image](https://user-images.githubusercontent.com/66030601/198056898-8dad7e0f-35ff-4461-ac79-cffca9eeda6a.png)    
> ***MemoryMemberRepsotiroy*** 라는 구현체를 만들었고, _**MemberRepository**_ 인터페이스의 추상메서드를 오버라이딩 했습니다.   
> 이제 구현을 해보겠습니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/198057256-661f57bc-da06-4f78-af61-14eae8c88802.png)    
> 먼저, _**save**_ 를 할 때, 저장을 어딘가에는 해야 할 것입니다.   
> _**Map**_ 자료구조를 이용해보겠습니다. _**key**_ 는 회원의 아이디이므로, _**Long**_ 타입, 그리고 _**value**_ 는 _**Member**_ 타입으로 정의합니다.   
> 그리고 _**store**_ 라는 참조변수를 만들고, ***new HashMap<>();*** 을 해줍니다.    
> 실무에서는 이렇게 공유되는 변수일 때는 동시성 문제가 있을 수 있기 때문에 _**ConcurrentHashMap**_ 을 사용해야 하는데, 예제에서는 단순하게 _**HashMap**_ 을 사용하도록 하겠습니다.    
>     
> 그리고 _**sequence**_ 를 만들어주는데, _**sequence**_ 는 단순하게 0, 1, 2 이런식으로 _**key**_ 값을 생성해 주는 것이라고 보면 됩니다.    
> 이것 또한 실무에서는 _**Long**_ 보다는 동시성 문제를 고려해서 ***Atomic Long*** 을 사용해야 하는데, 이 예제에서는 단순하게 _**Long**_ 을 사용하도록 하겠습니다.    
>     
> 그리고, _**member.setId(++sequence);**_ 로 시스템이 정해주는 _**id**_ 를 지정해줍니다.    
> 이렇게 _**id**_ 를 세팅하고, _**store**_ 에 저장을 합니다. _**map**_ 에 저장이 될 것입니다.   
> 그리고 저장된 결과를 반환합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198058315-bd7a169d-7900-4904-9828-7f08fb0e3706.png)    
> _**findById**_ 는 _**store**_ 에서 꺼내면 됩니다.   
> _**store.get(id)**_ 를 하면 됩니다. 그런데 만약에 이 결과가 없으면 어떻게 될까요?   
> 없으면 _**null**_ 일 것입니다.   
> 과거에는 _**null**_ 을 반환했지만, 요즘에는 _**null**_ 이 반환 될 가능성이 있으면 _**Option**_ 이라는 것으로 감싸서 반환합니다.   
> _**optional.ofNullable(store.get(id))**_ 이라고 하면,   
> _**store.get(id)**_ 가 _**null**_ 이어도 감쌀 수 있습니다.   
> 감싸서 반환해주면 클라이언트에서 무언가를 할 수 있습니다.   
> 뭘 할 수 있는지에 대해서는 뒤에서 알아보도록 하겠습니다.   
>    
> _**findByName**_ 은 _**Java**_ 의 람다를 이용해서 구현해보도록 하겠습니다.      
>     
> _**return store.values().stream()**_   
> 은 루프로 계속 돌립니다.    
>     
> _**.filter(member -> member.getName().equals(name))**_    
> 람다를 사용하는데, _**member**_ 에서 ***member.getName()*** 이 여기에 파라미터로 넘어온 ***name*** 이랑 같은지 확인합니다.      
>    
> _**.find();**_   
> 같은 경우에만 필터링이 되고, 그중에서 그냥 찾으면, 반환하는 것입니다.       
> 
> _**findAny()**_   
> 는 그냥 하나라도 찾는 것입니다.   
>     
> 이것의 결과가 ***Optional*** 로 반환이 됩니다.   
>    
> 그러면, _**Map**_ 에서 _**loop**_ 를 다 돌면서 하나라도 찾아지면 그것을 그냥 반환해 버리는 겁니다.   
> 그런데, _**loop**_ 를 끝까지 돌았는데 찾아지는게 없으면 _**optional**_ 에 _**null**_ 이 포함이 되서 반환됩니다.   
>    
> _**findAll**_ 은 _**newArrayList<>(store.values());**_ 를 반환 해주면됩니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198063428-52cf1f71-4bf8-4ea9-9882-249dd0258506.png)   
> ***store***에 있는 ***values*** 가 ***Member*** 들 입니다.   
> 즉, _**Member**_ 들이 쭉 반환이 됩니다.   
>     
> ![image](https://user-images.githubusercontent.com/66030601/198063622-fee4b05f-d90d-4e16-9304-bf64cb464384.png)    
> 간단하게 구현을 마쳤습니다.   
> 이제, 이것들이 제대로 동작을 하는지 검증을 해봐야 합니다.      
> 
> 동작을 검증하는 좋은 방법이 테스트 케이스 작성을 하는 것입니다.   




## --------------------------------------------------------
--- 
위의 목차순으로
마지막에 느낀점 

기술 발전의 맥락을 이해하고, 기술의 주인의식을 갖고,