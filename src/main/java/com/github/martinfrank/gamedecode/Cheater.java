package com.github.martinfrank.gamedecode;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

public class Cheater {

    //https://www.kongregate.com/games/Volch/endless-expansion

    public static void main(String[] args) throws IOException {
        GameReader reader = new GameReader();
        GameDecoder decoder = new GameDecoder();
        JSONObject root = decoder.decode(reader.getContent());
        Cheater cheater = new Cheater();
        cheater.increaseAllLevel(root);
        GameEncoder encoder = new GameEncoder();
        GameWriter writer = new GameWriter();
        writer.write(encoder.encode(root));
    }

    private void increaseAllLevel(JSONObject root) {
        final String key = "level";
        JSONArray fields = root.getJSONArray("map");
        for(int i = 0; i < fields.length(); i ++){
            JSONObject field = fields.getJSONObject(i);
            System.out.println("before: "+field);
            int level = field.getInt(key);
            level = level + 1;
            field.put(key, level);
            System.out.println("after : "+field);
            System.out.println("--------------");
        }
    }

}
