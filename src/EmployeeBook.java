public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    int idIncrement = 0;

    // Добавить работника
    public void addEmployee(String name, double salary, int state) {
        if (idIncrement >= employees.length) {
            System.out.println("Нельзя добавить контакт, закончилось место");
        } else {
            Employee newEmployee = new Employee(name, salary, state, idIncrement);
            employees[idIncrement] = newEmployee;
            idIncrement++;
        }
    }

    // Распечатка пользователей
    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("id сотрудника: " + employee.getId() +
                        ". Имя сотрудника: " + employee.getName() +
                        ". Зарплата: " + employee.getSalary() +
                        ". Отдел: " + employee.getState() +
                        ".");
            } else continue;
        }
    }

    // Рассчитать среднюю зарплату
    public void calculateAverageSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            } else continue;
        }
        System.out.println("Общая сумма выплат за месяц: " + String.format("%.02f", sum));
    }

    // Рассчитать среднюю зарплату
    public void calculateAverageSalaryPerState() {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
                count++;
            } else continue;
        }
        double total = sum / count;
        System.out.println("Средняя зарплата в месяц: " + String.format("%.02f", total));
    }

    // Найти сотрудника с наименьшей зарплатой
    public void findMinSalary() {
        double min = 9999999;
        Employee minSalaryEmployee = new Employee("",0,0,0);
        for (int i=0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employees[i] != null && employee.getSalary() < min) {
                min = employee.getSalary();
            minSalaryEmployee = employee;
            } else continue;
        }
        System.out.println("Сотрудник с минимальной зарплатой:");
        System.out.print("id сотрудника: ");
        System.out.print(minSalaryEmployee.getId());
        System.out.print(". Имя: ");
        System.out.print(minSalaryEmployee.getName());
        System.out.print(". Зарплата: ");
        System.out.print(String.format("%.02f", minSalaryEmployee.getSalary()));
        System.out.print(". Отдел: ");
        System.out.print(minSalaryEmployee.getState());

    // Найти сотрудника с наибольшей зарплатой
    }public void findMaxSalary() {
        double max = 0;
        Employee maxSalaryEmployee = new Employee("",0,0,0);
        for (int i=0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employees[i] != null && employee.getSalary() > max) {
                max = employee.getSalary();
            maxSalaryEmployee = employee;
            } else continue;
        }
        System.out.println("Сотрудник с минимальной зарплатой:");
        System.out.print("id сотрудника: ");
        System.out.print(maxSalaryEmployee.getId());
        System.out.print(". Имя: ");
        System.out.print(maxSalaryEmployee.getName());
        System.out.print(". Зарплата: ");
        System.out.print(String.format("%.02f", maxSalaryEmployee.getSalary()));
        System.out.print(". Отдел: ");
        System.out.print(maxSalaryEmployee.getState());

    }

    public int getIdIncrement() {
        return idIncrement;
    }
}