package me.guya.remindspring.service;

import me.guya.remindspring.domain.Member;
import me.guya.remindspring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
       this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        /* 중복 회원 검증. */
        validateDuplicateMember(member);
        /* 중복 회원이 없을 경우, 저장. */
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }
}
