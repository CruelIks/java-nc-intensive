package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

/**
 * Класс описывает ячейку поля
 *
 * */
public class GroundCell {

    private CellState state;

    public GroundCell(Point point) {
        this.state = CellState.FREE;
    }

    public GroundCell(CellState state) {
        this.state = state;
    }

    public GroundCell(Point point, CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
