package jpa.laboratory.jpalab.controller;

import jpa.laboratory.jpalab.domain.Member;
import jpa.laboratory.jpalab.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/jpa-lab")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{email}")
    public ResponseEntity<Optional<Member>> findByEmail(@PathVariable String email) {
        Optional<Member> member = memberService.findByEmail(email);
        return new ResponseEntity<Optional<Member>>(member, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Member> create(){
        Member member = new Member();
        member.setName("injun");
        member.setEmail("123@gmail.com");
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
    }
}
