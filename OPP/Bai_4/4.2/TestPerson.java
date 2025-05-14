public class TestPerson {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Main St");
        System.out.println(person);

        Student student = new Student("Jane Smith", "456 College Ave", "Computer Science", 2023, 15000.0);
        System.out.println(student);
        student.setYear(2024);
        student.setFee(16000.0);
        System.out.println("Updated: " + student);

        Staff staff = new Staff("Dr. Johnson", "789 University Blvd", "Engineering", 75000.0);
        System.out.println(staff);
        staff.setPay(80000.0);
        System.out.println("Updated: " + staff);
    }
}