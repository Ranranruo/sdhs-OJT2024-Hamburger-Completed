package kr.hs.sdh.workbook2.controller;

import kr.hs.sdh.workbook2.entity.History;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

    @GetMapping("/lorem")
    public String lorem(History history) {
        return "hello lorem";
    }
}
