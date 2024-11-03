package kr.hs.sdh.workbook2.service;

import kr.hs.sdh.workbook2.entity.Hamburger;
import kr.hs.sdh.workbook2.repository.HamburgerRepository;
import kr.hs.sdh.workbook2.repository.LotteriaHamburgerRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

@Service
public final class HamburgerService {

    private static final String ABSOLUTE_PATH = "C:\\Users\\309\\Desktop\\OJT2024\\workbook2\\src\\main\\resources\\static\\images\\";

    // 햄버거 데이터 저장소
    private final HamburgerRepository hamburgerRepository;

    // "HamburgerService" 클래스의 생성자
    public HamburgerService(LotteriaHamburgerRepository hamburgerRepository) {
        this.hamburgerRepository = hamburgerRepository;
    }

    public List<Hamburger> findRecommendedHamburgers() {
      return this.hamburgerRepository.findHamburgers()
              .stream()
              .filter(hamburger -> hamburger.isRecommended)
              .toList();
    };


    // 햄버거 데이터를 조회하고 금액 순서로 정렬하여 반환
    public List<Hamburger> getHamburgers() {
        return this.hamburgerRepository.findHamburgers()
            .stream()
            .sorted(
                Comparator.comparing(Hamburger::getPrice)
            )
            .toList();
    }

    public void setHamburger(Hamburger hamburger, final MultipartFile multipartFile) {
        final String fileName = multipartFile.getOriginalFilename();

        if(fileName != null && !fileName.isEmpty()) {
            try{
                final File file = new File(ABSOLUTE_PATH + fileName);

                multipartFile.transferTo(file);
                hamburger.setImagePath("/images/" + fileName);
                this.hamburgerRepository.saveHamburger(hamburger);
            } catch (final IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}