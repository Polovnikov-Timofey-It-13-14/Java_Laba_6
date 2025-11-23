@ToString
public class Employee {
    @ToString(ToString.Mode.YES)
    private String name;

    @ToString(ToString.Mode.NO)
    private String company;

    public Employee() {
        this.name = "null";
        this.company = "null";
    }

    public Employee(String name, String company) {
        this.name = name;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', company='" + company + "'}";
    }
}