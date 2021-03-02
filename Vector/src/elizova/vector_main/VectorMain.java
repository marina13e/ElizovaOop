package elizova.vector_main;

import elizova.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        try {
            Vector vector1 = new Vector(5);
            System.out.println("Vector 1 = " + vector1.toString());

            Vector vector2 = new Vector(vector1);
            System.out.println("Vector 2 = " + vector2.toString());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        double[] array = {0, 1, 2, 3, 4, 5, 6};

        Vector vector3 = new Vector(array);
        System.out.println("Vector 3 = " + vector3.toString());

        Vector vector4 = new Vector(10, array);
        System.out.println("Vector 4 = " + vector4.toString());

        System.out.println("Sum = " + vector3.getSum(vector4));
        System.out.println("Different = " + vector3.getDifferent(vector4));
        System.out.println("Multiplication Result = " + vector3.getMultiplicationResult(5));

        System.out.println("Unfolded Vector 4 = " + vector4.unfoldVector());
        vector4.unfoldVector();

        System.out.println("Vector 4 length = " + vector4.getLength());

        System.out.println("Vector 4 component with index 4 = " + vector4.getComponent(4));
        vector4.setComponent(4, 8);
        System.out.println("Vector 4 component with index 4 = " + vector4.getComponent(4));

        Vector vectorsSum = Vector.getSum(vector3, vector4);
        System.out.println("Sum = " + vectorsSum);

        Vector vectorsDifferent = Vector.getDifferent(vectorsSum, vector4);
        System.out.println("Different = " + vectorsDifferent);

        Vector vectorsMultiplicationResult = Vector.getMultiplicationResult(4, vectorsDifferent);
        System.out.println("Multiplication Result = " + vectorsMultiplicationResult);
    }
}
