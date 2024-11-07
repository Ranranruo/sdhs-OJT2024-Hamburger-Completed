package kr.hs.sdh.workbook2.controller;

import kr.hs.sdh.workbook2.entity.History;
import kr.hs.sdh.workbook2.service.HistoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;

@RestController
public class HistoryRestController {
    private final HistoryService historyService;
    public HistoryRestController(HistoryService historyService) {
        this.historyService = historyService;
    }

//    @GetMapping("/history")
//    public List<History> getHistory() {
//
//    }

    @PostMapping("/hamburger-sell")
    private String saleHamburger(History history) {
        historyService.setHamburgerHistory(history);
        return "판매가 완료되었습니다.";
    }
}
