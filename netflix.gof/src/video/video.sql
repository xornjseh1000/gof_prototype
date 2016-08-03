----------------------- actor -----------------------(배우 CRUD등록읽기수정삭제용)
create sequence actor_seq
start with 1;
	 select * from member; 
create table actor(
	actor_no int primary key,
	kor_name varchar2(30),
	eng_name varchar2(30),
	profile_img varchar2(100)
)
delete from member where email = 'aa';
----------------------- member -----------------------회원
select * from member;
create table member(
	email varchar2(50) primary key,
	name varchar2(30),
	password varchar2(30) not null,
	phone varchar2(15),
	reg_date date,
	grade number(1),
	birth varchar2(6),
	prof_img varchar2(100),
	card_num varchar2(20),
	email_sv varchar2(1),
	fav varchar2(50),
	constraint CHECK_MEMBER_EMAIL_SV CHECK (email_sv in ('Y','N')),
	constraint FK_MEMBER_GRADE foreign key(grade)
	references member_grade(grade) on delete cascade
)

--------------------- member grade -----------------
create table member_grade(
	grade number(1) primary key
)
insert into member_grade values(1); -- basic grade
insert into member_grade values(2); -- special grade
----------------------- Video -----------------------비됴
create sequence serial_seq
start with 1001;

create table video(
	serial_no int primary key,
	title varchar2(50),
	sub_title varchar2(100),
	create_year varchar2(10),
	synops varchar2(300),
	running_time varchar2(10),
	file_url varchar2(100),
	language varchar2(20),
	reg_date varchar2(20),
	poster varchar2(100)
)



----------------------- producer  -----------------------비디오 쪼개는 중
create sequence producer_seq;

create table producer(
	producer_no int primary key,
	kor_name varchar2(30),
	eng_name varchar2(30),
	profile_img varchar2(100)	
)

----------------------- producing  -----------------------

create table producing(
	producer_no int,
	serial_no int,
	constraint PK_PRODUCING_PS primary key(producer_no,serial_no),
	constraint FK_PRODUCING_PRODUCER_NO foreign key(producer_no)
	references producer(producer_no) on delete cascade,
	constraint FK_PRODUCING_SERIAL_NO foreign key(serial_no)
	references video(serial_no) on delete cascade
)
----------------------- category  -----------------------
create table category(
	category number(2) primary key
)
insert into category values(1);
insert into category values(2);
insert into category values(3);
insert into category values(4);
insert into category values(5);



create table category_video(
	category number(2),
	serial_no int,
	constraint PK_CATEGORY_VIDEO_CS primary key(category,serial_no),
	constraint FK_CATEGORY_VIDEO_CN foreign key(category)
	references category(category) on delete cascade,
	constraint FK_CATEGORY_VIDEO_SERIAL_NO foreign key(serial_no)
	references video(serial_no) on delete cascade
)
----------------------- genre  -----------------------

create table genre(
	genre number(2) primary key
)
insert into genre values(1);
insert into genre values(2);
insert into genre values(3);
insert into genre values(4);
insert into genre values(5);

create table genre_video(
	genre number(2),
	serial_no int,
	constraint PK_GENRE_VIDEO_GS primary key(genre,serial_no),
	constraint FK_GENRE_VIDEO_GENRE foreign key(genre)
	references genre(GENRE) on delete cascade,
	constraint FK_GENRE_VIDEO_SERIAL_NO foreign key(serial_no)
	references video(serial_no) on delete cascade
)
----------------------- group no  -----------------------


create table group_no(
	group_no number(3),
	serial_no int,
	constraint PK_GROUP_NO_GS primary key(group_no,serial_no),
	constraint FK_GROUP_NO_SN foreign key(serial_no)
	references video(serial_no) on delete cascade
)
----------------------- grade  -----------------------

create table grade(
	grade number(2) primary key
)

