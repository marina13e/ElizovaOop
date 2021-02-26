package elizova.shapes_main;

import elizova.shapes.*;

import java.util.Arrays;

public class ShapesMain {
    public static void main(String[] args) {
        Shape triangle1 = new Triangle(1, 3, 2, 4, 6, 8);

        double triangleWidth = triangle1.getWidth();
        double triangleHeight = triangle1.getHeight();
        System.out.printf("Ширина треугольника = %f%nВысота треугольника = %f%n",
                triangleWidth, triangleHeight);

        double trianglePerimeter = triangle1.getPerimeter();
        System.out.println("Периметр треугольника = " + trianglePerimeter);

        double triangleArea = triangle1.getArea();
        System.out.println("Площадь треугольника = " + triangleArea);

        Shape square1 = new Square(3);

        double squareWidth = square1.getWidth();
        double squareHeight = square1.getHeight();
        System.out.printf("Ширина квадрата = %f%nВысота квадрата = %f%n",
                squareWidth, squareHeight);

        double squarePerimeter = square1.getPerimeter();
        System.out.println("Периметр квадрата = " + squarePerimeter);

        double squareArea = square1.getArea();
        System.out.println("Площадь квадрата = " + squareArea);

        Shape rectangle1 = new Rectangle(3, 8);

        double rectangleWidth = rectangle1.getWidth();
        double rectangleHeight = rectangle1.getHeight();
        System.out.printf("Ширина прямоугольника = %f%nВысота прямоугольника = %f%n",
                rectangleWidth, rectangleHeight);

        double rectanglePerimeter = rectangle1.getPerimeter();
        System.out.println("Периметр прямоугольника = " + rectanglePerimeter);

        double rectangleArea = rectangle1.getArea();
        System.out.println("Площадь прямоугольника = " + rectangleArea);

        Shape circle1 = new Circle(4);

        double circleWidth = circle1.getWidth();
        double circleHeight = circle1.getHeight();
        System.out.printf("Ширина круга = %f%nВысота круга = %f%n",
                circleWidth, circleHeight);

        double circlePerimeter = circle1.getPerimeter();
        System.out.println("Периметр круга = " + circlePerimeter);

        double circleArea = circle1.getArea();
        System.out.println("Площадь круга = " + circleArea);

        Shape square2 = new Square(8);

        Shape rectangle2 = new Rectangle(7, 12);

        Shape[] shapes = {square1, square2, rectangle1, rectangle2, circle1, triangle1};

        Arrays.sort(shapes, new SortByArea());
        System.out.println("Фигура с наибольшей площадью: " + shapes[shapes.length - 1].toString());

        Arrays.sort(shapes, new SortByPerimeter());
        System.out.println("Фигура со вторым по величине периметром: " + shapes[1].toString());

        boolean isSameSquares = square1.equals(square2);

        if (isSameSquares) {
            System.out.println("Фигуры одинаковые");
        } else {
            System.out.println("Фигуры разные");
        }

        int hashCode = square1.hashCode();
        System.out.println("Hash Code = " + hashCode);
    }
}
