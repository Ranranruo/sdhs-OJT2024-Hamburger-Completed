package kr.hs.sdh.workbook2.controller;

import kr.hs.sdh.workbook2.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

}
