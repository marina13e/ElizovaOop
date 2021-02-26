package elizova.range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getLength() {
        return to - from;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "(" + from + ", " + to + ")";
    }

    public static void print(Range[] ranges, String function) {
        System.out.printf("Результат %s: [", function);

        if (ranges.length != 0) {
            for (Range e : ranges) {
                System.out.print(e.toString());
            }
        }

        System.out.println("]");
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if ((from >= range.to) || (to <= range.from)) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (getIntersection(range) == null) {
            Range range1 = new Range(from, to);
            Range range2 = new Range(range.from, range.to);

            if (from > range.from) {
                return new Range[]{range2, range1};
            }

            return new Range[]{range1, range2};
        }

        return new Range[]{new Range(Math.min(from, range.from), Math.max(to, range.to))};
    }

    public Range[] getDifference(Range range) {
        if (range.from <= from && range.to >= to) {
            return new Range[0];
        }

        double from1 = from;
        double to1 = range.from;
        Range range1 = new Range(from1, to1);

        if (range.to > to) {
            return new Range[]{range1};
        }

        range.from = range.to + 1;
        range.to = to;
        Range range2 = new Range(range.from, range.to);

        if (range.to < to) {
            return new Range[]{range2};
        }

        return new Range[]{range1, range2};
    }
}
