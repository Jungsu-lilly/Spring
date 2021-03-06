package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

/*
* 저장소룰 local 하게 만듬. memberRepository 인터페이스*/
public class MemoryMemberRepository implements MemberRepository{

    // members 객체 저장하는 공간.
    private static Map<Long, Member> store = new HashMap<>();

    // id
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);

        // K : member id, V : member
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

   public void clearStore(){
        store.clear();
   }

    public void printStore(){
        for(Member m : store.values()){
            System.out.println(m.getId() +" " + m.getName());
        }
    }
}
