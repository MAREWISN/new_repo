import java.util.ArrayList;
import java.util.List;

public class Employee extends Person{
    private static int id = 1;
    private int employeeId;
    private int salary;
    public Employee(String firstName, String secondName, int age, int salary) {
        super(firstName, secondName, age);
        this.salary = salary;
        this.employeeId = id;
        id++;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static void main(String[] args) {
        List<Employee> pracownicy = new ArrayList<>();
        pracownicy.add(new Employee("Adam", "Dzięganowski", 25, 48000));
        pracownicy.add(new Employee("Marek", "Wiśniowski", 24, 60000));
        pracownicy.add(new Employee("Apolonia", "Tajner", 46, 87000));
        pracownicy.add(new Employee("Cecylia", "Taraszewska", 32, 56000));

        for (int i = 0; i < pracownicy.size(); i++)
        {
            System.out.println(pracownicy.get(i).getFirstName() + " " + pracownicy.get(i).getSecondName() + " " +
                    pracownicy.get(i).getAge() + " " + pracownicy.get(i).getSalary() + " " + pracownicy.get(i).getEmployeeId());
        }

    }
}


