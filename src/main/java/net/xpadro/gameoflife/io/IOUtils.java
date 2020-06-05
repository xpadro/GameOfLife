package net.xpadro.gameoflife.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class IOUtils {

    private IOUtils() {

    }

    public static Integer[][] read(InputStream in) {
        try {
            String content = readFromInputStream(in);
            return ContentParser.parse(content);
        } catch (IOException e) {
            System.exit(-1);
        }

        return new Integer[][]{};
    }

    public static void write(Integer[][] matrix) {
        for (Integer[] line : matrix) {
            for (Integer element : line) {
                String value = CellConverter.convertToString(element);
                System.out.print(value);
            }
            System.out.println();
        }
    }

    private static String readFromInputStream(InputStream in) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;

        while ((length = in.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }

        return result.toString(StandardCharsets.UTF_8.name());
    }
}
