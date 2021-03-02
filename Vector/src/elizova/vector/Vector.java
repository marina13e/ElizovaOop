package elizova.vector;

import java.util.Arrays;

public class Vector {
    private int n;
    private double[] vector;

    public Vector(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        this.n = n;
        vector = new double[n];

        for (int i = 0; i < n; i++) {
            vector[i] = 0;
        }
    }

    public Vector(Vector v) {
        n = v.n;
        vector = v.vector;
    }

    public Vector(double[] array) {
        n = array.length;
        vector = array;
    }

    public Vector(int n, double[] array) {
        this.n = n;
        vector = new double[n];

        for (int i = 0; i < array.length; i++) {
            vector[i] = array[i];
        }

        if (n > array.length) {
            for (int i = array.length; i < n; i++) {
                vector[i] = 0;
            }
        }
    }

    public double[] getVector() {
        return vector;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
        vector = new double[n];
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    public int getSize() {
        return n;
    }

    public Vector getSum(Vector vector) {
        for (int i = 0; i < getSize(); i++) {
            vector.vector[i] += this.vector[i];
        }

        return vector;
    }

    public Vector getDifferent(Vector vector) {
        for (int i = 0; i < getSize(); i++) {
            vector.vector[i] -= this.vector[i];
        }

        return vector;
    }

    public Vector getMultiplicationResult(int scalar) {
        Vector multiplicationResult = new Vector(vector);

        for (int i = 0; i < getSize(); i++) {
            multiplicationResult.vector[i] *= scalar;
        }

        return multiplicationResult;
    }

    public Vector unfoldVector() {
        Vector unfoldedVector = new Vector(vector);
        final int x = -1;

        for (int i = 0; i < getSize(); i++) {
            unfoldedVector.vector[i] *= x;
        }

        return unfoldedVector;
    }

    public int getLength() {
        return vector.length;
    }

    public double getComponent(int index) {
        return vector[index];
    }

    public void setComponent(int index, double component) {
        vector[index] = component;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }

        if (object == null || object.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) object;
        boolean componentsEqual = true;

        for (int i = 0; i < vector.getLength(); i++) {
            if (vector.vector[i] != this.vector[i]) {
                componentsEqual = false;
                break;
            }
        }

        return n == vector.n && componentsEqual;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(vector);
        hash = prime * hash + Integer.hashCode(n);
        return hash;
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vectorSumResult = new Vector (Math.max(vector1.n, vector2.n), vector1.vector);

        for (int i = 0; i < vectorSumResult.getLength(); i++) {
            vectorSumResult.vector[i] += vector2.vector[i];
        }

        return  vectorSumResult;
    }

    public static Vector getDifferent(Vector vector1, Vector vector2) {
        Vector vectorSumResult = new Vector (Math.max(vector1.n, vector2.n), vector1.vector);

        for (int i = 0; i < vectorSumResult.getLength(); i++) {
            vectorSumResult.vector[i] -= vector2.vector[i];
        }

        return  vectorSumResult;
    }

    public static Vector getMultiplicationResult(int scalar, Vector vector) {
        for (int i = 0; i < vector.getLength(); i++) {
            vector.vector[i] *= scalar;
        }

        return vector;
    }
}
