package lbrary.model.dto;


import lombok.*;

@Getter@Setter@ToString
@AllArgsConstructor@NoArgsConstructor
public class BookDto {

    private int bno;
    private String btitle;
    private String writer;
    private String publisher;;
    private int stock;


}
