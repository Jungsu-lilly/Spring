package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest{

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @Test
    public void save(){
        Member member = new Member();
        member.setName("Jung-Su");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // Optional 에서 get으로 값을 꺼낼 수 있다.

        // System.out.println("result = "+(result==member) );
        // Assertions.assertEquals(member, result);

        assertThat(member).isEqualTo(result);
    }


    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring1").get();

        assertThat(result).isEqualTo(member1);
    }
}
