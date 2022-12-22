package com.company;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.Helpers.*;
import com.company.ObjectsList.*;
public class Main {

    public static void main(String[] args) throws SQLException {
        // Establishes a connection to the "films" database.
        Connection conn = databaseHelper.DbConnect("films");

        // Calls the ShowAllTables method and passes the Connection object as an argument.
        ShowAllTables(conn);
         updateActors(conn, "Daniel Radcliffe", "NewYork", 35 );

         createActors(conn, "Alexander Skarsgård", "Stockholm", 45, 4, 3);

         updateAddress(conn, "HelsingBorgs gatan 5", "12345", "skane", 1);
         createAddress(conn, "Hasselgatan 2", "987654", "skane");

         updateDirectors(conn, "Frank Darabont", "London", 10 , 2);
         createDirectors(conn, "steven spielberg", "lubech", 20);

         updateMovies(conn, "The Fellowship of the Rin", 3, 6, 11);
         createMovies(conn, "The Fast and the Furious", 4, 8);

         createGenre(conn, "Scary");
         updateGenres(conn, "Horror", 8);





        // Closes the Connection object.
        conn.close();



    }

    // This method takes a Connection object as input and retrieves data from several tables in the connected database.
    private static void ShowAllTables(Connection conn) {
    // Creates objects for each table in the database, passing the Connection object as an argument.
        actors myActors = new actors(conn);
        adressList myAddresses = new adressList(conn);
        films myMovies = new films(conn);
        genres myGenres = new genres(conn);
        directors myDirectors = new directors(conn);
        actor_relations myAR = new actor_relations(conn);
        filmgeneres myMG = new filmgeneres(conn);
        releasedates myRD = new releasedates(conn);


        // Creates an ArrayList to store the JSON representations of the data from each table.
        ArrayList<String> document = new ArrayList<>();
        // Adds the JSON representations of the data from each table to the ArrayList.
        document.add(myActors.toJson());
        document.add(myAddresses.toJson());
        document.add(myMovies.toJson());
        document.add(myGenres.toJson());
        document.add(myDirectors.toJson());
        document.add(myAR.toJson());
        document.add(myMG.toJson());
        document.add(myRD.toJson());

        // Converts the ArrayList of JSON representations into a single JSON object.
        String jsonDoc = jsonHelper.toJsonObjectFromStrings(document);
        System.out.println(jsonDoc);

    }
    private static void createActors(Connection conn, String name, String hometown, int age, int addressId, int actorMovieId) {
        actors myActors = new actors(conn);

        int antal= myActors.createActor(name, hometown, age, addressId, actorMovieId);
        System.out.println("createActor executed: "+ antal);
    }

    private static void updateActors(Connection conn, String name, String city, int age) {

        actors myActors = new actors(conn);

        int antal = myActors.updateActors(name, city, age);
        System.out.println("Actors updated: " + antal);

        antal = myActors.updateActorsCity(city,"%s");
        System.out.println("Actor city updated : " + antal);
    }

    private static void createDirectors(Connection conn, String name, String city, int age) {
        directors myDirectors = new directors(conn);
        myDirectors.createDirector(name, city, age);
    }

    private static void updateAddress(Connection conn, String address, String postalcode, String state,
                                      int address_id) {
        adressList myAddresses = new adressList(conn);

        int antal = myAddresses.updateAddresses(address, postalcode, state, address_id);
        System.out.println("Address updated: " + antal);

    }

    private static void createAddress(Connection conn, String address, String postalcode, String state) {
        adressList myAddresses = new adressList(conn);

        int antal= 1;
        System.out.println("Address Created: " + antal);

        myAddresses.createAddress(address, postalcode, state);
    }

    private static void updateDirectors(Connection conn, String name, String city,int age, int id) {
        directors myDirectors = new directors(conn);

        int antal = myDirectors.updateDirectors(name, city, age, id);
        System.out.println("Directors updated: " + antal);
    }

    private static void updateMovies(Connection conn, String title, int director_id, int releasedate_id, int movie_id) {
        films myMovies = new films(conn);

        int antal = myMovies.updateMovies(title, director_id, releasedate_id, movie_id);
        System.out.println("Films updated: " + antal);
    }

