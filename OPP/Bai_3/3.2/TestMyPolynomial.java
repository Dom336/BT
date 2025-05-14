public class TestMyPolynomial {
    public static void main(String[] args) {
        MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3);
        System.out.println("p1 = " + p1);
        System.out.println("Degree of p1: " + p1.getDegree());
        
        MyPolynomial p2 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);
        System.out.println("p2 = " + p2);
        
        Double[] coeffsArray = {1.2, 3.4, 5.6, 7.8};
        MyPolynomial p3 = new MyPolynomial(1.2, 3.4, 5.6, 7.8);
        System.out.println("p3 = " + p3);
        
        double x = 2.0;
        System.out.println("p1 evaluated at x = " + x + " is: " + p1.evaluate(x));
        
        MyPolynomial sum = p1.add(p3);
        System.out.println("p1 + p3 = " + sum);
        
        MyPolynomial product = p1.multiply(p2);
        System.out.println("p1 * p2 = " + product);
        
        MyPolynomial zeroPolynomial = new MyPolynomial(0);
        System.out.println("Zero polynomial: " + zeroPolynomial);
        
        MyPolynomial constantPolynomial = new MyPolynomial(5);
        System.out.println("Constant polynomial: " + constantPolynomial);
        
        MyPolynomial p4 = new MyPolynomial(-1, 0, -3.5, 2);
        System.out.println("p4 = " + p4);
    }
}