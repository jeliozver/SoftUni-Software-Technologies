package IntersectionOfCircles;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] circleOneProperties = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double[] circleTwoProperties = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Circle circleOne = GetCircleInfo(circleOneProperties);
        Circle circleTwo = GetCircleInfo(circleTwoProperties);

        System.out.println(IsCirclesIntersect(circleOne, circleTwo)
                ? "Yes"
                : "No");
    }

    public static Circle GetCircleInfo(double[] circleProperties) {
        Point circleCenter = new Point();
        circleCenter.setX(circleProperties[0]);
        circleCenter.setY(circleProperties[1]);

        Circle circle = new Circle();
        circle.setRadius(circleProperties[2]);
        circle.setCenter(circleCenter);

        return circle;
    }

    public static boolean IsCirclesIntersect(Circle circleOne, Circle circleTwo) {
        Point circleOneCenter = circleOne.getCenter();
        Point circleTwoCenter = circleTwo.getCenter();

        double distance = CalcDistance(circleOneCenter, circleTwoCenter);

        return !(distance > circleOne.getRadius() + circleTwo.getRadius());
    }

    public static double CalcDistance(Point firstPoint, Point secondPoint) {
        double diffX = firstPoint.getX() - secondPoint.getX();
        double diffY = firstPoint.getY() - secondPoint.getY();

        double powX = Math.pow(diffX, 2);
        double powY = Math.pow(diffY, 2);

        return Math.sqrt(powX + powY);
    }
}