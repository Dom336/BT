public class TestCylinder {
    public static void main(String[] args) {
        Cylinder c1 = new Cylinder();
        System.out.println("Default cylinder: " + c1);
        System.out.println("Volume: " + c1.getVolume());

        Cylinder c2 = new Cylinder(5.0);
        System.out.println("\nCylinder with height 5: " + c2);
        System.out.println("Volume: " + c2.getVolume());

        Cylinder c3 = new Cylinder(2.0, 10.0, "blue");
        System.out.println("\nCustom cylinder: " + c3);
        System.out.println("Base area: " + c3.getBaseArea());
        System.out.println("Volume: " + c3.getVolume());
    }
}