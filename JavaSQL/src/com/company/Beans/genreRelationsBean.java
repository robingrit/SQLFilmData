package com.company.Beans;
import java.util.ArrayList;
import com.company.Helpers.jsonHelper;
import com.company.Helpers.keyvaluepair;
public class genreRelationsBean {
    private int genreId;
    private int filmId;

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String toString() {
        String pattern = "Genre ID = %s, Movie ID = %s";
        String returnString = String.format(pattern,Integer.toString(genreId), Integer.toString(filmId));

        return returnString;
    }

    public String toJson() {
        ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
        dataList.add(new keyvaluepair("GenreId", Integer.toString(genreId)));
        dataList.add(new keyvaluepair("MovieId", Integer.toString(filmId)));
        return jsonHelper.toJsonObject(dataList);
    }
}
