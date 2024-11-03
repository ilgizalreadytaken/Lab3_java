package ru.Ishmanov.main;

public interface Meowable {
    void meow();
}

/*
Интерфейс ru.Ishmanov.main.ru.Ishmanov.main.Meowable определяет соглашение для объектов, которые могут мяукать.
Любой класс, который реализует этот интерфейс, должен предоставить реализацию метода
meow(), что гарантирует, что все "мяукающие" объекты будут иметь этот метод.

Пример использования:
1. Класс ru.Ishmanov.main.ru.Ishmanov.main.Cat реализует интерфейс ru.Ishmanov.main.ru.Ishmanov.main.Meowable и предоставляет конкретную реализацию метода meow().
2. Класс ru.Ishmanov.main.ru.Ishmanov.main.FakeCat также реализует ru.Ishmanov.main.ru.Ishmanov.main.Meowable, но может иметь другую логику в методе meow().
3. Создание массива объектов типа ru.Ishmanov.main.ru.Ishmanov.main.Meowable позволяет вызывать метод meow() на любых объектах,
 реализующих этот интерфейс, независимо от их конкретного типа.
 */