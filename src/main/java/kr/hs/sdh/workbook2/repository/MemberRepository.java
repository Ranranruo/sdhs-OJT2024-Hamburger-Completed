package kr.hs.sdh.workbook2.repository;

import kr.hs.sdh.workbook2.entity.Member;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberRepository {
    @Select("SELECT * FROM member WHERE id = #{id}")
    Member findMemberById(String id);

    @Delete("DELETE FROM member WHERE id = #{id}")
    void deleteMemberById(String id);
}
