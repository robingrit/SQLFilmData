use films;

DROP VIEW if exists view_general_info;
create or replace view view_general_info as
select director_name as "director name", title as "film", actor_name as "actor", actor_age as "age"
FROM films
JOIN actor ON films.film_id = actor.actor_id
JOIN director ON films.film_id = director.director_id;