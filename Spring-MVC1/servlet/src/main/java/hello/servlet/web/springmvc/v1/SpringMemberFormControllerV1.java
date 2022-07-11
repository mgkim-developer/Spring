package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@Component // 스프링 빈으로 등록
//@RequestMapping // @RequestMapping이 클래스단에 붙어있으면, RequestMappingHndlerMapping이 @RequestMapping가 붙은 클래스를 찾아낸다.
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }
}
