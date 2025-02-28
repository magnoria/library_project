drop database library;

create database library;

use library;

create table book(
	bno int auto_increment,
    btitle varchar(50),
    writer varchar(10),
    publisher varchar(10),
    stock int default 0,
    
   constraint primary key(bno)
);

insert into book values (null , '천사와악마' , '레오나르도' , '한마음출판사' , 5 );
insert into book values (null , '셜록' , '코난도일' , '한마음출판사' , 4 );
insert into book values (null , '연금술사' , '미정' , '하늘출판사' , 5 );



select * from book;

create table member(
	mno  int auto_increment,   
mname    varchar(30),
mphone   varchar(30),
maddress  varchar (30),
mbook  varchar(20) not null,

constraint primary key(mno)

);

insert into member values ( null ,'유재석' , '010-3333-2222', '인천 부평구' , '천사와악마');
insert into member values ( null , '강호동' , '010-3223-2222', '인천 남동구' , '천사와악마');
insert into member values ( null , '김하늘' , '010-3333-2222', '인천 낭동구' , '셜록');

select * from member;