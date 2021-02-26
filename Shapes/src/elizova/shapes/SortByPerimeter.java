package elizova.shapes;

import java.util.Comparator;

public class SortByPerimeter implements Comparator<Shape> {
    double epsilon = 1.0e-10;

    @Override
    public int compare(Shape shape1, Shape shape2) {
        if ((shape2.getPerimeter() - shape1.getPerimeter()) > epsilon) {
            return -1;
        } else if (Math.abs(shape1.getPerimeter() - shape2.getPerimeter()) < epsilon) {
            return 0;
        } else {
            return 1;
        }
    }
}
