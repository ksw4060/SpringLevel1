package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 컴포넌트 스캔과 의존관계 자동 주입을 위해서, @Component, @Autowired 가 추가됨.
@Component
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    @Autowired // 자동 의존 관계 주입을 위해서, 생성자에 붙여준다. ac.getBean(MemberRepository.class)
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도로 꺼내보는 메서드.
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
