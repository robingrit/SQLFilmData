package com.company.Beans;

import com.company.Helpers.jsonHelper;
import com.company.Helpers.keyvaluepair;

import java.util.ArrayList;

public class directorBean {
    private int id;
    private String name;
    private String town;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        String pattern = "Director ID = %s, Director Name = %s, City = %s, Age = %s";
        String returnString = String.format(pattern,Integer.toString(id), this.name, this.town, this.age);

        return returnString;
    }

    public String toJson() {
        ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
        dataList.add(new keyvaluepair("Director Id", Integer.toString(id)));
        dataList.add(new keyvaluepair("Name", this.name));
        dataList.add(new keyvaluepair("Town", this.town));
        dataList.add(new keyvaluepair( "Age", Integer.toString(this.age)));

        return jsonHelper.toJsonObject(dataList);
    }
}
