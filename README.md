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
