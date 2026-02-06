package manu.interview.serviceImpl;

import manu.interview.service.MemberService;
import manu.interview.model.Member;
import manu.interview.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberRepository memRepo;

    @Override
    public Integer saveMember(Member member) {
        member=memRepo.save(member);
        return member.getId();
    }

    @Override
    public List<Member> getAllMembers() {
        return memRepo.findAll();
    }
}
