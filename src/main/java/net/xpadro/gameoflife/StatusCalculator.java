package net.xpadro.gameoflife;

public final class StatusCalculator {
    private StatusCalculator() {}

    public static int calculate(int cellValue, int neighboursValues) {
        int result = 0;

        if (shouldDeadCellLive(cellValue, neighboursValues) || shouldLiveCellPersist(cellValue, neighboursValues)) {
            result = 1;
        }

        return result;
    }

    private static boolean shouldDeadCellLive(int cellValue, int neighboursValues) {
        return cellValue == 0 && neighboursValues == 3;
    }

    private static boolean shouldLiveCellPersist(int cellValue, int neighboursValues) {
        return cellValue == 1 && neighboursValues >= 2 && neighboursValues <= 3;
    }
}
