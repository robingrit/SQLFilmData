package com.company.Beans;

import com.company.Helpers.jsonHelper;
import com.company.Helpers.keyvaluepair;

import java.util.ArrayList;

public class actorBean {
    private int id;
    private String name;
    private String hometown;
    private int age;
    private int addressId;

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

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String toString() {
        String pattern = "Actor Name = %s, Actor Age = %s, Hometown = %s, Address ID = %s";
        String returnString = String.format(pattern, this.name, Integer.toString(this.age), this.hometown, Integer.toString(addressId));

        return returnString;
    }

    public String toJson() {
        ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
        dataList.add(new keyvaluepair("Name", this.name));
        dataList.add(new keyvaluepair("Age", Integer.toString(this.age)));
        dataList.add(new keyvaluepair("Hometown", this.hometown));
        dataList.add(new keyvaluepair("Address_Id", Integer.toString(addressId)));
        return jsonHelper.toJsonObject(dataList);
    }
}
