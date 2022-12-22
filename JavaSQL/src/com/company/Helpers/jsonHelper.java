package com.company.Helpers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class jsonHelper {

    // This method takes a label and a String as input and returns a JSON array with the given label and content.
    public static String toJsonArray(String ArrayLabel, String content) {
        // Removes the last comma in the content String if it exists.
        String lastCharacter = content.substring(content.length() - 1);
        if (lastCharacter == ",") {
            content = content.substring(0, content.lastIndexOf(","));
        }

        // Formats the label and content into a JSON array and stores it in a String.
        String pattern = "\"%s\": [ %s ]";
        String returnString = String.format(pattern, ArrayLabel, content);

        // Returns the JSON array as a String.
        return returnString;
    }

    // This method takes an ArrayList of keyvaluepair objects as input and returns a JSON object.
    public static String toJsonObject(ArrayList<keyvaluepair> content) {
        // Initializes an empty String to store the JSON object.
        String jsonString = "";

        // Iterates through the ArrayList and formats each key-value pair into a String.
        String itemPattern = "\"%s\" : \"%s\", ";
        for (keyvaluepair item : content) {
            jsonString += String.format(itemPattern, item.key, item.value);
        }
        // Removes the last comma from the String.
        jsonString = jsonString.substring(0, jsonString.lastIndexOf(","));

        // Formats the key-value pair String into a JSON object.
        String objectPattern = "{ %s }";


        // Returns the JSON object as a String.
        return String.format(objectPattern, jsonString);
    }

    // This method takes an ArrayList of Strings as input and returns a JSON object.
    public static String toJsonObjectFromStrings(ArrayList<String> content) {
        // Initializes an empty String to store the JSON object.
        String jsonString = "";

        // Iterates through the ArrayList and adds each String to the JSON object String.
        for (String item : content) {
            jsonString += item +",";
        }
        // Removes the last comma from the String.
        jsonString = jsonString.substring(0, jsonString.lastIndexOf(","));
        //return toJsonDocument(jsonString);

        // Formats the content String into a JSON object.
        // The %s placeholder is a placeholder for a String value.
        String objectPattern = "{ %s }";

        // Returns the JSON object as a String.
        return String.format(objectPattern, jsonString);
    }

    // This method takes a String as input and returns a JSON document with the given content.
    public static String toJsonDocument(String content) {
        // Returns the content String as a JSON document.
        return "{ " + content + " }";
    }

}
