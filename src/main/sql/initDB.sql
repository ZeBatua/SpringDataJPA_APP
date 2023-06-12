CREATE TABLE Person (
    id int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name varchar(100) NOT NULL,
    age int CHECK (age >= 18),
    email varchar(200) NOT NULL UNIQUE,
    date_of_birth DATE,
    created_at TIMESTAMP
);

insert into Person(name, age, email, date_of_birth) values ('test1', 21, 'test1@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test2', 22, 'test2@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test3', 23, 'test3@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test4', 24, 'test4@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test5', 25, 'test5@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test6', 26, 'test6@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test7', 27, 'test7@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test8', 28, 'test8@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test9', 29, 'test9@mail.com', '01/01/2000');
insert into Person(name, age, email, date_of_birth) values ('test10', 30, 'test10@mail.com', '01/01/2000');

