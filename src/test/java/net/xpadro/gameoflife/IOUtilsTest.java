package net.xpadro.gameoflife;

import net.xpadro.gameoflife.io.IOUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("IOUtils tests")
public class IOUtilsTest {
    private static final String FILE_NAME = "toad.life";

    @Test
    @DisplayName("Test matrix is correctly read")
    public void gameMatrixIsLoaded() throws FileNotFoundException {
        InputStream in = new FileInputStream(FILE_NAME);
        Integer[][] content = IOUtils.read(in);

        List<String> result = Arrays.stream(content)
                .map(row -> Arrays.stream(row).map(Object::toString).collect(joining()))
                .collect(toList());

        assertAll(
                () -> assertEquals("000000", result.get(0)),
                () -> assertEquals("000000", result.get(1)),
                () -> assertEquals("001110", result.get(2)),
                () -> assertEquals("011100", result.get(3)),
                () -> assertEquals("000000", result.get(4)),
                () -> assertEquals("000000", result.get(5))
        );

    }
}
