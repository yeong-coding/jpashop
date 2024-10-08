package jpabook.jpashop.sample;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    public void testMember(){

        // given
        Member member=new Member();
        member.setUsername("AAA");

        // when
        Long save = memberRepository.save(member);
        Member findMember=memberRepository.find(save);

        // then
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
    }
}