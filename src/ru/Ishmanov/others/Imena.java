package ru.Ishmanov.others;

public final class Imena {
    // Поля класса для хранения имени, отчества и фамилии.
    private final String firstName;
    private final String middleName;
    private final String lastName;

    // Конструктор класса, принимающий имя, отчество и фамилию.
    public Imena(String firstName, String middleName, String lastName) {
        // Проверка на наличие хотя бы одного непустого параметра.
        // Если все параметры пустые или null, выбрасывается исключение.
        if ((firstName == null || firstName.isEmpty()) &&
                (middleName == null || middleName.isEmpty()) &&
                (lastName == null || lastName.isEmpty())) {
            throw new IllegalArgumentException("Хотя бы одно поле должно быть заполнено.");
        }
        // Проверка, что все параметры содержат только буквы.
        // Если строка содержит не буквенные символы, выбрасывается исключение.
        if (!isAlphabetic(firstName) || !isAlphabetic(middleName) || !isAlphabetic(lastName)) {
            throw new IllegalArgumentException("Имя, отчество и фамилия могут содержать только буквы.");
        }

        // Инициализация полей. Если параметр пустой, он сохраняется как null.
        this.firstName = firstName.isEmpty() ? null : firstName;
        this.middleName = middleName.isEmpty() ? null : middleName;
        this.lastName = lastName.isEmpty() ? null : lastName;
    }

    // Приватный метод, который проверяет, что строка состоит только из букв.
    // Принимает строку str и возвращает true, если строка содержит только буквы или равна null.
    private boolean isAlphabetic(String str) {
        return str == null || str.matches("[a-zA-Zа-яА-Я]*");
    }

    // Переопределенный метод toString() для удобного строкового представления объекта.
    // Если поле не равно null, оно добавляется в итоговую строку через пробел.
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (firstName != null) result.append(firstName).append(" ");
        if (middleName != null) result.append(middleName).append(" ");
        if (lastName != null) result.append(lastName);
        return result.toString().trim();
    }
}

/*
Примечания:
- Все поля (firstName, middleName, lastName) объявлены как final, что запрещает их изменение после инициализации в конструкторе.
- Поля firstName, middleName и lastName являются private, поэтому к ним нет прямого доступа из других классов.
- Не предоставляются сеттеры для изменения значений полей после создания объекта, что делает объект неизменяемым.
*/
