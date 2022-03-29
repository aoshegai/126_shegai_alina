package task;

public enum Direction {
    North (0,-1),
    West (-1,0),
    South (0,1),
    East (1,0);
    private int moveX;
    private int moveY;
    Direction(int moveX, int moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }
    public Vector2 move(Vector2 start, double length) {
        return new Vector2(start.getX() + length * moveX, start.getY() + length * moveY);
    }
}
