package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest{

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트가 끝날 떄마가 repository를 깔끔하게 지워주는 함수
    @AfterEach
    public void afterEach(){
        repository.clearStore(); // 저장소를 지움
    }

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


    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("Spring3");
        repository.save(member3);

        List<Member> result = repository.findAll();

        for(int i=0;i<3;i++){
            System.out.println(result.get(i).getId()+" : "+result.get(i).getName());
        }
    }

    @Test
    public void mm(){
        Member m1 = new Member();
        m1.setName("JungSu1");

        Member m2 = new Member();
        m2.setName("JungSu2");

        Member m3 = new Member();
        m3.setName("JungSu3");

        repository.save(m1);
        repository.save(m2);
        repository.save(m3);

        //System.out.println(repository.findAll());
        List<Member> li = repository.findAll();
        for(int i=0;i<li.size();i++){
            System.out.println(li.get(i).getName());
        }

        for(Member m : repository.findAll()){
            System.out.println(m.getId() + " " +m.getName() );
        }
    }
}
