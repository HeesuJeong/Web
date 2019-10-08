create database fooddb;
use fooddb;

create table food (
   code int primary key,
   name varchar(30),
   maker varchar(30),
   material varchar(600),
   image varchar(50),
   supportpereat varchar(30),
   calory varchar(30),
   carbo varchar(30),
   protein varchar(30),
   fat varchar(30),
   sugar varchar(30),
   natrium varchar(30),
   chole varchar(30),
   fattyacid varchar(30),
   transfat varchar(30)
);
select*from food;
drop table food;

create table memtb(
id varchar(20) primary key,
pw varchar(20),
name varchar(20),
addr varchar(200),
email varchar(50),
tel varchar(50),
alinfo varchar(500)
);

insert into members values('김현정', 'ssafy', '1234', 'abcd@ssafy', '010-1111-2222', 10);
select*from memtb;
drop table memtb;

