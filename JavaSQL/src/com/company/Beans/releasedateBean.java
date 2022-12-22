package com.company.Beans;
import java.util.ArrayList;
import com.company.Helpers.jsonHelper;
import com.company.Helpers.keyvaluepair;
public class releasedateBean {

    private int releasedate_id;
    private String releasedate;

    public int getReleasedate_id() {
        return releasedate_id;
    }

    public void setReleasedate_id(int releasedate_id) {
        this.releasedate_id = releasedate_id;
    }

    public String getReleasedate() {
        return releasedate;
    }

    public void setReleasedate(String releasedate) {
        this.releasedate = releasedate;
    }

    public String toString() {
        String pattern = "Releasedate ID = %s, Releasedate = %s";
        String returnString = String.format(pattern,Integer.toString(this.releasedate_id), this.releasedate);

        return returnString;
    }

    public String toJson() {
        ArrayList<keyvaluepair> dataList = new ArrayList<keyvaluepair>();
        dataList.add(new keyvaluepair("ReleasedateId", Integer.toString(this.releasedate_id)));
        dataList.add(new keyvaluepair("Releasedate", this.releasedate));
        return jsonHelper.toJsonObject(dataList);
    }
}
