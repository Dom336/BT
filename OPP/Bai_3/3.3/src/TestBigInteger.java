import java.math.BigInteger;

public class TestBigInteger {
   public static void main(String[] args) {
      BigInteger i1 = new BigInteger("11111111111111111111111111111111111111111111111111111111111111");
      BigInteger i2 = new BigInteger("22222222222222222222222222222222222222222222222222");
      
      System.out.println("First number: " + i1);
      System.out.println("Second number: " + i2);
      
      BigInteger sum = i1.add(i2);
      System.out.println("Sum: " + sum);
      
      BigInteger product = i1.multiply(i2);
      System.out.println("Product: " + product);
   }
}