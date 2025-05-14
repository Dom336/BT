import java.util.Date;

public class Visit {
    private Customer customer;
    private Date date;
    private double serviceExpense;
    private double productExpense;

    public Visit(Customer customer, Date date) {
        this.customer = customer;
        this.date = date;
    }

    public String getName() {
        return customer.getName();
    }

    public double getServiceExpense() {
        return serviceExpense;
    }

    public void setServiceExpense(double ex) {
        this.serviceExpense = ex;
    }

    public double getProductExpense() {
        return productExpense;
    }

    public void setProductExpense(double ex) {
        this.productExpense = ex;
    }

    public double getTotalExpense() {
        double serviceDiscount = customer.isMember() ? 
            DiscountRate.getServiceDiscountRate(customer.getMemberType()) : 0.0;
        double productDiscount = customer.isMember() ? 
            DiscountRate.getProductDiscountRate(customer.getMemberType()) : 0.0;

        return (serviceExpense * (1 - serviceDiscount)) + 
               (productExpense * (1 - productDiscount));
    }

    @Override
    public String toString() {
        return "Visit[customer=" + customer + ",date=" + date + 
               ",serviceExpense=" + serviceExpense + 
               ",productExpense=" + productExpense + "]";
    }
}