package com.company.ObjectsList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.company.Beans.actorBean;
import com.company.Helpers.jsonHelper;
public class actors {

    private Connection _connection;
    private ArrayList<actorBean> _actors;

    public actors(Connection cn) {
        this._connection = cn;
        this._actors = new ArrayList<>();
        getActors();
    }

    public ArrayList<actorBean> getActors() {
        String qry = "select * from actor";

        if (this._actors.size() > 0)
            return this._actors;

        this._actors = new ArrayList<actorBean>();
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)) {
            runQuery(myQry);
        } catch (SQLException e) {
            System.out.println("getActors exception for statement");
            e.printStackTrace();
        }

        return this._actors;
    }

    public int createActor(String name, String hometown, int age, int addressId, int actorMovieId) {
        int nr = 0;
        String qry = "INSERT INTO actor (actor_name, hometown, actor_age, address_id, actor_movie_id) VALUES (?, ?, ?, ?, ?);";
        try(PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, name);
            myQry.setString(2, hometown);
            myQry.setInt(3, age);
            myQry.setInt(4, addressId);
            myQry.setInt(5, actorMovieId);
            nr = myQry.executeUpdate();


        }catch (SQLException e) {
            System.out.println("createActor exception");
            e.printStackTrace();
        }
        return nr;
    }
    public int updateActors(String name, String newCity, int newAge) {
        int count = -1;
        String qry = "UPDATE actor SET hometown = ?, actor_age = ? WHERE actor_name = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){

            myQry.setString(1, newCity);
            myQry.setInt(2, newAge);
            myQry.setString(3, name);

            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("updateActors exception for statement");
            e.printStackTrace();
        }

        return count;
    }

    public int updateActorsCity(String oldCity, String newCity) {

        String qry = "UPDATE actor SET hometown = ? WHERE hometown LIKE ?";
        int count = -1;
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setString(1, oldCity);
            myQry.setString(2, newCity);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("updateActorsCity exception for statement");
            e.printStackTrace();
        }

        return count;
    }

    public int deleteActor(int address_id) {
        int count = -1;
        actor_relations myAR = new actor_relations(_connection);
        myAR.deleteActorRelations(address_id);
        String qry = "DELETE FROM actor WHERE address_id = ?";
        try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
            myQry.setInt(1, address_id);
            count = myQry.executeUpdate();

        }catch (SQLException e) {
            System.out.println("deleteActor exception for statement");
            e.printStackTrace();
        }

        return count;
    }


    public String toJson() {
        String beansContent = "";
        for (actorBean ab : this._actors) {
            beansContent += ab.toJson() + ",";

        }
        beansContent = beansContent.substring(0, beansContent.lastIndexOf(","));

        return jsonHelper
                .toJsonArray("Actors", beansContent);
    }

    private actorBean buildActor(ResultSet rs) {
        actorBean ab = new actorBean();

        try {
            ab.setId(rs.getInt("actor_id"));
            ab.setAge(rs.getInt("actor_age"));
            ab.setName(rs.getString("actor_name"));
            ab.setHometown(rs.getString("hometown"));
            ab.setAddressId(rs.getInt("address_id"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ab;
    }

    private void buildActors(ResultSet rs) throws SQLException {
        while(rs.next()) {  // rows
            this._actors.add(buildActor(rs));
        }
    }

    private void runQuery(PreparedStatement query) {
        try (ResultSet rs = query.executeQuery()) {
            buildActors(rs);
        } catch (SQLException e) {
            System.out.println("getActors exception for result set");
            e.printStackTrace();
        }

    }
}
