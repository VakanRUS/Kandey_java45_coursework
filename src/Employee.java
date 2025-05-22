import java.util.Objects;

public class Employee {

    private static int idTemp = 0;

    private String name;
    private double salary;
    private int state;
    private int id = 0;

    public Employee(String name, double salary, int state, int id) {
        this.name = name;
        this.salary = salary;
        this.state = state;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public static int getIdTemp() {
        return idTemp;
    }

    public static void setIdTemp(int idTemp) {
        Employee.idTemp = idTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 && state == employee.state && id == employee.id && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, state, id);
    }

    @Override
    public String toString() {
        return ("id сотрудника: " + this.id + ". Имя сотрудника: " + this.name + ". Зарплата: " + this.salary + ". Отдел: " + this.state);
    }
}