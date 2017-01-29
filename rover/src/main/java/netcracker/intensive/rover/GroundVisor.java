package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {

    private Ground ground;

    public GroundVisor(Ground ground) {
        this.ground = ground;
    }

    public boolean hasObstacles(Point point) throws OutOfGroundException {
        if (point.getY() >= ground.getHeight() | point.getX() >= ground.getWidth()
                | point.getY() < 0 | point.getX() < 0) {
            throw new OutOfGroundException();
        }

        GroundCell cell = ground.getLandscape()[point.getY()][point.getX()];

        if (null == cell) {
            throw new OutOfGroundException();
        }

        return (cell.getState().equals(CellState.OCCUPIED));

    }


}
