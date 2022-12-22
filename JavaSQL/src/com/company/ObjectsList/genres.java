package com.company.ObjectsList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.Beans.genreBean;
import com.company.Helpers.jsonHelper;

public class genres {

    private Connection _connection;
    private ArrayList<genreBean> _genres;

    public genres (Connection cn) {
        this._connection = cn;
        this._genres = new ArrayList<genreBean>();
        getGenres();
    }

    public ArrayList<genreBean> getGenres() {
        String qry = "select * from genre";

        if (this._genres.size() > 0)
            return this._genres;

        this._genres = new ArrayList<genreBean>();
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)) {
            runQuery(myQry);
        } catch (SQLException e) {
            System.out.println("getGenres exception for statement");
            e.printStackTrace();
        }

        return this._genres;
    }
    public int updateGenres(String genre, int genre_id) {
        int count = -1;
        String qry = "UPDATE genre SET genre = ? WHERE genre_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, genre);
            myQry.setInt(2, genre_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("updateGenres exception for statement");
            e.printStackTrace();
        }

        return count;
    }
    public int createGenre(String genre) {
        int count = -1;
        String qry = "INSERT INTO genre (genre) VALUES (?)";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, genre);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("createGenre exception for statement");
            e.printStackTrace();
        }

        return count;
    }
    public int deleteGenre(int genre_id) {
        int count = -1;
        filmgeneres MG = new filmgeneres(_connection);
        MG.deleteMovieGenres(genre_id);
        String qry = "DELETE FROM genre WHERE genre_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, genre_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("deleteGenre exception for statement");
            e.printStackTrace();
        }

        return count;
    }

    public String toJson() {
        String beansContent = "";
        for (genreBean gb : this._genres) {
            beansContent += gb.toJson() + ",";
        }
        beansContent = beansContent.substring(0, beansContent.lastIndexOf(","));

        return jsonHelper
                .toJsonArray("Genres", beansContent);
    }

    private genreBean buildGenre(ResultSet rs) {
        genreBean gb = new genreBean();

        try {
            gb.setId(rs.getInt("genre_id"));
            gb.setGenre(rs.getString("genre"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return gb;
    }

    private void buildGenres(ResultSet rs) throws SQLException {
        while(rs.next()) {  // rows
            this._genres.add(buildGenre(rs));
        }
    }

    private void runQuery(PreparedStatement query) {
        try (ResultSet rs = query.executeQuery()) {
            buildGenres(rs);
        } catch (SQLException e) {
            System.out.println("run query exception for result set");
            e.printStackTrace();
        }

    }
}
