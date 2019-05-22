package com.company.stepik.robot;

class Demo {

    public static void main(String[] args) {

        Robot artEv = new Robot(Direction.DOWN, 7, 5);
        System.out.println("Current robot location: " + artEv.getDirection() + " x:"
                + artEv.getX() + " y:" + artEv.getY());

        Demo demo = new Demo();
        demo.moveRobot(artEv, 3, 1);

        System.out.println("New robot location: " +artEv.getDirection() + " x:" + artEv.getX() + " y:" + artEv.getY());
    }

    public static void moveRobot(Robot robot, int toX, int toY) {
        int currX = robot.getX();
        int currY = robot.getY();
        if (toX > currX) {
            while (robot.getDirection() != Direction.RIGHT) {
                robot.turnRight();
            }
            while (toX != robot.getX()) {
                robot.stepForward();
            }
        } else {
            while (robot.getDirection() != Direction.LEFT) {
                robot.turnLeft();
            }
            while (toX != robot.getX()) {
                robot.stepForward();
            }
        }
        if (toY > currY) {
            while (robot.getDirection() != Direction.UP) {
                robot.turnRight();
            }
            while (toY != robot.getY()) {
                robot.stepForward();
            }
        } else {
            while (robot.getDirection() != Direction.DOWN) {
                robot.turnLeft();
            }
            while (toY != robot.getY()) {
                robot.stepForward();
            }
        }
    }
}