create table grade_video(
	grade number(2),
	serial_no int,
	constraint PK_GRADE_VIDEO_GS primary key(grade,serial_no),
	constraint FK_GRADE_VIDEO_GRADE foreign key(grade)
	references grade(grade) on delete cascade,
	constraint FK_GRADE_VIDEO_SN foreign key(serial_no)
	references video(serial_no) on delete cascade
)
----------------------- season,episode -----------------------
create table SERIES(
	serial_no int primary key,
	season number(2),
	episode number(3),
	constraint FK_DRAMA_SN foreign key(serial_no)
	references video(serial_no) on delete cascade
)
----------------------- appearance -----------------------배우가 출연한 영화 같은거 구할떄 사용, 출연 테이블 

create table appearance(
	actor_no int,
	serial_no int,
	constraint PK_APPEARANCE_ES primary key(actor_no,serial_no),
	constraint FK_APPEARANCE_ACTOR_NO foreign key(actor_no)
	references actor(actor_no) on delete cascade,
	constraint FK_APPEARANCE_SERIAL_NO foreign key(serial_no)
	references video(serial_no) on delete cascade
)


----------------------- Customer ----------------------- 고객센터 q&a
	
create sequence customer_seq
start with 1;

create table customer_center(
	customer_seq int primary key,
	category varchar2(10),
	title varchar2(100),
	content clob
)
----------------------- Payment ----------------------- 결제 정보
create sequence pay_seq
start with 1;

create table payment(
	pay_seq int primary key,
	card_num varchar2(20),
	price int,
	company varchar2(15),
	pay_date date,
	expire_date date
)
----------------------- gpa -----------------------grade point average 영화 평점 테이블

create table gpa(
	email varchar2(50),
	serial_no int,
	point int,
	constraint PK_GPA_ES primary key(email,serial_no),
	constraint FK_GPA_EMAIL foreign key(email)
	references member(email) on delete cascade,
	constraint FK_GPA_SERIAL_NO foreign key(serial_no)
	references video(serial_no) on delete cascade
)
----------------------- stats ----------------------- 통계용 테이블 현재는 본 날짜만 기록 

create table stats(
	email varchar2(50),
	serial_no int,
	view_date date,
	constraint PK_STATS_ES primary key(email,serial_no),
	constraint FK_STATS_EMAIL foreign key(email)
	references member(email) on delete cascade,
	constraint FK_STATS_SERIAL_NO foreign key(serial_no)
	references video(serial_no) on delete cascade
)

----------------------- bookmark -----------------------
create table bookmark(
	email varchar2(50),
	serial_no int,
	constraint PK_BOOKMARK_ES primary key(email,serial_no),
	constraint FK_BOOKMAKR_EMAIL foreign key(email)
	references member(email) on delete cascade,
	constraint FK_BOOKMARK_SERIAL_NO foreign key(serial_no)
	references video(serial_no) on delete cascade
)
select * from video;
delete  from video;

create view video_detail
as
select SERIAL_NO,TITLE,SUB_TITLE,CREATE_YEAR,RUNNING_TIME,FILE_URL,LANGUAGE,REG_DATE,POSTER,SYNOPS,PRODUCER_NO,CATEGORY,GENRE,GROUP_NO,GRADE,SEASON,EPISODE from video join producing using(serial_no) join category_video using(serial_no)
join genre_video using(serial_no) join group_no using(serial_no) join grade_video using(serial_no) left outer join series using(serial_no)


drop view video_detail;

select * from video_detail;


select * from member;
delete from member;

insert into bookmark values('2hwooo@naver.com',1010);

select * from bookmark;

insert into stats values('2hwooo@naver.com',1011,sysdate);

SELECT SERIAL_NO FROM (
SELECT SERIAL_NO, CNT, RANK() OVER(ORDER BY CNT DESC) AS RK FROM (SELECT SERIAL_NO,COUNT(*) CNT FROM STATS GROUP BY SERIAL_NO))
WHERE RK < 10;


select * from video_detail where genre=5 OR genre=0 or genre = 3;