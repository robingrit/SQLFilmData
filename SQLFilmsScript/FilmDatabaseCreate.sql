drop database if exists Films;
create database if not exists Films;

use Films;

drop table if exists director;
create table if not exists director(
	director_id int auto_increment,
    director_name varchar(50) not null,
    town_name varchar(50) default 'Skurup',
    director_age int(3) not null,
    primary key (director_id)
);

drop table if exists genre;
create table if not exists genre(
	genre_id int auto_increment,
    genre varchar(20) not null unique,
    primary key (genre_id)
);

drop table if exists releasedate;
create table if not exists releasedate(
	releasedate_id int auto_increment,
    releasedate year not null,
    primary key (releasedate_id)
);

drop table if exists films;
create table if not exists films(
	film_id int auto_increment,
	title varchar(100) not null,
    director_id int not null,
    releasedate_id int not null,

    primary key (film_id),
    foreign key (director_id) references director (director_id),
    foreign key (releasedate_id) references releasedate (releasedate_id)
   
    
    
    
);

drop table if exists moviegenres;
create table if not exists moviegenres(
	film_id int not null,
    genre_id int not null,
    foreign key (film_id) references films (film_id),
    foreign key (genre_id) references genre (genre_id)
);

drop table if exists address;
create table if not exists address(
	address_id int auto_increment,
    address varchar(50) not null,
    postalcode int not null,
    state varchar(50) default 'skane',
    primary key (address_id)
    
);
            
drop table if exists actor;
create table if not exists actor(
	actor_id int auto_increment,
    actor_name varchar(50) not null,
    hometown varchar(50) default 'Malmo',
    actor_age tinyint(3) not null,
    address_id int not null,
    actor_movie_id int not null,
    primary key (actor_id),
    foreign key (address_id) references address (address_id)
    
);

drop table if exists actorrelations;
create table if not exists actorrelations(
	film_id int not null,
    actor_id int not null,
    foreign key (film_id) references films (film_id),
    foreign key (actor_id) references actor (actor_id)
);