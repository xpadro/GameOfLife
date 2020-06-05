package net.xpadro.gameoflife;

import net.xpadro.gameoflife.io.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Game of life tests")
class GameOfLifeTest {
    private GameOfLife game;

    @BeforeEach
    public void setUp() {
        this.game = new GameOfLife();
    }

    @Test
    @DisplayName("Play one round")
    void playOneRound() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("toad.life");
        Integer[][]matrix = IOUtils.read(in);

        Integer[][] outcome = game.play(matrix);
        List<String> result = convertToStringList(outcome);

        assertAll(
                () -> assertEquals("000000", result.get(0)),
                () -> assertEquals("000100", result.get(1)),
                () -> assertEquals("010010", result.get(2)),
                () -> assertEquals("010010", result.get(3)),
                () -> assertEquals("001000", result.get(4)),
                () -> assertEquals("000000", result.get(5))
        );
    }

    @Test
    @DisplayName("Play second round")
    void playSecondRound() throws FileNotFoundException {
        FileInputStream in = new FileInputStream("toad_second_gen.life");
        Integer[][] matrix = IOUtils.read(in);

        Integer[][] outcome = game.play(matrix);
        List<String> result = convertToStringList(outcome);

        assertAll(
                () -> assertEquals("000000", result.get(0)),
                () -> assertEquals("000000", result.get(1)),
                () -> assertEquals("001110", result.get(2)),
                () -> assertEquals("011100", result.get(3)),
                () -> assertEquals("000000", result.get(4)),
                () -> assertEquals("000000", result.get(5))
        );
    }

    private List<String> convertToStringList(Integer[][] matrix) {
        return Arrays.stream(matrix)
                .map(row -> Arrays.stream(row).map(Object::toString).collect(joining()))
                .collect(toList());
    }
}
