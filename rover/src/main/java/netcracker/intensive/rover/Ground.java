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

        if (cells.length < height * width) {
            throw new IllegalArgumentException();
        }

        int x = 0, y = 0;

        for (GroundCell cell : cells) {

            if (y == height | x == width){
                break;
            }
            landscape[y][x] = cell;

            x++;
            if (x == width) {
                x = 0;
                y++;
            }


        }
    }

    public GroundCell getCell(int x, int y) throws OutOfGroundException {

        if (y >= height | x >= width | y < 0 | x < 0){
            throw new OutOfGroundException();
        }

        return landscape[y][x];
    }

    public GroundCell[][] getLandscape() {
        return landscape;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}
