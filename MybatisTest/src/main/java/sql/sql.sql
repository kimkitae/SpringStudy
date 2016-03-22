create table testtable(
	name varchar2(10) primary key,
	email varchar2(100),
	phone varchar2(11)
);

insert into testtable 
values ('1','thosit@naee.com','01044472343');

insert into testtable 
values ('2','qewdq@naee.com','1234654');

insert into testtable 
values ('3','thosit@naee.com','01044472343');


drop table testtable;