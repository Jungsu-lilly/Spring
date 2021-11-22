package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    /* 회원가입 메뉴 */
    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

   //   System.out.println("member : "+form.getName());
        memberService.join(member);

        return "redirect:/"; // 회원 가입이 끝났으니 홈 화면으로 돌려보내는 것.
    }

    @GetMapping("/members")
    public String list(Model model){

        List<Member> members = memberService.findMembers(); // 모든 멤버 조회
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
