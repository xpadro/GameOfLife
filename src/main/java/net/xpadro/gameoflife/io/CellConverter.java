package net.xpadro.gameoflife.io;

public final class CellConverter {
    private static final String LIVE = "O";
    private static final String DEAD = ".";

    private CellConverter() {
    }

    public static Integer convertToInteger(String cell) {
        return cell.equals(LIVE) ? 1 : 0;
    }

    public static String convertToString(Integer cell) {
        return cell == 0 ? DEAD : LIVE;
    }
}
