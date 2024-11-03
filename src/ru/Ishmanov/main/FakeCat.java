package ru.Ishmanov.main;

// Класс ru.Ishmanov.main.ru.Ishmanov.main.FakeCat реализует интерфейс ru.Ishmanov.main.ru.Ishmanov.main.Meowable и представляет собой "фейкового" кота
public class FakeCat implements Meowable {
    private final String name; // Имя фейк кота

    // Конструктор для создания фейк кота с заданным именем
    public FakeCat(String name) {
        this.name = name; // Инициализация имени фейк кота
    }

    // Реализация метода meow() из интерфейса ru.Ishmanov.main.ru.Ishmanov.main.Meowable
    @Override
    public void meow() {
        System.out.println(name + ": мияу!");
    }

    // Перегрузка метода meow для указанного количества мяуканий
    public void meow(int times) {
        StringBuilder meowSound = new StringBuilder(name + ": "); // Создаем строку для мяуканья
        for (int i = 0; i < times; i++) { // Цикл для добавления мяуканий
            meowSound.append("мяу"); // Добавляем звук мяуканья
            if (i < times - 1) { // Если это не последнее мяуканье
                meowSound.append("-"); // Добавляем разделитель между мяуканьями
            }
        }
        // Выводим всю строку с мяуканьем
        System.out.println(meowSound.toString() + "!");
    }

    // Переопределяем метод toString для вывода информации о фейк коте
    @Override
    public String toString() {
        return "фейк кот: " + name; // Возвращаем строку с именем фейк кота
    }
}
