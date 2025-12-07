package app;

import annotations.Default;
import handlers.*;
import model.*;
import service.Valid;
import java.util.Scanner;

/**
 * Главный класс приложения для демонстрации работы с аннотациями.
 * <p>Предоставляет интерактивное консольное меню для тестирования функциональности,
 * связанной с пользовательскими аннотациями:</p>
 *
 * <p>Меню приложения:
 * <ol>
 *   <li>Демонстрация и тестирование аннотации {@link annotations.Invoke}</li>
 *   <li>Демонстрация аннотации {@link annotations.Default}</li>
 *   <li>Демонстрация аннотации {@link annotations.ToString}</li>
 *   <li>Демонстрация аннотации {@link annotations.Validate}</li>
 *   <li>Демонстрация и тестирование аннотации {@link annotations.Two}</li>
 *   <li>Демонстрация аннотации {@link annotations.Cache}</li>
 *   <li>Выход из приложения</li>
 * </ol>
 * </p>
 *
 */
public class Main {

    /**
     * Главный метод приложения.
     * <p>Создает меню для демонстрации работы.</p>
     *
     * @see service.Valid
     * @see handlers.InvokeAnnotation
     * @see handlers.ToStringAnnotation
     * @see handlers.TwoAnnotation
     * @see handlers.CacheAnnotation
     * @see handlers.ValidateAnnotation
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Valid valid = new Valid();

        System.out.println("Привет, это 6 лаба по Java");
        String number;
        while (true) {
            System.out.println("Введи номер задания(1-8):");
            System.out.println("9 - Выход");
            number = scanner.nextLine();

            if (!valid.isNumber(number)) {
                System.out.println("Ошибка: введите число от 1 до 9");
                continue;
            }

            int TaskNum = Integer.parseInt(number);
            if (TaskNum < 1 || TaskNum > 9) {
                System.out.println("Вводимый номер должен быть от 1 до 9");
                continue;
            }

            switch (TaskNum) {
                case 1:
                    System.out.println("1 Задание");

                    String name;
                    while (true) {
                        System.out.print("Введите имя человека: ");
                        name = scanner.nextLine().trim();
                        if (!name.isEmpty()) {
                            break;
                        }
                        System.out.println("Ошибка: имя не может быть пустым!");
                    }

                    String ageInput;
                    int age = 0;
                    boolean validAge = false;
                    while (!validAge) {
                        System.out.print("Введите возраст человека: ");
                        ageInput = scanner.nextLine().trim();

                        if (!valid.isPositiveInteger(ageInput)) {
                            System.out.println("Ошибка: возраст должен быть положительным целым числом");
                            continue;
                        }

                        age = Integer.parseInt(ageInput);
                        if (age < 0) {
                            System.out.println("Ошибка: возраст не может быть отрицательным");
                            continue;
                        }
                        validAge = true;
                    }

                    try {
                        Human human = new Human(name, age);
                        InvokeAnnotation.invokeAnnotatedMethods(human);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка создания человека: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("2 Задание");
                    Class<?> classes = DefaultAnnotation.class;
                    if (classes.isAnnotationPresent(Default.class)) {
                        Default annotation = classes.getAnnotation(Default.class);
                        System.out.println("Класс " + classes.getSimpleName() +
                                " имеет @Default аннотацию");
                        System.out.println("Класс по умолчанию: " +
                                annotation.value().getName());
                        System.out.println("Простое имя: " +
                                annotation.value().getSimpleName());
                    }
                    break;

                case 3:
                    System.out.println("3 Задание");

                    System.out.print("Введите имя сотрудника: ");
                    String employeeName = scanner.nextLine().trim();

                    System.out.print("Введите название компании: ");
                    String company = scanner.nextLine().trim();

                    if (employeeName.isEmpty()) {
                        employeeName = "Неизвестный сотрудник";
                    }
                    if (company.isEmpty()) {
                        company = "Неизвестная компания";
                    }

                    Employee emp = new Employee(employeeName, company);

                    System.out.println("Стандартный toString(): " + emp.toString());
                    System.out.println("toString с @ToString: " + ToStringAnnotation.toString(emp));
                    break;

                case 4:
                    System.out.println("4 Задание");

                    ValidateAnnotation.processClass(User.class);

                    break;

                case 5:
                    System.out.println("5 Задание");

                    TwoAnnotation.processAnnotation(Car.class);

                    /*
                    Car car1 = new Car("Toyota", 2022);
                    System.out.println("Автомобиль 1: " + car1);
                    System.out.println("Новый: " + car1.isNew());

                    Car car2 = new Car();

                    String brand;
                    while (true) {
                        System.out.print("Введите марку: ");
                        brand = scanner.nextLine().trim();
                        if (!brand.isEmpty()) {
                            break;
                        }
                        System.out.println("Ошибка: марка не может быть пустой!");
                    }

                    String yearInput;
                    int year = 0;
                    boolean validYear = false;
                    while (!validYear) {
                        System.out.print("Введите год: ");
                        yearInput = scanner.nextLine().trim();

                        if (!valid.isInteger(yearInput)) {
                            System.out.println("Ошибка: год должен быть целым числом");
                            continue;
                        }

                        year = Integer.parseInt(yearInput);
                        try {
                            car2.setYear(year);
                            validYear = true;
                        } catch (IllegalArgumentException e) {
                            System.out.println("Ошибка: " + e.getMessage());
                        }
                    }

                    try {
                        car2.setBrand(brand);
                        System.out.println("Автомобиль 2: " + car2);
                        System.out.println("Новый: " + car2.isNew());
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                     */
                    break;

