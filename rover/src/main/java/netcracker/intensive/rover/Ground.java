package netcracker.intensive.rover;

/**
 * Класс описывает игровое поле. Состоит из клеток (GroundCell)
 */
public class Ground {

    private GroundCell[][] landscape;
    //высота поля
    private int height;
    //ширина поля
    private int width;

    public Ground(int height, int width) {
        this.height = height;
        this.width = width;
        landscape = new GroundCell[height][width];
    }

    public void initialize(GroundCell... cells) {

        if (cells.length == 0) {
            return;
        }
        if (cells.length > height * width) {
            throw new RuntimeException("Too much cells");
        }

        int x = 0, y = 0;

        for (GroundCell cell : cells) {
            landscape[y][x] = cell;

            x++;
            if (x == width) {
                x = 0;
                y++;
            }
        }
    }
}
