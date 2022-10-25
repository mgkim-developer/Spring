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

#### 스프링 웹 개발 기초 
- 정적 컨텐츠 
- MVC와 템플릿 엔진 
- API
#### 회원 관리 예제 - 백엔드 개발
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

## 프로젝트 환경설정
>  ##[✅ 프로젝트 생성](https://github.com/mgyokim/Spring/commit/d4b13f2cc5ffe0b0c397dcaeac00ef40017517b9)
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
>---
>  ##[✅ View 환경설정](https://github.com/mgyokim/Spring/commit/ad758650cbec3fd7e1e257e24606916804214d4c)
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
> ---
> > ## ✅ 빌드하고 실행하기
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




## --------------------------------------------------------
--- 
위의 목차순으로
마지막에 느낀점 

기술 발전의 맥락을 이해하고, 기술의 주인의식을 갖고,