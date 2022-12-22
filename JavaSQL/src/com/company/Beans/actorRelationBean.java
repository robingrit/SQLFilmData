package com.company.Beans;

import com.company.Helpers.jsonHelper;
import com.company.Helpers.keyvaluepair;

import java.util.ArrayList;

public class actorRelationBean {

    private int actorId;
    private int filmId;

    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String toString() {
        String pattern = "Actor ID = %s, Film ID = %s";
        String returnString = String.format(pattern,Integer.toString(actorId), Integer.toString(filmId));

        return returnString;
    }

    public String toJson() {
        ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
        dataList.add(new keyvaluepair("ActorId", Integer.toString(actorId)));
        dataList.add(new keyvaluepair("MovieId", Integer.toString(filmId)));
        return jsonHelper.toJsonObject(dataList);
    }
}
