package practice06.task06.model;

public enum DayOfWeek {
    MONDAY("MON"),
    TUESDAY("TUE"),
    WEDNESDAY("WED"),
    THURSDAY("THU"),
    FRIDAY("FRI"),
    SATURDAY("SAT"),
    SUNDAY("SUN");

    private String dayName;

    DayOfWeek(String dayName) {
        this.dayName = dayName;
    }

    public String getDayName() {
        return this.dayName;
    }

    @Override
    public String toString() {
        return "Day: " + name() + " / " + this.dayName;
    }
}
