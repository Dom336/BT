public class TestMyTime {
    public static void main(String[] args) {
        System.out.println("Testing MyTime class");
        
        System.out.println("\nTest constructor and toString():");
        MyTime t1 = new MyTime();
        System.out.println("Default time: " + t1);
        
        MyTime t2 = new MyTime(23, 59, 58);
        System.out.println("Time t2: " + t2);
        
        System.out.println("\nTest getters:");
        System.out.println("Hour: " + t2.getHour());
        System.out.println("Minute: " + t2.getMinute());
        System.out.println("Second: " + t2.getSecond());
        
        System.out.println("\nTest setters:");
        t1.setHour(12);
        t1.setMinute(30);
        t1.setSecond(45);
        System.out.println("After setters, t1: " + t1);
        
        System.out.println("\nTest setTime():");
        t1.setTime(23, 59, 59);
        System.out.println("After setTime, t1: " + t1);
        
        System.out.println("\nTest nextSecond():");
        System.out.println(t1 + " -> " + t1.nextSecond());
        System.out.println(t1 + " -> " + t1.nextSecond());
        
        System.out.println("\nTest nextMinute():");
        t2.setTime(23, 59, 0);
        System.out.println(t2 + " -> " + t2.nextMinute());
        System.out.println(t2 + " -> " + t2.nextMinute());
        
        System.out.println("\nTest nextHour():");
        t2.setTime(23, 0, 0);
        System.out.println(t2 + " -> " + t2.nextHour());
        System.out.println(t2 + " -> " + t2.nextHour());
        
        System.out.println("\nTest previousSecond():");
        t2.setTime(0, 0, 0);
        System.out.println(t2 + " -> " + t2.previousSecond());
        System.out.println(t2 + " -> " + t2.previousSecond());
        
        System.out.println("\nTest previousMinute():");
        t2.setTime(0, 0, 30);
        System.out.println(t2 + " -> " + t2.previousMinute());
        System.out.println(t2 + " -> " + t2.previousMinute());
        
        System.out.println("\nTest previousHour():");
        t2.setTime(0, 30, 30);
        System.out.println(t2 + " -> " + t2.previousHour());
        System.out.println(t2 + " -> " + t2.previousHour());
        
        System.out.println("\nTest exception handling:");
        try {
            t1.setHour(24);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception for invalid hour: " + e.getMessage());
        }
        
        try {
            t1.setMinute(60);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception for invalid minute: " + e.getMessage());
        }
        
        try {
            t1.setSecond(60);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception for invalid second: " + e.getMessage());
        }
        
        try {
            t1.setTime(12, 60, 30);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception for invalid time: " + e.getMessage());
        }
    }
}