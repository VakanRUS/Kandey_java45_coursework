import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();

        // Добавить нового сотрудника
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

        // Получить список всех сотрудников со всеми имеющимися по ним данными
        employeeBook.printAllEmployees(); // распечатка всех сотрудников

        // Распечатать ФИО всех сотрудников
        employeeBook.printNamesOfAllEmployees(); // Распечатка только имён сотрудников

        // Сотрудника с минимальной зарплатой с учётом отдела (0 - не учитывать отдел)
        employeeBook.findMinSalary(1);

        // Сотрудника с максимальной зарплатой с учётом отдела (0 - не учитывать отдел)
        employeeBook.findMaxSalary(1);

        // Посчитать сумму затрат на ЗП в месяц с учётом отдела (0 - не учитывать отдел)
        employeeBook.calculateTotalPayments(1); // Расчёт суммы всех зарплат за месяц

        // Подсчитать среднее значение зарплат с учётом отдела (0 - не учитывать отдел)
        employeeBook.calculateAverageSalary(1); // Расчет средней зарплаты с учётом отдела (0 - не учитывать отдел)

        // Проиндексировать зарплату (вызвать изменение зп у всех сотрудников на величину аргумента в %) с учётом отдела (0 - не учитывать отдел)
        employeeBook.indexSalary(15, 2); // индексация зарплаты на задаваемый процент с учётом отдела (0 - не учитывать отдел)

        // Напечатать всех сотрудников отдела (все данные, кроме отдела) (0 - не учитывать отдел)
        employeeBook.printStateEmployees(2);

        // Получить число и вывести сотрудников с зарплатой больше и меньше этого числа
        employeeBook.findMoreOrLessSalary(59100.51); // сортировка сотрудников с меньше и большей зарплатами относительно полученного числа

        // Удалить сотрудника
        employeeBook.removeEmployee(1);
        employeeBook.removeEmployee(5);


        // Вывод данных сотрудника с определённым id
        employeeBook.printAllEmployees();
        employeeBook.findEmployeeById(4);
    }
}