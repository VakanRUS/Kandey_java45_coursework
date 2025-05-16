import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Олег", 55100.77, 2);
        employeeBook.addEmployee("Инга", 52700.25, 1);
        employeeBook.addEmployee("Иван", 50500.98, 1);
        employeeBook.addEmployee("Роман", 51200.12, 1);
        employeeBook.addEmployee("Игорь", 59800.52, 2);
        employeeBook.addEmployee("Ольга", 59100.51, 1);
        employeeBook.addEmployee("Антон", 57750.44, 2);
        employeeBook.addEmployee("Ринат", 52810.12, 1);
        employeeBook.addEmployee("Татьяна", 62100.77, 2);
        employeeBook.addEmployee("Светлана", 52800.12, 1);
        employeeBook.printAllEmployees();
        System.out.println();// распечатка всех сотрудников
        System.out.println("Всего записей - " + employeeBook.getIdIncrement());
        System.out.println();
        employeeBook.calculateAverageSalary();                                                                          // Расчёт суммы всех зарплат за месяц
        System.out.println();
        employeeBook.calculateAverageSalaryPerState();                                                                  // Расчет средней зарплаты в каком-то отделе
        System.out.println();
        employeeBook.findMinSalary();                                                                                   // Поиск сотрудника с минимальной зарплатой
        System.out.println();
        employeeBook.findMaxSalary();                                                                                   // Поиск сотрудника с максимальной зарплатой
        System.out.println();

    }
}