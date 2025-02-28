package lbrary.controller;

import lbrary.model.dto.MemberDto;
import lbrary.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired private MemberService memberService;

    // 1. 대여자 등록
    @PostMapping("")
    public boolean addmember(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.addmember");
        System.out.println("memberDto = " + memberDto);

        return memberService.addmember(memberDto);
    }

    // 2. 전체리스트
    @GetMapping("")
    public List<MemberDto> findAll(){
        System.out.println("MemberController.findAll");

        return memberService.findAll();
    }

    //3. 단일 대여자 확인
    @GetMapping("/view")
    public MemberDto find(@RequestParam("mno") int mno ){
        System.out.println("MemberController.find");
        System.out.println("mno = " + mno);

        return memberService.find(mno);
    }

    //4. 대여자 수정
    @PutMapping("")
    public boolean update(@RequestBody MemberDto memberDto){
        System.out.println("MemberController.update");
        System.out.println("memberDto = " + memberDto);
        boolean result = memberService.update(memberDto);
        System.out.println(result);
        return result;
    }

    //5. 대여자 삭제
    @DeleteMapping("")
    public boolean delete(@RequestParam("mno") int mno){
        System.out.println("MemberController.delete");
        System.out.println("mno = " + mno);

        return memberService.delete(mno);
    }

}
