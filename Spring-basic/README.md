# Spring Basic
>### Spring_Basic 레포지토리의 목표는,
> 스프링의 핵심 원리와 핵심 기능에 대해서 깊이있게 학습하여    
> 스프링이 왜 만들어졌고, 왜 필요한지, 그리고 객체 지향 설계와 스프링이 왜 땔 수 없는 관계인지 이해하는 것 입니다.
>
> 스프링이 없던 20년 전으로 돌아가서 스프링이 왜 만들어졌는지 그 이유부터 시작합니다.   
> 그리고 실제 그때로 돌아가서 스프링이 없는 순수한 자바 코드로 예제 애플리케이션을 만들어봅니다.    
> 요구사항이 변경 됨에 따라 문제점들이 하나씩 발견되고, 그 문제를 해결하기 위해 좋은 객체 지향 원리들을 하나씩 코드에 적용하면서 문제를 해결해나갑니다.    
> 이 과정속에서 자연스럽게 코드를 통해, 객체 지향의 원리(SOLID)와 IoC, DI에 대해서 이해하고, 또 스프링 컨테이너가 왜 필요한지 알게되었습니다.     
>      
> 스프링의 핵심 원리와 핵심 컨셉을 제대로 학습했기 때문에 스프링 부트를 포함해서 스프링의 핵심 기술을 활용하는 수많은 스프링 기술들을 배우고 사용할 때도, 단순한 기능 사용을 넘어서 깊이 있는 이해가 가능할 것입니다.

---
## Index
### [객체 지향 설계와 스프링](https://mgyo.tistory.com/423)
- 스프링 역사
- 스프링 생태계
- 스프링 프레임워크
- 스프링 부트
- 스프링의 핵심
- 객체 지향 프로그래밍
- SOLID
- 객체 지향 설계와 스프링

### 스프링 핵심 원리 이해1 예제 만들기
- [프로젝트 생성](https://mgyo.tistory.com/423)
- [비즈니스 요구사항과 설계](https://mgyo.tistory.com/424)
- [회원 도메인 설계](https://mgyo.tistory.com/425)
- [회원 도메인 개발](https://mgyo.tistory.com/426)
- [회원 도메인 실행과 테스트](https://mgyo.tistory.com/427)
- [주문과 할인 도메인 설계](https://mgyo.tistory.com/428)
- [주문과 할인 도메인 개발](https://mgyo.tistory.com/430)
- [주문과 할인 도메인 실행과 테스트](https://mgyo.tistory.com/431)

[스프링 핵심 원리 이해2 객체 지향 원리 적용]
- [새로운 할인 정책 개발](https://mgyo.tistory.com/432)
- [새로운 할인 정책 적용과 문제점](https://mgyo.tistory.com/433)
- [관심사의 분리](https://mgyo.tistory.com/434)
- [AppConfig 리팩터링](https://mgyo.tistory.com/435)
- [새로운 구조와 할인 정책 적용](https://mgyo.tistory.com/436)
- [전체 흐름 정리](https://mgyo.tistory.com/438)
- [좋은 객체 지향 설계의 5가지 원칙의 적용](https://mgyo.tistory.com/439)
- [IoC, DI, 그리고 컨테이너](https://mgyo.tistory.com/440)
- [스프링으로 전환하기](https://mgyo.tistory.com/441)

### 스프링 컨테이너와 스프링 빈
- [스프링 컨테이너 생성](https://mgyo.tistory.com/442)
- [컨테이너에 등록된 모든 빈 조회](https://mgyo.tistory.com/443)
- [스프링 빈 조회 - 기본](https://mgyo.tistory.com/444)
- [스프링 빈 조회 - 동일한 타입이 둘 이상](https://mgyo.tistory.com/445)
- [스프링 빈 조회 - 상속 관계](https://mgyo.tistory.com/446)
- [BeanFactory와 ApplicationContext](https://mgyo.tistory.com/448)
- [다양한 설정 형식 지원 - 자바 코드, XML](https://mgyo.tistory.com/449)
- [스프링 빈 설정 메타 정보 - BeanDefinition](https://mgyo.tistory.com/450)

### 싱글톤 컨테이너
- [웹 애플리케이션과 싱글톤](https://mgyo.tistory.com/451)
- [싱글톤 패턴](https://mgyo.tistory.com/452)
- [싱글톤 컨테이너](https://mgyo.tistory.com/453)
- [싱글톤 방식의 주의점](https://mgyo.tistory.com/454)
- [@Configuration과 싱글톤](https://mgyo.tistory.com/455)
- [@Configuration과 바이트코드 조작의 마법](https://mgyo.tistory.com/459)

### 컴포넌트 스캔
- [컴포넌트 스캔과 의존관계 자동 주입 시작하기](https://mgyo.tistory.com/460)
- [탐색 위치와 기본 스캔 대상](https://mgyo.tistory.com/461)
- [필터](https://mgyo.tistory.com/463)
- [중복 등록과 충돌](https://mgyo.tistory.com/464)

### 의존관계 자동 주입
- [다양한 의존관계 주입 방법](https://mgyo.tistory.com/466)
- [옵션 처리](https://mgyo.tistory.com/467)
- [생성자 주입을 선택해라!](https://mgyo.tistory.com/468)
- [롬복과 최신 트랜드](https://mgyo.tistory.com/469)
- [조회 빈이 2개 이상 - 문제](https://mgyo.tistory.com/470)
- [@Autowired 필드명, @Qualifier, @Primary](https://mgyo.tistory.com/471)
- [애노테이션 직접 만들기](https://mgyo.tistory.com/472)
- [조회한 빈이 모두 필요할 때, List, Map](https://mgyo.tistory.com/473)
- [자동, 수동의 올바른 실무 운영 기준](https://mgyo.tistory.com/474)

### 빈 생명주기 콜백
- [빈 생명주기 콜백 시작](https://mgyo.tistory.com/477)
- [인터페이스 InitializingBean, DisposableBean](https://mgyo.tistory.com/478)
- [빈 등록 초기화, 소멸 메서드 지정](https://mgyo.tistory.com/479)
- [애노테이션 @PostConstruct, @PreDestroy](https://mgyo.tistory.com/480)

### 빈 스코프
- [빈 스코프란?](https://mgyo.tistory.com/481)
- [프로토타입 스코프](https://mgyo.tistory.com/482)
- [프로토타입 스코프 - 싱글톤 빈과 함께 사용시 문제점](https://mgyo.tistory.com/484)
- [프로토타입 스코프 - 싱글톤 빈과 함께 사용시 Provider로 문제 해결](https://mgyo.tistory.com/486)
- [웹 스코프](https://mgyo.tistory.com/491)
- [request 스코프 예제 만들기](https://mgyo.tistory.com/492)
- [스코프와 Provider](https://mgyo.tistory.com/493)
- [스코프와 프록시](https://mgyo.tistory.com/494)

[Spring_Basic를 마치며..](#마무리)

### 마무리
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