package model;

/**
 * Класс, представляющий студента.
 * <p>Содержит базовую информацию о студенте: имя и курс обучения.</p>
 *
 */
public class Student {

    /** Имя студента. */
    private String name;

    /** Курс обучения студента. */
    private int course;

    /**
     * Создает студента с именем "Неизвестно" и курсом 1.
     */
    public Student() {
        this.name = "Неизвестно";
        this.course = 1;
    }

    /**
     * Создает студента с указанными именем и курсом.
     *
     * @param name имя студента
     * @param course курс обучения
     */
    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    /**
     * Возвращает имя студента.
     *
     * @return имя студента
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает курс обучения студента.
     *
     * @return курс обучения
     */
    public int getCourse() {
        return course;
    }

    /**
     * Возвращает строковое представление студента.
     *
     * @return строку в формате "Student{name='[имя]', course=[курс]}"
     */
    @Override
    public String toString() {
        return "Student{name='" + name + "', course=" + course + "}";
    }
}
