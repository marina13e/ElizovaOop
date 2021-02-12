package elizova.range_main;

import elizova.range.Range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        double from1 = 3.2;
        double to1 = 6.2;

        Range range1 = new Range(from1, to1);

        range1.print();
        System.out.println();

        range1.setFrom(1.0);
        range1.setTo(6.0);

        System.out.printf("Значения from и to были изменены%nДиапазон начинается со значения %f%n" +
                "Диапазон кончается значением %f%n", range1.getFrom(), range1.getTo());

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число:");
        double number = scanner.nextDouble();

        if (number >= range1.getFrom() && number <= range1.getTo()) {
            System.out.printf("Число %f входит в диапазон", number);
        } else {
            System.out.printf("Число %f не входит в диапазон", number);
        }

        System.out.println();

        double range1Length = range1.getLength();
        System.out.println("Длина диапазона = " + range1Length);

        double from2 = 3.0;
        double to2 = 4.0;

        Range range2 = new Range(from2, to2);

        Range intersection = range1.getIntersection(range2);
        System.out.print("Результат поиска пересечения: ");

        if (intersection == null) {
            System.out.println("Значение отсутствует");
        } else {
            intersection.print();
            System.out.println();
        }

        Range[] union = range1.getUnion(range2);
        Range.print(union, "объединения");

        Range[] difference = range1.getDifference(range2);
        Range.print(difference, "разницы");
    }
}
