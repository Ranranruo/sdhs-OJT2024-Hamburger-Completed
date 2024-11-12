show databases;
create database hamburger;
use hamburger;

drop table hamburger;

create table hamburger(
                          name varchar(50) primary key not null,
                          price int not null,
                          image_path varchar(300) not null,
                          is_new bool not null,
                          is_recommended bool not null
);

commit;

select * from hamburger;

select * from hamburger where image_path like '%더블%';
select * from hamburger h1 inner join hamburger h2 on h1.price = h2.price where h1.price - h2.price < 1000;
select * from hamburger h1 inner join hamburger h2 on h1.name = h2.name where h1.price - h2.price between 0 and 1000 or h2.price - h1.price between 0 and 1000 order by h1.price, h1.name, h2.price, h2.name;

INSERT INTO hamburger(name, price, image_path, is_new, is_recommended) VALUES("통새우크런KIM버거", 7700, "/images/통새우크런KIM버거.png", false, false),
                                                                             ("불고기포텐버거", 7700, "/images/불고기포텐버거.png", false, false),
                                                                             ("전주 비빔라이스 버거", 6900, "/images/전주 비빔라이스 버거.png", false, false),
                                                                             ("리아 새우 베이컨", 5900, "/images/리아 새우 베이컨.png", false, false),
                                                                             ("리아 불고기 베이컨", 5900, "/images/리아 불고기 베이컨.png", false, false),
                                                                             ("더블 한우불고기버거", 12600, "/images/더블 한우불고기버거.png", false, false),
                                                                             ("한우불고기버거", 8600, "/images/한우불고기버거.png", false, false),
                                                                             ("더블 클래식치즈버거(버터번)", 7000, "/images/더블 클래식치즈버거(버터번).png", false, false),
                                                                             ("더블 치킨버거", 5600, "/images/더블 치킨버거.png", false, false),
                                                                             ("더블 데리버거", 4700, "/images/더블 데리버거.png", false, false),
                                                                             ("리아 불고기 더블(빅불)", 7300, "/images/리아 불고기 더블(빅불).png", false, false),
                                                                             ("리아 불고기", 4800, "/images/리아 불고기.png", false, false),
                                                                             ("모짜렐라 인 더 버거 베이컨", 7600, "/images/모짜렐라 인 더 버거 베이컨.png", false, false),
                                                                             ("더블엑스투버거", 6900, "/images/더블엑스투버거.png", false, false),
                                                                             ("리아 사각새우 더블", 5900, "/images/리아 사각새우 더블.png", false, false),
                                                                             ("리아 새우", 4800, "/images/리아 새우.png", false, false),
                                                                             ("미라클버거", 5300, "/images/미라클버거.png", false, false),
                                                                             ("더블 미라클버거", 6800, "/images/더블 미라클버거.png", false, false),
                                                                             ("핫크리스피치킨버거", 6000, "/images/핫크리스피치킨버거.png", false, false),
                                                                             ("클래식치즈버거(버터번)", 5300, "/images/클래식치즈버거(버터번).png", false, false),
                                                                             ("티렉스버거", 4800, "/images/티렉스버거.png", false, false),
                                                                             ("치킨버거", 4100, "/images/치킨버거.png", false, false),
                                                                             ("데리버거", 3500, "/images/데리버거.png", false, false),
                                                                             ("한우연인팩", 16000, "/images/한우연인팩.png", false, false),
                                                                             ("한우명품팩", 17800, "/images/한우명품팩.png", false, false);

create table history (
                         name varchar(50) not null,
                         price int not null,
                         date varchar(10) not null
);

insert into history (name, price, date) values('치킨버거', '4100', '2024-11-4');
insert into history (name, price, date) values('데리버거', '4100', '2024-11-4');

select * from hamburger;
select * from history;

select * from hamburger ha inner join history hi on ha.name = hi.name;
select * from hamburger ha right join history hi on ha.name = hi.name;


select * from history;

drop table login;
create table login (
                       login_id varchar(20) primary key not null,
                       login_password varchar(10) not null
);