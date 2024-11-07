package kr.hs.sdh.workbook2.service;

import kr.hs.sdh.workbook2.entity.History;
import kr.hs.sdh.workbook2.repository.HamburgerRepository;
import kr.hs.sdh.workbook2.repository.HistoryRepository;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final HamburgerRepository hamburgerRepository;

    public HistoryService(HistoryRepository historyRepository, HamburgerRepository hamburgerRepository) {
        this.historyRepository = historyRepository;
        this.hamburgerRepository = hamburgerRepository;
    }
    public boolean addHistory(String hamburgerName) {

        return true;
    }
    public void setHamburgerHistory(History history) {
        if(history.price <= 0) return;
        if(hamburgerRepository.contains(history.name) == null) return;
        historyRepository.saveHamburgerHistory(history);
    }
}