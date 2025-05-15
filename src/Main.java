import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();
        Employee john = new Employee("Пыщ", 777, 0);
//        Employee sarah = new Employee("Сара", 51000, 2);
//        Employee donald = new Employee("Дональд", 60000, 1);
//        Employee eugene = new Employee("Евгений", 62000, 1);
//        Employee roman = new Employee("Роман", 52000, 2);
        System.out.println(john);
//        System.out.println(sarah);
//        System.out.println(donald);
//        System.out.println(eugene);
//        System.out.println(roman);
        employeeService.addEmployee("Иван", 50000, 1);
        employeeService.printAllEmployees();
    }
}