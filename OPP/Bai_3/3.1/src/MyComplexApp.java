import java.util.Scanner;

public class MyComplexApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter complex number 1 (real and imaginary part): ");
        double real1 = scanner.nextDouble();
        double imag1 = scanner.nextDouble();
        
        System.out.print("Enter complex number 2 (real and imaginary part): ");
        double real2 = scanner.nextDouble();
        double imag2 = scanner.nextDouble();
        
        MyComplex number1 = new MyComplex(real1, imag1);
        MyComplex number2 = new MyComplex(real2, imag2);
        
        System.out.println("\nNumber 1 is: " + number1);
        System.out.println(number1 + " is " + (number1.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println(number1 + " is " + (number1.isImaginary() ? "" : "NOT ") + "a pure imaginary number");
        
        System.out.println("\nNumber 2 is: " + number2);
        System.out.println(number2 + " is " + (number2.isReal() ? "" : "NOT ") + "a pure real number");
        System.out.println(number2 + " is " + (number2.isImaginary() ? "" : "NOT ") + "a pure imaginary number");
        
        System.out.println("\n" + number1 + " is " + (number1.equals(number2) ? "" : "NOT ") + 
                          "equal to " + number2);
        
        System.out.println(number1 + " + " + number2 + " = " + number1.addNew(number2));
        
        System.out.println("\nMagnitude of " + number1 + " is: " + number1.magnitude());
        System.out.println("Magnitude of " + number2 + " is: " + number2.magnitude());
        
        System.out.println("\nArgument of " + number1 + " is: " + number1.argument() + " radians");
        System.out.println("Argument of " + number2 + " is: " + number2.argument() + " radians");
        
        System.out.println("\n" + number1 + " * " + number2 + " = " + 
                         number1.addNew(new MyComplex(0, 0)).multiply(number2));
        
        number1 = new MyComplex(real1, imag1);
        System.out.println(number1 + " / " + number2 + " = " + 
                         number1.addNew(new MyComplex(0, 0)).divide(number2));
        
        MyComplex conj1 = new MyComplex(real1, imag1).conjugate();
        MyComplex conj2 = new MyComplex(real2, imag2).conjugate();
        System.out.println("\nConjugate of " + new MyComplex(real1, imag1) + " is: " + conj1);
        System.out.println("Conjugate of " + new MyComplex(real2, imag2) + " is: " + conj2);
        
        scanner.close();
    }
}