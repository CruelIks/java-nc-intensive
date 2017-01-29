package netcracker.intensive.rover.stats;

import netcracker.intensive.rover.Point;

import java.util.Collection;
import java.util.HashSet;

public class SimpleRoverStatsModule implements RoverStatsModule {

    private final Collection<Point> points = new HashSet<>();

    @Override
    public void registerPosition(Point position) {
        points.add(position);
    }

    @Override
    public boolean isVisited(Point point) {
       return points.contains(point);
    }

    @Override
    public Collection<Point> getVisitedPoints() {
        return points;
    }
}