                case 6:
                    System.out.println("6 Задание");

                    CacheAnnotation.processCacheAnnotation(BankAccount.class);
                    /*
                    System.out.print("Введите номер счета: ");
                    String accountNumber = scanner.nextLine().trim();

                    if (accountNumber.isEmpty()) {
                        accountNumber = "1234567890";
                        System.out.println("Используется номер счета по умолчанию: " + accountNumber);
                    }

                    String balanceInput;
                    double initialBalance = 0;
                    boolean validBalance = false;

                    while (!validBalance) {
                        System.out.print("Введите начальный баланс: ");
                        balanceInput = scanner.nextLine().trim();

                        if (balanceInput.isEmpty()) {
                            initialBalance = 1000.0;
                            System.out.println("Используется баланс по умолчанию: " + initialBalance);
                            validBalance = true;
                        } else {
                            try {
                                initialBalance = Double.parseDouble(balanceInput);
                                if (initialBalance >= 0) {
                                    validBalance = true;
                                } else {
                                    System.out.println("Ошибка: баланс не может быть отрицательным");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введите корректное число для баланса");
                            }
                        }
                    }

                    BankAccount account = new BankAccount(accountNumber, initialBalance);
                    System.out.println("Создан: " + account);

                    String depositInput;
                    double depositAmount = 0;
                    boolean validDeposit = false;

                    while (!validDeposit) {
                        System.out.print("Введите сумму для пополнения: ");
                        depositInput = scanner.nextLine().trim();

                        if (depositInput.isEmpty()) {
                            depositAmount = 500.0;
                            System.out.println("Используется сумма по умолчанию: " + depositAmount);
                            validDeposit = true;
                        } else {
                            try {
                                depositAmount = Double.parseDouble(depositInput);
                                if (depositAmount > 0) {
                                    validDeposit = true;
                                } else {
                                    System.out.println("Ошибка: сумма пополнения должна быть положительной");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введите корректное число");
                            }
                        }
                    }

                    account.deposit(depositAmount);
                    System.out.println("После пополнения: " + account);

                    String withdrawInput;
                    double withdrawAmount = 0;
                    boolean validWithdraw = false;

                    while (!validWithdraw) {
                        System.out.print("Введите сумму для снятия: ");
                        withdrawInput = scanner.nextLine().trim();

                        if (withdrawInput.isEmpty()) {
                            withdrawAmount = 200.0;
                            System.out.println("Используется сумма по умолчанию: " + withdrawAmount);
                            validWithdraw = true;
                        } else {
                            try {
                                withdrawAmount = Double.parseDouble(withdrawInput);
                                if (withdrawAmount > 0 && withdrawAmount <= account.getBalance()) {
                                    validWithdraw = true;
                                } else if (withdrawAmount <= 0) {
                                    System.out.println("Ошибка: сумма снятия должна быть положительной");
                                } else {
                                    System.out.println("Ошибка: недостаточно средств на счете");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ошибка: введите корректное число");
                            }
                        }
                    }

                    account.withdraw(withdrawAmount);
                    System.out.println("После снятия: " + account);

                     */
                    break;

                case 7:
                    System.out.println("7 Задание");
                    System.out.println("Запусти 'InvokeAnnotationTest' для проверки JUnit тестов");
                    break;

                case 8:
                    System.out.println("8 Задание");
                    System.out.println("Запусти 'TwoAnnotationTest' для проверки JUnit тестов");
                    break;

                case 9:
                    System.out.println("Выход");
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
