drop table Product if exists;

create table Product(Id serial, Name varchar(5), Price bigint not null)