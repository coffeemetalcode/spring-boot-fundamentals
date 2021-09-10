CREATE DATABASE spring_boot_books;

use spring_boot_books;

CREATE TABLE books(
    title varchar(50),
    id varchar(50), -- set up a UUID auto generator for this?
    isbn varchar(50),
    aisle int,
    author varchar(50),PRIMARY KEY (id));


INSERT INTO books(title,id,isbn,aisle,author) values("Appium","fdsefr343","fdsefr3","43","Rahul Shetty");

select * from books where id = 'fdsefr343'