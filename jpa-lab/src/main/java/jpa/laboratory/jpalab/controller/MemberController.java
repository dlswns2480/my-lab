package jpa.laboratory.jpalab.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jpa.laboratory.jpalab.domain.Member;
import jpa.laboratory.jpalab.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @Operation(summary = "회원 조회 요청", description = "멤버십을 통해 회원 정보를 조회합니다.", tags = { "MemberController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "회원 조회 성공",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근",
                    content = @Content(mediaType = "application/json")),

    })
    @GetMapping("/{email}")
    public ResponseEntity<Optional<Member>> findByEmail(@PathVariable String email) {
        Optional<Member> member = memberService.findByEmail(email);
        return new ResponseEntity<Optional<Member>>(member, HttpStatus.OK);
    }
    @Operation(summary = "회원 생성 요청", description = "회원 정보가 생성됩니다.", tags = { "MemberController" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "회원 정보 생성 성공",
                    content = @Content(mediaType = "application/json")),
            @ApiResponse(responseCode = "404", description = "존재하지 않는 리소스 접근",
                    content = @Content(mediaType = "application/json")), //usereturntype

    })
    @PostMapping("/create")
    public ResponseEntity<Member> create(){
        Member member = Member.builder().name("pokari")
                .email("123@naver.com").build();
        return new ResponseEntity<Member>(memberService.save(member), HttpStatus.OK);
    }
}
