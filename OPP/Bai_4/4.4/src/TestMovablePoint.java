public class TestMovablePoint {
    public static void main(String[] args) {
        MovablePoint mp1 = new MovablePoint(1.5f, 2.5f, 0.5f, 0.5f);
        System.out.println("Initial position: " + mp1);
        
        mp1.move();
        System.out.println("After moving: " + mp1);
        
        mp1.setSpeed(1.0f, 1.0f);
        mp1.move();
        System.out.println("After changing speed and moving: " + mp1);
        
        float[] speed = mp1.getSpeed();
        System.out.println("Current speed: [" + speed[0] + "," + speed[1] + "]");
    }
}