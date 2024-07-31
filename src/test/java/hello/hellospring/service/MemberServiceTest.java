package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService();
    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given (뭔가가 주어져 있는데,)
        Member member = new Member();
        member.setName("hello");


        //when (이걸 실행 했을 때,)
        Long saveId = memberService.join(member);


        //then (결과는 이렇게 나와야 한다.)
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());

    }


    @Test
    public void 중복_회원_예외(){
        //given (뭔가가 주어져 있는데,)
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");


        //when (이걸 실행 했을 때,)
        memberService.join(member1);
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));


        //then (결과는 이렇게 나와야 한다.)

    }


    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}