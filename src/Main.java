public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.addEmployee("Олег", 55100.77, 2);
        employeeBook.addEmployee("Инга", 52700.25, 1);
        employeeBook.addEmployee("Иван", 50500.98, 3);
        employeeBook.addEmployee("Роман", 51200.12, 1);
        employeeBook.addEmployee("Игорь", 59800.52, 2);
        employeeBook.addEmployee("Ольга", 59100.51, 4);
        employeeBook.addEmployee("Антон", 57750.44, 4);
        employeeBook.addEmployee("Ринат", 52810.12, 1);
        employeeBook.addEmployee("Татьяна", 62100.77, 2);
        employeeBook.addEmployee("Светлана", 152800.12, 5);
        employeeBook.printAllEmployees();
        employeeBook.printNamesOfAllEmployees();
        employeeBook.findMinSalary(1);
        employeeBook.findMaxSalary(1);
        employeeBook.calculateTotalPayments(1);
        employeeBook.calculateAverageSalary(1);
        employeeBook.indexSalary(15, 2);
        employeeBook.printStateEmployees(2);
        employeeBook.removeEmployee(1);
        employeeBook.removeEmployee(5);
        employeeBook.removeEmployee(5);
        employeeBook.removeEmployee(15);
        employeeBook.addEmployee("Инга", 52700.25, 1);
        employeeBook.addEmployee("Инга", 52700.25, 1);
        employeeBook.addEmployee("Ольга", 59100.51, 4);
        employeeBook.addEmployee("Ольга", 59100.51, 4);
        employeeBook.removeEmployee(9);
        employeeBook.findSalaryMoreThenNumber(55000);
        employeeBook.findSalaryLessThenNumber(55000);
        employeeBook.findEmployeeById(9);
        employeeBook.removeEmployee(2);
        employeeBook.addEmployee("Светлана", 152800.12, 5);
        employeeBook.printAllEmployees();

        Employee find = employeeBook.findEmployeeById(4); // теперь поиск возвращает данные Employee
        if (find != null){
            System.out.println("Сотрудник найден");
            System.out.println(find);
        } else {
            System.out.println("Сотрудник не найден");
        }
    }
}