public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    int idIncrement = 0;

    // Добавить работника
    public void addEmployee(String name, double salary, int state) {
        if ( idIncrement >= employees.length) {
            System.out.println("Нельзя добавить контакт, закончилось место");
        } else {
        Employee newEmployee = new Employee(name, salary, state, idIncrement);
        employees[idIncrement] = newEmployee;
        idIncrement++;}
    }

    // Распечатка пользователей
    public void printAllEmployees() {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employees[i] != null) {
                System.out.println("Имя сотрудника: " + employee.getName() +
                        ". Зарплата: " + employee.getSalary() +
                        ". Отдел: " + employee.getState() +
                        ".");
            }
        }
    }

    // Рассчитать среднюю зарплату
    public void getAverageSalary() {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            sum += employee.getSalary();
        }
        System.out.println("Общая сумма выплат за месяц: " + String.format("%.02f", sum));
    }

    // Рассчитать среднюю зарплату по отделу
    public void getAverageSalaryPerState(int state) {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee.getState() == state) {
                sum += employee.getSalary();
                count++;
            }
        }
        double total = sum / count;
        System.out.println("Средняя зарплата в месяц по отделу: " + state + ": " + String.format("%.02f", total));
    }

    public int getIdIncrement() {
        return idIncrement;
    }
}
