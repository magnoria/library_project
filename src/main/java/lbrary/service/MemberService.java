package lbrary.service;


import lbrary.model.dto.MemberDto;
import lbrary.model.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class MemberService {
    @Autowired private MemberMapper memberMapper;

    // 1. 대여자 등록

    public boolean addmember(MemberDto memberDto){
        System.out.println("MemberController.addmember");
        System.out.println("memberDto = " + memberDto);

        return memberMapper.addmember(memberDto);
    }

    // 2. 전체리스트

    public List<MemberDto> findAll(){
        System.out.println("MemberController.findAll");

        return memberMapper.findAll();
    }

    //3. 단일 대여자 확인

    public MemberDto find(int mno ){
        System.out.println("MemberController.find");
        System.out.println("mno = " + mno);

        return memberMapper.find(mno);
    }

    //4. 대여자 수정

    public boolean update( MemberDto memberDto){
        System.out.println("MemberController.update");
        System.out.println("memberDto = " + memberDto);

        return memberMapper.update(memberDto);
    }

    //5. 대여자 삭제
    @DeleteMapping("")
    public boolean delete(@RequestParam("mno") int mno){
        System.out.println("MemberController.delete");
        System.out.println("mno = " + mno);

        return memberMapper.delete(mno);
    }



}
