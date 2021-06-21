package com.github.martinfrank.gamedecode;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class GameEncoder {

    public String encode(JSONObject root) {
        String jsonString = root.toString();
        byte[] encode = Base64.getEncoder().encode(jsonString.getBytes(StandardCharsets.UTF_8));
        return new String(encode);
    }
}
