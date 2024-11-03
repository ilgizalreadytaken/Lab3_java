package ru.Ishmanov.animals;

import java.util.Random;

// Класс для представления птицы
public class Bird {
    private final String type; // Тип птицы
    private String text; // Текст для попугая (если применимо)
    private final Random random = new Random(); // Генератор случайных чисел

    // Конструктор для создания птицы
    public Bird(String type) {
        this.type = type; // Инициализация типа птицы
    }

    // Конструктор для создания попугая с текстом
    public Bird(String type, String text) {
        this.type = type; // Инициализация типа птицы
        this.text = text; // Инициализация текста для попугая
    }

    // Метод для пения
    public void sing() {
        switch (type) { // Проверяем тип птицы
            case "Воробей":
                System.out.println("чырык"); // Воробей поет "чырык"
                break;
            case "Кукушка":
                int times = random.nextInt(10) + 1; // Генерируем случайное число от 1 до 10
                for (int i = 0; i < times; i++) { // Цикл для повторения "ку-ку"
                    System.out.print("ку-ку "); // Кукушка поет "ку-ку"
                }
                System.out.println(); // Переход на новую строку после окончания пения
                break;
            case "Попугай":
                int n = random.nextInt(text.length()) + 1; // Генерируем случайное количество символов от 1 до длины текста
                System.out.println(text.substring(0, n)); // Попугай поет первые N символов текста
                break;
            default:
                System.out.println("Неизвестный тип птицы."); // Если тип птицы не распознан
        }
    }
}
