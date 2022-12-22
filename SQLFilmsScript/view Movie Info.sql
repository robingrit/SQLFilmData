use films;

DROP VIEW if exists view_movie_info;
create or replace view view_movie_info as
select title, genre
from films
join moviegenres on films.film_id = moviegenres.film_id
join genre on moviegenres.genre_id = genre.genre_id
ORDER BY films.film_id;