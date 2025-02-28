package lbrary.service;


import lbrary.model.dto.BookDto;
import lbrary.model.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookMapper bookMapper;

    //(1) 등록

    public boolean addbook( BookDto bookDto){
        System.out.println("BookController.addbook");
        System.out.println("bookDto = " + bookDto);

        return bookMapper.addbook(bookDto);
    }

    //(2) 전체리스트 보기

    public List<BookDto> findAll(){
        System.out.println("BookController.findAll");

        return  bookMapper.findAll();
    }

    //(3) 단일 도서 보기

    public BookDto find( int bno){
        System.out.println("BookController.find");
        System.out.println("bno = " + bno);



        return  bookMapper.find(bno);
    }


    //(4) 도서 수정

    public boolean update( BookDto bookDto){
        System.out.println("BookController.update");
        System.out.println("bookDto = " + bookDto);

        return bookMapper.update(bookDto);
    }

    //(5) 도서 삭제
    public boolean delete( int bno){
        System.out.println("BookController.delete");
        System.out.println("bno = " + bno);

        return bookMapper.delete(bno);

    }



}
