package ru.Ishmanov.math;

public class PowerCalculator {
    public static double power(String xStr, String yStr) {
        double x = Double.parseDouble(xStr); // Преобразуем строку X в double
        double y = Double.parseDouble(yStr); // Преобразуем строку Y в double
        return Math.pow(x, y); // Возводим x в степень y
    }
}
