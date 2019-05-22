package com.company.stepik.robot;


public class Robot implements RobotConnection, RobotConnectionManager {
    private Direction direction;
    private int x;
    private int y;

    Robot(Direction direction, int x, int y) {
        this.direction = direction;
        this.x = x;
        this.y = y;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        int ordinal = getDirection().ordinal();
        if (ordinal == 0) {
            setDirection(Direction.LEFT);
        }
        if (ordinal == 1) {
            setDirection(Direction.RIGHT);
        }
        if (ordinal == 2) {
            setDirection(Direction.DOWN);
        }
        if (ordinal == 3) {
            setDirection(Direction.UP);
        }
        // повернуться на 90 градусов против часовой стрелки
    }

    public void turnRight() {
        int ordinal = direction.ordinal();
        if (ordinal == 0) {
            setDirection(Direction.RIGHT);
        }
        if (ordinal == 1) {
            setDirection(Direction.LEFT);
        }
        if (ordinal == 2) {
            setDirection(Direction.UP);
        }
        if (ordinal == 3) {
            setDirection(Direction.DOWN);
        }
        // повернуться на 90 градусов по часовой стрелке
    }

    public void stepForward() {
        if (direction == Direction.RIGHT)
            x++;
        if (direction == Direction.LEFT)
            x--;
        if (direction == Direction.UP)
            y++;
        if (direction == Direction.DOWN)
            y--;
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
    }

    @Override
    public void moveRobotTo(int x, int y) {

    }

    @Override
    public void close() {

    }

    @Override
    public RobotConnection getConnection() {
        return this;
    }
}
