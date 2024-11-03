package kr.hs.sdh.workbook2.repository;

import kr.hs.sdh.workbook2.entity.Hamburger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LotteriaHamburgerRepositoryTest {

//    private final List<Hamburger> hamburgers = new ArrayList<>();

    private final Set<Hamburger> hamburgers = new HashSet<>();

    @Test
    void saveHamburger() {
        Hamburger compareHamburger = new Hamburger(
                "테스트맛 햄버거",
                100,
                "/none",
                true,
                true
        );
        //int index  = this.hamburgers.indexOf(compareHamburger);

//        assertEquals(0, index, "테스트는 실패했어요");
//        assertTrue(is, '테스트맛 햄버거가 무조건 있어야한다.');
//        assertEquals(i == , "테스트맛 햄버거가 무조건 있어야한다.");
    }

//    @BeforeEach
    void beforeTest() {
        Hamburger testHamburger = new Hamburger(
                "테스트맛 햄버거",
                100,
                "/none",
                true,
                true
        );
        this.hamburgers.add(testHamburger);
    }

    @BeforeEach
    void beforeTest2() {
        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거2",
                4500,
                "/",
                true,
                false
        );
        this.hamburgers.add(appleHamburger);
    }

    @Test
    void deleteHamburger2() {
        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거1",
                4500,
                "/",
                true,
                false
        );
        this.hamburgers.removeIf(beforeHamburger -> beforeHamburger.equals(appleHamburger));
        System.out.println(this.hamburgers);
    }

    @Test
    void saveHamburger2() {
        Hamburger appleHamburger = new Hamburger(
                "사과 햄버거",
                4500,
                "/",
                true,
                false
        );
//        this.hamburgers.remove(appleHamburger);
//        this.hamburgers.add(appleHamburger);
        System.out.println(this.hamburgers);
        System.out.println(appleHamburger);
    }
    @Test
    void num(){
        List<Integer> a = new ArrayList<Integer>();
        Integer num = 1;
        a.add(num);
        Integer num2 = 1;
        System.out.println(a.contains(num2));

    }

}