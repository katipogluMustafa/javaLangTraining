import java.util.Random;

public class Employee {
    private static int nextId;
    private int id = assignId();
    private String name;
    private int age;
    boolean isManager;

    public Employee(){
        this("Undefined",-1);
    }

    public Employee(String name, int age){
        this(name,age,false);
    }

    public Employee(String name, int age, boolean isManager){
        this.name = name;
        this.age = age;
        this.isManager = isManager;
    }

    private static int assignId(){
        return nextId++;
    }

    public int getId(){
        return id;
    }

    @Override
    public String toString(){
        return String.format("%s - %d - %b", name, age, isManager );
    }

    // Unit Test
    public static void main(String[] args) {
        Employee[] staff = new Employee[10];
        for(Employee e : staff)
            System.out.println( e = new Employee() );

        Random rand = new Random();
        StringBuilder builder = new StringBuilder("Staff#");
        staff = new Employee[15];
        for(Employee e : staff)
            System.out.println( e = new Employee( builder.append(rand.nextInt(5000)).toString(),rand.nextInt(47)+ 18 ) );
    }
}
