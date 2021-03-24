package elizova.vector;

import java.util.Arrays;

public class Vector {
    private final double[] componentArray;

    public Vector(int componentArrayLength) {
        if (componentArrayLength <= 0) {
            throw new IllegalArgumentException("component array length must be > 0");
        }

        componentArray = new double[componentArrayLength];
    }

    public Vector(Vector v) {
        componentArray = Arrays.copyOf(v.componentArray, v.getSize());
    }

    public Vector(double[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("component array length must be > 0");
        }

        componentArray = Arrays.copyOf(array, array.length);
    }

    public Vector(int componentArrayLength, double[] array) {
        if (componentArrayLength <= 0) {
            throw new IllegalArgumentException("component array length must be > 0");
        }

        if (componentArrayLength < array.length) {
            throw new IllegalArgumentException("component array length must be >= array length");
        }

        componentArray = Arrays.copyOf(array, componentArrayLength);
    }

    @Override
    public String toString() {
        return "{" + Arrays.toString(componentArray) + "}";
    }

    public int getSize() {
        return componentArray.length;
    }

    public Vector addVector(Vector vector) {
        int minSize = Math.min(getSize(), vector.getSize());

        for (int i = 0; i < minSize; i++) {
            this.componentArray[i] += vector.componentArray[i];
        }

        return this;
    }

    public Vector subtractVector(Vector vector) {
        int minSize = Math.min(getSize(), vector.getSize());

        for (int i = 0; i < minSize; i++) {
            this.componentArray[i] -= vector.componentArray[i];
        }

        return this;
    }

    public Vector multiplyByScalar(double scalar) {
        for (int i = 0; i < getSize(); i++) {
            componentArray[i] *= scalar;
        }

        return this;
    }

    public Vector turn() {
        return this.multiplyByScalar(-1);
    }

    public double getLength() {
        return componentArray[componentArray.length - 1] - componentArray[0];
    }

    public double getComponent(int index) {
        return componentArray[index];
    }

    public void setComponent(int index, double component) {
        componentArray[index] = component;
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

        for (int i = 0; i < vector.getSize(); i++) {
            if (vector.componentArray[i] != this.componentArray[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 7;
        int hash = 1;
        return prime * hash + Arrays.hashCode(componentArray);
    }

    public static Vector addVector(Vector vector1, Vector vector2) {
        return vector1.addVector(vector2);
    }

    public static Vector subtractVector(Vector vector1, Vector vector2) {
        return vector1.subtractVector(vector2);
    }

    public static Vector multiplyVectors(Vector vector1, Vector vector2) {
        int maxSize = Math.max(vector1.getSize(), vector2.getSize());
        Vector product = new Vector(maxSize, vector1.componentArray);

        for (int i = 0; i < product.getSize() - 1; i++) {
            vector1.componentArray[i] *= vector2.componentArray[i];
        }

        return product;
    }
}
