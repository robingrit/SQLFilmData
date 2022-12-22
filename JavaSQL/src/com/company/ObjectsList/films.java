package com.company.ObjectsList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.company.Beans.filmBean;
import com.company.Helpers.jsonHelper;
public class films {
    private Connection _connection;
    private ArrayList<filmBean> _films;

    public films(Connection cn) {
        this._connection = cn;
        this._films = new ArrayList<filmBean>();
        getMovies();
    }

    public ArrayList<filmBean> getMovies() {
        String qry = "select * from films";

        if (this._films.size() > 0)
            return this._films;

        this._films = new ArrayList<filmBean>();
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)) {
            runQuery(myQry);
        } catch (SQLException e) {
            System.out.println("getMovies exception for statement");
            e.printStackTrace();
        }

        return this._films;
    }
    public int updateMovies(String title, int director_id, int releasedate_id, int film_id) {
        int count = -1;
        String qry = "UPDATE films SET title = ?, director_id = ?, releasedate_id = ? WHERE film_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, title);
            myQry.setInt(2, director_id);
            myQry.setInt(3, releasedate_id);
            myQry.setInt(4, film_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("updateMovies exception for statement");
            e.printStackTrace();
        }

        return count;
    }
    public int createMovies(String title, int director_id, int releasedate_id) {
        int count = -1;
        String qry = "INSERT INTO films (title, director_id, releasedate_id) VALUES (?,?,?)";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, title);
            myQry.setInt(2, director_id);
            myQry.setInt(3, releasedate_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("createMovies exception for statement");
            e.printStackTrace();
        }
        return count;
    }
    public int deleteMovies(String title) {
        int del = 0;
        String qry = "DELETE FROM movies where title = ?";
        try(PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, title);
            myQry.executeUpdate();
        }catch(SQLException e) {
            System.out.println("deleteMovies Exception");
            e.printStackTrace();
        }
        return del;
    }

    public String toJson() {
        String beansContent = "";
        for (filmBean mb : this._films) {
            beansContent += mb.toJson() + ",";
        }
        beansContent = beansContent.substring(0, beansContent.lastIndexOf(","));

        return jsonHelper
                .toJsonArray("films", beansContent);
    }

    private filmBean buildMovie(ResultSet rs) {
        filmBean mb = new filmBean();

        try {
            mb.setFilm_id(rs.getInt("film_id"));
            mb.setTitle(rs.getString("title"));
            mb.setDirector_id(rs.getInt("director_id"));
            mb.setReleasedate_id(rs.getInt("releasedate_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mb;
    }

    private void buildMovies(ResultSet rs) throws SQLException {
        while(rs.next()) {  // rows
            this._films.add(buildMovie(rs));
        }
    }

    private void runQuery(PreparedStatement query) {
        try (ResultSet rs = query.executeQuery()) {
            buildMovies(rs);
        } catch (SQLException e) {
            System.out.println("error in runQuery exception for result set");
            e.printStackTrace();
        }

    }
}
