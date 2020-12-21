package me.guya.remindspring.controller;

import me.guya.remindspring.domain.Member;

/* java bean pattern */
public class MemberForm {
    private String name;

    public MemberForm() {}

    public String getName() {
        return name;
    }

    /* spring 이 setName 을 보고 전달된 key 값을 바인딩 해줌. */
    public void setName(String name) {
        this.name = name;
    }

    public Member toDomain() {
        Member member = new Member();
        member.setName(this.name);

        return member;
    }
}
