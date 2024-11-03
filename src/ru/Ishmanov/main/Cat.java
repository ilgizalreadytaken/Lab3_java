package ru.Ishmanov.main;

/**
 * Класс ru.Ishmanov.main.ru.Ishmanov.main.Cat представляет кота, который может мяукать.
 * Он реализует интерфейс ru.Ishmanov.main.ru.Ishmanov.main.Meowable, что гарантирует наличие
 * метода meow().
 */
public class Cat implements Meowable {
    // Имя кота
    private final String name;

    // Конструктор для создания кота с указанным именем
    public Cat(String name) {
        this.name = name;
    }

    // Реализация метода meow() из интерфейса ru.Ishmanov.main.ru.Ishmanov.main.Meowable
    @Override
    public void meow() {
        System.out.println(name + ": мяу!"); // Печатает мяуканье кота
    }

    // Метод для мяуканья несколько раз
    public void meow(int times) {
        StringBuilder meowSound = new StringBuilder(name + ": ");
        for (int i = 0; i < times; i++) {
            meowSound.append("мяу"); // Добавляем "мяу" к строке
            if (i < times - 1) {
                meowSound.append("-"); // Добавляем дефис между звуками
            }
        }
        System.out.println(meowSound.toString() + "!"); // Печатает мяуканье с количеством раз
    }

    // Переопределение метода toString() для удобного представления объекта
    @Override
    public String toString() {
        return "кот: " + name; // Возвращает строку с именем кота
    }
}