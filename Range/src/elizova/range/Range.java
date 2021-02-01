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

    public String getIntersectionRange(double from, double to) {
        for (int i = (int) from; i <= getLength(); i++) {
            if (isInside(i) && i <= to) {
                from = i;

                for (int j = (int) to; j >= i; j--) {
                    if (isInside(j)) {
                        to = j;
                        return "Интервал-пересечения с " + from + " до " + to;
                    }
                }
            }
        }

        return null;
    }

    public String getUnion(double from, double to) {
        if (getIntersectionRange(from, to) == null) {
            if (this.from > from) {
                return "Диапазон объединения с " + from + " до " + to + " и с " + this.from + " до " + this.to;
            } else {
                return "Диапазон объединения с " + this.from + " до " + this.to + " и с " + from + " до " + to;
            }
        }

        double start = this.from;
        double end = to;

        if (this.from > from) {
            start = from;
            end = this.to;
        }

        return "Диапазон объединения с " + start + " до " + end;
    }

    /*
    public String getDifference(double from, double to) {
        if (this.from == from && this.to == to) {
            return "Разность = 0";
        }

        if (this.from != from && this.to != to){
            //код
        }

        //код для 3 случая
    }
    */
}
