import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Иван", 50500.98, 1);
        employeeBook.addEmployee("Олег", 55100.77, 2);
        employeeBook.addEmployee("Инга", 52700.25, 1);
        employeeBook.addEmployee("Роман", 51200.12, 1);
        employeeBook.addEmployee("Игорь", 59800.52, 2);
        employeeBook.printAllEmployees();
        System.out.println(employeeBook.getIdIncrement());


    }
}