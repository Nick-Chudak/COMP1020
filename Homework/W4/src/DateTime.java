public class DateTime implements Comparable<DateTime> {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    private int second;

    public DateTime(String dateTime) {
        String[] dateParts = dateTime.split(" ");

        this.year = Integer.parseInt(dateParts[0].split("-")[0]);
        this.month = Integer.parseInt(dateParts[0].split("-")[1]);
        this.day = Integer.parseInt(dateParts[0].split("-")[2]);

        this.hour = Integer.parseInt(dateParts[1].split(":")[0]);
        this.minute = Integer.parseInt(dateParts[1].split(":")[1]);
        this.second = Integer.parseInt(dateParts[1].split(":")[2]);
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public int compareTo(DateTime other) {

        if (this.year != other.getYear()) {
            return Integer.compare(this.year, other.getYear());
        }
        if (this.month != other.getMonth()) {
            return Integer.compare(this.month, other.getMonth());
        }
        if (this.day != other.getDay()) {
            return Integer.compare(this.day, other.getDay());
        }
        if (this.hour != other.getHour()) {
            return Integer.compare(this.hour, other.getHour());
        }
        if (this.minute != other.getMinute()) {
            return Integer.compare(this.minute, other.getMinute());
        }

        return Integer.compare(this.second, other.getSecond());
    }

    public String toString() {
        return String.format("%04d-%02d-%02d %02d:%02d:%02d", this.getYear(), this.getMonth(), this.getDay(), this.getHour(), this.getMinute(), this.getSecond());
    }
}
