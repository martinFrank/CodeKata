package com.github.martinfrank.gamedecode;

import com.google.gson.*;
import org.json.JSONObject;

import java.util.Base64;

public class GameDecoder {


    public JSONObject decode(String content) {
        System.out.println(content);
        byte[] decodedBytes = Base64.getDecoder().decode(content);
        String decodedString = new String(decodedBytes);
        JSONObject jsonObject = new JSONObject(decodedString);
        System.out.println(jsonObject);
        return jsonObject;
    }
}
