insert into library (id, name) values (1, '1Biblia');
insert into library (id, name) values (2, 'Biblia2');

insert into book (id, title, library) values (1, 'Pierwsza książka',1);
insert into book (id, title, library) values (2, 'Druga książka',1);
insert into book (id, title, library) values (3, 'Trzecia książka',2);
insert into book (id, title, library) values (4, 'Czwarta książka',2);

insert into author (id, first_name, last_name) values (7, 'Jan', 'Kowalski');
insert into author (id, first_name, last_name) values (8, 'Zbigniew', 'Nowak');
insert into author (id, first_name, last_name) values (9, 'Janusz', 'Jankowski');


insert into book_author(book_id, author_id) values (1, 7);
insert into book_author(book_id, author_id) values (2, 8);
insert into book_author(book_id, author_id) values (3, 7);
insert into book_author(book_id, author_id) values (4, 7);


