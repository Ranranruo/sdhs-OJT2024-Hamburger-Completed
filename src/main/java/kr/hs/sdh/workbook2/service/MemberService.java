package kr.hs.sdh.workbook2.service;

import kr.hs.sdh.workbook2.entity.Member;
import kr.hs.sdh.workbook2.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void removeMember(String id) {
        this.memberRepository.deleteMemberById(id);
    }

    public Member findMemberById(String id) {
        return this.memberRepository.findMemberById(id);
    }
}
