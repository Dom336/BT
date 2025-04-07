public class MyComplexTest {
    public static void main(String[] args) {
        System.out.println("Testing constructors:");
        MyComplex c1 = new MyComplex();
        System.out.println("Default constructor: " + c1);
        
        MyComplex c2 = new MyComplex(3.0, 4.0);
        System.out.println("Parameterized constructor: " + c2);
        
        System.out.println("\nTesting getters and setters:");
        System.out.println("Real part: " + c2.getReal());
        System.out.println("Imaginary part: " + c2.getImag());
        
        c2.setReal(5.0);
        c2.setImag(6.0);
        System.out.println("After setting values: " + c2);
        
        c2.setValue(3.0, 4.0);
        System.out.println("After setValue: " + c2);
        
        System.out.println("\nTesting isReal and isImaginary:");
        MyComplex realOnly = new MyComplex(5.0, 0.0);
        MyComplex imagOnly = new MyComplex(0.0, 5.0);
        System.out.println(realOnly + " is real? " + realOnly.isReal());
        System.out.println(realOnly + " is imaginary? " + realOnly.isImaginary());
        System.out.println(imagOnly + " is real? " + imagOnly.isReal());
        System.out.println(imagOnly + " is imaginary? " + imagOnly.isImaginary());
        System.out.println(c2 + " is real? " + c2.isReal());
        System.out.println(c2 + " is imaginary? " + c2.isImaginary());
        
        System.out.println("\nTesting equals methods:");
        MyComplex c3 = new MyComplex(3.0, 4.0);
        System.out.println(c2 + " equals " + c3 + "? " + c2.equals(c3));
        System.out.println(c2 + " equals (3.0, 4.0)? " + c2.equals(3.0, 4.0));
        System.out.println(c2 + " equals " + c1 + "? " + c2.equals(c1));
        
        System.out.println("\nTesting magnitude and argument:");
        System.out.println("Magnitude of " + c2 + " is " + c2.magnitude());
        System.out.println("Argument of " + c2 + " in radians is " + c2.argument());
        
        System.out.println("\nTesting arithmetic operations:");
        
        MyComplex a = new MyComplex(1.0, 2.0);
        MyComplex b = new MyComplex(3.0, 4.0);
        MyComplex result1 = a.addNew(b);
        System.out.println(a + " + " + b + " = " + result1);
        System.out.println("Original a after addNew: " + a);
        
        a.add(b);
        System.out.println("a after add(b): " + a);
        
        a = new MyComplex(5.0, 6.0);
        result1 = a.subtractNew(b);
        System.out.println(a + " - " + b + " = " + result1);
        System.out.println("Original a after subtractNew: " + a);
        
        a.subtract(b);
        System.out.println("a after subtract(b): " + a);
        
        a = new MyComplex(1.0, 2.0);
        System.out.println(a + " * " + b + " = ?");
        a.multiply(b);
        System.out.println("Result after multiply: " + a);
        
        a = new MyComplex(2.0, 3.0);
        System.out.println(a + " / " + b + " = ?");
        a.divide(b);
        System.out.println("Result after divide: " + a);
        
        a = new MyComplex(1.0, 2.0);
        System.out.println("Conjugate of " + a + " is ?");
        a.conjugate();
        System.out.println("After conjugate: " + a);
        
        System.out.println("\nTesting method chaining:");
        a = new MyComplex(1.0, 2.0);
        b = new MyComplex(3.0, 4.0);
        MyComplex c = new MyComplex(5.0, 6.0);
        
        MyComplex chainResult = a.add(b).add(c);
        System.out.println("a.add(b).add(c) = " + chainResult);
    }
}