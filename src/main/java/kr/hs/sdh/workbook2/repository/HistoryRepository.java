package kr.hs.sdh.workbook2.repository;

import kr.hs.sdh.workbook2.entity.History;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HistoryRepository {

    @Insert("""
        INSERT INTO history
        VALUES(#{name}, #{price}, #{saleDatetime});
    """)
    void saveHamburgerHistory(History history);

    @Insert("""
        INSERT INTO history(name, price, sale_datetime)
        VALUES(#{burgerName}, (SELECT price FROM hamburger WHERE name = #{burgerName}), CURRENT_TIMESTAMP())
    """)
    void addHistoryByBurgerName(String burgerName);

}
