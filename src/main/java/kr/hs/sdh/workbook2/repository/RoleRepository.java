package kr.hs.sdh.workbook2.repository;

import kr.hs.sdh.workbook2.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleRepository {
    @Select("SELECT * FROM role WHERE id = #{id}")
    public List<Role> findAllById(String id);
}
