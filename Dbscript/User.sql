create table user (user_id int   not null,primary key(user_id), firstname varchar(45), lastname varchar(50) , email varchar(20)); 

create table roles (role_id int not null, foreign key(role_id) references user (user_id) , rolename varchar(60));

create table leavestatus (emp_id int not null,  emp_name varchar(45), fromdate date, todate date,Leavebalance varchar(50), status varchar(50) ); 

create table feedback (full_name varchar(45), email varchar(50),contact int, message varchar(50) ); 
