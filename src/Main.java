import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Олег", 55100.77, 2); // ... создаем записи сотрудников в массиве
        employeeBook.addEmployee("Инга", 52700.25, 1);
        employeeBook.addEmployee("Иван", 50500.98, 3);
        employeeBook.addEmployee("Роман", 51200.12, 1);
        employeeBook.addEmployee("Игорь", 59800.52, 2);
        employeeBook.addEmployee("Ольга", 59100.51, 4);
        employeeBook.addEmployee("Антон", 57750.44, 4);
        employeeBook.addEmployee("Ринат", 52810.12, 1);
        employeeBook.addEmployee("Татьяна", 62100.77, 2);
        employeeBook.addEmployee("Светлана", 152800.12, 5);
        employeeBook.printAllEmployees(); // распечатка всех сотрудников
        System.out.println("Всего записей - " + employeeBook.getIdTemp()); // тестовая распечатка временной переменной
        employeeBook.calculateTotalPayments(); // Расчёт суммы всех зарплат за месяц
        employeeBook.findMinSalary(); // Поиск сотрудника с минимальной зарплатой
        employeeBook.findMaxSalary(); // Поиск сотрудника с максимальной зарплатой
        employeeBook.printNamesOfAllEmployees(); // Распечатка только имён сотрудников
        employeeBook.addEmployee("Test", 0, 1);// попытка добавить нового сотрудника в полный массив
        System.out.println("В массиве нет места, это верно? - " + employeeBook.isArrayFull(true)); // тестовая распечатка результата проверки полный ли массив
        employeeBook.indexSalary(15, 2); // индексация зарплаты на задаваемый процент с учётом отдела (0 - не учитывать отдел)
        employeeBook.printAllEmployees(); //проверка, что индексация произошла
        employeeBook.calculateAverageSalary(1); // Расчет средней зарплаты с учётом отдела (0 - не учитывать отдел)


    }
}