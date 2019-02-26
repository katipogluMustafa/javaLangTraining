import java.util.Random;

public class Employee {
    private static int nextId;

    private int id;
    private String name = "";       // instance field initialization
    private double salary;

    // Static Initialization Block
    static{
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    // Object Initialization Block
    {
        id = nextId;
        nextId++;
    }

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public Employee(double salary){
        this("Employee #" + nextId, salary);
    }

    // Default Constructor
    public Employee(){
        // name initialized to ""
        // salary not explicitly set
        // id initialized in initialization block
    }

    @Override
    public String toString(){
        return String.format("ID: %d\tName: %s\n Salary: %f\n", id,name,salary);
    }

    // Unit Test
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee(50000);
        Employee e3 = new Employee("Mustafa",15000);
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

    }

}
