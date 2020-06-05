package net.xpadro.gameoflife.io;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class ContentParser {

    private ContentParser() {
    }

    public static Integer[][] parse(String content) {
        String[] lines = content.split("\n");

        List<Integer[]> lists = Arrays
                .stream(lines)
                .filter(line -> !line.startsWith("!"))
                .filter(line -> !line.equals(" "))
                .map(ContentParser::convertLine)
                .collect(Collectors.toList());

        return lists.toArray(new Integer[0][0]);
    }

    private static Integer[] convertLine(String line) {
        return Arrays.stream(line.split(""))
                .map(CellConverter::convertToInteger)
                .toArray(Integer[]::new);
    }
}
