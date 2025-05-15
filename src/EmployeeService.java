import java.util.Arrays;

public class EmployeeService {
    Employee[] employees = new Employee[5];
    int id = 0;

    public void addEmployee(String name, float salary, int state) {
        if (id >= employees.length) {
            System.out.println("Нельзя добавить контакт, закончилось место");
        }
        Employee newEmployee = new Employee(name, salary, state);
        employees[id] = newEmployee;
        id++;
    }

    public int getCurrentSize() {
        return id;
    }

    public void printAllEmployees() {
        for (int i = 0; i < employees.length-1; i++) {
            Employee employee = employees[i];
            if (employees[i] != null)
            System.out.println("Имя сотрудника: " + employee.getName() +
                    ". Зарплата: " + employee.getSalary() +
                    ". Отдел: " + employee.getSalary() +
                    ".");
        }
        System.out.println("Больше записей нет");
    }
}