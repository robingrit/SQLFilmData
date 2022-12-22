package com.company.ObjectsList;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.company.Beans.releasedateBean;
import com.company.Helpers.jsonHelper;
public class releasedates {
    private Connection _connection;
    private ArrayList<releasedateBean> _releasedates;

    public releasedates (Connection cn) {
        this._connection = cn;
        this._releasedates = new ArrayList<releasedateBean>();
        getReleasedates();
    }

    public ArrayList<releasedateBean> getReleasedates() {
        String qry = "select * from releasedate";

        if (this._releasedates.size() > 0)
            return this._releasedates;

        this._releasedates = new ArrayList<releasedateBean>();
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)) {
            runQuery(myQry);
        } catch (SQLException e) {
            System.out.println("getReleasedates exception for statement");
            e.printStackTrace();
        }

        return this._releasedates;
    }
    public int updateReleasedate(int releasedate_id, int releasedateYear) {
        int count = -1;
        String qry = "UPDATE releasedate SET releasedate = ? WHERE releasedate_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, releasedateYear);
            myQry.setInt(2, releasedate_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("updateReleasedate exception for statement");
            e.printStackTrace();
        }

        return count;
    }
    public int createReleasedate(int releasedateYear) {
        int count = -1;
        String qry = "INSERT INTO releasedate (releasedate) VALUES (?)";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, releasedateYear);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("createReleasedate exception for statement");
            e.printStackTrace();
        }

        return count;
    }

    public int deleteReleasedate(int releasedate_id) {
        int count = -1;
        String qry = "DELETE FROM releasedate WHERE releasedate_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, releasedate_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("deleteReleasedate exception for statement");
            e.printStackTrace();
        }

        return count;
    }

    public String toJson() {
        String beansContent = "";
        for (releasedateBean rdb : this._releasedates) {
            beansContent += rdb.toJson() + ",";
        }
        beansContent = beansContent.substring(0, beansContent.lastIndexOf(","));

        return jsonHelper
                .toJsonArray("Releasedates", beansContent);
    }

    private releasedateBean buildReleasedate(ResultSet rs) {
        releasedateBean rdb = new releasedateBean();

        try {
            rdb.setReleasedate_id(rs.getInt("releasedate_id"));
            rdb.setReleasedate(rs.getString("releasedate"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rdb;
    }

    private void buildReleasedates(ResultSet rs) throws SQLException {
        while(rs.next()) {  // rows
            this._releasedates.add(buildReleasedate(rs));
        }
    }

    private void runQuery(PreparedStatement query) {
        try (ResultSet rs = query.executeQuery()) {
            buildReleasedates(rs);
        } catch (SQLException e) {
            System.out.println("run query exception for result set");
            e.printStackTrace();
        }

    }
}
