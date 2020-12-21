package me.guya.remindspring;

import com.zaxxer.hikari.HikariDataSource;
import me.guya.remindspring.repository.JdbcMemberRepository;
import me.guya.remindspring.repository.MemberRepository;
import me.guya.remindspring.repository.MemoryMemberRepository;
import me.guya.remindspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    private final DataSource dataSource;

    @Autowired
    public AppConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        /* Autowired */
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
