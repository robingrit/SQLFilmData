package com.company.ObjectsList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.company.Beans.directorBean;
import com.company.Helpers.jsonHelper;
public class directors {
    private Connection _connection;
    private ArrayList<directorBean> _directors;

    public directors (Connection cn) {
        this._connection = cn;
        this._directors = new ArrayList<directorBean>();
        getDirectors();
    }

    public ArrayList<directorBean> getDirectors() {
        String qry = "select * from director";

        if (this._directors.size() > 0)
            return this._directors;

        this._directors = new ArrayList<directorBean>();
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)) {
            runQuery(myQry);
        } catch (SQLException e) {
            System.out.println("getDirectors exception for statement");
            e.printStackTrace();
        }

        return this._directors;
    }

    public int updateDirectors(String name, String city,int director_age, int director_id) {
        int count = -1;
        String qry = "UPDATE director SET director_name = ?, town_name = ?, director_age = ? WHERE director_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, name);
            myQry.setString(2, city);
            myQry.setInt(3, director_age);
            myQry.setInt(4, director_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("updateDirectors exception for statement");
            e.printStackTrace();
        }

        return count;
    }
    public int createDirector(String name, String city, int age) {
        int count = -1;
        String qry = "INSERT INTO director (director_name, town_name, director_age) VALUES (?, ?, ?)";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, name);
            myQry.setString(2, city);
            myQry.setInt(3, age);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("createDirector exception for statement");
            System.out.println();
            e.printStackTrace();
        }

        return count;
    }
    public int deleteDirector(int director_id) {
        int count = -1;
        String qry = "DELETE FROM director WHERE director_id = ?)";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, director_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("deleteDirector exception for statement");
            e.printStackTrace();
        }

        return count;
    }

    public String toJson() {
        String beansContent = "";
        for (directorBean db : this._directors) {
            beansContent += db.toJson() + ",";
        }
        beansContent = beansContent.substring(0, beansContent.lastIndexOf(","));

        return jsonHelper
                .toJsonArray("Directors", beansContent);
    }

    private directorBean buildDirector(ResultSet rs) {
        directorBean db = new directorBean();

        try {
            db.setId(rs.getInt("director_id"));
            db.setName(rs.getString("director_name"));
            db.setTown(rs.getString("town_name"));
            db.setAge(rs.getInt("director_age"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return db;
    }

    private void buildDirectors(ResultSet rs) throws SQLException {
        while(rs.next()) {  // rows
            this._directors.add(buildDirector(rs));
        }
    }

    private void runQuery(PreparedStatement query) {
        try (ResultSet rs = query.executeQuery()) {
            buildDirectors(rs);
        } catch (SQLException e) {
            System.out.println("run query exception for result set");
            e.printStackTrace();
        }

    }


}