    private static void createMovies(Connection conn, String title, int director_id, int releasedate_id) {
        films myMovies = new films (conn);
        int antal= 1;
        System.out.println("Film Created: " + antal);
        myMovies.createMovies(title, director_id, releasedate_id);
    }

    private static void updateGenres(Connection conn, String genre, int genre_id) {
        genres myGenres = new genres(conn);
        int antal= 1;
        System.out.println("Genre Updated: " + antal);
        myGenres.updateGenres(genre, genre_id);
    }

    private static void createGenre(Connection conn, String genre) {
        genres myGenres = new genres(conn);
        myGenres.createGenre(genre);

        int antal= 1;
        System.out.println("Genre Created: " + antal);
        ;
    }

    private static void updateActorRelations(Connection conn, int movie_id, int actor_id) {
        actor_relations myAR = new actor_relations(conn);
        int antal= 1;
        System.out.println("ActorRelations Updated: " + antal);
        myAR.updateActorRelations(movie_id, actor_id);
    }

    private static void createActorRelations(Connection conn, int movie_id, int actor_id) {
        actor_relations myAR = new actor_relations(conn);
        int antal= 1;
        System.out.println("ActorRelations Created: " + antal);
        myAR.createActorRelations(movie_id, actor_id);
    }

    private static void updateMovieGenres(Connection conn, int movie_id, int genre_id) {
        filmgeneres myMG = new filmgeneres(conn);
        int antal= 1;
        System.out.println("MovieGenres Updated: " + antal);
        myMG.updateMovieGenres(movie_id, genre_id);
    }

    private static void createMovieGenres(Connection conn, int movie_id, int genre_id) {
        filmgeneres myMG = new filmgeneres(conn);
        int antal= 1;
        System.out.println("MovieGenres Created: " + antal);
        myMG.createActorRelations(movie_id, genre_id);
    }

    private static void updateReleasedates(Connection conn, int releasedate_id, int releasedateYear) {
        releasedates myRD = new releasedates(conn);
        int antal= 1;
        System.out.println("Releasedates Updated: " + antal);
        myRD.updateReleasedate(releasedate_id, releasedateYear);
    }

    private static void createReleasedates(Connection conn, int releasedateYear) {
        releasedates myRD = new releasedates(conn);
        int antal= 1;
        System.out.println("Releasedates Created: " + antal);
        myRD.createReleasedate(releasedateYear);
    }

    private static void deleteMovies(Connection conn, String title) {
        //not functional yet
        films myMovies = new films(conn);
        int antal= 1;
        System.out.println("Films Deleted: " + antal);
        myMovies.deleteMovies(title);
    }

    private static void deleteGenre(Connection conn, int genre_id) {
        genres myGenres = new genres(conn);
        int antal= 1;
        System.out.println("Genre Deleted: " + antal);
        myGenres.deleteGenre(genre_id);
    }

    private static void deleteActorrelations(Connection conn, int actor_id) {
        actor_relations myAR = new actor_relations(conn);
        int antal= 1;
        System.out.println("ActorRelations Deleted: " + antal);
        myAR.deleteActorRelations(actor_id);
    }

    private static void deleteActor(Connection conn, int address_id) {
        actors myActors = new actors(conn);
        int antal= 1;
        System.out.println("Actor Deleted: " + antal);
        myActors.deleteActor(address_id);
    }

    private static void deleteAddress(Connection conn, int address_id) {
        adressList myAddresses = new adressList(conn);
        int antal= 1;
        System.out.println("Address Deleted: " + antal);
        myAddresses.deleteAddress(address_id);
    }

    private static void deleteReleasedate(Connection conn, int releasedate_id) {
        releasedates myRD = new releasedates(conn);
        int antal= 1;
        System.out.println("Releasedate Deleted: " + antal);
        myRD.deleteReleasedate(releasedate_id);
    }

    private static void deleteDirector(Connection conn, int director_id) {
        directors myDirectors = new directors(conn);
        int antal= 1;
        System.out.println("Director Deleted: " + antal);
        myDirectors.deleteDirector(director_id);
    }
}
