package hello.core.singleton;

import hello.core.Appconfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없이 순수한 DI 컨테이너")
    void pureContainer() {
        Appconfig appconfig = new Appconfig();
        // 1. 조회: 호출할 때 마다 객체를 생성
        SingletonService memberService1 = SingletonService.getInstance();

        // 2. 조회: 호출할 때 마다 객체를 생성
        SingletonService memberService2 = SingletonService.getInstance();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

//        assertThat(memberService1).isNotSameAs(memberService2);
        // SingletonService 의 싱글톤 패턴으로 객체를 생성하면, 두 객체가 같기 때문에
        // 다르지 않음 알 수 있습니다. 테스트 해보면, java.lang.AssertionError:
        // Expected not same 라고나옴
        assertThat(memberService1).isSameAs(memberService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springConstainer() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        // 1. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        // 2. 조회: 호출할 때 마다 객체를 생성
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
//
//    @Test //SingletonService() has private access in hello.core.singleton.SingletonService
//    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
//    void singletonServiceText() {
//        new SingletonService();
//    }