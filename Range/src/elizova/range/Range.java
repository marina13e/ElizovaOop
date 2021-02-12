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

    public void print() {
        System.out.printf("(%f, %f)", from, to);
    }

    public static void print(Range[] ranges, String function) {
        System.out.printf("Результат %s: [", function);

        if (ranges.length != 0) {
            for (Range e : ranges) {
                e.print();
            }
        }

        System.out.println("]");
    }

    public Range getIntersection(Range range) {
        double from2 = range.getFrom();
        double to2 = range.getTo();

        if ((from > to2) || (to < from2)) {
            return null;
        }

        return new Range(Math.max(from, from2), Math.min(to, to2));
    }

    public Range[] getUnion(Range range) {
        double from2 = range.getFrom();
        double to2 = range.getTo();

        if (getIntersection(range) == null) {
            Range range1 = new Range(from, to);
            Range range2 = new Range(from2, to2);

            if (from > from2) {
                return new Range[]{range2, range1};
            }

            return new Range[]{range1, range2};
        }

        return new Range[]{new Range(Math.min(from, from2), Math.max(to, to2))};
    }

    public Range[] getDifference(Range range) {
        double from2 = range.getFrom();
        double to2 = range.getTo();

        if (from2 <= this.from && to2 >= this.to) {
            return new Range[0];
        }

        double from1 = this.from;
        double to1 = from2;
        Range range1 = new Range(from1, to1);

        if (to2 > this.to) {
            return new Range[]{range1};
        }

        from2 = to2 + 1;
        to2 = this.to;
        Range range2 = new Range(from2, to2);

        if (to2 < this.to) {
            return new Range[]{range2};
        }

        return new Range[]{range1, range2};
    }
}
