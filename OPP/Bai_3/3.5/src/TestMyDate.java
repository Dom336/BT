public class TestMyDate {
    public static void main(String[] args) {
        MyDate d1 = new MyDate(2012, 2, 28);
        System.out.println(d1);
        System.out.println(d1.nextDay());
        System.out.println(d1.nextDay());
        System.out.println(d1.nextMonth());
        System.out.println(d1.nextYear());

        MyDate d2 = new MyDate(2012, 1, 2);
        System.out.println(d2);
        System.out.println(d2.previousDay());
        System.out.println(d2.previousDay());
        System.out.println(d2.previousMonth());
        System.out.println(d2.previousYear());

        MyDate d3 = new MyDate(2012, 2, 29);
        System.out.println(d3.previousYear());

        // Uncomment to test invalid cases
        // MyDate d4 = new MyDate(2099, 11, 31); // Invalid year, month, or day!
        // MyDate d5 = new MyDate(2011, 2, 29);  // Invalid year, month, or day!

        // Loop test: 28 Dec 2011 to 2 Mar 2012
        MyDate loopDate = new MyDate(2011, 12, 28);
        while (!(loopDate.getYear() == 2012 && loopDate.getMonth() == 3 && loopDate.getDay() == 3)) {
            System.out.println(loopDate);
            loopDate.nextDay();
        }
    }
}
