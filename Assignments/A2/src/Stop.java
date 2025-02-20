public class Stop {
    private String stationName;
    private String arrivalTime;
    private String departureTime;

    // try {
    // int num = Integer.parseInt()
    // }
    public static void main(String[] args) throws BadTrainException, BadScheduleException{
        // Creating a valid Stop object
        Stop stop1 = new Stop("Central Station", "10:30", "11:00");
        System.out.println(stop1);
        // Expected output: Stop Name: Central Station, Arrival: 10:30, Departure: 11:00

        // Accessing and displaying station name
        System.out.println("Station Name: " + stop1.getStationName());
        // Expected output: Station Name: Central Station

        // Accessing and displaying arrival time
        System.out.println("Arrival Time: " + stop1.getArrivalTime());
        // Expected output: Arrival Time: 10:30

        // Accessing and displaying departure time
        System.out.println("Departure Time: " + stop1.getDepartureTime());
        // Expected output: Departure Time: 11:00

        // Comparing two times
        int comparisonResult = Stop.compareTimes("10:30", "11:00");
        System.out.println("Comparing 10:30 and 11:00: " + comparisonResult);
        // Expected output: Comparing 10:30 and 11:00: -1 (indicating 10:30 < 11:00)

        // Check a valid time
        boolean validTime = Stop.isValidTime("23:59");
        System.out.println("Checking if 23:59 is a valid time: " + validTime);
        // Expected output: Checking if 23:59 is a valid time: true

        // Check an invalid time
        boolean inValidTime = Stop.isValidTime("-15:59.4");
        System.out.println("Checking if -15:59.4 is a valid time: " + inValidTime);
      // Expected ooutput: Checking if -15:59.4 is a valid time: false
    }

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
