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
> 이번에는 회원 웹기능 - 등록을 만들어보도록 하겠습니다.       
>           
> ![image](https://user-images.githubusercontent.com/66030601/199656301-f3de6525-0a38-4f98-9359-2f0fabc51f64.png)         
> _**MemberController**_ 에 빨간 네모표시한 코드를 작성해주었습니다.  
> _**return**_ 은 _**members/createMemberForm**_ 으로 이동하도록 하겠습니다.
>        
> _**@GetMapping("members/new")**_ 에서 _**/members/new**_ 로 한 이유는,        
>         
> ![image](https://user-images.githubusercontent.com/66030601/199656478-1d2ca20d-fc9c-4cd3-a012-fc72b82d629b.png)          
> 이전에 작성해둔 _**home.html**_ 에서 _**/members/new**_ 로 이동하도록 설정했기 때문입니다.         
>            
> ![image](https://user-images.githubusercontent.com/66030601/199656558-9d1095fd-79eb-4b56-9958-636475a7903e.png)          
> 그리고, _**templates**_ 폴더 안에 _**members**_ 라는 폴더를 만들고, _**createMemberForm**_ 이라는 이름으로 _**html**_ 을 만들었습니다.       
>          
> ![image](https://user-images.githubusercontent.com/66030601/199657141-b25a279a-0b19-40f9-a0f9-219019d719a9.png)         
> 회원 등록폼 _**HTML**_ 을 작성해주었습니다.      
>      
> 서버를 _**run**_ 시켜보겠습니다.       
>         
> ![image](https://user-images.githubusercontent.com/66030601/199657461-774b2ff1-59da-4f7b-a90e-06ff6d9e75ec.png)          
> 회원 가입을 누르면, _**members/new**_ 로 들어가집니다.     
> 소스코드 보기를 하면,       
>         
> ![image](https://user-images.githubusercontent.com/66030601/199657639-cc58bc13-3cd7-471a-a769-2834a3c8bd8a.png)         
> 이렇게 방금 복사해서 작성한 _**html**_ 이 랜더링이 된 것을 확인할 수 있습니다.       
>         
> 지금은 코드를 다 작성하지 않아서 오류가 뜨지만,     
>        
> 예를 들어서 이름을 _**spring**_ 이라고 등록하면,  
> _**name**_ 이라는 이름의 _**key**_ 와 _**value**_ 인 _**spring**_ 이 서버로 넘어가게 됩니다.       
>        
> 이제, 회원을 등록하는 컨트롤러를 만들어야 합니다.       
>       
> ![image](https://user-images.githubusercontent.com/66030601/199657847-f97ce91f-b666-4d7b-8dff-90520a1d2d56.png)        
> _**MemberForm**_ 이라는 이름으로 컨트롤러를 생성했습니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199657906-cba58c38-88fa-4ea2-aef1-54860ee4ef8f.png)        
> _**private String name;**_ 을 만들어주고,     
> _**getter**_, _**setter**_ 를 만들어줍니다.         
>          
> 이렇게 하면,      
>          
> ![image](https://user-images.githubusercontent.com/66030601/199658089-ebdf150a-4dd2-40e9-86d0-9301846645c0.png)         
> _**MemberForm**_ 의 _**name**_ 과 _**createMemberForm.html**_ 의 _**name**_ 이 매칭되면서 값이 들어올 것입니다.       
>            
> ![image](https://user-images.githubusercontent.com/66030601/199658304-99867590-ba0b-49e6-b7a5-043ed2159c5a.png)        
> 그리고 실제 _**MemberController**_ 에다가 위 코드를 작성해줍니다.     
>          
> _**@PostMapping**_ 을 해줘야 합니다. "_**/members/new**_" 를 해줍니다.        
> 그리고         
>         
> _**Member mmeber = new Member();**_          
> _**member.setName(form.getName());**_            
>             
> 를 해주면 멤버가 만들어집니다.       
>       
> 그리고나서      
>        
> _**memberService.join(member);**_        
>         
> 으로 생성된 멤버를 넘깁니다.       
>        
> _**return "redirect:/";**_          
>             
> 그리고 회원가입이 끝낫으므로 _**return**_ 을 하는데, _**redirect**_ 를 이용해서 홈화면으로 보냅니다.         
>        
> 서버를 _**run**_ 시켜보겠습니다.           
>       
> ![image](https://user-images.githubusercontent.com/66030601/199658674-2e5218b8-b3f1-4eac-9571-730451d87aa8.png)       
> 그리고 등록을 누르면, 홈 화면으로 넘어갑니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199658752-7cc53c08-65d8-44fe-8d57-ff5563cd6950.png)        
> 간단하게 작동 과정을 알아보겠습니다.        
>        
> ![image](https://user-images.githubusercontent.com/66030601/199658910-88904a99-f8c7-4447-8e14-da022e807327.png)        
> 먼저, 회원가입으로 들어오면, _**members/new**_ 로 들어갑니다.       
>        
> _**/members/new**_ 로 와서 _**@GetMapping("/members/new")**_ 이 매핑됩니다.        
> 그러면, _**createForm()**_ 은 아무 하는 것 없이 "_**members/createMemberForm**_" 이라는 곳으로 이동을 하게 합니다.     
>        
> 즉, _**return**_ 한 "_**members/createMemberForm**_"를 _**templates**_ 에서 찾게됩니다.         
>          
> ![image](https://user-images.githubusercontent.com/66030601/199659131-1e237c2f-f3ce-4876-a0c4-6bf88403892c.png)             
> 그러면, _**templates**_ 에서 _**members**_ 의 _**createMemberForm**_ 이 _**ViewResolver**_ 를 통해서 선택이 되고,    
> _**thymeleaf**_ 템플릿 엔진이 해당 _**createMemberForm.html**_ 을 랜더링합니다.      
> 그러면, 해당 _**html**_ 이 뿌려지는 것입니다.        
>        
> ![image](https://user-images.githubusercontent.com/66030601/199659246-b3e630fa-9fc4-4e0b-bef0-57361dfcf8de.png)         
> _**createMemberForm.html**_ 을 보면, _**form**_ 이라는 태그가 있는데,      
> _**form**_ 태그는 값을 입력할 수 있는 _**html**_ 태그입니다.       
>         
> ![image](https://user-images.githubusercontent.com/66030601/199659484-ff588620-397b-491a-86cf-bda985819e86.png)         
> 중요한 것은, _**name="name"**_ 인데, _**"name"**_ 이 서버로 넘어올 때 _**key**_ 가 됩니다.         
>          
> _**spring**_ 이라고 적어주고 등록버튼을 누르면, 무슨일이 생기냐면,     
> _**action="/members/new"**_ 로 post방식으로 넘어옵니다.       
> 그러면, _**/members/new**_ 에 post 방식으로 넘어오면 어디로 가느냐면,       
>         
> ![image](https://user-images.githubusercontent.com/66030601/199659612-213bae3c-2a7d-4ae3-a5ce-07c6e11d0574.png)            
> _**MemberController**_ 의 _**@PostMapping**_ 으로 넘어옵니다.       
>         
> ※ 기본적으로 url 창에 주소를 입력해서 엔터치는 것은 _**@GetMapping**_ 입니다. _**@GetMapping**_ 은 조회할 때 주로 씁니다.         
>          
> _**@PostMapping**_ 은 보통,    
> 이렇게 데이터를 뭔가 _**<form>**_ 같은 곳에 넣어서 전달할 때는 _**@PostMapping**_ 을 씁니다.      
> 보통 데이터를 등록할 때, _**@PostMapping**_ 을 사용합니다.         
>       
> 그래서 URL은 똑같지만, _**@GetMapping**_ 이냐, _**@PostMapping**_ 이냐에 따라서 위 코드처럼 다르게 매핑할 수 있습니다.       
>        
> 다시 과정으로 넘어와서,        
>        
> ![image](https://user-images.githubusercontent.com/66030601/199659839-59752131-0e5d-4c6f-a8dc-e37dba699912.png)          
>          
> ![image](https://user-images.githubusercontent.com/66030601/199659869-30d1aa17-06d9-4828-baf7-02b13e3bc95a.png)        
> url은 똑같지만, 넘어온 메서드가 post 이기 때문에 _**@PostMapping**_ 이 선택되고, _**create(MemberForm form)**_ 가 호출됩니다.      
> 그러면서 값이 들어오는데,         
>        
> ![image](https://user-images.githubusercontent.com/66030601/199660146-1985365c-5d50-4334-9282-b7523ee6f2bb.png)           
> _**MemberForm**_ 의 _**name**_ 에 "_**spring**_" 이라는 값이 들어오게 됩니다.        
> _**setName()**_ 을 통해서 들어갑니다.       
> 값은 _**createMemberForm.html**_ 의 name값("_**spring**_") 을 보고 스프링이 _**setName()**_ 을 호출해서      
> _**MemberForm**_ 의 _**name**_ 에 "_**spring**_"을 넣어줍니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199660395-0cd34a5e-7207-447c-b6fb-64fa5febf799.png)       
> 그래서 _**MemberController**_ 의 _**create()**_ 에서 _**form.getName()**_ 으로 꺼내서 _**member.setName()**_ 을 해준 것입니다.     
>        
> 그리고나서 _**memberService.join(member);**_ 을 해서 가입이 된 것입니다.     
>        
> ***      
>        
> ## [✅ 회원 웹 기능 - 조회](https://github.com/mgyokim/Spring/commit/89b9a87412d551ae520c1cb0646bd0b003d9ab2a)           
> 이번에는 회원 웹기능 - 조회 를 만들어 보겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/199672494-7941e271-c2a5-40d2-9314-c556b8cb2981.png)     
> 이제 회원 목록을 눌렀을때 동작하도록 만들면 됩니다.     
>     
> 회원 목록 링크를 누르면, _**localhost:8080/members**_ 로 이동하도록 해두었습니다.   
>     
> _**MemberController**_ 에 코드를 작성하겠습니다.     
>       
> ![image](https://user-images.githubusercontent.com/66030601/199672679-7b80efb6-be62-4b06-868e-72f5c29ac891.png)        
> 회원 목록 링크를 누르면, _**localhost:8080/members**_ 로 가게 해두었으므로,      
>         
> _**@GetMapping("/members")**_    
>       
> 를 해줍니다.       
>     
> 그리고 _**public String List(Model model)**_ 을 해주는데,     
> _**memberService**_ 에서 _**findMembers();**_ 라고 하면, _**members**_ 를 다 끄집어 올 수 있습니다.        
> 그리고 _**model.addAttribute**_ 를 해서 _**members**_ 리스트 자체를 모델에 담아서 화면(view) 템플릿에 넘길 것입니다.     
> 넘길 곳은 return "_**member/memberList**_" 라고 했습니다.       
>      
> 그러면 _**member/memberList**_ 를 만들어야 합니다.     
>        
> ![image](https://user-images.githubusercontent.com/66030601/199675048-386d8171-8736-4ad8-8f40-cc8419f4aabd.png)        
> _**templates**_ 폴더의 _**members**_ 폴더 안에 _**memberList.html**_ 을 생성했습니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199675180-1c696915-7b7a-49f4-98e4-1da82bb67c4e.png)        
> _**memberList.html**_ 을 작성해주었습니다.     
>       
> 이 코드에서는 _**thymeleaf**_ 템플릿 엔진이 본격적으로 작동을 하는데요,   
> 이러한 템플릿 엔진이 무엇을 해주냐면,      
>      
> 서버를 _**run**_ 시켜보면,      
>          
> ![image](https://user-images.githubusercontent.com/66030601/199675378-cd367de1-22a1-402f-bea5-ccf10a8eff36.png)       
> 회원 목록 링크에 들어가보면, 아직 아무것도 없다.       
>         
> 한번, 가입을 해보겠습니다.    
> _**spring1**_ 이라는 이름과 _**spring2**_ 라는 이름으로 회원 가입을 했습니다.     
> 그리고나서 회원 목록을 가보면,       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199675863-91d4d4ba-3b3e-4140-b1b5-792af9663bfe.png)         
> 이렇게 _**spring1**_, _**spring2**_ 를 볼 수 잇습니다.       
>         
> ![image](https://user-images.githubusercontent.com/66030601/199676450-6e18a530-92f6-4634-9565-1ce8c431c14c.png)             
> 이 페이지의 소스보기를 해보면,     
> 빨간 네모 박스 부분이 템플릿 엔진이 랜더링 하는 부분인데,      
>       
> 실제 코드는 _**<tr></tr>**_ 이 하나인데, 회원가입을 2번하고 조회를 한 페이지의 소스코드에는 _**<tr></tr>**_ 이 2개로 랜더링 되어있습니다.     
>       
> 이것이 템플릿 언어가 랜더링 한 것입니다.      
> 다른태그는 다 그대로고,       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199677392-899e7e96-5d1f-4664-ab67-0e24cf2c2830.png)       
> 템플릿 언어에서 해당 _**members**_ 를 읽어들이는데,        
> 이 $표시안에 있는 _**members**_ 는 모델안에 있는 값을 꺼내는 것입니다.         
>         
> ![image](https://user-images.githubusercontent.com/66030601/199677523-b6c37070-91b0-4769-b54d-ab45cbefe36e.png)         
> _**MemberController**_ 를 보면,    
> _**model.addAttribute**_ 로 _**key**_ 가 "_**members**_"이고,      
> 이 _**members**_ 안에는 _**List**_ 로 모든 회원을 조회해서 담아놓았습니다.       
>         
> ![image](https://user-images.githubusercontent.com/66030601/199677759-493795de-920f-4841-8279-bcf3f83b8eca.png)       
> 그러면, _**th:each**_ 라고 하면, 루프를 다 돕니다. (thymeleaf 문법)      
> 루프를 돌면서 해당 빨간네모 로직을 실행합니다.       
>       
> 그러면, 루프마다,      
> _**${members}**_ 에서 첫번째 객체를 꺼내서 _**member**_ 에 담고,      
> 해당 _**member**_ 의 _**id**_ 와 _**name**_ 을 출력합니다.        
>       
> ![image](https://user-images.githubusercontent.com/66030601/199678641-aaf33dfd-3f28-409c-8c70-79700ce35f79.png)       
> 이때, _**id**_ 를 살펴보면, _**id**_ 와 _**name**_ 이 _**private**_ 이라서 직접 접근은 안되고,     
> _Java_ 프로퍼티 방식의 접근이라고하는      
> _**getter**_, _**setter**_ 접근 방식으로(_**getId**_, _**getName**_) 접근해서 값을 가져와서 출력해주게 되는 것입니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199678957-4ef6197c-4406-4658-a243-c650fc9a8651.png)       
> 그렇게 해서 최종 결과물이 이렇게 랜더링 된 것이고,      
> 브라우져로 이것을 잘 뿌려준 것입니다.       
>                  
> ![image](https://user-images.githubusercontent.com/66030601/199679209-6464b09a-0484-4588-801f-ac11566153a7.png)         
> 지금까지, 회원 조회까지 다 작성해 보았습니다.       
>       
> ![image](https://user-images.githubusercontent.com/66030601/199679386-1b6c5bc9-4b8a-4a6f-8729-bc1a2fc53e80.png)       
> 데이터가 메모리에 있기 때문에      
> 서버를 내렸다가 다시키게 되면, 데이터가 삭제됩니다.      
>        
> 서버를 내렸다가 회원목록을 들어가보면, 아무것도 없는 것을 확인할 수 있습니다.       
> 메모리 안에 있기 때문에 서버를, 자바를 내려버리면, 당연히 회원 데이터가 사라집니다.      
>       
> 그래서 우리는 이 데이터들을 파일이나 데이터베이스에 저장을 해야합니다.      

                      
# 스프링 DB 접근 기술
> ## [✅ H2 데이터베이스 설치](https://github.com/mgyokim/Spring/commit/b3195663b9e2e5e7e6012a55bdfc5404f189b55b)        
> H2 데이터베이스는 개발이나 테스트 용도로 가볍고 편리한 DB, 웹 화면을 제공합니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/199902656-87d3f51a-7344-44eb-911e-92ba509f8f6e.png)       
> [h2database 다운로드](https://www.h2database.com/html/download-archive.html)      
> ![image](https://user-images.githubusercontent.com/66030601/199904676-3752717f-82d3-420e-bbae-771739a63180.png)        
> 해당 버전을 설치하고,    
> 압축을 푼 뒤, 터미널에서 생성된 _**h2**_ 파일의 _**bin**_ 파일 위치로 이동하겠습니다.       
>         
> ![image](https://user-images.githubusercontent.com/66030601/199904841-d80f6b5a-d75d-44af-8a1e-37c955a20fb6.png)        
> _**h2.sh**_ 라는 이름의 실행파일이 있습니다.       
>      
> <pre><code>chmod 755 h2.sh</code></pre>
>       
> ![image](https://user-images.githubusercontent.com/66030601/199905291-070fac40-ae0c-4dae-83ad-8a9c849873e0.png)          
> Mac 기준으로, 우선, 해당 파일을 실행하는 권한을 줘야합니다.       
>       
> <pre><code>./h2.sh</code></pre>         
>
> ![image](https://user-images.githubusercontent.com/66030601/199905576-8d39ec41-f4f8-43b0-9699-05119d0f5c29.png)             
> 이제, 위 명령어로 실행을 해보겠습니다. (터미널 현재 위치가, _**bin**_ 일때 기준))      
>       
> 만약에 데이터베이스가 정상적으로 생성되지 않으면, 아래 절차를 시행해보아야합니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199905750-30b5ddf5-3c6c-4958-801e-0e7d6104d797.png)      
> 자 다시, 돌아와서.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199905828-932a93b3-c471-42bb-8634-c27d457288cb.png)        
> 실행이 완료 되었습니다.      
>       
> 최초에는 데이터베이스 파일이라는 것을 만들어야 합니다.    
> 그래서 어떻게 해야하냐면,     
>       
> ![image](https://user-images.githubusercontent.com/66030601/199906981-f5c53533-c3b1-48fe-bd3b-3f9b9e588161.png)       
> 경로를 "_**jdbc:h2:~/test**_" 로 해주는데, 뭘 의미하냐면,       
> 내 _**home**_ 에 있는 _**test**_ 라는 파일을 말합니다.       
>        
> 이렇게 설정한 후, 연결을 합니다.       
>       
> ![image](https://user-images.githubusercontent.com/66030601/199907162-29c9ef26-f9a9-4048-88e7-a465f971c3de.png)       
> 그러면 이렇게 만들어집니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199907206-2fdfa2ac-a0c6-4156-b157-6271d5b3f17a.png)         
> 그리고 이 버튼으로 나갈 수 있는데,       
> 나가서 확인해야 할 것이 있습니다.    
>       
> 추가 터미널 창에서 _**home**_ 위치에서,       
>        
> <pre><code>ll</code></pre>
> 이 명령어를 이용해서     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199907557-e2a7ccde-f2ec-4195-8eef-34fd878de393.png)       
> _**home**_ 에 "_**test.mv.db**_" 파일이 있는지 확인해야 합니다. 있으면 OK          
>             
> 그리고, 이시점 이후부터는 어떻게 h2 에 접속을 해야하냐면,       
>       
> ![image](https://user-images.githubusercontent.com/66030601/199907752-00216fab-9fbb-463a-b3bd-18fb072d7508.png)        
> 이렇게 파일로 접근하게 되면,      
> 웹콘솔과 애플리케이션이 동시접근이 안될 수도 있습니다. 즉, 오류가 날 수도 있습니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199907942-2a642d73-de04-40c5-ab25-1821a318f469.png)         
> 이렇게 하면, 파일에 직접 접근하는 것이 아니라,      
> 소켓을 통해서 접근하게 됩니다.     
>        
> 이렇게 해야 여러군데에서 접근할 수 있습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/199908136-c6116054-b6e8-484f-a61f-e32e1e67b8bf.png)         
> 이렇게 연결 해주면 됩니다.      
>       
> 만약 혹시라도 DB에 문제가 있다면, 연결을 나와서,       
> <pre><code>rm test.mv.db</code></pre>           
> 터미널에  이 명령어를 이용해서 _**test.mv.db**_ 파일을 지우고       
> 서버를 완전히 내린 후, 처음부터 다시 진행해보길 바랍니다.      
>        
> 테이블을 만들어보겠습니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199913211-9ea7ae9e-1e4e-48d7-b5e3-ba01a4fd9e28.png)
> 테이블 관리를 위해 프로젝트 루트에 _**sql/ddl.sql**_ 파일을 생성합니다.     
>       
> 우리가 만들었던 _**member**_ 의 _**table**_ 을 만들 것입니다.      
> 실행 버튼을 눌러서 만들었습니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/199909440-5f11d890-d431-486d-b039-e12274dea696.png)       
> _**id bigint generated by default as identity,**_          
>          
> _**id**_ 는 java에서는 _**Long**_ 인데, DB에서는 _**bigint**_ 라는 타입입니다.      
> 그리고, _**generated by default as identity**_ 가 있는데, 이게 뭐냐면,      
> 만약에 _**id**_ 값을 세팅하지 않고, _**null**_ 값을 _**insert**_ 하면, data가 들어왔을 때, 자동으로 _**id**_ 값을 채워줍니다.      
>        
> _**name varchar(255),**_          
>           
> 그리고 _**name**_ 은 _**varchar**_ 타입으로 만들어놨습니다.     
>      
> _**primary key**_ 는 _**id**_ 로 잡았습니다.      
>      
> 정말 단순하게 작성한 것입니다.       
>       
> 그리고,      
>       
> _**SELECT * FROM MEMBER**_           
>        
> 를 이용하여 조회할 수 있습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/199911220-ed2e45bc-b61e-4ce3-885b-f1f73b948527.png)       
> 현재는 저장된 데이터가 없습니다.      
>             
> _**insert**_ 를 해보겠습니다.      
>         
> _**INSERT INTO MEMBER(name) VALUES('spring')**_                
>            
> ![image](https://user-images.githubusercontent.com/66030601/199911396-c0b4e3c1-35bb-4d84-9a29-7dd1e2170680.png)                  
> 실행을 누르면, _**insert**_ 에 의해 갱신이 1개 되었다고 결과를 받을 수 있습니다.      
> 확인해보겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/199911522-4211a0cd-e39f-4164-b93b-6b1c0e25bb7a.png)       
> 이렇게 _**id**_ 는 1이 자동으로 들어갔고, _**NAME**_ 에는 _**spring**_ 이 들어간 것을 확인할 수 있습니다.      
>        
> 1개 더 _**insert**_ 해보겠습니다. _**name**_ 에 '_**spring2**_'를 넣어보겠습니다.       
>       
> ![image](https://user-images.githubusercontent.com/66030601/199911740-60590884-14f7-4cfd-9e0b-56589654919d.png)         
> 확인해보겠습니다.        
>       
> ![image](https://user-images.githubusercontent.com/66030601/199911858-d3cb1b2d-d7e9-416d-961b-79a9a91167fc.png)        
> 이것도 _**id**_ 를 생략하고 _**name**_ 만 '_**spring2**_' 을 넣어주었는데,     
> _**id**_ 가 자동으로 2, 그리고 _**NAME**_ 은 _**spring2**_ 가 잘 저장되었습니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199912190-d4637745-4f3a-448f-a86a-9216410f86b5.png)          
> 사실, _**MemberRepository**_ 의 구현체인 _**MemoryMemberRepository**_ 도 _**sequence**_ 라는 것을 통해 db에 _**save()**_ 했을 때, 자동으로 증가되도록 만들었었습니다. 이것과 같은 원리로 맞춘 것입니다.        
>       
> 이런식으로 _**Primary Key**_ 에 대한 생성을 "DB야 너가 알아서 해줘!!" 라고 넘긴 것입니다.      
>       
> ### DDL 관리      
> ![image](https://user-images.githubusercontent.com/66030601/199913589-3121d594-2eb0-4a73-957d-58f798dfdda0.png)       
> 방금 사용한 _**SQL DDL**_ 을 관리하면 좋은데,      
> 이런식으로 _**sql**_ 이라는 이름으로 _**hello-spring**_ 하위 폴더를 만들어서     
> _**sql**_ 폴더에 _**ddl.sql**_ 이라는 이름으로 파일을 생성합니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199913844-e2db653f-a2ec-467e-9bea-965e39d1f15d.png)        
> 이런식으로 만들어 두고, 좀전에 _**DB table**_ 을 생성한 _**DDL**_ 같은 것을 저장해서 관리합니다.       
>       
> 이렇게 해두면,           
> _**git**_ 같은 것을 이용하여 버전관리를 하면,      
> 변경내역이 함께 관리가 되기 때문에 이점을 얻을 수 있습니다.    
>         
> 이번시간에는 DB에 웹 콘솔로 들어갓는데,     
> 다음시간에는, 우리가 만들었던 _**Application**_ 에서 DB로 접근해서 데이터를 넣고 빼는 등의 작업을 해보겠습니다.    
>     
> ***         
>       
> ## [✅ 순수 Jdbc](https://github.com/mgyokim/Spring/commit/c9624a88093fc355ec9ca53e1d4bd7ee78d4a946)     
> 애플리케이션에 DB에 연동을 해서 저장하는 것을 해보겠습니다.    
> 기존처럼 Memory에 저장하지 않고, 데이터베이스에 insert쿼리, select 쿼리를 날려서 데이터를 넣고 빼는 것을 해보겠습니다.     
>       
> 이번시간에는, 정말 오래된 JDBC방식으로 해보겠습니다.     
>        
> 먼저, _**build.gradle**_ 파일에 jdbc, h2 데이터베이스 관련 라이브러리를 추가해야 합니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199930700-db47316f-d080-4ec6-8ea6-6c38c1e5cf8b.png)       
> _**build.gradle**_ 파일에 jdbc, h2 데이터베이스 관련 라이브러리를 추가해주었습니다.      
>       
> <pre><code>implementation 'org.springframework.boot:spring-boot-starter-jdbc'
> runtimeOnly 'com.h2database:h2'</code></pre>         
> 코드를 보면, '_**spring-boot-starter-jdbc**_'를 볼 수 있는데,    
> 자바는 기본적으로 db랑 붙으려면, jdbc 드라이버가 꼭 있어야 합니다. 이것을 가지고 서로 연동하는것입니다.     
> 그리고 '_**com.h2database:h2**_' 는 뭐냐면, db랑 붙을 때, 데이터베이스가 제공하는 클라이언트가 필요한데, 이것은 h2database 클라이언트를 설정 해준것입니다.      
>         
> 이렇게 두 개의 라이브러리를 넣으면 되고,     
>      
> 이제 db에 붙으려면 접속정보 같은 것들을 설정해줘야 합니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/199934436-d072ab38-5c7a-4ddc-a919-c2a13b977313.png)       
> _**resources/application.properties**_ 에다가 스프링 부트 데이터베이스 연결 설정을 추가해주겠습니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199934595-fd4024a5-e3c3-4217-aa5d-72e0406155d8.png)      
> <pre><code>spring.datasource.url=jdbc:h2:tcp://localhost/~/test</code></pre>      
> url은 우리가 h2 데이터베이스에 접근할때 사용하는 url을 적어주면 됩니다.     
>       
> ![image](https://user-images.githubusercontent.com/66030601/199934805-25ccdf68-7101-4d69-b685-b52cef9b0c94.png)         
> 이 url과 동일하게 적어주면 됩니다.       
> <pre><code>spring.datasource.driver-class-name=org.h2.Driver</code></pre>         
> 그리고 _**driver-class-name**_ 이라는게 필요한데, 우리가 h2 데이터베이스로 접근할 것이기 때문에 _**org.h2.Driver**_ 를 넣어주면 됩니다.      
>       
> <pre><code>spring.datasource.username=sa</code></pre>     
> 그리고 스프링부트 2.4부터는 _**spring.datasource.username=sa**_ 를 꼭 추가해주어야 합니다.    
> 그렇지 않으면 _**Wrong user name or password**_ 오류가 발생합니다. 참고로 마지막에 공백이 들어가면 같은 오류가 발생합니다.     
> _**spring.datasource.username=sa**_ 공백주의를 해야합니다. 공백은 모두 제거합니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/199936497-a50185f4-8259-4129-a2d0-1144c69680b2.png)       
> 이렇게만 해두면, 데이터베이스에 접근할 준비는 끝났습니다. (원래는 데이터베이스 id, pw 등도 적어야 하는데, h2 데이터베이스는 생략)      
>      
> _**run**_ 시키면, 스프링이 DB와 연결하는 작업을 다 해줍니다. 그리고 이제 이것을 가져다 사용하면 됩니다.      
>       
> 이제, _**JDBC API**_ 를 가지고 개발을 해보겠습니다.     
>       
> 어디를 개발할 것이냐면, 기존에 _**MemoryMemberRepository**_ 라고 _**MemberRepository**_ 인터페이스의 구현체를 만들어 놓았는데,    
> _**MemberRepository**_ 가 인터페이스이기때문에 구현체를 개발하면 됩니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199937714-4e2f8a91-b1a8-4a38-86f3-fbea2af5663e.png)       
> _**JdbcMemberRepository**_ 라는 이름으로 클래스를 생성하겠습니다.     
>       
> ![image](https://user-images.githubusercontent.com/66030601/199938045-91c6bcdf-701c-4f12-90de-5c7076686459.png)           
> _**MemberRepository**_ 를 _**implements**_ 해주고, implement methods 를 해주겠습니다.      
>       
> 이제 하나씩 구현하면 됩니다.     
>      
> 그런데, 이렇게 _**JDBC API**_ 로 직접 코딩하는 것은 20년 전 이야기입니다.    
> 따라서 고대 개발자들이 이렇게 고생하고 살았구나..정도로 생각하고, 참고로 보면 됩니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/199938614-5cb6beae-227a-4fe3-8eae-259f5e626c65.png)        
> 먼저, DB에 붙으려면 _**DataSource**_ 라는 것이 필요합니다.     
> 그리고 얘를 나중에 스프링한테 주입받아야 하는데,     
>       
> ![image](https://user-images.githubusercontent.com/66030601/199945467-cd1e8c82-2c50-4750-a744-957cf8bf21e2.png)        
> 우리가 이것을 세팅했으므로, 스프링부트가 _**DataSource**_ 라는 것을 접속정보를 이용해서 만들어 놓습니다.     
>      
> 그러면, _**dataSource.getConnection()**_ 을 해서 데이터베이스 커넥션을 얻을 수 있습니다.    
> 그러면 진짜 데이터베이스와 연결된 열린 소켓을 얻을 수 있는 것입니다.     
> 여기다가 _**sql**_ 문을 날려서 _**db**_ 에 전달해 주는 것입니다.     
>            
> ![image](https://user-images.githubusercontent.com/66030601/199952976-2fc43766-63f2-4089-8bcd-43bf56d70845.png)          
> _**DataSourceUtils**_ 를 통해서 커넥션을 획득해야합니다.     
> 데이터베이스 트랜잭션같은게 걸리더라도 똑가은 데이터베이스 커넥션을 유지해야하는데, 그것을 유지시켜주는 역할을 합니다.   
>    
> <pre><code>private Connection getConnection() {
>    return DataSourceUtils.getConnection(dataSource);
> }</code></pre>
> 그래서, 스프링 프레임 웍을 사용할 때에는, 꼭 이렇게 커넥션을 가져와야 합니다.    
>       
> <pre><code>private void close(Connection conn) throws SQLException {
>    DataSourceUtils.releaseConnection(conn, dataSource);
> }</code></pre>
> 커넥션을 닫을 때도, _**DataSourceUtils**_ 를 통해서 _**release**_ 를 해야 합니다.    
>    
> 위에서 말한, 커넥션을 얻는 것과, 커넥션을 닫을 때 주의해야합니다.    
>        
> 최종적으로 작성한 _**JdbcMemberRepository**_ 의 코드입니다.     
> <pre><code> 
>package hello.hellospring.repository;
>
> import hello.hellospring.domain.Member;
> import org.springframework.jdbc.datasource.DataSourceUtils;
> import javax.sql.DataSource;
> import java.sql.*;
> import java.util.ArrayList;
> import java.util.List;
> import java.util.Optional;
>
> public class JdbcMemberRepository implements MemberRepository {
>
>    private final DataSource dataSource;
> 
>    public JdbcMemberRepository(DataSource dataSource) {
>        this.dataSource = dataSource;
>    }
> 
>    @Override
>    public Member save(Member member) {
>        String sql = "insert into member(name) values(?)";
> 
>        Connection conn = null;
>        PreparedStatement pstmt = null;
>        ResultSet rs = null;
> 
>        try {
>            conn = getConnection();
>            pstmt = conn.prepareStatement(sql,
>                    Statement.RETURN_GENERATED_KEYS);
> 
>            pstmt.setString(1, member.getName());
> 
>            pstmt.executeUpdate();
>            rs = pstmt.getGeneratedKeys();
> 
>            if (rs.next()) {
>                member.setId(rs.getLong(1));
>            } else {
>                throw new SQLException("id 조회 실패");
>            }
>            return member;
>        } catch (Exception e) {
>            throw new IllegalStateException(e);
>        } finally {
>            close(conn, pstmt, rs);
>        }
>    }
> 
>    @Override
>    public Optional<Member> findById(long id) {
>        String sql = "select * from member where id = ?";
> 
>        Connection conn = null;
>        PreparedStatement pstmt = null;
>        ResultSet rs = null;
> 
>        try {
>            conn = getConnection();
>            pstmt = conn.prepareStatement(sql);
>            pstmt.setLong(1, id);
> 
>            rs = pstmt.executeQuery();
> 
>            if(rs.next()) {
>                Member member = new Member();
>                member.setId(rs.getLong("id"));
>                member.setName(rs.getString("name"));
>                return Optional.of(member);
>            } else {
>                return Optional.empty();
>            }
> 
>        } catch (Exception e) {
>            throw new IllegalStateException(e);
>        } finally {
>            close(conn, pstmt, rs);
>        }
>    }
> 
>    @Override
>    public Optional<Member> findByName(String name) {
>        String sql = "select * from member where name = ?";
> 
>        Connection conn = null;
>        PreparedStatement pstmt = null;
>        ResultSet rs = null;
> 
>        try {
>            conn = getConnection();
>            pstmt = conn.prepareStatement(sql);
>            pstmt.setString(1, name);
> 
>            rs = pstmt.executeQuery();
> 
>            if(rs.next()) {
>                Member member = new Member();
>                member.setId(rs.getLong("id"));
>                member.setName(rs.getString("name"));
>                return Optional.of(member);
>            }
>            return Optional.empty();
>        } catch (Exception e) {
>            throw new IllegalStateException(e);
>        } finally {
>            close(conn, pstmt, rs);
>        }
>    }
> 
>    @Override
>    public List<Member> findAll() {
>        String sql = "select * from member";
> 
>        Connection conn = null;
>        PreparedStatement pstmt = null;
>        ResultSet rs = null;
> 
>        try {
>            conn = getConnection();
>            pstmt = conn.prepareStatement(sql);
> 
>            rs = pstmt.executeQuery();
> 
>            List<Member> members = new ArrayList<>();
>            while(rs.next()) {
>                Member member = new Member();
>                member.setId(rs.getLong("id"));
>                member.setName(rs.getString("name"));
>                members.add(member);
>            }
> 
>            return members;
>        } catch (Exception e) {
>            throw new IllegalStateException(e);
>        } finally {
>            close(conn, pstmt, rs);
>        }
>    }
> 
>    private Connection getConnection() {
>        return DataSourceUtils.getConnection(dataSource);
>    }
> 
>    private void close(Connection conn, PreparedStatement pstmt, ResultSet rs)
>    {
>        try {
>            if (rs != null) {
>                rs.close();
>            }
>        } catch (SQLException e) {
>            e.printStackTrace();
>        }
>        try {
>            if (pstmt != null) {
>                pstmt.close();
>            }
>        } catch (SQLException e) {
>            e.printStackTrace();
>        }
>        try {
>            if (conn != null) {
>                close(conn);
>            }
>        } catch (SQLException e) {
>            e.printStackTrace();
>        }
>    }
>    private void close(Connection conn) throws SQLException {
>        DataSourceUtils.releaseConnection(conn, dataSource);
>    }
> }</code></pre>     
>     
> 이제 서버를 돌리면 될까요?     
> 안됩니다.     
>       
> 왜냐하면, _**Configuration**_ 해줘야 하기 때문입니다.    
> 우리가 지금까지 저장할 때는 메모리에 저장했었습니다.     
>       
> ![image](https://user-images.githubusercontent.com/66030601/199985816-ce12865d-e40d-4aab-8214-613f98b906a5.png)        
> 즉, _**MemoryMemberRepository**_ 를 사용하고 있었습니다.      
>      
> 이점은 _**SpringConfig**_ 에서도 확인할 수 있는데요,     
>      
> ![image](https://user-images.githubusercontent.com/66030601/199985987-c4c33f37-9be6-4da0-9f76-9e44871a5f23.png)        
> _**MemoryMemberRepository**_ 를 스프링빈으로 등록해서 사용했었습니다.       
> 이것을 방금 만든, _**JdbcMemberRepository**_ 로 바꿉니다.          
>         
> 그리고, 작성해둔 _**JdbcMemberRepository**_ 를 살펴보면,      
>       
> ![image](https://user-images.githubusercontent.com/66030601/199986309-57574c7f-de50-4cd3-b533-a01dff4a39b4.png)        
> _**DataSource**_ 를 넣어줘야하는데,     
>      
> 이것은 스프링이 제공을 해주는데, 어떻게 제공을 해주냐면,       
>       
> ![image](https://user-images.githubusercontent.com/66030601/199986472-3690e300-17e1-446b-a974-a17888695cb5.png)       
> 이렇게 작성을 하면 됩니다.   
>      
> _**@Configuration**_ 한 것도 스프링빈으로 관리가 되기 때문에,   
> 이렇게 작성을 해두면, 스프링이 자체적으로 스프링빈을 생성해줍니다.      
>       
> 즉, 스프링이 _**dataSource**_ 를 스프링빈으로 등록해준 것입니다.       
>        
> 오직 _**JdbcMemberRepository**_ 를 만들어서 _**MemberRepository**_ 인터페이스를 구현했습니다.   
> 그리고, _**SpringConfig**_ 에서 스프링이 제공하는 _**@Configuration**_ 만 수정했습니다.    
> 스프링 빈으로 등록하는 부분을 수정했을 뿐입니다.    
>     
> 이외 기존의 다른 어떤 코드도 변경하지 않았습니다.      
>       
> 이제 서버를 실행해보겠습니다.       
> 실행하기전에 _**h2 DB**_ 를 실행해두는 것을 잊으면 안됩니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199990586-d8b3caf8-27c8-41a7-acfe-392a7207f9dd.png)              
> _**h2 DB**_ 를 실행하고,      
>       
> 서버를 실행하고, _**localhost:8080**_ 에 접속해보겠습니다.       
>       
> ![image](https://user-images.githubusercontent.com/66030601/199990801-f34d5534-8133-4eab-b9d1-6cd4343ea821.png)        
> 기존에 h2 DB에 쿼리문으로 'spring'과 'spring2'를 작성했었습니다.     
> 회원 목록을 확인해보겠습니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/199991132-da88f49a-d58c-404a-9b7e-522ff6609d50.png)        
> DB에 저장해둔 회원이름을 확인할 수 있습니다.      
>       
> 이번에는 회원 가입을 해보겠습니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/199992710-4d56ab91-18a7-40d7-bd55-8d532aa32782.png)       
> jpa 라는 이름으로 등록했습니다.     
>        
> ![image](https://user-images.githubusercontent.com/66030601/199992930-bd2fccd9-ebf6-491a-89c6-9f56aabaa9cc.png)         
> 회원목록을 확인해보면, jpa가 저장되어있습니다.      
>       
> 이번에는 DB Console에서 확인해보겠습니다.     
>     
> ![image](https://user-images.githubusercontent.com/66030601/199994059-210a77e9-0fa4-4ae6-9b09-09992c789e54.png)        
> jpa가 잘 등록되어 있습니다.     
>       
> 애플리케이션에서 데이터베이스에 접근한 것이 굉장히 잘 동작하고 있는 것을 확인할 수 있습니다.  
>       
> ## 스프링을 사용하는 이유      
> ![image](https://user-images.githubusercontent.com/66030601/199994555-8088f439-2607-4595-8dde-ef853bd6af7a.png)       
> 스프링을 쓰는 이유가 바로 이런 것 입니다.      
>       
> 객체 지향 설계가 좋다좋다 하지만, "왜 좋은가?" 라고 한다면,  
> 이렇게 인터페이스를 두고 구현체를 바꿔끼기 하는 것을 "다형성을 활용한다" 라고 이야기 할 수 있는데,   
>     
> 스프링은 이것을 굉장히 편리하게 할 수 있도록 스프링 컨테이너가 이것을 지원해주는 것입니다.      
>      
> 그리고 소위 말하는 "_**DI**_" (의존성 주입) 덕분에 이러한 것을 굉장히 편리하게 하는 것입니다.       
>      
> 기존의 코드는 손대지 않고,     
> 오직 애플리케이션을 설정하는 코드만 수정하고,   
> 나머지 실제 어플리케이션과 관련된 코드는 하나도 손대지 않고 구현 클래스를 바꿀 수 있습니다.      
>       
> 이것을 편리하게 해주는 것이 스프링의 장점입니다.  
>       
> ![image](https://user-images.githubusercontent.com/66030601/199999210-2cf8d49b-452b-4ed5-b267-3a747076944c.png)       
> _**MemberService**_ 는 _**MemberRepository**_ 를 의존하고 있습니다.     
>       
> MemberRepository 인터페이스는 구현체로     
> - _**MemoryMemberRepository**_        
> - _**JdbcMemberRepository**_     
>     
> 가 있습니다.    
>      
> ![image](https://user-images.githubusercontent.com/66030601/200016680-d55c7dcf-ffb0-4938-89c1-dc19bf634a0d.png)       
> 그런데 스프링 컨테이너에서 기존에는 _**MemoryMemberRepository**_ 를 스프링 빈으로 등록했었다면,     
>      
> 이제는, _**MemoryMemberRepository**_ 를 빼고,   
> _**Jdbc**_ 버전의 _**JdbcMemberRepository**_ 를 스프링 빈으로 등록했습니다.     
>      
> 그리고나면 나머지는 하나도 손댈 것이 없습니다.     
>     
> 구현체가 _**JdbcMemberRepository**_ 로 바뀌어서 서버가 돌아갑니다.    
>      
> ## SOLID (객체 지향 설계)      
> ![image](https://user-images.githubusercontent.com/66030601/200018015-071908e4-f5e4-4309-8172-9a5be9a86377.png)       
> _**SOLID**_ 라는 객체지향 프로그래밍 및 설계의 다섯 가지 기본 원칙이 있는데,     
>       
> 이중에서 _**OCP**_(개방-폐쇄 원칙)는     
> 객체 지향에서 말하는 다형성 이라는 개념을 잘 활용하면, 잘 지킬 수 있습니다.     
> 우리가 했던 것 처럼 기능을 완전히 변경을 해도, 애플리케이션 전체를 수정할 필요가 없는 것 입니다.       
>      
> 조립하는 코드는 어쩔 수 없이 수정해야하지만,      
> 실제 어플리케이션이 동작하는데에 필요한 코드들은 하나도 변경하지 않을 수 있습니다.    
>       
> ![image](https://user-images.githubusercontent.com/66030601/200020701-ad9ae592-8564-43dd-ada9-acb5a9fbcbfd.png)      
> 이것은 개방 폐쇄 원칙이 지켜진 것이라고 할 수 있습니다.
>
> ***         
>         
> ## [✅ 스프링 통합 테스트](https://github.com/mgyokim/Spring/commit/5878a71caae55232fccac0e1aa415350d3170d9e)
> 이전시간에 만들었던 _**JdbcMemberRepository**_ 는 DB까지 연결이 됩니다.      
>       
> 그러면, 테스트도, 스프링까지 다 올리고 DB까지 연결해서 동작하는 통합 테스트를 해보아야 합니다.     
> 스프링 통합 테스트를 해보겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200104140-605754b6-8ab2-4019-9a00-efc5a5bdf35d.png)         
> 이전에 했던, 이런 테스트들을 보면,      
> 전혀 스프링과 관련이 없는 테스트들입니다.      
>      
> 순수한 _**Java**_ 코드를 가지고 테스트 한 것입니다.      
>       
> 그런데, 지금은 순수한 _**Java**_ 코드만 가지고 테스트 할 수 없습니다.      
> 왜냐하면, 데이터베이스 커넥션 정보도 스프링 부트가 들고있기 때문입니다.      
>       
> 그래서 지금부터는, 테스트를 스프링과 엮어서 해볼 것입니다.       
>         
> 우선, 기존에 만들어 두었던, _**MemberServiceTest**_ 를 살펴보겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200104257-af687571-4aeb-4475-a786-bfdab0067445.png)         
> 이 테스트는 메모리에 저장하는 테스트이기 때문에 _**Java**_ 뜨는 시간만 제외하면 거의 시간소요가 없습니다.    
> 이것은 _**JVM**_ 안에서 끝나는 테스트입니다.      
>       
> 이번에는 DB까지 연결해서 테스트를 만들어보겠습니다.      
>     
> ![image](https://user-images.githubusercontent.com/66030601/200104289-5ee85e94-09ca-4d3b-9b7d-0dc4cda790d9.png)         
> 우선은, _**MemberServiceTest**_ 를 복사 붙여넣기해서 이름이 _**MemberServiceIntegrationTest**_ 라는 클래스를 생성했습니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/200104317-24fc1736-85ec-4838-b205-e18a63f43371.png)        
> 스프링 컨테이너와 테스트를 함께 실행하도록 하기위해 _**@SpringBootTest**_ 를 붙여주고,     
> 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백 하도록하여 DB에 데이터를 남기지 않게 해서      
> 다음 테스트에 영향을 주지 않게 하기위해 _**@Transactional**_ 를 붙이면 됩니다.       
>         
> ![image](https://user-images.githubusercontent.com/66030601/200104424-29608242-5128-4c39-a30e-614ad4030903.png)         
> 그리고 이 부분을 보면, 직접 객체를 생성해서 넣어주었는데,     
> 이제는 스프링 컨테이너에게 "_**MemberService**_, ***MemberRepository***를 내놔!!" 라고 해야합니다.      
> 파란색 표시된 부분은 지워주도록 하겠습니다.      
>       
> 테스트는, 제일 끝 단에 있는 것이기 때문에, 테스트 코드를 만들 때는, 제일 편한 방법으로 쓰면 됩니다.       
>         
> ![image](https://user-images.githubusercontent.com/66030601/200104494-b8cdb755-011b-4fc5-a8b5-253ab99746d2.png)        
> _**@Autowired**_ 를 바로 넣어줘도 됩니다.      
> 테스트를 다른데서 가져다 쓸 것이 아니기 때문에, 테스트는 내가 필요한 것을 인젝션해서 사용하고 끝이기 때문에,    
> 테스트 케이스를 작성할 때는 필드 기반으로 _**@Autowired**_ 를 받는 것이 편합니다.      
>        
> 그리고, 중요한게 있는데,      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200104522-87c7c910-23f7-44e0-8f44-6630c5d9366b.png)         
> 이 부분을 _MemoryMemberRepository_ 로 해주는 것이 아니라, _**MemberRepository**_ 로 바꿔야합니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200104574-67828d58-afba-41ff-8db6-69a46ce15ac6.png)        
> _**@AfterEach**_ 도 지워줍니다.       
> _**@AfterEach**_ 가 필요했던 이유는, 메모리 DB에 있는 데이터를 다음 테스트에 영향이 없도록 지워주기 위함이었는데,      
> 이제 _**@Transactional**_ 을 사용할 것이기 때문에 필요없습니다.       
>         
> ![image](https://user-images.githubusercontent.com/66030601/200104618-c7166d7e-a917-4378-9417-52f054ff6b2a.png)        
> 그 다음, 회원가입 로직 그대로 두고, 중복 회원 예외 로직도 그대로 납둡니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200104630-b323a748-ef41-415e-995c-ff66c37fceaf.png)        
> 일단, 회원 가입테스트를 돌려보겠습니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/200104642-86276211-cc95-4e3c-95d0-ddb782704710.png)       
> 회원가입을 하는데, "이미 존재하는 회원입니다."라는 예외가 발생했습니다.     
>       
> 이유를 살펴보겠습니다.      
> 우리가 사용하는 DB를 살펴보면,      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200104756-de9d91f0-c606-4e55-bd53-5cf6d70173e2.png)      
> "spring" 이라는 이름의 데이터가 저장 되어있습니다.     
>        
> ![image](https://user-images.githubusercontent.com/66030601/200104785-96cb024f-6eae-44f5-a6d0-22cc639542e9.png)       
> 그런데, 테스트를 할 때, "spring" 이라는 이름으로 회원가입을 하도록했으므로     
> "이미 존재하는 회원입니다." 라는 예외가 발생하는 것입니다.     
>         
> ![image](https://user-images.githubusercontent.com/66030601/200104898-5e204bdf-3b35-4104-8383-4915ed83a902.png)         
> DB의 데이터 완전히 지워주도록 하겠습니다.      
>        
> "운영하는 DB의 데이터를 너무 막지우는거 아닌가?" 라는 의문이 들 수도 있는데,     
> 실제로는 테스트 전용 DB를 따로 구축해서 테스트 전용 DB의 데이터를 지우기 때문에 너무 걱정하지 않아도 됩니다.      
>       
> 이 상태에서    
> _**@Transactional**_ 만 주석처리하고 다시 회원가입 테스트를 돌려보겠습니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/200105050-9c82abad-0e10-49ca-a3ed-6909dbee3c01.png)         
> 기존에 _**MemoryMemberRepository**_ 를 테스트 할 때와 다르게 테스트를 하는데 스프링이 올라왔습니다.      
> 그리고 _**@Configuration**_ 도 다 올라왔습니다.      
> 그리고 테스트가 끝나면 스프링이 내려갑니다.       
>      
> 회원 가입 테스트가 정상적으로 통과되었습니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/200105089-dc9888bd-b524-4947-8b84-81e40ff5bf8d.png)       
> DB를 확인해보면, spring이 정상적으로 저장되었습니다. (ID는 DB매커니즘에 의해 알아서 부여되므로 신경쓰지 말도록합시다.)     
>       
> 그런데, _**Test**_ 는 반복할 수 있어야 하는데, 이제 다시 실행하면,      
>        
> ![image](https://user-images.githubusercontent.com/66030601/200105119-1405b5d1-7116-4785-a2ff-f8e3f952a6f4.png)        
> 이렇게 오류가 발생합니다.      
>       
> DB에 "spring" 저장한게 남아있기 때문입니다.      
>      
> 그러면 또 전에 했던것 처럼 _**@AfterEach**_, _**@BeforeEach**_ 이런식으로 해줘야 하는 걸까요?      
>       
> _**@Transactional**_ 을 사용하면 해결할 수 있습니다.    
>       
> _**@Transactional**_ 은 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백 하도록하여      
> DB에 데이터를 남기지 않도록하여 다음 테스트에 영향을 주지 않게 해줍니다.       
>       
> 그런데, 지금은 _**@Transactional**_ 의 역할을 보기위해,  주석처리를 하고 테스트를 돌렸기 때문에 저러한 예외가 발생한 것입니다.     
>       
> DB에 인서트 쿼리를 날려도 커밋을 하기 전까지는 DB에 반영되지 않습니다.     
> 커밋을 자동으로 하는 오토커밋 모드로 설정할 수도 있지만,      
> 일반적으로는 DB에 인서트 쿼리를 날려도 커밋을 하지 않으면 DB에 반영되지 않습니다.       
>       
> _**@Transactional**_ 을 사용하면, 테스트(DB에 인서트 쿼리 날리고)를 끝내고 커밋이 아니라 롤백을 하는 것입니다.     
>      
> 그러면 DB에 인서트 쿼리를 날렸어도 롤백을 하면 DB에 인서트 쿼리 데이터가 반영되지 않습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200105871-66370218-c24e-42dd-bff3-1f5791d00566.png)         
> 우선, 한번은 다시 DB에 저장된 데이터를 지워주겠습니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/200105885-cbb011ef-2c3a-45e1-a92e-0e29be989711.png)         
> 그리고 _**@Transactional**_ 주석을 해제해주겠습니다.    
> 돌려보겠습니다.      
>         
> ![image](https://user-images.githubusercontent.com/66030601/200105907-4ea630e3-66a7-4e24-9cc7-bfdc62efe484.png)        
> 회원가입 테스트를 할때, 인서트 쿼리를 날려도, DB에는 반영하지 않고 롤백한 것을 확인할 수 있습니다.      
> 반복해서 테스트를 할 수 있습니다.     
>       
> 이번에는 전체를 테스트해보겠습니다.       
>        
> ![image](https://user-images.githubusercontent.com/66030601/200105931-bb670dc2-9109-4137-aea4-ad128d7bc77e.png)       
> 전체 테스트를 성공했습니다.      
>       
> 이렇게해서 통합테스트에 대해서 알아보았습니다.      
>        
> - _**@SpringBootTest**_ : 스프링 컨테이너와 테스트를 함께 실행합니다. 
> - _**@Transactional**_ : 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백합니다. 이렇게하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지 않습니다.      
>       
>
> ※ "그러면 통합테스트말고, 순수하게 자바코드로만 하는 단위테스트는 필요 없는 것 아닌가요?"     
> - 가급적이면 순수한 단위테스트가 훨씬 좋은 테스트일 확률이 높습니다. 왜냐하면 단위마다 쪼개서 테스트를 할 수 있기 때문입니다. 스프링 컨테이너 없이 테스트를 할 수 있도록 하면, 좋은 테스트를 할 수 있을 확률이 높습니다.
>
> ***         
>       
> ## [✅ 스프링 Jdbc Template](https://github.com/mgyokim/Spring/commit/b11b157933e846808b76425b5c0e75248eec5518)
> 이번에는 _**Jdbc Template**_ 를 사용해보겠습니다.     
> 설정은, 순수 _**Jdbc**_ 를 공부할 때 했던 것과 동일하게 환경설정 하면 됩니다.    
> ![image](https://user-images.githubusercontent.com/66030601/200117846-b1bf8179-4042-43e8-92ba-23c5916ed4fa.png)           
> _**build.gradle**_ 파일에 _**jdbc**_, _**h2 데이터베이스**_ 관련 라이브러리를 추가해주면 됩니다.    
> <pre><code>implementation 'org.springframework.boot:spring-boot-starter-jdbc'
>	runtimeOnly 'com.h2database:h2' </code></pre>       
> 이렇게 해주었습니다.    
>     
> 스프링 _**JdbcTemplate**_ 는 _**MyBatis**_ 와 비슷한 라이브러리인데,     
> _**JDBC API**_ 에서의 반복적인 코드를 대부분 제거해줍니다.   
> 하지만 _**SQL**_ 은 직접 작성 해야합니다.     
>        
> ![image](https://user-images.githubusercontent.com/66030601/200122999-3dc508c8-2c17-47bf-9188-e7c24d83f526.png)      
> 우선, _**JdbcTemplateMemberRepository**_ 라는 이름으로 클래스를 생성했습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200123049-50384ba1-862a-45be-b623-bc4ebe5eb8fe.png)       
> 그리고 _**implements MemberRepository**_ 를 했습니다.     
> 그후, _**MemberRepository**_ 의 메서드를 오버라이딩 했습니다.      
>      
> 이제 코드를 작성해보겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200123172-344b1212-3d9d-4317-9b1f-9c33980e9c34.png)       
> 먼저, _**JdbcTemplate**_ 이 있어야 합니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200123251-4edc6df1-fb56-4dab-ae78-6a3bf6214c0e.png)       
> 그리고 얘는 인젝션을 받을 수 없기 때문에 _**DataSource**_ 로 인젝션을 받아야 합니다.      
> 이렇게 작성해주면 됩니다.     
>     
> 그리고 참고로,      
> 생성자가 딱 1개만 있으면, 스프링빈으로 등록이 되기 때문에 _**@Autowired**_ 를 생략할 수 있습니다.      
>      
> 위의 코드처럼 작성하면,     
> 스프링이 _**DataSource**_ 를 자동으로 인젝션 해줍니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200123472-8fed05e8-ae6f-4382-9d4a-91869e34b5c1.png)         
> 이번에는 조회하는 쿼리를 먼저 작성해보겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200123492-2bd96f3d-ac71-46ad-836f-06806f1bd767.png)        
> <pre><code>SELECT * FROM MEMBER WHERE ID = ?</code></pre>       
> 의 결과가 나오는 것을 로우 매퍼라는 것으로 매핑을 해줘야 합니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200123611-8f70b432-1303-4575-8e24-f17b4551bccd.png)       
> _**JdbcTemplateMemberRepository**_ 밑에 이렇게 _**RowMapper**_ 를 작성했습니다.      
>       
> 그런데 이 코드를 람다로 바꿀 수 있습니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/200123642-82b672d8-fbbe-4f8d-8434-5129623181ee.png)       
> opt + enter 를 해서 _**Replace with lambda**_ 를 눌러주겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200123741-6038fc08-4980-4a8a-96e3-b68502f47a2c.png)       
> 이렇게 람다스타일로 바꿔주었습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200123766-2d8adb3a-aa8b-4a90-955f-05c5e6503078.png)      
> 이렇게 만든 _**memberRowMapper()**_ 를 앞서 만든 _**findById**_ 가 _**return**_ 할 _**result**_ 의 두번째 파라미터로 넣어줍니다.      
>       
> 그리고, _**result**_ 로 꺼내면 _**list**_ 로 나오는데,     
> _**return result.stream().findAny();**_ 를 해서 _**Optional**_ 로 반환합니다.       
>       
> 이 코드를 _**Jdbc**_ 랑 비교해보면,     
>      
> ![image](https://user-images.githubusercontent.com/66030601/200124008-8ff13be2-8718-42cf-a305-b520fd8d87f4.png)        
> 죄측처럼 엄청 길었던 코드를 _**jdbcTemplate**_ 를 사용해서 아주 줄이고 줄인 결과입니다.     
> _**jdbcTemplate**_ 라이브러리를 사용한 것입니다.      
>      
> 이번에는 _**save()**_ 를 작성해보겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200124100-581457a8-7ce0-4e01-b8ee-06271ba2e44e.png)      
> _**SimpleJdbcInsert**_ 라는 것을 사용하면, 쿼리를 짤 필요가 없습니다.     
> 테이블명 "_**member**_"과, _**primary key**_ 인 "_**id**_"와 "_**name**_"을 알고 있기 때문에 _**INSERT**_ 쿼리를 만들 수 있는데,     
> _**SimpleJdbcInsert**_ 로 인해서 자동으로 _**INSERT**_ 문이 만들어집니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200124178-dad82154-841f-4bb7-b570-d68f0e77abeb.png)       
> 그리고, _**excuteAndReturnKey**_ 에서 _**key**_ 를 받고,      
> 해당 _**key**_ 를 가지고 _**member**_ 에다가 _**setId**_ 해서 _**key.LongValue()**_ 를 넣어주도록 했습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200124911-67c0f51a-cd16-4a8e-91b5-1bfa7984e7df.png)       
> _**findByName**_ 같은 경우에는 _**findById**_ 에서 _**where**_ 를 _**name**_ 으로 바꿔주면 됩니다.     
>       
> ![image](https://user-images.githubusercontent.com/66030601/200124945-cf065e59-2528-41b9-a9a2-75f33bcc99f7.png)        
> _**findAll**_ 은 아주 간단합니다.      
> _**SELECT * FROM MEMBER WHERE NAME**_ 을 하고, _**memberRowMapper()**_ 를 해주면,     
> 객체 생성에 대한 것은 _**memberRowMapper()**_ 에서 콜백으로 정리가 됩니다.     
> 여기서 쭉 멤버가 생성되서 넘어옵니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/200125081-00ff263d-dbb3-4486-9761-4637ec5a0005.png)       
> 이렇게 작성을 완료했습니다.      
>      
> 이제 조립을 해줄 차례입니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/200125108-bcbb681e-07ba-4381-ab30-8c37a185510e.png)       
> _**SpringConfig**_ 에서    
> <pre><code>return new JdbcTemplateMemberRepository(dataSource);</code></pre>     
> 를 해주었습니다.     
>      
> 테스트를 해보겠습니다.     
>      
> 이전에, 스프링 통합테스트를 만들어 놓았었습니다.      
> 스프링 통합 테스트를 돌려보겠습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200125208-883ccd57-5850-4a4a-a3c9-cbdf8c6a33b5.png)       
> _**jdbcTemplate**_ 버전으로 바꾼,     
> 가입과 조회가 DB까지 연동되어 테스트가 성공적으로 통과되었습니다.      
>      
> 프로덕션이 커지면 테스트코드를 잘 짜는 것이 매우 중요해집니다.      
>      
> 작은 버그 하나가 기업에게는 정말 수십억원의 피해로 돌아올 수 있습니다.      
> 테스트 코드의 중요성을 인식하고 테스트 케이스, 코드를 잘 작성하도록 끊임없이 고민해야합니다.
>             
> ***           
>           
> ## [✅ JPA](https://github.com/mgyokim/Spring/commit/07d9353cbc1271af2d77ad30c825ff002278bd5a)
> 이전에 _**Jdbc**_ 를 해보고, _**JdbcTemplate**_ 를 써봤는데,   
> _**Jdbc**_ 에서 _**JdbcTemplate**_ 로 바꿔보니, 개발해야하는 반복적인 코드가 확 줄었던 경험을 해보았습니다.     
>       
> 그런데, 아직도 해결이 안되는 것이 하나 있습니다.      
>      
> "SQL은 결국 개발자가 직접 작성을 해야 한다는 것" 입니다.     
>    
> 이 문제를 해결할 수 없을까요?     
>      
> _**JPA**_ 라는 기술을 사용하면 _**SQL**_ 쿼리도 _**JPA**_ 가 자동으로 처리를 해줍니다.    
>      
> _**JPA**_ 를 사용하면 개발 생산성을 크게 높일 수 있습니다.     
> 마치 우리가 _**MemoryMemberRepository**_ 를 사용했던 것 처럼     
> 객체를 메모리에 넣듯이 _**JPA**_ 에 집어넣으면,     
> _**JPA**_ 가 중간에 DB에 _**SQL**_ 을 날리고, DB를 통해서 데이터를 가져오는 것을 처리해줍니다.      
>       
> _**JPA**_ 가 단순히 _**SQL**_ 을 만들어 주는 것을 넘어서서,     
> _**JPA**_ 를 사용하면, _**SQL**_ 보다 객체 중심으로 고민 할 수가 있게 됩니다.      
>       
> 즉, _**JPA**_ 를 사용하면, _**SQL**_ 과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환할 수 있습니다.     
> 그래서, _**JPA**_ 를 사용하면, 개발 생산성을 크게 높을 수 있습니다.     
>       
> ## JPA 
> 
> - _**JPA**_ 는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해줍니다.
> - _**JPA**_ 를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환 할 수 있습니다.
> - _**JPA**_ 를 사용하면 개발 생산성을 크게 높일 수 있습니다.      
>       
> 우선, _**JPA**_ 를 사용하려면 _**build.gradle**_ 파일에 _**JPA**_, _**H2**_ 데이터베이스 관련 라이브러리를 추가해야합니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/200160820-75f5e6b5-38fd-404b-a318-3e718d1edf16.png)      
> <pre><code>spring-boot-starter-data-jpa</code></pre>     
> 이것에는 내부에 _**jdbc**_ 관련 라이브러리를 포함합니다.   
> 따라서 기존에 작성해둔 _**jdbc**_ 라이브러리는 제거 해도됩니다.     
>      
> 그리고 이번에는 스프링 부트에 _**JPA**_ 설정을 추가 해줘야합니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/200160878-da25ca0a-fb95-4d00-a7d4-99c815648abb.png)       
> <pre><code>spring.jpa.show-sql=true</code></pre>      
> - _**show-sql**_ : 이렇게 true로 하면 JPA가 날리는 SQL을 볼 수가 있습니다.     
>    
> <pre><code>spring.jpa.hibernate.ddl-auto=none</code></pre>     
> - _**ddl-auto**_ : jpa를 사용하면 객체를 보고 jpa가 테이블도 다 만들어줍니다.        
>            
> 그런데, 우리는 이미 테이블을 만들어놓았고, 만들어진것을 사용할 것이기 때문에, 자동으로 테이블을 생성해주는 기능은 _**none**_ 으로 끄고 시작하도록 하겠습니다.(_**create**_ 로 하면 자동생성)      
>         
> _**build.gradle**_ reload 로 라이브러리 로딩이 끝나면,      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200161449-debeb8be-da31-4915-b067-693b8430abd9.png)       
> ![image](https://user-images.githubusercontent.com/66030601/200161461-8af34416-de1e-4b18-bcb9-5d4c7c10a893.png)       
> _**jpa**_ 라이브러리와 _**hibernate**_ 라이브러리가 로딩이 되어있어야 합니다.      
>      
> _**JPA**_ 라는 것은 인터페이스입니다.     
> 구현체로 _**hibernate**_ 등의 구현 기술이 있는 것입니다.      
>       
> 그중에서 우리는 거의 _**JPA**_ 인터페이스와 _**hibernate**_ 만 쓴다고 보면 됩니다.     
>      
> _**JPA**_ 라는 것은 _**Java**_ 진영의 표준 인터페이스입니다.      
>      
> 구현은 여러 업체들이 하는 것입니다.     
> 각 업체마다 성능이 더 좋거나, 쓰기 편하거나 등의 장단점이 있는 것입니다.      
>      
> _**JPA**_ 는 객체와 _**ORM**_ 이라는 기술로 정의할 수 있습니다.      
> O는 _**Object**_, R은 _**Relational**_, M은 _**Mapping**_ 입니다.      
>      
> 즉, 객체와 관계형 데이터베이스의 테이블을 매핑한다는 뜻입니다.     
> 그래서, _**JPA**_ 를 사용하려면 먼저 엔티티라는 것을 매핑 해야합니다.     
> 매핑은 어노테이션으로 합니다.      
>      
> _**Member**_ 클래스에 작성해보겠습니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/200161563-5c514e04-8e79-4a70-89b5-e1237d3762f8.png)       
> _**@Entity**_ 라고 적어주면,   
> "아! 이제 이것은 _**JPA**_ 가 관리하는 엔티티구나!" 가 되는 것입니다.       
> 즉, _**@Entity**_ 를 달아서 엔티티라고 알려주는 것입니다.      
>      
> 그리고 _**Primary Key**_ 도 매핑해줘야하는데,      
>      
> 아래 DB를 살펴봅시다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/200161605-c9be4def-799a-426a-aa57-cdd97667fe87.png)      
> DB에 데이터를 저장하면 ID가 generate 됩니다.     
> 쿼리를 잘 보면, 쿼리에 id를 넣는 것이 아니라,   
> DB에 값을 넣으면, DB가 ID를 자동으로 생성해 주는 것을 뭐라고 하냐면, "Identity 전략" 이라고 합니다.      
>        
> ![image](https://user-images.githubusercontent.com/66030601/200161825-c874b016-cc65-494d-bbb8-8ffe2e7412ed.png)       
> 그래서, 이렇게      
> <pre><code>@Id @GeneratedValue(strategy = GenerationType.IDENTITY)</code></pre>        
> 라고 해줘야 합니다.     
>      
> 이렇게 DB가 알아서 생성해 주는 것은 IDENTITY 라고 합니다.     
>       
> ![image](https://user-images.githubusercontent.com/66030601/200161897-de21984c-32e9-440f-964c-06a0086e4d6a.png)       
> 지금은 name이 컬럼명도 name이라서 그대로 하면 되지만,      
>      
> ![image](https://user-images.githubusercontent.com/66030601/200161911-587c30d2-dc9a-4f0c-b625-ce5848626420.png)       
> 만약에 DB의 컬럼명이 username이면, _**@Column(name="username")**_ 이렇게 해주면 매핑됩니다.     
>      
> 이렇게 애너테이션을 가지고 데이터베이스와 매핑을 하는 것입니다.     
> 이렇게 해놓으면, 이제 이 정보들을 가지고 _**sql**_ 쿼리문을 만들 수 있는 것입니다.    
> _**JPA**_ 가 이러한 방식으로 동작하는 것입니다.      
>      
> 이제 _**JPA**_ 로 _**Repository**_ 를 만들어보겠습니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/200162030-c9c289a8-c20a-49cd-8bb6-9d11afe3add6.png)       
> ![image](https://user-images.githubusercontent.com/66030601/200162035-942950ce-7fc9-4edc-a7af-f9a6e60c16fb.png)       
> _**JpaMemberRepository**_ 라는 이름으로 클래스를 만들고,     
> _**MemberRepository**_ 를 _**implements**_ 했습니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200162148-b9636bbe-b62f-4b37-8866-c4d344a37c59.png)       
> <pre><code>private final EntityManager em;</code></pre>     
> 를 입력하고 Constructor Method 를 해주었습니다.     
>   
> _**JPA**_ 는 _**EntityManager**_ 라는 것으로 모든게 동작합니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200162202-bae12ce0-7fa8-409a-87cc-0909e4b14aa3.png)       
> 아까전에 _**build.gradle**_ 에서 _**data-jpa**_ 라이브러리를 받았는데, 그렇게 하면, _**properties**_ 정보등을 전부 취합하여 스프링 부트가 자동을 _**EntityManager**_ 를 생성해줍니다.     
>       
> 현재 DB랑 연결까지 전부 해서 _**EntityManager**_ 를 생성해줍니다.      
>      
> 그래서 우리는 만들어진 _**EntityManager**_ 를 _**Injection**_ 받으면 됩니다.     
>     
> 즉, _**JPA**_ 를 사용하려면,     
> _**EntityManager**_ 라는 것을 인젝션 받아야 한다는 것 입니다.      
>       
> ![image](https://user-images.githubusercontent.com/66030601/200162294-1b221f62-e26e-4818-9489-49cf4e6681b2.png)      
> _**save**_ 를 구현해보겠습니다.     
>       
> _**EntityManager**_ 를 줄여서 _**em**_ 이라고 많이 사용하는데,      
> <pre><code>em.persist(member);</code></pre>        
> 를 해줍니다. _**persist**_ 가 영속하다, 영구저장하다라는 뜻입니다.    
> 안에는 _**member**_ 를 넣고, _**return member**_ 를 해줍니다.    
>      
> 이렇게만 하면 _**save()**_ 가 끝납니다.     
>      
> _**JPA**_ 가 _**Insert쿼리**_ 를 다 만들어서 DB에 집어넣고,    
> _**ID**_ 까지 _**member**_ 에다 _**setId**_ 까지 해줍니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/200162485-4cebfdaa-07cf-490b-bbb7-251ce3de33ca.png)      
> 이번에는 _**findById**_ 를 구현해보겠습니다.    
>      
> <pre><code>em.find(Member.class, id)</code></pre>      
> _**em.find**_ 라고 있는데, 매개변수로는 조회할 타입과, 식별자 Primary Key 만 넣어주면 조회가 됩니다.   
> 그러면 _**SELECT**_ 문이 나가는 것 입니다.     
> 그런데 _**return**_ 을 해야 하는데,     
> _**Optional**_ 로 반환을 하기 때문에 값이 없을 수도 있기 때문에      
> <pre><code>return Optional.ofNullable(member);</code></pre>        
> 이렇게 작성합니다.       
>       
> 이번에는 _**findAll**_ 을 작성해보겠습니다.     
> 앞서 작성한, _**findId**_ 는 ***id*** 가 _**Primary Key**_ 였습니다.     
>      
> _**name**_ 은 _**pk**_ 가 아닙니다. 따라서      
> _**findAll**_ 과 _**findByName**_ 를 작성할 때는 조금 다르게 작성합니다.       
>      
> ![image](https://user-images.githubusercontent.com/66030601/200162782-f8a7f9aa-264b-4894-ae55-766d7d90352b.png)       
> 이 두 위치의 값이 같으면, inline(cmd + opt + n) 사용할 수 있습니다.      
>      
> ![image](https://user-images.githubusercontent.com/66030601/200162802-9337c781-d60e-4e13-a7b4-88eabd32e0fa.png)     
> (맥 기준으로 ctrl + t 로 검색할 수도 있습니다.)     
>      
> ![image](https://user-images.githubusercontent.com/66030601/200162827-7d7c0d17-3f06-4746-9b1e-2169fef1ce03.png)     
> inline을 사용하면 이렇게 바뀝니다.     
>   
> 어쨋든, 위 코드가 _**jpql**_ 이라는 쿼리언어인데,   
> 우리가 보통 테이블을 대상으로 sql을 날리는데,   
> _**jpql**_ 은 테이블 대상이 아니라, 객체를 대상으로 _**sql**_ 을 날리는 것입니다.     
> 정확하게는 _**Entity**_ 를 대상으로 쿼리를 날리는 것 입니다.     
>       
> <pre><code>return em.createQuery("select m from Member m", Member.class)
>          .getResultList();</code></pre>         
> "***MemberEntity***를 조회해!" 라고 하는데,      
> _**select**_ 의 대상이 _**m**_ 입니다.     
>      
> 원래 _**SQL**_ 이면, * 이라고 하거나, _**mi.id**_, _**m.name**_ 으로 할텐데 말입니다.      
>      
> <pre><code>return em.createQuery("select m from Member m", Member.class)
>           .getResultList();</code></pre>      
> _**jpql**_ 이 적용된 이 코드에서는    
> _**m**_ 엔티티 객체 자체를 _**select**_ 하는 것입니다.    
> 이렇게 해서 조회를 하게 됩니다.    
>       
> 이번에는 _**findByName**_ 을 작성해보겠습니다.       
> ![image](https://user-images.githubusercontent.com/66030601/200163592-c7ac8e18-c15b-4ae0-a339-45a094ac01f1.png)
> <pre><code>List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
>        .setParameter("name", name)
>        .getResultList();</code></pre>
> _**findByName**_ 도 _**jpql**_ 이라는 것을 짜야합니다.     
> 지금은 _**Member.class**_ 로 조회 해야합니다.     
> 그리고, _**findByName**_ 의 결과를 1개만 찾는다고 했으므로,      
> _**stream**_ 을 사용해서 반환하면 됩니다.   
>      
> 단건을 찍어서 찾는.. 예를 들면, 저장하고, 조회하고 업데이트 하는 것은 _**sql**_ 을 짤 필요가 없는데,     
>     
> _**findByName**_ 이나, _**findAll**_ 처럼     
> 여러개의 리스트를 가지고 돌릴 때는, _**PrimaryKey**_ 기반이 아닌 나머지들은 _**jpql**_ 이라는 것을 작성해줘야합니다.      
>     
> ![image](https://user-images.githubusercontent.com/66030601/200163875-8bd5c5ea-05a9-49cb-87aa-316e90efb000.png)     
> 그리고, _**JPA**_ 를 사용하려면 항상 트랜잭션이 있어야합니다. (JPA로 데이터를 저장하거나 변경하려면...)    
>     
> 그래서 _**MemberService**_ 계층에 _**@Transactional**_ 을 작성해줘야 합니다.   
> _**org.springframework.transaction.annotation.Transactional**_ 를 사용하면 됩니다.     
> 스프링은 해당 클래스의 메서드를 실행할 때 트랜잭션을 시작하고, 메서드가 정상 종료되면 트랜잭션을 커밋합니다.     
> 만약 런타임 예외가 발생하면 롤백합니다.     
> _**JPA**_ 를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 합니다.     
>      
> 이제 _**JPA**_ 를 사용하도록 스프링 설정을 변경하겠습니다.     
>      
> ![image](https://user-images.githubusercontent.com/66030601/200164003-d0939a95-c7ac-4c84-90e1-4634abecfa68.png)      
> 원래 스펙에서는    
> ![image](https://user-images.githubusercontent.com/66030601/200164019-f39a4729-c20d-4248-8182-3616903b96c5.png)      
> _**@PersistenceContext**_ 를 이렇게 받아야 하는데,    
> <pre><code>private EntityManager em;
>
> @Autowired
> public SpringConfig(EntityManager em) {
> this.em = em;
> }</code></pre>     
> 스프링에서는 이렇게 작성해도 _**DI**_ 를 해줍니다.      
>       
> 자! 이제 돌려보겠습니다.     
> ![image](https://user-images.githubusercontent.com/66030601/200164111-fc7aa5ad-0b4a-4774-9cbc-2e5cc7cf4c90.png)       
> 전에 만들어둔 스프링 통합테스트를 돌려보겠습니다.      
>       
> 테스트에 통과했습니다.       
>     
> ![image](https://user-images.githubusercontent.com/66030601/200164133-63b2a621-0d9d-4681-ad91-8d1cb3236a86.png)      
> 로그를 보면, _**JPA**_ 는 인터페이스고, 쿼리가 _**Hibernate**_ 구현체가 사용된 것을 볼 수 있습니다.     
> 결국 DB에는 _**SQL**_ 이 나가야 하는 것입니다.      
>     
> ※ 참고      
> _**JPA**_ 기술을 스프링에 담아서 감싸서 제공하는 기술이 있습니다.     
> 그것이 바로 _**SpringDataJPA**_ 기술입니다.     
>     
> _**SpringDataJPA**_ 를 사용하면, _**findByName**_ 이나 _**findAll**_ 같이 _**PrimaryKey**_ 기반이 아닌 것들도 _**jpql**_ 쿼리를 작성하지 않아도 됩니다.     
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