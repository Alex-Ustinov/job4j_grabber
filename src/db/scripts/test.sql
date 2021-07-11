insert into company (id, name) values(1, 'dell');
insert into company (id, name) values(2, 'lenovo');
insert into company (id, name) values(3, 'apple');
insert into company (id, name) values(4, 'asus');
insert into company (id, name) values(5, 'ibm');
insert into company (id, name) values(6, 'samsung');

insert into person (id, name, company_id) values(1, 'alex', 1);
insert into person (id, name, company_id) values(2, 'tom', 2);
insert into person (id, name, company_id) values(3, 'sam', 2);
insert into person (id, name, company_id) values(4, 'jime', 3);
insert into person (id, name, company_id) values(5, 'tom', 4);
insert into person (id, name, company_id) values(6, 'alef', 4);
insert into person (id, name, company_id) values(7, 'pole', 5);
insert into person (id, name, company_id) values(8, 'casy', 6);

select * from person as p inner join company as c on c.id = p.company_id where p.company_id !=5
select * from person as p where p.company_id !=5
select c.name, count(c.name) as amount from person as p inner join company as c on c.id = p.company_id group by c.name order by amount desc limit 1