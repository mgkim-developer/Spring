# Spring_MVC2
>### Spring_MVC2 레포지토리의 목표는,
> Spring_MVC1에서 학습한 스프링 MVC의 기반 위에,    
> - 뷰 템플릿
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
> 위와 같은 실무에 꼭 필요한 방대한 웹 활용 기술을 예제를 통해 공부하는 것 입니다.    
> 단지 구현에 집중하는 것이 아니라, 각 기술들을 가장 LowLevel의 코드로 작성 해보고, 개발자가 사용하기 편하도록 추가된 기능들을 도입하며 실무에서 사용하는 방식으로 리팩토링 하는 방식으로 진행할 것입니다.

---
## Index
### 타임리프 - 기본 기능
- [프로젝트 생성](https://mgyo.tistory.com/613)
- [타임리프 소개](https://mgyo.tistory.com/614)
- [텍스트 - text, utext](https://mgyo.tistory.com/615)
- [변수 - SpringEL](https://mgyo.tistory.com/616)
- [유틸리티 객체와 날짜](https://mgyo.tistory.com/618)
- [URL 링크](https://mgyo.tistory.com/619)
- [리터럴](https://mgyo.tistory.com/620)
- [연산](https://mgyo.tistory.com/621)
- [속성 값 설정](https://mgyo.tistory.com/622)
- [반복](https://mgyo.tistory.com/625)
- [조건부 평가](https://mgyo.tistory.com/626)
- [주석](https://mgyo.tistory.com/627)
- [블록](https://mgyo.tistory.com/628)
- [자바스크립트 인라인](https://mgyo.tistory.com/629)
- [템플릿 조각](https://mgyo.tistory.com/630)
- [템플릿 레이아웃1](https://mgyo.tistory.com/631)
- [템플릿 레이아웃2](https://mgyo.tistory.com/632)
- [정리](https://mgyo.tistory.com/633)

### 타임리프 - 스프링 통합과 폼
- [프로젝트 설정](https://mgyo.tistory.com/634)
- [타임리프 스프링 통합](https://mgyo.tistory.com/635)
- [입력 폼 처리](https://mgyo.tistory.com/636)
- [요구사항 추가](https://mgyo.tistory.com/637)
- [체크 박스 - 단일1](https://mgyo.tistory.com/638)
- [체크 박스 - 단일 2](https://mgyo.tistory.com/639)
- [체크 박스 - 멀티](https://mgyo.tistory.com/640)
- [라디오 버튼](https://mgyo.tistory.com/641)
- [셀렉트 박스](https://mgyo.tistory.com/642)
- [정리](https://mgyo.tistory.com/643)

### 메시지, 국제화
- [프로젝트 설정](https://mgyo.tistory.com/644)
- [메시지, 국제화 소개](https://mgyo.tistory.com/645)
- [스프링 메시지 소스 설정](https://mgyo.tistory.com/646)
- [스프링 메시지 소스 사용](https://mgyo.tistory.com/647)
- [웹 애플리케이션에 메시지 적용하기](https://mgyo.tistory.com/648)
- [웹 애플리케이션에 국제화 적용하기](https://mgyo.tistory.com/649)
- [정리](https://mgyo.tistory.com/650)

### 검증1 - Validation
- [검증 요구사항](https://mgyo.tistory.com/651)
- [프로젝트 설정 V1](https://mgyo.tistory.com/652)
- [검증 직접 처리 - 소개](https://mgyo.tistory.com/653)
- [검증 직접 처리 - 개발](https://mgyo.tistory.com/654)
- [프로젝트 준비 V2](https://mgyo.tistory.com/655)
- [BindingResult1](https://mgyo.tistory.com/656)
- [BindingResult2](https://mgyo.tistory.com/657)
- [FieldError, ObjectError](https://mgyo.tistory.com/658)
- [오류 코드와 메시지 처리1](https://mgyo.tistory.com/659)
- [오류 코드와 메시지 처리2](https://mgyo.tistory.com/660)
- [오류 코드와 메시지 처리3](https://mgyo.tistory.com/661)
- [오류 코드와 메시지 처리4](https://mgyo.tistory.com/662)
- [오류 코드와 메시지 처리5](https://mgyo.tistory.com/663)
- [오류 코드와 메시지 처리6](https://mgyo.tistory.com/664)
- [Validator 분리1](https://mgyo.tistory.com/665)
- [Validator 분리2](https://mgyo.tistory.com/666)
- [정리](https://mgyo.tistory.com/667)

### 검증2 - Bean Validation
- [Bean Validation - 소개](https://mgyo.tistory.com/668)
- [Bean Validation - 시작](https://mgyo.tistory.com/669)
- [Bean Validation - 프로젝트 준비 V3](https://mgyo.tistory.com/670)
- [Bean Validation - 스프링 적용](https://mgyo.tistory.com/671)
- [Bean Validation - 에러 코드](https://mgyo.tistory.com/672)
- [Bean Validation - 오브젝트 오류](https://mgyo.tistory.com/674)
- [Bean Validation - 수정에 적용](https://mgyo.tistory.com/675)
- [Bean Validation - 한계](https://mgyo.tistory.com/676)
- [Bean Validation - groups](https://mgyo.tistory.com/677)
- [Form 전송 객체 분리 - 프로젝트 준비 V4](https://mgyo.tistory.com/678)
- [Form 전송 객체 분리 - 소개](https://mgyo.tistory.com/679)
- [Form 전송 객체 분리 - 개발](https://mgyo.tistory.com/680)
- [Bean Validation - HTTP 메시지 컨버터](https://mgyo.tistory.com/681)
- [정리](https://mgyo.tistory.com/682)

### 로그인 처리1 - 쿠키, 세션
- [로그인 요구사항](https://mgyo.tistory.com/683)
- [프로젝트 생성](https://mgyo.tistory.com/684)
- [홈 화면](https://mgyo.tistory.com/685)
- [회원 가입](https://mgyo.tistory.com/686)
- [로그인 기능](https://mgyo.tistory.com/687)
- [로그인 처리하기 - 쿠키 사용](https://mgyo.tistory.com/688)
- [쿠키와 보안 문제](https://mgyo.tistory.com/690)
- [로그인 처리하기 - 세션 동작 방식](https://mgyo.tistory.com/691)
- [로그인 처리하기 - 세션 직접 만들기](https://mgyo.tistory.com/692)
- [로그인 처리하기 - 직접 만든 세션 적용](https://mgyo.tistory.com/693)
- [로그인 처리하기 - 서블릿 HTTP 세션1](https://mgyo.tistory.com/694)
- [로그인 처리하기 - 서블릿 HTTP 세션2](https://mgyo.tistory.com/695)
- [세션 정보와 타임아웃 설정](https://mgyo.tistory.com/696)
- [정리](https://mgyo.tistory.com/697)

### 로그인 처리2 - 필터, 인터셉터
- [서블릿 필터 - 소개](https://mgyo.tistory.com/698)
- [서블릿 필터 - 요청 로그](https://mgyo.tistory.com/699)
- [서블릿 필터 - 인증 체크](https://mgyo.tistory.com/700)
- [스프링 인터셉터 - 소개](https://mgyo.tistory.com/701)
- [스프링 인터셉터 - 요청 로그](https://mgyo.tistory.com/702)
- [스프링 인터셉터 - 인증 체크](https://mgyo.tistory.com/703)
- [ArgumentResolver 활용](https://mgyo.tistory.com/704)
- [정리](https://mgyo.tistory.com/705)          

### 예외 처리와 오류 페이지
- [프로젝트 생성](https://mgyo.tistory.com/706)
- [서블릿 예외 처리 - 시작](https://mgyo.tistory.com/707)
- [서블릿 예외 처리 - 오류 화면 제공](https://mgyo.tistory.com/708)
- [서블릿 예외 처리 - 오류 페이지 작동 원리](https://mgyo.tistory.com/709)
- [서블릿 예외 처리 - 필터](https://mgyo.tistory.com/710)
- [서블릿 예외 처리 - 인터셉터](https://mgyo.tistory.com/711)
- [스프링 부트 - 오류 페이지1](https://mgyo.tistory.com/712)
- [스프링 부트 - 오류 페이지2](https://mgyo.tistory.com/713)
- [정리](https://mgyo.tistory.com/714)         

### API 예외 처리
- [시작](https://mgyo.tistory.com/715)
- [스프링 부트 기본 오류 처리](https://mgyo.tistory.com/716)
- [HandlerExceptionResolver 시작](https://mgyo.tistory.com/718)
- [HandlerExceptionResolver 활용](https://mgyo.tistory.com/719)
- [스프링이 제공하는 ExceptionResolver1](https://mgyo.tistory.com/720)
- [스프링이 제공하는 ExceptionResolver2](https://mgyo.tistory.com/721)
- [@ExceptionHandler](https://mgyo.tistory.com/722)
- [@ControllerAdvice](https://mgyo.tistory.com/723)
- [정리](https://mgyo.tistory.com/724)       

### 스프링 타입 컨버터
- [프로젝트 생성](https://mgyo.tistory.com/725)
- [스프링 타입 컨버터 소개](https://mgyo.tistory.com/726)
- [타입 컨버터 - Converter](https://mgyo.tistory.com/727)
- [컨버전 서비스 - ConversionService](https://mgyo.tistory.com/728)
- [스프링에 Converter 적용하기](https://mgyo.tistory.com/729)
- [뷰 템플릿에 컨버터 적용하기](https://mgyo.tistory.com/730)
- [포맷터 - Formatter](https://mgyo.tistory.com/731)
- [포맷터를 지원하는 컨버전 서비스](https://mgyo.tistory.com/732)
- [포맷터 적용하기](https://mgyo.tistory.com/733)
- [스프링이 제공하는 기본 포맷터](https://mgyo.tistory.com/734)
- [정리](https://mgyo.tistory.com/735)       

### 파일 업로드
- [파일 업로드 소개](https://mgyo.tistory.com/736)
- [프로젝트 생성](https://mgyo.tistory.com/737)
- [서블릿과 파일 업로드1](https://mgyo.tistory.com/738)
- [서블릿과 파일 업로드2](https://mgyo.tistory.com/739)
- [스프링과 파일 업로드](https://mgyo.tistory.com/741)
- [예제로 구현하는 파일 업로드, 다운로드](https://mgyo.tistory.com/742)
- [정리](https://mgyo.tistory.com/743)       



[Spring_MVC2을 마치며..](#마무리)

### 마무리
> Spring_MVC2 레포지토리의 목표는,    
> 실무 백엔드 웹 애플리케이션을 개발할 때 필요한 웹 기술을 공부하는 것이었습니다.     
>     
> 스프링 MVC의 다양한 활용 기술을 학습했습니다.   
> - 타임리프
> - 메시지
> - 국제화
> - 검증
> - 쿠키
> - 세션
> - 필터
> - 인터셉터
> - 예외처리
> - 타입 컨버터
> - 파일 업로드
>        
> ### 요약 및 정리
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
> --------------------     
> 기능 구현에 집중하는 것이 아닌, LowLevel 코드에서 실전에서 사용할 수 있는 방식으로 리팩토링을 진행하는 과정을 통해,   
> 특정 기능을 추가해야 할 때, 어떤 부분을 확장해야 하는지 확장 포인트에 대한 고민까지 할 수 있었습니다.
>  