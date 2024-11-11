package kr.hs.sdh.workbook2.service;

import kr.hs.sdh.workbook2.entity.Role;
import kr.hs.sdh.workbook2.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RoleService {
    RoleRepository roleRepository;
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    public Set<Role> getRoles(String id) {
        return new HashSet<Role>(roleRepository.findAllById(id));
    }
}
