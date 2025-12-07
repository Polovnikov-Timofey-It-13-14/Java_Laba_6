package model;

import annotations.ToString;

/**
 * Класс, представляющий сотрудника.
 * <p>Содержит информацию об имени сотрудника и компании, в которой он работает.
 *
 * @see annotations.ToString
 * @see annotations.ToString.Mode
 */
@ToString
public class Employee {

    /** Имя сотрудника. Всегда включается в строковое представление. */
    @ToString(ToString.Mode.YES)
    private String name;

    /** Компания, в которой работает сотрудник. Исключается из строкового представления. */
    @ToString(ToString.Mode.NO)
    private String company;

    /**
     * Создает сотрудника с именем "null" и компанией "null".
     */
    public Employee() {
        this.name = "null";
        this.company = "null";
    }

    /**
     * Создает сотрудника с указанными именем и компанией.
     *
     * @param name имя сотрудника
     * @param company компания сотрудника
     */
    public Employee(String name, String company) {
        this.name = name;
        this.company = company;
    }

    /**
     * Возвращает имя сотрудника.
     *
     * @return имя сотрудника
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает компанию сотрудника.
     *
     * @return компанию сотрудника
     */
    public String getCompany() {
        return company;
    }

    /**
     * Возвращает строковое представление сотрудника.
     * <p>Включает оба поля, независимо от аннотаций {@code @ToString}.</p>
     *
     * @return строку в формате "Employee{name='[имя]', company='[компания]'}"
     */
    @Override
    public String toString() {
        return "Employee{name='" + name + "', company='" + company + "'}";
    }
}
