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
                    
[스프링 빈과 의존관계](#스프링-빈과-의존관계)   
- 컴포넌트 스캔과 자동 의존관계 설정 
- 자바 코드로 직접 스프링 빈 등록하기    
            
[회원 관리 예제 - 웹 MVC 개발](#회원-관리-예제-웹-MVC-개발)
- 회원 웹 기능 - 홈 화면 추가 
- 회원 웹 기능 - 등록
- 회원 웹 기능 - 조회          
             
[스프링 DB 접근 기술](#스프링-DB-접근-기술)
- H2 데이터베이스 설치 
- 순수 Jdbc 
- 스프링 통합 테스트 
- 스프링 JdbcTemplate 
- JPA
- 스프링 데이터 JPA            
              
[AOP](#AOP)
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
>    
> ***    
> 
> ## [✅회원 리포지토리 테스트 케이스 작성](https://github.com/mgyokim/Spring/commit/50ecbd3e63642acd687e2237bcd344ae3285c527)    
> 개발한 기능을 실행해서 테스트 할 때 자바의 _**main**_ 메서드를 통해서 실행하거나,   
> 웹 어플리케이션의 컨트롤러를 통해서 해당 기능을 실행 해볼 수 있는데, 이러한 방법은 준비하고 실행하는데 오래 걸리고,   
> 반복실행하기 어려우며, 여러 테스트를 한번에 실행하기 어렵다는 단점이 있습니다.   
>    
> 자바는 _**JUnit**_ 이라는 테스트 프레임워크로 테스트를 실행할 수 있습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198220387-09e43a39-1087-4d63-9dfb-7eed0be844a9.png)   
> _**test**_ 폴더의 _**java**_ 의 _**hello**_ 의 _**hellospring**_ 폴더에 _**repository**_ 라는 이름의 패키지를 만들었습니다. (보통 테스트 패키지 이름은 기존 패키지와 동일하게 지정합니다.)   
> ![image](https://user-images.githubusercontent.com/66030601/198220867-b022e99c-783c-48de-9569-0116f6bf2c07.png)   
> 그리고 클래스를 생성해주는데, 테스트할 클래스이름 뒤에 _**test**_ 를 붙여서 이름을 지정해주는 것이 관례입니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198221204-cdd51fe5-c68f-4b5a-ad55-6302ddba55de.png)    
> _**save()**_ 메서드를 테스트해 볼 것입니다. 앞에 _**@Test**_ 를 작성해줍니다. _**org.junit.jupiter.api**_ 를 _**import**_ 해줍니다.    
> ![image](https://user-images.githubusercontent.com/66030601/198222553-a293395b-59d7-4704-ae9d-c94cc87f9baf.png)   
> 저장이 잘 되는지 테스트를 해보기 위해 코드를 작성해보겠습니다.   
> _**findById**_ 의 반환타입이 _**Optional**_ 입니다.   
> _**Optional**_ 에서 값을 꺼낼 때는 _**get()**_ 을 이용합니다. (사실 ***get()*** 으로 바로 꺼내는 것이 좋은 방법은 아니지만, 테스트코드 같은 곳에서는 이렇게 꺼내도 됩니다.)   
> ![image](https://user-images.githubusercontent.com/66030601/198223228-909a7e28-9df7-42ee-956d-6d5161f886f5.png)   
> 그래서 이렇게 _**Member**_ 객체를 생성하고, 객체에 _**setName()**_ 으로 이름을 지정하고,   
> _**repository**_ 에 _**save()**_ 로 _**member**_ 를 저장하고,   
> _**result**_ 로 값을 꺼내도록 했습니다.    
>    
> 이제 검증을 해보겠습니다.   
>    
> _**new**_ 로 생성한 _**member**_ 객체와 _**db**_ 에서 꺼낸 것이 똑같으면, _**true**_ 라고 할 수 있습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198224918-75ad04a1-e6d2-49e5-ba8b-9f5294cc9376.png)   
> 단순하게 이렇게 할 수도 있습니다.    
> _**result == member**_ 인지 출력해보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198225283-6f48f752-e923-4cf9-84a2-ec8aca8b4c2e.png)   
> _**result**_ 랑 _**member**_ 가 같은지 테스트 했을 때, ***result = true*** 가 나왔습니다.   
>    
> 그런데, 테스트 결과를 이렇게 계속 글자로 볼 수는 없습니다.   
>    
> 그래서 어떤 기능이 있냐면,   
> _**Assert**_ 라는 기능이 있습니다. (***assert*** 는 _**Junit**_ 에서 가장 많이 이용되는 단정메서드입니다. 단정 메서드로 테스트 케이스의 수행결과를 판별합니다.)    
>    
> _**Assertions**_ 에 여러가지가 있습니다.   
> _**org.junit.jupiter.api**_ 에서 제공하는 _**Assertions**_ 가 있는데,   
> ![image](https://user-images.githubusercontent.com/66030601/198227122-5c68f2fe-c47d-45e4-bd43-68662ce1c3b6.png)   
> 이렇게 사용해서 _**result**_ 와 _**member**_ 가 같은지를 확인해볼 수 있습니다.   
>    
> _**command + p**_ 로 옵션을 볼 수 있는데,    
> ![image](https://user-images.githubusercontent.com/66030601/198227325-b7560b87-81a4-44f9-8d23-3d26220678f1.png)   
> 이렇게 첫번째 파라미터에는 _**expected**_, 두번째 파라미터에는 _**actual**_ 을 적어줘야 합니다.   
>    
> 즉, _**save**_ 결과 _**result**_ 가 _**member**_ 와 같은지 테스트 하는 것이기 때문에, 
> 기대값은 _**member**_ 이고, 실제 값은 _**result**_ 가 되는 것 입니다.   
> 이것을 돌려보도록 하겠습니다.     
> ![image](https://user-images.githubusercontent.com/66030601/198229068-3d1347a3-608b-4d7e-be10-f6bbbc17a745.png)   
> 따로 출력되는 것은 없지만, _**TestResults**_ 옆에 녹색체크를 확인할 수 있습니다.      
> 
> ![image](https://user-images.githubusercontent.com/66030601/198229595-4f459a18-0446-4aaa-8554-ecd6130ba629.png)   
> 만약에 기댓값과 실제값이 다르면 어떻게 될까요?   
> 실제 값을 임의로 _**null**_ 로 지정해보겠습니다.   
> 그리고 실행해 보았습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198230560-90f7bf9c-d25d-4a56-b570-2f69cbb113fb.png)   
> 빨간불이 뜨면서 테스트에 실패했습니다. 즉, _**Test**_ 결과가 _**member**_ 와 실제값(_**null**_)이 같지 않다고 알려줍니다.   
>       
> ![image](https://user-images.githubusercontent.com/66030601/198231961-33f900c8-9e71-4ea0-bcc9-810349957a6d.png)   
> 그리고 요즈음에는 ***org.assertj.core.api*** 에서 제공하는 _**Assertions**_ 도 많이 사용합니다.   
> _**Assertions**_ 를 좀더 편하게 사용할 수 있게 해줍니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198233958-c862f8a6-efec-41e2-918a-7d2ee6f045bf.png)   
> _**Add on-damend static**_ 을 해주면,   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198234171-d6f4e5da-4192-4adf-be81-b5ed2a4a99c4.png)   
> _**import**_ 문이 추가되면서 _**assertThat**_ 을 바로 사용할 수 있습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198234915-617f4ce6-0869-407a-b883-747c1daf3f2f.png)   
> 이번에는 _**findByName()**_ 테스트 코드를 작성했습니다.   
> 2명의 회원을 가입시켰고,   
> 그중 이름이 _**spring1**_ 인 데이터를 대상으로 테스트를 진행했습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198236127-1c3c1334-72cb-4c1c-a283-fefb747f5a4f.png)    
> 테스트 해보면, 성공한 것을 확인할 수 있습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198236496-c935e5bf-14dc-4f4f-8ce0-b5bc0af4add0.png)   
> 이번에는 _**findAll()**_ 을 테스트 해보겠습니다.   
> 위와 같이 테스트 코드를 작성했습니다.   
> _**findAll()**_ 이므로 객체를 두개정도 생성 해주었습니다.   
> 그리고 _**repository.findAll()**_ 을 하면 나오는 결과를 _**result**_ 에 저장했습니다.
>    
> ![image](https://user-images.githubusercontent.com/66030601/198238497-72c67590-b9d8-4e06-976e-ed40142db7cb.png)   
> 테스트에 성공했습니다.   
>    
> 이제 전체 테스트를 돌려보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198238631-c61f9e12-f0cf-4bb3-a6cd-e388f0bb9f0e.png)   
> 클래스단에서 테스트를 돌렸습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198238731-48af2d83-1b87-4efc-88f4-06cfae03034c.png)    
> 어? _**findByName()**_ 이 이상합니다.   
> 아까는 괜찮았는데 지금은 왜 에러가 날까요?   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198238859-cfd53ebc-7c77-459a-b575-6f0adcf0d326.png)   
> 테스트 순서를 보면,    
> _**findAll()**_ 이 먼저 테스트 되었습니다.   
> 그 다음에 _**findByName()**_ 이 테스트 되었습니다.   
>    
> 테스트 순서는 보장이 안됩니다.   
> 모든 테스트는 순서와 상관없이 다 메서드 별로 따로 동작하도록 설계해야 합니다.   
> 절대로 순서를 의존적으로 설계하면 안됩니다.   
>    
> 그런데, 지금 보면, _**findAll()**_ 이 먼저 실행되었습니다.    
> ![image](https://user-images.githubusercontent.com/66030601/198242104-42c51b54-c9f5-4f07-adb1-2e37c7bef8ee.png)   
> _**findAll()**_ 이 먼저 실행되어서 _**spring1**_, _**srping2**_ 가 이미 저장되어버렸습니다.      
> 그래서 그 다음에 _**findByName()**_ 을 할 때, 이전에 저장한 _**spring1**_, _**spring2**_ 가 나와버린것입니다.   
>    
> 그래서 어떻게 해줘야 하냐면,   
> 테스트를 하나 끝내고 나면, 데이터를 깔끔하게 클리어 해줘야 합니다.   
>    
> 테스트가 끝날때마다 데이터를 저장하는 저장공간(예제에서는 _**repository**_)을 깔끔하게 지워주는 코드를 추가해야 합니다.
>     
> ![image](https://user-images.githubusercontent.com/66030601/198251592-563447a3-31c5-4ba0-b7f3-d2e54882f99e.png)   
> _**@AfterEach**_ 는 클래스의 각 메서드가 끝나고 어떠한 동작을 하는 것 입니다. 콜백 메서드라고 보면 됩니다.    
>    
> > _**@AfterEach**_   
>> - 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있습니다.   
>> - 이렇게 되면, 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있습니다.   
>> - ***@AfterEach*** 를 사용하면 각 테스트가 종료될 때 마다 이 기능을 실행합니다.   
>> - 이 예제에서는 메모리 DB에 저장된 데이터를 삭제합니다.
>> - 테스트는 각각 독립적으로 실행되어야 합니다. 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아닙니다.   
>    
> 즉, _**save()**_ 끝나고 _**afterEach()**_ 가 호출되고,    
> _**findByName()**_ 이 끝나고 _**afterEach()**_ 가 호출되고,    
> _**findAll()**_ 이 끝나고 _**afterEach()**_ 가 호출됩니다.    
>     
> 우선은 ***MemoryMemberRepsitory()*** 만 테스트하면 되므로   
> ![image](https://user-images.githubusercontent.com/66030601/198253593-c11c9cd0-fce5-4388-9630-1227eb3110b2.png)   
> _**MemberRepository**_ 인터페이스를    
> ![image](https://user-images.githubusercontent.com/66030601/198253686-e6d88e59-e92a-4bdf-ad8d-0c70639868a1.png)   
> 이렇게 _**MemoryMemberRepository**_ 로 바꿔주었습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198253810-be106433-5e1c-47fc-ad8e-a63fd49c6865.png)    
> 그리고 _**MemporyMemberRepository**_ 클래스에 _**clearStore()**_ 메서드를 추가로 작성해주었습니다.   
> _**clear**_ 는 _**store**_ 를 싹 비워줍니다.   
>    
> 그리고 다시 _**MemoryMemberRepository**_ 로 돌아와서   
> ![image](https://user-images.githubusercontent.com/66030601/198254050-35ea09cc-d888-49b4-90cb-aa22e0b6115a.png)    
> _**afterEach()**_ 메서드 구현부에서 _**repository.clearStroe();**_ 를 호출하도록 코드를 작성해줍니다.   
>     
> 이렇게하면, _**Test**_ (테스트 메서드)가 실행되고 끝날 때마다 _**repository**_ 를 한번씩 비워줍니다.   
> 그러면, 테스트작업은 순서와 상관이 없어집니다.   
>    
> 클래스단에서 테스트를 돌려보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198259628-3ce06fa7-2952-45af-b188-1ac5cd7854f5.png)   
> 사진처럼, 테스트가 전부 녹색체크로, 성공했다는 것을 확인할 수 있습니다.   
>    
> 다시한번 강조하지만,   
> 테스트는 서로간에 순서 의존관계 없이 설계되어야 합니다.   
> 따라서 하나의 테스트가 끝날때마다, 저장소나 공용 데이터들을 깔끔하게 지워줘야 합니다.   
>    
> 이번 예제에서는 먼저 _**MemoryMemberRepository**_ 등 개발을 먼저 한다음에,   
> 테스트 케이스 작성을 했습니다.   
>    
> 반대로 이것을 완전히 뒤집어서,   
>    
> 테스트 케이스 클래스를 먼저 작성하고,   
> Member, _**MemporyRepository**_ 를 작성할 수도 있습니다.   
> 이렇게 테스트 케이스 클래스를 먼저 작성해서    
> 검증할 수 있는 틀을 먼저 만든 상태에서 개발하는 것을 "_**TDD(테스트 주도 개발)**_"라고 합니다.   
>    
> ***    
>     
> ## [✅회원 서비스 개발](https://github.com/mgyokim/Spring/commit/a6e21760b4d9aa1afb962ab73c9c46e0b1648984)    
> 이번에는 회원 서비스 클래스를 만들어 보도록 하겠습니다.   
> 회원 서비스는, 회원 리포지토리와 도메인을 활용해서 실제 비즈니스 로직을 작성하는 것입니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198343127-c85fb81c-dcfb-40ee-b7f4-a6e17e6c9d0a.png)   
> 우선, _**service**_ 라는 이름으로 패키지를 생성했습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198343305-1755f741-4a7f-4dcb-b8ed-8634d68dd84b.png)   
> 그리고 여기에 _**MemberService**_ 라는 이름으로 클래스를 생성했습니다.   
>    
> 서비스 코드를 작성해보겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198343593-fef15970-1de4-4385-897e-95ba6b860c46.png)   
> 일단, 회원 서비스를 만들려면, 회원 리포지토리가 있어야 합니다.    
>     
> 회원가입은, ***memberRepository*** 에 _**save()**_ 를 호출해주면 됩니다.   
> 그리고 반환은 임의로 _**id**_ 를 반환하도록 작성하겠습니다.   
>    
> 그런데, 회원 가입을 할 때, 비즈니스 로직중에, "같은 이름이 잇는 중복 회원은 가입이 안된다."라는 조건이 있었습니다.     
> <pre><code>Optional< Member > result = memberRepository.findByName(member.getName());   
> result.ifPresent(m -> {
>       throw new IllegalStateException("이미 존재하는 회원입니다.");   
> } );</code></pre>
> 그런데 이 코드처럼 _**Optional**_ 을 바로 반환하는 것은 권장하지 않습니다.   
> <pre><code>memberRepository.findByName(member.getName());</code></pre>   
> _**Optional< Member > result =**_ 을 없애면,   
> 이 코드의 반환이 _**Optional**_ 이므로,   
> 여기다가 바로 _**.ifPresent();**_ 가 들어갈 수 있습니다.   
> <pre><code>memberRepository.findByName(member.getName())
>        .ifPresent(m -> {
>               throw new IllegalStateException("이미 존재하는 회원입니다.");
>        } );</code></pre>   
> 그래서 이렇게 수정해서 작성하는 것이 좋습니다.   
>    
> 그런데, 코드를 봤을 때, 뭔가 로직이 쭉 있으면, 이런 경우에는 메서드로 뽑는게 좋습니다.      
> ![image](https://user-images.githubusercontent.com/66030601/198353485-87f7bf30-1cb1-4279-9da8-8dd8a854538c.png)   
> _**validateDuplicateMember**_ 라는 이름으로 메서드 리팩토링을 해주었습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198354045-60b7dbd0-c03d-448e-ac08-e0f0bf4e4878.png)   
> 이렇게 메서드로 뽑으면 좋은 점은,   
> "아! _**join()**_ 을 하면, 중복 회원을 검증하고, 통과하면 저장하는구나!"라고 바로 이해할 수 있게 됩니다.   
>    
> 이번에는 전체 회원을 조회하는 기능도 만들어 보겠습니다.
> ![image](https://user-images.githubusercontent.com/66030601/198355018-dbd420f4-244b-46d6-9fff-faa87123523a.png)    
> _**memberRepository**_ 의 _**findAll()**_ 을 호출해서 반환합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198355361-f4806d11-f86c-4c08-9b0a-195b47e91ff4.png)    
> _**findOne**_ 은 _**memberId**_ 로 멤버를 찾는 기능입니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198357284-00bc7526-1678-42a1-9950-580beb3ab46a.png)   
> 회원 서비스 클래스를 작성했습니다.   
>    
> 이제, 회원가입을 했을 때, 중복회원이면 오류가 발생하는지(_**IllegalStateException**_)이 터지는지, 검증을 해봐야 합니다.   
>    
> 검증하는 방법은 여러가지가 있지만,   
> 제일 좋은 방법은, 테스트 케이스를 활용하는 방법입니다.   
> 
> ***   
>    
> ## [✅회원 서비스 테스트](https://github.com/mgyokim/Spring/commit/8f6ae562c0f8805806635b0dcfdee9c432c0bf05)   
> 회원 서비스 클래스를 테스트 해보겠습니다.   
> 이전시간에 테스트를 할 때는,    
> ![image](https://user-images.githubusercontent.com/66030601/198501041-5074aacb-4f17-4786-be58-6dae4e36e35a.png)   
> 이렇게 패키지를 직접 만들었습니다. 이것을 편리하게 하는 방법이 있습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198501891-3debe462-9405-4e6e-badf-1d2aa856065b.png)   
> 테스트 하고싶은 클래스에 커서를 두고, ***cmd + shift + t*** 를 누르면 _**Create New Test**_ 를 할 수 있습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198502054-6342844e-3309-441b-ba85-aab596841858.png)   
> _**Testing library**_ 는 _**JUnit5**_ 를 선택했습니다.   
> 클래스 이름은 _**MemberServiceTest**_ 라고 지정했습니다.   
> 그리고 테스트할 메서드를 선택체크 해주었습니다. 그리고 OK를 누르면,   
> ![image](https://user-images.githubusercontent.com/66030601/198502152-3993d5bf-4426-483d-91ce-e749af99de76.png)   
> 이렇게 자동으로 테스트 껍데기를 만들어줍니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198502205-129decd2-8e5d-47c9-bf91-d5200c09a0c5.png)    
> 생성된 위치는 _**test**_ 폴더의 _**service**_ 패키지에 만들어졌습니다.   
> 이제 테스트를 하나씩 작성해보겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198503436-23a7b5ec-bf06-4e08-94dd-95a4a66c7aaa.png)    
> 테스트 코드를 제외한 실제 동작하는 코드들은, 한글로 네이밍하는 것이 관례적으로 금기되었습니다.   
> 테스트 코드는 영어권 사람들과 일하는게 아니라면, 한글로 네이밍하기도 합니다.   
> 많은 사람들이 좀더 직관적으로 쉽게 알아들을 수 있기 때문입니다.   
> 그리고 해당 프로젝트가 빌드될 때, 테스트 코드는 포함되지 않기 때문에 더욱이 그렇습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198503644-eeff4fe9-107f-47fb-b4f4-beeb7c83a08e.png)   
> 회원 가입을 하려면 우선, 서비스가 있어야 합니다.   
>    
> 테스트는 사실, 생각해보면,   
> 1. 뭔가가 주어졌는데, 
> 2. 이것이 실행되었을 때, 
> 3. 결과가 이게 나와야해!   
>    
> 대부분 이러한 과정으로 진행됩니다.   
> 
> ![image](https://user-images.githubusercontent.com/66030601/198503801-fc80e9da-7000-4d81-87bb-9987722d83e1.png)   
> 그래서 given, when, then 으로 나눠서 작성하면 좋습니다.   
>    
> given을 보면, "아! 이 데이터를 기반으로 하는구나!"   
> when을 보면, "아 이걸 실행하는걸 검증하는구나!"   
> then을 보면, "여기가 이제 검증부구나!"   
>    
> 라는 것을 알 수 있습니다.   
>    
> 그래서 이렇게 주석을 작성해 두는 것만으로도 많은 도움이 됩니다.   
> 물론 상황에 따라 다양하게 변형해야 하겠지만, 기본틀은 이러하다는 것을 알아두겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198503982-38cfb666-82bd-4d1d-a31f-327d60aea723.png)   
> 회원 가입 테스트 코드를 작성했습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198504024-84aede0d-b750-4fe0-a6df-3f7488514c8d.png)   
> 테스트를 통과했습니다.     
>    
> 그런데 여기서 중요한점이 있습니다.   
> 위에 작성한 테스트 코드는 너무 단순한 동작입니다.   
>    
> 테스트는, 정상 범주의 케이스도 중요하지만, 예외 범주의 케이스가 더 중요합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198504134-49fb0b81-316c-44b5-9b63-a3d8cfd23331.png)    
> _**join**_ 을 살펴보면 알 수 있듯,    
> 저장이 되는 것도 중요하지만, 더 중요한 것은,   
> 중복 회원을 검증해서 중복회원이 존재하면, 중복검증 로직을 잘 타서 예외를 발생시키는 것이 중요합니다.   
>    
> 중복_회원_예외 라는 이름으로 테스트를 작성해보겠습니다.   
>     
> ![image](https://user-images.githubusercontent.com/66030601/198504233-2a4e4024-94ea-4d20-af6b-e417d2c47a56.png)    
> 예외가 발생했을 때, 주어지는 메시지가 _**Service**_ 클래스의 _**validateDuplicateMember**_ 에서 예외를 던질 때 주는 메시지와 같은지 비교하도록 했습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198504347-6d8ffdb5-57c8-4775-85e1-1c20cddb0c4d.png)   
> 테스트에 통과했습니다.   
>     
> ![image](https://user-images.githubusercontent.com/66030601/198504370-73494af8-4aba-4a02-af09-e63df42bb6e3.png)   
> 이번에는 임의로 메시지를 변경해보겠습니다. 그러면 테스트에 실패해야합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198504432-15ded648-5431-46d4-8262-c3c578571ae2.png)   
> 테스트에 실패함을 확인할 수 있습니다.   
>    
> 위의 코드처럼 작성하는 방법이 있지만,   
> 그런데, 이러한 예외 테스트 때문에 _**try-catch**_ 문을 넣는 것이조금 비효율적(?)으로 애매합니다.   
>    
> 그래서 좋은 문법이 제공됩니다.   
>    
> 우선 앞서 작성해둔 _**try-catch**_ 문은 주석처리했습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198504569-af62b350-0fac-4040-9daa-01a4c7372356.png)   
> _**assertThrows**_ 라는 문법입니다.   
> "중복회원 예외가 발생했을 때, ***IllegalStateException.class*** 가 발생해야 해!"라고 알려주고,   
> 람다가 넘어가서   
> 어떤로직을 태울때 _**IllegalStateException.class**_ 가 발생해야하는지 알려줍니다.   
> _**memberService.join(member2);**_ 를 넣으면 _**IllegalStateException.class**_ 예외가 터져야 한다고 알려주는 것입니다.   
>    
> 테스트를 돌려보겠습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198504788-6f60e546-62f4-4b08-92bc-5558f4730600.png)   
> 테스트에 통과했습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198504838-7ca7c8da-249b-4dca-9bcb-be7574c74636.png)   
> 만약에 터저야 하는 예외가 ***IllegalStateException*** 이 아니라 _**NullPointerException**_ 이 터져야 한다고 임의로 지정하고 테스트를 돌려보겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198504919-5c4ce248-261b-4d30-85cf-547227e60dc3.png)    
> 테스트에 실패하는 것을 확인할 수 있습니다. 다시 원래대로 _**IllegalStateException**_ 으로 작성해두겠습니다.   
>    
> _**assertThrows**_ 의 또 다른 좋은점은 메시지도 반환할 수 있다는 것 입니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198505065-387cba9f-5225-4b9b-8b31-48217a739f06.png)    
> 이렇게 메시지를 비교하도록 작성하고, 테스트를 돌려보겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198505134-88b43fa8-57cb-4065-b2ae-0fab06cc7b48.png)   
> 테스트에 성공하는 것을 확인할 수 있습니다.   
>    
> 자 이제, 테스트 코드를 작성할 때 꼭 해줘야 하는 것이 남아있습니다.   
>    
> 앞서 이야기했듯,   
> 모든 테스트는 순서와 상관없이 메서드별로 따로 동작하도록 설계해야합니다.   
> 절대로 순서를 의존적으로 설계하면 안됩니다.   
>    
> 즉, 메서드를 실행하고나면 데이터를 깔끔하게 클리어 해줘야 합니다.   
>    
> 그런데, 지금 MemberServiceTest클래스 코드에 문제가 있습니다.   
> ![image](https://user-images.githubusercontent.com/66030601/198505330-a213f314-b482-4bff-aabc-30ce36aa7bea.png)   
> 데이터를 클리어해주고 싶은데, _**MemberServiceTest**_ 클래스의 멤버가 _**MemberService**_ 밖에 없습니다.   
> 클리어가 안될 것입니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198505690-6407a4d8-d72d-420c-be41-795757d2c74b.png)    
> 그래서 어떻게 해야 하냐면,   
> _**MemoryMemberRepository**_ 를 가져와야 합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198505837-c2e53320-243d-496c-a30c-b89bfac91a90.png)   
> 이렇게 해두면, 메서드가 돌때마다, _**db**_ 의 값을 _**clear**_ 해줍니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198505890-747ed5fe-c610-4f47-9610-dc423d7d204f.png)   
> 테스트에 성공하는 것을 볼 수 있습니다.   
> 테스트가 돌때마다 메모리가 클리어가 되서 잘 동작합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198505941-22e6637b-878e-41d5-b872-0dda487d3cbf.png)   
> 그런데, 이 코드를 보면, 조금 애매한 부분이 있습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198506004-4dea676f-5428-4f10-b515-3ef3e6e505b0.png)    
> _**MemberService**_ 클래스에 있는 _**memberRepository**_ 는 _**new**_ 연산자를 이용했기 때문에,  _**MemberServiceTest**_ 클래스에 있는 _**memberRepository**_ 와 다른 객체입니다.   
>    
> 애매하다고 말한 이유가 바로 이것입니다.   
> 이렇게 따로 2개의 객체를 사용할 이유가 없습니다. 같은 것을 사용하는 것이 아무래도 낫습니다.   
>    
> 이렇게 _**new**_ 로 다른 객체가 생성이 되면, 서로 다른 인스턴스 이기 떄문에 혹시라도 내용물이 달라질 수 있습니다.   
>     
> 그래서 어떻게 하는 것이 좋냐면, 같은 인스턴스를 사용하도록 코드를 수정하는게 좋습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198506329-58c44731-4d9e-426e-bbb3-82665826b946.png)   
> _**MemberService**_ 클래스의 _**new MemoryMemberRepository()**_ 를 지우고,   
> _**new**_ 로 직접 생성하는 것이 아니라 외부에서 넣어주도록 바꿔야 합니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198506428-3c861ea4-504c-4b31-b1f3-c6fe3082f605.png)    
> _**cmd + n**_ 을 눌러서 _**Constructor**_ 를 눌러줍니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198506524-3cc6202c-4665-42d2-a56e-eb7bb0a2daad.png)   
> 그러면, _**MemberService**_ 의 ***MemberRepository memberRepository*** 를 직접 _**new**_ 해서 생성하는게 아니라,   
> 외부에서 넣어주도록 변경됩니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198506592-2b1f59c0-612f-4ea9-9544-a7a066549024.png)   
> 그러면, _**MemberServiceTest**_ 클래스에서 _**MemberService()**_ 를 생성할 때, 내가 _**MemoryMemberRepository**_ 를 직접 넣어줄 수 있습니다.    
>    
> ![image](https://user-images.githubusercontent.com/66030601/198506800-767592fe-fed2-488d-84c7-0ba8ed97716f.png)   
> _**@BeforeEach**_ 로 테스트가 동작하기 전에 넣어주면 됩니다.   
>    
> _**@BeforeEach**_ : 각 테스트 실행전에 호출됩니다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 의존관계도 새로 맺어줍니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198506971-9adb7970-c90e-44a9-bc96-1b058f8774ed.png)   
> 이것이 동작하는 방식은,   
> 각 테스트를 실행하기 전에, _**@BeforeEach**_ 가 실행되는데,
> _**MemoryMemberRepository()**_ 가 만들어집니다.   
> 그리고, 만들어진 _**memberRepository**_ 를 _**MemberServiceTest**_ 클래스의 _**memberRepository**_ 에 넣어 놓습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198507384-38021055-6a57-4041-b88c-aac14b208e4a.png)   
> _**new MemberService(memberRepository);**_ 를 할 때,   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198507506-80ca97b6-9c3c-4f3d-90c4-a6b9d452fd73.png)   
> _**MemberService**_ 클래스에서 만들어둔 _**memberRepsotiroy**_ 를 넣어줍니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198507670-ed37abc3-cca0-499b-b75f-f9e3f11e6d97.png)   
> 그러면, 같은 _**MemoryMemberRepsitory**_ 를 사용하게 됩니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198509606-6bf79de2-26a0-4210-9dae-da55516c5cf8.png)   
> ![image](https://user-images.githubusercontent.com/66030601/198509653-639dfa92-e798-47e9-ada9-ee9f378286ca.png)   
> _**MemberService**_ 입장에서 자신이 직접 _**new**_ 하지 않고, 외부에서 _**MemberRepository**_ 를 넣어줍니다.   
>    
> 이러한 것을 _**Dependecy Injection(DI - 의존성 주입)**_ 이라고 합니다.      
>

# 스프링 빈과 의존관계
> ## [✅ 컴포넌트 스캔과 자동 의존관계 설정](https://github.com/mgyokim/Spring/commit/a66bc98a0c17f70deeb99aeff4402fbc4c3f7d1e)    
> 지금까지, _**MemberService**_ 와 _**MemberRepository**_ 를 만들었습니다.   
> 그리고, _**Member**_ 객체도 만들고, 서비스를 통해서 멤버가 가입할 수 있고, 리포지토리에 저장이 되고,   
> 리포지토리에서 꺼내올 수 있는 이러한 로직들을 만들었고,   
> 테스트도 만들었습니다.   
>    
> 이번시간에는 화면을 붙이려고 합니다.   
> 그럴려면 먼저 컨트롤러와 _**view**_ 템플릿이 필요합니다.   
> 회원가입하고, 회원가입된 결과를 _**html**_ 로 뿌려주고, 이러한 것들을 하려고 합니다.   
>    
> 그럴려면, 멤버 컨트롤러를 만들어야 하는데, 멤버 컨트롤러가 멤버 서비스를 통해서 회원가입을 하고,   
> 멤버서비스를 통해서 데이터를 조회할 수 있어야 합니다.   
>    
> 멤버컨트롤러가 멤버서비스를 의존하는 것입니다.   
> 이러한 것을 "서로 의존 관계가 있다." 라고 표현합니다.   
> 
> 이 작업을 _**Spring**_ 스럽게 해보겠습니다.   
>    
> 먼저 멤버컨트롤러를 만들어보겠습니다.   
>        
> ![image](https://user-images.githubusercontent.com/66030601/198845865-e74350c9-07c6-4ad6-a4cb-3db3a7f15d7b.png)    
> 이렇게까지 작성해 놓으면,    
> 기능은 아무것도 없지만 어떤 일이 벌어지냐면,   
> 스프링이 처음에 뜰 때, _**SpringContainer**_ 가 생기는데,    
> _**@Controller**_ 애너테이션만 있으면, _**MemberController**_ 객체를 생성해서 _**SpringContainer**_ 에 넣어둡니다.   
> 그리고 스프링이 관리를 합니다.   
>    
> 이것을 "스프링 컨테이너에서 스프링 빈이 관리된다." 라고 합니다.     
>    
> ![image](https://user-images.githubusercontent.com/66030601/198845959-3e70112e-38c2-48fa-840a-190639bda36c.png)   
> 그림으로 확인해보면 이러합니다.   
> _**@Controller**_ 라는 애너테이션이 있으면, 스프링이 뜰 때,   
> 스프링 컨테이너에서 해당 컨트롤러 객체를 생성해서 관리합니다.   
>     
> 다시 돌아와서,   
> ![image](https://user-images.githubusercontent.com/66030601/198846976-e3ad6cd2-548a-4ab2-abb7-f186a859b9da.png)   
> 그러면, _**MemberController**_ 가 _**memberservice**_ 를 가져다가 써야합니다.    
> 이렇게 _**new**_ 로 생성해서 사용할 수도 있습니다.   
>     
> 하지만, 스프링이 관리를 하게 되면,   
> 전부 스프링 컨테이너에 등록을 하게 되고, 스프링 컨테이너로부터 받아서 쓰도록 바꿔야 합니다.   
>    
> 그 이유를 알아보겠습니다.   
>    
> _**MemberController**_ 말고 다른 여러 컨트롤러들이 _**memberService**_ 를 가져다 쓸 수 있습니다.   
> 예를 들면, 주문 컨트롤러에서도 _**memberService**_ 를 가져다 쓸 수도 있습니다. 회원은 여러군대에서 사용되기 때문입니다.   
>    
> _**MemberService**_ 를 살펴보면, 기능 자체가,   
> 여러개의 인스턴스를 생성할 필요가 없고, 하나만 생성해서 같이 공용으로 사용하면 될 것으로 예상됩니다.   
>     
> 그런데 객체를 _**new**_ 로 생성해서 사용하게 되면, 여러개의 _**MemberService**_ 객체가 생성되어 비효율적입니다.   
>    
> 그래서 공용으로 사용하려면 어떻게 해야하냐면,   
> 스프링 컨테이너에 등록을 하고 사용해야 합니다.   
> 스프링 컨테이너에 등록을 하면, 딱 1개만 등록하게 됩니다.   
> 이렇게 하면 방금 설명한 효과 외에도 굉장히 많은 부가적인 효과들이 있습니다. 이것들에 대해서는 뒤에서 좀더 알아보겠습니다.   
>    
> 이제 연결을 해보겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198861559-cfbda116-37bc-4747-b2b9-c45460c1e6d9.png)   
> 생성자 연결을 하겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198861573-21e6166e-336e-4cbb-acdc-b88d93a5d468.png)   
> 그러면, 그때, _**MemberController**_ 내부에 있는 생성자를 호출하는데,   
> 생성자에 _**@Autowired**_ 애너테이션이 있으면,   
> 이 코드의 _**memberService**_ 를 스프링이 스프링 컨테이너에 있는 _**memberService**_ 를 가져다가 연결시켜줍니다.   
>    
> - 생성자에 ***@Autowired***가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줍니다. 이렇게 객체의 의존관계를 외부에서 넣어주는 것을 _**DI(Dependency Injection)**_, 의존성 주입이라 합니다.   
> - 이전 테스트에서는 개발자가 직접 주입했고, 여기서는 _**@Autowired**_ 에 의해 스프링이 주입해줍니다.   
>     
> 그런데, 지금 코드를 보면, 빨간 밑줄이 그어져 있습니다.   
> 뭔가 잘 안되는 것 같습니다.   
>     
> 일단 _**HelloSpringApplication**_ 를 _run_ 시켜보겠습니다.   
>   
> ![image](https://user-images.githubusercontent.com/66030601/198861686-6cb937a0-d947-47bb-ad4d-19a3f0f3d5e9.png)   
> _**MemberService could not be found**_ 라는 것을 볼 수 있습니다.   
>    
> 무슨 이야기냐면,   
>    
> _**@Autowired**_ 라고 하면, 스프링 컨테이너에서 _**memberService**_ 를 가져와서 연결시켜준다고 했습니다.   
> 그런데!!!   
>    
> 그림을 살펴보겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198861801-a6da7347-ba3d-4700-9900-484e5a1985f6.png)    
>               
> _**MemberController**_ 는 _**@Controller**_ 애너테이션 때문에, 스프링이 딱 뜰때, 스프링 컨테이너에 등록됩니다.    
>    
> 그러면, ***MemberController*** 는 안에 _**@Autowired**_ 애너테이션이 있으므로 스프링 컨테이너에서 관리하는 _**memberService**_ 를 가져다가 스프리잉 연결을 해주는데,   
> 현재는 빨간 밑줄이 그어져 있는 것으로 보아 연결이 안된 것을 확인할 수 있습니다.   
>    
> 왜냐하면,   
> _**MemberService**_ 를 살펴보면,    
> ![image](https://user-images.githubusercontent.com/66030601/198861904-1b9a31df-813b-4fee-8995-707afe55686f.png)    
> _**MemberService**_ 는 그냥 순수한 _**Java**_ 클래스입니다. 스프링이 이게 뭔지 알 수 있는 방법이 없습니다.   
> _**MemberController**_ 는 _**@Controller**_ 애너테이션 때문에 스프링이 뜰 때, 애너테이션을 보고,   
> "아! 이건 내가 관리해야할 대상이구나"라고 하고 스프링 컨테이너에 생성해서 등록해두는 규칙에 따라 등록하는데,   
> _**MemberService**_ 는 순수한 _**Java**_ 코드입니다. 그래서 아무것도 되지 않습니다.   
>    
> 그러면 어떻게 해야할까요?   
> ![image](https://user-images.githubusercontent.com/66030601/198861957-3cec49f8-c041-40b6-90c8-0d98ff4f6d88.png)    
> _**MemberService**_ 에 _**@Service**_ 애너테이션을 붙여주면 됩니다.   
> _**@Service**_ 애너테이션을 붙이면, 스프링이 "어? _**@Service**_ 네?" 라고 하고   
> 스프링 컨테이너에 _**MemberService**_ 를 등록해줍니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198861983-fc8716b0-0116-4d55-9cd0-d0aed6454bd8.png)    
> 그리고 _**MemberRepository**_ 로 가보겠습니다.   
> _**MemberRepository**_ 구현체인 _**MemoryMemberRepository**_ 로 가서 _**@Repository**_ 애너테이션을 작성해주면 됩니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198862055-e77360d6-f8f5-40fb-9ca1-835e49541216.png)    
> _**@Controller**_ - Controller,    
> _**@Service**_ - Service,    
> _**@Repository**_ - Repository   
>    
> Controller 통해서 외부 요청을 받고,   
> Service를 통해서 비즈니스 로직을 만들고,    
> Repository에서 데이터를 저장하는,    
>     
> 이것은 굉장히 정형화된 패턴입니다.   
>    
> 이렇게 해놓으면,   
> 스프링이 뜰 때, _**@Controller**_, _**@Repository**_, _**@Service**_ 를 쫙 가지고 올라와서 스프링 컨테이너에 등록해줍니다.   
>     
> 그리고 나서, 뭘 해주냐면,   
>     
> ![image](https://user-images.githubusercontent.com/66030601/198862126-4f789632-435a-42a4-8af2-81e5b479c473.png)    
> _**Controller**_ 와 _**Service**_ 를 연결시켜 줘야 합니다.    
>    
> ![image](https://user-images.githubusercontent.com/66030601/198862154-a2c49ace-d457-438f-92c6-1ec3bdc80840.png)    
> 연결시켜줄 때, _**@Autowired**_ 를 쓰면 된다고 했었습니다.   
> 생성자에 _**@Autowired**_ 를 쓰면,   
> _**MemberController**_ 가 생성이 될 때, 스프링빈에 등록되어 있는 _**MemberService**_ 객체를 가져다가 넣어줍니다.   
>     
> 이게 바로 _**DI**_(_**Dependency Injection**_ 의존성 주입) 입니다. 스프링이 딱 넣어주는 것입니다.
>     
> ![image](https://user-images.githubusercontent.com/66030601/198862219-4dc2700b-ba11-4ad0-929f-6bc1cea014da.png)    
> 이번에는 _**MemberService**_ 를 보겠습니다.    
> 생성자에 _**@Autowired**_ 를 작성해주었습니다.    
>     
> 그러면, _**MemberService**_ 는 _**MemberRepository**_ 가 필요한데,   
> _**@Autowired**_ 가 있으면,   
>     
> _**MemberService**_ 를 스프링이 _**@Service**_ 를 보고 생성을 할 때,   
> 스프링 컨테이너에 등록을 하면서, 생성자를 호출하면서 _**@Autowired**_ 가 있으면,   
> "아! _**MemberService**_ 는 _**MemberRepository**_ 가 필요하구나?"라고 하면서    
> 스프링 컨테이너에 있는 _**MemberRepository**_ 를 _**MemberService**_ 에 넣어줍니다.   
>     
> 지금 같은 경우에는 구현체로 _**MemoryMemberRepository**_ 가 있으므로 이 _**MemoryMemberRepository**_ 를 _**MemberService**_ 에 주입을 해줍니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/198862319-269b3186-4bcb-4b29-b281-f01e4a293caf.png)    
> 그러면 이렇게 _**memberController**_, _**memberService**_, _**memberRepository**_ 가 연결이 완료됩니다.    
>     
> 이 상태에서 _**HelloSpringApplication**_ 을 실행해보겠습니다.   
>    
> ![image](https://user-images.githubusercontent.com/66030601/198862374-cc6a53cb-e0ef-4132-9006-c8caf4918dfb.png)    
> _**Tomcat started on port:8080**_ 도 잘 뜬것을 볼 수 있습니다.   
>     
> 즉, 스프링이 스프링 컨테이너를 만들때 문제없이 잘 되었다는 뜻이기도 합니다.   
>     
> ![image](https://user-images.githubusercontent.com/66030601/198862407-2aaae77f-193a-4f30-871b-b390c8aa23f3.png)    
> 지금은 MemberController 관련된 기능이 아무것도 없기 때문에,    
> 연결하는 과정만 알아보았습니다.    
>     
> 정리해보겠습니다.    
>      
> 스프링 빈을 등록하는 방법은 2가지가 있습니다.   
> - 컴포넌트 스캔과 자동 의존관계 설정   
> - 자바 코드로 직접 스프링 빈 등록하기
>      
> 컴포넌트 스캔 원리는 다음과 같습니다.    
> - _**@Conponent**_ 애노테이션이 있으면 스프링 빈으로 자동 등록됩니다.    
> - _**@Controller**_ 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문입니다.    
>     
> _**@Controller**_ 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록됩니다.    
> - _**@Controller**_
> - _**@Service**_    
> - _**@Repository**_     
>      
> 우리가 위에서     
> _**@Controller**_       
> _**@Service**_    
> _**@Repository**_    
> 애너테이션을 통해 한 것이 컴포넌트 스캔 방식입니다.    
>     
> 이것이 왜 컴포넌트 방식이나면,    
>     
> ![image](https://user-images.githubusercontent.com/66030601/198862521-ae910217-c765-42b2-95cc-5841b599a61a.png)    
> _**MemberService**_ 로 살펴보면, _**@Service**_ 대신 사실은 _**@Component**_ 라고 하면 됩니다.    
>      
> "어? 나는 _**@Service**_ 라고 했는데 왜 되는 거지?"    
>     
> 라고 생각할 수 있습니다. _**@Service**_ 애너테이션 내부를 살펴보겠습니다.    
>      
> ![image](https://user-images.githubusercontent.com/66030601/198862555-dc03f469-89cb-4e06-8672-6db24e270df0.png)     
> _**@Service**_ 안을 보면,      
> _**@Component**_ 라는 애너테이션이 등록이 되어 있습니다.    
>      
> 그리고 _**@Controller**_ 도 마찬가지입니다.       
>       
> ![image](https://user-images.githubusercontent.com/66030601/198862575-017e1e44-0c02-4b42-ba97-2a55da0a3c86.png)     
> _**@Controller**_ 내부를 보면, _**@Component**_ 애너테이션이 붙어있습니다.    
> 그리고 _**@Repository**_ 도 마찬가지일 것입니다.    
>      
> ![image](https://user-images.githubusercontent.com/66030601/198862591-3bf75a15-6b65-429a-a268-5943da1f3c16.png)      
> _**@Repository**_ 내부도 살펴보면, _**@Component**_ 라고 붙어있습니다.     
> 그래서, 원래 이름은 컴포넌트 스캔이라고 합니다.    
>      
> 스프링이 올라올 때,     
> _**@Component**_ 와 관련된 애너테이션이 있으면,    
> 그것들은 전부 객체를 하나씩 생성해서 스프링 컨테이너에 등록을 합니다.    
>      
> 그리고 _**@Autowired**_ 는 등록이 되어 있는 것들을 연결해줍니다.     
> _**@Autowired**_ 덕분에      
> _**MemberController**_ 가 _**memberService**_ 를 쓸 수 있게되고,    
> _**memberService**_ 가 _**memberRepository**_ 를 쓸 수 있게 되는 것입니다.    
>      
> 이러한 방법이,    
> 컴포넌트 스캔과 자동 의존관계 설정 이라는 것입니다.    
>      
> 그리고, 두번째 방법은,    
> - 자바 코드로 직접 스프링 빈 등록하기    
>      
> 입니다.    
>      
> 두가지 방법을 모두 알아야 합니다.    
>       
> 스프링을 쓰면, 왠만한 것들을 스프링 빈으로 등록해서 써야합니다.    
> 그렇게 해야 하는 이점이 많습니다.      
> 이점들은 공부하면서 하나씩 알아겠습니다.(ex. AOP)    
>      
> 이즘에서 드는 궁굼증이 있습니다.    
> "그러면 아무대나 _**@Component**_ 가 있어도 되나요?"    
>      
> ![image](https://user-images.githubusercontent.com/66030601/198862693-034908bc-e3aa-49f8-8471-b906fd69c84e.png)      
> 예를 들어 이렇게 아무 패키지를 만들어서 클래스를 생성하고, _**@Service**_ 를 붙이면 될까요?    
>      
> 기본적으로는 "안된다."입니다.    
>     
> 왜냐하면, 이게 어디서부터 되냐면,     
>    
> ![image](https://user-images.githubusercontent.com/66030601/198862833-00f7318a-2271-4fc2-a5c9-757fc2f09615.png)     
> 지금 우리가 _**HelloSpringApplication**_ 을 실행시키는데,   
>      
> _**hello.hellospring**_ 패키지 하위들은 스프링이 자동으로 전부 탐색해서 스프링 빈으로 등록합니다.    
>      
> 그런데, _**hello.hellospring**_ 패키지와 동일하거나 하위패키지가 아닌 패키지들은 스프링빈으로 컴포넌트 스캔을 하지 않습니다.     
>      
> 그래서 _**demo**_ 는 등록되지 않습니다.(설정을 해주면 가능하지만, 기본적으로는 컴포넌트 스캔 대상X)    
>       
> _**hello.hellospring**_ 패키지를 포함한 하위패키지만 컴포넌트 스캔 대상입니다.    
> _**demo**_ 패키지는 다시 삭제했습니다.    
>      
> 참고로,  
> 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때,     
> 기본으로 싱글톤으로 등록합니다.     
> (싱글톤이란, 유일하게 하나만 등록해서 공유한다는 뜻입니다. (ex. 회원컨트롤러 1개만, 멤버서비스 1개만, 멤버리포지토리도 1개만)    
>     
> 따라서 같은 스프링 빈이면 모두 같은 인스턴스입니다.    
>       
> 설정으로 싱글톤이 아니게 설정할 수 있지만,   
> 특별한 경우를 제외하면 대부분 _**싱글톤**_ 으로 사용합니다.      
>      
> ***   
>    
> ## [✅ 자바 코드로 직접 스프링 빈 등록하기](https://github.com/mgyokim/Spring/commit/236266019238775d7b1ee0fd7c8cbab3e79375bc)    
> 지난시간에는, _**@Service**_, _**@Repository**_, _**@Autowired**_, 등을 이용하여   
> 컴포넌트 스캔으로 스프링 컨테이너에 스프링빈으로 자동으로 등록하고, 연결하는 것을 자동으로 했습니다.    
>     
> 이번시간에는, 자바 코드로 하나하나 직접 스프링 빈을 등록 해보도록 하겠습니다.    
>     
> ***MemberService*** 와 ***MemberRepository*** 의 _**@Service**_, _**@Repository**_, _**@Autowired**_ 애너테이션을 제거하고 진행하도록 하겠습니다. (_**MemberController**_ 는 그대로 둡니다.)    
>     
> 지우고나서 돌려보면,     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199425575-538ae1ba-9c6e-4fb9-910a-05c146fc75ba.png)     
> 당연히 스프링이 올라올 때 컴포넌트 스캔이 안되므로, _**MemberService**_ 가 스프링빈에 등록되어 있지 않습니다.     
> 그래서 이처럼 오류가 납니다.     
>      
> 컴포넌트 스캔방식 말고, 직접 등록하는 방식에 대해 알아보겠습니다.     
>       
> 
> ![image](https://user-images.githubusercontent.com/66030601/199425798-69457b3a-06b1-4004-8c7a-bbe15f12be5b.png)     
> _**SpringConfig**_ 라는 이름으로 해당 위치에 파일을 생성했습니다.    
>      
> ![image](https://user-images.githubusercontent.com/66030601/199425903-c6df5a17-f8f3-4748-9ddd-8266302769ef.png)     
> 그리고 _**@Configuration**_ 을 작성해줍니다.    
>       
> ![image](https://user-images.githubusercontent.com/66030601/199425974-46bc01d2-f55c-479d-808f-23f4591ddda1.png)    
> 이렇게 작성을 해주는데,    
> _**@Bean**_ 애너테이션은,   
> 스프링이 뜰 때, _**@Configuration**_ 을 읽고, "***@Bean*** 은 스프링에 등록하라는 뜻이네!" 라고 스프링이 인식을 해서    
> _**memberService()**_ 를 호출해서 스프링빈에 등록을 해줍니다.    
>      
> ![image](https://user-images.githubusercontent.com/66030601/199426213-a8aaa668-9c04-4fdb-afe0-97f9dd6045d6.png)     
> 그런데, _**MemberService();**_ 에 빨간줄이 있는 것으로 보아, 생성자에서 뭔가를 넣어줘야 합니다.    
> _**cmd + p**_ 를 눌러서 확인해보면, _**MemberRepository**_ 를 넣어줘야 하는 것을 확인할 수 있습니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199426579-9efa63e1-5ac9-4b88-b371-81a86d5a97ca.png)    
> _**MemberRepository**_ 를 _**@Bean**_ 으로 등록해주었습니다.    
> _**MemberRepository**_ 는 인터페이스라서, 구현체인 _**MemoryMemberRepository**_ 를 _**new**_ 해주었습니다.     
>      
> 그러면, _**MemberService**_ 에는 방금 작성한 _**@Bean**_ 에 있는 _**memberRepository**_ 를 넣어줘야 합니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/199428185-2e16f394-e4c5-4c4d-a082-a20104b19df3.png)    
> 이렇게 넣어주면 됩니다.    
>      
> 그러면 이게 스프링이 뜰때 어떻게 뜨냐면,    
> _**MemberService**_ 와 _**MemberRepository**_ 를 둘다 스프링빈에 등록을 하고,     
> 그러면서, 스프링빈에 등록되어 있는 _**memberRepository**_ 를 _**MemberService**_ 에 넣어줍니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/199428474-d1490447-6b6f-4d0a-8315-e6d8acebb6f6.png)    
> 그러면 이러한 그림이 완성됩니다.    
>      
> - _**@Configuration**_    
> - _**@Bean**_     
>     
> 이것들을 이용해서 직접 스프링 빈에 등록할 수 있습니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/199429020-44bf5ad9-187d-4e83-9903-4d5773098492.png)    
> 그런데, _**@Controller**_ 는 어쩔 수 없습니다.    
>      
> 컨트롤러는 어쨋든 스프링이 관리하는 대상이기 때문에, 이렇게 두면 컴포넌트 스캔이 올라가고,    
> 컴포넌트 스캔이기 때문에 _**@Autowired**_ 로 연결해줍니다.     
>      
> 이렇게 해두면, _**@Bean**_ 으로 등록한 _**memberService**_ 가 연결됩니다.    
>      
> 이 상태로 잘 동작하는지 돌려보겠습니다.    
>      
> ![image](https://user-images.githubusercontent.com/66030601/199430270-ceee765f-cc2c-4c6e-9935-a14a9e91483f.png)    
> 정상적으로 잘 동작하는 것을 확인할 수 있습니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/199430418-7e491d0c-4758-4ceb-85ec-e1f23d7f825a.png)    
> DI 에는 
> - 필드주입     
> - setter 주입    
> - 생성자 주입         
>       
> 이렇게 3가지 방법이 있습니다.   
>      
> 의존관계 실행중에 동적으로 변하는 경우는 거의 없으므로 _**생성자 주입**_ 을 권장합니다.    
>     
> 우리가 작성했던 위의 코드처럼, 생성자를 통해서 _**MemberService**_ 가 들어오는데, 이러한 것을 생성자 주입 이라고 합니다.   
>     
> ![image](https://user-images.githubusercontent.com/66030601/199430879-beef77e0-bbd3-45c1-b4ab-0281c1c4095d.png)    
> 그리고 이렇게 생성자를 빼고, 아예 필드에다가 _**@Autowired**_ 하는 방법이 있습니다.   
> 이러한 방식을 _**필드 주입**_ 이라고 합니다.    
>      
> ![image](https://user-images.githubusercontent.com/66030601/199431111-47028aed-d4e1-4b9f-adf7-665f43ea9f23.png)    
> 그런데, 인텔리제이가 _**@Autowired**_ 밑에 물결표시를 했습니다. 뭔가 애매한 것 같습니다.    
> 살펴보면, _**Create constructor**_ 라고 나옵니다.     
>     
> 필드주입은 별로 좋지 않은 방법입니다.    
>     
> 왜냐하면, 스프링이 뜰 때만 얘를 넣어주고, 이후에는 중간에 바꿔치기 할 수 있는 방법이 아예 없기 때문입니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/199432177-19475a28-3c7e-4c95-8330-69877c2a0e97.png)     
> 이번에는 _**setter 주입**_ 입니다.    
> _**cmd + n**_ 으로 _**setter**_ 를 넣고, 여기에 _**@Autowired**_ 를 붙여주었습니다.    
> 이렇게 해주면, 생성은 생성대로 되고, _**setter**_ 가 나중에 호출이 되서 _**setter**_ 를 통해서 주입이 됩니다.    
>     
> 그런데, 이것의 단점은,    
> 누군가가 _**MemberController**_ 를 호출했을 때, 이것이 _**public**_ 으로 열려있어야 합니다.   
> _**setMemberService**_ 를 한번 세팅하고나면 중간에 바꿀일이 없지만, _**public**_ 하게 노출된다는 단점이 있습니다.    
> 중간에 잘못 바꾸면 문제가 생길것 입니다.    
>     
> 그래서 ***DI 방식*** 으로는 필드주입, setter 주입 보다는 ***생성자 주입*** 이 권장됩니다.    
>     
> ![image](https://user-images.githubusercontent.com/66030601/199432715-30ca70a1-6fa8-47b8-9689-61289d96e01c.png)    
> 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용합니다.   
> 그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면, 설정을 통해 스프링 빈으로 등록합니다.    
>     
> 이 내용이 중요한 내용입니다.    
>     
> 이후에는 무엇을 할 것이냐면,   
> 현재는 _**MemberRepository**_ 를 만들어놓았는데,   
>    
> ![image](https://user-images.githubusercontent.com/66030601/199432986-14be546f-0089-40fd-8052-00cf86bc5e2a.png)     
> 비즈니스 요구사항 정리부분에서 언급했듯, 아직 데이터 저장소가 선정되지 않았다는 가상의 시나리오 조건이 있었습니다.    
> 그래서 일단 _**MemoryMemberRepository**_ 로 구현했고, 나중에 교체할 것입니다.    
>     
> 그래서 지금 인터페이스로 설계하고, 구현체로 _**MemoryMemberRepository**_ 를 사용하는 것입니다.    
> 나중에 이 _**MemoryMemberRepository**_ 를 다른 리포지토리로 바꿔치기 할 것입니다.    
>     
> 이때, 기존에 운영중인 코드를 하나도 손대지 않고 바꿔치기 할 수 있는 방법이 있습니다. 
> 그 방법을 사용하려면 나중에 구현체를 바꿔치기 해야합니다.   
>    
> 그러면, "상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다" 라는 상황인 것입니다.    
>     
> 그래서 나중에 실제 데이터베이스를 연결하게되면 뭐만 고치면 되냐면,     
>         
> ![image](https://user-images.githubusercontent.com/66030601/199452890-35185737-0ff4-4a3f-a130-ffc1a3e044e6.png)    
> 이것만 이런식으로 고치면 됩니다. 다른코드는 전혀 손댈 필요 없습니다.    
>     
> 이것이 바로, 직접 코드로 스프링 빈을 등록할 때의 장점입니다.   
> 그러나, 컴포넌트 스캔을 사용하면 여러 코드를 바꿔야 합니다.   
>         
> 여기서는 향후 메모리 리포지토리를 다른 리포지토리로 변경할 예정이므로, 컴포넌트 스캔 방식 대신에 자바 코드로 스프링 빈을 설정하겠습니다.    
>     
> 참고 : XML로 설정하는 방식도 있지만 최근에는 잘 사용하지 않으므로 생략합니다.    
>     
> 참고 : DI 에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있습니다. 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장합니다.  
>     
> 참고 : 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용합니다. 그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면, 설정을 통해 스프링 빈으로 등록합니다.   
>    
> 주의 : @Autowired 를 통한 DI는 helloController, memberService 등과 같이 스프링이 관리하는 객체에서만 동작합니다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않습니다.       
       
# 회원 관리 예제 웹 MVC 개발       
> ## [✅ 회원 웹 기능 - 홈 화면 추가](https://github.com/mgyokim/Spring/commit/d679f78688b5f3ffe2619b4d81b9aaaa37b25fc8)      
> 홈 화면을 추가해 보겠습니다.    
> 아주 단순하게, 회원을 등록하고 조회할 수 있는 버튼(링크)이 있는 사이트를 만들어보겠습니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199653469-0f90ac92-4db5-4ce5-9c6b-fa9987da8ae4.png)     
> 컨트롤러 패키지에 _**HomeController**_ 라는 이름으로 파일을 만들었습니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199653558-fa4bb91d-02bd-4102-ac64-7919ef51d093.png)      
> 이렇게 작성을 했습니다.     
>      
> "/" 는 뭐냐면, _**localhost:8080**_ 으로 딱 들어오면,     
> _**home()**_ 이 호출이 됩니다. 그러면 _**home.html**_ 이 호출되어야 할 것입니다.    
>     
> _**template**_ 에서 _**home.html**_ 을 생성하겠습니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/199653734-82489f3e-2919-4029-99f9-17c486db8467.png)       
> 이제 서버를 _**run**_ 시켜보겠습니다.       
>      
> ![image](https://user-images.githubusercontent.com/66030601/199653802-799c7abf-4b8b-486a-855d-685342a9b503.png)      
> _**localhost:8080**_ 의 화면입니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199653847-48468012-eda0-49c6-a7f1-1a09e5c87237.png)      
> 그리고 회원 가입 링크를 누르면, _**localhost:8080/members/new**_ 로 가게 했고,      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199654043-c3e7fec5-e4d6-4d56-b661-860b918a6f69.png)      
> 회원 목록을 누르면 _**localhost:8080/members**_ 로 가게 했습니다.    
>      
> 물론 지금은 페이지 _**Controller**_ 가 없으므로 에러페이지가 나옵니다.       
>        
> 그런데, 조금 이상한 점이 있습니다.      
> "이전에 _**index.html**_ 을 만들었는데 아무것도 없을 때는 _**WelcomePage**_ 로 간다고 했는데??"       
>          
> ![image](https://user-images.githubusercontent.com/66030601/199654521-1fd3baa6-363e-4ba3-8e02-3168eb89d9e5.png)           
> 저번에 이 그림과 함께 정적 컨텐츠를 공부한 것을 기억해 봅시다.       
>       
> 우선순위가 있습니다.       
>        
> 스프링에 요청이 오면, 
> 1. 스프링은 컨트롤러 쪽을 먼저 봐서 관련 컨트롤러가 있는지 먼저 찾고,
> 2. 없으면 _**static**_ 파일을 탐색하도록 되어있습니다.        
>          
> ![image](https://user-images.githubusercontent.com/66030601/199654904-d3a6fcef-ebf6-4614-9740-a1ede7b5eb48.png)       
> 즉, 첫번째 도메인인 "/" _**localhost:8080**_ 요청이 오면,     
> 첫번쨰 도메인이 매핑된 컨트롤러가 있는지 찾아본 후,       
> 매핑된게 있으므로, 해당 _**Controller**_ 가 호출되고 끝납니다.       
>        
> 그러면, 기존에 _**static**_ 파일에 만들어 두었던 _**index.html**_ 은 무시됩니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199655035-a37aa291-3615-4153-ba68-ffda4c4fd107.png)           
> _**home.html**_ 을 생성해서 작성해주었습니다.      
> 
> ***         
>      
> ## [✅ 회원 웹 기능 - 등록](https://github.com/mgyokim/Spring/commit/630626cac59e74f73a1a6e7731990e8cd5071ec2)       
>        
> ***      
>        
> ## [✅ 회원 웹 기능 - 조회](https://github.com/mgyokim/Spring/commit/89b9a87412d551ae520c1cb0646bd0b003d9ab2a)           
                      
# 스프링 DB 접근 기술
> ## [✅ H2 데이터베이스 설치](https://github.com/mgyokim/Spring/commit/b3195663b9e2e5e7e6012a55bdfc5404f189b55b)
>
>
> ***         
>       
> ## [✅ 순수 Jdbc](https://github.com/mgyokim/Spring/commit/c9624a88093fc355ec9ca53e1d4bd7ee78d4a946)
>
>
> ***         
>         
> ## [✅ 스프링 통합 테스트](https://github.com/mgyokim/Spring/commit/5878a71caae55232fccac0e1aa415350d3170d9e)
>
>
> ***         
>       
> ## [✅ 스프링 Jdbc Template](https://github.com/mgyokim/Spring/commit/b11b157933e846808b76425b5c0e75248eec5518)
>
>             
> ***           
>           
> ## [✅ JPA](https://github.com/mgyokim/Spring/commit/07d9353cbc1271af2d77ad30c825ff002278bd5a)
>
>
> ***         
>        
> ## [✅ 스프링 데이터 JPA](https://github.com/mgyokim/Spring/commit/67f3f5e419a78bc31dd7680bc6d0da7fc49354de)
>
>
> ***        
                  
# AOP
> ## ✅ AOP가 필요한 상황
>
>
> ***         
>       
> ## [✅ AOP 적용](https://github.com/mgyokim/Spring/commit/4b332ef4b3d61ec2556878be1f9ff903af0ac652)
>



## --------------------------------------------------------
--- 
위의 목차순으로
마지막에 느낀점 

기술 발전의 맥락을 이해하고, 기술의 주인의식을 갖고,