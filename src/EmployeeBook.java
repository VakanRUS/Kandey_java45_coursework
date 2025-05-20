public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    int idTemp = 0;

    public boolean checkIsArrayFull(boolean check) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                check = false;
                idTemp = i;
                break;
            } else {
                check = true;
            }
        }
        return check;
    }

    public void addEmployee(String name, double salary, int state) {
        boolean check = false;
        int idOfExistedEmployee = 0;
        if (checkIsArrayFull(true)) {
            System.out.println("Попытка внести сотрудника: " + name + " из отдела №" + state + " не возможна!");
            System.out.println("В массиве места нет");
            System.out.println();
        } else {
            Employee newEmployee = new Employee(name, salary, state, idTemp);
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    check = false;
                } else {
                    if (employees[i].getName().equals(name) && employees[i].getState() == state) {
                        check = true;
                        idOfExistedEmployee = employees[i].getId();
                        break;
                    }
                }
            }
            for (int i = 0; i < employees.length; i++) {
                if (check) {
                    System.out.println("Попытка внести сотрудника: " + name + " из отдела №" + state + " не возможна!");
                    System.out.println("Этот сотрудник уже есть в списке c id " + idOfExistedEmployee);
                    System.out.println();
                    break;
                } else {
                    employees[idTemp] = newEmployee;
                    System.out.println("Попытка внести сотрудника: " + name + " из отдела №" + state + " успешна!");
                    System.out.println("Сотрудник добавлен!");
                    System.out.println();
                    break;
                }
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
                break;
            }
        }
    }

    public void findEmployeeById(int id) {
        for (int i = 0; i < employees.length; i++) {
            Employee employee = employees[i];
            if (id > employees.length || id < 0 || (employee == null && i == id)) {
                System.out.println("Сотрудник с id №" + id + " не существует.");
                System.out.println();
                break;
            }
            if (employee != null && i == id) {
                System.out.print("id сотрудника: ");
                System.out.print(employee.getId());
                System.out.print(". Имя: ");
                System.out.print(employee.getName());
                System.out.print(". Зарплата: ");
                System.out.print(String.format("%.02f", employee.getSalary()));
                System.out.print(". Отдел: ");
                System.out.println(employee.getState());
                System.out.println();
                break;
            } else continue;
        }
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
                } else {
                    if (state == employee.getState()) {
                        sum += employee.getSalary();
                    }
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
                } else {
                    if (state == employee.getState() && employee.getSalary() < min) {
                        min = employee.getSalary();
                        minSalaryEmployee = employee;
                    }
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
                } else {
                    if (state == employee.getState() && employee.getSalary() > max) {
                        max = employee.getSalary();
                        maxSalaryEmployee = employee;
                    }
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
                } else {
                    if (state == employee.getState()) {
                        double index = 0;
                        index = employee.getSalary() + (employee.getSalary() * percent / 100);
                        employees[i].setSalary(index);
                    }
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

    public void findMoreOrLessSalary(double digit) {
        Employee[] lessSalary = new Employee[employees.length];
        Employee[] moreSalary = new Employee[employees.length];
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else {
                if (employees[i].getSalary() < digit) {
                    lessSalary[i] = employees[i];
                } else {
                    moreSalary[i] = employees[i];
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
                System.out.println("id№" + lessSalary[i].getId() +
                        ". " + lessSalary[i].getName() +
                        ". Зарплата: " + String.format("%.02f", lessSalary[i].getSalary()));
            }
        }
        System.out.println();
        System.out.println("Сотрудники с зарплатой равной, либо выше указанного числа:");
        for (int i = 0; i < moreSalary.length; i++) {
            if (moreSalary[i] == null) {
                continue;
            } else {
                System.out.println("id№" + moreSalary[i].getId() +
                        ". " + moreSalary[i].getName() +
                        ". Зарплата: " + String.format("%.02f", moreSalary[i].getSalary()));
            }
        }
        System.out.println();
    }

    public void printAllEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println("id сотрудника: " + employee.getId() +
                        ". Имя сотрудника: " + employee.getName() +
                        ". Зарплата: " + String.format("%.02f", employee.getSalary()) +
                        ". Отдел: " + employee.getState() +
                        ".");
            } else {
                continue;
            }
        }
        System.out.println();
    }

    public void printStateEmployees(int state) {
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

    public int getIdTemp() {
        return idTemp;
    }
}