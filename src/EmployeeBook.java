import java.util.Arrays;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    int idTemp = 0;
    Employee employee;

    // проверка архива на свободное место
    public boolean isArrayFull(boolean check) {
        for (int i = 0; i < employees.length; i++) { // задаем цикл по длине массива для проверки, осталось ли пустое место в массиве
            if (employees[i] == null) { // если проверка показала, что массив в этой ячейке пуст
                check = false; // присваиваем значение "Не верно" (массив НЕ полный)
                idTemp = i; // сохраняем временную переменную
                break; //прекращаем выполнение цикла, поскольку уже ясно, что массив не пустой
            } else { // иначе
                check = true; // присваиваем значение "Верно" (ДА, массив полный)
            }
        }
        return check; // возвращаем результат проверки
    }


    // Добавить сотрудника
    public void addEmployee(String name, double salary, int state) {
        if (isArrayFull(true)) { // Проверяем, полный ли массив, и если да, то
            System.out.println("места нет"); // пишем, что места в массиве не осталось
        } else {
            Employee newEmployee = new Employee(name, salary, state, idTemp); // , если же он не полон, заносим в него данные полученные на входе, плюс в качестве id поставляем число из временной переменной
            employees[idTemp] = newEmployee;
        }
    }


    // Распечатка сотрудника
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
    public void calculateTotalPayments() {
        double sum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                sum += employee.getSalary();
            } else continue;
        }
        System.out.println("Общая сумма выплат за месяц: " + String.format("%.02f", sum));
    }

    // Рассчитать среднюю зарплату
    public void calculateAverageSalary() {
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
        Employee minSalaryEmployee = new Employee("", 0, 0, 0);
        for (int i = 0; i < employees.length; i++) {
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
        System.out.println(minSalaryEmployee.getState());
    }

    // Найти сотрудника с наибольшей зарплатой
    public void findMaxSalary() {
        double max = 0;
        Employee maxSalaryEmployee = new Employee("", 0, 0, 0);
        for (int i = 0; i < employees.length; i++) {
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
        System.out.println(maxSalaryEmployee.getState());
    }

    // Распечатка только имён всех сотрудников
    public void printNamesOfAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.print(employee.getName() + ". ");
            } else continue;
        }
    }

    // индексирование зарплаты всем сотрудникам
//    public void indexSalary() {
//        double index;
//        for (int i = 0; i < employees.length; i++) {
//            if
//        }
//    }

    public int getIdTemp() {
        return idTemp;
    }
}