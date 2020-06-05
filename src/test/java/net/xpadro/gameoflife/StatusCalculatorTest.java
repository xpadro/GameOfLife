package net.xpadro.gameoflife;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Cell status rules tests")
class StatusCalculatorTest {

    @Test
    public void deadCellWithNoLiveNeighboursShouldRemainDead() {
        assertEquals(0, StatusCalculator.calculate(0, 0));
    }

    @Test
    public void deadCellWithOneLiveNeighboursShouldRemainDead() {
        assertEquals(0, StatusCalculator.calculate(0, 1));
    }

    @Test
    public void deadCellWithTwoLiveNeighboursShouldRemainDead() {
        assertEquals(0, StatusCalculator.calculate(0, 2));
    }

    @Test
    public void deadCellWithThreeLiveNeighboursShouldAwake() {
        assertEquals(1, StatusCalculator.calculate(0, 3));
    }

    @Test
    public void deadCellWithManyLiveNeighboursShouldRemainDeadOfUnderPopulation() {
        assertEquals(0, StatusCalculator.calculate(0, 8));
    }

    @Test
    public void liveCellWithNoLiveNeighboursShouldDie() {
        assertEquals(0, StatusCalculator.calculate(1, 0));
    }

    @Test
    public void liveCellWithOneLiveNeighboursShouldDie() {
        assertEquals(0, StatusCalculator.calculate(1, 1));
    }

    @Test
    public void liveCellWithTwoLiveNeighboursShouldRemainLive() {
        assertEquals(1, StatusCalculator.calculate(1, 2));
    }

    @Test
    public void liveCellWithThreeLiveNeighboursShouldRemainLive() {
        assertEquals(1, StatusCalculator.calculate(1, 3));
    }

    @Test
    public void liveCellWithManyLiveNeighboursShouldDieOfOverPopulation() {
        assertEquals(0, StatusCalculator.calculate(1, 4));
    }
}