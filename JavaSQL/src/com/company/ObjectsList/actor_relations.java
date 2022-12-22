package com.company.ObjectsList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.company.Beans.actorRelationBean;
import com.company.Helpers.jsonHelper;

public class actor_relations {

        private Connection _connection;
        private ArrayList<actorRelationBean> _actor_relations;

        public actor_relations (Connection cn) {
            this._connection = cn;
            this._actor_relations = new ArrayList<actorRelationBean>();
            getActorRelations();
        }

        public ArrayList<actorRelationBean> getActorRelations() {
            String qry = "select * from actorrelations";

            if (this._actor_relations.size() > 0)
                return this._actor_relations;

            this._actor_relations = new ArrayList<>();
            try (PreparedStatement myQry = this._connection.prepareStatement(qry)) {
                runQuery(myQry);
            } catch (SQLException e) {
                System.out.println("getActorRelations exception for statement");
                e.printStackTrace();
            }

            return this._actor_relations;
        }
        public int updateActorRelations(int movie_id, int actor_id) {
            int count = -1;
            String qry = "UPDATE actorrelations SET actor_id = ? WHERE film_id = ?";
            try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
                myQry.setInt(1, actor_id);
                myQry.setInt(2, movie_id);
                count = myQry.executeUpdate();

            }catch (SQLException e) {
                System.out.println("updateActorRelations exception for statement");
                e.printStackTrace();
            }

            return count;
        }
        public int createActorRelations(int movie_id, int actor_id) {
            int count = -1;
            String qry = "INSERT INTO actorrelations (film_id, actor_id) VALUES (?,?)";
            try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
                myQry.setInt(1, movie_id);
                myQry.setInt(2, actor_id);
                count = myQry.executeUpdate();

            }catch (SQLException e) {
                System.out.println("createActorRelations exception for statement");
                e.printStackTrace();
            }

            return count;
        }
        public int deleteActorRelations(int actor_id) {
            int count = -1;
            String qry = "DELETE FROM actorrelations WHERE actor_id = ?";
            try (PreparedStatement myQry = this._connection.prepareStatement(qry)){
                myQry.setInt(1, actor_id);
                count = myQry.executeUpdate();

            }catch (SQLException e) {
                System.out.println("deleteActorRelations exception for statement");
                e.printStackTrace();
            }

            return count;
        }

        public String toJson() {
            String beansContent = "";
            for (actorRelationBean arb : this._actor_relations) {
                beansContent += arb.toJson() + ",";
            }
            beansContent = beansContent.substring(0, beansContent.lastIndexOf(","));

            return jsonHelper
                    .toJsonArray("actorrelations", beansContent);
        }

        private actorRelationBean buildActorRelation(ResultSet rs) {
            actorRelationBean arb = new actorRelationBean();

            try {
                arb.setActorId(rs.getInt("actor_id"));
                arb.setFilmId(rs.getInt("film_id"));
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return arb;
        }

        private void buildActorRelations(ResultSet rs) throws SQLException {
            while(rs.next()) {  // rows
                this._actor_relations.add(buildActorRelation(rs));
            }
        }

        private void runQuery(PreparedStatement query) {
            try (ResultSet rs = query.executeQuery()) {
                buildActorRelations(rs);
            } catch (SQLException e) {
                System.out.println("run query exception for result set");
                e.printStackTrace();
            }

        }

}
