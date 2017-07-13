create table if not exists person(
  id int auto_increment primary key, 
  firstname text, lastname text not null, 
  birthdate long not null, 
  email text not null
);

insert into person (firstname, lastname, birthdate, email) values ('Jarno', 'Walgemoed', 329097600, 'email@mailserver.com');
insert into person (firstname, lastname, birthdate, email) values ('Some', 'Guy', 329097600, 'email@mailserver.com');
insert into person (firstname, lastname, birthdate, email) values ('New', 'Dude', 329097600, 'email@mailserver.com');
insert into person (firstname, lastname, birthdate, email) values ('Another', 'Dude', 329097600, 'email@mailserver.com');