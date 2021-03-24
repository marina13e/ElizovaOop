package elizova.vector_main;

import elizova.vector.Vector;

public class VectorMain {
    public static void main(String[] args) {
        int componentArrayLength = -3;

        try {
            Vector vector1 = new Vector(componentArrayLength);
            System.out.println("Vector 1 = " + vector1);

            Vector vector2 = new Vector(vector1);
            System.out.println("Vector 2 = " + vector2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "; значение аргумента = " + componentArrayLength);
        }

        double[] array = {0, 1, 2, 3, 4, 5, 6};

        Vector vector3 = new Vector(array);
        System.out.println("Vector 3 = " + vector3);

        Vector vector4 = new Vector(10, array);
        System.out.println("Vector 4 = " + vector4);

        System.out.println("Sum = " + vector3.addVector(vector4));
        System.out.println("Different = " + vector3.subtractVector(vector4));

        System.out.println("Multiplication Result = " + vector3.multiplyByScalar(5));

        System.out.println("Unfolded Vector 4 = " + vector4.turn());
        vector4.turn();

        System.out.println("Vector 4 length = " + vector4.getLength());

        System.out.println("Vector 4 component with index 4 = " + vector4.getComponent(4));
        vector4.setComponent(4, 8);
        System.out.println("Vector 4 component with index 4 = " + vector4.getComponent(4));

        Vector vectorsSum = Vector.addVector(vector3, vector4);
        System.out.println("Sum = " + vectorsSum);

        Vector vectorsDifferent = Vector.subtractVector(vectorsSum, vector4);
        System.out.println("Different = " + vectorsDifferent);

        Vector vectorsMultiplicationResult = Vector.multiplyVectors(vector3, vectorsDifferent);
        System.out.println("Multiplication Result = " + vectorsMultiplicationResult);
        System.out.println("Vector Size = " + vectorsMultiplicationResult.getSize());
    }
}
