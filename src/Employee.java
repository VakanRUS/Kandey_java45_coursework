public class Employee {
    private int id = 1;
    private String name;
    private float salary;
    private int state;

    public Employee(String name, float salary, int state) {
        this.name = name;
        this.salary = salary;
        this.state = state;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public float getSalary() {
        return salary;
    }

    public int getState() {
        return state;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return ("№: " + id + ". Имя сотрудника: " + name + ". Зарплата: " + salary + ". Отдел: " + state + ".");
    }
}