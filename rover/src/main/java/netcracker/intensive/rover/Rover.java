package netcracker.intensive.rover;

import netcracker.intensive.rover.constants.CellState;
import netcracker.intensive.rover.constants.Direction;

/**
 * Класс описывает модель планетохода
 */
public class Rover implements Moveable, Turnable, Liftable, Landable {

    protected Point position;
    protected Direction direction;
    protected boolean airborne;
    protected GroundVisor groundVisor;

    public Rover() {
        this.position = new Point(0, 0);
        this.direction = Direction.SOUTH;
        this.airborne = false;
    }

    public Rover(GroundVisor groundVisor) {
        this.position = new Point(0, 0);
        this.direction = Direction.SOUTH;
        this.airborne = false;
        this.groundVisor = groundVisor;
    }

    public Point getCurrentPosition(){
        return position;
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
                    if(isAirborne()){
                        land(newPoint, direction);
                    }
                    else{
                        position = newPoint;
                    }
                 }
            } catch (OutOfGroundException e) {
                if (!airborne) {
                    lift();
                }
            }
        }

    }

    @Override
    public void land(Point position, Direction direction) {
        this.position = position;
        airborne = false;
        this.direction = direction;
    }

    @Override
    public void lift() {
        airborne = true;
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

    public boolean isAirborne() {
        return airborne;
    }

    public void setAirborne(boolean airborne) {
        this.airborne = airborne;
    }

    public GroundVisor getGroundVisor() {
        return groundVisor;
    }

    public void setGroundVisor(GroundVisor groundVisor) {
        this.groundVisor = groundVisor;
    }

    public Direction getDirection() {
        return direction;
    }
}
