package me.guya.remindspring;

import me.guya.remindspring.repository.MemberRepository;
import me.guya.remindspring.repository.MemoryMemberRepository;
import me.guya.remindspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        /* Autowired */
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
