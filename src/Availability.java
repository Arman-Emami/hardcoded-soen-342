public class Availability {
    private String weekDayAvailable;
    private String startTime;  // or use LocalTime
    private String endTime;    // or use LocalTime

    // Constructors
    public Availability() {}

    public Availability(String weekDayAvailable, String startTime, String endTime) {
        this.weekDayAvailable = weekDayAvailable;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Getters and Setters
    public String getWeekDayAvailable() {
        return weekDayAvailable;
    }

    public void setWeekDayAvailable(String weekDayAvailable) {
        this.weekDayAvailable = weekDayAvailable;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
