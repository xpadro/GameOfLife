package net.xpadro.gameoflife;

public class GameOfLife {

    public Integer[][] play(Integer[][] matrix) {
        Integer[][] outcome = new Integer[matrix.length][matrix[0].length];

        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                int neighboursValue = calculateNeighboursValue(matrix, i, j);
                int status = StatusCalculator.calculate(getCellValue(matrix, i, j), neighboursValue);
                outcome[i][j] = status;
            }
        }

        return outcome;
    }

    private int calculateNeighboursValue(Integer[][] matrix, int row, int col) {
        int upperLeft = getCellValue(matrix, row-1, col-1);
        int up = getCellValue(matrix, row-1, col);
        int upperRight = getCellValue(matrix, row-1, col+1);
        int left = getCellValue(matrix, row, col-1);
        int right = getCellValue(matrix, row, col+1);
        int lowerLeft = getCellValue(matrix, row+1, col-1);
        int low = getCellValue(matrix, row+1, col);
        int lowerRight = getCellValue(matrix, row+1, col+1);

        return upperLeft + up + upperRight + left + right + lowerLeft + low + lowerRight;
    }

    private int getCellValue(Integer[][] matrix, int row, int col) {
        return row < 0 || row > matrix.length - 1 || col < 0 || col > matrix[row].length - 1 ? 0 : matrix[row][col];
    }

}
