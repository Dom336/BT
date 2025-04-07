public class TestPoint {
    public static void main(String[] args) {
        Point2D point2d = new Point2D(1.5f, 2.5f);
        System.out.println("2D Point: " + point2d);
        point2d.setXY(3.0f, 4.0f);
        System.out.println("Updated 2D Point: " + point2d);
        float[] xy = point2d.getXY();
        System.out.println("XY coordinates: [" + xy[0] + ", " + xy[1] + "]");

        Point3D point3d = new Point3D(1.5f, 2.5f, 3.5f);
        System.out.println("3D Point: " + point3d);
        point3d.setXYZ(4.0f, 5.0f, 6.0f);
        System.out.println("Updated 3D Point: " + point3d);
        float[] xyz = point3d.getXYZ();
        System.out.println("XYZ coordinates: [" + xyz[0] + ", " + xyz[1] + ", " + xyz[2] + "]");
    }
}