package jpabook.jpashop;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
//JUnit5 에서 AssertThat 사용하기 위해 추가

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.equalTo;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)/*JUnit5로 사용할때*/
//@RunWith(SpringRunner.class)/*JUnit4로 사용할때*/
@SpringBootTest
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    //쿼리 완성형으로 뽑아주는 p6spy 라이브러리 임포트
    @Test
    @Transactional
    //테스트 후에 롤백할지 말지 결정해주는 어노테이션
    @Rollback(value = false)
    public void testMember(){
        //given
        Member member = new Member();
        member.setUsername("김윤서");

        //when
        Long savedId = memberRepository.save(member);       //저장한 회원 id
        Member findMember = memberRepository.find(savedId); //저장후 재조회

        //then
        assertThat(member.getId(), is(equalTo(findMember.getId())));
        assertThat(member.getUsername(), is(equalTo(findMember.getUsername())));
    }
    
}