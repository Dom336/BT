public class MyDate {
    private int year;
    private int month;
    private int day;

    public static final String[] MONTHS = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public static final String[] DAYS = {
        "Sunday", "Monday", "Tuesday", "Wednesday",
        "Thursday", "Friday", "Saturday"
    };

    public static final int[] DAYS_IN_MONTHS = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
    };

    public MyDate(int year, int month, int day) {
        setDate(year, month, day);
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static boolean isValidDate(int year, int month, int day) {
        if (year < 1 || year > 9999 || month < 1 || month > 12)
            return false;
        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) dayMax = 29;
        return day >= 1 && day <= dayMax;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (day + (13*(month + 1)) / 5 + k + k/4 + j/4 + 5*j) % 7;
        return (h + 6) % 7;
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day))
            throw new IllegalArgumentException("Invalid year, month, or day!");
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() { return year; }
    public int getMonth() { return month; }
    public int getDay() { return day; }

    public void setYear(int year) {
        if (year < 1 || year > 9999)
            throw new IllegalArgumentException("Invalid year!");
        this.year = year;
        if (!isValidDate(this.year, this.month, this.day)) {
            this.day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(this.year)) this.day = 29;
        }
    }

    public void setMonth(int month) {
        if (month < 1 || month > 12)
            throw new IllegalArgumentException("Invalid month!");
        this.month = month;
        if (!isValidDate(this.year, this.month, this.day)) {
            this.day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(this.year)) this.day = 29;
        }
    }

    public void setDay(int day) {
        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) dayMax = 29;
        if (day < 1 || day > dayMax)
            throw new IllegalArgumentException("Invalid day!");
        this.day = day;
    }

    public MyDate nextDay() {
        day++;
        if (!isValidDate(year, month, day)) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
                if (year > 9999)
                    throw new IllegalStateException("Year out of range!");
            }
        }
        return this;
    }

    public MyDate nextMonth() {
        month++;
        if (month > 12) {
            month = 1;
            year++;
            if (year > 9999)
                throw new IllegalStateException("Year out of range!");
        }
        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) dayMax = 29;
        if (day > dayMax) day = dayMax;
        return this;
    }

    public MyDate nextYear() {
        year++;
        if (year > 9999)
            throw new IllegalStateException("Year out of range!");
        if (!isValidDate(year, month, day)) {
            day = (month == 2 && isLeapYear(year)) ? 29 : DAYS_IN_MONTHS[month - 1];
        }
        return this;
    }

    public MyDate previousDay() {
        day--;
        if (day < 1) {
            month--;
            if (month < 1) {
                month = 12;
                year--;
            }
            if (year < 1)
                throw new IllegalStateException("Year out of range!");
            day = DAYS_IN_MONTHS[month - 1];
            if (month == 2 && isLeapYear(year)) day = 29;
        }
        return this;
    }

    public MyDate previousMonth() {
        month--;
        if (month < 1) {
            month = 12;
            year--;
        }
        if (year < 1)
            throw new IllegalStateException("Year out of range!");
        int dayMax = DAYS_IN_MONTHS[month - 1];
        if (month == 2 && isLeapYear(year)) dayMax = 29;
        if (day > dayMax) day = dayMax;
        return this;
    }

    public MyDate previousYear() {
        year--;
        if (year < 1)
            throw new IllegalStateException("Year out of range!");
        if (!isValidDate(year, month, day)) {
            day = (month == 2 && isLeapYear(year)) ? 29 : DAYS_IN_MONTHS[month - 1];
        }
        return this;
    }

    public String toString() {
        int dow = getDayOfWeek(year, month, day);
        return String.format("%s %d %s %d", DAYS[dow], day, MONTHS[month - 1], year);
    }
}
