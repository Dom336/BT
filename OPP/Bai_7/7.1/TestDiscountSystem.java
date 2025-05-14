import java.util.Date;

public class TestDiscountSystem {
    public static void main(String[] args) {
        // Create customers
        Customer premium = new Customer("Alice");
        premium.setMemberType("Premium");
        
        Customer gold = new Customer("Bob");
        gold.setMemberType("Gold");
        
        Customer silver = new Customer("Charlie");
        silver.setMemberType("Silver");
        
        Customer nonMember = new Customer("Dave");

        // Create visits
        Visit v1 = new Visit(premium, new Date());
        v1.setServiceExpense(100);
        v1.setProductExpense(50);
        
        Visit v2 = new Visit(gold, new Date());
        v2.setServiceExpense(100);
        v2.setProductExpense(50);
        
        Visit v3 = new Visit(silver, new Date());
        v3.setServiceExpense(100);
        v3.setProductExpense(50);
        
        Visit v4 = new Visit(nonMember, new Date());
        v4.setServiceExpense(100);
        v4.setProductExpense(50);

        // Test calculations
        System.out.println("Premium Member Total: $" + v1.getTotalExpense());
        System.out.println("Gold Member Total: $" + v2.getTotalExpense());
        System.out.println("Silver Member Total: $" + v3.getTotalExpense());
        System.out.println("Non-Member Total: $" + v4.getTotalExpense());
        
        // Test toString()
        System.out.println("\nVisit Details:");
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);
    }
}