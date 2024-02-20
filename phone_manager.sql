create database phone_manager;
use phone_manager;
create table phone(
id int auto_increment primary key,
name varchar(255),
price int,
img varchar(255),
phone_categoryid int,
description varchar(255));
drop table phone;
create table phone_category(id int primary key auto_increment,
name varchar(255));
alter table phone add foreign key (phone_categoryid) references phone_category(id);
create table user(
id int primary key auto_increment,
name varchar(255),
phone_number int,
address varchar(255));
create table orders(
id int primary key auto_increment,
user_id int,
date date,
foreign key (user_id) references user(id));

create table order_detail(
id int primary key auto_increment,
order_id int,
phone_id int,
quantity int,
foreign key (phone_id) references phone(id),
foreign key (order_id) references orders(id));


insert into phone_category(name) values('Iphone'),('Samsung'),('Oppo');
insert into phone(name,price,img,phone_categoryid,description) 
values ('iphone 12',13000000,'..\img\ip12.jpg',1,'iphone 12 promax'),
('iphone 15',33000000,'..\img\ip15.jpg',1,'iphone 15 promax');
insert into user(name,phone_number,address) values ('Tran Thanh Hai',0967548599,'HN'),('Nguyen Van A',01239485731,'SG');
insert into orders(user_id,date) values(1,'2024-01-01'),(2,'2024-02-01');
insert into order_detail(order_id,phone_id,quantity) values (1,1,1),(1,2,3),(2,2,1);

select * from phone_category;
select * from phone;
select * from user;
select * from orders;
select * from order_detail;