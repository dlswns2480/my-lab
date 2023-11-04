package jpa.laboratory.jpalab.service;

import jpa.laboratory.jpalab.domain.Member;
import jpa.laboratory.jpalab.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;

    public Optional<Member> findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public Member save(Member member){
        return memberRepository.save(member);
    }
}
