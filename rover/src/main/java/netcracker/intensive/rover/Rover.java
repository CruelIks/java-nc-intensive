package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;
import netcracker.intensive.rover.constants.Direction;

/**
 * Класс описывает модель планетохода
 */
public class Rover implements Moveable, Turnable, Liftable, Landable {

    protected Point position;
    protected Direction direction;
    protected boolean flight;
    protected GroundVisor groundVisor;

    public Rover() {
        this.position = new Point(0, 0);
        this.direction = Direction.SOUTH;
        this.flight = false;
    }

    public Rover(GroundVisor groundVisor) {
        this.position = new Point(0, 0);
        this.direction = Direction.SOUTH;
        this.flight = false;
        this.groundVisor = groundVisor;
    }

    @Override
    public void move() {

        int deltaX = 0, deltaY = 0;
        switch (direction) {
            case SOUTH: {
                deltaY = 1;
                break;
            }
            case NORTH: {
                deltaY = -1;
                break;
            }
            case EAST: {
                deltaX = 1;
                break;
            }
            case WEST: {
                deltaX = -1;
                break;
            }
            default: {

            }
        }
        Point newPoint = new Point(position.getX() + deltaX, position.getY() + deltaY);

        //проверить точку визором, без визора не едем
        if (!(null == groundVisor)) {
            try {
                if (groundVisor.scanPoint(newPoint) == CellState.FREE) {
                    if(isFlight()){
                        land(newPoint, direction);
                    }
                    else{
                        position = newPoint;
                    }
                 }
            } catch (OutOfGroundException e) {
                if (!flight) {
                    lift();
                }
            }
        }

    }

    @Override
    public void land(Point position, Direction direction) {
        this.position = position;
        flight = false;
        this.direction = direction;
    }

    @Override
    public void lift() {
        flight = true;
    }

    @Override
    public void turnTo(Direction direction) {
        this.direction = direction;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public boolean isFlight() {
        return flight;
    }

    public void setFlight(boolean flight) {
        this.flight = flight;
    }

    public GroundVisor getGroundVisor() {
        return groundVisor;
    }

    public void setGroundVisor(GroundVisor groundVisor) {
        this.groundVisor = groundVisor;
    }
}
