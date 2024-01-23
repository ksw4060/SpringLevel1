package hello.core;


import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(
//        basePackages = "hello.core.member", // hello.core.member 에서부터 스캔을 시작함.
//        basePackageClasses = AutoAppConfig.class, // 지정 해주지 않으면, 디폴트로 이렇게 스캔함
        excludeFilters = @Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class)
)
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
