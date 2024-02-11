select @@autocommit=0;

select * from film
where film_id =10;

/* 
 * transaction types
 * 
 * Read Uncommited - > Read latest data commited /Uncommited from all the sessions
 */ 
show variables like 'transaction_isolation';

set session transaction isolation level  read uncommitted ;

update film 
set title='Animal-3'
where film_id =10;

use sakila;
create index idx_film_title_release_year
on film(title, release_year);

select * from film f ;

select * from film f 
where title='ADAPTATION HOLES';

explain analyze select * from film f 
where title='ADAPTATION HOLES';

-- Index lookup on f using idx_title 
-- (title='ADAPTATION HOLES')  (cost=0.35 rows=1) 
-- (actual time=0.0776..0.0857 rows=1 loops=1)

-- drop index idx_film_title_release_year on film;

-- -> Index lookup on f using idx_title
--  (title='ADAPTATION HOLES')  (cost=0.35 rows=1) 
 -- (actual time=0.0673..0.0763 rows=1 loops=1)

 drop index idx_title on film;

-- -> Filter: (f.title = 'ADAPTATION HOLES')  (cost=103 rows=100) 
-- (actual time=0.0801..6.81 rows=1 loops=1)
-- -> Table scan on f  (cost=103 rows=1000) (actual time=0.0585..6.34 rows=1000 loops=1)

-- -> Index lookup on f using idx_film_title_release_year 
-- (title='ADAPTATION HOLES')  (cost=0.35 rows=1)
-- (actual time=0.0694..0.0778 rows=1 loops=1)

create index idx_film_title on film(title(7));

--- > Filter: (f.title = 'ADAPTATION HOLES')  (cost=0.35 rows=1) (actual time=0.0637..0.0747 rows=1 loops=1)
--    -> Index lookup on f using idx_film_title (title='ADAPTATION HOLES') 
-- (cost=0.35 rows=1) (actual time=0.0602..0.071 rows=1 loops=1)



/*
ACID properties
a transaction may or may not always have a ACID properties

A- Atomicity
C- Consistency
I- Isolation 
D- Durability

Atomicity :
Indivisible Unit
everything should happen or nothing should happen


Consistency: 
Consistency is something that might be expected but not always
it depends on use case
whatever happens should be accurate

Isolation:
One transaction should not affects the other transactions 

Durability:
Once the transaction is completed we would want its work to be persisted

*/

/* *
 * Transactions 
 * commits 
 * rollback
 * 
 * 
 * 
 * 
 * */
select @@autocommit=0;

show variables like 'transaction_isolation';

set autocommit=0;

select * from film
where film_id =10;

update film 
set title='Animal-2'
where film_id =10;

select * from film
where film_id =10;

-- rollback;





select @@autocommit=0;

select * from film
where film_id =10;

/* 
 * transaction types
 * 
 * Read Uncommited - > Read latest data commited /Uncommited from all the sessions
 */ 
show variables like 'transaction_isolation';

set session transaction isolation level  read uncommitted ;

update film 
set title='Animal-3'
where film_id =10;

show variables like 'transaction_isolation';

set autocommit=1;

select * from film
where film_id =10;

update film 
set title='Animal1'
where film_id =10;

