package elizova.shapes_main;

import elizova.shapes.Shape;

import java.util.Comparator;

public class AreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getArea(), shape2.getArea());
    }
}
