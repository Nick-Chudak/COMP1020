/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 2, question 1
 * @author       Mykola Chudak, 8043157
 * @version      2/20/2025
 */

public class Stop {
    private String stationName;
    private String arrivalTime;
    private String departureTime;

    public Stop(String stationName, String arrivalTime, String departureTime) {

        if (stationName == null || stationName.isBlank()) {
            throw new IllegalArgumentException("Station name can not be null or empty");
        }
        if (!isValidTime(arrivalTime) || !isValidTime(departureTime)) {
            throw new IllegalArgumentException("Invalid time format: Times must be in HH:mm format");
        }

        this.stationName = stationName;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;

    }

    public String getStationName() {
        return this.stationName;
    }

    public String getArrivalTime() {
        return this.arrivalTime;
    }

    public String getDepartureTime() {
        return this.departureTime;
    }

    public String toString() {
        return String.format("Stop Name: %s, Arrival: %s, Departure: %s", this.stationName, this.arrivalTime, this.departureTime);
    }

    public static int compareTimes(String time1, String time2) throws BadScheduleException {
        if (!isValidTime(time1) || !isValidTime(time2)) {
            throw new BadScheduleException("Invalid time format: Times must be in HH:mm format");
        }

        String[] t1 = time1.split(":");
        String[] t2 = time2.split(":");

        int hour1 = Integer.parseInt(t1[0]);
        int minute1 = Integer.parseInt(t1[1]);
        int hour2 = Integer.parseInt(t2[0]);
        int minute2 = Integer.parseInt(t2[1]);

        if (hour1 != hour2) {
            return hour1 - hour2;
        } else {
            return minute1 - minute2;
        }
    }

    public static boolean isValidTime(String time) {

        if (time == null || time.length() != 5 || time.charAt(2) != ':') {
            return false;
        }

        try {
            int hours = Integer.parseInt(time.split(":")[0]);
            int minutes = Integer.parseInt(time.split(":")[1]);

            return hours >= 0 && hours <= 23 && minutes >= 0 && minutes <= 59;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
