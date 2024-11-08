package kr.hs.sdh.workbook2.controller;

import kr.hs.sdh.workbook2.dto.ResponseDTO;
import kr.hs.sdh.workbook2.entity.Member;
import kr.hs.sdh.workbook2.entity.SignIn;
import kr.hs.sdh.workbook2.service.MemberService;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class MemberRestController {
    MemberService memberService;

    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/member/{id}")
    private Member getMember(@PathVariable String id) {
        return this.memberService.findMemberById(id);
    }

    @DeleteMapping("/member/{id}")
    private ResponseDTO<String> deleteMember(@PathVariable String id) {
        this.memberService.removeMember(id);
        return new ResponseDTO.Builder<String>()
                .code(200)
                .message(id + " 계정이 삭제가 완료되었습니다.")
                .requestURI("/member/" + id)
                .requestMethod("DELETE")
                .build();
    }
//    @DeleteMapping("/delete-user")
//    private String deleteMember(@RequestParam final String id) {
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.exchange(
//                "http://10.56.148.132:18080/delete-user?id=" + id,
//                HttpMethod.DELETE,
//                null,
//                String.class
//        ).getBody();
//
//        this.memberService.removeMember(id);
//        return new ResponseDTO.Builder<String>()
//                .code(200)
//                .message(id + " 계정이 삭제가 완료되었습니다.")
//                .requestURI("/member/?id=" + id)
//                .requestMethod("DELETE")
//                .build();
//    }



    @PostMapping("/sign-in")
    private Member signIn(@RequestBody SignIn signIn) {
        final String id = signIn.getId();
        return this.memberService.findMemberById(id);
    }


}
