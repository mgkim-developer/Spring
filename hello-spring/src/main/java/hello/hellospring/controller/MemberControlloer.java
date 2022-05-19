package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberControlloer {

    private MemberService memberService;

    @Autowired
    public MemberControlloer(MemberService memberService) {
        this.memberService = memberService;
    }
}
