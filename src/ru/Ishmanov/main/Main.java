package ru.Ishmanov.main;

import ru.Ishmanov.animals.Bird;
import ru.Ishmanov.geometry.Point;
import ru.Ishmanov.geometry.Point2;
import ru.Ishmanov.math.PowerCalculator;
import ru.Ishmanov.others.Imena;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Выберите опцию:");
            System.out.println("1 - Создать имя");
            System.out.println("2 - Создать точку");
            System.out.println("3 - Создать птицу");
            System.out.println("4 - Создать кота и мяукать");
            System.out.println("5 - Создать точку 2 и проверить равенство");
            System.out.println("6 - Возведение числа в степень");
            System.out.println("7 - Возвращает клон объекта класса point 2");
            System.out.println("0 - Выйти");
            System.out.print("Ваш выбор: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера

                switch (choice) {
                    case 1:
                        createName(scanner);
                        break;
                    case 2:
                        createPoint(scanner);
                        break;
                    case 3:
                        createBird(scanner);
                        break;
                    case 4:
                        createCatsAndMeow(scanner);
                        break;
                    case 5:
                        createPoint2AndCompare(scanner);
                        break;
                    case 6:
                        calculatePowerFromInput(scanner);
                        break;
                    case 7:
                        clonePoint(scanner);
                        break;
                    case 0:
                        exit = true;
                        break;
                    default:
                        System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
                }
            } else {
                System.out.println("Неверный ввод. Введите число.");
                scanner.nextLine(); // Очистка буфера
            }
        }
        System.out.println("Программа завершена.");
        scanner.close();
    }

    private static void createName(Scanner scanner) {
        System.out.print("Введите личное имя (или оставьте пустым): ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Введите отчество (или оставьте пустым): ");
        String middleName = scanner.nextLine().trim();

        System.out.print("Введите фамилию (или оставьте пустым): ");
        String lastName = scanner.nextLine().trim();

        try {
            Imena name = new Imena(firstName, middleName, lastName);
            System.out.println("Созданное имя: " + name);

            // Демонстрация неизменяемости
            System.out.println("Ошибка: Имя неизменяемо и не может быть изменено.");
            System.out.println("Имя после попытки изменения: " + name);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void createPoint(Scanner scanner) {
        int dimensionChoice = 0;
        boolean validInput = false;

        // Запрос размерности точки
        while (!validInput) {
            System.out.println("Выберите размерность точки:");
            System.out.println("1 - 2D точка");
            System.out.println("2 - 3D точка");
            System.out.print("Ваш выбор: ");

            if (scanner.hasNextInt()) {
                dimensionChoice = scanner.nextInt();
                scanner.nextLine(); // Очистка буфера
                if (dimensionChoice == 1 || dimensionChoice == 2) {
                    validInput = true;
                } else {
                    System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
                }
            } else {
                System.out.println("Неверный ввод. Введите число.");
                scanner.nextLine(); // Очистка буфера
            }
        }

        // Запрос координат
        double x, y, z;
        try {
            System.out.print("Введите координату X: ");
            x = Double.parseDouble(scanner.nextLine());
            System.out.print("Введите координату Y: ");
            y = Double.parseDouble(scanner.nextLine());

            if (dimensionChoice == 2) {
                System.out.print("Введите координату Z: ");
                z = Double.parseDouble(scanner.nextLine());
                Point point3D = new Point(x, y, z);
                System.out.println("Создана 3D точка: " + point3D.getRepresentation());
            } else {
                Point point2D = new Point(x, y);
                System.out.println("Создана 2D точка: " + point2D.getRepresentation());
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Введите действительное число для координат.");
        }
    }

    private static void createBird(Scanner scanner) {
        System.out.println("Выберите вид птицы:");
        System.out.println("1 - Воробей");
        System.out.println("2 - Кукушка");
        System.out.println("3 - Попугай");
        System.out.print("Ваш выбор: ");

        if (scanner.hasNextInt()) {
            int birdChoice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера

            Bird bird;

            switch (birdChoice) {
                case 1:
                    bird = new Bird("Воробей"); // Создаем воробья
                    break;
                case 2:
                    bird = new Bird("Кукушка"); // Создаем кукушку
                    break;
                case 3:
                    System.out.print("Введите текст для попугая: ");
                    String text = scanner.nextLine();
                    bird = new Bird("Попугай", text); // Создаем попугая с указанным текстом
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова.");
                    return;
            }

            // Пение птицы
            bird.sing();
        } else {
            System.out.println("Неверный ввод. Введите число.");
            scanner.nextLine(); // Очистка буфера
        }
    }

    // Метод для мяуканья всех объектов, которые реализуют интерфейс ru.Ishmanov.main.ru.Ishmanov.main.Meowable
    private static void meowAll(Meowable[] meowables) {
        // Проходим по каждому объекту в массиве
        for (Meowable meowable : meowables) {
            meowable.meow(); // Вызываем метод meow() для каждого объекта
        }
    }

    private static void createCatsAndMeow(Scanner scanner) {
        int numberOfCats = 0; // Переменная для хранения количества котов
        boolean vaalidInput = false; // Флаг для проверки корректности ввода

        // Цикл до тех пор, пока пользователь не введет корректное число
        while (!vaalidInput) {
            System.out.print("Введите количество котов: ");
            if (scanner.hasNextInt()) { // Проверка, является ли ввод целым числом
                numberOfCats = scanner.nextInt(); // Чтение количества котов
                if (numberOfCats > 0) { // Проверка на положительность
                    vaalidInput = true; // Ввод корректен, выходим из цикла
                } else {
                    System.out.println("Введите положительное число!"); // Сообщение об ошибке
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число."); // Сообщение об ошибке
                scanner.nextLine(); // Очистка буфера
            }
        }
        scanner.nextLine(); // Очистка буфера

        // Создание массива, в который будут добавлены коты и фейк кот
        Meowable[] meowables = new Meowable[numberOfCats + 1]; // +1 для ru.Ishmanov.main.ru.Ishmanov.main.FakeCat

        // Цикл для создания котов
        for (int i = 0; i < numberOfCats; i++) {
            System.out.print("Введите имя кота #" + (i + 1) + ": ");
            String catName = scanner.nextLine();
            meowables[i] = new Cat(catName); // Создаем кота и добавляем в массив
        }

        // Запрос имени для фейк кота
        System.out.print("Введите имя фейк кота: ");
        String fakeCatName = scanner.nextLine();
        meowables[numberOfCats] = new FakeCat(fakeCatName); // Добавляем ru.Ishmanov.main.ru.Ishmanov.main.FakeCat в массив

        // Вызов метода мяуканья для всех котов и фейк котов
        meowAll(meowables);

        // Запрос количества мяуканий с проверкой на положительность и правильный ввод
        int meowCount = 0; // Переменная для хранения количества мяуканий
        boolean validInput = false; // Флаг для проверки корректности ввода

        while (!validInput) {
            System.out.print("Сколько раз каждый кот должен мяукать? ");
            if (scanner.hasNextInt()) { // Проверка, является ли ввод целым числом
                meowCount = scanner.nextInt(); // Чтение количества мяуканий
                if (meowCount > 0) { // Проверка на положительность
                    validInput = true; // Ввод корректен, выходим из цикла
                } else {
                    System.out.println("Введите положительное число!"); // Сообщение об ошибке
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число."); // Сообщение об ошибке
                scanner.nextLine(); // Очистка буфера
            }
        }

        // Цикл для мяуканья каждого кота заданное количество раз
        for (Meowable meowable : meowables) {
            if (meowable instanceof Cat) { // Проверка, является ли объект котом
                ((Cat) meowable).meow(meowCount); // Вызываем мяуканье заданное количество раз для кота
            } else if (meowable instanceof FakeCat) { // Проверка, является ли объект фейк котом
                ((FakeCat) meowable).meow(meowCount); // Вызываем мяуканье заданное количество раз для фейк кота
            }
        }
    }

    private static double getCoordinate(Scanner scanner, String axis) {
        double value = 0; // Переменная для хранения введенного значения координаты
        boolean validInput = false; // Флаг для проверки корректности ввода

        // Цикл для ввода координаты
        while (!validInput) {
            System.out.print("Введите координату " + axis + ": "); // Запрос на ввод координаты
            if (scanner.hasNextDouble()) { // Проверяем, является ли ввод числом
                value = scanner.nextDouble(); // Считываем значение координаты
                validInput = true; // Ввод корректен, выходим из цикла
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число."); // Сообщение об ошибке
                scanner.nextLine(); // Очистка буфера ввода для следующей попытки
            }
        }

        return value; // Возвращаем введенное значение координаты
    }

    private static void createPoint2AndCompare(Scanner scanner) {
        // Запрос на выбор типа точки (2D или 3D)
        System.out.println("Выберите тип точки:");
        System.out.println("1 - 2D точка");
        System.out.println("2 - 3D точка");
        int pointType = 0;

        // Проверка корректности ввода типа точки
        while (pointType != 1 && pointType != 2) {
            System.out.print("Введите 1 или 2: ");
            if (scanner.hasNextInt()) {
                pointType = scanner.nextInt();
                if (pointType != 1 && pointType != 2) {
                    System.out.println("Некорректный ввод. Пожалуйста, выберите 1 или 2.");
                }
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
                scanner.next(); // Очистка буфера
            }
        }

        // Получение координат X и Y для точки 1
        double x1 = getCoordinate(scanner, "X для точки 1"); // Запрашиваем координату X для первой точки
        double y1 = getCoordinate(scanner, "Y для точки 1"); // Запрашиваем координату Y для первой точки

        Point2 point1; // Объявляем переменную для первой точки
        if (pointType == 1) {
            point1 = new Point2(x1, y1); // Создаем 2D точку
        } else {
            Double z1 = getZCoordinate(scanner, "Z для точки 1"); // Получаем координату Z для 3D точки
            point1 = new Point2(x1, y1, z1); // Создаем 3D точку
        }

        // Получение координат X и Y для точки 2
        double x2 = getCoordinate(scanner, "X для точки 2"); // Запрашиваем координату X для второй точки
        double y2 = getCoordinate(scanner, "Y для точки 2"); // Запрашиваем координату Y для второй точки

        Point2 point2; // Объявляем переменную для второй точки
        if (pointType == 1) {
            point2 = new Point2(x2, y2); // Создаем 2D точку
        } else {
            Double z2 = getZCoordinate(scanner, "Z для точки 2"); // Получаем координату Z для 3D точки
            point2 = new Point2(x2, y2, z2); // Создаем 3D точку
        }

        // Сравнение точек
        if (point1.equals(point2)) { // Используем переопределенный метод equals для сравнения точек
            System.out.println("Точки равны: " + point1 + " и " + point2); // Если точки равны, выводим сообщение
        } else {
            System.out.println("Точки не равны: " + point1 + " и " + point2); // Если точки не равны, выводим сообщение
        }
    }

    private static Double getZCoordinate(Scanner scanner, String axis) {
        Double z = null; // Инициализация координаты Z как null
        boolean validInput = false; // Флаг для проверки корректности ввода

        // Цикл для ввода координаты Z
        while (!validInput) {
            System.out.print("Введите координату " + axis + ": ");
            if (scanner.hasNextDouble()) { // Проверяем, является ли ввод числом
                z = scanner.nextDouble(); // Считываем значение Z
                if (z == -1) { // Проверяем, введено ли -1
                    z = null; // Если да, присваиваем null, чтобы обозначить отсутствие Z
                }
                validInput = true; // Ввод корректен
            } else {
                System.out.println("Некорректный ввод. Пожалуйста, введите число."); // Сообщение об ошибке
                scanner.nextLine(); // Очистка буфера ввода
            }
        }
        return z; // Возвращаем координату Z
    }

    private static void calculatePowerFromInput(Scanner scanner) {
        System.out.print("Введите основание (X): ");
        String xStr = scanner.nextLine().replace(",", ".");
        System.out.print("Введите показатель степени (Y): ");
        String yStr = scanner.nextLine().replace(",", ".");
        try {
            double result = PowerCalculator.power(xStr, yStr);
            System.out.println("Результат: " + result);
        } catch (NumberFormatException e) {
            // Обрабатываем случай, если пользователь ввел некорректные числовые значения
            System.out.println("Ошибка: Введите корректные числовые значения.");
        } catch (ArithmeticException e) {
            // Обрабатываем возможные арифметические ошибки (например, деление на ноль)
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void clonePoint(Scanner scanner) {
        double x = 0; // Инициализируем переменную для X
        double y = 0; // Инициализируем переменную для Y
        Double z; // Инициализируем Z как null
        boolean validInput = false; // Флаг для проверки корректности ввода

        // Цикл для ввода координаты X с проверкой на корректность
        while (!validInput) {
            System.out.print("Введите координату X: ");
            if (scanner.hasNextDouble()) {
                x = scanner.nextDouble(); // Читаем координату X
                validInput = true; // Ввод корректен
            } else {
                System.out.println("Ошибка: Пожалуйста, введите действительное число для X."); // Сообщение об ошибке
                scanner.next(); // Очистка буфера
            }
        }

        // Сбрасываем флаг для ввода координаты Y
        validInput = false; // Сбрасываем флаг

        // Цикл для ввода координаты Y с проверкой на корректность
        while (!validInput) {
            System.out.print("Введите координату Y: ");
            if (scanner.hasNextDouble()) {
                y = scanner.nextDouble(); // Читаем координату Y
                validInput = true; // Ввод корректен
            } else {
                System.out.println("Ошибка: Пожалуйста, введите действительное число для Y."); // Сообщение об ошибке
                scanner.next(); // Очистка буфера
            }
        }

        // Чтение и преобразование координаты Z
        System.out.print("Введите координату Z (или введите null для отсутствия): ");
        String zInput = scanner.next(); // Читаем ввод Z

        // Если введено "null", устанавливаем z как null, иначе преобразуем ввод в Double
        if (zInput.equalsIgnoreCase("null")) {
            z = null; // Устанавливаем Z как null
        } else {
            try {
                z = Double.parseDouble(zInput); // Преобразуем ввод в Double
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Пожалуйста, введите действительное число для Z."); // Сообщение об ошибке
                return; // Завершаем метод при ошибке
            }
        }

        // Создаем оригинальную точку
        Point2 originalPoint = new Point2(x, y, z);
        System.out.println("Оригинальная точка: " + originalPoint);
        try {
            // Клонируем оригинальную точку
            Point2 clonedPoint = originalPoint.clone();
            System.out.println("Клонированная точка: " + clonedPoint); // Выводим клонированную точку
        } catch (CloneNotSupportedException e) {
            System.out.println("Ошибка клонирования: " + e.getMessage()); // Обработка ошибки клонирования
        }
    }

}