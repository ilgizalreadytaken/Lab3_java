package ru.Ishmanov.geometry;

// Класс ru.Ishmanov.geometry.Point2 представляет точку в двумерном или трехмерном пространстве
public class Point2 implements Cloneable {
    private final double x; // Координата X
    private final double y; // Координата Y
    private final Double z; // Координата Z (может быть null для 3D точки)

    // Конструктор для создания 2D точки с заданными координатами X и Y
    public Point2(double x, double y) {
        this(x, y, null); // Устанавливаем Z как null для 2D точки
    }

    // Конструктор для создания 3D точки с заданными координатами X, Y и Z
    public Point2(double x, double y, Double z) {
        this.x = x; // Инициализация координаты X
        this.y = y; // Инициализация координаты Y
        this.z = z; // Инициализация координаты Z (может быть null)
    }

    // Переопределение метода equals для корректного сравнения объектов ru.Ishmanov.geometry.Point2
    @Override
    public boolean equals(Object obj) {
        // Проверяем, является ли ссылка на текущий объект такой же, как и объект, с которым сравниваем
        if (this == obj) return true; // Если ссылки на объекты совпадают, они равны

        // Проверяем, является ли переданный объект экземпляром класса ru.Ishmanov.geometry.Point2
        if (!(obj instanceof Point2)) return false; // Если нет, возвращаем false

        // Приводим объект к типу ru.Ishmanov.geometry.Point2
        Point2 other = (Point2) obj;

        // Сравниваем координаты X, Y и Z двух точек
        return Double.compare(this.x, other.x) == 0 && // Сравнение координаты X
                Double.compare(this.y, other.y) == 0 && // Сравнение координаты Y
                (this.z == null ? other.z == null : this.z.equals(other.z)); // Сравнение координаты Z
    }

    // Переопределение метода toString для текстового представления точки
    @Override
    public String toString() {
        // Форматируем строку, чтобы включить координаты X, Y и (если есть) Z
        return "{" + x + ";" + y + (z != null ? ";" + z : "") + "}"; // Возвращаем строковое представление
    }

    // Переопределение метода clone для клонирования объекта ru.Ishmanov.geometry.Point2
    @Override
    public Point2 clone() throws CloneNotSupportedException {
        // Вызываем метод clone() родительского класса и возвращаем новый объект ru.Ishmanov.geometry.Point2
        return (Point2) super.clone(); // Клонируем объект
    }
}


/*
Вызов метода суперкласса
super.clone(): Это ключевая часть метода. Когда вы вызываете super.clone(),
вы вызываете метод clone() из класса Object. Этот метод создает «мелкую копию» (shallow copy)
текущего объекта. Это означает, что:
Создается новый объект того же типа, что и текущий (в данном случае, ru.Ishmanov.geometry.Point2).
Копируются ссылки на все поля текущего объекта.

Приведение типов
return (ru.Ishmanov.geometry.Point2) super.clone();: Поскольку super.clone()
возвращает объект типа Object, мы должны привести его к типу ru.Ishmanov.geometry.Point2,
чтобы вернуть именно объект нашего класса. Это безопасно, поскольку мы знаем,
что super.clone() создаст объект типа ru.Ishmanov.geometry.Point2.
 */