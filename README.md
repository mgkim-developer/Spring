# Spring
### Repository Information       
> ---
> ## [Spring-intro](https://github.com/mgyokim/Spring/tree/main/Spring-intro)
> 
> Spring_intro 레포지토리의 목표는,  
> 가장 기본적인 기능들을 살펴보고 코드를 직접 작성하고 돌려보면서,    
> 웹 애플리케이션을 개발할 때 어떤 기술들이 어떻게 사용되는지,     
> 스프링 개발의 전반적인 감을 잡고 큰 그림을 머릿속에 그리는 것 이었습니다.
>
> 일단 가장 쉬운 예제로 스프링 웹 애플리케이션을 만드는 핵심 사이클을 돌려보았습니다.
>
> - 프로젝트 환경설정
> - 스프링 웹 개발 기초
> - 회원 관리 예제 - 백엔드 개발
> - 스프링 빈과 의존관계
> - 회원 관리 예제 - 웹 MVC 개발
> - 스프링 DB 접근 기술
> - AOP
>
> 이 과정들을 진행하며, 자연스럽게 큰 그림이 그려지고, 앞으로 어떤 부분을 깊이있게 학습해야 하는지 파악했습니다.
>
> 특히, DI를 할때, 처음부터 스프링에서 제공하는 기능을 바로 적용해보는 것이 아니라,      
> 가장 low level의 DI 구현을 해보고, 이러한 방식의 DI를 사용함으로서 생기는 문제점(같은 클래스의 인스턴스 객체가 여러개 생성되는 문제 등)을 생각해보고,     
> 해당 문제점을 개선시키기 위해서 현재 스프링에서 제공하는 DI 기능(스프링빈 등록방식) 를 적용하는 방식으로 공부를 하였습니다.
>
> 이렇게 점진적인 기술발전의 맥락을 최대한 이해하려고 노력하다보니,    
> 스프링을 사용할 때, 스프링에서 제공하는 DI 기능의 필요성을 알고 사용할 수 있게 되었습니다.
>
> 그리고, 스프링 DB접근 기술에서 최종적으로 스프링 데이터 JPA를 사용하기전에,     
> 순수 Jdbc -> JdbcTemplate -> JPA -> 스프링 데이터 JPA           
> 이러한 과정으로 점진적으로 발전시켜나가며 구현을 해보았습니다.
>
> 이렇게 점진적으로 기술의 발전과정을 이해하려고 노력하다보니,    
> SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임이 전환됨으로 인해      
> 개발 생산성이 크게 높일 수 있다는 것을 이해하게 되었습니다.
> 
> 앞으로 추가적으로 거대한 스프링을 공부하며, 이러한 공부방식으로 학습해야겠습니다.
>
> ---


