package com.company.Beans;

import java.util.ArrayList;
import com.company.Helpers.jsonHelper;
import com.company.Helpers.keyvaluepair;

public class genreBean {
    private int id;
    private String genre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String toString() {
        String pattern = "Genre ID = %s, Genre = %s";
        String returnString = String.format(pattern,Integer.toString(id), this.genre);

        return returnString;
    }

    public String toJson() {
        ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
        dataList.add(new keyvaluepair("Id", Integer.toString(id)));
        dataList.add(new keyvaluepair("Genre", this.genre));
        return jsonHelper.toJsonObject(dataList);
    }
}
