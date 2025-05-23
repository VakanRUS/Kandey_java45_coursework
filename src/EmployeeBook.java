public class EmployeeBook {
    private final Employee[] employees = new Employee[10];

    public boolean checkIsArrayFull() {
        boolean check = false;
        if (Employee.getNumberOfElements() == employees.length) {
            check = true;
        }
        return check;
    }

    public int checkExistence(String name, int state) {
        int checkExistence = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else {
                if (employees[i].getName().equals(name) && employees[i].getState() == state) {
                    checkExistence = i;
                    break;
                } else {
                    checkExistence = -1;
                }
            }
        }
        return checkExistence;
    }

    public void addEmployee(String name, double salary, int state) {
        if (checkIsArrayFull()) {
            System.out.println("Попытка внести сотрудника: " + name + " из отдела №" + state + " не возможна!");
            System.out.println("В массиве нет места");
            System.out.println();
        } else {
            for (int i = 0; i < employees.length; i++) {
                Employee newEmployee = new Employee(name, salary, state, Employee.getIdTemp());
                if (checkExistence(name, state) == -1 && employees[i] == null) {
                    Employee.setIdTemp(0);
                    employees[i] = newEmployee;
                    System.out.println("Попытка внести сотрудника: " + name + " из отдела №" + state + " успешна!");
                    System.out.println("Сотрудник добавлен!");
                    System.out.println();
                    Employee.setNumberOfElements(Employee.getNumberOfElements()+1);
                    break;
                } else if (checkExistence(name, state) != -1){
                    System.out.println("Попытка внести сотрудника: " + name + " из отдела №" + state + " не возможна!");
                    System.out.println("Этот сотрудник уже есть в списке c id " + (checkExistence(name, state)));
                    System.out.println();
                    break;
                } else continue;
            }
        }
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (id > employees.length || id < 0 || (employee == null && i == id)) {
                System.out.println("Сотрудник с id №" + id + " не существует.");
                System.out.println();
                break;
            } else if (i == id) {
                System.out.println("Сотрудник с id №" + id + " удалён.");
                System.out.println();
                employees[i] = null;
                Employee.setIdTemp(0);
                Employee.setNumberOfElements(Employee.getNumberOfElements()-1);
                break;
            }
        }
    }

    public Employee findEmployeeById(int id) {
        Employee findEmployee = null;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (id > employees.length || id < 0 || (employee == null && i == id)) {
                findEmployee = null;
                break;
            }
            if (employee != null && i == id) {
                findEmployee = employee;
                break;
            } else continue;
        }
        return findEmployee;
    }

    public void calculateTotalPayments(int state) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employees[i] == null) {
                continue;
            } else {
                if (state == 0) {
                    sum += employee.getSalary();
                } else if (state == employee.getState()) {
                    sum += employee.getSalary();

                }
            }
        }
        if (state == 0) {
            System.out.println("Общая сумма выплат за месяц: " + String.format("%.02f", sum));
            System.out.println();
        } else {
            System.out.println("Общая сумма выплат по отделу №" + state + " за месяц: " + String.format("%.02f", sum));
            System.out.println();
        }
    }

    public void calculateAverageSalary(int state) {
        double sum = 0;
        int count = 0;
        for (Employee employee : employees) {
            if (employee != null && state == 0) {
                sum += employee.getSalary();
                count++;
            } else if (employee != null && state != 0) {
                if (state == employee.getState()) {
                    sum += employee.getSalary();
                    count++;
                }
            } else continue;
        }
        double total = sum / count;
        if (state == 0) {
            System.out.println("Средняя зарплата в месяц: " + String.format("%.02f", total));
            System.out.println();
        } else {
            System.out.println("Средняя зарплата в месяц в отделе №" + state + " составляет: " + String.format("%.02f", total));
            System.out.println();
        }
    }

    public void findMinSalary(int state) {
        double min = 9999999;
        Employee minSalaryEmployee = new Employee("", 0, 0, 0);
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee == null) {
                continue;
            } else {
                if (state == 0 && employee.getSalary() < min) {
                    min = employee.getSalary();
                    minSalaryEmployee = employee;
                } else if (state == employee.getState() && employee.getSalary() < min) {
                    min = employee.getSalary();
                    minSalaryEmployee = employee;
                }
            }
        }
        if (state == 0) {
            System.out.println("Сотрудник с минимальной зарплатой среди всех отделов:");
        } else {
            System.out.println("Сотрудник из отдела №:" + state + " с минимальной зарплатой:");
        }
        System.out.print("id сотрудника: ");
        System.out.print(minSalaryEmployee.getId());
        System.out.print(". Имя: ");
        System.out.print(minSalaryEmployee.getName());
        System.out.print(". Зарплата: ");
        System.out.print(String.format("%.02f", minSalaryEmployee.getSalary()));
        System.out.print(". Отдел: ");
        System.out.println(minSalaryEmployee.getState());
        System.out.println();
    }

    public void findMaxSalary(int state) {
        double max = 0;
        Employee maxSalaryEmployee = new Employee("", 0, 0, 0);
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employee == null) {
                continue;
            } else {
                if (state == 0 && employee.getSalary() > max) {
                    max = employee.getSalary();
                    maxSalaryEmployee = employee;
                } else if (state == employee.getState() && employee.getSalary() > max) {
                    max = employee.getSalary();
                    maxSalaryEmployee = employee;
                }
            }
        }
        if (state == 0) {
            System.out.println("Сотрудник с максимальной зарплатой среди всех отделов:");
        } else {
            System.out.println("Сотрудник из отдела №:" + state + " с максимальной зарплатой:");
        }
        System.out.print("id сотрудника: ");
        System.out.print(maxSalaryEmployee.getId());
        System.out.print(". Имя: ");
        System.out.print(maxSalaryEmployee.getName());
        System.out.print(". Зарплата: ");
        System.out.print(String.format("%.02f", maxSalaryEmployee.getSalary()));
        System.out.print(". Отдел: ");
        System.out.println(maxSalaryEmployee.getState());
        System.out.println();
    }

    public void indexSalary(int percent, int state) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (employees[i] == null) {
                continue;
            } else {
                if (state == 0) {
                    double index = 0;
                    index = employee.getSalary() + (employee.getSalary() * percent / 100);
                    employees[i].setSalary(index);
                } else if (state == employee.getState()) {
                    double index = 0;
                    index = employee.getSalary() + (employee.getSalary() * percent / 100);
                    employees[i].setSalary(index);

                }
            }
        }
        System.out.println("Произведена индексация зарплат на " + percent + "% всем сотрудникам отдела №" + state);
        System.out.println();
    }

    public void printNamesOfAllEmployees() {
        System.out.println("Имена сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.getName() + ". ");
            } else continue;
        }
        System.out.println();
    }

    public void findSalaryMoreThenNumber(double digit) {
        Employee[] moreSalary = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else {
                if (employees[i].getSalary() >= digit) {
                    moreSalary[i] = employees[i];
                }
            }
        }
        System.out.println("Получено число: " + digit);
        System.out.println();
        System.out.println("Сотрудники с зарплатой равной, либо выше указанного числа:");
        for (int i = 0; i < moreSalary.length; i++) {
            if (moreSalary[i] == null) {
                continue;
            } else {
                System.out.println("id сотрудника: " + moreSalary[i].getId() +
                        ". Имя сотрудника: " + moreSalary[i].getName() +
                        ". Зарплата: " + String.format("%.02f", moreSalary[i].getSalary()));
            }
        }
        System.out.println();
    }

    public void findSalaryLessThenNumber(double digit) {
        Employee[] lessSalary = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else {
                if (employees[i].getSalary() < digit) {
                    lessSalary[i] = employees[i];
                }
            }
        }
        System.out.println("Получено число: " + digit);
        System.out.println();
        System.out.println("Сотрудники с зарплатой ниже указанного числа:");
        for (int i = 0; i < lessSalary.length; i++) {
            if (lessSalary[i] == null) {
                continue;
            } else {
                System.out.println("id сотрудника: " + lessSalary[i].getId() +
                        ". Имя сотрудника: " + lessSalary[i].getName() +
                        ". Зарплата: " + String.format("%.02f", lessSalary[i].getSalary()));
            }
        }
        System.out.println();
    }

    public void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("id сотрудника: " + employee.getId() +
                        ". Имя сотрудника: " + employee.getName() +
                        ". Зарплата: " + String.format("%.02f", employee.getSalary()) +
                        ". Отдел: " + employee.getState() +
                        ".");
            } else {
                System.out.println("нет данных");
                continue;
            }
        }
        System.out.println("Всего сотрудников: " + Employee.getNumberOfElements() + " из " + employees.length);
        System.out.println();
    }

    public void printStateEmployees(int state) {
        System.out.println("Список сотрудников из отдела №" + state);
        for (Employee employee : employees) {
            if (employee != null && employee.getState() == state) {
                System.out.println("id сотрудника: " + employee.getId() +
                        ". Имя сотрудника: " + employee.getName() +
                        ". Зарплата: " + String.format("%.02f", employee.getSalary()) +
                        ".");
            } else {
                continue;
            }
        }
        System.out.println();
    }
}