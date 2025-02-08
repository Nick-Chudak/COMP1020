import java.time.LocalTime;

public class Stop {
    private String stationName;
    private String arrivalTime;
    private String departureTime;

    // try {
    //     int num = Integer.parseInt()
    // }

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
        
        LocalTime localTime1 = LocalTime.parse(time1);
        LocalTime localTime2 = LocalTime.parse(time2);

        return localTime1.compareTo(localTime2);
    }

    public static boolean isValidTime(String time) {
        boolean result = true;

        if (time == null || time.length() != 5 || time.charAt(2) != ':') {
            return false;
        }

        try {
            int hours = Integer.parseInt(time.split(":")[0]);
            int minutes = Integer.parseInt(time.split(":")[1]);

            if (!(hours >= 0 && hours <= 23) && (minutes >= 0 && minutes <= 59)) {
                result = false;
            }
        
        } catch (NumberFormatException e) {
            result =  false;
        }

        return result;
    }
}
