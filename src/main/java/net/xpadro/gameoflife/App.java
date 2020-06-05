package net.xpadro.gameoflife;

import net.xpadro.gameoflife.io.IOUtils;

public class App {

    public static void main(String[] args) {
        new App().startGame();
    }

    public void startGame() {
        GameOfLife game = new GameOfLife();
        Integer[][] input = IOUtils.read(System.in);
        Integer[][] outcome = game.play(input);
        IOUtils.write(outcome);
    }
}