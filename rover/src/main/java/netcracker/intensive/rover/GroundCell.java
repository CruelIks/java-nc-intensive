package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

/**
 * Класс описывает ячейку поля
 *
 * */
public class GroundCell {

    private Point point;
    private CellState state;

    public GroundCell(Point point) {
        this.point = point;
        this.state = CellState.FREE;
    }

    public GroundCell(CellState state) {
        this.state = state;
    }

    public GroundCell(Point point, CellState state) {
        this.point = point;
        this.state = state;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }
}
