package com.company.ObjectsList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.Beans.genreRelationsBean;
import com.company.Helpers.jsonHelper;

public class filmgeneres {
    private Connection _connection;
    private ArrayList<genreRelationsBean> _moviegenres;

    public filmgeneres (Connection cn) {
        this._connection = cn;
        this._moviegenres = new ArrayList<genreRelationsBean>();
        getMovieGenres();
    }


    public ArrayList<genreRelationsBean> getMovieGenres() {
        String qry = "select * from moviegenres";

        if (this._moviegenres.size() > 0)
            return this._moviegenres;

        this._moviegenres = new ArrayList<genreRelationsBean>();
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)) {
            runQuery(myQry);
        } catch (SQLException e) {
            System.out.println("getMovieGenres exception for statement");
            e.printStackTrace();
        }

        return this._moviegenres;
    }
    public int updateMovieGenres(int movie_id, int genre_id) {
        int count = -1;
        String qry = "UPDATE moviegenres SET movie_id = ? WHERE genre_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, movie_id);
            myQry.setInt(2, genre_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("updateMovieGenres exception for statement");
            e.printStackTrace();
        }

        return count;
    }
    public int createActorRelations(int movie_id, int genre_id) {
        int count = -1;
        String qry = "INSERT INTO moviegenres (movie_id, genre_id) VALUES (?,?)";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, movie_id);
            myQry.setInt(2, genre_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("createMovieGenres exception for statement");
            e.printStackTrace();
        }

        return count;
    }

    public String toJson() {
        String beansContent = "";
        for (genreRelationsBean mgb : this._moviegenres) {
            beansContent += mgb.toJson() + ",";
        }
        beansContent = beansContent.substring(0, beansContent.lastIndexOf(","));

        return jsonHelper
                .toJsonArray("MovieGenres", beansContent);
    }

    private genreRelationsBean buildMovieGenre(ResultSet rs) {
        genreRelationsBean mgb = new genreRelationsBean();

        try {
            mgb.setFilmId(rs.getInt("film_id"));
            mgb.setGenreId(rs.getInt("genre_id"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mgb;
    }

    private void buildMovieGenres(ResultSet rs) throws SQLException {
        while(rs.next()) {  // rows
            this._moviegenres.add(buildMovieGenre(rs));
        }
    }

    private void runQuery(PreparedStatement query) {
        try (ResultSet rs = query.executeQuery()) {
            buildMovieGenres(rs);
        } catch (SQLException e) {
            System.out.println("run query exception for result set");
            e.printStackTrace();
        }

    }

    public int deleteMovieGenres(int genre_id) {
        int count = 0;
        String qry = "DELETE FROM moviegenres WHERE genre_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, genre_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("deleteMovieGenres exception for statement");
            e.printStackTrace();
        }

        return count;


    }
}
