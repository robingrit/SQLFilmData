package com.company.Beans;
import com.company.Helpers.jsonHelper;
import com.company.Helpers.keyvaluepair;

import java.util.ArrayList;
public class filmBean {
    private int film_id;
    private String title;
    private int director_id;
    private int releasedate_id;


    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDirector_id() {
        return director_id;
    }

    public void setDirector_id(int director_id) {
        this.director_id = director_id;
    }

    public int getReleasedate_id() {
        return releasedate_id;
    }

    public void setReleasedate_id(int releasedate_id) {
        this.releasedate_id = releasedate_id;
    }

    public String toString() {
        String pattern = "Film_ID = %s, Title = %s, Director_ID = %s, Releasedate_ID = %s";
        String returnString = String.format(pattern, Integer.toString(this.film_id), this.title, Integer.toString(director_id), Integer.toString(releasedate_id));

        return returnString;
    }

    public String toJson() {
        ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
        dataList.add(new keyvaluepair("Film ID", Integer.toString(this.film_id)));
        dataList.add(new keyvaluepair("Title", this.title));
        dataList.add(new keyvaluepair("Director ID", Integer.toString(this.director_id)));
        dataList.add(new keyvaluepair("Releasedate ID", Integer.toString(this.releasedate_id)));

        return jsonHelper.toJsonObject(dataList);
    }
}
