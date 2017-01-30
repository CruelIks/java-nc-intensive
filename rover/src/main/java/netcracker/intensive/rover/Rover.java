package netcracker.intensive.rover;

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

    public Point getCurrentPosition() {
        if (isAirborne()) {
            return null;
        }
        return position;
    }

    @Override
    public void move() {

        if (getDirection() == null) {
            return;
        }

        int deltaX = 0, deltaY = 0;
        switch (getDirection()) {
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

        if (deltaX + deltaY == 0) {
            return;
        }
        Point newPoint = new Point(position.getX() + deltaX, position.getY() + deltaY);

        //проверить точку визором, без визора не едем
        if (!(null == groundVisor)) {
            try {
                if (!groundVisor.hasObstacles(newPoint)) {
                    if (isAirborne()) {
                        land(newPoint, direction);
                    } else {
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

        try {
            if (!groundVisor.hasObstacles(position)) {
                this.position = position;
                airborne = false;
                this.direction = direction;
            }
        } catch (OutOfGroundException e) {
        }
   }

    @Override
    public void lift() {
        airborne = true;
    }

    @Override
    public void turnTo(Direction direction) {
        this.direction = direction;
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
        if (isAirborne()) {
            return null;
        } else {
            return direction;
        }

    }
}
