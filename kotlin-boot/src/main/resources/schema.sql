create table if not exists person(id int auto_increment primary key, firstname text, lastname text, birthdate long);

insert into person (firstname, lastname, birthdate) values ('Jarno', 'Walgemoed', 23123123123);