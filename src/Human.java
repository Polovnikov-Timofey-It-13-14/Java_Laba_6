package model;

import annotations.Invoke;

/**
 * Класс, представляющий человека.
 * <p>Содержит информацию об имени и возрасте человека.</p>
 *
 * <p>Методы, помеченные аннотацией {@code @Invoke}:
 * <ul>
 *   <li>{@link #sayHello()} - приветствие</li>
 *   <li>{@link #introduce(String)} - представление с указанием настроения</li>
 *   <li>{@link #checkAdult()} - проверка совершеннолетия</li>
 *   <li>{@link #celebrateBirthday()} - празднование дня рождения</li>
 * </ul>
 * </p>
 *
 * @see annotations.Invoke
 */
public class Human {

    /** Имя человека. Не может быть пустым. */
    private String name;

    /** Возраст человека. Не может быть отрицательным. */
    private int age;

    /**
     * Создает человека с именем "null" и возрастом 0.
     */
    public Human() {
        this.name = "null";
        this.age = 0;
    }

    /**
     * Создает человека с указанными именем и возрастом.
     *
     * @param name имя человека
     * @param age возраст человека
     * @throws IllegalArgumentException если имя пустое или возраст отрицательный
     */
    public Human(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.name = name;
        this.age = age;
    }

    /**
     * Возвращает имя человека.
     *
     * @return имя человека
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя человека.
     *
     * @param name имя для установки
     * @throws IllegalArgumentException если имя {@code null} или пустое
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    /**
     * Возвращает возраст человека.
     *
     * @return возраст человека
     */
    public int getAge() {
        return age;
    }

    /**
     * Устанавливает возраст человека.
     *
     * @param age возраст для установки
     * @throws IllegalArgumentException если возраст отрицательный
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.age = age;
    }

    /**
     * Выводит приветственное сообщение.
     * <p>Метод помечен аннотацией {@link annotations.Invoke} для автоматического вызова.</p>
     *
     */
    @Invoke
    public void sayHello() {
        System.out.println(name + " говорит: Привет! Мне " + age + " лет.");
    }

    /**
     * Представляется с указанием настроения.
     * <p>Метод помечен аннотацией {@link annotations.Invoke} для автоматического вызова.</p>
     *
     * @param mood текущее настроение человека
     * @return строку с представлением и настроением
     *
     */
    @Invoke
    public String introduce(String mood) {
        String introduction = "Меня зовут " + name + ", мне " + age + " лет. Настроение: " + mood;
        System.out.println(introduction);
        return introduction;
    }

    /**
     * Проверяет, является ли человек совершеннолетним.
     * <p>Метод помечен аннотацией {@link annotations.Invoke} для автоматического вызова.</p>
     *
     */
    @Invoke
    public void checkAdult() {
        if (age >= 18) {
            System.out.println(name + " совершеннолетний(яя)");
        } else {
            System.out.println(name + " несовершеннолетний(яя)");
        }
    }

    /**
     * Отмечает день рождения человека (увеличивает возраст на 1).
     * <p>Метод помечен аннотацией {@link annotations.Invoke} для автоматического вызова.</p>
     */
    @Invoke
    public void celebrateBirthday() {
        age++;
        System.out.println("С днем рождения, " + name + "! Теперь тебе " + age + " лет.");
    }

    /**
     * Возвращает строковое представление человека.
     *
     * @return строку в формате "Person{name='[имя]', age=[возраст]}"
     */
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
