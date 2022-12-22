package com.company.Beans;

import com.company.Helpers.jsonHelper;
import com.company.Helpers.keyvaluepair;

import java.util.ArrayList;

public class addressBean {

    private int id;
    private String address;
    private String postalcode;
    private String state;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String toString() {
        String pattern = "Address id = %s, Address = %s, Postalcode = %s, State = %s";
        String returnString = String.format(pattern,Integer.toString(this.id), this.address, this.postalcode, this.state);

        return returnString;
    }

    public String toJson() {
        ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
        dataList.add(new keyvaluepair("address_id", Integer.toString(this.id)));
        dataList.add(new keyvaluepair("Address", this.address));
        dataList.add(new keyvaluepair("Postalcode", this.postalcode));
        dataList.add(new keyvaluepair("State", this.state));

        return jsonHelper.toJsonObject(dataList);
    }
}
