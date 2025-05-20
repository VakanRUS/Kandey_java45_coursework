public class EmployeeBook {
    private Employee[] employees = new Employee[10];
    int idTemp = 0;

    // проверка архива на свободное место
    public boolean checkIsArrayFull(boolean check) {
        for (int i = 0; i < employees.length; i++) {                                                                    // задаем цикл по длине массива для проверки, осталось ли пустое место в массиве
            if (employees[i] == null) {                                                                                 // если проверка показала, что массив в этой ячейке пуст
                check = false;                                                                                          // присваиваем значение "Не верно" (массив НЕ полный)
                idTemp = i;                                                                                             // сохраняем временную переменную
                break;                                                                                                  // прекращаем выполнение цикла, поскольку уже ясно, что массив не пустой
            } else {                                                                                                    // иначе
                check = true;                                                                                           // присваиваем значение "Верно" (ДА, массив полный)
            }
        }
        return check;                                                                                                   // возвращаем результат проверки
    }


    // Добавить сотрудника - без проверки на дублирование
//    public void addEmployee(String name, double salary, int state) {
//        if (isArrayFull(true)) { // Проверяем, полный ли массив, и если да, то
//            System.out.println("места нет"); // пишем, что места в массиве не осталось
//        } else {
//            Employee newEmployee = new Employee(name, salary, state, idTemp); // , если же он не полон, заносим в него данные полученные на входе, плюс в качестве id поставляем число из временной переменной
//            employees[idTemp] = newEmployee;
//        }
//    }

    // Добавить нового сотрудника с проверкой на дублирование
    public void addEmployee(String name, double salary, int state) {
        boolean check = false;                                                                                          // задаем проверочную переменную
        int idOfExistedEmployee = 0;                                                                                    // задаем переменную для указания id имеющегося сотрудника, если таковой будет найден в массиве
        if (checkIsArrayFull(true)) {                                                                                   // Проверяем, полный ли массив, и если да, то
            System.out.println("Попытка внести сотрудника: " + name +                                                   // держим в курсе
                    " из отдела №" + state + " не возможна!");
            System.out.println("В массиве места нет");                                                                  // пишем, что места в массиве не осталось
            System.out.println();
        } else {                                                                                                        // если же он не полон, то нужно проверить,
            // есть ли уже такая запись в массиве, чтобы избежать дублирования данных
            Employee newEmployee = new Employee(name, salary, state, idTemp);                                           // заносим во временную переменную данные, полученные на входе, плюс в качестве id подставляем число из временной переменной
            for (int i = 0; i < employees.length; i++) {                                                                // задаем цикл для поиска
                if (employees[i] == null) {                                                                             // если ячейка массива в этой итерации пуста, сравнивать тут не с чем
                    check = false;                                                                                      // сохраняем состояние проверочной переменной
                } else {                                                                                                // иначе
                    if (employees[i].getName().equals(name) &&
                            employees[i].getState() == state &&
                            employees[i].getSalary() == salary) {                                                       // Проверяем совпадение в имени, отделе и зарплате
                        check = true;                                                                                   // если всё совпало, изменяем состояние проверочной переменной
                        idOfExistedEmployee = employees[i].getId();                                                     // так же сохраняем id найденного сотрудника
                        break;                                                                                          // и прекращаем выполнение цикла
                    }
                }
            }
            // Теперь проверяем, нашлась ли наша запись в массиве при поиске выше
            for (int i = 0; i < employees.length; i++) {                                                                // проверяем по циклу весь массив
                if (check) {                                                                                            // если наша запись нашлась
                    System.out.println("Попытка внести сотрудника: " + name + " из отдела №" + state + " не возможна!"); // держим в курсе
                    System.out.println("Этот сотрудник уже есть в списке c id " + idOfExistedEmployee);                 // сообщая что такой сотрудник уже есть под указанным идентификатором
                    System.out.println();
                    break;                                                                                              // завершаем выполнение цикла
                } else {                                                                                                // иначе
                    employees[idTemp] = newEmployee;                                                                    // спокойно заносим нового сотрудника
                    System.out.println("Попытка внести сотрудника: " + name + " из отдела №" + state + " успешна!");    // держим в курсе
                    System.out.println("Сотрудник добавлен!");
                    System.out.println();
                    break;                                                                                              // и так же прекращаем цикл
                }
            }
        }
    }

    // Удалить сотрудника
    public void removeEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {                                                                    // задаем цикл проверки по всему по массиву
            if (employees[i] == null || id > employees.length || id < 0) {                                              // если ячейка массива в этой итерации пуста или заданный id за пределами массива
                System.out.println("Сотрудник с id №" + id + " не существует.");                                        // сообщаем об этом
                System.out.println();
                break;                                                                                                  // и прерываем цикл
            } else if (i == id) {                                                                                       // иначе проверяем соответствие номера итерации и полученного на входе числа
                System.out.println("Сотрудник с id №" + id + " удалён.");                                               // сообщаем, что всё получилось
                System.out.println();
                employees[i] = null;                                                                                    // и очищаем ячейку массива
                break;                                                                                                  // прерываем цикл
            }
        }
    }

    // Распечатка сотрудников
    public void printAllEmployees() {
        for (Employee employee : employees) {                                                                           // пробегаемся по массиву
            if (employee != null) {                                                                                     // проверяем, если ячейка в этой итерации не пуста
                System.out.println("id сотрудника: " + employee.getId() +                                               // то распечатываем данные о сотруднике
                        ". Имя сотрудника: " + employee.getName() +
                        ". Зарплата: " + String.format("%.02f", employee.getSalary()) +
                        ". Отдел: " + employee.getState() +
                        ".");
            } else {                                                                                                    // иначе
                System.out.println("нет данных");                                                                       // выводить нечего, о чем и пишем
            }
        }
        System.out.println();
    }

    // Рассчитать общую сумму затрат за зарплату с учётом отдела (0 - не учитывать отдел)
    public void calculateTotalPayments(int state) {
        double sum = 0;
        for (int i = 0; i < employees.length; i++) {                                                                    // по циклу начинаем индексацию отдела
            Employee employee = employees[i];                                                                           // задаем временную переменную
            if (employees[i] == null) {                                                                                 // проверяем не пустой ли массив на этой итерации
                continue;                                                                                               // если да, просто переходим к следующей итерации
            } else {                                                                                                    // если нет
                if (state == 0) {                                                                                       // проверяем, если 0, значит просто рассчитываем индексацию для всех отделов
                    sum += employee.getSalary();
                } else {                                                                                                // иначе рассчитываем индексацию только для указанного отдела
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

        // Рассчитать среднюю зарплату с учётом отдела (0 - не учитывать отдел)
        public void calculateAverageSalary ( int state){
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

        // Найти сотрудника с наименьшей зарплатой
        public void findMinSalary ( int state){
            double min = 9999999;
            Employee minSalaryEmployee = new Employee("", 0, 0, 0);
            for (int i = 0; i < employees.length; i++) {                                                                    // по циклу начинаем индексацию отдела
                Employee employee = employees[i];                                                                           // задаем временную переменную
                if (employees[i] == null) {                                                                                 // проверяем не пустой ли массив на этой итерации
                    continue;                                                                                               // если да, просто переходим к следующей итерации
                } else {                                                                                                    // если нет
                    if (state == 0 && employee.getSalary() < min) {                                                                                       // проверяем, если 0, значит просто рассчитываем индексацию для всех отделов
                        min = employee.getSalary();
                        minSalaryEmployee = employee;
                    } else {                                                                                                // иначе рассчитываем индексацию только для указанного отдела
                        if (state == employee.getState() && employee.getSalary() < min) {
                            min = employee.getSalary();
                            minSalaryEmployee = employee;
                        }
                    }
                }
                employees[i].setSalary(min);
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

        // Найти сотрудника с наибольшей зарплатой
        public void findMaxSalary ( int state){
            double max = 0;
            Employee maxSalaryEmployee = new Employee("", 0, 0, 0);
            for (int i = 0; i < employees.length; i++) {                                                                    // по циклу начинаем индексацию отдела
                Employee employee = employees[i];                                                                           // задаем временную переменную
                if (employees[i] == null) {                                                                                 // проверяем не пустой ли массив на этой итерации
                    continue;                                                                                               // если да, просто переходим к следующей итерации
                } else {                                                                                                    // если нет
                    if (state == 0 && employee.getSalary() > max) {                                                                                       // проверяем, если 0, значит просто рассчитываем индексацию для всех отделов
                        max = employee.getSalary();
                        maxSalaryEmployee = employee;
                    } else {                                                                                                // иначе рассчитываем индексацию только для указанного отдела
                        if (state == employee.getState() && employee.getSalary() > max) {
                            max = employee.getSalary();
                            maxSalaryEmployee = employee;
                        }
                    }
                }
                employees[i].setSalary(max);
            }

//        for (int i = 0; i < employees.length; i++) {
//            Employee employee = employees[i];
//            if (employees[i] != null && employee.getSalary() > max) {
//                max = employee.getSalary();
//                maxSalaryEmployee = employee;
//            } else continue;
//        }
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

        // индексирование зарплаты сотрудникам на указанный процент в зависимости от отдела
        public void indexSalary ( int percent, int state){
            for (int i = 0; i < employees.length; i++) {                                                                    // по циклу начинаем индексацию отдела
                Employee employee = employees[i];                                                                           // задаем временную переменную
                if (employees[i] == null) {                                                                                 // проверяем не пустой ли массив на этой итерации
                    continue;                                                                                               // если да, просто переходим к следующей итерации
                } else {                                                                                                    // если нет
                    if (state == 0) {                                                                                       // проверяем, если 0, значит просто рассчитываем индексацию для всех отделов
                        double index = 0;
                        index = employee.getSalary() + (employee.getSalary() * percent / 100);
                        employees[i].setSalary(index);
                    } else {                                                                                                // иначе рассчитываем индексацию только для указанного отдела
                        if (state == employee.getState()) {
                            double index = 0;
                            index = employee.getSalary() + (employee.getSalary() * percent / 100);
                            employees[i].setSalary(index);
                        }
                    }
                }
            }
            System.out.println("Произведена индексация зарплат на " + percent + "% всем сотрудникам отдела №" + state);     // пишем отчет о проделанной работе
            System.out.println();
        }

        // Распечатка только имён всех сотрудников
        public void printNamesOfAllEmployees () {
            System.out.println("Имена сотрудников:");
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println(employee.getName() + ". ");
                } else continue;
            }
            System.out.println();
        }

        public void findMoreOrLessSalary ( double digit){
            Employee[] lessSalary = new Employee[employees.length];                                                         // создаем два временных массива для сортировки
            Employee[] moreSalary = new Employee[employees.length];
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    continue;
                } else {
                    if (employees[i].getSalary() < digit) {                                                                 // если зарплата ниже, чем указанное число
                        lessSalary[i] = employees[i];                                                                       // записываем данные в массив с низкими зарплатами
                    } else {                                                                                                // иначе
                        moreSalary[i] = employees[i];                                                                       // записываем данные в массив с высокими зарплатами
                    }
                }
            }
            System.out.println("Получено число: " + digit);
            System.out.println();
            System.out.println("Сотрудники с зарплатой ниже указанного числа:");
            for (int i = 0; i < lessSalary.length; i++) {                                                                   // через цикл выводим данные людей с зарплатой ниже указанного числа
                if (lessSalary[i] == null) {                                                                                // не забывая пропускать пустые ячейки
                    continue;
                } else {
                    System.out.println("id№" + lessSalary[i].getId() +
                            ". " + lessSalary[i].getName() +
                            ". Зарплата: " + String.format("%.02f", lessSalary[i].getSalary()));
                }
            }
            System.out.println();
            System.out.println("Сотрудники с зарплатой равной, либо выше указанного числа:");
            for (int i = 0; i < moreSalary.length; i++) {                                                                   // то же самое проделываем для людей с зарплатой равной или выше указанного числа
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

        public int getIdTemp () {
            return idTemp;
        }
    }