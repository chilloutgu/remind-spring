package me.guya.remindspring.repository;

import me.guya.remindspring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("동구");

        Member savedMember = memberRepository.save(member);
        Member foundMember = memberRepository.findById(savedMember.getId()).get();

        // Assertions.assertEquals(savedMember, null);
        assertThat(foundMember).isEqualTo(savedMember);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("동구");
        memberRepository.save(member1);


        Member member2 = new Member();
        member2.setName("재혁");
        memberRepository.save(member2);

        Member foundMember = memberRepository.findByName("동구").get();

        assertThat(foundMember).isEqualTo(member1);
    }
    
    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("동구");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("재혁");
        memberRepository.save(member2);

        Member member3 = new Member();
        member3.setName("상근");
        memberRepository.save(member3);

        Member member4 = new Member();
        member4.setName("준혁");
        memberRepository.save(member4);

        List<Member> nuga = memberRepository.findAll();
        assertThat(nuga.size()).isEqualTo(4);
    }
}
