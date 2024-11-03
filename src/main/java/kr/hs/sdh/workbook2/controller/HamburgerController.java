package kr.hs.sdh.workbook2.controller;

import  kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.service.HamburgerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public final class HamburgerController {

    private final HamburgerService hamburgerService;

    public HamburgerController(final HamburgerService hamburgerService) {
        this.hamburgerService = hamburgerService;
    }

    @GetMapping(value = "/lotteria")
    private String lotteria(final Model model, @RequestParam(required = false) String category) {
        List<Hamburger> hamburgers = null;
        if(Objects.equals(category, "recommended")) hamburgers = this.hamburgerService.findRecommendedHamburgers();
        else hamburgers = this.hamburgerService.getHamburgers();
        model.addAttribute("hamburgers", hamburgers);
        model.addAttribute("category", category);
        return "lotteria";
    }
    @GetMapping(value = "/lotteria-example")
    private String lotteriaExample() {
        return "lotteria-example";
    }

}
