package lbrary.model.mapper;

import lbrary.model.dto.MemberDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    //1. 대여자 등록
    @Insert("insert into member ( mname , mphone, maddress, mbook) values ( #{mname} , #{mphone}, #{maddress} , #{mbook})")
    public boolean addmember(MemberDto memberDto);

    //2. 전체리스트
    @Select("select * from member")
    public List<MemberDto> findAll();

    //3. 단일 대여자 확인
    @Select("select * from member where mno = #{mno}")
    public MemberDto find(int mno );

    //4. 대여자 수정
    @Update("update member set mname = #{mname} , mphone = #{mphone} , maddress = #{maddress} , mbook = #{mbook} where mno = #{mno} ")
    boolean update(MemberDto memberDto);

    //5. 대여자 삭제
    @Delete("delete from member where mno = #{mno}")
    public boolean delete(int mno);


}
