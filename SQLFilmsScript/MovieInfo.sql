use films;

-- adding directors
insert into director (director_name, town_name, director_age) VALUES ('Gore Verbinski', 'Oak Ridge', "58");
insert into director (director_name, town_name, director_age) VALUES ('Frank Darabont', 'Montbeliard', "63");
insert into director (director_name, town_name, director_age) VALUES ('Francis Ford Coppola', 'Detroit', "83");
insert into director (director_name, town_name, director_age) VALUES ('Quentin Tarantino', 'Knoxville', "59");
insert into director (director_name, town_name, director_age) VALUES ('Robert Zemeckis', 'Chicago', "70");
insert into director (director_name, town_name, director_age)VALUES ('Christopher Nolan', 'London', "52");
insert into director (director_name, town_name, director_age) VALUES ('Jonathan Demme', 'Long Island', "73");
insert into director (director_name, town_name, director_age) VALUES ('Sam Raimi', 'Royal Oak', "63");
insert into director (director_name, town_name, director_age) VALUES ('Brian De Palma', 'Newark', "82");
insert into director (director_name, town_name, director_age) VALUES ('Peter Jackson', 'Pukerua Bay', "61");
insert into director (director_name, town_name, director_age) VALUES ('Chris Columbus', 'Spangler', "64");

-- adding genres
insert into genre (genre) VALUES ('Crime');
insert into genre (genre) VALUES ('Documentary');
insert into genre (genre) VALUES ('Romance');
insert into genre (genre) VALUES ('Drama');
insert into genre (genre) VALUES ('Adventure');
insert into genre (genre) VALUES ('Action');
insert into genre (genre) VALUES ('Fantasy');

-- adding years
insert into releasedate (releasedate) VALUES ('1994');
insert into releasedate (releasedate) VALUES ('2003');
insert into releasedate (releasedate) VALUES ('1974');
insert into releasedate (releasedate) VALUES ('2009');
insert into releasedate (releasedate) VALUES ('2010');
insert into releasedate (releasedate) VALUES ('1991');
insert into releasedate (releasedate) VALUES ('2002');
insert into releasedate (releasedate) VALUES ('1983');
insert into releasedate (releasedate) VALUES ('2001');


-- adding Films
insert into films (title, director_id, releasedate_id) values ('The Shawshank Redemption', 2, 1);
insert into films (title, director_id, releasedate_id) values ('Pirates of the Caribbean: The Curse of the Black Pearl', 1, 2);
insert into films (title, director_id, releasedate_id) values ('Avatar', 1, 3);
insert into films (title, director_id, releasedate_id) values ('The Godfather', 3, 2);
insert into films (title, director_id, releasedate_id) VALUES ('Pulp Fiction', 4, 1);
insert into films (title, director_id, releasedate_id) VALUES ('Forrest Gump', 5, 1);
insert into films (title, director_id, releasedate_id) VALUES ('Inception', 6, 4);
insert into films (title, director_id, releasedate_id) VALUES ('The silence of the lambs', 7, 4);
insert into films (title, director_id, releasedate_id) VALUES ('Spider-man',8 , 6);
insert into films (title, director_id, releasedate_id) VALUES ('Scarface', 9, 7);
insert into films (title, director_id, releasedate_id) VALUES ('Lord of the Rings', 10, 8);
insert into films (title, director_id, releasedate_id) VALUES ('harry potter and the philosopher\'s stone', 11, 9);

-- adding genres to movies
insert into moviegenres (film_id, genre_id) VALUES (1, 4);
insert into moviegenres (film_id, genre_id) VALUES (2, 6);
insert into moviegenres (film_id, genre_id) VALUES (2, 5);
insert into moviegenres (film_id, genre_id) VALUES (3, 1);
insert into moviegenres (film_id, genre_id) VALUES (3, 4);
insert into moviegenres (film_id, genre_id) VALUES (4, 1);
insert into moviegenres (film_id, genre_id) VALUES (4, 4);
insert into moviegenres (film_id, genre_id) VALUES (5, 3);
insert into moviegenres (film_id, genre_id) VALUES (5, 4);
insert into moviegenres (film_id, genre_id) VALUES (6, 5);
insert into moviegenres (film_id, genre_id) VALUES (6, 6);
insert into moviegenres (film_id, genre_id) VALUES (7, 1);
insert into moviegenres (film_id, genre_id) VALUES (7, 4);
insert into moviegenres (film_id, genre_id) VALUES (8, 5);
insert into moviegenres (film_id, genre_id) VALUES (8, 6);
insert into moviegenres (film_id, genre_id) VALUES (9, 1);
insert into moviegenres (film_id, genre_id) VALUES (9, 4);
insert into moviegenres (film_id, genre_id) VALUES (10, 4);
insert into moviegenres (film_id, genre_id) VALUES (10, 5);
insert into moviegenres (film_id, genre_id) VALUES (10, 6);
insert into moviegenres (film_id, genre_id) VALUES (12, 7);

-- adding addresses
insert into address (address, postalcode) VALUES ('Surrey England UK', 21212);
insert into address (address, postalcode) VALUES ('Tennessee BBQ 55', 23220);
insert into address (address, postalcode) VALUES ('Manhattan 44th ST.', 24553);
insert into address (address, postalcode) VALUES ('Knoxville road 40', 25555);
insert into address (address, postalcode) VALUES ('Concord valley 62', 26666);
insert into address (address, postalcode) VALUES ('West Hollywood 2nd ST.', 29999);
insert into address (address, postalcode) VALUES ('Venice California', 35000);
insert into address (address, postalcode) VALUES ('Santa Monica', 12345);
insert into address (address, postalcode) VALUES ('Cedar Rapids', 56789);
insert into address (address, postalcode) VALUES ('Platform 9-3/4', 66789);
-- adding actors
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Sam Worthington', 'Godalming', 46, 1, 2);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Morgan Freeman', 'Memphis', 85, 2, 1);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Al Pacino', 'New York', 82, 3, 3);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Quentin Tarantino', 'Tennessee', 62, 4, 4);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Tom Hanks', 'California USA', 66, 5, 5);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Leonardo DiCaprio', 'Los Angeles', 48, 6, 6);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Jodie Foster', 'Los Angeles', 50, 7, 7);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Tobey Maguire', 'Los Angeles', 47, 8, 8);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Elijah Wood', 'Iowa', 41, 9, 9);
insert into actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES ('Daniel Radcliffe', 'London', 33, 10, 10);

-- adding actors to movies
insert into actorrelations (film_id, actor_id) VALUES (2, 1);
insert into actorrelations (film_id, actor_id) VALUES (1, 2);
insert into actorrelations (film_id, actor_id) VALUES (3, 3);
insert into actorrelations (film_id, actor_id) VALUES (4, 4);
insert into actorrelations (film_id, actor_id) VALUES (5, 5);
insert into actorrelations (film_id, actor_id) VALUES (6, 6);
insert into actorrelations (film_id, actor_id) VALUES (7, 7);
insert into actorrelations (film_id, actor_id) VALUES (8, 8);
insert into actorrelations (film_id, actor_id) VALUES (9, 3);
insert into actorrelations (film_id, actor_id) VALUES (10, 9);
insert into actorrelations (film_id, actor_id) VALUES (11, 10);