> ---
> ## [Spring-Basic](https://github.com/mgyokim/Spring/tree/main/Spring-basic)
> Spring_Basic 레포지토리의 목표는,    
스프링이 왜 만들어졌고, 왜 필요한지, 그리고 객체 지향 설계와 스프링이 왜 땔 수 없는 관계인지 이해하는 것 이었습니다.
>
> 스프링이 없던 20년 전으로 돌아가서 스프링이 왜 만들어졌는지 그 이유부터 시작했습니다.   
> 그리고 실제 그때로 돌아가서 스프링이 없는 순수한 자바 코드로 예제 애플리케이션을 만들었습니다.
>
> 요구사항이 변경 됨에 따라 문제점들이 하나씩 발견되고,    
> 그 문제를 해결하기 위해 좋은 객체 지향 원리들을 하나씩 코드에 적용하면서 문제를 해결해나갔습니다.
>
> 이 과정속에서 자연스럽게 코드를 통해, 객체 지향의 원리(SOLID)와 IoC, DI에 대해서 이해하고, 또 스프링 컨테이너가 왜 필요한지 알게되었습니다.
>
> - 객체 지향 설계와 스프링
> - 스프링 핵심 원리 이해1 - 예제 만들기
> - 스프링 핵심 원리 이해2 - 객체 지향 원리 적용
> - 스프링 컨테이너와 스프링 빈
> - 싱글톤 컨테이너
> - 컴포넌트 스캔
> - 의존관계 자동 주입
> - 빈 생명주기 콜백
> - 빈 스코프
>
> 처음에는, 스프링을 이용하지 않고, 순수한 자바로만 개발을 진행했습니다.
>
> 요구사항에 따른 할인 정책을 개발하는 과정에서 문제가 발생했습니다.
>
> 순수 자바로만 개발을 해보니, 주문 클래스가 2개의 구체클래스를 가진 할인 인터페이스에만 의존해야 하는데, 특정 구체 클래스에도 의존하는 것을 확인했습니다.
>
> 만약, 서비스 요구사항이 변경되어, 할인 정책을 변경해야 하면, 주문 클래스의 소스코드도 변경해야 하는 문제가 발생할 것으로 예상되었습니다.
>
> 이것은, DIP위반, OCP위반입니다.
>
> DIP위반과 OCP위반 문제를 해결하기 위해 인터페이스에만 의존하도록 설계를 변경했습니다.
>
> 그런데, 문제가 있었습니다.   
> 인터페이스에만 의존하니, 구현체가 없어서 코드를 실행할 수 없었습니다. Null Pointer Exception이 발생하는 문제가 있었습니다.
>
>
> 이 문제를 해결하기 위해, AppConfig를 도입해 보고, 스프링으로 전환하는 등의 과정을 수행했습니다.
>
> 스프링이 왜 만들어졌고, 왜 필요한지, 그리고 객체 지향 설계와 스프링이 왜 땔 수 없는 관계인지 이해했습니다.      
> 스프링의 핵심 원리와 핵심 콘셉트를 제대로 학습했기 때문에 스프링 웹 MVC, 스프링 데이터 접근 기술, 스프링 부트를 포함해서 스프링의 핵심 기술을 활용하는 수많은 스프링 기술들을 배우고 사용할 때도,   
> 단순한 기능 사용을 넘어서 깊이 있는 이해가 가능할 것이라는 자신감이 있습니다.         
>        
> ---
         
