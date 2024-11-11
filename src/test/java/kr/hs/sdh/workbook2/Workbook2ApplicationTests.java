package kr.hs.sdh.workbook2;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Workbook2ApplicationTests {

    @Test
    void contextLoads() {

    }
    int returnOne(){
        return 1;
    }
    @Test
    void main() {
        System.out.println((double) returnOne());
    }

}
