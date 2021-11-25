package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    /* 멤버 저장 */
    Member save(Member member);

    /* ID로 멤버 찾기*/
    Optional<Member> findById(Long id);

    /* 이름으로 멤버 찾기 */
    Optional<Member> findByName(String name);

    /* 전부 출력 */
    List<Member> findAll();

}