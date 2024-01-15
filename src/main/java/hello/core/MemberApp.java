package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        Appconfig appconfig = new Appconfig();
//        MemberService memberService = appconfig.memberService();
        // AppConfig 에 있는 환경설정을, 스프링 컨테이너에 넣어서 관리해줍니다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Appconfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        Member member1 = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member1 = " + member1.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
