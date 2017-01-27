package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;

public class GroundVisor {

    private Ground ground;

    public GroundVisor(Ground ground) {
        this.ground = ground;
    }

    public boolean hasObstacles(Point point) throws OutOfGroundException{
        if (point.getY() >= ground.getHeight() | point.getX() >= ground.getWidth()){
            throw new OutOfGroundException();
        }

        GroundCell cell = ground.getLandscape()[point.getY()][point.getX()];

        if (null == cell){
            throw new OutOfGroundException();
        }

        return (cell.getState().equals(CellState.OCCUPIED));

    }

    public CellState scanPoint(Point point) throws OutOfGroundException{

        if (point.getY() >= ground.getHeight() | point.getX() >= ground.getWidth()){
            throw new OutOfGroundException("Конец земли! Взлетай!");
        }

        GroundCell cell = ground.getLandscape()[point.getY()][point.getX()];

        if (null == cell){
            throw new OutOfGroundException("Нет ячейки!");
        }

        return cell.getState();
    }

}
