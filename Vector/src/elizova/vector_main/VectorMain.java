package elizova.vector_main;

import elizova.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        Vector vector1 = new Vector(5);
        System.out.println("Vector 1 = " + vector1.toString());

        Vector vector2 = new Vector(vector1);
        System.out.println("Vector 2 = " + vector2.toString());

        double[] array = {0, 1, 2, 3, 4, 5, 6};

        Vector vector3 = new Vector(array);
        System.out.println("Vector 3 = " + vector3.toString());

        Vector vector4 = new Vector(10, array);
        System.out.println("Vector 4 = " + vector4.toString());
    }
}
