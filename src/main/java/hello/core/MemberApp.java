package hello.core;

import hello.core.member.*;

public class MemberApp {
    public static void main(String[] args) {
        Appconfig appconfig = new Appconfig();
        MemberService memberService = appconfig.memberService();
        Member member1 = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member1);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member1 = " + member1.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
