package elizova.shapes;

import java.util.Comparator;

public class SortByArea implements Comparator<Shape> {
    double epsilon = 1.0e-10;

    @Override
    public int compare(Shape shape1, Shape shape2) {
        if ((shape2.getArea() - shape1.getArea()) > epsilon) {
            return -1;
        } else if (Math.abs(shape1.getArea() - shape2.getArea()) < epsilon) {
            return 0;
        } else {
            return 1;
        }
    }
}