> ---
> ## [Spring-MVC1](https://github.com/mgyokim/Spring/tree/main/Spring-MVC1)
> Spring_MVC1 레포지토리의 목표는,    
> 스프링 없이 직접 스프링 MVC의 핵심 기능을 만들어보는 과정을 통해   
> 스프링 MVC의 내부 구조가 왜 이렇게 설계되었는지 깊이있게 이해하는 것 이었습니다.
>
> 자바 웹 기술의 기초라 할 수 있는 서블릿부터 시작해서 JSP, MVC패턴, MVC 프레임워크,
> 그리고 스프링 MVC의 탄생부터 실무에서 주로 사용하는 스프링 MVC의 사용법까지,
> 모든 것을 코드로 만들어보면서 단계적으로 알아보았습니다.      
> - 웹 애플리케이션 이해
> - 서블릿
> - 서블릿, JSP, MVC 패턴
> - MVC 프레임워크 만들기
> - 스프링 MVC - 구조 이해
> - 스프링 MVC - 기본 기능
> - 스프링 MVC - 웹 페이지 만들기
>> #### 직접 만든 MVC 프레임워크 구조 vs SpringMVC 구조
>> ![image](https://user-images.githubusercontent.com/66030601/228139871-2287025a-3f0f-48d0-9c67-431a4d598802.png)   
>> 직접 만든 프레임워크 → 스프링 MVC 비교
>> - FrontController → DispatcherServlet
>> - handlerMappingMap → HandlerMapping
>> - MyHandlerAdapter → HandlerAdapter
>> - ModelView → ModelAndView
>> - viewResolver → ViewResolver
>> - MyView → View
>>
>> #### DispatcherServlet 구조 살펴보기
>> <code>org.springframework.web.servlet.DispatcherServlet</code>    
>> 스프링 MVC도 프론트 컨트롤러 패턴으로 구현되어 있습니다.   
>> 스프링 MVC의 프론트 컨트롤러가 바로 디스패처 서블릿(DispatcherServlet)입니다.   
>> 그리고 이 디스패처 서블릿이 바로 스프링 MVC의 핵심입니다.  
>>
>> #### DispatcherSevlet 서블릿 등록
>> - DispatcherServlet 도 부모 클래스에서 HttpServlet을 상속 받아서 사용하고, 서블릿으로 동작합니다.
     >>  - DispatcherServlet → FrameworkServlet → HttpServletBean → HttpServlet
>> - 스프링 부트는 DispatcherServlet을 서블릿으로 자동 등록하면서 모든 경로(urlPatterns="/")에 대해서 매핑합니다.
     >>  - 참고 : 더 자세한 경로가 우선순위가 높습니다. 그래서 기존에 등록한 서블릿도 함께 동작합니다.
>>
>> #### 요청 흐름
>> - 서블릿이 호출되면 HttpServlet이 제공하는 service()가 호출됩니다.
>> - 스프링 MVC는 DispatcherServlet의 부모인 FrameworkServlet에서 service()를 오버라이드 해두었습니다.
>> - FrameworkServlet.service()를 시작으로 여러 메서드가 호출되면서 DispatcherServlet.doDispatch()가 호출됩니다.      
>> 
>> 이번에는 DispatcherServlet의 핵심인 doDispatch() 코드를 분석 해보겠습니다.     
>> 최대한 간단하게 정리하기 위해 예외처리, 인터셉터 기능은 제외했습니다.
>> #### DispatcherServlet.doDispatch()
>> ![image](https://user-images.githubusercontent.com/66030601/228140468-f00dbd34-1dce-47e2-b213-1827a0dc1955.png)   
>> ![image](https://user-images.githubusercontent.com/66030601/228140512-fec62eda-bed3-41a3-9f13-204c12f1827a.png)
>
>> #### SpringMVC 구조
>> ![image](https://user-images.githubusercontent.com/66030601/228140564-fe8e75ee-946b-47b0-9595-51f27925005c.png)      
>> 동작 순서
>> 1. 핸들러 조회 : 핸들러 매핑을 통해 요청 URL에 매핑된 핸들러(컨트롤러)를 조회한다.
>> 2. 핸들러 어댑터 조회 : 핸들러를 실행할 수 있는 핸들러 어댑터를 조회한다.
>> 3. 핸들러 어댑터 실행 : 핸들러 어댑터를 실행한다.
>> 4. 핸들러 실행 : 핸들러 어댑터가 실제 핸들러를 실행한다.
>> 5. ModelAndView 반환 : 핸들러 어댑터는 핸들러가 반환하는 정보를 ModelAndView로 변환해서 반환한다.
>> 6. viewResolver 호출 : 뷰 리졸버를 찾고 실행한다.
      >>   1. JSP의 경우 : InternalResourceViewResolver가 자동 등록되고, 사용된다.
>> 7. View 반환 : 뷰 리졸버는 뷰의 논리 이름을 물리 이름으로 바꾸고, 랜더링 역할을 담당하는 뷰 객체를 반환한다.
      >>   1. JSP의 경우 InternalResourceView(JslView)를 반환하는데, 내부에 forward() 로직이 있다.
>> 8. 뷰 랜더링 : 뷰를 통해서 뷰를 랜더링 한다.
>>
>> 스프링 MVC의 큰 강점은 DispatcherServlet 코드의 변경 없이, 원하는 기능을 변경하거나 확장할 수 있다는 점입니다.    
>> 지금까지 알아본 대부분의 것들을 확장 가능할 수 있도록 인터페이스로 제공합니다.   
>> 이 인터페이스들만 구현해서 DispatcherServlet에 등록하면 우리들만의 컨트롤러를 만들 수도 있습니다.
>>
>>  #### 주요 인터페이스 목록
>> 핸들러 매핑: <code>org.springframework.web.servlet.HandlerMapping</code>     
>> 핸들러 어댑터: <code>org.springframework.web.servlet.HandlerAdapter</code>      
>> 뷰 리졸버: <code>org.springframework.web.servlet.ViewResolver</code>        
>> 뷰: <code>org.springframework.web.servlet.View</code>
> 
>>
>> #### RequestMappingHandlerAdapter 동작 방식
>> <img width="913" alt="image" src="https://user-images.githubusercontent.com/66030601/228176492-cda7850d-0f5a-4cac-987d-e564cc7e299c.png">       
>>
>> #### ArgumentResolver
>> 애노테이션 기반의 컨트롤러는 매우 다양한 파라미터를 사용할 수 있습니다.    
>> <code>HttpServlet</code> , <code>Model</code>은 물론이고, <code>@RequestParam</code>, <code>@ModelAttribute</code> 같은 애노테이션, 그리고 <code>@RequestBody</code>, <code>HttpEntity</code> 같은 HTTP 메시지를 처리하는 부분까지 매우 큰 유연합니다.    
>> 이렇게 파라미터를 유연하게 처리할 수 있는 이유가 바로 <code>ArgumentResolver</code> 덕분입니다.
>>
>> 애노테이션 기반 컨트롤러를 처리하는 <code>RequestMappingHandlerAdapter</code>는 바로 이 <code>ArgumentResolver</code>를 호출해서 컨트롤러(핸들러)가 필요로 하는 다양한 파라미터의 값(객체)을 생성합니다.    
>> 그리고 파라미터의 값이 모두 준비되면 컨트롤러를 호출하면서 값을 넘겨줍니다.
>>
>> ※ 가능한 파라미터 목록은 다음 [공식 메뉴얼](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-arguments) 에서 확인 할 수 있습니다
>>
>> 정확히는 <code>HandlerMethodArgumentResolver</code>인데 줄여서 <code>ArgumentResolver</code>라고 부릅니다.
>>
>> #### <code>ArgumentResolver</code>의 동작 방식을 살펴보도록 하겠습니다.
>> <code>ArgumentResolver</code>의 <code>supportsParameter()</code>를 호출해서 해당 파라미터를 지원하는지 체크하고, 지원하면 <code>resolveArgument()</code>를 호출해서 실제 객체를 생성합니다.      
>> 그리고, ,원한다면 직접 이 인터페이스를 확장해서 원하는 <code>ArgumentResolver</code>를 만들 수도 있습니다.
>>
>> #### ReturnValueHanlder
>> <code>HandlerMethodReturnValueHandler</code>를 줄여서 <code>ReturnValueHandler</code>라 부릅니다.    
>> <code>ArgumentResolver</code>와 비슷한데, 이것은 응답 값을 변환하고 처리합니다.
>>
>> 컨트롤레엇 String으로 뷰 이름을 반환해도, 동작하는 이유가 바로 ReturnValueHandler 덕분입니다.
>>
>> ※ 가능한 응답 값 목록은 다음 [공식 메뉴얼](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-ann-return-types) 에서 확인 할 수 있습니다.
>
>> #### HTTP 메시지 컨버터
>> #### HTTP 메시지 컨버터 위치
>> <img width="912" alt="image" src="https://user-images.githubusercontent.com/66030601/228183941-583f8b92-2425-4dc2-9b74-7b91652fd609.png">      
>>
>> HTTP 메시지 컨버터는 어디에 있을까요?   
>> 그림에서 볼 수 있듯이,
>> #### 요청의 경우,
>> <code>@RequestBody</code>를 처리하는 <code>ArgumentResolver</code>가 있고, <code>HttpEntity</code>를 처리하는 <code>ArgumentResolver</code>가 있습니다.    
>> 이 <code>ArgumentResolver</code>들이 HTTP 메시지 컨버트를 사용해서 필요한 객체를 생성하는 것입니다.
>>
>> #### 응답의 경우,
>> <code>@ResponseBody</code>와 <code>HttpEntity</code>를 처리하는 <code>ReturnValueHandler</code>가 있습니다.      
>> 그리고 여기에서 HTTP 메시지 컨버터를 호출해서 응답 결과를 만듭니다.
>>
>> 스프링 MVC는 <code>@RequestBody</code>, <code>@ResponseBody</code>가 있으면 <code>RequestResponseBodyMethodProcessor(ArgumentResolver)</code>,    
> <code>HttpEntityMethodProcessor(ArgumentResolver)</code>를 사용합니다.
>>
>> #### 확장
>> 스프링은 다음을 모두 인터페이스로 제공합니다. 따라서 필요하면 언제든지 기능을 확장할 수 있습니다.
>> - <code>HandlerMethodArgumentResolver</code>
>> - <code>HandlerMethodReturnValueHandler</code>
>> - <code>HttpMessageConverter</code>
>>
>> 스프링이 필요한 대부분의 기능을 제공하기 때문에 실제 기능을 확장할 일이 많지는 않습니다. 기능 확장은 <code>WebMvcConfigurer</code>를 상속받아서 스프링 빈으로 등록하면 됩니다.   
>> 실제 자주 사용하지는 않으니 실제 기능 확장이 필요할 때 <code>WebMvcConfigurer</code>를 검색해보면 됩니다.
>
>       
> 스프링을 이용해서 웹 어플리케이션을 개발하려면, 스프링 MVC의 핵심 구조를 제대로 파악해야 합니다.
>
> 그런데 스프링 MVC에는 수 많은 기능들이 자동화되고, 추상화되어 있기 떄문에 핵심 구조를 파악하기가 쉽지 않습니다.
>
> 그래서, 스프링 없이 직접 스프링 MVC의 핵심 기능을 만들어 보았습니다.    
> 단순히 머리로 MVC 프레임워크를 이해하는 것이 아니라, 완전히 처음부터 MVC 프레임워크를 새로 개발했습니다.
>
> 그리고 단계적으로 MVC 프레임워크를 발전시켜 나가는 과정을 통해 자연스럽게 스프링 MVC의 내부 구조가 왜 이렇게 설계되었는지 깊이있게 이해할 수 있었습니다.       
> 스프링 MVC는 전 세계 수 많은 개발자들의 요구사항에 맞추어 기능을 계속 확장해왔습니다. 그래서, 대부분의 기능이 이미 다 구현되어 있습니다.    
> 그래도, 이렇게 핵심 동작 방식을 알아두어야, 향후 문제가 발생했을 때 어떤 부분에서 문제가 발생했는지 쉽게 파악하고, 문제를 해결할 수 있습니다.  
> 그리고 확장 포인트가 필요할 때, 어떤 부분을 확장해야 할지 감을 잡을 수 있습니다.      
>         
> ---

> ---
> ## [Spring-MVC2](https://github.com/mgyokim/Spring/tree/main/Spring-MVC2)
> Spring_MVC2 레포지토리의 목표는,   
> Spring_MVC1에서 학습한 스프링 MVC의 기반 위에,
> - 뷰 템플릿(타임리프)
> - 메시지
> - 국제화
> - 검증
> - 쿠키
> - 세션
> - 필터
> - 인터셉터
> - 예외처리
> - 타입 컨버터
> - 파일업로드
>
> 위와 같은 실무에 꼭 필요한 방대한 웹 활용 기술을 예제를 통해 공부하는 것 이었습니다.       
> 
> 단지 구현에 집중하는 것이 아니라, 각 기술들을 가장 LowLevel의 코드로 작성 해보고, 개발자가 사용하기 편하도록 추가된 기능들을 도입하며 실무에서 사용하는 방식으로 리팩토링 하는 방식으로 진행 했습니다.
>
> 스프링 MVC의 다양한 활용 기술을 학습했습니다.
>
>> #### 타임리프
>> ![image](https://user-images.githubusercontent.com/66030601/229275801-17d4cfc3-3333-4bdb-8bd4-de0118311a0f.png)
>> 타임리프(Thymeleaf)는 백엔드 개발자를 위한 서버 사이드 뷰(Server-Side View) 템플릿 입니다.   
> 타임리프를 사용하면 백엔드 개발자 만으로 쉽고 빠르게 동적인 HTML을 만들 수 있습니다.
>>
>> 타임리프의 기본 기능부터, 스프링과 통합, 체크 박스, 라디오 버튼, 셀렉트 박스, 템플릿 조각, 템플릿 레이아웃 기능까지 예제를 통해 만들어가며 학습했습니다.
>>
>
>> #### 메시지, 국제화
>> ![image](https://user-images.githubusercontent.com/66030601/229276113-dba4e3eb-9b5b-497c-bb68-fb2ef33f0e41.png)
>> 웹 애플리케이션이 크고 복잡해질수록, 다양한 메시지들을 일관성 있게 한 곳에서 관리해야 합니다.   
>> 예를 들어 "상품명"이라는 단어를 "상품 이름" 이라는 단어로 고치려면 수많은 파일의 소스코드를 수정해야 합니다.   
>> 스프링이 제공하는 메시지 기능을 사용하면 이런 것을 한번에 관리하고 수정할 수 있습니다.
>>
>> 국제화는 영어를 사용하는 사람에게는 사이트가 영어로 나오고, 한국어를 사용하는 사람에게는 사이트가 한국어로 나오는 기능입니다.   
>> 스프링은 이러한 국제화 기능을 제공합니다.    
>> 스프링이 제공하는 메시지와 국제화 기능을 실제 예제를 통해 단계적으로 학습했습니다.
>>
>
>>  #### 검증(Validation)
>> ![image](https://user-images.githubusercontent.com/66030601/229276765-bf1f0e56-e402-457c-b416-7b3cbb642199.png)    
>> 고객이 회원 가입을 할 떄 입력 폼에 잘못된 값을 입력해서 서버에 전송한다면, 서버는 그 값을 검증하고 고객에게 다시 입력폼을 보여주면서 어떤 부분이 잘못 입력되었는지 친절하게 안내해야 합니다.   
>> 이러한 방식은 모든 웹서비스에 꼭 필요한 기능입니다.
>>
>> 먼저 이러한 검증 기능을 직접 개발해보고,    
>> 스프링이 제공하는 검증 기능도 사용해보고, 더 나아가서 어노테이션(Annotation) 하나로 매우 편리하게 검증 기능을 수행하는 Bean Validation 기능까지 예제를 통해 단계적으로 학습했습니다.
>
>> #### 쿠키, 세션
>> ![image](https://user-images.githubusercontent.com/66030601/229277296-98e92dfc-19df-40bd-9883-bea5474a00c6.png)   
>> HTTP는 무상태 프로토콜입니다. 따라서 로그인 기능을 유지하려면 쿠키와 세션과 같은 개념이 필요합니다.   
>> 먼저 쿠키만으로 로그인 기능을 만들어봅니다. 그리고 어떤 보안 문제점들이 있는지 확인한 다음에 세션을 직접 만들고 적용해봅니다.
>>
>> 이렇게 세션을 직접 만드는 과정을 통해서 쿠키와 세션의 동작 방식을 깊이있게 이해할 수 있습니다. 그리고 추가로 서블릿이 제공하는 세션을 학습하고 적용했습니다.
>
>> #### 필터, 인터셉터
>> ![image](https://user-images.githubusercontent.com/66030601/229278180-efbf9bd9-9bf8-4dab-ad6c-4d3d10aadb94.png)
>> 서블릿이 제공하는 필터(Filter)와 스프링이 제공하는 인터셉터(Interceptor)를 예제를 통해서 학습했습니다.
>>
>> 먼저 가장 단순한 모든 HTTP 요청 로그로 남기는 기능을 필터와 인터셉터로 만들어보고, 이후 인증 처리를 위한 기능도 필터와 인터셉터로 만들어보았습니다.   
>> 이렇게 둘을 함께 사용해보면서 각각의 장단점을 명확히 이해할 수 있습니다.
>
>> #### 예외 처리
>> ![image](https://user-images.githubusercontent.com/66030601/229278497-7d198b6c-1d76-4b96-a3f3-287375b1bbf9.png)   
>> 웹 애플리케이션을 학습할 때 가장 이해하기 어려운 부분이 바로 예외 처리(Exception Handling)입니다.    
>> 왜냐하면 서블릿 컨테이너(WAS)와 스프링 MVC가 각각 나름의 예외 처리 방법을 제공하기 떄문입니다.   
>> 그리고 실제로 이 둘이 섞여서 복잡하게 예외 처리 매커니즘이 동작합니다.   
>> 그래서 컨트롤러에서 예외가 발생했을 때 스프링과 서블릿 컨테이너가 각각 내부에서 어떻게 동작하는지 개발자가 정확하게 이해하고 사용하기 매우 어렵습니다.
>>
>> 서블릿 컨테이너의 예외 처리부터 스프링 MVC의 예외 처리까지 하나씩 단계적으로 알아보았습니다.   
>> 실제 예외가 발생했을 때 서버 내부에서 어떻게 동작하고, 어떤 지점을 변경해야 할지 명확히 이해할 수 있습니다.   
>> 추가로 API를 사용할 떄의 예외처리에 대해서도 알아보았습니다.
>
>> #### 스프링 타입 컨버터
>> ![image](https://user-images.githubusercontent.com/66030601/229279084-f31591d9-b73e-4f88-9302-c57066361144.png)        
>> 문자를 숫자로 변환하거나, 반대로 숫자를 문자로 변환해야 하는 것 처럼 애플리케이션을 개발하다 보면 타입을 변환해야 하는 경우가 많습니다.    
>> 예를 들어서 HTTP 요청에서 문자 "10"이 전달되어도 스프링에서는 @RequestParam으로 Integer 타입인 숫자 10으로 받을 수 있습니다.    
>> 스프링은 타입 컨버터라는 기능을 제공해서 일관성 있는 타입 변환을 지원합니다.
>>
>> 타입 컨버터의 기본에서 활용까지 예제를 통해 단계적으로 이해했습니다.
>
>> #### 파일 업로드
>> ![image](https://user-images.githubusercontent.com/66030601/229279726-2e0942d2-380f-4a22-b51e-1f811c07c596.png)
>> 단순히 파일 업로드의 기능을 알아보는 것을 넘어서, 파일 업로드를 위해 사용하는 프로토콜에 대해 알아보고, 어떤 원리로 HTTP에서 파일 업로드가 가능한지 학습했습니다.
>>
>> 파일 업로드 기능을 서블릿부터 시작해서 스프링이 제공하는 편리한 방식의 파일 업로드까지 예제를 통해 단계적으로 학습했습니다.
>         
>             
> 기능 구현에 집중하는 것이 아닌, LowLevel 코드에서 실전에서 사용할 수 있는 방식으로 리팩토링을 진행하는 과정을 통해,   
> 특정 기능을 추가해야 할 때, 어떤 부분을 확장해야 하는지 확장 포인트에 대한 고민까지 할 수 있었습니다.
> ---
