package lbrary.model.mapper;

import lbrary.model.dto.BookDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {


    //(1) 등록
    @Insert("insert into book( btitle, writer, publisher, stock ) values (  #{btitle} , #{writer}, #{publisher} , #{stock})")
    public boolean addbook( BookDto bookDto);

    //(2) 전체리스트 보기
    @Select(" select * from book")
    public List<BookDto> findAll();


    //(3) 단일 도서 보기
    @Select(" select * from book where bno = #{bno}")
    public BookDto find( int bno);


    //(4) 도서 수정
    @Update("update book set btitle = #{btitle} , writer = #{writer} , publisher = #{publisher}, stock = #{stock} where bno = #{bno}")
    public boolean update( BookDto bookDto);


    //(5) 도서 삭제
    @Delete("delete from book where bno = #{bno}")
    public boolean delete( int bno);




}
