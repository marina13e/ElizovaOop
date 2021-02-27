package elizova.vector;

import java.util.Arrays;

public class Vector {
    private final int n;
    private double[] vector;

    public Vector(int n) {
        this.n = n;
        vector = new double[n];

        if (n <= 0) {
            throw new IllegalArgumentException("n must be > 0");
        }

        for (int i = 0; i < n; i++) {
            vector[i] = 0;
        }
    }

    public Vector(Vector v) {
        n = v.n;
        vector = new double[n];
        vector = v.vector;
    }

    public Vector(double[] array) {
        n = array.length;
        vector = new double[n];

        for (int i = 0; i < array.length; i++) {
            vector[i] = array[i];
        }
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

    @Override
    public String toString(){
        return Arrays.toString(vector);
    }
}
