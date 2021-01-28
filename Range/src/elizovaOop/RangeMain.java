package elizovaOop;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        double from = 1.0;
        double to = 5.0;

        Range range = new Range(from, to);

        range.print();
        System.out.println();

        range.setFrom(3.2);
        range.setTo(6.2);

        range.print();
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        double number = scanner.nextDouble();

        if (range.isInside(number)) {
            System.out.printf("Число %f входит в диапазон", number);
        } else {
            System.out.printf("Число %f не входит в диапазон", number);
        }

        System.out.println();

        double length1 = range.getTo() - range.getFrom();
        double length2 = range.getLength();

        if (length1 == length2){
            System.out.println("Длины равны. Все верно.");
        } else {
            System.out.println("Ошибка. Длины не равны.");
        }
    }
}
