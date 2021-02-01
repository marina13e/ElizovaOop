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

    public double getTo() {
        return to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public void print() {
        System.out.printf("Диапазон с %f до %f", from, to);
    }

    public boolean isInside(double number) {
        return number >= from && number <= to;
    }

    public Range getIntersectionRange(double from, double to) {
        for (int i = (int) from; i <= getLength(); i++) {
            if (isInside(i) && i <= to) {
                from = i;

                for (int j = (int) to; j >= i; j--) {
                    if (isInside(j)) {
                        to = j;
                        return new Range(from, to);
                    }
                }
            }
        }

        return null;
    }

    public void print(Range[] rangesArray) {
        for (Range e : rangesArray) {
            e.print();
        }
    }

    public Range[] getUnion(double from, double to) {
        if (getIntersectionRange(from, to) == null) {
            Range range1 = new Range(this.from, this.to);
            Range range2 = new Range(from, to);

            if (this.from > from) {
                return new Range[]{range2, range1};
            } else {
                return new Range[]{range1, range2};
            }
        }

        double start = this.from;
        double end = to;

        if (this.from > from) {
            start = from;
            end = this.to;
        }

        return new Range[]{new Range(start, end)};
    }

    public Range[] getDifference(double from, double to) {
        if ((this.from == from && this.to == to)) {
            return new Range[]{new Range(0, 0)};
        }

        if (from <= this.from) {
            from = to + 1;
            to = this.to;
        } else {
            to = from;
            from = this.from;
        }

        return new Range[]{new Range(from, to)};
    }
}
