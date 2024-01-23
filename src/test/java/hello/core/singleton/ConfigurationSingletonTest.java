package hello.core.singleton;

import hello.core.Appconfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        // 모두 같은 인스턴스를 참고하고 있는지 테스트해본다.
        System.out.println("<memberService -> memberRepository> = " + memberService.getMemberRepository());
        System.out.println("<orderService -> memberRepository> = " + orderService.getMemberRepository());
        System.out.println("memberRepository = " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(orderService.getMemberRepository());
        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);
        Appconfig bean = ac.getBean(Appconfig.class);
        // CGLIB 이라는 임의의 다른 클래스가 싱글톤이 보장되도록 해준다. 바이트 코드를 조작해서 작성되어 있다.
        System.out.println("....->bean = " + bean.getClass()); //Appconfig$$SpringCGLIB$$0
    }
}
