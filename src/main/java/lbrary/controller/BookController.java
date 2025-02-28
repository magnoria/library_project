package lbrary.controller;


import lbrary.model.dto.BookDto;
import lbrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired private BookService bookService;

    //(1) 등록
    @PostMapping("")
    public boolean addbook(@RequestBody BookDto bookDto){
        System.out.println("BookController.addbook");
        System.out.println("bookDto = " + bookDto);

        return bookService.addbook(bookDto);
    }

    //(2) 전체리스트 보기
    @GetMapping("")
    public List<BookDto> findAll(){
        System.out.println("BookController.findAll");

        return  bookService.findAll();
    }

    //(3) 단일 도서 보기
    @GetMapping("/view")
    public BookDto find(@RequestParam("bno") int bno){
        System.out.println("BookController.find");
        System.out.println("bno = " + bno);



        return  bookService.find(bno);
    }


    //(4) 수정
    @PutMapping("") //{"bno" : "2 " ,"btitle" :"그리고아무" , "writer":"아가사" , "publisher" : "한마음" , "stock" : "3" }
    public boolean update(@RequestBody BookDto bookDto){
        System.out.println("BookController.update");
        System.out.println("bookDto = " + bookDto);

        return bookService.update(bookDto);
    }

    //(5) 도서삭제
    @DeleteMapping("")
    public boolean delete(@RequestParam("bno") int bno){
        System.out.println("BookController.delete");
        System.out.println("bno = " + bno);

        return bookService.delete(bno);

    }



}// class end
