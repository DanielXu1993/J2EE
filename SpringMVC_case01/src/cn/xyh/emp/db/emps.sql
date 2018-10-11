drop  table emps;
create table emps(
  id varchar2(40) primary key,
  username varchar2(10) not null ,
  salary number(10,2) not null,
  hiredate date not null
)
