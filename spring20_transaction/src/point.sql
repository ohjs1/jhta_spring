drop table points_seq;
create table points(
	pnum number(5) primary key,
	num number(5) references members(num),
	point number(6),
	regdate date
);
create sequnce points_seq;