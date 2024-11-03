package kr.hs.sdh.workbook2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.service.HamburgerService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class HamburgerRestController {
    private final HamburgerService hamburgerService;

    public HamburgerRestController(final HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping("/lotteria-menus")
    private List<Hamburger> lotterialMenus(@RequestParam(defaultValue = "") String hamburgerName) {
        List<Hamburger> hamburgers = this.hamburgerService.getHamburgers();
//         defaultValue로 if 문을 없애도 됨
//        if(hamburgerName == null || hamburgerName.isEmpty()) return hamburgers;
        return hamburgers
                .stream()
                .filter(hamburger -> hamburger.getName().matches(".*" + hamburgerName + ".*"))
                .toList();
//        스트림을 사용하여 위 처럼 줄일 수 있음
//        List<Hamburger> filteredHamburgers = new ArrayList<Hamburger>();
//        for (Hamburger hamburger : hamburgers) {
//            if(hamburger.getName().matches(".*" + hamburgerName + ".*")){
//                filteredHamburgers.add(hamburger);
//            }
//        }
//        return filteredHamburgers;
    }

    @PostMapping("/lotteria-add-menu")
    private void lotterialMenus(
            Hamburger hamburger,
            @RequestParam(value = "image") MultipartFile multipartFile,
            HttpServletResponse httpServletResponse
    ) throws IOException {
        if (hamburger != null) {
            System.out.println(hamburger.isRecommended);
            System.out.println(hamburger.isNew);
            hamburgerService.setHamburger(hamburger, multipartFile);
            httpServletResponse.sendRedirect("lotteria-example");
        }
//        return new RedirectView("/lotteria-example");
    }
}
