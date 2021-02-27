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

    public static String getString(Range[] ranges) {
        StringBuilder rangeArray = new StringBuilder();

        rangeArray.append("[");

        for (int i = 0; i < ranges.length - 1; i++) {
            rangeArray.append(ranges[i].toString())
                    .append(", ");
        }

        rangeArray.append(ranges[ranges.length - 1].toString())
                .append("]");

        return rangeArray.toString();
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersection(Range range) {
        if (from >= range.to || to <= range.from) {
            return null;
        }

        return new Range(Math.max(from, range.from), Math.min(to, range.to));
    }

    public Range[] getUnion(Range range) {
        if (from >= range.to || to <= range.from) {
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

        Range range1 = new Range(from, range.from);

        if (range.to > to) {
            return new Range[]{range1};
        }

        Range range2 = new Range(range.to, to);

        if (from > range.from) {
            return new Range[]{range2};
        }

        return new Range[]{range1, range2};
    }
}
