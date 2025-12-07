package handlers;

import annotations.Default;
import model.Student;

/**
 * <p>Класс помечен аннотацией {@code @Default(Student.class)}, что указывает,
 * что {@link model.Student} является классом по умолчанию для данного типа.</p>
 *
 * @see annotations.Default
 * @see model.Student
 */
@Default(Student.class)
public class DefaultAnnotation {

    /** Факультет, к которому относится обработчик. */
    private String faculty;

    /**
     * Создает новый экземпляр {@code DefaultAnnotation} с факультетом
     * "Computer Science" по умолчанию.
     */
    public DefaultAnnotation() {
        this.faculty = "Computer Science";
    }

    /**
     * Возвращает название факультета, связанного с этим обработчиком.
     *
     * @return название факультета
     */
    public String getDepartment() {
        return faculty;
    }

    /**
     * Обрабатывает переданного студента, выводя информацию о нем
     * вместе с факультетом обработчика.
     *
     * <p>Выводит в консоль информацию о студенте</p>
     *
     * @param student студент для обработки
     * @throws NullPointerException если переданный студент равен {@code null}
     */
    public void processStudent(Student student) {
        System.out.println("Обработка студента: " + student.getName() +
                ", курс: " + student.getCourse() +
                ", факультет: " + faculty);
    }
}

