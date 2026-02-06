package manu.interview.service;

import manu.interview.model.Member;

import java.util.List;

public interface MemberService {

    Integer saveMember(Member member);
    List<Member> getAllMembers();


}
