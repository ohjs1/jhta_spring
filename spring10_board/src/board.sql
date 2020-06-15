-- board.sql
drop table board;
drop sequence board_seq;
create table board
(
	num number(7) primary key,
	writer varchar2(20),
	title varchar2(20),
	content clob,
	hit number(5),
	regdate date
);
create sequence board_Seq;





