package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j
@RestController
public class LogTestController {

    private final Logger log = LoggerFactory.getLogger(getClass());   //lombok의 @Slf4j가 이 코드를 자동으로 넣어줌

    @RequestMapping("/log-test")
    public String LogTest() {
        String name = "Spring";

//        System.out.println("name = " + name);  // 레벨에 상관없이 항상 출력되기 때문에 println으로는 로그를 출력하면 안됌.

        log.trace("trace log={}", name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

//        로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
//        log.debug("String concatlog=" + name);

        return "ok";
    }
}
