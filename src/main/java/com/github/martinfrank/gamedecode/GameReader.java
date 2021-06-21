package com.github.martinfrank.gamedecode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class GameReader {

    public static final String GAME_SAFE_TXT = "C:\\Users\\fmar\\IdeaProjects\\CodeKata\\src\\main\\resources\\game.safe.txt";

    public String getContent() throws IOException {
        List<String> content = Files.readAllLines(Paths.get(GAME_SAFE_TXT), StandardCharsets.UTF_8);
        return content.stream().collect(Collectors.joining("", "", ""));
    }
}
